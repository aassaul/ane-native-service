/**
 * Created with IntelliJ IDEA.
 * User: Andrey Assaul
 * Date: 14.08.2015
 * Time: 17:06
 */
package com.trembit.nativeService {
	import com.trembit.nativeService.events.NativeServiceEvent;

	import flash.events.EventDispatcher;
	import flash.events.StatusEvent;
	import flash.external.ExtensionContext;
	import flash.net.URLRequest;

	public class NativeService extends EventDispatcher implements INativeService{

		private var extContext:ExtensionContext;

		public function NativeService() {
			extContext = ExtensionContext.createExtensionContext("com.trembit.extension.NativeService", null);
			extContext.addEventListener(StatusEvent.STATUS, onStatus);
		}

		public function callGet(request:URLRequest):String {
			var params:String = request.data.toString();
			var url:String = (params && params != "")?(request.url+"?"+params):request.url;
			return String(extContext.call("callGet", url));
		}

		public function dispose():void {
			extContext.dispose();
		}

		private function onStatus(event:StatusEvent):void {
			var uuid:String = event.level;
			switch(event.code){
				case "RequestFinished":
					dispatchEvent(new NativeServiceEvent(NativeServiceEvent.REQUEST_FINISHED, getResponse(uuid), uuid));
					break;
				case "RequestError":
					dispatchEvent(new NativeServiceEvent(NativeServiceEvent.REQUEST_ERROR, getError(uuid), uuid));
					break;
			}
		}

		private function getResponse(uuid:String):String {
			return String(extContext.call("getResponse", uuid));
		}

		private function getError(uuid:String):RequestError{
			return RequestError(extContext.call("getError", uuid));
		}
	}
}

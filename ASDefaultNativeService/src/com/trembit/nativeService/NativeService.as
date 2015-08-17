/**
 * Created with IntelliJ IDEA.
 * User: Andrey Assaul
 * Date: 14.08.2015
 * Time: 17:06
 */
package com.trembit.nativeService {

	import flash.events.EventDispatcher;
	import flash.net.URLRequest;

	[Event(type="com.trembit.nativeService.events.NativeServiceEvent", name="requestFinished")]
	[Event(type="com.trembit.nativeService.events.NativeServiceEvent", name="requestError")]
	public class NativeService extends EventDispatcher {


		public function callGet(request:URLRequest):String {
			return "";
		}

		public function dispose():void {

		}
	}
}

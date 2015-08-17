/**
 * Created with IntelliJ IDEA.
 * User: Andrey Assaul
 * Date: 14.08.2015
 * Time: 17:33
 */
package com.trembit.nativeService.events {
	import flash.events.Event;

	public class NativeServiceEvent extends Event {

		public static const REQUEST_FINISHED:String = "requestFinished";
		public static const REQUEST_ERROR:String = "requestError";

		private var _data:*;
		private var _uuid:String;

		public function get data():*{
			return _data;
		}

		public function get uuid():String{
			return _uuid;
		}

		public function NativeServiceEvent(eventType:String, data:*, uuid:String) {
			super(eventType, false, false);
			_data = data;
			_uuid = uuid;
		}

		override public function clone():Event {
			return new NativeServiceEvent(type, data, uuid);
		}
	}
}

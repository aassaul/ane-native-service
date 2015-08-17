/**
 * Created with IntelliJ IDEA.
 * User: Andrey Assaul
 * Date: 16.08.2015
 * Time: 17:39
 */
package com.trembit.nativeService {
	public class RequestError {

		private var _code:int;
		private var _message:String;

		public function RequestError(code:int, message:String) {
			this._code = code;
			this._message = message;
		}

		public function get code():int {
			return _code;
		}

		public function get message():String {
			return _message;
		}
	}
}

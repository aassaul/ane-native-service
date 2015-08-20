/**
 * Created with IntelliJ IDEA.
 * User: Andrey Assaul
 * Date: 14.08.2015
 * Time: 17:06
 */
package com.trembit.nativeService {

	import flash.events.IEventDispatcher;
	import flash.net.URLRequest;

	[Event(type="com.trembit.nativeService.events.NativeServiceEvent", name="requestFinished")]
	[Event(type="com.trembit.nativeService.events.NativeServiceEvent", name="requestError")]
	public interface INativeService extends IEventDispatcher {
		function callGet(request:URLRequest):String;
		function dispose():void;
	}
}

package com.trembit.nativeService.api;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.trembit.nativeService.api.functions.NativeServiceCallGetFREFunction;
import com.trembit.nativeService.api.functions.NativeServiceErrorMapFREFunction;
import com.trembit.nativeService.api.functions.NativeServiceResponseMapFREFunction;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Andrey Assaul
 * Date: 14.08.2015
 * Time: 15:51
 */
public class NativeServiceFREContext extends FREContext {

    private static Map<String, FREFunction> functionMap;

    @Override
    public Map<String, FREFunction> getFunctions() {
        if(functionMap == null){
            functionMap = new HashMap<String, FREFunction>();
            functionMap.put("callGet", new NativeServiceCallGetFREFunction());
            functionMap.put("getResponse", new NativeServiceResponseMapFREFunction());
            functionMap.put("getError", new NativeServiceErrorMapFREFunction());
        }
        return functionMap;
    }

    @Override
    public void dispose() {

    }
}

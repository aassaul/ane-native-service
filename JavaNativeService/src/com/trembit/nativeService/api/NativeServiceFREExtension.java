package com.trembit.nativeService.api;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREExtension;

/**
 * Created with IntelliJ IDEA.
 * User: Andrey Assaul
 * Date: 14.08.2015
 * Time: 16:00
 */
public class NativeServiceFREExtension implements FREExtension {

    private static NativeServiceFREContext context;

    @Override
    public FREContext createContext(String s) {
        if(context == null){
            context = new NativeServiceFREContext();
        }
        return context;
    }

    @Override
    public void dispose() {}

    @Override
    public void initialize() {}
}

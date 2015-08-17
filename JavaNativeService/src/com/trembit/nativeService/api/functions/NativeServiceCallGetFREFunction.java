package com.trembit.nativeService.api.functions;

import android.os.AsyncTask;
import android.util.Log;
import com.adobe.fre.*;
import com.trembit.nativeService.base.BaseMethod;

import java.util.UUID;

/**
 * Created with IntelliJ IDEA.
 * User: Andrey Assaul
 * Date: 14.08.2015
 * Time: 16:10
 */
public class NativeServiceCallGetFREFunction implements FREFunction {
    @Override
    public FREObject call(FREContext freContext, FREObject[] freObjects) {
        String uuid = UUID.randomUUID().toString();
        try {
            String url = freObjects[0].getAsString();
            getGetMoviesTask(freContext, uuid).execute(url);
            return FREObject.newObject(uuid);
        } catch (FRETypeMismatchException e) {
            e.printStackTrace();
        } catch (FREInvalidObjectException e) {
            e.printStackTrace();
        } catch (FREWrongThreadException e) {
            e.printStackTrace();
        }
        return null;
    }

    private AsyncTask<String, Void, BaseMethod> getGetMoviesTask(final FREContext context, final String uuid) {
        return new AsyncTask<String, Void, BaseMethod>() {
            @Override
            protected BaseMethod doInBackground(String... params) {
                BaseMethod method = new BaseMethod();
                method.sendGET(params[0]);
                return method;
            }

            @Override
            protected void onPostExecute(BaseMethod method) {
                String result = method.getResult();
                if(result != null){
                    NativeServiceResponseMapFREFunction.put(result, uuid);
                    context.dispatchStatusEventAsync("RequestFinished", uuid);
                }else{
                    NativeServiceErrorMapFREFunction.put(method.getError(), uuid);
                    context.dispatchStatusEventAsync("RequestError", uuid);
                }
            }
        };
    }
}

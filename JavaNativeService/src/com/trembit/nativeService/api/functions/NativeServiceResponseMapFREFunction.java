package com.trembit.nativeService.api.functions;

import android.util.Log;
import com.adobe.fre.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Andrey Assaul
 * Date: 14.08.2015
 * Time: 16:58
 */
public class NativeServiceResponseMapFREFunction implements FREFunction {
    private static Map<String, String> map = new HashMap<String, String>();
    public static void put(String response, String uuid){
        map.put(uuid, response);
    }

    @Override
    public FREObject call(FREContext freContext, FREObject[] freObjects) {
        try {
            String uuid = freObjects[0].getAsString();
            FREObject result = FREObject.newObject(map.get(uuid));
            map.remove(uuid);
            return result;
        } catch (FREWrongThreadException e) {
            e.printStackTrace();
        } catch (FRETypeMismatchException e) {
            e.printStackTrace();
        } catch (FREInvalidObjectException e) {
            e.printStackTrace();
        }
        return null;
    }
}

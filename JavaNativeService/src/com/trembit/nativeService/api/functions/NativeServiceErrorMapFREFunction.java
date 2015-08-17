package com.trembit.nativeService.api.functions;

import com.adobe.fre.*;
import com.trembit.nativeService.base.RequestError;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Andrey Assaul
 * Date: 14.08.2015
 * Time: 16:58
 */
public class NativeServiceErrorMapFREFunction implements FREFunction {
    private static Map<String, RequestError> map = new HashMap<String, RequestError>();
    public static void put(RequestError response, String uuid){
        map.put(uuid, response);
    }

    @Override
    public FREObject call(FREContext freContext, FREObject[] freObjects) {
        try {
            String uuid = freObjects[0].getAsString();
            FREObject result = map.get(uuid).toFREObject();
            map.remove(uuid);
            return result;
        } catch (FREWrongThreadException e) {
            e.printStackTrace();
        } catch (FRETypeMismatchException e) {
            e.printStackTrace();
        } catch (FREInvalidObjectException e) {
            e.printStackTrace();
        } catch (FREASErrorException e) {
            e.printStackTrace();
        } catch (FRENoSuchNameException e) {
            e.printStackTrace();
        }
        return null;
    }
}

package com.trembit.nativeService.base;

import com.adobe.fre.*;

/**
 * Created with IntelliJ IDEA.
 * User: Andrey Assaul
 * Date: 16.08.2015
 * Time: 17:27
 */
public class RequestError {
    private int code;
    private String message;

    public RequestError(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public FREObject toFREObject() throws FREWrongThreadException, FREASErrorException, FREInvalidObjectException, FRENoSuchNameException, FRETypeMismatchException {
        return FREObject.newObject("com.trembit.nativeService.RequestError",
                new FREObject[]{FREObject.newObject(getCode()), FREObject.newObject(getMessage())});
    }
}

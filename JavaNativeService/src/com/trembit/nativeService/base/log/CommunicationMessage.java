package com.trembit.nativeService.base.log;

/**
 * Created by Andrey Assaul on 04.07.2015.
 */
public class CommunicationMessage {
    private final static String RESPONSE_SUCCESS_PATTERN = "Response success on url: %s";
    private final static String RESPONSE_FAULT_PATTERN = "Response fault on url: %s with code:%d";
    private final static String BAD_URL_ERROR_PATTERN = "Cannot make request with malformed url: %s";
    private final static String CANNOT_OPEN_CONNECTION_ERROR_PATTERN = "Cannot open connection for url: %s";
    private final static String METHOD_IS_NOT_SUPPORTED_ERROR_PATTERN = "%s is not supported for url: %s";
    private final static String CANNOT_GET_RESPONSE_CODE_PATTERN = "Cannot gat response code for url: %s";
    private final static String CANNOT_ESTABLISH_INPUT_STREAM_ERROR_PATTERN = "Cannot establish input stream for url: %s";
    private final static String CANNOT_READ_INPUT_ERROR_PATTERN = "Cannot read input stream from url: %s";

    public String getResponseSuccessMessage(String url){
        return String.format(RESPONSE_SUCCESS_PATTERN, url);
    }

    public String getResponseFault(String url, int responseCode){
        return String.format(RESPONSE_FAULT_PATTERN, url, responseCode);
    }

    public String getBadUrlError(String url){
        return String.format(BAD_URL_ERROR_PATTERN, url);
    }

    public String getCannotOpenConnectionError(String url){
        return String.format(CANNOT_OPEN_CONNECTION_ERROR_PATTERN, url);
    }

    public String getMethodIsNotSupportedError(String method, String url){
        return String.format(METHOD_IS_NOT_SUPPORTED_ERROR_PATTERN, method, url);
    }

    public String getCannotGetResponseCode(String url){
        return String.format(CANNOT_GET_RESPONSE_CODE_PATTERN, url);
    }

    public String getCannotEstablishInputStreamError(String url){
        return String.format(CANNOT_ESTABLISH_INPUT_STREAM_ERROR_PATTERN, url);
    }

    public String getCannotReadInputErrorPattern(String url){
        return String.format(CANNOT_READ_INPUT_ERROR_PATTERN, url);
    }

    CommunicationMessage(){}
}

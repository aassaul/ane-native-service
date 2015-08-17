/**
 * Created by Andrey Assaul on 28.06.2015.
 */
package com.trembit.nativeService.base;

import android.util.Log;
import com.trembit.nativeService.base.enums.RequestMethod;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import static com.trembit.nativeService.base.log.LogConstants.COMMUNICATION_MESSAGE;
import static com.trembit.nativeService.base.log.LogConstants.TAG;

public class BaseMethod {

    private String result;

    private RequestError error;

    public String getResult(){
        return result;
    }

    public RequestError getError() {
        return error;
    }

    public void sendGET(String requestUrl) {
        try {
            result = null;
            error = null;
            URL url = new URL(requestUrl);
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
            try {
                connection.setRequestMethod(RequestMethod.GET.name());
                int responseCode = connection.getResponseCode();
                StringBuilder response;
                if (responseCode == HttpURLConnection.HTTP_OK) {
                    response = readStreamFromConnection(connection, false);
                    if (response != null){
                        Log.i(TAG, COMMUNICATION_MESSAGE.getResponseSuccessMessage(requestUrl));
                        onResult(response);
                    } else {
                        onFault(responseCode);
                    }
                }else {
                    response = readStreamFromConnection(connection, true);
                    Log.i(TAG, String.valueOf(response));
                    onFault(responseCode, response != null ? response.toString() : "");
                }
            } catch (ProtocolException e){
                onFault(COMMUNICATION_MESSAGE.getMethodIsNotSupportedError(RequestMethod.GET.name(), requestUrl));
            } catch (IOException e){
                onFault(COMMUNICATION_MESSAGE.getCannotGetResponseCode(requestUrl));
            } finally {
                connection.disconnect();
            }
        } catch (MalformedURLException e){
            onFault(COMMUNICATION_MESSAGE.getBadUrlError(requestUrl));
        } catch (IOException e){
            onFault(COMMUNICATION_MESSAGE.getCannotOpenConnectionError(requestUrl));
        }
    }

    private void onFault(int responseCode, String data){
        Log.e(TAG, data);
        error = new RequestError(responseCode, data);
    }

    private void onFault(String data){
        onFault(-1, data);
    }

    private void onFault(int responseCode){
        onFault(responseCode, "");
    }

    private void onResult(StringBuilder response) {
        result = response.toString();
    }

    private StringBuilder readStreamFromConnection(HttpURLConnection connection, boolean isError){
        StringBuilder response = null;
        try {
            InputStream inputStream = isError?connection.getErrorStream():connection.getInputStream();
            BufferedReader inputStreamReader = new BufferedReader(new InputStreamReader(inputStream));
            try {
                String inputLine = inputStreamReader.readLine();
                response = new StringBuilder();
                while (inputLine != null) {
                    response.append(inputLine);
                    inputLine = inputStreamReader.readLine();
                }
            } catch (IOException e){
                onFault(COMMUNICATION_MESSAGE.getCannotReadInputErrorPattern(connection.getURL().toString()));
            } finally {
                inputStreamReader.close();
            }
        }catch (IOException e){
            onFault(COMMUNICATION_MESSAGE.getCannotEstablishInputStreamError(connection.getURL().toString()));
        }
        return response;
    }
}
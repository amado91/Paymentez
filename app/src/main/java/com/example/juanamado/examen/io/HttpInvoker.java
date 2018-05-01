package com.example.juanamado.examen.io;

import com.example.juanamado.examen.commons.Constants;
import com.example.juanamado.examen.modelos.Response;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpInvoker {
    public Response sendJsonToUrl(String json){

        Response serverResponse = new Response();

        try{
            URL url = new URL(json) ;
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

            urlConnection.setConnectTimeout(40000);
            urlConnection.setRequestMethod(Constants._HTTP_REQUEST_METHOD_POST);
            urlConnection.setDoInput(true);
            urlConnection.setRequestProperty(Constants._HTTP_STRING_CONTENT_TYPE, Constants._HTTP_STRING_APPLICATION);
            urlConnection.setDoOutput(true);

            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(urlConnection.getOutputStream(), "UTF-8"));
            bw.write(json);
            bw.flush();
            bw.close();

            int responseCode = urlConnection.getResponseCode();
            android.util.Log.i("RespondeCode", String.valueOf(responseCode));

            if(responseCode == 200){

                serverResponse.setStatus(Constants.Status.ok);

                BufferedReader in = new BufferedReader(
                        new InputStreamReader( urlConnection.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();

                while ( (inputLine = in.readLine()) !=null){
                    response.append(inputLine);
                }
                in.close();

                serverResponse.setResponseString(response.toString());
            }
            else {
                serverResponse.setStatus(Constants.Status.Error);
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return serverResponse;
    }
}

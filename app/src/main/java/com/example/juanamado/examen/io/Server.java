package com.example.juanamado.examen.io;

import android.os.Handler;

import com.example.juanamado.examen.commons.Constants;
import com.example.juanamado.examen.modelos.Response;

import java.io.IOException;

public class Server {
    private static Server INSTANCE = null;

    private Handler myHandler = null;

    private Server(){
        myHandler = new Handler();
    }

    private synchronized  static void createInstance(){
        if(INSTANCE == null){
            INSTANCE = new Server();
        }
    }

    public static  Server getINSTANCE(){
        if(INSTANCE == null){
            createInstance();
        }
        return INSTANCE;
    }


    public void doNetWorkOperation(Constants.Operation operation, BasicRunnable action, String json){

        switch (operation){
            case consultaDireccion:
                ConsultaNegocios consultaTask = new ConsultaNegocios(operation, action,json);
                consultaTask.start();
                break;
        }
    }

    class ConsultaNegocios extends BasicThread{

        public ConsultaNegocios(Constants.Operation operation, Runnable runnable, String json) {
            super(operation, runnable, json);
        }

        @Override
        public void run() {
            String url = json;

            HttpInvoker httpInvoker = new HttpInvoker();

            if(Constants._SIMULATION){
                if(Constants._SIM_SUCCESS.equals(Constants._SIM_SUCCESS)){
                    response = new Response();
                    response.setStatus(Constants.Status.ok);
                    response.setResponseString(Constants._SIM_SUCCESS);
                }else{
                    response = new Response();
                    response.setStatus(Constants.Status.ok);
                    response.setResponseString(Constants._SIM_ERROR);
                }

                response = new Parser().parseResponse(response);
            }
            else {
                response = httpInvoker.sendJsonToUrl(json);

                if (response != null) {
                    if (response.getStatus() == Constants.Status.ok) {
                        android.util.Log.e("Checkup", "ResponseStringLogin= " + response.getResponseString());
                        response = new Parser().parseResponse(response);
                    } else {
                        response.setStatus(Constants.Status.Error);
                    }
                }
            }
            myRunnable.setResponse(response);
            myHandler.post(myRunnable);
        }
    }
}

package com.example.juanamado.examen.io;

import com.example.juanamado.examen.modelos.Response;

public class BasicRunnable implements Runnable {

    private Response response;

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }

    @Override
    public void run() {

    }
}

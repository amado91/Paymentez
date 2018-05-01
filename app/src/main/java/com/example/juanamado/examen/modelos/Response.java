package com.example.juanamado.examen.modelos;

import com.example.juanamado.examen.commons.Constants.*;

public class Response {

    private Status status;
    private BasicModel model;
    private String responseString;

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public BasicModel getModel() {
        return model;
    }

    public void setModel(BasicModel model) {
        this.model = model;
    }

    public String getResponseString() {
        return responseString;
    }

    public void setResponseString(String responseString) {
        this.responseString = responseString;
    }
}

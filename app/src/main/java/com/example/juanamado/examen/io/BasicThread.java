package com.example.juanamado.examen.io;

import com.example.juanamado.examen.commons.Constants.*;
import com.example.juanamado.examen.modelos.Response;

public class BasicThread extends Thread{

    String json;
    Operation operation;
    Response response;
    BasicRunnable myRunnable;

    public BasicThread(Operation operation, Runnable runnable, String json) {
        this.myRunnable = (BasicRunnable) runnable;
        this.operation = operation;
        this.json = json;
    }
}

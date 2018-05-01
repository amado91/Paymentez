package com.example.juanamado.examen.delegados;

import android.util.Log;

import com.example.juanamado.examen.MainActivity;
import com.example.juanamado.examen.commons.Constants;
import com.example.juanamado.examen.io.BasicRunnable;
import com.example.juanamado.examen.io.Server;
import com.example.juanamado.examen.modelos.LugaresEncontrados;
import com.example.juanamado.examen.modelos.Response;
import com.example.juanamado.examen.modelos.TodosLosLugares;

public class MainDelegate {
    MainActivity mainActivity;

    public MainDelegate(){

    }

    public MainDelegate(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    public void lugaresCerca(String Json){
        Server.getINSTANCE().doNetWorkOperation(Constants.Operation.consultaDireccion, new MainRunnable(), Json);
    }

    class MainRunnable extends BasicRunnable{
        @Override
        public void run() {
            Response response = getResponse();
            Log.e("response","Status:"+ response.getStatus());
            if(response != null){
                switch (response.getStatus()){

                    case ok:
                        TodosLosLugares data = (TodosLosLugares) response.getModel();
                        if(data.getAllBussines().get(0).getStatus().equals("OK")){
                            mainActivity.onSuccessLogin(data);
                        }
                        else{
                            mainActivity.onErrorData(response.getStatus().toString());
                        }
                        break;


                    default:
                        mainActivity.onError("Error al iniciar Session");
                        break;

                }

            }
        }

    }
}

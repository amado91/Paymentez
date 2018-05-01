package com.example.juanamado.examen.io;

import android.util.Log;

import com.example.juanamado.examen.commons.Constants;
import com.example.juanamado.examen.modelos.LugaresEncontrados;
import com.example.juanamado.examen.modelos.Response;
import com.example.juanamado.examen.modelos.TodosLosLugares;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Parser {
    public Response parseResponse(Response response){

        if(response != null){
            if(response.getStatus() == Constants.Status.ok){
                String responseString = response.getResponseString();
                if(responseString != null && responseString.length() > 0){
                    try {
                        JSONObject dataJson = new JSONObject(responseString);
                        String status = dataJson.getString("status");
                        Log.e("status_parser",status);

                        if (status.equals("OK")){
                            TodosLosLugares todosLosLugares  = new TodosLosLugares();
                            ArrayList<LugaresEncontrados> allBusiines = new ArrayList<LugaresEncontrados>();
                            JSONArray bussines_all = dataJson.getJSONArray("results");

                            for (int i = 0 ; i<bussines_all.length();i++){
                                LugaresEncontrados bussines = new LugaresEncontrados();
                                bussines = new LugaresEncontrados();
                                JSONObject obj = bussines_all.getJSONObject(i);
                                String name = obj.getString("name");
                                bussines.setName(name);
                                bussines.setId(String.valueOf(i));
                                Log.e("name_bussines",name);
                                bussines.setStatus(status);
                                allBusiines.add(bussines);
                            }
                            todosLosLugares.setAllBussines(allBusiines);

                            response.setModel(todosLosLugares);
                        }
                    } catch (JSONException e) {
                        response.setStatus(Constants.Status.Error);
                        Log.e("PayMentez", "Error de Parseo: " + e.toString());
                        e.printStackTrace();
                    }
                }
            }
        }
        return  response;
    }
}

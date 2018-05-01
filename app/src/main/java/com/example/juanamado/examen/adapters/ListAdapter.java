package com.example.juanamado.examen.adapters;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.juanamado.examen.R;
import com.example.juanamado.examen.modelos.LugaresEncontrados;
import com.example.juanamado.examen.modelos.TodosLosLugares;

import java.util.ArrayList;

public class ListAdapter extends BaseAdapter {
    private Context context;
    private AppCompatActivity mActivity;
    private ArrayList<LugaresEncontrados> items;

    public ListAdapter(Context activity, ArrayList<LugaresEncontrados> items){
        this.context = activity;
        this.mActivity = (AppCompatActivity) context;
        this.items = items;
    }
    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int arg0) {
        return items.get(arg0);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;

        if (convertView == null){
            //LayoutInflater inflater = (LayoutInflater) mActivity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            LayoutInflater inflater = (LayoutInflater) mActivity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.item_category,null);

            LugaresEncontrados dir = items.get(position);
            Log.e("error","itemsize"+ items.size());

            TextView name = v.findViewById(R.id.texto);
            name.setText(dir.getName());

            TextView id = v.findViewById(R.id.idBusines);
            id.setText(dir.getId());

            ImageView imageView = v.findViewById(R.id.imageView4);
            imageView.setImageDrawable(context.getDrawable(R.drawable.ic_launcher_background));


        }
        return v;
    }
}

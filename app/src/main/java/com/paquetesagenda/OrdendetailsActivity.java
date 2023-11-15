package com.paquetesagenda;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.paquetesagenda.proyectoagenda.Database;
import com.paquetesagenda.proyectoagenda.HomeActivity;
import com.paquetesagenda.proyectoagenda.LoginActivity;
import com.paquetesagenda.proyectoagenda.R;
import com.paquetesagenda.proyectoagenda.RegistroActivity;

import java.util.ArrayList;
import java.util.HashMap;

public class OrdendetailsActivity extends AppCompatActivity {

    private  String[][] order_details={};

    HashMap<String,String>item;
    ArrayList list;
    SimpleAdapter sa;
    ListView lst;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ordendetails);
        btn = findViewById(R.id.buttonvolverr);
        lst = findViewById(R.id.Listvieworden);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(OrdendetailsActivity.this, HomeActivity.class));
            }
        });

        Database db = new Database(getApplicationContext(),"Proyectoagenda",null,1);
            SharedPreferences sharedPreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
            String usuario = sharedPreferences.getString("usuario","").toString();
            ArrayList dbData = db.getOrderData(usuario);

            order_details = new String[dbData.size()][];
            for(int i=0;i<order_details.length;i++){
                order_details[i]=new String[5];
                String arrData = dbData.get(i).toString();



            }

    }
}
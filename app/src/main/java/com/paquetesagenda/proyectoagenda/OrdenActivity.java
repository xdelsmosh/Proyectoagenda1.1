package com.paquetesagenda.proyectoagenda;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class OrdenActivity extends AppCompatActivity {

    EditText edname,edtef,edmail;
    Button btnorden;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orden);


        edname = findViewById(R.id.Nombreformularioorden);
        edmail = findViewById(R.id.editTextCorreorden);
        edtef = findViewById(R.id.Numerocontactoorden);

        Intent intent=getIntent();
        String[]price=intent.getStringExtra("price").toString().split(java.util.regex.Pattern.quote(":"));
        String date=intent.getStringExtra("date");
        String time=intent.getStringExtra("time");

        btnorden.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
                String usuario = sharedPreferences.getString("usuario","").toString();

                Database db = new Database(getApplicationContext(),"Proyectoagenda",null,1);


            }
        });


    }
}
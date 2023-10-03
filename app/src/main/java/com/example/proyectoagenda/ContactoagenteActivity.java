package com.example.proyectoagenda;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ContactoagenteActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contactoagente);

        CardView exit = findViewById(R.id.tarjetasalirr);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    startActivity(new Intent(ContactoagenteActivity.this,HomeActivity.class));

            }
        });
        CardView sedan = findViewById(R.id.tarjetasedan);
        sedan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it =  new Intent(ContactoagenteActivity.this,AgenteDetallesActivity.class);
                it.putExtra("title","Sedan");
                startActivity(it);
            }
        });
        CardView electrico = findViewById(R.id.tarjetaelectr);
        electrico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it =  new Intent(ContactoagenteActivity.this,AgenteDetallesActivity.class);
                it.putExtra("title","Electrico");
                startActivity(it);
            }
        });
        CardView suv = findViewById(R.id.tarjetaesuv);
        suv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it =  new Intent(ContactoagenteActivity.this,AgenteDetallesActivity.class);
                it.putExtra("title","SUV");
                startActivity(it);
            }
        });

        CardView deportivo = findViewById(R.id.tarjetadeportivo);
        deportivo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it =  new Intent(ContactoagenteActivity.this,AgenteDetallesActivity.class);
                it.putExtra("title","Deportivo");
                startActivity(it);
            }
        });

        CardView camioneta = findViewById(R.id.tarjetaecamioneta);
        camioneta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it =  new Intent(ContactoagenteActivity.this,AgenteDetallesActivity.class);
                it.putExtra("title","Camioneta");
                startActivity(it);
            }
        });
    }
}
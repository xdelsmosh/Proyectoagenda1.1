package com.example.proyectoagenda;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class AgendaActivity extends AppCompatActivity {

    EditText ed1,ed2,ed3;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agenda);
        tv = findViewById(R.id.textormulario);
        ed1 = findViewById(R.id.Nombreformulario);
        ed2 = findViewById(R.id.editTextCorre);
        ed3 = findViewById(R.id.Numerocontacto);


        ed1.setKeyListener(null);
        ed2.setKeyListener(null);
        ed3.setKeyListener(null);

        Intent it = getIntent();
        String tittle = it.getStringExtra("text1");
        String fullname = it.getStringExtra("text2");
        String address = it.getStringExtra("text3");
        String contact = it.getStringExtra("text4");

        tv.setText(tittle);
        ed1.setText(fullname);
        ed2.setText(address);
        ed3.setText(contact);


    }
}
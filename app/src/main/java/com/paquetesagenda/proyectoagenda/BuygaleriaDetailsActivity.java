package com.paquetesagenda.proyectoagenda;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class BuygaleriaDetailsActivity extends AppCompatActivity {

    TextView tvpackaname,tvtotal;
    EditText edDetails;
    Button btnback,btnaddcart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buygaleria_details);

        tvpackaname=findViewById(R.id.textViewcatalogoname);
        edDetails=findViewById(R.id.editTextTextMultiLiner);
        edDetails.setKeyListener(null);
        tvtotal=findViewById(R.id.textViewtotalcost);
        btnback=findViewById(R.id.atras);
        btnaddcart=findViewById(R.id.buttoncarrito);

        Intent intent = getIntent();
        tvpackaname.setText(intent.getStringExtra("text1"));
        edDetails.setText(intent.getStringExtra("text2"));
        tvtotal.setText("Total : "+intent.getStringExtra("text3")+"/-");

        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BuygaleriaDetailsActivity.this, GaleriaActivity.class));

            }
        });


        /*btnaddcart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
                String usuario = sharedPreferences.getString("usuario","").toString();
                String product = tvpackaname.getText().toString();
                float price = Float.parseFloat(intent.getStringExtra("text3").toString());
                Database db = new Database(getApplicationContext(),"Proyectoagenda",null,1);

                if(db.chekCart(usuario,product)==1){
                    Toast.makeText(getApplicationContext(),"Auto ya agregado",Toast.LENGTH_SHORT).show();
                }else {
                    db.addCart(usuario,product,price,"auto");
                    Toast.makeText(getApplicationContext(),"Agregado al carro",Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(BuygaleriaDetailsActivity.this,GaleriaActivity.class));

                }

            }
        });*/

    }
}
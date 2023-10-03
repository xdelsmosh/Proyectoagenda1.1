package com.example.proyectoagenda;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class AgenteDetallesActivity extends AppCompatActivity {

    private String [][] autos_detallles1=
            {
                    {"Nombre del agente: María Pérez","Dirección: Calle ficticia 1234 Egipto","Horario: de 9 a 17 hrs lunes a viernes","Número de teléfono: +56987654321","1"},

                    {"Nombre del agente: Pedro González","Dirección: Calle ficticia 1234 Egipto","Horario: de 10 a 18 hrs lunes a viernes","Número de teléfono: +56955555555","2"},

                    {"Nombre del agente: Ana Rodríguez","Dirección: Calle ficticia 1234 Egipto","Horario: de 8 a 16 hrs lunes a viernes","Número de teléfono: +56998765432","3"},

                    {"Nombre del agente: Luis Sánchez","Dirección: Calle ficticia 1234 Egipto","Horario: de 11 a 19 hrs lunes a viernes","Número de teléfono: +56912345678","4"},

                    {"Nombre del agente: Laura Martínez","Dirección: Calle ficticia 1234 Egipto","Horario: de 13 a 20 hrs lunes a viernes","Número de teléfono: +56999999999","5"}
            };

    private String[][] autos_detallles2 =
            {
                    {"Nombre del agente: Carlos López", "Dirección: Avenida Principal 567, Ciudad Imaginaria", "Horario: de 9 a 18 hrs de lunes a viernes", "Número de teléfono: +56988888888","1"},
                    {"Nombre del agente: Laura Fernández", "Dirección: Calle Central 4321, Pueblo de Ensueño", "Horario: de 10 a 19 hrs de lunes a viernes", "Número de teléfono: +56977777777","2"},
                    {"Nombre del agente: Andrés Ramírez", "Dirección: Calle Ficticia 987, Villa Mágica", "Horario: de 8 a 17 hrs de lunes a viernes", "Número de teléfono: +56966666666","3"},
                    {"Nombre del agente: Marta Silva", "Dirección: Avenida Principal 567, Ciudad Imaginaria", "Horario: de 11 a 20 hrs de lunes a viernes", "Número de teléfono: +56955555555","4"},
                    {"Nombre del agente: Juan Pérez", "Dirección: Calle de los Sueños 123, Villa Encantada", "Horario: de 13 a 22 hrs de lunes a viernes", "Número de teléfono: +56944444444","5"}
            };

    private String[][] autos_detallles3 =
            {
                    {"Nombre del agente: Sofia Martínez", "Dirección: Calle Solitaria 789, Villa Tranquila", "Horario: de 9 a 17 hrs de lunes a viernes", "Número de teléfono: +56912312312","1"},
                    {"Nombre del agente: Diego Rodríguez", "Dirección: Avenida Principal 123, Ciudad Serena", "Horario: de 10 a 18 hrs de lunes a viernes", "Número de teléfono: +56945645645","2"},
                    {"Nombre del agente: Valentina Pérez", "Dirección: Calle Imaginaria 567, Barrio Encantado", "Horario: de 8 a 16 hrs de lunes a viernes", "Número de teléfono: +56978978978","3"},
                    {"Nombre del agente: Javier Soto", "Dirección: Avenida Central 432, Ciudad Moderna", "Horario: de 11 a 19 hrs de lunes a viernes", "Número de teléfono: +56910101010","4"},
                    {"Nombre del agente: Laura Fernández", "Dirección: Calle Tranquila 987, Pueblo Sereno", "Horario: de 13 a 21 hrs de lunes a viernes", "Número de teléfono: +56920202020","5"}
            };

    private String[][] autos_detallles4 =
            {
                    {"Nombre del agente: Ana García", "Dirección: Calle Soleada 123, Ciudad Brillante", "Horario: de 9 a 17 hrs de lunes a viernes", "Número de teléfono: +56911112222","1"},
                    {"Nombre del agente: Javier Rodríguez", "Dirección: Avenida Central 456, Pueblo Encantado", "Horario: de 10 a 18 hrs de lunes a viernes", "Número de teléfono: +56933334444","2"},
                    {"Nombre del agente: Laura Sánchez", "Dirección: Calle Tranquila 789, Villa Serena", "Horario: de 8 a 16 hrs de lunes a viernes", "Número de teléfono: +56955556666","3"},
                    {"Nombre del agente: Carlos Pérez", "Dirección: Avenida Principal 789, Ciudad Imaginaria", "Horario: de 11 a 19 hrs de lunes a viernes", "Número de teléfono: +56977778888","4"},
                    {"Nombre del agente: Sofia López", "Dirección: Calle Feliz 567, Barrio Felicidad", "Horario: de 13 a 21 hrs de lunes a viernes", "Número de teléfono: +56999990000","5"}
            };
    private String[][] autos_detallles5 =
            {
                    {"Nombre del agente: Martín Gómez", "Dirección: Calle Imaginaria 789, Villa Soñadora", "Horario: de 9 a 17 hrs de lunes a viernes", "Número de teléfono: +56987654321","1"},
                    {"Nombre del agente: Carolina Rodríguez", "Dirección: Avenida Central 456, Ciudad Moderna", "Horario: de 10 a 18 hrs de lunes a viernes", "Número de teléfono: +56965432109","2"},
                    {"Nombre del agente: Pedro Fernández", "Dirección: Calle Tranquila 123, Barrio Tranquilo", "Horario: de 8 a 16 hrs de lunes a viernes", "Número de teléfono: +56945678901","3"},
                    {"Nombre del agente: Laura Martínez", "Dirección: Avenida Principal 789, Ciudad Fantástica", "Horario: de 11 a 19 hrs de lunes a viernes", "Número de teléfono: +56998765432","4"},
                    {"Nombre del agente: Juan Pérez", "Dirección: Calle Feliz 567, Pueblo Feliz", "Horario: de 13 a 21 hrs de lunes a viernes", "Número de teléfono: +56912345678","5"}
            };


    TextView tv;
    Button btn;
    String[][] agente_detalles={};

    ArrayList list;
    HashMap<String,String>item;
    SimpleAdapter sa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agente_detalles);

        tv = findViewById(R.id.textssubtitulo);
        btn = findViewById(R.id.buttonvolveragent);
        Intent it = getIntent();
        String title = it.getStringExtra("title");
        tv.setText(title);

        if (title.compareTo("Sedan")==0)
            agente_detalles = autos_detallles1;
        else
        if (title.compareTo("Electrico")==0)
            agente_detalles = autos_detallles2;
        else
        if (title.compareTo("SUV")==0)
            agente_detalles = autos_detallles3;
        else
        if (title.compareTo("Deportivo")==0)
            agente_detalles = autos_detallles4;
        else
        if (title.compareTo("Camioneta")==0)
            agente_detalles = autos_detallles5;

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AgenteDetallesActivity.this,ContactoagenteActivity.class));
            }
        });

        list = new ArrayList();
        for (int i=0;i<agente_detalles.length;i++){
            item = new HashMap<String,String>();
            item.put("line1",agente_detalles[i][0]);
            item.put("line2",agente_detalles[i][1]);
            item.put("line3",agente_detalles[i][2]);
            item.put("line4",agente_detalles[i][3]);
            item.put("line5","Cons Fees"+agente_detalles[i][4]+"/-");
            list.add(item);

        }
        sa = new SimpleAdapter(this,list,
                R.layout.multi_lines,
                new String[]{"line1","line2","line3","line4","line5"},
                new  int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e}
        );
        ListView lst=findViewById(R.id.listviewagent);
        lst.setAdapter(sa);
    }
}
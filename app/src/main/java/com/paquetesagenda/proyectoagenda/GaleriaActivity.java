package com.paquetesagenda.proyectoagenda;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class GaleriaActivity extends AppCompatActivity {


    private String[][] packages =

            {
                    {"Toyota", "Corolla", "2022", "Sedán", "15,000,000"},
                    {"Chevrolet", "Spark", "2023", "Compacto", "8,500,000"},
                    {"Ford", "Escape", "2022", "SUV", "22,000,000"},
                    {"Volkswagen", "Golf", "2021", "Hatchback", "12,500,000"},
                    {"Hyundai", "Tucson", "2023", "SUV", "25,500,000"},
                    {"Mazda", "CX-5", "2022", "SUV", "20,800,000"},
                    {"Nissan", "Versa", "2023", "Sedán", "11,200,000"},
                    {"Renault", "Duster", "2021", "SUV", "17,000,000"},
                    {"Kia", "Rio", "2022", "Compacto", "10,700,000"},


            };


    private String []package_details={
            "Toyota Corolla\n"+
            "Sedán elegante y confiable. Ideal para quienes valoran la eficiencia en combustible y la tecnología avanzada. Diseño moderno y características de seguridad destacadas.",

            "Chevrolet Spark\n"+
            "Compacto y ágil, perfecto para la vida urbana. Diseño llamativo y eficiencia de combustible, ideal para maniobras y estacionamiento fáciles.",

            "Ford Escape\n"+
            "SUV versátil que combina potencia y comodidad. Espaciosa y con características todoterreno, es ideal para aventuras familiares y escapadas al aire libre.",

            "Volkswagen Golf\n"+
            "Hatchback deportivo y elegante. Ofrece un rendimiento ágil y tecnología de vanguardia para una experiencia de conducción emocionante y cómoda.",

            "Hyundai Tucson\n"+
            "SUV moderna y espaciosa. Diseño aerodinámico y características de seguridad avanzadas para un viaje suave y seguro para toda la familia.",

            "Mazda CX-5\n"+
            "Combina elegancia y rendimiento. Con un diseño atractivo y detalles de alta gama, proporciona una experiencia de conducción refinada y eficiente.",

            "Nissan Versa\n"+
            "Sedán compacto con diseño elegante y eficiencia de combustible. Tecnología moderna y espacio interior amplio, ideal para desplazamientos diarios.",

            "Renault Duster\n"+
            "SUV robusta y aventurera. Diseñada para el terreno variado, combina un diseño resistente con comodidades modernas para enfrentar cualquier desafío.",

            "Kia Rio\n"+
            "Compacto y lleno de estilo, eficiente y divertido de conducir. Características de seguridad y tecnología intuitiva, ideal para conductores urbanos."


    };

    HashMap<String,String>item;
    ArrayList list;
    SimpleAdapter sa;
    ListView lst;
    Button  btnBack,btnCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_galeria);

        lst = findViewById(R.id.LISTAGALERIA);
        btnBack=findViewById(R.id.volver3);
        btnCart=findViewById(R.id.buttoncarro);

        btnCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(GaleriaActivity.this,HomeActivity.class));
            }
        });

        list  = new ArrayList();
        for (int i=0;i<packages.length;i++){
            item = new HashMap<String,String>();
            item.put("line1",packages[i][0]);
            item.put("line2",packages[i][1]);
            item.put("line3",packages[i][2]);
            item.put("line4",packages[i][3]);
            item.put("line5","Total"+packages[i][4]+"/-");
            list.add(item);

        }

        sa= new SimpleAdapter(this,list,
                R.layout.multi_lines,
                new String[]{"line1","line2","line3","line4","line5"},
                new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e});

                lst.setAdapter(sa);

                lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        Intent it = new Intent(GaleriaActivity.this,BuygaleriaDetailsActivity.class);
                        it.putExtra("text1",packages[i][0]);
                        it.putExtra("text2",package_details[i]);
                        it.putExtra("text3",packages[i][4]);
                        startActivity(it);

                    }
                });
    }
}
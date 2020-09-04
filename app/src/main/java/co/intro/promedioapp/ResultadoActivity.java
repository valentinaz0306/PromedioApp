package co.intro.promedioapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class ResultadoActivity extends AppCompatActivity {

    private TextView textResult;
    private TextView text2;
    private TextView textNota;
    private Button otravBu;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        //referenciar
        textResult=findViewById(R.id.textResult);
        text2=findViewById(R.id. text2);
        textNota=findViewById(R.id. textNota);
        //otravBu=findViewById(R.id. otravBu);

        otravBu.setOnClickListener(
                (v)->{


                }

        );


    }

    @Override
    protected void onResume() {
        super.onResume();
        super.onResume();
        SharedPreferences colorPreference = getSharedPreferences("Locker", MODE_PRIVATE);
        String color = colorPreference.getString("nuevoColor", "NO_COLOR");

        switch (color) {

            case "azul":
                getWindow().getDecorView().setBackgroundColor(Color.BLUE);

                break;
            case "blanco":
                getWindow().getDecorView().setBackgroundColor(Color.WHITE);

                break;
            case "verde":
                getWindow().getDecorView().setBackgroundColor(Color.GREEN);

                break;

        }
    }


}
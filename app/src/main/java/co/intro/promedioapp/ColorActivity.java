package co.intro.promedioapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;

public class ColorActivity extends AppCompatActivity  implements View.OnClickListener{
    private TextView textConfig;
    private TextView textApp;
    private Button azulBu;
    private Button blancoBu;
    private Button verdeBu;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color);

        //recoger dato de la actividad 1
        //String background= getIntent().getExtras().getString("colorScreen1");

        //referenciar
        textConfig=findViewById(R.id.textConfig);
        textApp=findViewById(R.id.textApp);
        azulBu=findViewById(R.id.azulBu);
        blancoBu=findViewById(R.id.blancoBu);
        verdeBu=findViewById(R.id.verdeBu);

        azulBu.setOnClickListener(this);
        blancoBu.setOnClickListener(this);
        verdeBu.setOnClickListener(this);

    }
    @Override
    public void onClick(View v) {
        //Intent i = new Intent();
       SharedPreferences colorPreference = getSharedPreferences("Locker", MODE_PRIVATE);

        switch (v.getId()){
            case R.id.azulBu:
                colorPreference.edit().putString("nuevoColor","cian").apply();
                //i.putExtra("color","azul");
                break;
            case R.id.blancoBu:
                colorPreference.edit().putString("nuevoColor","blanco").apply();
               // i.putExtra("color","blanco");
                break;
            case R.id.verdeBu:
                colorPreference.edit().putString("nuevoColor","verde").apply();
                //i.putExtra("color","verde");
                break;
        }

        finish();
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences colorPreference = getSharedPreferences("Locker", MODE_PRIVATE);
        String color=colorPreference.getString("nuevoColor", "NO_COLOR");

        switch (color){

            case "cian":   getWindow().getDecorView().setBackgroundColor(Color.CYAN);

                break;
            case "blanco":   getWindow().getDecorView().setBackgroundColor(Color.WHITE);

                break;
            case "verde":   getWindow().getDecorView().setBackgroundColor(Color.GREEN);

                break;

        }
    }



}





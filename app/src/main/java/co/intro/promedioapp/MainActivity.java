package co.intro.promedioapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private TextView nameText;
    private EditText textBu;
    private Button continuarBu;
    private Button configBu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //referenciar
        nameText=findViewById(R.id.nameText);
        textBu=findViewById(R.id.textBu);
        continuarBu=findViewById(R.id.continuarBu);
        configBu=findViewById(R.id.configBu);

        configBu.setOnClickListener(
                (v)->{
                Intent i = new Intent(this,ColorActivity.class);
               // i.putExtra("colorScreen1", (Parcelable) colorScreen1);
                    startActivityForResult(i,10);
                }

        );

        continuarBu.setOnClickListener(
                (v)->{
                    Intent i = new Intent(this,NotaActivity.class);
                    startActivity(i);
                }

        );


    }//oncreate

    @Override
    protected void onResume() {
        super.onResume();
        super.onResume();
        SharedPreferences colorPreference = getSharedPreferences("Locker", MODE_PRIVATE);
        String color=colorPreference.getString("nuevoColor", "NO_COLOR");

        switch (color){

            case "azul":   getWindow().getDecorView().setBackgroundColor(Color.BLUE);

                break;
            case "blanco":   getWindow().getDecorView().setBackgroundColor(Color.WHITE);

                break;
            case "verde":   getWindow().getDecorView().setBackgroundColor(Color.GREEN);

                break;

        }
    }



}//cierra
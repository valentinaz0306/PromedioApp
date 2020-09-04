package co.intro.promedioapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class NotaActivity extends AppCompatActivity {

    private TextView textCal;
    private EditText pP1;
    private EditText pP2;
    private EditText quiz;
    private EditText p1;
    private EditText p2;
    private EditText ej;
    private Button calcularBu;
    //variables
    private double nota;
    private double pP1Cast;
    private double pP2Cast;
    private double quizCast;
    private double p1Cast;
    private double p2Cast;
    private double ejCast;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nota);

        //referenciar
        textCal = findViewById(R.id.textCal);
        pP1 = findViewById(R.id.pP1);
        pP2 = findViewById(R.id.pP2);
        quiz = findViewById(R.id.quiz);
        p1 = findViewById(R.id.p1);
        p2 = findViewById(R.id.p2);
        ej = findViewById(R.id.ej);
        calcularBu = findViewById(R.id.calcularBu);


        calcularBu.setOnClickListener(
                (v) -> {

                    pP1Cast = Double.parseDouble((pP1.getText().toString()));
                    pP2Cast = Double.parseDouble((pP2.getText().toString()));
                    quizCast = Double.parseDouble((quiz.getText().toString()));
                    ejCast = Double.parseDouble((ej.getText().toString()));
                    p1Cast = Double.parseDouble((p1.getText().toString()));
                    p2Cast = Double.parseDouble((p2.getText().toString()));

                    nota = (pP1Cast * 0.25) + (pP2Cast * 0.25) + (p1Cast * 0.15) + (p2Cast * 0.15) + (quizCast * 0.15) +
                            (ejCast * 0.05);

                    SharedPreferences colorPreference = getSharedPreferences("Locker", MODE_PRIVATE);
                    colorPreference.edit().putFloat("promedioNota",(float)nota).apply();

                    Intent i = new Intent(this, ResultadoActivity.class);
                    startActivity(i);
                    finish();

                }
        );

    }//oncreate

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences colorPreference = getSharedPreferences("Locker", MODE_PRIVATE);
        String color = colorPreference.getString("nuevoColor", "NO_COLOR");

        switch (color) {

            case "cian":
                getWindow().getDecorView().setBackgroundColor(Color.CYAN);

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
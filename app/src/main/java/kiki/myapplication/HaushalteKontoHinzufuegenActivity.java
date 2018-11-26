package kiki.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HaushalteKontoHinzufuegenActivity extends AppCompatActivity {

    Button btn_neuenhaushalterstellen, btn_haushaltbeitreten, btn_abbruchhh, btn_hilfehh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_haushalte_konto_hinzufuegen);

        btn_neuenhaushalterstellen = findViewById(R.id.btn_neuenhaushalterstellen);
        btn_haushaltbeitreten = findViewById(R.id.btn_haushaltbeitreten);
        btn_abbruchhh = findViewById(R.id.button3);
        btn_hilfehh = findViewById(R.id.btn_hilfehh);

        btn_neuenhaushalterstellen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        btn_haushaltbeitreten.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        btn_abbruchhh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        btn_hilfehh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}

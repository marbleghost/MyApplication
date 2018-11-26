package kiki.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Objects;

public class HaushaltBeitretenActivity extends AppCompatActivity {

    TextView tv_haushaltbeitreten1, tv_haushaltbeitreten2;
    Button btn_beitreten, btn_abbruch, btn_hilfe;
    EditText et_haushaltsid, et_passwort;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_haushalt_beitreten);

        tv_haushaltbeitreten1 = findViewById(R.id.tv_haushaltbeitreten1);
        tv_haushaltbeitreten2 = findViewById(R.id.tv_haushaltbeitreten2);
        btn_beitreten = findViewById(R.id.btn_beitreten);
        btn_abbruch = findViewById(R.id.btn_abbruch);
        btn_hilfe = findViewById(R.id.btn_hilfe);
        et_haushaltsid = findViewById(R.id.et_haushaltsid);
        et_passwort = findViewById(R.id.et_passwortlogin);
    }
}

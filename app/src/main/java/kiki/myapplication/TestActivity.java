package kiki.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;


public class TestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        final TextView textView = (TextView) findViewById(R.id.textView);

        Button lesenBtn = (Button) findViewById(R.id.lesenBtn);
        lesenBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new ActivityDataSource(textView).execute("someParams");
            }
        });
    }

}

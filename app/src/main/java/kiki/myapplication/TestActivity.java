package kiki.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.util.Log;

import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.TextView;

import java.io.InputStream;
import java.io.BufferedReader;

import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;


public class TestActivity extends AppCompatActivity {

    TextView text;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        text = (TextView)findViewById(R.id.text);
        Button button = (Button)findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String result = null;
                InputStream is = null;
                StringBuilder sb=null;

                //Verbindung zum Server
                try{

                    URL url = new URL("http://localhost:8080/quercus-4.0.39/verbindung.php");
                    URLConnection con = url.openConnection();

                    //TODO: Alles was hier drunter grau ist, koennen wir nicht nutzen, da es veraltet ist.
                    //TODO: Die ALternative waere wohl das, welches ich oben bereits begonne habe (Url url... URLCOnnection)
                    //TODO: Also muessen wir uns das zusammen basteln das es die selbe Aussage spaeter hat

                    //HttpClient httpclient = new DefaultHttpClient();
                    //HttpPost httppost = new HttpPost("http://domain.com/AndroidTest/index.php");
                    //HttpResponse response = httpclient.execute(httppost);
                    //HttpEntity entity = response.getEntity();
                    //is = entity.getContent();
                }catch(Exception e){
                    Log.e("log_tag", "Verbindungsfehler"+e.toString());
                }

                //konvertieren der Antwort in einen String
                try{
                    BufferedReader reader = new BufferedReader(new InputStreamReader(is,"utf-8"),8);
                    sb = new StringBuilder();
                    sb.append(reader.readLine() + "\n");
                    String line="0";
                    while ((line = reader.readLine()) != null) {
                        sb.append(line + "\n");
                    }
                    is.close();
                    result=sb.toString();
                }catch(Exception e){
                    Log.e("log_tag", "Error converting result "+e.toString());
                }

                //Daten trennen
                int fd_id = 0;
                String fd_benutzername = "";
                String fd_name = "";
                String fd_passwort = "";

                try{
                    JSONArray jArray = new JSONArray(result);
                    JSONObject json_data=null;
                    for(int i=0;i<jArray.length();i++) {
                        json_data = jArray.getJSONObject(i);
                        fd_id = json_data.getInt("BenutzerID");
                        fd_benutzername = json_data.getString("Bentzername");
                        fd_name = json_data.getString("Name");
                        fd_passwort = json_data.getString("Passwort");
                    }
                }catch(JSONException e1){
                    Toast.makeText(getBaseContext(), "Keine Daten oder keine Verbindung!", Toast.LENGTH_LONG).show();
                }

                //Ausgeben der empfangenen Daten
                text.setText("ID: "+fd_id+" Benutzername: "+fd_benutzername+" Name: "+fd_name+" Passwort: "+fd_passwort);
            }
        });

    }
}

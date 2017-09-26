package mhercharachian.com.lab04_localisation;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = (TextView) findViewById(R.id.countryName);

    }

    public void sendToMapActivity(View view) {
        Intent i = new Intent(this, MapActivity.class);
        i.putExtra("DATA1", tv.getText().toString());
        startActivity(i);

    }

}

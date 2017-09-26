package mhercharachian.com.lab04_localisation;

import android.app.SearchManager;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MapActivity extends AppCompatActivity {

    TextView tv;
    EditText et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        String value = getIntent().getExtras().getString("DATA1");

        et = (EditText) findViewById(R.id.location);
        tv = (TextView) findViewById(R.id.errors);

        if (value == null || value.isEmpty()) {
            tv.setText("Need a location");
            tv.setTextColor(Color.RED);
        } else {
            //MainActivity.logIt("DATA1 " + value);
            et.setText(value);
            et.setTextColor(Color.GREEN);
        }
    }

    public void openMap(View v)
    {
        String loc = et.getText().toString();
        Uri myUri = Uri.parse("geo:0,0?q=" + Uri.encode(loc));
        showMap(myUri);
    }

    public void searchOnline(View v)
    {
        String loc = et.getText().toString();
        if(loc == null || loc.isEmpty())
        {
            tv.setText("Need a location");
            tv.setTextColor(Color.RED);
        }
        else
        {
            searchWeb(loc);
        }
    }

    public void showMap(Uri geoLocation) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(geoLocation);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void searchWeb(String query) {
        Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
        intent.putExtra(SearchManager.QUERY, query);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

}

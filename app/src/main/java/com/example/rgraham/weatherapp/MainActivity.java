package com.example.rgraham.weatherapp;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;


public class MainActivity extends Activity implements View.OnClickListener {

    static final String baseUrl = "http://api.openweathermap.org/data/2.5/weather?q=";
    static final String imgURL = "http://openweathermap.org/img/w/";


    TextView text;
    EditText city;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        Button b = (Button) findViewById(R.id.main_button);
        text = (TextView) findViewById(R.id.current_weather);
        city = (EditText) findViewById(R.id.myCity);
        b.setOnClickListener(this);

        // Figure out a way to clean this up too. Maybe see if I can move it somewhere else
        city.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    encodeAndBuildString(city);
                    return true;
                }
                return false;
            }
        });
    }

    // This method basically encodes and builds the string.
    public void encodeAndBuildString(EditText searchLocation) {

        String c = searchLocation.getText().toString();
        String encoded = null;
        try {
            encoded = URLEncoder.encode(c, "UTF-8").replace("+", "%20");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        StringBuilder URL = new StringBuilder(baseUrl);
        URL.append(encoded + "&APPID=7294c49c972a84832b19e0225dd8cb44&mode=xml");
        String fullUrl = URL.toString();
        new Read().execute(fullUrl);
    }


    public void onClick(View view) {
        encodeAndBuildString(city);
    }

    class Read extends AsyncTask<String, Integer, String> {

        private ProgressDialog progressDialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog = ProgressDialog.show(MainActivity.this, "Wait", "Downloading... ", true);
            progressDialog.setCancelable(true);
        }

        @Override
        protected String doInBackground(String... arg0) {
            try

            {
                URL website = new URL(arg0[0]);
                SAXParserFactory spf = SAXParserFactory.newInstance();
                SAXParser sp = spf.newSAXParser();
                XMLReader xr = sp.getXMLReader();
                ParseXML parser = new ParseXML();
                xr.setContentHandler(parser);
                xr.parse(new InputSource(website.openStream()));

                return parser.getInformation();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String result) {
            text.setText(result);
            progressDialog.dismiss();
        }
    }
}





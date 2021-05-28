package com.example.parseandroidstudio;
import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class MainActivity extends AppCompatActivity {


    TextView text;
    Button btn2;
    Button btn4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text=(TextView)findViewById(R.id.textview);
        Button btn=(Button)findViewById(R.id.pulltxt);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new doit().execute();
            }
        });

        btn2 =(Button)findViewById(R.id.btn2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ParseImage.class);
                startActivity(intent);
            }
        });
        btn4=(Button)findViewById(R.id.btn4);
        btn4.setOnClickListener(v -> {
            Intent web = new Intent(getApplicationContext(), WebParse.class);
            startActivity(web);
        });

    }

    public class doit extends AsyncTask<Void, Void, Void>{

        String words;

        @Override
        protected Void doInBackground(Void... voids) {

            try {


                Document doc = Jsoup.connect("https://www.studylab.ru/education/higher-education/vuzy/harvard-university").get();

                words=doc.text();
            }catch (Exception e){e.printStackTrace();}
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

            text.setText(words);
        }
    }

}
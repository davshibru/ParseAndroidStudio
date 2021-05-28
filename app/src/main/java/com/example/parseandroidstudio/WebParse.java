package com.example.parseandroidstudio;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class WebParse extends AppCompatActivity {


    WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_parse);
        webView=(WebView)findViewById(R.id.webview);
        webView.loadUrl("https://iuca.kg/ru/");
    }
}
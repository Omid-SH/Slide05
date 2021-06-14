package com.example.slides2;

import android.os.Bundle;
import android.webkit.WebView;

import androidx.appcompat.app.AppCompatActivity;

public class Slide27_28 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.slide27_28);
        WebView myWebView = (WebView) findViewById(R.id.web_view);
        myWebView.loadUrl("https://quera.ir");
    }
}

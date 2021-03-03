package com.example.covergrabber;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.apache.commons.lang3.StringUtils;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    String url ="";
    String name = "Iron Maiden";
    Button btUpdate;
    ImageView cover;
    TextView textOutput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btUpdate = findViewById(R.id.button);
        cover = findViewById(R.id.cover);
        textOutput = findViewById(R.id.url);

    }
}
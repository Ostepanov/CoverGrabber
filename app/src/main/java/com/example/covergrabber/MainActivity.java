package com.example.covergrabber;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
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
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {
    String urlCover = "https://enroks.es/php/currentCover.php";
    Button btUpdate;
    ImageView cover;
    TextView textOutput;
    String res, result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btUpdate = findViewById(R.id.button);
        cover = findViewById(R.id.cover);
        textOutput = findViewById(R.id.url);

        btUpdate.setOnClickListener(v -> {
            Load();
        });}





        private void Load(){
        result = sendGetRequest(urlCover);
        Picasso.get().load(result).into(cover);

        }
    //request to page for obtain song title
        private String sendGetRequest(String url){
            RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
            StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    if(url.contains("Cover")){
                        res = response;
                    }
                    else
                        res = StringUtils.substringBetween(response, "<p style=color:#f07700;text-align:center><b>","</b></p>");
                }
            }, new Response.ErrorListener() {
                @SuppressLint("SetTextI18n")
                @Override
                public void onErrorResponse(VolleyError error) {
                    textOutput.setText("ENROKS RADIO");
                }
            });
        queue.add(stringRequest);
        return res;
        }








/*
    private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
        ImageView bmImage;

        public DownloadImageTask(ImageView bmImage) {
            this.bmImage = bmImage;
        }

        protected Bitmap doInBackground(String... urls) {
            String urldisplay = urls[0];
            Bitmap mIcon11 = null;
            try {
                InputStream in = new java.net.URL(urldisplay).openStream();
                mIcon11 = BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return mIcon11;
        }

        protected void onPostExecute(Bitmap result) {
            cover.setImageBitmap(result);
        }
    }*/
}
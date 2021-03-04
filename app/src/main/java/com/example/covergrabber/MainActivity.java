package com.example.covergrabber;
https://stackoverflow.com/questions/2471935/how-to-load-an-imageview-by-url-in-android
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
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

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {
    String url ="";
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

        new DownloadImageTask((ImageView) findViewById(R.id.cover))
                .execute("https://lastfm.freetls.fastly.net/i/u/174s/bec75daa4dab41e38924b0d3b2dcf115.png");


        btUpdate.setOnClickListener(v -> {

        });}



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
    }
}
package com.app.coronavairuss;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.airbnb.lottie.LottieAnimationView;

public class mapaNacional extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapa_nacional);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
/*
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setIcon(R.mipmap.ic_launcher);
        progressDialog.setMessage("Cargando...");
        progressDialog.show();


 */
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("México");
        final LottieAnimationView animacion2 = findViewById(R.id.Animacion2);

        final LottieAnimationView animacion = findViewById(R.id.Animacion);
        WebView wv = findViewById(R.id.root_web_view);
        wv.getSettings().setJavaScriptEnabled(true);

        wv.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                //elimina ProgressBar.
                animacion.cancelAnimation();
                animacion.setVisibility(View.INVISIBLE);

            }
        });
         if (isOnline(mapaNacional.this)) {
           String url =("https://mesuralab.carto.com/builder/b3288f9c-ed8f-4d9a-bfb4-755fa8b5cf7d/embed");
             wv.loadUrl(url);
             animacion2.setVisibility(View.INVISIBLE);

         } else {
             wv.loadUrl("file:///android_asset/index.html");
         }



        }
    public static boolean isOnline(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isAvailable() && networkInfo.isConnected();
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}

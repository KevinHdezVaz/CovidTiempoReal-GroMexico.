package com.app.coronavairuss.MapaInteractivo.Vista;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.airbnb.lottie.LottieAnimationView;
import com.app.coronavairuss.R;

public class mapa extends AppCompatActivity {
     WebView wv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        setContentView(R.layout.activity_mapa);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Noticias");
         wv = findViewById(R.id.root_web_view);

        wv.getSettings().setJavaScriptEnabled(true);

        final LottieAnimationView animacion2 = findViewById(R.id.Animacion2);


        final LottieAnimationView animacion = findViewById(R.id.Animacion);
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
        if (isOnline(mapa.this)) {
            String url =("https://www.google.com/search?q=coronavirus+chilpancingo&sxsrf=ALeKk00MzQ3jbM5RHqphtyQCu9zzRExtbw:1605323707711&source=lnms&tbm=nws&sa=X&ved=2ahUKEwjax-PqiIHtAhWYG80KHTaHB3YQ_AUoAXoECA4QAw&biw=1777&bih=876");
            wv.loadUrl(url);

            animacion2.setVisibility(View.INVISIBLE);

        } else {
            wv.loadUrl("file:///android_asset/index.html");
        }


    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
    public static boolean isOnline(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isAvailable() && networkInfo.isConnected();
    }

}

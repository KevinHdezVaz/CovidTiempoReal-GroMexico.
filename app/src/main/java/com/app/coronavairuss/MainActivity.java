package com.app.coronavairuss;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;
import com.app.coronavairuss.DatosMundiales.Vista.DatostiempoReal;
import com.app.coronavairuss.MapaInteractivo.Vista.mapa;
import com.app.coronavairuss.Recomendaciones.recomendaciones;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class MainActivity extends AppCompatActivity {
    GridLayout mainGri;
    ImageButton btn1;
    ImageButton btn2;
    ImageButton btn3;
    ImageButton btn4;
    Dialog epicDialog;
    TextView textoarr,resultado;
    Button  botonvam, botonface;
    DatabaseReference databaseReference;
    ImageView cerrar;
    LottieAnimationView animacion;
  private InterstitialAd mInterstitialAd;

    private TextView mtextview;
     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainGri = (GridLayout)findViewById(R.id.mainGrid);
        btn1 = (ImageButton)findViewById(R.id.btn_mate);
        btn2 = (ImageButton)findViewById(R.id.btn_quimica);
        btn3 = (ImageButton)findViewById(R.id.btn_calculo);
        btn4 = (ImageButton)findViewById(R.id.btn_fisica);

        mtextview = (TextView)findViewById(R.id.textfire);

        databaseReference = FirebaseDatabase.getInstance().getReference();
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });



        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-8882667917768463/4375470220");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());

         mInterstitialAd.setAdListener(new AdListener() {
             @Override
             public void onAdClosed() {
                 // Load the next interstitial.
                 mInterstitialAd.loadAd(new AdRequest.Builder().build());
             }

         });
        databaseReference.child("Persona").addValueEventListener(new ValueEventListener() {
            @Override

            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    String nombre = dataSnapshot.child("Name").getValue().toString();
                    mtextview.setText(nombre);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });




        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DatostiempoReal.class);


               startActivity(intent);


            }
        });

      btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, mapa.class);
               if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                } else {
                    Log.d("TAG", "The interstitial wasn't loaded yet.");
                }

                 startActivity(intent);

            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, mapaNacional.class);
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                } else {
                    Log.d("TAG", "The interstitial wasn't loaded yet.");
                }

                startActivity(intent);
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, recomendaciones.class);
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                } else {
                    Log.d("TAG", "The interstitial wasn't loaded yet.");
                }

                 startActivity(intent);
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.mymenu, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.action_info) {
            mostrarInfo();
        }
        return super.onOptionsItemSelected(item);
    }

    public void mostrarInfo(){
        epicDialog = new Dialog(this);
        epicDialog.setContentView(R.layout.custom_resultado);
        cerrar = (ImageView)epicDialog.findViewById(R.id.cerrarVentana);
        botonvam = (Button)epicDialog.findViewById(R.id.botonvamo);
        animacion = (LottieAnimationView)epicDialog.findViewById(R.id.Animacion);
        textoarr = (TextView)epicDialog.findViewById(R.id.texto);
        textoarr.setText("Información");
        resultado = (TextView)epicDialog.findViewById(R.id.txtResultado);
        resultado.setText("Los datos mostrados en la aplicacion son proporcionados por la OMS (Organizacion Mundial de la Salud) en conjunto con otras organizaciones internacionales." +
                "" +
                "\n\nEsta aplicacion es una herramienta con la que podemos estar al tanto de toda la información relacionada con el Coronavirus contando con diversas herramientas." +
                "\n\nSe muestran numerosos gráficos con los que observaremos la situación en cada territorio. De esta forma, en tan solo unos segundos sabremos cuáles son aquellos países en los que hay un mayor número de contagios, pacientes ingresados, recuperados y fallecidos a causa del virus. ");
        animacion.setAnimation(R.raw.developer);
        cerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                epicDialog.dismiss();
            }
        });

        epicDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        epicDialog.show();

        botonvam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                epicDialog.dismiss();

            }
        });

    }

}

package com.app.coronavairuss.Recomendaciones;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;
import com.app.coronavairuss.R;
import com.app.coronavairuss.Recomendaciones.adaptador.CustomAdapter3;
import com.app.coronavairuss.Recomendaciones.adaptador.lista2;

import java.util.ArrayList;

public class recomendaciones extends AppCompatActivity {
    private ListView list;
    private CustomAdapter3 adaptador;
    Dialog epicDialog;
    ImageView cerrar;
    TextView resultado;
    Button boton;
    LottieAnimationView animacion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recomendaciones);

        epicDialog = new Dialog(this);

        boton = (Button) findViewById(R.id.botonvamo);
         list = (ListView) findViewById(R.id.item2_2);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Recomendaciones");
        final ArrayList<lista2> listItems = new ArrayList<>();
        listItems.add(new lista2((R.drawable.sintom),"¿Cuales son los sintomas?"));
        listItems.add(new lista2((R.drawable.contagio),"¿Puedo contagiarme de una persona sin síntomas?"));
        listItems.add(new lista2((R.drawable.grupo_riesgo),"¿Quiénes forman los grupos de riesgo?"));
        listItems.add(new lista2((R.drawable.propaga),"¿Cómo se propaga?"));
        listItems.add(new lista2((R.drawable.clima),"¿El clima cálido detendrá el brote?"));
        listItems.add(new lista2((R.drawable.manos),"Correcto Lavado de Manos."));
        listItems.add(new lista2((R.drawable.grupo_riesgo),"Evitar el contacto directo."));
        listItems.add(new lista2((R.drawable.cubreboca),"Cubra su boca y nariz con una cubierta de tela."));
        listItems.add(new lista2((R.drawable.desinfecte),"Limpie y desinfecte"));


        adaptador = new CustomAdapter3(this, listItems);
        list.setAdapter(adaptador);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(i==0){
                    mostrarInfoPROSint();
                }

                else if (i==1){
                    mostrarInfoPRO();
                }

                else if (i==2){
                    mostrarInfoPRO2();
                }
                else if (i==3){
                    mostrarInfoPRO3();
                }
                else if(i==4){
                    mostrarInfoPRO4();
                }
                else if(i==5){
                    mostrarInfoPRO5();
                }
                else if(i==6){
                    mostrarInfoPRO6();
                }
                else if(i==7){
                    mostrarInfoPRO7();
                }
                else if(i==8){
                    mostrarInfoPRO8();
                }
            }
        });

    }
    public void mostrarInfoPROSint() {
        epicDialog.setContentView(R.layout.custom_resultado);
        cerrar = (ImageView) epicDialog.findViewById(R.id.cerrarVentana);
        boton = (Button) epicDialog.findViewById(R.id.botonvamo);
        resultado = (TextView) epicDialog.findViewById(R.id.txtResultado);
        animacion = (LottieAnimationView) epicDialog.findViewById(R.id.Animacion);


        animacion.setAnimation(R.raw.estornudo);
        resultado.setText("Los casos confirmados de la enfermedad del coronavirus 2019 (COVID-19) reportan síntomas que varían de leves a enfermedad grave y muerte.\n" +
                "\n Estos síntomas pueden aparecer entre 2 a 14 días después de la exposición (con base en la información sobre periodos de incubación de los virus MERS-CoV).\n" +
                "\n● Fiebre.\n● Tos.\n● Dificultad para Respirar.\n● Diarrea");
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                epicDialog.dismiss();
            }
        });
        cerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                epicDialog.dismiss();
            }
        });
        epicDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        epicDialog.show();
    }
    public void mostrarInfoPRO() {
        epicDialog.setContentView(R.layout.custom_resultado);
        cerrar = (ImageView) epicDialog.findViewById(R.id.cerrarVentana);
        boton = (Button) epicDialog.findViewById(R.id.botonvamo);
        resultado = (TextView) epicDialog.findViewById(R.id.txtResultado);
        animacion = (LottieAnimationView) epicDialog.findViewById(R.id.Animacion);


        animacion.setAnimation(R.raw.manono);
        resultado.setText("El virus se contagia con mayor facilidad cuando una persona infectada presenta síntomas.\n Por eso, lo mejor es tener las manos limpias y no tocarse el rostro.\n\nPero también es posible contagiarse de el virus antes de que se empiece a presentar síntomas. Una persona puede tardar de 2 a 14 días en presentar síntoma después de contraer el virus."
        );
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                epicDialog.dismiss();
            }
        });

        cerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                epicDialog.dismiss();
            }
        });
        epicDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        epicDialog.show();
    }

    public void mostrarInfoPRO2() {
        epicDialog.setContentView(R.layout.custom_resultado);
        cerrar = (ImageView) epicDialog.findViewById(R.id.cerrarVentana);
        boton = (Button) epicDialog.findViewById(R.id.botonvamo);
        resultado = (TextView) epicDialog.findViewById(R.id.txtResultado);
        animacion = (LottieAnimationView) epicDialog.findViewById(R.id.Animacion);

        animacion.setAnimation(R.raw.gentecambiando);

        resultado.setText("● Personas de 60 años o más\n● Mujeres embarazadas\n● Niñas y niños menor de 5 años\n● Quienes padecen enfermedades inmunodepresivas, crónicas, cardíacas, pulmonares, renales, hepáticas, sanguíneas o metabólicas."
        );
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                epicDialog.dismiss();
            }
        });

        cerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                epicDialog.dismiss();
            }
        });
        epicDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        epicDialog.show();
    }
    public void mostrarInfoPRO3() {
        epicDialog.setContentView(R.layout.custom_resultado);
        cerrar = (ImageView) epicDialog.findViewById(R.id.cerrarVentana);
        boton = (Button) epicDialog.findViewById(R.id.botonvamo);
        resultado = (TextView) epicDialog.findViewById(R.id.txtResultado);
        animacion = (LottieAnimationView) epicDialog.findViewById(R.id.Animacion);


        animacion.setAnimation(R.raw.mascarilla);
        resultado.setText("Se cree que el virus que causa COVID-19 se propaga principalmente de persona a persona, principalmente a través de las gotas respiratorias producidas cuando una persona infectada tose o estornuda.\n" +"\nEstas gotitas pueden terminar en la boca o en la nariz de quienes se encuentran cerca o posiblemente ser inhaladas y llegar a los pulmones. La propagación es más probable cuando las personas están en contacto cercano entre sí.");
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                epicDialog.dismiss();
            }
        });
        cerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                epicDialog.dismiss();
            }
        });
        epicDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        epicDialog.show();
    }

    public void mostrarInfoPRO4() {
        epicDialog.setContentView(R.layout.custom_resultado);
        cerrar = (ImageView) epicDialog.findViewById(R.id.cerrarVentana);
        boton = (Button) epicDialog.findViewById(R.id.botonvamo);
        resultado = (TextView) epicDialog.findViewById(R.id.txtResultado);
        animacion = (LottieAnimationView) epicDialog.findViewById(R.id.Animacion);


        animacion.setAnimation(R.raw.covid);
        resultado.setText("Todavía no se sabe si el clima y la temperatura afectan la propagación de COVID-19. Algunos otros virus, como los que causan el resfriado común y la gripe, se propagan más durante los meses de clima frío, pero eso no significa que sea imposible enfermarse con estos virus durante otros meses. \n\nHay mucho más que aprender acerca de la transmisibilidad, gravedad y otras características asociadas al COVID-19, y las investigaciones están en curso.\n");
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                epicDialog.dismiss();
            }
        });
        cerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                epicDialog.dismiss();
            }
        });
        epicDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        epicDialog.show();
    }

    public void mostrarInfoPRO5() {
        epicDialog.setContentView(R.layout.custom_resultado);
        cerrar = (ImageView) epicDialog.findViewById(R.id.cerrarVentana);
        boton = (Button) epicDialog.findViewById(R.id.botonvamo);
        resultado = (TextView) epicDialog.findViewById(R.id.txtResultado);
        animacion = (LottieAnimationView) epicDialog.findViewById(R.id.Animacion);


        animacion.setAnimation(R.raw.manos);
resultado.setText("● Lávese las manos con frecuencia con agua y jabón por al menos 20 segundos, especialmente después de haber estado en un lugar público, o después de sonarse la nariz, toser o estornudar." +
        "\n\n● Lávese las manos con frecuencia con agua y jabón por al menos 20 segundos, especialmente después de haber estado en un lugar público, o después de sonarse la nariz, toser o estornudar." +
        "\n\n● Evite tocarse los ojos, la nariz y la boca sin haberse lavado las manos.\n");
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                epicDialog.dismiss();
            }
        });
        cerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                epicDialog.dismiss();
            }
        });
        epicDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        epicDialog.show();
    }

    public void mostrarInfoPRO6() {
        epicDialog.setContentView(R.layout.custom_resultado);
        cerrar = (ImageView) epicDialog.findViewById(R.id.cerrarVentana);
        boton = (Button) epicDialog.findViewById(R.id.botonvamo);
        resultado = (TextView) epicDialog.findViewById(R.id.txtResultado);
        animacion = (LottieAnimationView) epicDialog.findViewById(R.id.Animacion);


        animacion.setAnimation(R.raw.casaa);
        resultado.setText("● Evite el contacto cercano con personas que están enfermas." +
                "\n\n● Quédese en casa tanto como sea posible." +
                "\n\n● Ponga distancia entre usted y las demás personas.\nRecuerde que algunas personas que no tienen síntomas pueden propagar el virus.\nRecuerde que algunas personas que no tienen síntomas pueden propagar el virus.");
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                epicDialog.dismiss();
            }
        });
        cerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                epicDialog.dismiss();
            }
        });
        epicDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        epicDialog.show();
    }

    public void mostrarInfoPRO7() {
        epicDialog.setContentView(R.layout.custom_resultado);
        cerrar = (ImageView) epicDialog.findViewById(R.id.cerrarVentana);
        boton = (Button) epicDialog.findViewById(R.id.botonvamo);
        resultado = (TextView) epicDialog.findViewById(R.id.txtResultado);
        animacion = (LottieAnimationView) epicDialog.findViewById(R.id.Animacion);


        animacion.setAnimation(R.raw.mascarilla);
        resultado.setText("Puede transmitir COVID-19 a otras personas incluso si no se siente enfermo." +
                "\n● Todos deben usar una cubierta facial de tela cuando tienen que salir en público, por ejemplo, a la tienda de comestibles o para recoger otras necesidades." +
                "\n\n●" +
                "Cubra su boca y nariz con una cubierta de tela cuando esté cerca de otros\n" +
                "\n● Puede transmitir COVID-19 a otras personas incluso si no se siente enfermo.\n" +
                "\n● Todos deben usar una cubierta facial de tela cuando tienen que salir en público, por ejemplo, a la tienda de comestibles o para recoger otras necesidades.\n" +
                "\n● Los revestimientos de tela para la cara no se deben colocar en niños pequeños menores de 2 años, en cualquier persona que tenga problemas para respirar o que esté inconsciente, incapacitado o que no pueda quitarse la máscara sin ayuda.\nLa cubierta facial de tela está diseñada para proteger a otras personas en caso de que esté infectado.\nRecuerde que algunas personas que no tienen síntomas pueden propagar el virus.");
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                epicDialog.dismiss();
            }
        });
        cerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                epicDialog.dismiss();
            }
        });
        epicDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        epicDialog.show();
    }

    public void mostrarInfoPRO8() {
        epicDialog.setContentView(R.layout.custom_resultado);
        cerrar = (ImageView) epicDialog.findViewById(R.id.cerrarVentana);
        boton = (Button) epicDialog.findViewById(R.id.botonvamo);
        resultado = (TextView) epicDialog.findViewById(R.id.txtResultado);
        animacion = (LottieAnimationView) epicDialog.findViewById(R.id.Animacion);


        animacion.setAnimation(R.raw.manooos);
        resultado.setText("● Limpie Y desinfecte diariamente las superficies que se tocan con frecuencia . Esto incluye las mesas, las manijas de las puertas, los interruptores de luz, los mesones, las barandas, los escritorios, los teléfonos, los teclados, los inodoros, los grifos, los lavamanos y los lavaplatos."+
                "\n\n● Si las superficies están sucias, límpielas: lávelas con agua y detergente o jabón antes de desinfectarlas.");
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                epicDialog.dismiss();
            }
        });
        cerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                epicDialog.dismiss();
            }
        });
        epicDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        epicDialog.show();
    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
        }


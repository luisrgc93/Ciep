package com.example.macmini3cuceimobile.ciep;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
/**
 * Created by Luis on 26/11/2015.
 */

public class DragAndDrop extends AppCompatActivity {
    TextView prueba;
    Context contexto;
    ImageView imageView1;
    ImageView imageView2;
    ImageView imageView3;
    ImageView imageView4;
    ImageView imageView5;
    ImageView imageView6;
    ImageView imageView7;
    ImageView imageView8;
    ImageView imageView9;
    ImageView imageView10;
    ImageView imageView11;
    ImageView imageView12;

    RelativeLayout relativeLayout1;
    RelativeLayout relativeLayout2;
    RelativeLayout relativeLayout3;
    RelativeLayout relativeLayout4;
    RelativeLayout relativeLayout5;
    RelativeLayout relativeLayout6;
    RelativeLayout relativeLayout7;
    RelativeLayout relativeLayout8;
    RelativeLayout relativeLayout9;
    RelativeLayout relativeLayout10;
    RelativeLayout relativeLayout11;
    RelativeLayout relativeLayout12;
    boolean terminar = false;
    ArrayList<Opcion> opcions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drag_and_drop);
        contexto = getApplicationContext();
        prueba = (TextView) findViewById(R.id.texto_prueba);
        opcions = new ArrayList<>();
        relativeLayout1 = (RelativeLayout) findViewById(R.id.layout_1);
        relativeLayout2 = (RelativeLayout) findViewById(R.id.layout_2);
        relativeLayout3 = (RelativeLayout) findViewById(R.id.layout_3);
        relativeLayout4 = (RelativeLayout) findViewById(R.id.layout_4);
        relativeLayout5 = (RelativeLayout) findViewById(R.id.layout_5);
        relativeLayout6 = (RelativeLayout) findViewById(R.id.layout_6);
        relativeLayout7 = (RelativeLayout) findViewById(R.id.layout_7);
        relativeLayout8 = (RelativeLayout) findViewById(R.id.layout_8);
        relativeLayout9 = (RelativeLayout) findViewById(R.id.layout_9);
        relativeLayout10 = (RelativeLayout) findViewById(R.id.layout_10);
        relativeLayout11 = (RelativeLayout) findViewById(R.id.layout_11);
        relativeLayout12 = (RelativeLayout) findViewById(R.id.layout_12);

        //Incialización de imagen
        imageView1 = (ImageView) findViewById(R.id.arrastra_1);
        imageView2 = (ImageView) findViewById(R.id.arrastra_2);
        imageView3 = (ImageView) findViewById(R.id.arrastra_3);
        imageView4 = (ImageView) findViewById(R.id.arrastra_4);
        imageView5 = (ImageView) findViewById(R.id.arrastra_5);
        imageView6 = (ImageView) findViewById(R.id.arrastra_6);
        imageView7 = (ImageView) findViewById(R.id.arrastra_7);
        imageView8 = (ImageView) findViewById(R.id.arrastra_8);
        imageView9 = (ImageView) findViewById(R.id.arrastra_9);
        imageView10 = (ImageView) findViewById(R.id.arrastra_10);
        imageView11 = (ImageView) findViewById(R.id.arrastra_11);
        imageView12 = (ImageView) findViewById(R.id.arrastra_12);

        opcions.add(new Opcion(imageView1, 1, 0));
        opcions.add(new Opcion(imageView2, 1, 0));
        opcions.add(new Opcion(imageView3, 1, 0));
        opcions.add(new Opcion(imageView4, 2, 0));
        opcions.add(new Opcion(imageView5, 2, 0));
        opcions.add(new Opcion(imageView6, 2, 0));
        opcions.add(new Opcion(imageView7, 2, 0));
        opcions.add(new Opcion(imageView8, 1, 0));
        opcions.add(new Opcion(imageView9, 2, 0));
        opcions.add(new Opcion(imageView10, 1, 0));
        opcions.add(new Opcion(imageView11, 2, 0));
        opcions.add(new Opcion(imageView12, 1, 0));

        //Se agrega para que se puedan mover
        imageView1.setOnTouchListener(new DragListener(opcions.get(0)));
        imageView2.setOnTouchListener(new DragListener(opcions.get(1)));
        imageView3.setOnTouchListener(new DragListener(opcions.get(2)));
        imageView4.setOnTouchListener(new DragListener(opcions.get(3)));
        imageView5.setOnTouchListener(new DragListener(opcions.get(4)));
        imageView6.setOnTouchListener(new DragListener(opcions.get(5)));
        imageView7.setOnTouchListener(new DragListener(opcions.get(6)));
        imageView8.setOnTouchListener(new DragListener(opcions.get(7)));
        imageView9.setOnTouchListener(new DragListener(opcions.get(8)));
        imageView10.setOnTouchListener(new DragListener(opcions.get(9)));
        imageView11.setOnTouchListener(new DragListener(opcions.get(10)));
        imageView12.setOnTouchListener(new DragListener(opcions.get(11)));

        final Button button = (Button) findViewById(R.id.boton_evaluar);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (terminar) {
                    finish();
                } else {
                    String resultado = evaluar();
                    Toast.makeText(contexto, resultado, Toast.LENGTH_SHORT).show();
                    button.setText("Terminar");
                    terminar = true;
                }
            }
        });
    }

    public String evaluar () {
        int correctas = 0;

        for (Opcion opcion : opcions) {

            if (opcion.getId() == opcion.getCorrecto()) {
                correctas++;
            }
        }

        return "Tienes " + correctas + " respuestas correctas y " + (12 - correctas) + " incorrectas";

    }

    public class DragListener implements View.OnTouchListener{
        Opcion opcion;
        float x = 0.0f;
        float y = 0.0f;
        boolean movimiento = false;
        int id;

        public DragListener (Opcion opcion) {
            this.opcion = opcion;
            this.id = id;
        }

        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {

            switch (motionEvent.getAction()){
                case MotionEvent.ACTION_DOWN:
                    movimiento = true;
                    break;
                case MotionEvent.ACTION_MOVE:

                    if (movimiento) {
                        x = motionEvent.getRawX() - opcion.getImageView().getWidth() / 2;
                        y = motionEvent.getRawY() - opcion.getImageView().getHeight() * 3 / 2;

                        if (evaluaPosicion(relativeLayout1,x, y, opcion.getImageView())) {
                            opcion.setCorrecto(1);
                        } else if (evaluaPosicion(relativeLayout2,x, y, opcion.getImageView())) {
                            opcion.setCorrecto(2);
                        } else if (evaluaPosicion(relativeLayout3,x, y, opcion.getImageView())) {
                            opcion.setCorrecto(1);
                        } else if (evaluaPosicion(relativeLayout4, x, y, opcion.getImageView())) {
                            opcion.setCorrecto(2);
                        } else if (evaluaPosicion(relativeLayout5,x, y, opcion.getImageView())) {
                            opcion.setCorrecto(1);
                        } else if (evaluaPosicion(relativeLayout6,x, y, opcion.getImageView())) {
                            opcion.setCorrecto(2);
                        } else if (evaluaPosicion(relativeLayout7,x, y, opcion.getImageView())) {
                            opcion.setCorrecto(1);
                        } else if (evaluaPosicion(relativeLayout8,x, y, opcion.getImageView())) {
                            opcion.setCorrecto(2);
                        } else if (evaluaPosicion(relativeLayout9,x, y, opcion.getImageView())) {
                            opcion.setCorrecto(1);
                        } else if (evaluaPosicion(relativeLayout10,x, y, opcion.getImageView())) {
                            opcion.setCorrecto(2);
                        } else if (evaluaPosicion(relativeLayout11,x, y, opcion.getImageView())) {
                            opcion.setCorrecto(1);
                        } else if (evaluaPosicion(relativeLayout12,x, y, opcion.getImageView())) {
                            opcion.setCorrecto(2);
                        }
                    }
                    break;
                case MotionEvent.ACTION_UP:
                    movimiento = false;
                    break;
            }

            return true;
        }

        public boolean evaluaPosicion (RelativeLayout relativeLayout, float x, float y, ImageView imageView) {

            if (x > ((relativeLayout.getX()) - 70 + ((relativeLayout.getWidth() -imageView.getWidth()) / 2))
                    && x < (relativeLayout.getX() + 70 + ((relativeLayout.getWidth() -imageView.getWidth()) / 2)) &&
                    y > (relativeLayout.getY() - 50) &&
                    y < (relativeLayout.getY() + 50)) {
                int xAux = relativeLayout.getWidth() - imageView.getWidth();
                imageView.setX(relativeLayout.getX() + (xAux/2));
                imageView.setY(relativeLayout.getY());

                return true;
            } else {
                imageView.setX(x);
                imageView.setY(y);
                //relativeLayout.setVisibility(View.VISIBLE);
                return false;
            }
        }
    }

    public class Opcion {
        private ImageView imageView;
        private int id;
        private int correcto;

        public Opcion (ImageView imageView, int id, int correcto) {
            this.imageView = imageView;
            this.id = id;
            this.correcto = correcto;
        }

        public ImageView getImageView() {
            return imageView;
        }

        public void setImageView(ImageView imageView) {
            this.imageView = imageView;
        }

        public int getCorrecto() {
            return correcto;
        }

        public void setCorrecto(int correcto) {
            this.correcto = correcto;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
    }


    //hacer una clase para encapsular los datos que contenga el imageView, el id y el si está en posición.

}

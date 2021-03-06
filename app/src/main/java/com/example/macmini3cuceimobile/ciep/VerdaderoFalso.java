package com.example.macmini3cuceimobile.ciep;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class VerdaderoFalso extends AppCompatActivity {
    public ArrayList<DatosVerdaderoFalso> datosVerdaderoFalsos;
    private Button botonEvaluar;
    public int resultado;
    public Context contexto;
    public ListView lista;
    boolean terminar = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verdadero_falso);

        //contexto
        contexto = getApplicationContext();

        //Se inicializa la lista
        lista = (ListView) findViewById(R.id.lista_preguntas);

        //botón de evaluar
        botonEvaluar = (Button) findViewById(R.id.boton_evaluar);
        botonEvaluar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (terminar) {
                    Intent intent = new Intent(VerdaderoFalso.this, DragAndDrop.class);
                    startActivity(intent);
                    finish();
                } else {

                    resultado = evaluar(datosVerdaderoFalsos);

                    if (resultado == -1) {
                        //existen preguntas sin contestar
                        Toast.makeText(contexto,
                                "Debes contestar todas las preguntas",
                                Toast.LENGTH_LONG).show();
                    } else {
                        int incorrectas = datosVerdaderoFalsos.size() - resultado;
                        Toast.makeText(contexto,
                                "Tienes "
                                        + resultado
                                        + " respuestas correctas y "
                                        + incorrectas
                                        + " incorrectas",
                                Toast.LENGTH_LONG).show();

                        terminar = true;
                        botonEvaluar.setText("Terminar");
                    }


                }

            }
        });

        //Datos
        datosVerdaderoFalsos = new ArrayList<>();
        datosVerdaderoFalsos.add(new DatosVerdaderoFalso("Aprender una lengua desarrolla las habiliades cognitivas de la persona", false, false, true));
        datosVerdaderoFalsos.add(new DatosVerdaderoFalso("El francés se habla en los 5 continentes", false, false, true));
        datosVerdaderoFalsos.add(new DatosVerdaderoFalso("La francofonia representa el conjunto de personas que hablan lenguas provenientes del latín (español, francés, italiano, portugués).)", false, false, false));
        datosVerdaderoFalsos.add(new DatosVerdaderoFalso("En el francés existe la letra ñ como en el español", false, false, false));

        datosVerdaderoFalsos.add(new DatosVerdaderoFalso("No sólo se habla el francés en Francia", false, false, true));
        datosVerdaderoFalsos.add(new DatosVerdaderoFalso("El alfabeto español y el inglés son iguales, excepto por algunos cambios", false, false, true));
        datosVerdaderoFalsos.add(new DatosVerdaderoFalso("Después del alemán y el inglés, el francés es la tercera lengua más usada en internet", false, false, true));
        datosVerdaderoFalsos.add(new DatosVerdaderoFalso("En el mundo el francés es hablado por menos de 100 millones de personas", false, false, false));
        datosVerdaderoFalsos.add(new DatosVerdaderoFalso("Francia es el país más visitado en el mundo", false, false, true));
        datosVerdaderoFalsos.add(new DatosVerdaderoFalso("En el ingés más del 50% del vocabulario ha sido aportado por el francés", false, false, true));



        lista.setAdapter(new AdaptadorVerdaderoFalso(this, R.layout.item_verdadero_falso,datosVerdaderoFalsos));
    }

    /**
     * Clase que encapsula los datos para las preguntas
     */
    public class DatosVerdaderoFalso{

        private String texto;
        private boolean verdadero;
        private boolean falso;
        private boolean correcto;

        public DatosVerdaderoFalso (String texto, boolean verdadero, boolean falso, boolean correcto) {
            this.correcto = correcto;
            this.falso = falso;
            this.verdadero = verdadero;
            this.texto = texto;
        }

        public String getTexto(){
            return texto;
        }

        public boolean getVerdadero(){
            return verdadero;
        }

        public boolean getFalso(){
            return falso;
        }

        public boolean getCorrecto(){
            return correcto;
        }

        public void setTexto(String texto){
            this.texto = texto;
        }

        public void setVerdadero(boolean verdadero) {
            this.verdadero = verdadero;
        }

        public void setFalso(boolean falso){
            this.falso = falso;
        }

        public void setCorrecto(boolean correcto){
            this.correcto = correcto;
        }
    }

    /**
     *
     * @param datosVerdaderoFalsos
     * @return -1 incompleto
     */
    public int evaluar(ArrayList<DatosVerdaderoFalso> datosVerdaderoFalsos){
        int correctos = 0;

        for (DatosVerdaderoFalso datosVerdaderoFalso : datosVerdaderoFalsos) {

            if (datosVerdaderoFalso.getCorrecto() &&
                    (datosVerdaderoFalso.getVerdadero() == true)) {
                correctos ++;
            } else if ((datosVerdaderoFalso.getFalso() == true) &&
                    (datosVerdaderoFalso.getCorrecto() == false)) {
                correctos ++;
            } else if ((datosVerdaderoFalso.getVerdadero() == false) &&
                    (datosVerdaderoFalso.getFalso() == false)) {
                //Si se retorna -1 quiere decir que faltan preguntas por contestar
                return -1;
            }
        }

        return correctos;
    }

    /**
     * Clase que sirve de adaptador para la lista
     */
    public class AdaptadorVerdaderoFalso extends ArrayAdapter<DatosVerdaderoFalso>{
        ArrayList<DatosVerdaderoFalso> datosVerdaderoFalsos;
        Activity activity;
        public AdaptadorVerdaderoFalso(Activity activity, int resource, ArrayList<DatosVerdaderoFalso> datosVerdaderoFalsos) {
            super(activity.getApplicationContext(), resource, datosVerdaderoFalsos);
            this.datosVerdaderoFalsos = datosVerdaderoFalsos;
            this.activity = activity;

        }

        @Override
        public View getView(final int position, View view, ViewGroup parent) {
            LayoutInflater inflater = activity.getLayoutInflater();
            View rowView      = inflater.inflate(R.layout.item_verdadero_falso, null, true);
            TextView txtTitle = (TextView) rowView.findViewById(R.id.texto_pregunta);
            final CheckBox checkBoxVerdadero = (CheckBox) rowView.findViewById(R.id.check_verdadero);
            final CheckBox checkBoxFalso = (CheckBox) rowView.findViewById(R.id.check_falso);

            txtTitle.setText(datosVerdaderoFalsos.get(position).getTexto());

            checkBoxVerdadero.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    if (checkBoxVerdadero.isChecked()) {
                        datosVerdaderoFalsos.get(position).setVerdadero(true);
                        datosVerdaderoFalsos.get(position).setFalso(false);
                        checkBoxVerdadero.setChecked(true);
                        checkBoxFalso.setChecked(false);
                    } else {
                        datosVerdaderoFalsos.get(position).setVerdadero(false);
                        datosVerdaderoFalsos.get(position).setFalso(true);
                        checkBoxVerdadero.setChecked(false);
                        checkBoxFalso.setChecked(true);
                    }
                }
            });

            checkBoxFalso.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    if (checkBoxFalso.isChecked()) {
                        datosVerdaderoFalsos.get(position).setFalso(true);
                        datosVerdaderoFalsos.get(position).setVerdadero(false);
                        checkBoxFalso.setChecked(true);
                        checkBoxVerdadero.setChecked(false);
                    } else {
                        datosVerdaderoFalsos.get(position).setFalso(false);
                        datosVerdaderoFalsos.get(position).setVerdadero(true);
                        checkBoxFalso.setChecked(false);
                        checkBoxVerdadero.setChecked(true);
                    }
                }
            });

            if ((datosVerdaderoFalsos.get(position).getFalso() == false) && (datosVerdaderoFalsos.get(position).getVerdadero() == false) ) {
                //No hacer nada
            } else {

                if (datosVerdaderoFalsos.get(position).getVerdadero()) {
                    checkBoxVerdadero.setChecked(true);
                    checkBoxFalso.setChecked(false);
                } else {
                    checkBoxVerdadero.setChecked(false);
                    checkBoxFalso.setChecked(true);
                }
            }

            return rowView;
        }
    }
}
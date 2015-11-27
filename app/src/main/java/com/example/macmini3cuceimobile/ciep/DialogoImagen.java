package com.example.macmini3cuceimobile.ciep;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;

/**
* Created by Luis Raul on 27/10/2015.
        */
public class DialogoImagen extends DialogFragment {


    String imagen = "";

    static DialogoImagen newInstance() {
        DialogoImagen f = new DialogoImagen();

        // Supply num input as an argument.
        Bundle args = new Bundle();
        f.setArguments(args);

        return f;
    }

    public void setImagen(String imagen)
    {
        this.imagen= imagen;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        View v = inflater.inflate(R.layout.dialogoibook, container, false);
        ImageView imageen = (ImageView) v.findViewById(R.id.ficha);
        File carga = Environment.getExternalStoragePublicDirectory(imagen);
        Bitmap bm = BitmapFactory.decodeFile(String.valueOf(carga));
        imageen.setImageBitmap(bm);

        return v;
    }

}
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
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;

/**
* Created by Luis Raul on 27/10/2015.
        */
public class DialogoImagen extends DialogFragment {

    static DialogoImagen newInstance() {
        DialogoImagen f = new DialogoImagen();

        // Supply num input as an argument.
        Bundle args = new Bundle();
        f.setArguments(args);

        return f;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.dialogoibook, container, false);
        ImageView imageen = (ImageView) v.findViewById(R.id.imagen_ficha_aldiko);
        File carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia7/ficha_aldiko.zip");
        Bitmap bm = BitmapFactory.decodeFile(String.valueOf(carga));
        imageen.setImageBitmap(bm);

        return v;
    }

}
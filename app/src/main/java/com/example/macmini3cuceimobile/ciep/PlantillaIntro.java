package com.example.macmini3cuceimobile.ciep;

import android.app.DownloadManager;
import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import java.io.File;
import java.util.ArrayList;

public class PlantillaIntro extends AppCompatActivity {
    ArrayList<Informacion.DatosDescarga> datosDescargas;
    ImageView imageViewComenzar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plantilla_intro);

        //Botones
        imageViewComenzar = (ImageView) findViewById(R.id.plantilla_comenzar);
        imageViewComenzar.setEnabled(false);
        ///////////

        datosDescargas = Informacion.obtenerDatosGuia(Informacion.urls6);

        for (Informacion.DatosDescarga datosDescarga : datosDescargas) {
            descargar(datosDescarga.getUrl(),datosDescarga.getNombre(), datosDescarga.getIndice());
        }
    }

    public void descargar(String Url, String nombrearc, int guia) {

        File dir= Environment.getExternalStoragePublicDirectory("/.estu@pp/guia" + guia);

        if(!dir.exists()){
            dir.mkdirs();
        }

        Uri downloadLocation=Uri.fromFile(new File(dir, nombrearc));
        String serviceString = Context.DOWNLOAD_SERVICE;
        DownloadManager downloadManager;
        downloadManager = (DownloadManager)getSystemService(serviceString);
        Uri uri = Uri.parse(Url);
        DownloadManager.Request request ;
        request =  new DownloadManager.Request(uri);
        request.setDestinationUri(downloadLocation);
        downloadManager.enqueue(request);
    }

}

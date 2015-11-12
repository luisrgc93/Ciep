package com.example.macmini3cuceimobile.ciep;

import android.app.AlertDialog;
import android.app.DownloadManager;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;
import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class MainActivity extends AppCompatActivity {
    FragmentTransaction Ft;
    DialogoImagen DI;
    private final String NAMESPACE = "http://webservice/Logon.wsdl";
    private final String URL = "http://148.202.105.181/WebServiceLogon/WebServiceLogon";
    private final String SOAP_ACTION = "http://webservice/Logon.wsdl/valida";
    private final String METHOD_NAME = "valida";
    String usuario=null;
    String password=null;
    private static String key="UdGSIIAUWebServiceValidaUsuario";
    String temp=null;
    String salto=System.getProperty("line.separator");
    Boolean confirmacion=false;
    Boolean logeo=false;
    Boolean guia=false;
    String situacion1=null;
    String codigo1=null;
    String nombre1=null;
    String centro1=null;
    String carrera1=null;
    String departamento1=null;
    String situacion3=null;
    String codigo3=null;
    String nombre3=null;
    String centro3=null;
    String carrera3=null;
    String usuario3=null;
    String password3=null;
    String password32=null;
    String linea=null;
    String total="";
    EditText Usuario;
    EditText Contraseña;
    EditText situacion;
    EditText departamento;
    EditText codigo;
    EditText nombre;
    EditText centro;
    EditText carrera;
    EditText codigo4;
    EditText nombre4;
    EditText centro4;
    EditText carrera4;
    EditText usuario4;
    EditText contraseña4;
    EditText contraseña5;
    TextView op1_1;
    TextView op1_2;
    TextView op1_3;
    TextView op1_4;
    TextView op2_1;
    TextView op2_2;
    TextView op2_3;
    TextView op2_4;
    TextView op3_1;
    TextView op3_2;
    TextView op3_3;
    TextView op3_4;
    TextView op4_1;
    TextView op4_2;
    TextView op4_3;
    TextView op4_4;
    TextView op5_1;
    TextView op5_2;
    TextView op5_3;
    TextView op5_4;
    TextView op6_1;
    TextView op6_2;
    TextView op6_3;
    TextView op6_4;
    TextView op7_1;
    TextView op7_2;
    TextView op7_3;
    TextView op7_4;
    TextView op8_1;
    TextView op8_2;
    TextView op8_3;
    TextView op8_4;
    TextView op9_1;
    TextView op9_2;
    TextView op9_3;
    TextView op9_4;
    TextView op10_1;
    TextView op10_2;
    TextView op10_3;
    TextView op10_4;
    TextView op11_1;
    TextView op11_2;
    TextView op11_3;
    TextView op11_4;
    TextView op12_1;
    TextView op12_2;
    TextView op12_3;
    TextView op12_4;
    TextView op13_1;
    TextView op13_2;
    TextView op13_3;
    TextView op13_4;
    TextView op14_1;
    TextView op14_2;
    TextView op14_3;
    TextView op14_4;
    TextView op15_1;
    TextView op15_2;
    TextView op15_3;
    TextView op15_4;
    Button entrar21;
    Button entrar1;
    Button registrar1;
    Button siguiente1;
    Button cancelar1;
    Button regresar1;
    Button cerrar1;
    Button cerrar3;
    File ruta= Environment.getExternalStoragePublicDirectory("/.estu@pp/");
    File rutaguia8= Environment.getExternalStoragePublicDirectory("/.estu@pp/guia8/");
    File nomar = new File(ruta.getAbsolutePath(), "registros.txt");
    File temploggeo = new File(ruta.getAbsolutePath(), "loggeo.txt");
    File guardadatosnum = new File(rutaguia8.getAbsolutePath(), "Datos Numericos.txt");
    Spinner sp;
    int pos;
    String[ ] array = {"Activo","Egresado","Trabajador"};
    int numguia=0;
    VideoView mVideoView;
    ImageView mImageView;
    MediaPlayer aud=null;
    int numaudguia8=0;
    int correctas8=0;
    float correctas9=0;
    int TIEMPO = 1500;
    Boolean seleccion8=false;
    int pregunta=0;
    int preguntas9[][]={{0,0},{0,0},{0,0},{0,0},{0,0},{0,0},{0,0}};
    Menu menu;
    MenuItem opcion1;
    MenuItem opcion2;
    MenuItem submenu1;
    MenuItem submenu3;
    MenuItem submenu5;
    MenuItem submenu6;
    MenuItem submenu7;
    MenuItem submenu8;
    MenuItem submenu9;
    MenuItem submenu10;
    MenuItem submenu11;
    int ventana_datosnum=0;
    ImageView imagenguia9;
    Boolean descarga=false;
    int numar=0;
    File carga=null;

                                    //COMIENZO DE LAS VARIABLES DE LAS GUIAS

    //VARIABLES GUIA 1 FRANCES
    int ventana_frances;
    LinearLayout fondo1_pantalla1_frances;
    ImageView imagen1_pantalla1_frances;
    ImageView imagen2_pantalla1_frances;
    ImageView comenzar_frances;
    ImageView imagen1_pantalla2_frances;
    ImageView imagen1_pantalla3_frances;
    ImageView imagen1_pantalla4_frances;
    ImageView imagen1_pantalla5_frances;
    ImageView imagen1_pantalla6_frances;
    ImageView imagen1_pantalla7_frances;
    ImageView imagen1_pantalla8_frances;
    ImageView imagen1_pantalla9_frances;
    ImageView imagen1_pantalla10_frances;
    ImageView imagen1_pantalla11_frances;
    ImageView imagen1_pantalla13_frances;
    ImageView imagen1_pantalla14_frances;
    ImageView imagen1_pantalla15_frances;
    ImageView imagen1_pantalla16_frances;
    ImageView imagen1_pantalla17_frances;
    ImageView imagen1_pantalla18_frances;
    ImageView imagen1_pantalla19_frances;
    ImageView imagen1_pantalla20_frances;
    ImageView imagen1_pantalla21_frances;
    ImageView imagen1_pantalla22_frances;
    ImageView imagen1_pantalla23_frances;
    ImageView boton_siguiente_frances;
    ImageView boton_anterior_frances;
    ImageView Salir_Frances;
    ImageView imagen_bocina;


    //VARIABLES GUIA 8 DATOS NUMERICOS
    LinearLayout fondo1_pantalla1_datosnumericos;
    ImageView imagen1_pantalla1_datosnumericos;
    ImageView imagen2_pantalla1_datosnumericos;
    ImageView imagen1_pantalla2_datosnumericos;
    ImageView imagen2_pantalla2_datosnumericos;
    ImageView imagen3_pantalla2_datosnumericos;
    ImageView imagen4_pantalla2_datosnumericos;
    ImageView imagen5_pantalla2_datosnumericos;
    ImageView imagen6_pantalla2_datosnumericos;
    ImageView imagen1_pantalla3_datosnumericos;
    ImageView imagen2_pantalla3_datosnumericos;
    ImageView imagen3_pantalla3_datosnumericos;
    ImageView imagen4_pantalla3_datosnumericos;
    ImageView imagen1_pantalla4_datosnumericos;
    ImageView imagen2_pantalla4_datosnumericos;
    ImageView imagen3_pantalla4_datosnumericos;
    ImageView imagen4_pantalla4_datosnumericos;
    ImageView imagen1_pantalla5_datosnumericos;
    ImageView imagen2_pantalla5_datosnumericos;
    ImageView imagen3_pantalla5_datosnumericos;
    ImageView imagen4_pantalla5_datosnumericos;
    ImageView imagen1_pantalla6_datosnumericos;
    ImageView imagen2_pantalla6_datosnumericos;
    ImageView imagen3_pantalla6_datosnumericos;
    ImageView imagen4_pantalla6_datosnumericos;
    ImageView imagen1_pantalla7_datosnumericos;
    ImageView imagen2_pantalla7_datosnumericos;
    ImageView imagen3_pantalla7_datosnumericos;
    ImageView imagen4_pantalla7_datosnumericos;
    ImageView imagen1_pantalla8_datosnumericos;
    ImageView imagen2_pantalla8_datosnumericos;
    ImageView imagen3_pantalla8_datosnumericos;
    ImageView imagen4_pantalla8_datosnumericos;
    ImageView imagen1_pantalla9_datosnumericos;
    ImageView imagen2_pantalla9_datosnumericos;
    ImageView imagen3_pantalla9_datosnumericos;
    ImageView imagen4_pantalla9_datosnumericos;
    ImageView imagen5_pantalla9_datosnumericos;
    ImageView imagen1_pantalla10_datosnumericos;
    ImageView imagen2_pantalla10_datosnumericos;
    ImageView imagen3_pantalla10_datosnumericos;
    ImageView imagen4_pantalla10_datosnumericos;
    ImageView imagen1_pantalla11_datosnumericos;
    ImageView imagen2_pantalla11_datosnumericos;
    ImageView imagen3_pantalla11_datosnumericos;
    ImageView imagen4_pantalla11_datosnumericos;
    ImageView imagen1_pantalla12_datosnumericos;
    ImageView imagen2_pantalla12_datosnumericos;
    ImageView imagen3_pantalla12_datosnumericos;
    ImageView imagen4_pantalla12_datosnumericos;
    LinearLayout fondo1_pantalla13_datosnumericos;
    ImageView imagen1_pantalla13_datosnumericos;
    ImageView imagen2_pantalla13_datosnumericos;
    ImageView imagen3_pantalla13_datosnumericos;
    ImageView imagen1_pantalla14_datosnumericos;
    ImageView imagen2_pantalla14_datosnumericos;
    ImageView imagen1_pantalla15_datosnumericos;
    ImageView imagen2_pantalla15_datosnumericos;
    ImageView imagen1_pantalla16_datosnumericos;
    ImageView imagen2_pantalla16_datosnumericos;
    ImageView imagen1_pantalla17_datosnumericos;
    ImageView imagen2_pantalla17_datosnumericos;
    ImageView imagen1_pantalla18_datosnumericos;
    ImageView imagen2_pantalla18_datosnumericos;
    ImageView imagen3_pantalla18_datosnumericos;
    ImageView imagen1_pantalla19_datosnumericos;
    ImageView imagen2_pantalla19_datosnumericos;
    ImageView imagen3_pantalla19_datosnumericos;
    ImageView imagen1_pantalla20_datosnumericos;
    ImageView imagen2_pantalla20_datosnumericos;
    ImageView imagen3_pantalla20_datosnumericos;
    ImageView imagen1_pantalla21_datosnumericos;
    ImageView imagen2_pantalla21_datosnumericos;
    ImageView imagen3_pantalla21_datosnumericos;
    ImageView imagen1_pantalla22_datosnumericos;
    ImageView imagen2_pantalla22_datosnumericos;
    ImageView imagen3_pantalla22_datosnumericos;
    ImageView imagen1_pantalla23_datosnumericos;
    ImageView imagen2_pantalla23_datosnumericos;
    ImageView imagen3_pantalla23_datosnumericos;
    ImageView imagen1_pantalla24_datosnumericos;
    ImageView imagen2_pantalla24_datosnumericos;
    ImageView imagen3_pantalla24_datosnumericos;
    ImageView imagen1_pantalla25_datosnumericos;
    ImageView imagen2_pantalla25_datosnumericos;
    ImageView imagen3_pantalla25_datosnumericos;
    ImageView imagen1_pantalla26_datosnumericos;
    ImageView imagen2_pantalla26_datosnumericos;
    ImageView imagen3_pantalla26_datosnumericos;
    ImageView imagen1_pantalla27_datosnumericos;
    ImageView imagen2_pantalla27_datosnumericos;
    ImageView imagen3_pantalla27_datosnumericos;
    ImageView imagen1_pantalla28_datosnumericos;
    ImageView imagen2_pantalla28_datosnumericos;
    ImageView imagen3_pantalla28_datosnumericos;
    ImageView imagen4_pantalla28_datosnumericos;
    ImageView estrella1_pantalla28_datosnumericos;
    ImageView estrella2_pantalla28_datosnumericos;
    ImageView estrella3_pantalla28_datosnumericos;
    ImageView estrella4_pantalla28_datosnumericos;
    ImageView estrella5_pantalla28_datosnumericos;
    TextView texto1_pantalla28_datosnumericos;
    TextView texto2_pantalla28_datosnumericos;
    TextView texto3_pantalla28_datosnumericos;
    ImageView imagen1_pantalla29_datosnumericos;
    File au;
    //VARIABLES GUIA 12 FOROS VIRTUALES
    int ventana_foros;
    LinearLayout fondo1_pantalla1_forosvirtuales;
    ImageView imagen1_pantalla1_forosvirtuales;
    LinearLayout fondo2_pantalla1_forosvirtuales;
    ImageView comenzar_forosvirtuales;
    ImageView imagen1_pantalla2_forosvirtuales;
    ImageView imagen2_pantalla2_forosvirtuales;
    LinearLayout fondo1_pantalla2_forosvirtuales;
    ImageView menu_forosvirtuales;
    ImageView fondo1_pantalla3_forosvirtuales;
    ImageView imagen1_pantalla3_forosvirtuales;
    ImageView imagen2_pantalla3_forosvirtuales;
    ImageView imagen3_pantalla3_forosvirtuales;
    ImageView imagen4_pantalla3_forosvirtuales;
    ImageView fondo1_pantalla4_forosvirtuales;
    ImageView imagen1_pantalla4_forosvirtuales;
    ImageView imagen2_pantalla4_forosvirtuales;
    ImageView imagen3_pantalla4_forosvirtuales;
    ImageView imagen4_pantalla4_forosvirtuales;
    ImageView imagen5_pantalla4_forosvirtuales;
    ImageView fondo1_pantalla5_forosvirtuales;
    ImageView imagen1_pantalla5_forosvirtuales;
    ImageView imagen2_pantalla5_forosvirtuales;
    ImageView imagen3_pantalla5_forosvirtuales;
    ImageView imagen4_pantalla5_forosvirtuales;
    ImageView imagen5_pantalla5_forosvirtuales;
    ImageView imagen1_pantalla6_forosvirtuales;
    ImageView imagen2_pantalla6_forosvirtuales;
    ImageView imagen3_pantalla6_forosvirtuales;
    ImageView imagen4_pantalla6_forosvirtuales;
    ImageView imagen5_pantalla6_forosvirtuales;
    ImageView fondo1_pantalla7_forosvirtuales;
    ImageView imagen1_pantalla7_forosvirtuales;
    ImageView imagen2_pantalla7_forosvirtuales;
    ImageView imagen3_pantalla7_forosvirtuales;
    ImageView imagen4_pantalla7_forosvirtuales;
    ImageView imagen5_pantalla7_forosvirtuales;
    ImageView imagen1_pantalla8_forosvirtuales;
    ImageView imagen2_pantalla8_forosvirtuales;
    ImageView imagen3_pantalla8_forosvirtuales;
    ImageView imagen4_pantalla8_forosvirtuales;
    ImageView imagen5_pantalla8_forosvirtuales;
    ImageView fondo1_pantalla9_forosvirtuales;
    ImageView imagen1_pantalla9_forosvirtuales;
    ImageView imagen2_pantalla9_forosvirtuales;
    ImageView imagen3_pantalla9_forosvirtuales;
    ImageView imagen4_pantalla9_forosvirtuales;
    ImageView fondo1_pantalla10_forosvirtuales;
    ImageView imagen1_pantalla10_forosvirtuales;
    ImageView imagen2_pantalla10_forosvirtuales;
    ImageView imagen3_pantalla10_forosvirtuales;
    ImageView imagen4_pantalla10_forosvirtuales;
    ImageView imagen5_pantalla10_forosvirtuales;
    ImageView fondo1_pantalla11_forosvirtuales;
    ImageView imagen1_pantalla11_forosvirtuales;
    ImageView imagen2_pantalla11_forosvirtuales;
    ImageView imagen3_pantalla11_forosvirtuales;
    ImageView imagen4_pantalla11_forosvirtuales;
    ImageView fondo1_pantalla12_forosvirtuales;
    ImageView imagen1_pantalla12_forosvirtuales;
    ImageView imagen2_pantalla12_forosvirtuales;
    ImageView imagen3_pantalla12_forosvirtuales;
    ImageView imagen4_pantalla12_forosvirtuales;
    ImageView fondo1_pantalla13_forosvirtuales;
    ImageView imagen1_pantalla13_forosvirtuales;
    ImageView imagen2_pantalla13_forosvirtuales;
    ImageView imagen3_pantalla13_forosvirtuales;
    ImageView imagen4_pantalla13_forosvirtuales;
    ImageView fondo1_pantalla14_forosvirtuales;
    ImageView imagen1_pantalla14_forosvirtuales;
    ImageView imagen2_pantalla14_forosvirtuales;
    ImageView imagen3_pantalla14_forosvirtuales;
    ImageView imagen4_pantalla14_forosvirtuales;
    ImageView fondo1_pantalla15_forosvirtuales;
    ImageView imagen1_pantalla15_forosvirtuales;
    ImageView imagen2_pantalla15_forosvirtuales;
    ImageView imagen3_pantalla15_forosvirtuales;
    ImageView imagen4_pantalla15_forosvirtuales;
    ImageView imagen1_pantalla16_forosvirtuales;
    ImageView imagen2_pantalla16_forosvirtuales;
    LinearLayout fondo1_pantalla16_forosvirtuales;
    ImageView salir_forosvirtuales;
    //VARIABLES GUIA CAPACIDADES PARA EL APRENDIZAJE
    int ventana_capacidades;
    LinearLayout fondo1_pantalla1_capacidadesparaelaprendizaje;
    ImageView imagen1_pantalla1_capacidadesparaelaprendizaje;
    ImageView comenzar_capacidadesparaelaprendizaje;
    ImageView imagen1_pantalla2_capacidadesparaelaprendizaje;
    ImageView menu_pantallas2_capacidadesparaelaprendizaje;
    ImageView imagen2_pantalla2_capacidadesparaelaprendizaje;
    ImageView imagen3_pantalla2_capacidadesparaelaprendizaje;
    ImageView imagen4_pantalla2_capacidadesparaelaprendizaje;
    ImageView imagen5_pantalla2_capacidadesparaelaprendizaje;
    ImageView imagen6_pantalla2_capacidadesparaelaprendizaje;
    ImageView imagen1_pantalla3_capacidadesparaelaprendizaje;
    ImageView imagen2_pantalla3_capacidadesparaelaprendizaje;
    ImageView imagen3_pantalla3_capacidadesparaelaprendizaje;
    ImageView imagen4_pantalla3_capacidadesparaelaprendizaje;
    ImageView imagen5_pantalla3_capacidadesparaelaprendizaje;
    ImageView imagen6_pantalla3_capacidadesparaelaprendizaje;
    ImageView imagen1_pantalla4_capacidadesparaelaprendizaje;
    ImageView imagen2_pantalla4_capacidadesparaelaprendizaje;
    ImageView imagen3_pantalla4_capacidadesparaelaprendizaje;
    ImageView imagen4_pantalla4_capacidadesparaelaprendizaje;
    ImageView imagen5_pantalla4_capacidadesparaelaprendizaje;
    ImageView imagen6_pantalla4_capacidadesparaelaprendizaje;
    ImageView imagen1_pantalla5_capacidadesparaelaprendizaje;
    ImageView fondo1_pantalla5_capacidadesparaelaprendizaje;
    ImageView imagen2_pantalla5_capacidadesparaelaprendizaje;
    ImageView imagen3_pantalla5_capacidadesparaelaprendizaje;
    ImageView imagen4_pantalla5_capacidadesparaelaprendizaje;
    ImageView imagen5_pantalla5_capacidadesparaelaprendizaje;
    ImageView imagen6_pantalla5_capacidadesparaelaprendizaje;
    ImageView imagen1_pantalla6_capacidadesparaelaprendizaje;
    ImageView fondo1_pantalla6_capacidadesparaelaprendizaje;
    ImageView imagen2_pantalla6_capacidadesparaelaprendizaje;
    ImageView imagen3_pantalla6_capacidadesparaelaprendizaje;
    ImageView imagen4_pantalla6_capacidadesparaelaprendizaje;
    ImageView imagen5_pantalla6_capacidadesparaelaprendizaje;
    ImageView imagen6_pantalla6_capacidadesparaelaprendizaje;
    ImageView imagen7_pantalla6_capacidadesparaelaprendizaje;
    ImageView imagen1_pantalla7_capacidadesparaelaprendizaje;
    ImageView fondo1_pantalla7_capacidadesparaelaprendizaje;
    ImageView imagen2_pantalla7_capacidadesparaelaprendizaje;
    ImageView imagen3_pantalla7_capacidadesparaelaprendizaje;
    ImageView imagen4_pantalla7_capacidadesparaelaprendizaje;
    ImageView imagen5_pantalla7_capacidadesparaelaprendizaje;
    ImageView imagen6_pantalla7_capacidadesparaelaprendizaje;
    ImageView imagen7_pantalla7_capacidadesparaelaprendizaje;
    ImageView imagen8_pantalla7_capacidadesparaelaprendizaje;
    ImageView imagen1_pantalla8_capacidadesparaelaprendizaje;
    ImageView fondo1_pantalla8_capacidadesparaelaprendizaje;
    ImageView imagen2_pantalla8_capacidadesparaelaprendizaje;
    ImageView imagen3_pantalla8_capacidadesparaelaprendizaje;
    ImageView imagen4_pantalla8_capacidadesparaelaprendizaje;
    ImageView imagen5_pantalla8_capacidadesparaelaprendizaje;
    ImageView imagen6_pantalla8_capacidadesparaelaprendizaje;
    ImageView imagen7_pantalla8_capacidadesparaelaprendizaje;
    ImageView imagen8_pantalla8_capacidadesparaelaprendizaje;
    ImageView imagen9_pantalla8_capacidadesparaelaprendizaje;
    ImageView imagen1_pantalla9_capacidadesparaelaprendizaje;
    ImageView fondo1_pantalla9_capacidadesparaelaprendizaje;
    ImageView imagen2_pantalla9_capacidadesparaelaprendizaje;
    ImageView imagen3_pantalla9_capacidadesparaelaprendizaje;
    ImageView imagen4_pantalla9_capacidadesparaelaprendizaje;
    ImageView imagen5_pantalla9_capacidadesparaelaprendizaje;
    ImageView imagen6_pantalla9_capacidadesparaelaprendizaje;
    ImageView imagen7_pantalla9_capacidadesparaelaprendizaje;
    ImageView imagen8_pantalla9_capacidadesparaelaprendizaje;
    ImageView imagen9_pantalla9_capacidadesparaelaprendizaje;
    ImageView imagen10_pantalla9_capacidadesparaelaprendizaje;
    ImageView imagen1_pantalla10_capacidadesparaelaprendizaje;
    ImageView fondo1_pantalla10_capacidadesparaelaprendizaje;
    ImageView imagen2_pantalla10_capacidadesparaelaprendizaje;
    ImageView imagen3_pantalla10_capacidadesparaelaprendizaje;
    ImageView imagen4_pantalla10_capacidadesparaelaprendizaje;
    ImageView imagen5_pantalla10_capacidadesparaelaprendizaje;
    ImageView imagen6_pantalla10_capacidadesparaelaprendizaje;
    ImageView imagen7_pantalla10_capacidadesparaelaprendizaje;
    ImageView imagen8_pantalla10_capacidadesparaelaprendizaje;
    ImageView imagen9_pantalla10_capacidadesparaelaprendizaje;
    ImageView imagen10_pantalla10_capacidadesparaelaprendizaje;
    ImageView imagen11_pantalla10_capacidadesparaelaprendizaje;
    ImageView imagen1_pantalla11_capacidadesparaelaprendizaje;
    ImageView fondo1_pantalla11_capacidadesparaelaprendizaje;
    ImageView imagen2_pantalla11_capacidadesparaelaprendizaje;
    ImageView imagen3_pantalla11_capacidadesparaelaprendizaje;
    ImageView imagen4_pantalla11_capacidadesparaelaprendizaje;
    ImageView imagen5_pantalla11_capacidadesparaelaprendizaje;
    ImageView imagen6_pantalla11_capacidadesparaelaprendizaje;
    ImageView imagen7_pantalla11_capacidadesparaelaprendizaje;
    ImageView imagen8_pantalla11_capacidadesparaelaprendizaje;
    ImageView imagen9_pantalla11_capacidadesparaelaprendizaje;
    ImageView imagen10_pantalla11_capacidadesparaelaprendizaje;
    ImageView imagen11_pantalla11_capacidadesparaelaprendizaje;
    ImageView imagen12_pantalla11_capacidadesparaelaprendizaje;
    ImageView imagen1_pantalla12_capacidadesparaelaprendizaje;
    ImageView imagen2_pantalla12_capacidadesparaelaprendizaje;
    ImageView imagen3_pantalla12_capacidadesparaelaprendizaje;
    ImageView imagen4_pantalla12_capacidadesparaelaprendizaje;
    ImageView imagen5_pantalla12_capacidadesparaelaprendizaje;
    ImageView imagen6_pantalla12_capacidadesparaelaprendizaje;
    ImageView imagen1_pantalla13_capacidadesparaelaprendizaje;
    ImageView imagen2_pantalla13_capacidadesparaelaprendizaje;
    ImageView imagen3_pantalla13_capacidadesparaelaprendizaje;
    ImageView imagen4_pantalla13_capacidadesparaelaprendizaje;
    ImageView imagen5_pantalla13_capacidadesparaelaprendizaje;
    ImageView imagen1_pantalla14_capacidadesparaelaprendizaje;
    ImageView imagen2_pantalla14_capacidadesparaelaprendizaje;
    ImageView imagen3_pantalla14_capacidadesparaelaprendizaje;
    ImageView imagen4_pantalla14_capacidadesparaelaprendizaje;
    ImageView imagen5_pantalla14_capacidadesparaelaprendizaje;
    ImageView imagen6_pantalla14_capacidadesparaelaprendizaje;
    ImageView imagen7_pantalla14_capacidadesparaelaprendizaje;
    ImageView imagen8_pantalla14_capacidadesparaelaprendizaje;
    ImageView imagen9_pantalla14_capacidadesparaelaprendizaje;
    ImageView imagen10_pantalla14_capacidadesparaelaprendizaje;
    ImageView imagen11_pantalla14_capacidadesparaelaprendizaje;
    //VARIABLES GUIA 10 HABILIDADES DE LECTURA
    int ventana_habilidadesdelectura;
    LinearLayout fondo1_pantalla1_habilidadesdelectura;
    ImageView imagen1_pantalla1_habilidadesdelectura;
    ImageView imagen2_pantalla1_habilidadesdelectura;
    ImageView comenzar_habilidadesdelectura;
    ImageView imagen1_pantalla2_habilidadesdelectura;
    ImageView imagen2_pantalla2_habilidadesdelectura;
    ImageView imagen3_pantalla2_habilidadesdelectura;
    ImageView imagen1_pantalla3_habilidadesdelectura;
    ImageView imagen2_pantalla3_habilidadesdelectura;
    ImageView imagen3_pantalla3_habilidadesdelectura;
    ImageView imagen1_pantalla4_habilidadesdelectura;
    ImageView imagen2_pantalla4_habilidadesdelectura;
    ImageView imagen3_pantalla4_habilidadesdelectura;
    ImageView imagen4_pantalla4_habilidadesdelectura;
    ImageView imagen1_pantalla5_habilidadesdelectura;
    ImageView imagen2_pantalla5_habilidadesdelectura;
    ImageView imagen3_pantalla5_habilidadesdelectura;
    ImageView imagen1_pantalla6_habilidadesdelectura;
    ImageView imagen2_pantalla6_habilidadesdelectura;
    ImageView imagen3_pantalla6_habilidadesdelectura;
    ImageView imagen1_pantalla7_habilidadesdelectura;
    ImageView imagen2_pantalla7_habilidadesdelectura;
    ImageView imagen3_pantalla7_habilidadesdelectura;
    ImageView imagen1_pantalla8_habilidadesdelectura;
    ImageView imagen2_pantalla8_habilidadesdelectura;
    ImageView imagen3_pantalla8_habilidadesdelectura;
    ImageView imagen1_pantalla9_habilidadesdelectura;
    ImageView imagen2_pantalla9_habilidadesdelectura;
    ImageView imagen3_pantalla9_habilidadesdelectura;
    ImageView imagen4_pantalla9_habilidadesdelectura;
    ImageView imagen1_pantalla10_habilidadesdelectura;
    ImageView imagen2_pantalla10_habilidadesdelectura;
    ImageView imagen3_pantalla10_habilidadesdelectura;
    ImageView imagen1_pantalla11_habilidadesdelectura;
    ImageView imagen2_pantalla11_habilidadesdelectura;
    ImageView imagen3_pantalla11_habilidadesdelectura;
    ImageView imagen1_pantalla12_habilidadesdelectura;
    ImageView imagen2_pantalla12_habilidadesdelectura;
    ImageView imagen3_pantalla12_habilidadesdelectura;
    ImageView imagen1_pantalla13_habilidadesdelectura;
    ImageView imagen2_pantalla13_habilidadesdelectura;
    ImageView imagen3_pantalla13_habilidadesdelectura;
    ImageView imagen1_pantalla14_habilidadesdelectura;
    ImageView imagen2_pantalla14_habilidadesdelectura;
    ImageView imagen3_pantalla14_habilidadesdelectura;
    ImageView imagen1_pantalla15_habilidadesdelectura;
    ImageView imagen2_pantalla15_habilidadesdelectura;
    ImageView imagen3_pantalla15_habilidadesdelectura;
    ImageView imagen1_pantalla16_habilidadesdelectura;
    ImageView imagen2_pantalla16_habilidadesdelectura;
    ImageView imagen3_pantalla16_habilidadesdelectura;
    ImageView imagen1_pantalla17_habilidadesdelectura;
    ImageView imagen2_pantalla17_habilidadesdelectura;
    ImageView imagen3_pantalla17_habilidadesdelectura;
    ImageView imagen1_pantalla18_habilidadesdelectura;

    //VARIABLES GUIA 3 ADMINISTRACION DEL TIEMPO
    int ventana_administraciondeltiempo;
    LinearLayout fondo1_pantalla1_administraciondeltiempo;
    ImageView imagen1_pantalla1_administraciondeltiempo;
    ImageView comenzar_administraciondeltiempo;
    int ventana_estres;
    LinearLayout fondo1_pantalla1_estres;
    ImageView imagen1_pantalla1_estres;
    ImageView comenzar_estres;
    int ventana_mapasmentales;
    LinearLayout fondo1_pantalla1_mapasmentales;
    ImageView imagen1_pantalla1_mapasmentales;
    ImageView imagen2_pantalla1_mapasmentales;
    ImageView comenzar_mapasmentales;
    //VARIABLES GUIA 7 IMPORTANCIA DEL INGLES
    int ventana_importanciadelingles;
    LinearLayout fondo1_pantalla1_importanciadelingles;
    ImageView imagen1_pantalla1_importanciadelingles;
    ImageView imagen2_pantalla1_importanciadelingles;
    ImageView comenzar_importanciadelingles;
    ImageView imagen1_pantalla2_importanciadelingles;
    ImageView imagen2_pantalla2_importanciadelingles;
    ImageView imagen3_pantalla2_importanciadelingles;
    ImageView imagen4_pantalla2_importanciadelingles;
    ImageView imagen5_pantalla2_importanciadelingles;
    ImageView imagen1_pantalla3_importanciadelingles;
    ImageView imagen2_pantalla3_importanciadelingles;
    ImageView imagen3_pantalla3_importanciadelingles;
    ImageView imagen4_pantalla3_importanciadelingles;
    ImageView imagen5_pantalla3_importanciadelingles;
    ImageView imagen1_pantalla4_importanciadelingles;
    ImageView imagen2_pantalla4_importanciadelingles;
    ImageView imagen3_pantalla4_importanciadelingles;
    ImageView imagen4_pantalla4_importanciadelingles;
    ImageView imagen5_pantalla4_importanciadelingles;
    ImageView imagen6_pantalla4_importanciadelingles;
    ImageView imagen7_pantalla4_importanciadelingles;
    ImageView imagen8_pantalla4_importanciadelingles;
    ImageView imagen9_pantalla4_importanciadelingles;
    ImageView imagen10_pantalla4_importanciadelingles;
    ImageView imagen11_pantalla4_importanciadelingles;
    ImageView imagen12_pantalla4_importanciadelingles;
    ImageView imagen13_pantalla4_importanciadelingles;
    ImageView imagen14_pantalla4_importanciadelingles;
    ImageView imagen15_pantalla4_importanciadelingles;
    ImageView imagen16_pantalla4_importanciadelingles;
    ImageView imagen17_pantalla4_importanciadelingles;
    ImageView imagen18_pantalla4_importanciadelingles;
    ImageView imagen19_pantalla4_importanciadelingles;
    ImageView imagen20_pantalla4_importanciadelingles;
    ImageView imagen21_pantalla4_importanciadelingles;
    ImageView imagen22_pantalla4_importanciadelingles;
    ImageView imagen23_pantalla4_importanciadelingles;
    ImageView imagen2_1_fichaaldiko_pantalla4_importanciadelingles;
    ImageView imagen1_pantalla5_importanciadelingles;
    ImageView imagen2_pantalla5_importanciadelingles;
    ImageView imagen3_pantalla5_importanciadelingles;

    Boolean mensaje9=false;
    Bitmap bm;
    BitmapDrawable bmDrawable;
FragmentManager fm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Ft = getSupportFragmentManager().beginTransaction();

        fm = getSupportFragmentManager();
        super.onCreate(savedInstanceState);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        this.menu=menu;
        opcion1= menu.findItem(R.id.cerrar_sesion);
        opcion2= menu.findItem(R.id.datos);
        opcion1.setVisible(false);
        opcion2.setVisible(false);
        submenu1=menu.findItem(R.id.menuguia1);
        submenu1.setVisible(false);
        submenu3=menu.findItem(R.id.menuguia3);
        submenu3.setVisible(false);
        submenu5=menu.findItem(R.id.menuguia5);
        submenu5.setVisible(false);
        submenu6=menu.findItem(R.id.menuguia6);
        submenu6.setVisible(false);
        submenu7=menu.findItem(R.id.menuguia7);
        submenu7.setVisible(false);
        submenu8=menu.findItem(R.id.menuguia8);
        submenu8.setVisible(false);
        submenu9=menu.findItem(R.id.menuguia9);
        submenu9.setIcon(R.drawable.icono_menu);
        submenu9.setVisible(false);
        submenu10=menu.findItem(R.id.menuguia10);
        submenu10.setIcon(R.drawable.icono_menu);
        submenu10.setVisible(false);
        submenu11=menu.findItem(R.id.menuguia11);
        submenu11.setIcon(R.drawable.icono_menu);
        submenu11.setVisible(false);
        if(temploggeo.exists()==false){
            if(nomar.exists()==false)
            {
                try
                {
                    ruta.mkdirs();
                    OutputStreamWriter archivo = new OutputStreamWriter(new FileOutputStream(nomar));
                    archivo.close();
                }
                catch (Exception ex)
                {
                    Log.e("Ficheros", "Error al escribir fichero a memoria interna");
                }
            }
            setContentView(R.layout.activity_main);
            if(validaVersion()==true){
                video(1);
            }
            else{
                imagen(1);
            }
            getSupportActionBar().setSubtitle("");
        }
        else{
            logeo=true;
            numguia=0;
            validaTemp();
            setContentView(R.layout.guias);
            try {
                titulo(numguia);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.regresa_inicio) {
            ventana_datosnum=2;
            aud.stop();
            numaudguia8=2;
            correctas8=0;
            validaVentana8();
            validaudio(ventana_datosnum);
            return true;
        }
        if (id == R.id.regresa_guias1) {
            setContentView(R.layout.guias);
            guia = false;
            numguia=0;
            try {
                titulo(numguia);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            return true;
        }
        if (id == R.id.regresa_guias3) {
            setContentView(R.layout.guias);
            guia = false;
            numguia=0;
            try {
                titulo(numguia);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            return true;
        }
        if (id == R.id.regresa_guias5) {
            setContentView(R.layout.guias);
            guia = false;
            numguia=0;
            try {
                titulo(numguia);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            return true;
        }
        if (id == R.id.regresa_guias6) {
            setContentView(R.layout.guias);
            guia = false;
            numguia=0;
            try {
                titulo(numguia);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            return true;
        }
        if (id == R.id.regresa_guias7) {
            setContentView(R.layout.guias);
            guia = false;
            numguia=0;
            try {
                titulo(numguia);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            return true;
        }
        if (id == R.id.regresa_guias8) {
            setContentView(R.layout.guias);
            guia = false;
            if(ventana_datosnum<=13){
                aud.stop();
            }
            numaudguia8=0;
            numguia=0;
            correctas8=0;
            ventana_datosnum=0;
            try {
                titulo(numguia);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            return true;
        }
        if (id == R.id.regresa_guias9) {
            setContentView(R.layout.guias);
            guia = false;
            numguia=0;
            try {
                titulo(numguia);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            for(int i=0; i<7; i++){
                for(int j=0; j<2; j++){
                    preguntas9[i][j]=0;
                }
            }
            correctas9=0;
            return true;
        }
        if (id == R.id.regresa_guias10) {
            setContentView(R.layout.guias);
            guia = false;
            numguia=0;
            try {
                titulo(numguia);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            return true;
        }
        if (id == R.id.regresa_guias11) {
            setContentView(R.layout.guias);
            guia = false;
            numguia=0;
            try {
                titulo(numguia);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            return true;
        }
        if (id == R.id.guarda_datosnum) {
            if(guardadatosnum.exists()==false)
            {
                try
                {
                    OutputStreamWriter archivo = new OutputStreamWriter(
                            new FileOutputStream(guardadatosnum));
                    archivo.close();
                }
                catch (Exception ex)
                {
                    Log.e("Ficheros", "Error al escribir fichero a memoria interna");
                }
            }
            agregadatosnum();
            return true;
        }
        if(id==R.id.datos){
            carga();
            return true;
        }
        if(id==R.id.cerrar_sesion){
            setContentView(R.layout.activity_main);
            logeo=false;
            numguia=0;
            try {
                titulo(numguia);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            if(validaVersion()==true){
                video(1);
            }
            else{
                imagen(1);
            }
            opcion1.setVisible(false);
            opcion2.setVisible(false);
            temploggeo.delete();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void video(int video){
        if(video==1){
            mVideoView = (VideoView)findViewById(R.id.surface_view);
        }
        if(video==2){
            mVideoView = (VideoView)findViewById(R.id.surface_view1);
        }
        String uriPath = "android.resource://com.example.macmini3cuceimobile.ciep/"+R.raw.loginciep;
        Uri uri = Uri.parse(uriPath);
        mVideoView.setVideoURI(uri);
        mVideoView.requestFocus();
        mVideoView.start();

        mVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {

            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setLooping(true);
            }
        });
    }

    public void imagen(int imagen){
        if(imagen==1){
            mImageView = (ImageView)findViewById(R.id.imageView);
        }
        if(imagen==2){
            mImageView = (ImageView)findViewById(R.id.imageView1);
        }
        mImageView.setBackgroundResource(R.drawable.loginciep);
    }

    public void validaTemp(){
        try
        {
            FileInputStream fIn = new FileInputStream(temploggeo);
            InputStreamReader archivo = new InputStreamReader(fIn);
            BufferedReader br = new BufferedReader(archivo);
            linea = br.readLine();
            archivo.close();
            StringTokenizer tokens=new StringTokenizer(linea, ",");
            usuario=tokens.nextToken();
            password=tokens.nextToken();
            linea=verifica(usuario);
            separa(linea);
            linea=null;
            confirmacion=false;
        }
        catch (Exception ex)
        {
            Log.i("Ficheros", "Error al leer fichero desde memoria interna");
        }
    }

    public void inicio_datosnum(){
        String linea;
        String num=null;
        String usu="";
        Boolean band=false;
        try {
            FileInputStream fIn = new FileInputStream(guardadatosnum);
            InputStreamReader archivo1 = new InputStreamReader(fIn);
            BufferedReader br = new BufferedReader(archivo1);
            linea = br.readLine();
            while(linea!=null){
                StringTokenizer tkn = new StringTokenizer(linea, "&");
                usu=tkn.nextToken();
                if(usu.equals(usuario)){
                    num = tkn.nextToken();
                    ventana_datosnum = Integer.parseInt(num);
                    num = tkn.nextToken();
                    numaudguia8 = Integer.parseInt(num);
                    num = tkn.nextToken();
                    correctas8 = Integer.parseInt(num);
                    archivo1.close();
                    band=true;
                    linea=null;
                    eliminareg8();
                }
                else{
                    linea = br.readLine();
                }
            }
            if(band==true) {
                Boolean band2 = false;
                band2 = validaVersion();
                if(band2==true){
                    AlertaMayor();
                }
                else{
                    AlertaMenor();
                }
            }
            else{
                numaudguia8 = 1;
                ventana_datosnum = 1;
                validaVentana8();
                validaudio(ventana_datosnum);
            }
        } catch (Exception ex) {
            Log.e("Ficheros", "Error al leer fichero a memoria interna");
        }
    }

    public void agregadatosnum(){
        String linea="";
        String linea2="";
        String usu="";
        Boolean band=false;
        try {
            FileInputStream fIn = new FileInputStream(guardadatosnum);
            InputStreamReader archivo1 = new InputStreamReader(fIn);
            BufferedReader br = new BufferedReader(archivo1);
            linea = br.readLine();
            while (linea != null) {
                StringTokenizer tkn = new StringTokenizer(linea, "&");
                usu = tkn.nextToken();
                if (!usu.equals(usuario)) {
                    linea2 = linea2 + linea + salto;
                    linea = br.readLine();
                }
                else {
                    band = true;
                    linea2 = linea2 + (usuario + "&" + ventana_datosnum + "&" + numaudguia8 + "&" + correctas8 + salto);
                    linea = br.readLine();
                    while (linea != null) {
                        linea2 = linea + salto;
                        linea = br.readLine();
                    }
                }
            }
            archivo1.close();
            guardadatosnum.delete();
            if (band == false) {
                OutputStreamWriter archivo2 = new OutputStreamWriter(
                        new FileOutputStream(guardadatosnum));
                linea2 = linea2 + (usuario + "&" + ventana_datosnum + "&" + numaudguia8 + "&" + correctas8);
                archivo2.write(linea2);
                archivo2.flush();
                archivo2.close();
            }
            else{
                OutputStreamWriter archivo2 = new OutputStreamWriter(
                        new FileOutputStream(guardadatosnum));
                archivo2.write(linea2);
                archivo2.flush();
                archivo2.close();
            }
            Toast.makeText(MainActivity.this, "Información guardada exitosamente", Toast.LENGTH_LONG).show();
        }
        catch (Exception ex) {
            Log.e("Ficheros", "Error al escribir fichero a memoria interna");
        }
    }

    public void clickaud (){
        if(aud.isPlaying()){
            aud.stop();
            validaudio(ventana_datosnum);
        }
        else{
            aud.start();
        }
    }

    public void validaudio(int ventana){
        if(ventana==1){
            au=Environment.getExternalStoragePublicDirectory("/.estu@pp/guia8/audio1.rar");
            aud= MediaPlayer.create(this, Uri.fromFile(au));
        }
        if(ventana==2){
            au=Environment.getExternalStoragePublicDirectory("/.estu@pp/guia8/audio2.rar");
            aud= MediaPlayer.create(this, Uri.fromFile(au));
        }
        if(ventana==3){
            au=Environment.getExternalStoragePublicDirectory("/.estu@pp/guia8/audio3.rar");
            aud= MediaPlayer.create(this, Uri.fromFile(au));;
        }
        if(ventana==4){
            au=Environment.getExternalStoragePublicDirectory("/.estu@pp/guia8/audio4.rar");
            aud= MediaPlayer.create(this, Uri.fromFile(au));
        }
        if(ventana==5){
            au=Environment.getExternalStoragePublicDirectory("/.estu@pp/guia8/audio5.rar");
            aud= MediaPlayer.create(this, Uri.fromFile(au));
        }
        if(ventana==6){
            au=Environment.getExternalStoragePublicDirectory("/.estu@pp/guia8/audio6.rar");
            aud= MediaPlayer.create(this, Uri.fromFile(au));
        }
        if(ventana==7){
            au=Environment.getExternalStoragePublicDirectory("/.estu@pp/guia8/audio7.rar");
            aud= MediaPlayer.create(this, Uri.fromFile(au));
        }
        if(ventana==8){
            au=Environment.getExternalStoragePublicDirectory("/.estu@pp/guia8/audio8.rar");
            aud= MediaPlayer.create(this, Uri.fromFile(au));
        }
        if(ventana==9){
            au=Environment.getExternalStoragePublicDirectory("/.estu@pp/guia8/audio9.rar");
            aud= MediaPlayer.create(this, Uri.fromFile(au));
        }
        if(ventana==10){
            au=Environment.getExternalStoragePublicDirectory("/.estu@pp/guia8/audio10.rar");
            aud= MediaPlayer.create(this, Uri.fromFile(au));
        }
        if(ventana==11){
            au=Environment.getExternalStoragePublicDirectory("/.estu@pp/guia8/audio11.rar");
            aud= MediaPlayer.create(this, Uri.fromFile(au));
        }
        if(ventana==12){
            au=Environment.getExternalStoragePublicDirectory("/.estu@pp/guia8/audio12.rar");
            aud= MediaPlayer.create(this, Uri.fromFile(au));
        }
        if(ventana==13){
            au=Environment.getExternalStoragePublicDirectory("/.estu@pp/guia8/audio13.rar");
            aud= MediaPlayer.create(this, Uri.fromFile(au));
        }
    }

    public void AlertaMayor(){
        final Boolean[] opcion = {false};
        final AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
        alertDialog.setTitle("Punto de Inicio");
        alertDialog.setMessage("¿Deseas continuar con los datos guardados?");
        alertDialog.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.dismiss();
                validaVentana8();
                opcion[0] = true;
            }
        });
        alertDialog.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.dismiss();
                numaudguia8 = 1;
                ventana_datosnum = 1;
                validaVentana8();
                validaudio(ventana_datosnum);
                opcion[0] = true;
            }
        });
        alertDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            public void onDismiss(DialogInterface arg0) {
                if (opcion[0] == false) {
                    numaudguia8 = 1;
                    ventana_datosnum = 1;
                    validaVentana8();
                    validaudio(ventana_datosnum);
                }
            }
        });
        alertDialog.show();
    }

    public void AlertaMenor(){
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
        alertDialog.setTitle("Punto de Inicio");
        alertDialog.setMessage("¿Deseas continuar con los datos guardados?");
        alertDialog.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.dismiss();
                validaVentana8();
            }
        });
        alertDialog.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.dismiss();
                numaudguia8 = 1;
                ventana_datosnum = 1;
                validaVentana8();
                validaudio(ventana_datosnum);
            }
        });
        alertDialog.show();
    }
//VENTANA GUIA 1 FRANCES
    public void validaVentana1(){
        if (ventana_frances == 1) {
            setContentView(R.layout.pantalla1_frances);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia1/portada_frances.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            bmDrawable = new BitmapDrawable(bm);
            fondo1_pantalla1_frances = (LinearLayout) findViewById(R.id.fondo1_pantalla1_frances);
            fondo1_pantalla1_frances.setBackgroundDrawable(bmDrawable);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia1/ilustracion1_pantalla1_14_frances.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen1_pantalla1_frances = (ImageView) findViewById(R.id.imagen1_pantalla1_frances);
            imagen1_pantalla1_frances.setImageBitmap(bm);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia1/bienvenida_frances.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen2_pantalla1_frances = (ImageView) findViewById(R.id.imagen2_pantalla1_frances);
            imagen2_pantalla1_frances.setImageBitmap(bm);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia1/comenzar_frances.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            bmDrawable = new BitmapDrawable(bm);
            comenzar_frances = (ImageView) findViewById(R.id.comenzar_frances);
            comenzar_frances.setBackgroundDrawable(bmDrawable);
        }
        if(ventana_frances == 2)
        {
            setContentView(R.layout.pantalla2_frances);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia1/ilustracion1_pantalla2_3_frances.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            bmDrawable = new BitmapDrawable(bm);
            imagen1_pantalla2_frances = (ImageView) findViewById(R.id.imagen1_pantalla2_frances);
            imagen1_pantalla2_frances.setBackgroundDrawable(bmDrawable);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia1/boton_siguiente_frances.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            bmDrawable = new BitmapDrawable(bm);
            boton_siguiente_frances = (ImageView) findViewById(R.id.boton_siguiente_frances);
            boton_siguiente_frances.setBackgroundDrawable(bmDrawable);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia1/boton_anterior_frances.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            bmDrawable = new BitmapDrawable(bm);
            boton_anterior_frances = (ImageView) findViewById(R.id.boton_anterior_frances);
            boton_anterior_frances.setBackgroundDrawable(bmDrawable);
        }
        if(ventana_frances == 3)
        {
            setContentView(R.layout.pantalla3_frances);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia1/ilustracion1_pantalla3_frances.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            bmDrawable = new BitmapDrawable(bm);
            imagen1_pantalla3_frances = (ImageView) findViewById(R.id.imagen1_pantalla3_frances);
            imagen1_pantalla3_frances.setBackgroundDrawable(bmDrawable);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia1/boton_siguiente_frances.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            bmDrawable = new BitmapDrawable(bm);
            boton_siguiente_frances = (ImageView) findViewById(R.id.boton_siguiente_frances);
            boton_siguiente_frances.setBackgroundDrawable(bmDrawable);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia1/boton_anterior_frances.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            bmDrawable = new BitmapDrawable(bm);
            boton_anterior_frances = (ImageView) findViewById(R.id.boton_anterior_frances);
            boton_anterior_frances.setBackgroundDrawable(bmDrawable);
        }
        if(ventana_frances == 4)
        {
            setContentView(R.layout.pantalla4_frances);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia1/ilustracion1_pantalla4_frances.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            bmDrawable = new BitmapDrawable(bm);
            imagen1_pantalla4_frances = (ImageView) findViewById(R.id.imagen1_pantalla4_frances);
            imagen1_pantalla4_frances.setBackgroundDrawable(bmDrawable);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia1/boton_siguiente_frances.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            bmDrawable = new BitmapDrawable(bm);
            boton_siguiente_frances = (ImageView) findViewById(R.id.boton_siguiente_frances);
            boton_siguiente_frances.setBackgroundDrawable(bmDrawable);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia1/boton_anterior_frances.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            bmDrawable = new BitmapDrawable(bm);
            boton_anterior_frances = (ImageView) findViewById(R.id.boton_anterior_frances);
            boton_anterior_frances.setBackgroundDrawable(bmDrawable);
        }
        if(ventana_frances == 5)
        {
            setContentView(R.layout.pantalla5_frances);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia1/ilustracion1_pantalla5_frances.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            bmDrawable = new BitmapDrawable(bm);
            imagen1_pantalla5_frances = (ImageView) findViewById(R.id.imagen1_pantalla5_frances);
            imagen1_pantalla5_frances.setBackgroundDrawable(bmDrawable);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia1/boton_siguiente_frances.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            bmDrawable = new BitmapDrawable(bm);
            boton_siguiente_frances = (ImageView) findViewById(R.id.boton_siguiente_frances);
            boton_siguiente_frances.setBackgroundDrawable(bmDrawable);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia1/boton_anterior_frances.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            bmDrawable = new BitmapDrawable(bm);
            boton_anterior_frances = (ImageView) findViewById(R.id.boton_anterior_frances);
            boton_anterior_frances.setBackgroundDrawable(bmDrawable);
        }
        if(ventana_frances == 6)
        {
            setContentView(R.layout.pantalla6_frances);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia1/ilustracion1_pantalla6_frances.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            bmDrawable = new BitmapDrawable(bm);
            imagen1_pantalla6_frances = (ImageView) findViewById(R.id.imagen1_pantalla6_frances);
            imagen1_pantalla6_frances.setBackgroundDrawable(bmDrawable);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia1/boton_siguiente_frances.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            bmDrawable = new BitmapDrawable(bm);
            boton_siguiente_frances = (ImageView) findViewById(R.id.boton_siguiente_frances);
            boton_siguiente_frances.setBackgroundDrawable(bmDrawable);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia1/boton_anterior_frances.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            bmDrawable = new BitmapDrawable(bm);
            boton_anterior_frances = (ImageView) findViewById(R.id.boton_anterior_frances);
            boton_anterior_frances.setBackgroundDrawable(bmDrawable);
        }
        if(ventana_frances == 7)
        {
            setContentView(R.layout.pantalla7_frances);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia1/ilustracion1_pantalla7_frances.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            bmDrawable = new BitmapDrawable(bm);
            imagen1_pantalla7_frances = (ImageView) findViewById(R.id.imagen1_pantalla7_frances);
            imagen1_pantalla7_frances.setBackgroundDrawable(bmDrawable);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia1/boton_siguiente_frances.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            bmDrawable = new BitmapDrawable(bm);
            boton_siguiente_frances = (ImageView) findViewById(R.id.boton_siguiente_frances);
            boton_siguiente_frances.setBackgroundDrawable(bmDrawable);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia1/boton_anterior_frances.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            bmDrawable = new BitmapDrawable(bm);
            boton_anterior_frances = (ImageView) findViewById(R.id.boton_anterior_frances);
            boton_anterior_frances.setBackgroundDrawable(bmDrawable);
        }
        if(ventana_frances == 8)
        {
            setContentView(R.layout.pantalla8_frances);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia1/ilustracion1_pantalla8_frances.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            bmDrawable = new BitmapDrawable(bm);
            imagen1_pantalla8_frances = (ImageView) findViewById(R.id.imagen1_pantalla8_frances);
            imagen1_pantalla8_frances.setBackgroundDrawable(bmDrawable);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia1/boton_siguiente_frances.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            bmDrawable = new BitmapDrawable(bm);
            boton_siguiente_frances = (ImageView) findViewById(R.id.boton_siguiente_frances);
            boton_siguiente_frances.setBackgroundDrawable(bmDrawable);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia1/boton_anterior_frances.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            bmDrawable = new BitmapDrawable(bm);
            boton_anterior_frances = (ImageView) findViewById(R.id.boton_anterior_frances);
            boton_anterior_frances.setBackgroundDrawable(bmDrawable);
        }
        if(ventana_frances == 9)
        {
            setContentView(R.layout.pantalla9_frances);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia1/ilustracion1_pantalla9_frances.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            bmDrawable = new BitmapDrawable(bm);
            imagen1_pantalla9_frances = (ImageView) findViewById(R.id.imagen1_pantalla9_frances);
            imagen1_pantalla9_frances.setBackgroundDrawable(bmDrawable);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia1/boton_siguiente_frances.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            bmDrawable = new BitmapDrawable(bm);
            boton_siguiente_frances = (ImageView) findViewById(R.id.boton_siguiente_frances);
            boton_siguiente_frances.setBackgroundDrawable(bmDrawable);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia1/boton_anterior_frances.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            bmDrawable = new BitmapDrawable(bm);
            boton_anterior_frances = (ImageView) findViewById(R.id.boton_anterior_frances);
            boton_anterior_frances.setBackgroundDrawable(bmDrawable);
        }
        if(ventana_frances == 10)
        {
            setContentView(R.layout.pantalla10_frances);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia1/bocina.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            bmDrawable = new BitmapDrawable(bm);
            imagen_bocina = (ImageView) findViewById(R.id.imagen_bocina);
            imagen_bocina.setBackgroundDrawable(bmDrawable);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia1/boton_siguiente_frances.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            bmDrawable = new BitmapDrawable(bm);
            boton_siguiente_frances = (ImageView) findViewById(R.id.boton_siguiente_frances);
            boton_siguiente_frances.setBackgroundDrawable(bmDrawable);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia1/boton_anterior_frances.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            bmDrawable = new BitmapDrawable(bm);
            boton_anterior_frances = (ImageView) findViewById(R.id.boton_anterior_frances);
            boton_anterior_frances.setBackgroundDrawable(bmDrawable);
        }
        if(ventana_frances == 11)
        {
            setContentView(R.layout.pantalla11_frances);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia1/ilustracion1_pantalla11_frances.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            bmDrawable = new BitmapDrawable(bm);
            imagen1_pantalla11_frances = (ImageView) findViewById(R.id.imagen1_pantalla11_frances);
            imagen1_pantalla11_frances.setBackgroundDrawable(bmDrawable);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia1/boton_siguiente_frances.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            bmDrawable = new BitmapDrawable(bm);
            boton_siguiente_frances = (ImageView) findViewById(R.id.boton_siguiente_frances);
            boton_siguiente_frances.setBackgroundDrawable(bmDrawable);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia1/boton_anterior_frances.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            bmDrawable = new BitmapDrawable(bm);
            boton_anterior_frances = (ImageView) findViewById(R.id.boton_anterior_frances);
            boton_anterior_frances.setBackgroundDrawable(bmDrawable);
        }
        if(ventana_frances == 12)
        {
            setContentView(R.layout.pantalla12_frances);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia1/boton_siguiente_frances.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            bmDrawable = new BitmapDrawable(bm);
            boton_siguiente_frances = (ImageView) findViewById(R.id.boton_siguiente_frances);
            boton_siguiente_frances.setBackgroundDrawable(bmDrawable);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia1/boton_anterior_frances.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            bmDrawable = new BitmapDrawable(bm);
            boton_anterior_frances = (ImageView) findViewById(R.id.boton_anterior_frances);
            boton_anterior_frances.setBackgroundDrawable(bmDrawable);
        }
        if(ventana_frances == 13)
        {
            setContentView(R.layout.pantalla13_frances);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia1/ilustracion1_pantalla13_frances.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            bmDrawable = new BitmapDrawable(bm);
            imagen1_pantalla13_frances = (ImageView) findViewById(R.id.imagen1_pantalla13_frances);
            imagen1_pantalla13_frances.setBackgroundDrawable(bmDrawable);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia1/boton_siguiente_frances.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            bmDrawable = new BitmapDrawable(bm);
            boton_siguiente_frances = (ImageView) findViewById(R.id.boton_siguiente_frances);
            boton_siguiente_frances.setBackgroundDrawable(bmDrawable);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia1/boton_anterior_frances.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            bmDrawable = new BitmapDrawable(bm);
            boton_anterior_frances = (ImageView) findViewById(R.id.boton_anterior_frances);
            boton_anterior_frances.setBackgroundDrawable(bmDrawable);
        }
        if(ventana_frances == 14)
        {
            setContentView(R.layout.pantalla14_frances);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia1/ilustracion1_pantalla14_frances.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            bmDrawable = new BitmapDrawable(bm);
            imagen1_pantalla14_frances = (ImageView) findViewById(R.id.imagen1_pantalla14_frances);
            imagen1_pantalla14_frances.setBackgroundDrawable(bmDrawable);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia1/boton_siguiente_frances.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            bmDrawable = new BitmapDrawable(bm);
            boton_siguiente_frances = (ImageView) findViewById(R.id.boton_siguiente_frances);
            boton_siguiente_frances.setBackgroundDrawable(bmDrawable);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia1/boton_anterior_frances.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            bmDrawable = new BitmapDrawable(bm);
            boton_anterior_frances = (ImageView) findViewById(R.id.boton_anterior_frances);
            boton_anterior_frances.setBackgroundDrawable(bmDrawable);
        }
        if(ventana_frances == 15)
        {
            setContentView(R.layout.pantalla15_frances);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia1/ilustracion1_pantalla15_frances.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            bmDrawable = new BitmapDrawable(bm);
            imagen1_pantalla15_frances = (ImageView) findViewById(R.id.imagen1_pantalla15_frances);
            imagen1_pantalla15_frances.setBackgroundDrawable(bmDrawable);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia1/boton_siguiente_frances.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            bmDrawable = new BitmapDrawable(bm);
            boton_siguiente_frances = (ImageView) findViewById(R.id.boton_siguiente_frances);
            boton_siguiente_frances.setBackgroundDrawable(bmDrawable);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia1/boton_anterior_frances.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            bmDrawable = new BitmapDrawable(bm);
            boton_anterior_frances = (ImageView) findViewById(R.id.boton_anterior_frances);
            boton_anterior_frances.setBackgroundDrawable(bmDrawable);
        }
        if(ventana_frances == 16)
        {
            setContentView(R.layout.pantalla16_frances);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia1/boton_siguiente_frances.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            bmDrawable = new BitmapDrawable(bm);
            boton_siguiente_frances = (ImageView) findViewById(R.id.boton_siguiente_frances);
            boton_siguiente_frances.setBackgroundDrawable(bmDrawable);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia1/boton_anterior_frances.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            bmDrawable = new BitmapDrawable(bm);
            boton_anterior_frances = (ImageView) findViewById(R.id.boton_anterior_frances);
            boton_anterior_frances.setBackgroundDrawable(bmDrawable);
        }
        if(ventana_frances == 17)
        {
            setContentView(R.layout.pantalla17_frances);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia1/ilustracion1_pantalla17_frances.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            bmDrawable = new BitmapDrawable(bm);
            imagen1_pantalla17_frances = (ImageView) findViewById(R.id.imagen1_pantalla17_frances);
            imagen1_pantalla17_frances.setBackgroundDrawable(bmDrawable);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia1/boton_siguiente_frances.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            bmDrawable = new BitmapDrawable(bm);
            boton_siguiente_frances = (ImageView) findViewById(R.id.boton_siguiente_frances);
            boton_siguiente_frances.setBackgroundDrawable(bmDrawable);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia1/boton_anterior_frances.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            bmDrawable = new BitmapDrawable(bm);
            boton_anterior_frances = (ImageView) findViewById(R.id.boton_anterior_frances);
            boton_anterior_frances.setBackgroundDrawable(bmDrawable);
        }
        if(ventana_frances == 18)
        {
            setContentView(R.layout.pantalla18_frances);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia1/boton_siguiente_frances.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            bmDrawable = new BitmapDrawable(bm);
            boton_siguiente_frances = (ImageView) findViewById(R.id.boton_siguiente_frances);
            boton_siguiente_frances.setBackgroundDrawable(bmDrawable);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia1/boton_anterior_frances.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            bmDrawable = new BitmapDrawable(bm);
            boton_anterior_frances = (ImageView) findViewById(R.id.boton_anterior_frances);
            boton_anterior_frances.setBackgroundDrawable(bmDrawable);
        }
        if(ventana_frances == 19)
        {
            setContentView(R.layout.pantalla19_frances);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia1/ilustracion1_pantalla19_frances.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            bmDrawable = new BitmapDrawable(bm);
            imagen1_pantalla19_frances = (ImageView) findViewById(R.id.imagen1_pantalla19_frances);
            imagen1_pantalla19_frances.setBackgroundDrawable(bmDrawable);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia1/boton_siguiente_frances.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            bmDrawable = new BitmapDrawable(bm);
            boton_siguiente_frances = (ImageView) findViewById(R.id.boton_siguiente_frances);
            boton_siguiente_frances.setBackgroundDrawable(bmDrawable);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia1/boton_anterior_frances.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            bmDrawable = new BitmapDrawable(bm);
            boton_anterior_frances = (ImageView) findViewById(R.id.boton_anterior_frances);
            boton_anterior_frances.setBackgroundDrawable(bmDrawable);
        }
        if(ventana_frances == 20)
        {
            setContentView(R.layout.pantalla20_frances);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia1/ilustracion1_pantalla20_frances.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            bmDrawable = new BitmapDrawable(bm);
            imagen1_pantalla20_frances = (ImageView) findViewById(R.id.imagen1_pantalla20_frances);
            imagen1_pantalla20_frances.setBackgroundDrawable(bmDrawable);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia1/boton_siguiente_frances.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            bmDrawable = new BitmapDrawable(bm);
            boton_siguiente_frances = (ImageView) findViewById(R.id.boton_siguiente_frances);
            boton_siguiente_frances.setBackgroundDrawable(bmDrawable);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia1/boton_anterior_frances.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            bmDrawable = new BitmapDrawable(bm);
            boton_anterior_frances = (ImageView) findViewById(R.id.boton_anterior_frances);
            boton_anterior_frances.setBackgroundDrawable(bmDrawable);
        }
        if(ventana_frances == 21)
        {
            setContentView(R.layout.pantalla21_frances);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia1/boton_siguiente_frances.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            bmDrawable = new BitmapDrawable(bm);
            boton_siguiente_frances = (ImageView) findViewById(R.id.boton_siguiente_frances);
            boton_siguiente_frances.setBackgroundDrawable(bmDrawable);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia1/boton_anterior_frances.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            bmDrawable = new BitmapDrawable(bm);
            boton_anterior_frances = (ImageView) findViewById(R.id.boton_anterior_frances);
            boton_anterior_frances.setBackgroundDrawable(bmDrawable);
        }
        if(ventana_frances == 22)
        {
            setContentView(R.layout.pantalla22_frances);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia1/boton_siguiente_frances.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            bmDrawable = new BitmapDrawable(bm);
            boton_siguiente_frances = (ImageView) findViewById(R.id.boton_siguiente_frances);
            boton_siguiente_frances.setBackgroundDrawable(bmDrawable);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia1/boton_anterior_frances.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            bmDrawable = new BitmapDrawable(bm);
            boton_anterior_frances = (ImageView) findViewById(R.id.boton_anterior_frances);
            boton_anterior_frances.setBackgroundDrawable(bmDrawable);
        }
        if(ventana_frances == 23) {
            setContentView(R.layout.pantalla23_frances);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia1/ilustracion1_pantalla23_frances.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            bmDrawable = new BitmapDrawable(bm);
            imagen1_pantalla23_frances = (ImageView) findViewById(R.id.imagen1_pantalla23_frances);
            imagen1_pantalla23_frances.setBackgroundDrawable(bmDrawable);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia1/boton_salir_frances.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            bmDrawable = new BitmapDrawable(bm);
            Salir_Frances = (ImageView) findViewById(R.id.Salir_Frances);
            Salir_Frances.setBackgroundDrawable(bmDrawable);
        }

    }
    public void validaVentana3(){
        if (ventana_administraciondeltiempo == 1) {
            setContentView(R.layout.pantalla1_administraciondeltiempo);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia3/portada_administraciondeltiempo.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            bmDrawable = new BitmapDrawable(bm);
            fondo1_pantalla1_administraciondeltiempo = (LinearLayout) findViewById(R.id.fondo1_pantalla1_administraciondeltiempo);
            fondo1_pantalla1_administraciondeltiempo.setBackgroundDrawable(bmDrawable);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia3/ilustracion1_pantalla1_administraciondeltiempo.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen1_pantalla1_administraciondeltiempo = (ImageView) findViewById(R.id.imagen1_pantalla1_administraciondeltiempo);
            imagen1_pantalla1_administraciondeltiempo.setImageBitmap(bm);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia3/comenzar_administraciondeltiempo.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            bmDrawable = new BitmapDrawable(bm);
            comenzar_administraciondeltiempo = (ImageView) findViewById(R.id.comenzar_administraciondeltiempo);
            comenzar_administraciondeltiempo.setBackgroundDrawable(bmDrawable);
        }
    }
    public void validaVentana5(){
        if (ventana_estres == 1) {
            setContentView(R.layout.pantalla1_estres);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia5/portada_estres.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            bmDrawable = new BitmapDrawable(bm);
            fondo1_pantalla1_estres = (LinearLayout) findViewById(R.id.fondo1_pantalla1_estres);
            fondo1_pantalla1_estres.setBackgroundDrawable(bmDrawable);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia5/ilustracion1_pantalla1_estres.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen1_pantalla1_estres = (ImageView) findViewById(R.id.imagen1_pantalla1_estres);
            imagen1_pantalla1_estres.setImageBitmap(bm);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia5/comenzar_estres.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            bmDrawable = new BitmapDrawable(bm);
            comenzar_estres = (ImageView) findViewById(R.id.comenzar_estres);
            comenzar_estres.setBackgroundDrawable(bmDrawable);
        }
    }
    public void validaVentana6(){
        if (ventana_mapasmentales == 1) {
            setContentView(R.layout.pantalla1_mapasmentales);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia6/portada_mapasmentales.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            bmDrawable = new BitmapDrawable(bm);
            fondo1_pantalla1_mapasmentales = (LinearLayout) findViewById(R.id.fondo1_pantalla1_mapasmentales);
            fondo1_pantalla1_mapasmentales.setBackgroundDrawable(bmDrawable);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia6/ilustracion1_pantalla1_mapasmentales.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen1_pantalla1_mapasmentales = (ImageView) findViewById(R.id.imagen1_pantalla1_mapasmentales);
            imagen1_pantalla1_mapasmentales.setImageBitmap(bm);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia6/bienvenida_mapasmentales.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen2_pantalla1_mapasmentales = (ImageView) findViewById(R.id.imagen2_pantalla1_mapasmentales);
            imagen2_pantalla1_mapasmentales.setImageBitmap(bm);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia6/comenzar_mapasmentales.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            bmDrawable = new BitmapDrawable(bm);
            comenzar_mapasmentales = (ImageView) findViewById(R.id.comenzar_mapasmentales);
            comenzar_mapasmentales.setBackgroundDrawable(bmDrawable);
        }
    }
    public void validaVentana7(){
        if (ventana_importanciadelingles == 1) {
            setContentView(R.layout.pantalla1_importanciadelingles);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia7/portada_importanciadelingles.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            bmDrawable = new BitmapDrawable(bm);
            fondo1_pantalla1_importanciadelingles = (LinearLayout) findViewById(R.id.fondo1_pantalla1_importanciadelingles);
            fondo1_pantalla1_importanciadelingles.setBackgroundDrawable(bmDrawable);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia7/ilustracion1_pantalla1_importanciadelingles.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen1_pantalla1_importanciadelingles = (ImageView) findViewById(R.id.imagen1_pantalla1_importanciadelingles);
            imagen1_pantalla1_importanciadelingles.setImageBitmap(bm);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia7/bienvenida_importanciadelingles.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen2_pantalla1_importanciadelingles = (ImageView) findViewById(R.id.imagen2_pantalla1_importanciadelingles);
            imagen2_pantalla1_importanciadelingles.setImageBitmap(bm);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia7/comenzar_importanciadelingles.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            bmDrawable = new BitmapDrawable(bm);
            comenzar_importanciadelingles = (ImageView) findViewById(R.id.comenzar_importanciadelingles);
            comenzar_importanciadelingles.setBackgroundDrawable(bmDrawable);
        }
        if (ventana_importanciadelingles == 2) {
            setContentView(R.layout.pantalla2_importanciadelingles);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia7/ilustracion1_pantalla2_importanciadelingles.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen1_pantalla2_importanciadelingles = (ImageView) findViewById(R.id.imagen1_pantalla2_importanciadelingles);
            imagen1_pantalla2_importanciadelingles.setImageBitmap(bm);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia7/ilustracion2_pantalla2_importanciadelingles.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen2_pantalla2_importanciadelingles = (ImageView) findViewById(R.id.imagen2_pantalla2_importanciadelingles);
            imagen2_pantalla2_importanciadelingles.setImageBitmap(bm);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia7/ilustracion3_pantalla2_importanciadelingles.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen3_pantalla2_importanciadelingles = (ImageView) findViewById(R.id.imagen3_pantalla2_importanciadelingles);
            imagen3_pantalla2_importanciadelingles.setImageBitmap(bm);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia7/boton_anterior_importanciadelingles.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen4_pantalla2_importanciadelingles = (ImageView) findViewById(R.id.imagen4_pantalla2_importanciadelingles);
            imagen4_pantalla2_importanciadelingles.setImageBitmap(bm);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia7/boton_siguiente_importanciadelingles.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen5_pantalla2_importanciadelingles = (ImageView) findViewById(R.id.imagen5_pantalla2_importanciadelingles);
            imagen5_pantalla2_importanciadelingles.setImageBitmap(bm);
        }
        if (ventana_importanciadelingles == 3) {
            setContentView(R.layout.pantalla3_importanciadelingles);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia7/ilustracion1_pantalla3_importanciadelingles.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen1_pantalla3_importanciadelingles = (ImageView) findViewById(R.id.imagen1_pantalla3_importanciadelingles);
            imagen1_pantalla3_importanciadelingles.setImageBitmap(bm);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia7/ilustracion2_pantalla3_importanciadelingles.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen2_pantalla3_importanciadelingles = (ImageView) findViewById(R.id.imagen2_pantalla3_importanciadelingles);
            imagen2_pantalla3_importanciadelingles.setImageBitmap(bm);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia7/ilustracion3_pantalla3_importanciadelingles.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen3_pantalla3_importanciadelingles = (ImageView) findViewById(R.id.imagen3_pantalla3_importanciadelingles);
            imagen3_pantalla3_importanciadelingles.setImageBitmap(bm);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia7/boton_anterior_importanciadelingles.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen4_pantalla3_importanciadelingles = (ImageView) findViewById(R.id.imagen4_pantalla3_importanciadelingles);
            imagen4_pantalla3_importanciadelingles.setImageBitmap(bm);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia7/boton_siguiente_importanciadelingles.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen5_pantalla3_importanciadelingles = (ImageView) findViewById(R.id.imagen5_pantalla3_importanciadelingles);
            imagen5_pantalla3_importanciadelingles.setImageBitmap(bm);
        }
        if (ventana_importanciadelingles == 4) {
            setContentView(R.layout.pantalla4_importanciadelingles);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia7/ilustracion1_pantalla4_importanciadelingles.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen1_pantalla4_importanciadelingles = (ImageView) findViewById(R.id.imagen1_pantalla4_importanciadelingles);
            imagen1_pantalla4_importanciadelingles.setImageBitmap(bm);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia7/aldiko.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen2_pantalla4_importanciadelingles = (ImageView) findViewById(R.id.imagen2_pantalla4_importanciadelingles);
            imagen2_pantalla4_importanciadelingles.setImageBitmap(bm);
            imagen2_pantalla4_importanciadelingles.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Fragment prev = fm.findFragmentByTag("dialog");
                    if (prev != null) {
                        Ft.remove(prev);
                    }
                    Ft.addToBackStack(null);
                    DI = new DialogoImagen();
                    DI.setImagen(".estu@pp/guia7/ficha_aldiko.zip");
                    DI.show(Ft, "dialog");
                }
            });
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia7/pdfreader.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen3_pantalla4_importanciadelingles = (ImageView) findViewById(R.id.imagen3_pantalla4_importanciadelingles);
            imagen3_pantalla4_importanciadelingles.setImageBitmap(bm);
            imagen3_pantalla4_importanciadelingles.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Fragment prev = fm.findFragmentByTag("dialog");
                    if (prev != null) {
                        Ft.remove(prev);
                    }
                    Ft.addToBackStack(null);
                    DI = new DialogoImagen();
                    DI.setImagen(".estu@pp/guia7/ficha_ezpdf.zip");
                    DI.show(Ft, "dialog");
                }
            });
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia7/ibooks.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen4_pantalla4_importanciadelingles = (ImageView) findViewById(R.id.imagen4_pantalla4_importanciadelingles);
            imagen4_pantalla4_importanciadelingles.setImageBitmap(bm);
            imagen4_pantalla4_importanciadelingles.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Fragment prev = fm.findFragmentByTag("dialog");
                    if (prev != null) {
                        Ft.remove(prev);
                    }
                    Ft.addToBackStack(null);
                    DI = new DialogoImagen();
                    DI.setImagen(".estu@pp/guia7/ficha_ibooks.zip");
                    DI.show(Ft, "dialog");
                }
            });
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia7/kindle.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen5_pantalla4_importanciadelingles = (ImageView) findViewById(R.id.imagen5_pantalla4_importanciadelingles);
            imagen5_pantalla4_importanciadelingles.setImageBitmap(bm);
            imagen5_pantalla4_importanciadelingles.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Fragment prev = fm.findFragmentByTag("dialog");
                    if (prev != null) {
                        Ft.remove(prev);
                    }
                    Ft.addToBackStack(null);
                    DI = new DialogoImagen();
                    DI.setImagen(".estu@pp/guia7/ficha_kindle.zip");
                    DI.show(Ft, "dialog");
                }
            });
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia7/ilustracion2_pantalla4_importanciadelingles.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen6_pantalla4_importanciadelingles = (ImageView) findViewById(R.id.imagen6_pantalla4_importanciadelingles);
            imagen6_pantalla4_importanciadelingles.setImageBitmap(bm);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia7/ilustracion3_pantalla4_importanciadelingles.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen7_pantalla4_importanciadelingles = (ImageView) findViewById(R.id.imagen7_pantalla4_importanciadelingles);
            imagen7_pantalla4_importanciadelingles.setImageBitmap(bm);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia7/binaurality.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen8_pantalla4_importanciadelingles = (ImageView) findViewById(R.id.imagen8_pantalla4_importanciadelingles);
            imagen8_pantalla4_importanciadelingles.setImageBitmap(bm);
            imagen8_pantalla4_importanciadelingles.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Fragment prev = fm.findFragmentByTag("dialog");
                    if (prev != null) {
                        Ft.remove(prev);
                    }
                    Ft.addToBackStack(null);
                    DI = new DialogoImagen();
                    DI.setImagen(".estu@pp/guia7/ficha_binaurality.zip");
                    DI.show(Ft, "dialog");
                }
            });
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia7/wilingua.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen9_pantalla4_importanciadelingles = (ImageView) findViewById(R.id.imagen9_pantalla4_importanciadelingles);
            imagen9_pantalla4_importanciadelingles.setImageBitmap(bm);
            imagen9_pantalla4_importanciadelingles.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Fragment prev = fm.findFragmentByTag("dialog");
                    if (prev != null) {
                        Ft.remove(prev);
                    }
                    Ft.addToBackStack(null);
                    DI = new DialogoImagen();
                    DI.setImagen(".estu@pp/guia7/ficha_wilingua.zip");
                    DI.show(Ft, "dialog");
                }
            });
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia7/duolingo.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen10_pantalla4_importanciadelingles = (ImageView) findViewById(R.id.imagen10_pantalla4_importanciadelingles);
            imagen10_pantalla4_importanciadelingles.setImageBitmap(bm);
            imagen10_pantalla4_importanciadelingles.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Fragment prev = fm.findFragmentByTag("dialog");
                    if (prev != null) {
                        Ft.remove(prev);
                    }
                    Ft.addToBackStack(null);
                    DI = new DialogoImagen();
                    DI.setImagen(".estu@pp/guia7/ficha_duolingo.zip");
                    DI.show(Ft, "dialog");
                }
            });
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia7/project.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen11_pantalla4_importanciadelingles = (ImageView) findViewById(R.id.imagen11_pantalla4_importanciadelingles);
            imagen11_pantalla4_importanciadelingles.setImageBitmap(bm);
            imagen11_pantalla4_importanciadelingles.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Fragment prev = fm.findFragmentByTag("dialog");
                    if (prev != null) {
                        Ft.remove(prev);
                    }
                    Ft.addToBackStack(null);
                    DI = new DialogoImagen();
                    DI.setImagen(".estu@pp/guia7/ficha_project.zip");
                    DI.show(Ft, "dialog");
                }
            });
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia7/voxy.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen12_pantalla4_importanciadelingles = (ImageView) findViewById(R.id.imagen12_pantalla4_importanciadelingles);
            imagen12_pantalla4_importanciadelingles.setImageBitmap(bm);
            imagen12_pantalla4_importanciadelingles.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Fragment prev = fm.findFragmentByTag("dialog");
                    if (prev != null)
                    {
                        Ft.remove(prev);
                    }
                    Ft.addToBackStack(null);
                    DI = new DialogoImagen();
                    DI.setImagen(".estu@pp/guia7/ficha_voxy.zip");
                    DI.show(Ft,"dialog");
                }
            });
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia7/mindsnacks.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen13_pantalla4_importanciadelingles = (ImageView) findViewById(R.id.imagen13_pantalla4_importanciadelingles);
            imagen13_pantalla4_importanciadelingles.setImageBitmap(bm);
            imagen13_pantalla4_importanciadelingles.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Fragment prev = fm.findFragmentByTag("dialog");
                    if (prev != null)
                    {
                        Ft.remove(prev);
                    }
                    Ft.addToBackStack(null);
                    DI = new DialogoImagen();
                    DI.setImagen(".estu@pp/guia7/ficha_mindsnack.zip");
                    DI.show(Ft,"dialog");
                }
            });
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia7/ilustracion4_pantalla4_importanciadelingles.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen14_pantalla4_importanciadelingles = (ImageView) findViewById(R.id.imagen14_pantalla4_importanciadelingles);
            imagen14_pantalla4_importanciadelingles.setImageBitmap(bm);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia7/ilustracion5_pantalla4_importanciadelingles.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen15_pantalla4_importanciadelingles = (ImageView) findViewById(R.id.imagen15_pantalla4_importanciadelingles);
            imagen15_pantalla4_importanciadelingles.setImageBitmap(bm);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia7/chumkee.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen16_pantalla4_importanciadelingles = (ImageView) findViewById(R.id.imagen16_pantalla4_importanciadelingles);
            imagen16_pantalla4_importanciadelingles.setImageBitmap(bm);
            imagen16_pantalla4_importanciadelingles.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Fragment prev = fm.findFragmentByTag("dialog");
                    if (prev != null)
                    {
                        Ft.remove(prev);
                    }
                    Ft.addToBackStack(null);
                    DI = new DialogoImagen();
                    DI.setImagen(".estu@pp/guia7/ficha_chumkee.zip");
                    DI.show(Ft,"dialog");
                }
            });
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia7/mylingo.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen17_pantalla4_importanciadelingles = (ImageView) findViewById(R.id.imagen17_pantalla4_importanciadelingles);
            imagen17_pantalla4_importanciadelingles.setImageBitmap(bm);
            imagen17_pantalla4_importanciadelingles.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Fragment prev = fm.findFragmentByTag("dialog");
                    if (prev != null)
                    {
                        Ft.remove(prev);
                    }
                    Ft.addToBackStack(null);
                    DI = new DialogoImagen();
                    DI.setImagen(".estu@pp/guia7/ficha_bmylingo.zip");
                    DI.show(Ft,"dialog");
                }
            });
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia7/speaking.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen18_pantalla4_importanciadelingles = (ImageView) findViewById(R.id.imagen18_pantalla4_importanciadelingles);
            imagen18_pantalla4_importanciadelingles.setImageBitmap(bm);
            imagen18_pantalla4_importanciadelingles.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Fragment prev = fm.findFragmentByTag("dialog");
                    if (prev != null)
                    {
                        Ft.remove(prev);
                    }
                    Ft.addToBackStack(null);
                    DI = new DialogoImagen();
                    DI.setImagen(".estu@pp/guia7/ficha_speaking.zip");
                    DI.show(Ft,"dialog");
                }
            });
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia7/busuu.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen19_pantalla4_importanciadelingles = (ImageView) findViewById(R.id.imagen19_pantalla4_importanciadelingles);
            imagen19_pantalla4_importanciadelingles.setImageBitmap(bm);
            imagen19_pantalla4_importanciadelingles.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Fragment prev = fm.findFragmentByTag("dialog");
                    if (prev != null)
                    {
                        Ft.remove(prev);
                    }
                    Ft.addToBackStack(null);
                    DI = new DialogoImagen();
                    DI.setImagen(".estu@pp/guia7/ficha_bussu.zip");
                    DI.show(Ft,"dialog");
                }
            });
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia7/babbel.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen20_pantalla4_importanciadelingles = (ImageView) findViewById(R.id.imagen20_pantalla4_importanciadelingles);
            imagen20_pantalla4_importanciadelingles.setImageBitmap(bm);
            imagen20_pantalla4_importanciadelingles.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Fragment prev = fm.findFragmentByTag("dialog");
                    if (prev != null)
                    {
                        Ft.remove(prev);
                    }
                    Ft.addToBackStack(null);
                    DI = new DialogoImagen();
                    DI.setImagen(".estu@pp/guia7/ficha_babbel.zip");
                    DI.show(Ft,"dialog");
                }
            });
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia7/internet.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen21_pantalla4_importanciadelingles = (ImageView) findViewById(R.id.imagen21_pantalla4_importanciadelingles);
            imagen21_pantalla4_importanciadelingles.setImageBitmap(bm);
            imagen21_pantalla4_importanciadelingles.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Fragment prev = fm.findFragmentByTag("dialog");
                    if (prev != null)
                    {
                        Ft.remove(prev);
                    }
                    Ft.addToBackStack(null);
                    DI = new DialogoImagen();
                    DI.setImagen(".estu@pp/guia7/ficha_ainternet_archive.zip");
                    DI.show(Ft,"dialog");
                }
            });
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia7/boton_anterior_importanciadelingles.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen22_pantalla4_importanciadelingles = (ImageView) findViewById(R.id.imagen22_pantalla4_importanciadelingles);
            imagen22_pantalla4_importanciadelingles.setImageBitmap(bm);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia7/boton_siguiente_importanciadelingles.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen23_pantalla4_importanciadelingles = (ImageView) findViewById(R.id.imagen23_pantalla4_importanciadelingles);
            imagen23_pantalla4_importanciadelingles.setImageBitmap(bm);
        }
        if(ventana_importanciadelingles == 5)
        {
            setContentView(R.layout.pantalla5_importanciadelingles);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia7/texto2_pantalla5_importanciadelingles.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen1_pantalla5_importanciadelingles = (ImageView) findViewById(R.id.imagen1_pantalla5_importanciadelingles);
            imagen1_pantalla5_importanciadelingles.setImageBitmap(bm);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia7/boton_anterior_importanciadelingles.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen2_pantalla5_importanciadelingles = (ImageView) findViewById(R.id.imagen2_pantalla5_importanciadelingles);
            imagen2_pantalla5_importanciadelingles.setImageBitmap(bm);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia7/boton_salir_importanciadelingles.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen3_pantalla5_importanciadelingles = (ImageView) findViewById(R.id.imagen3_pantalla5_importanciadelingles);
            imagen3_pantalla5_importanciadelingles.setImageBitmap(bm);
        }
    }
    public void validaVentana8(){
        if (ventana_datosnum == 1) {
            setContentView(R.layout.pantalla1_datosnumericos);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia8/ilustracion1_pantalla1_datosnumericos.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen1_pantalla1_datosnumericos=(ImageView)findViewById(R.id.imagen1_pantalla1_datosnumericos);
            imagen1_pantalla1_datosnumericos.setImageBitmap(bm);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia8/siguiente_datosnumericos.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen2_pantalla1_datosnumericos=(ImageView)findViewById(R.id.imagen2_pantalla1_datosnumericos);
            imagen2_pantalla1_datosnumericos.setImageBitmap(bm);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia8/portada_datosnumericos.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            bmDrawable = new BitmapDrawable(bm);
            fondo1_pantalla1_datosnumericos=(LinearLayout)findViewById(R.id.fondo1_pantalla1_datosnumericos);
            fondo1_pantalla1_datosnumericos.setBackgroundDrawable(bmDrawable);
        }
        if(ventana_datosnum==2){
            setContentView(R.layout.pantalla2_datosnumericos);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia8/ilustracion1_pantalla3_datosnumericos.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen1_pantalla2_datosnumericos=(ImageView)findViewById(R.id.imagen1_pantalla2_datosnumericos);
            imagen1_pantalla2_datosnumericos.setImageBitmap(bm);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia8/porcentajes.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen2_pantalla2_datosnumericos=(ImageView)findViewById(R.id.imagen2_pantalla2_datosnumericos);
            imagen2_pantalla2_datosnumericos.setImageBitmap(bm);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia8/graficas_de_pastel.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen3_pantalla2_datosnumericos=(ImageView)findViewById(R.id.imagen3_pantalla2_datosnumericos);
            imagen3_pantalla2_datosnumericos.setImageBitmap(bm);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia8/histogramas.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen4_pantalla2_datosnumericos=(ImageView)findViewById(R.id.imagen4_pantalla2_datosnumericos);
            imagen4_pantalla2_datosnumericos.setImageBitmap(bm);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia8/autoevaluacion.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen5_pantalla2_datosnumericos=(ImageView)findViewById(R.id.imagen5_pantalla2_datosnumericos);
            imagen5_pantalla2_datosnumericos.setImageBitmap(bm);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia8/menu_datosnumericos.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen6_pantalla2_datosnumericos=(ImageView)findViewById(R.id.imagen6_pantalla2_datosnumericos);
            imagen6_pantalla2_datosnumericos.setImageBitmap(bm);
        }
        if(ventana_datosnum==3){
            setContentView(R.layout.pantalla3_datosnumericos);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia8/ilustracion1_pantalla3_datosnumericos.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen1_pantalla3_datosnumericos=(ImageView)findViewById(R.id.imagen1_pantalla3_datosnumericos);
            imagen1_pantalla3_datosnumericos.setImageBitmap(bm);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia8/ilustracion2_pantalla3_datosnumericos.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen2_pantalla3_datosnumericos=(ImageView)findViewById(R.id.imagen2_pantalla3_datosnumericos);
            imagen2_pantalla3_datosnumericos.setImageBitmap(bm);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia8/anterior_datosnumericos.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen3_pantalla3_datosnumericos=(ImageView)findViewById(R.id.imagen3_pantalla3_datosnumericos);
            imagen3_pantalla3_datosnumericos.setImageBitmap(bm);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia8/siguiente_datosnumericos.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen4_pantalla3_datosnumericos=(ImageView)findViewById(R.id.imagen4_pantalla3_datosnumericos);
            imagen4_pantalla3_datosnumericos.setImageBitmap(bm);
        }
        if(ventana_datosnum==4){
            setContentView(R.layout.pantalla4_datosnumericos);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia8/porcentajes.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen1_pantalla4_datosnumericos=(ImageView)findViewById(R.id.imagen1_pantalla4_datosnumericos);
            imagen1_pantalla4_datosnumericos.setImageBitmap(bm);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia8/ilustracion1_pantalla5_datosnumericos.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen2_pantalla4_datosnumericos=(ImageView)findViewById(R.id.imagen2_pantalla4_datosnumericos);
            imagen2_pantalla4_datosnumericos.setImageBitmap(bm);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia8/anterior_datosnumericos.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen3_pantalla4_datosnumericos=(ImageView)findViewById(R.id.imagen3_pantalla4_datosnumericos);
            imagen3_pantalla4_datosnumericos.setImageBitmap(bm);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia8/siguiente_datosnumericos.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen4_pantalla4_datosnumericos=(ImageView)findViewById(R.id.imagen4_pantalla4_datosnumericos);
            imagen4_pantalla4_datosnumericos.setImageBitmap(bm);
        }
        if(ventana_datosnum==5){
            setContentView(R.layout.pantalla5_datosnumericos);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia8/porcentajes.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen1_pantalla5_datosnumericos=(ImageView)findViewById(R.id.imagen1_pantalla5_datosnumericos);
            imagen1_pantalla5_datosnumericos.setImageBitmap(bm);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia8/ilustracion1_pantalla4_datosnumericos.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen2_pantalla5_datosnumericos=(ImageView)findViewById(R.id.imagen2_pantalla5_datosnumericos);
            imagen2_pantalla5_datosnumericos.setImageBitmap(bm);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia8/anterior_datosnumericos.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen3_pantalla5_datosnumericos=(ImageView)findViewById(R.id.imagen3_pantalla5_datosnumericos);
            imagen3_pantalla5_datosnumericos.setImageBitmap(bm);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia8/siguiente_datosnumericos.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen4_pantalla5_datosnumericos=(ImageView)findViewById(R.id.imagen4_pantalla5_datosnumericos);
            imagen4_pantalla5_datosnumericos.setImageBitmap(bm);
        }
        if(ventana_datosnum==6){
            setContentView(R.layout.pantalla6_datosnumericos);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia8/porcentajes.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen1_pantalla6_datosnumericos=(ImageView)findViewById(R.id.imagen1_pantalla6_datosnumericos);
            imagen1_pantalla6_datosnumericos.setImageBitmap(bm);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia8/ilustracion1_pantalla6_datosnumericos.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen2_pantalla6_datosnumericos=(ImageView)findViewById(R.id.imagen2_pantalla6_datosnumericos);
            imagen2_pantalla6_datosnumericos.setImageBitmap(bm);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia8/anterior_datosnumericos.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen3_pantalla6_datosnumericos=(ImageView)findViewById(R.id.imagen3_pantalla6_datosnumericos);
            imagen3_pantalla6_datosnumericos.setImageBitmap(bm);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia8/siguiente_datosnumericos.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen4_pantalla6_datosnumericos=(ImageView)findViewById(R.id.imagen4_pantalla6_datosnumericos);
            imagen4_pantalla6_datosnumericos.setImageBitmap(bm);
        }
        if(ventana_datosnum==7){
            setContentView(R.layout.pantalla7_datosnumericos);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia8/graficas_de_pastel.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen1_pantalla7_datosnumericos=(ImageView)findViewById(R.id.imagen1_pantalla7_datosnumericos);
            imagen1_pantalla7_datosnumericos.setImageBitmap(bm);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia8/ilustracion1_pantalla7_datosnumericos.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen2_pantalla7_datosnumericos=(ImageView)findViewById(R.id.imagen2_pantalla7_datosnumericos);
            imagen2_pantalla7_datosnumericos.setImageBitmap(bm);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia8/anterior_datosnumericos.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen3_pantalla7_datosnumericos=(ImageView)findViewById(R.id.imagen3_pantalla7_datosnumericos);
            imagen3_pantalla7_datosnumericos.setImageBitmap(bm);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia8/siguiente_datosnumericos.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen4_pantalla7_datosnumericos=(ImageView)findViewById(R.id.imagen4_pantalla7_datosnumericos);
            imagen4_pantalla7_datosnumericos.setImageBitmap(bm);
        }
        if(ventana_datosnum==8){
            setContentView(R.layout.pantalla8_datosnumericos);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia8/graficas_de_pastel.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen1_pantalla8_datosnumericos=(ImageView)findViewById(R.id.imagen1_pantalla8_datosnumericos);
            imagen1_pantalla8_datosnumericos.setImageBitmap(bm);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia8/ilustracion1_pantalla8_datosnumericos.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen2_pantalla8_datosnumericos=(ImageView)findViewById(R.id.imagen2_pantalla8_datosnumericos);
            imagen2_pantalla8_datosnumericos.setImageBitmap(bm);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia8/anterior_datosnumericos.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen3_pantalla8_datosnumericos=(ImageView)findViewById(R.id.imagen3_pantalla8_datosnumericos);
            imagen3_pantalla8_datosnumericos.setImageBitmap(bm);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia8/siguiente_datosnumericos.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen4_pantalla8_datosnumericos=(ImageView)findViewById(R.id.imagen4_pantalla8_datosnumericos);
            imagen4_pantalla8_datosnumericos.setImageBitmap(bm);
        }
        if(ventana_datosnum==9){
            setContentView(R.layout.pantalla9_datosnumericos);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia8/graficas_de_pastel.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen1_pantalla9_datosnumericos=(ImageView)findViewById(R.id.imagen1_pantalla9_datosnumericos);
            imagen1_pantalla9_datosnumericos.setImageBitmap(bm);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia8/ilustracion1_pantalla9_datosnumericos.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen2_pantalla9_datosnumericos=(ImageView)findViewById(R.id.imagen2_pantalla9_datosnumericos);
            imagen2_pantalla9_datosnumericos.setImageBitmap(bm);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia8/ilustracion2_pantalla9_datosnumericos.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen3_pantalla9_datosnumericos=(ImageView)findViewById(R.id.imagen3_pantalla9_datosnumericos);
            imagen3_pantalla9_datosnumericos.setImageBitmap(bm);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia8/anterior_datosnumericos.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen4_pantalla9_datosnumericos=(ImageView)findViewById(R.id.imagen4_pantalla9_datosnumericos);
            imagen4_pantalla9_datosnumericos.setImageBitmap(bm);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia8/siguiente_datosnumericos.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen5_pantalla9_datosnumericos=(ImageView)findViewById(R.id.imagen5_pantalla9_datosnumericos);
            imagen5_pantalla9_datosnumericos.setImageBitmap(bm);
        }
        if(ventana_datosnum==10){
            setContentView(R.layout.pantalla10_datosnumericos);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia8/histogramas.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen1_pantalla10_datosnumericos=(ImageView)findViewById(R.id.imagen1_pantalla10_datosnumericos);
            imagen1_pantalla10_datosnumericos.setImageBitmap(bm);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia8/ilustracion1_pantalla10_datosnumericos.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen2_pantalla10_datosnumericos=(ImageView)findViewById(R.id.imagen2_pantalla10_datosnumericos);
            imagen2_pantalla10_datosnumericos.setImageBitmap(bm);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia8/anterior_datosnumericos.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen3_pantalla10_datosnumericos=(ImageView)findViewById(R.id.imagen3_pantalla10_datosnumericos);
            imagen3_pantalla10_datosnumericos.setImageBitmap(bm);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia8/siguiente_datosnumericos.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen4_pantalla10_datosnumericos=(ImageView)findViewById(R.id.imagen4_pantalla10_datosnumericos);
            imagen4_pantalla10_datosnumericos.setImageBitmap(bm);
        }
        if(ventana_datosnum==11){
            setContentView(R.layout.pantalla11_datosnumericos);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia8/histogramas.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen1_pantalla11_datosnumericos=(ImageView)findViewById(R.id.imagen1_pantalla11_datosnumericos);
            imagen1_pantalla11_datosnumericos.setImageBitmap(bm);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia8/ilustracion1_pantalla11_datosnumericos.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen2_pantalla11_datosnumericos=(ImageView)findViewById(R.id.imagen2_pantalla11_datosnumericos);
            imagen2_pantalla11_datosnumericos.setImageBitmap(bm);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia8/anterior_datosnumericos.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen3_pantalla11_datosnumericos=(ImageView)findViewById(R.id.imagen3_pantalla11_datosnumericos);
            imagen3_pantalla11_datosnumericos.setImageBitmap(bm);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia8/siguiente_datosnumericos.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen4_pantalla11_datosnumericos=(ImageView)findViewById(R.id.imagen4_pantalla11_datosnumericos);
            imagen4_pantalla11_datosnumericos.setImageBitmap(bm);
        }
        if(ventana_datosnum==12){
            setContentView(R.layout.pantalla12_datosnumericos);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia8/histogramas.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen1_pantalla12_datosnumericos=(ImageView)findViewById(R.id.imagen1_pantalla12_datosnumericos);
            imagen1_pantalla12_datosnumericos.setImageBitmap(bm);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia8/ilustracion1_pantalla12_datosnumericos.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen2_pantalla12_datosnumericos=(ImageView)findViewById(R.id.imagen2_pantalla12_datosnumericos);
            imagen2_pantalla12_datosnumericos.setImageBitmap(bm);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia8/anterior_datosnumericos.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen3_pantalla12_datosnumericos=(ImageView)findViewById(R.id.imagen3_pantalla12_datosnumericos);
            imagen3_pantalla12_datosnumericos.setImageBitmap(bm);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia8/siguiente_datosnumericos.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen4_pantalla12_datosnumericos=(ImageView)findViewById(R.id.imagen4_pantalla12_datosnumericos);
            imagen4_pantalla12_datosnumericos.setImageBitmap(bm);
        }
        if(ventana_datosnum==13){
            setContentView(R.layout.pantalla13_datosnumericos);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia8/portada_autoevaluacion_datosnumericos.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            bmDrawable = new BitmapDrawable(bm);
            fondo1_pantalla13_datosnumericos=(LinearLayout)findViewById(R.id.fondo1_pantalla13_datosnumericos);
            fondo1_pantalla13_datosnumericos.setBackgroundDrawable(bmDrawable);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia8/ilustracion1_pantalla13_datosnumericos.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen1_pantalla13_datosnumericos=(ImageView)findViewById(R.id.imagen1_pantalla13_datosnumericos);
            imagen1_pantalla13_datosnumericos.setImageBitmap(bm);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia8/ilustracion2_pantalla13_datosnumericos.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen2_pantalla13_datosnumericos=(ImageView)findViewById(R.id.imagen2_pantalla13_datosnumericos);
            imagen2_pantalla13_datosnumericos.setImageBitmap(bm);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia8/anterior_datosnumericos.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen3_pantalla13_datosnumericos=(ImageView)findViewById(R.id.imagen3_pantalla13_datosnumericos);
            imagen3_pantalla13_datosnumericos.setImageBitmap(bm);
        }
        if(ventana_datosnum==14){
            setContentView(R.layout.pantalla14_datosnumericos);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia8/autoevaluacion.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen1_pantalla14_datosnumericos=(ImageView)findViewById(R.id.imagen1_pantalla14_datosnumericos);
            imagen1_pantalla14_datosnumericos.setImageBitmap(bm);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia8/ilustracion1_pantalla14_datosnumericos.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen2_pantalla14_datosnumericos=(ImageView)findViewById(R.id.imagen2_pantalla14_datosnumericos);
            imagen2_pantalla14_datosnumericos.setImageBitmap(bm);
        }
        if(ventana_datosnum==15){
            setContentView(R.layout.pantalla15_datosnumericos);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia8/autoevaluacion.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen1_pantalla15_datosnumericos=(ImageView)findViewById(R.id.imagen1_pantalla15_datosnumericos);
            imagen1_pantalla15_datosnumericos.setImageBitmap(bm);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia8/ilustracion1_pantalla15_datosnumericos.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen2_pantalla15_datosnumericos=(ImageView)findViewById(R.id.imagen2_pantalla15_datosnumericos);
            imagen2_pantalla15_datosnumericos.setImageBitmap(bm);
        }
        if(ventana_datosnum==16){
            setContentView(R.layout.pantalla16_datosnumericos);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia8/autoevaluacion.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen1_pantalla16_datosnumericos=(ImageView)findViewById(R.id.imagen1_pantalla16_datosnumericos);
            imagen1_pantalla16_datosnumericos.setImageBitmap(bm);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia8/ilustracion1_pantalla16_datosnumericos.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen2_pantalla16_datosnumericos=(ImageView)findViewById(R.id.imagen2_pantalla16_datosnumericos);
            imagen2_pantalla16_datosnumericos.setImageBitmap(bm);
        }
        if(ventana_datosnum==17){
            setContentView(R.layout.pantalla17_datosnumericos);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia8/autoevaluacion.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen1_pantalla17_datosnumericos=(ImageView)findViewById(R.id.imagen1_pantalla17_datosnumericos);
            imagen1_pantalla17_datosnumericos.setImageBitmap(bm);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia8/ilustracion1_pantalla17_datosnumericos.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen2_pantalla17_datosnumericos=(ImageView)findViewById(R.id.imagen2_pantalla17_datosnumericos);
            imagen2_pantalla17_datosnumericos.setImageBitmap(bm);
        }
        if(ventana_datosnum==18){
            setContentView(R.layout.pantalla18_datosnumericos);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia8/autoevaluacion.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen1_pantalla18_datosnumericos=(ImageView)findViewById(R.id.imagen1_pantalla18_datosnumericos);
            imagen1_pantalla18_datosnumericos.setImageBitmap(bm);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia8/grafica1_autoevaluacion_datosnumericos.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen2_pantalla18_datosnumericos=(ImageView)findViewById(R.id.imagen2_pantalla18_datosnumericos);
            imagen2_pantalla18_datosnumericos.setImageBitmap(bm);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia8/ilustracion1_pantalla18_datosnumericos.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen3_pantalla18_datosnumericos=(ImageView)findViewById(R.id.imagen3_pantalla18_datosnumericos);
            imagen3_pantalla18_datosnumericos.setImageBitmap(bm);
        }
        if(ventana_datosnum==19){
            setContentView(R.layout.pantalla19_datosnumericos);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia8/autoevaluacion.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen1_pantalla19_datosnumericos=(ImageView)findViewById(R.id.imagen1_pantalla19_datosnumericos);
            imagen1_pantalla19_datosnumericos.setImageBitmap(bm);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia8/grafica1_autoevaluacion_datosnumericos.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen2_pantalla19_datosnumericos=(ImageView)findViewById(R.id.imagen2_pantalla19_datosnumericos);
            imagen2_pantalla19_datosnumericos.setImageBitmap(bm);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia8/ilustracion1_pantalla19_datosnumericos.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen3_pantalla19_datosnumericos=(ImageView)findViewById(R.id.imagen3_pantalla19_datosnumericos);
            imagen3_pantalla19_datosnumericos.setImageBitmap(bm);
        }
        if(ventana_datosnum==20){
            setContentView(R.layout.pantalla20_datosnumericos);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia8/autoevaluacion.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen1_pantalla20_datosnumericos=(ImageView)findViewById(R.id.imagen1_pantalla20_datosnumericos);
            imagen1_pantalla20_datosnumericos.setImageBitmap(bm);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia8/grafica1_autoevaluacion_datosnumericos.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen2_pantalla20_datosnumericos=(ImageView)findViewById(R.id.imagen2_pantalla20_datosnumericos);
            imagen2_pantalla20_datosnumericos.setImageBitmap(bm);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia8/ilustracion1_pantalla20_datosnumericos.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen3_pantalla20_datosnumericos=(ImageView)findViewById(R.id.imagen3_pantalla20_datosnumericos);
            imagen3_pantalla20_datosnumericos.setImageBitmap(bm);
        }
        if(ventana_datosnum==21){
            setContentView(R.layout.pantalla21_datosnumericos);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia8/autoevaluacion.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen1_pantalla21_datosnumericos=(ImageView)findViewById(R.id.imagen1_pantalla21_datosnumericos);
            imagen1_pantalla21_datosnumericos.setImageBitmap(bm);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia8/grafica1_autoevaluacion_datosnumericos.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen2_pantalla21_datosnumericos=(ImageView)findViewById(R.id.imagen2_pantalla21_datosnumericos);
            imagen2_pantalla21_datosnumericos.setImageBitmap(bm);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia8/ilustracion1_pantalla21_datosnumericos.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen3_pantalla21_datosnumericos=(ImageView)findViewById(R.id.imagen3_pantalla21_datosnumericos);
            imagen3_pantalla21_datosnumericos.setImageBitmap(bm);
        }
        if(ventana_datosnum==22){
            setContentView(R.layout.pantalla22_datosnumericos);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia8/autoevaluacion.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen1_pantalla22_datosnumericos=(ImageView)findViewById(R.id.imagen1_pantalla22_datosnumericos);
            imagen1_pantalla22_datosnumericos.setImageBitmap(bm);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia8/grafica1_autoevaluacion_datosnumericos.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen2_pantalla22_datosnumericos=(ImageView)findViewById(R.id.imagen2_pantalla22_datosnumericos);
            imagen2_pantalla22_datosnumericos.setImageBitmap(bm);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia8/ilustracion1_pantalla22_datosnumericos.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen3_pantalla22_datosnumericos=(ImageView)findViewById(R.id.imagen3_pantalla22_datosnumericos);
            imagen3_pantalla22_datosnumericos.setImageBitmap(bm);
        }
        if(ventana_datosnum==23){
            setContentView(R.layout.pantalla23_datosnumericos);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia8/autoevaluacion.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen1_pantalla23_datosnumericos=(ImageView)findViewById(R.id.imagen1_pantalla23_datosnumericos);
            imagen1_pantalla23_datosnumericos.setImageBitmap(bm);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia8/grafica2_autoevaluacion_datosnumericos.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen2_pantalla23_datosnumericos=(ImageView)findViewById(R.id.imagen2_pantalla23_datosnumericos);
            imagen2_pantalla23_datosnumericos.setImageBitmap(bm);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia8/ilustracion1_pantalla23_datosnumericos.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen3_pantalla23_datosnumericos=(ImageView)findViewById(R.id.imagen3_pantalla23_datosnumericos);
            imagen3_pantalla23_datosnumericos.setImageBitmap(bm);
        }
        if(ventana_datosnum==24){
            setContentView(R.layout.pantalla24_datosnumericos);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia8/autoevaluacion.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen1_pantalla24_datosnumericos=(ImageView)findViewById(R.id.imagen1_pantalla24_datosnumericos);
            imagen1_pantalla24_datosnumericos.setImageBitmap(bm);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia8/grafica2_autoevaluacion_datosnumericos.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen2_pantalla24_datosnumericos=(ImageView)findViewById(R.id.imagen2_pantalla24_datosnumericos);
            imagen2_pantalla24_datosnumericos.setImageBitmap(bm);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia8/ilustracion1_pantalla24_datosnumericos.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen3_pantalla24_datosnumericos=(ImageView)findViewById(R.id.imagen3_pantalla24_datosnumericos);
            imagen3_pantalla24_datosnumericos.setImageBitmap(bm);
        }
        if(ventana_datosnum==25){
            setContentView(R.layout.pantalla25_datosnumericos);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia8/autoevaluacion.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen1_pantalla25_datosnumericos=(ImageView)findViewById(R.id.imagen1_pantalla25_datosnumericos);
            imagen1_pantalla25_datosnumericos.setImageBitmap(bm);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia8/grafica2_autoevaluacion_datosnumericos.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen2_pantalla25_datosnumericos=(ImageView)findViewById(R.id.imagen2_pantalla25_datosnumericos);
            imagen2_pantalla25_datosnumericos.setImageBitmap(bm);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia8/ilustracion1_pantalla25_datosnumericos.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen3_pantalla25_datosnumericos=(ImageView)findViewById(R.id.imagen3_pantalla25_datosnumericos);
            imagen3_pantalla25_datosnumericos.setImageBitmap(bm);
        }
        if(ventana_datosnum==26){
            setContentView(R.layout.pantalla26_datosnumericos);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia8/autoevaluacion.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen1_pantalla26_datosnumericos=(ImageView)findViewById(R.id.imagen1_pantalla26_datosnumericos);
            imagen1_pantalla26_datosnumericos.setImageBitmap(bm);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia8/grafica2_autoevaluacion_datosnumericos.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen2_pantalla26_datosnumericos=(ImageView)findViewById(R.id.imagen2_pantalla26_datosnumericos);
            imagen2_pantalla26_datosnumericos.setImageBitmap(bm);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia8/ilustracion1_pantalla26_datosnumericos.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen3_pantalla26_datosnumericos=(ImageView)findViewById(R.id.imagen3_pantalla26_datosnumericos);
            imagen3_pantalla26_datosnumericos.setImageBitmap(bm);
        }
        if(ventana_datosnum==27){
            setContentView(R.layout.pantalla27_datosnumericos);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia8/autoevaluacion.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen1_pantalla27_datosnumericos=(ImageView)findViewById(R.id.imagen1_pantalla27_datosnumericos);
            imagen1_pantalla27_datosnumericos.setImageBitmap(bm);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia8/grafica2_autoevaluacion_datosnumericos.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen2_pantalla27_datosnumericos=(ImageView)findViewById(R.id.imagen2_pantalla27_datosnumericos);
            imagen2_pantalla27_datosnumericos.setImageBitmap(bm);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia8/ilustracion1_pantalla27_datosnumericos.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen3_pantalla27_datosnumericos=(ImageView)findViewById(R.id.imagen3_pantalla27_datosnumericos);
            imagen3_pantalla27_datosnumericos.setImageBitmap(bm);
        }
        if(ventana_datosnum==28){
            setContentView(R.layout.pantalla28_datosnumericos);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia8/ilustracion3_pantalla28_datosnumericos.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen3_pantalla28_datosnumericos=(ImageView)findViewById(R.id.imagen3_pantalla28_datosnumericos);
            imagen3_pantalla28_datosnumericos.setImageBitmap(bm);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia8/menu_datosnumericos.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen4_pantalla28_datosnumericos=(ImageView)findViewById(R.id.imagen4_pantalla28_datosnumericos);
            imagen4_pantalla28_datosnumericos.setImageBitmap(bm);
            if(correctas8==14){
                carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia8/estrella_bien_datosnumericos.zip");
                bm = BitmapFactory.decodeFile(String.valueOf(carga));
                estrella1_pantalla28_datosnumericos=(ImageView)findViewById(R.id.estrella1_pantalla28_datosnumericos);
                estrella1_pantalla28_datosnumericos.setImageBitmap(bm);
                estrella2_pantalla28_datosnumericos=(ImageView)findViewById(R.id.estrella2_pantalla28_datosnumericos);
                estrella2_pantalla28_datosnumericos.setImageBitmap(bm);
                estrella3_pantalla28_datosnumericos=(ImageView)findViewById(R.id.estrella3_pantalla28_datosnumericos);
                estrella3_pantalla28_datosnumericos.setImageBitmap(bm);
                estrella4_pantalla28_datosnumericos=(ImageView)findViewById(R.id.estrella4_pantalla28_datosnumericos);
                estrella4_pantalla28_datosnumericos.setImageBitmap(bm);
                estrella5_pantalla28_datosnumericos=(ImageView)findViewById(R.id.estrella5_pantalla28_datosnumericos);
                estrella5_pantalla28_datosnumericos.setImageBitmap(bm);
                carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia8/ilustracion1_bien_pantalla28_datosnumericos.zip");
                bm = BitmapFactory.decodeFile(String.valueOf(carga));
                imagen1_pantalla28_datosnumericos=(ImageView)findViewById(R.id.imagen1_pantalla28_datosnumericos);
                imagen1_pantalla28_datosnumericos.setImageBitmap(bm);
                texto1_pantalla28_datosnumericos=(TextView)findViewById(R.id.texto1_pantalla28_datosnumericos);
                texto1_pantalla28_datosnumericos.setText("¡Felicidades!");
                texto1_pantalla28_datosnumericos.setTextColor(Color.parseColor("#FF1CA7C0"));
                texto2_pantalla28_datosnumericos=(TextView)findViewById(R.id.texto2_pantalla28_datosnumericos);
                texto2_pantalla28_datosnumericos.setText("CON UN TOTAL DE: 14 ACIERTOS");
                texto3_pantalla28_datosnumericos=(TextView)findViewById(R.id.texto3_pantalla28_datosnumericos);
                texto3_pantalla28_datosnumericos.setText("Concluíste con éxito la guía de aprendizaje:");
            }
            else{
                texto1_pantalla28_datosnumericos=(TextView)findViewById(R.id.texto1_pantalla28_datosnumericos);
                texto1_pantalla28_datosnumericos.setText("Inténtalo de nuevo");
                texto1_pantalla28_datosnumericos.setTextColor(Color.parseColor("#FF717171"));
                carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia8/ilustracion1_mal_pantalla28_datosnumericos.zip");
                bm = BitmapFactory.decodeFile(String.valueOf(carga));
                imagen1_pantalla28_datosnumericos=(ImageView)findViewById(R.id.imagen1_pantalla28_datosnumericos);
                imagen1_pantalla28_datosnumericos.setImageBitmap(bm);
                carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia8/ilustracion2_pantalla28_datosnumericos.zip");
                bm = BitmapFactory.decodeFile(String.valueOf(carga));
                imagen2_pantalla28_datosnumericos=(ImageView)findViewById(R.id.imagen2_pantalla28_datosnumericos);
                imagen2_pantalla28_datosnumericos.setImageBitmap(bm);
                if(correctas8>=3 && correctas8<6){
                    carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia8/estrella_bien_datosnumericos.zip");
                    bm = BitmapFactory.decodeFile(String.valueOf(carga));
                    estrella1_pantalla28_datosnumericos=(ImageView)findViewById(R.id.estrella1_pantalla28_datosnumericos);
                    estrella1_pantalla28_datosnumericos.setImageBitmap(bm);
                    carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia8/estrella_mal_datosnumericos.zip");
                    bm = BitmapFactory.decodeFile(String.valueOf(carga));
                    estrella2_pantalla28_datosnumericos=(ImageView)findViewById(R.id.estrella2_pantalla28_datosnumericos);
                    estrella2_pantalla28_datosnumericos.setImageBitmap(bm);
                    estrella3_pantalla28_datosnumericos=(ImageView)findViewById(R.id.estrella3_pantalla28_datosnumericos);
                    estrella3_pantalla28_datosnumericos.setImageBitmap(bm);
                    estrella4_pantalla28_datosnumericos=(ImageView)findViewById(R.id.estrella4_pantalla28_datosnumericos);
                    estrella4_pantalla28_datosnumericos.setImageBitmap(bm);
                    estrella5_pantalla28_datosnumericos=(ImageView)findViewById(R.id.estrella5_pantalla28_datosnumericos);
                    estrella5_pantalla28_datosnumericos.setImageBitmap(bm);
                }
                else{
                    if(correctas8>=6 && correctas8<9){
                        carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia8/estrella_bien_datosnumericos.zip");
                        bm = BitmapFactory.decodeFile(String.valueOf(carga));
                        estrella1_pantalla28_datosnumericos=(ImageView)findViewById(R.id.estrella1_pantalla28_datosnumericos);
                        estrella1_pantalla28_datosnumericos.setImageBitmap(bm);
                        estrella2_pantalla28_datosnumericos=(ImageView)findViewById(R.id.estrella2_pantalla28_datosnumericos);
                        estrella2_pantalla28_datosnumericos.setImageBitmap(bm);
                        carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia8/estrella_mal_datosnumericos.zip");
                        bm = BitmapFactory.decodeFile(String.valueOf(carga));
                        estrella3_pantalla28_datosnumericos=(ImageView)findViewById(R.id.estrella3_pantalla28_datosnumericos);
                        estrella3_pantalla28_datosnumericos.setImageBitmap(bm);
                        estrella4_pantalla28_datosnumericos=(ImageView)findViewById(R.id.estrella4_pantalla28_datosnumericos);
                        estrella4_pantalla28_datosnumericos.setImageBitmap(bm);
                        estrella5_pantalla28_datosnumericos=(ImageView)findViewById(R.id.estrella5_pantalla28_datosnumericos);
                        estrella5_pantalla28_datosnumericos.setImageBitmap(bm);
                    }
                    else{
                        if(correctas8>=9 && correctas8<12){
                            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia8/estrella_bien_datosnumericos.zip");
                            bm = BitmapFactory.decodeFile(String.valueOf(carga));
                            estrella1_pantalla28_datosnumericos=(ImageView)findViewById(R.id.estrella1_pantalla28_datosnumericos);
                            estrella1_pantalla28_datosnumericos.setImageBitmap(bm);
                            estrella2_pantalla28_datosnumericos=(ImageView)findViewById(R.id.estrella2_pantalla28_datosnumericos);
                            estrella2_pantalla28_datosnumericos.setImageBitmap(bm);
                            estrella3_pantalla28_datosnumericos=(ImageView)findViewById(R.id.estrella3_pantalla28_datosnumericos);
                            estrella3_pantalla28_datosnumericos.setImageBitmap(bm);
                            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia8/estrella_mal_datosnumericos.zip");
                            bm = BitmapFactory.decodeFile(String.valueOf(carga));
                            estrella4_pantalla28_datosnumericos=(ImageView)findViewById(R.id.estrella4_pantalla28_datosnumericos);
                            estrella4_pantalla28_datosnumericos.setImageBitmap(bm);
                            estrella5_pantalla28_datosnumericos=(ImageView)findViewById(R.id.estrella5_pantalla28_datosnumericos);
                            estrella5_pantalla28_datosnumericos.setImageBitmap(bm);
                        }
                        else{
                            if(correctas8>=12 && correctas8<14){
                                carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia8/estrella_bien_datosnumericos.zip");
                                bm = BitmapFactory.decodeFile(String.valueOf(carga));
                                estrella1_pantalla28_datosnumericos=(ImageView)findViewById(R.id.estrella1_pantalla28_datosnumericos);
                                estrella1_pantalla28_datosnumericos.setImageBitmap(bm);
                                estrella2_pantalla28_datosnumericos=(ImageView)findViewById(R.id.estrella2_pantalla28_datosnumericos);
                                estrella2_pantalla28_datosnumericos.setImageBitmap(bm);
                                estrella3_pantalla28_datosnumericos=(ImageView)findViewById(R.id.estrella3_pantalla28_datosnumericos);
                                estrella3_pantalla28_datosnumericos.setImageBitmap(bm);
                                estrella4_pantalla28_datosnumericos=(ImageView)findViewById(R.id.estrella4_pantalla28_datosnumericos);
                                estrella4_pantalla28_datosnumericos.setImageBitmap(bm);
                                carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia8/estrella_mal_datosnumericos.zip");
                                bm = BitmapFactory.decodeFile(String.valueOf(carga));
                                estrella5_pantalla28_datosnumericos=(ImageView)findViewById(R.id.estrella5_pantalla28_datosnumericos);
                                estrella5_pantalla28_datosnumericos.setImageBitmap(bm);
                            }
                            else{
                                carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia8/estrella_mal_datosnumericos.zip");
                                bm = BitmapFactory.decodeFile(String.valueOf(carga));
                                estrella1_pantalla28_datosnumericos=(ImageView)findViewById(R.id.estrella1_pantalla28_datosnumericos);
                                estrella1_pantalla28_datosnumericos.setImageBitmap(bm);
                                estrella2_pantalla28_datosnumericos=(ImageView)findViewById(R.id.estrella2_pantalla28_datosnumericos);
                                estrella2_pantalla28_datosnumericos.setImageBitmap(bm);
                                estrella3_pantalla28_datosnumericos=(ImageView)findViewById(R.id.estrella3_pantalla28_datosnumericos);
                                estrella3_pantalla28_datosnumericos.setImageBitmap(bm);
                                estrella4_pantalla28_datosnumericos=(ImageView)findViewById(R.id.estrella4_pantalla28_datosnumericos);
                                estrella4_pantalla28_datosnumericos.setImageBitmap(bm);
                                estrella5_pantalla28_datosnumericos=(ImageView)findViewById(R.id.estrella5_pantalla28_datosnumericos);
                                estrella5_pantalla28_datosnumericos.setImageBitmap(bm);
                            }
                        }
                    }
                }
            }
        }
        if(ventana_datosnum==29){
            setContentView(R.layout.pantalla29_datosnumericos);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia8/salir_datosnumericos.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen1_pantalla29_datosnumericos=(ImageView)findViewById(R.id.imagen1_pantalla29_datosnumericos);
            imagen1_pantalla29_datosnumericos.setImageBitmap(bm);
        }
        validaudio(ventana_datosnum);
    }

    public void validaVentana9(){
        if (ventana_capacidades == 1) {
            setContentView(R.layout.pantalla1_capacidadesparaelaprendizaje);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/portada_capacidadesparaelaprendizaje.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            bmDrawable = new BitmapDrawable(bm);
            fondo1_pantalla1_capacidadesparaelaprendizaje = (LinearLayout) findViewById(R.id.fondo1_pantalla1_capacidadesparaelaprendizaje);
            fondo1_pantalla1_capacidadesparaelaprendizaje.setBackgroundDrawable(bmDrawable);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/ilustracion_pantalla1_capacidadesparaelaprendizaje.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen1_pantalla1_capacidadesparaelaprendizaje = (ImageView) findViewById(R.id.imagen1_pantalla1_capacidadesparaelaprendizaje);
            imagen1_pantalla1_capacidadesparaelaprendizaje.setImageBitmap(bm);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/comenzar_capacidadesparaelaprendizaje.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            bmDrawable = new BitmapDrawable(bm);
            comenzar_capacidadesparaelaprendizaje = (ImageView) findViewById(R.id.comenzar_capacidadesparaelaprendizaje);
            comenzar_capacidadesparaelaprendizaje.setBackgroundDrawable(bmDrawable);
        }
        if (ventana_capacidades == 2) {
            setContentView(R.layout.pantalla2_capacidadesparaelaprendizaje);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/texto_pantalla2_capacidadesparaelaprendizaje.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen1_pantalla2_capacidadesparaelaprendizaje = (ImageView) findViewById(R.id.imagen1_pantalla2_capacidadesparaelaprendizaje);
            imagen1_pantalla2_capacidadesparaelaprendizaje.setImageBitmap(bm);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/menu_pantalla2_capacidadesparaelaprendizaje.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            menu_pantallas2_capacidadesparaelaprendizaje = (ImageView) findViewById(R.id.menu_pantallas2_capacidadesparaelaprendizaje);
            menu_pantallas2_capacidadesparaelaprendizaje.setImageBitmap(bm);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/ilustracion_pantalla2_capacidadesparaelaprendizaje.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen2_pantalla2_capacidadesparaelaprendizaje = (ImageView) findViewById(R.id.imagen2_pantalla2_capacidadesparaelaprendizaje);
            imagen2_pantalla2_capacidadesparaelaprendizaje.setImageBitmap(bm);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/boton_anterior_capacidadesparaelaprendizaje.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen3_pantalla2_capacidadesparaelaprendizaje = (ImageView) findViewById(R.id.imagen3_pantalla2_capacidadesparaelaprendizaje);
            imagen3_pantalla2_capacidadesparaelaprendizaje.setImageBitmap(bm);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/texto_anterior_capacidadesparaelaprendizaje.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen4_pantalla2_capacidadesparaelaprendizaje = (ImageView) findViewById(R.id.imagen4_pantalla2_capacidadesparaelaprendizaje);
            imagen4_pantalla2_capacidadesparaelaprendizaje.setImageBitmap(bm);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/texto_siguiente_capacidadesparaelaprendizaje.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen5_pantalla2_capacidadesparaelaprendizaje = (ImageView) findViewById(R.id.imagen5_pantalla2_capacidadesparaelaprendizaje);
            imagen5_pantalla2_capacidadesparaelaprendizaje.setImageBitmap(bm);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/boton_siguiente_capacidadesparaelaprendizaje.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen6_pantalla2_capacidadesparaelaprendizaje = (ImageView) findViewById(R.id.imagen6_pantalla2_capacidadesparaelaprendizaje);
            imagen6_pantalla2_capacidadesparaelaprendizaje.setImageBitmap(bm);
        }
        if (ventana_capacidades == 3) {
            setContentView(R.layout.pantalla3_capacidadesparaelaprendizaje);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/texto_pantalla3_capacidadesparaelaprendizaje.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen1_pantalla3_capacidadesparaelaprendizaje = (ImageView) findViewById(R.id.imagen1_pantalla3_capacidadesparaelaprendizaje);
            imagen1_pantalla3_capacidadesparaelaprendizaje.setImageBitmap(bm);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/ilustracion_pantalla3_capacidadesparaelaprendizaje.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen2_pantalla3_capacidadesparaelaprendizaje = (ImageView) findViewById(R.id.imagen2_pantalla3_capacidadesparaelaprendizaje);
            imagen2_pantalla3_capacidadesparaelaprendizaje.setImageBitmap(bm);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/boton_anterior_capacidadesparaelaprendizaje.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen3_pantalla3_capacidadesparaelaprendizaje = (ImageView) findViewById(R.id.imagen3_pantalla3_capacidadesparaelaprendizaje);
            imagen3_pantalla3_capacidadesparaelaprendizaje.setImageBitmap(bm);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/texto_anterior_capacidadesparaelaprendizaje.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen4_pantalla3_capacidadesparaelaprendizaje = (ImageView) findViewById(R.id.imagen4_pantalla3_capacidadesparaelaprendizaje);
            imagen4_pantalla3_capacidadesparaelaprendizaje.setImageBitmap(bm);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/texto_siguiente_capacidadesparaelaprendizaje.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen5_pantalla3_capacidadesparaelaprendizaje = (ImageView) findViewById(R.id.imagen5_pantalla3_capacidadesparaelaprendizaje);
            imagen5_pantalla3_capacidadesparaelaprendizaje.setImageBitmap(bm);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/boton_siguiente_capacidadesparaelaprendizaje.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen6_pantalla3_capacidadesparaelaprendizaje = (ImageView) findViewById(R.id.imagen6_pantalla3_capacidadesparaelaprendizaje);
            imagen6_pantalla3_capacidadesparaelaprendizaje.setImageBitmap(bm);
        }
        if (ventana_capacidades == 4) {
            setContentView(R.layout.pantalla4_capacidadesparaelaprendizaje);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/texto_pantalla4_capacidadesparaelaprendizaje.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen1_pantalla4_capacidadesparaelaprendizaje = (ImageView) findViewById(R.id.imagen1_pantalla4_capacidadesparaelaprendizaje);
            imagen1_pantalla4_capacidadesparaelaprendizaje.setImageBitmap(bm);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/ilustracion_pantalla4_capacidadesparaelaprendizaje.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen2_pantalla4_capacidadesparaelaprendizaje = (ImageView) findViewById(R.id.imagen2_pantalla4_capacidadesparaelaprendizaje);
            imagen2_pantalla4_capacidadesparaelaprendizaje.setImageBitmap(bm);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/boton_anterior_capacidadesparaelaprendizaje.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen3_pantalla4_capacidadesparaelaprendizaje = (ImageView) findViewById(R.id.imagen3_pantalla4_capacidadesparaelaprendizaje);
            imagen3_pantalla4_capacidadesparaelaprendizaje.setImageBitmap(bm);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/texto_anterior_capacidadesparaelaprendizaje.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen4_pantalla4_capacidadesparaelaprendizaje = (ImageView) findViewById(R.id.imagen4_pantalla4_capacidadesparaelaprendizaje);
            imagen4_pantalla4_capacidadesparaelaprendizaje.setImageBitmap(bm);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/texto_siguiente_capacidadesparaelaprendizaje.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen5_pantalla4_capacidadesparaelaprendizaje = (ImageView) findViewById(R.id.imagen5_pantalla4_capacidadesparaelaprendizaje);
            imagen5_pantalla4_capacidadesparaelaprendizaje.setImageBitmap(bm);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/boton_siguiente_capacidadesparaelaprendizaje.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen6_pantalla4_capacidadesparaelaprendizaje = (ImageView) findViewById(R.id.imagen6_pantalla4_capacidadesparaelaprendizaje);
            imagen6_pantalla4_capacidadesparaelaprendizaje.setImageBitmap(bm);
        }
        if (ventana_capacidades == 5) {
            setContentView(R.layout.pantalla5_capacidadesparaelaprendizaje);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/texto_superior_capacidadesparaelaprendizaje.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen1_pantalla5_capacidadesparaelaprendizaje = (ImageView) findViewById(R.id.imagen1_pantalla5_capacidadesparaelaprendizaje);
            imagen1_pantalla5_capacidadesparaelaprendizaje.setImageBitmap(bm);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/texto_pantalla5_capacidadesparaelaprendizaje.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            bmDrawable = new BitmapDrawable(bm);
            fondo1_pantalla5_capacidadesparaelaprendizaje = (ImageView) findViewById(R.id.fondo1_pantalla5_capacidadesparaelaprendizaje);
            fondo1_pantalla5_capacidadesparaelaprendizaje.setBackgroundDrawable(bmDrawable);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/rectangulo1_capacidadesparaelaprendizaje.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen2_pantalla5_capacidadesparaelaprendizaje = (ImageView) findViewById(R.id.imagen2_pantalla5_capacidadesparaelaprendizaje);
            imagen2_pantalla5_capacidadesparaelaprendizaje.setImageBitmap(bm);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/boton_anterior_capacidadesparaelaprendizaje.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen3_pantalla5_capacidadesparaelaprendizaje = (ImageView) findViewById(R.id.imagen3_pantalla5_capacidadesparaelaprendizaje);
            imagen3_pantalla5_capacidadesparaelaprendizaje.setImageBitmap(bm);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/texto_anterior_capacidadesparaelaprendizaje.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen4_pantalla5_capacidadesparaelaprendizaje = (ImageView) findViewById(R.id.imagen4_pantalla5_capacidadesparaelaprendizaje);
            imagen4_pantalla5_capacidadesparaelaprendizaje.setImageBitmap(bm);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/texto_siguiente_capacidadesparaelaprendizaje.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen5_pantalla5_capacidadesparaelaprendizaje = (ImageView) findViewById(R.id.imagen5_pantalla5_capacidadesparaelaprendizaje);
            imagen5_pantalla5_capacidadesparaelaprendizaje.setImageBitmap(bm);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/boton_siguiente_capacidadesparaelaprendizaje.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen6_pantalla5_capacidadesparaelaprendizaje = (ImageView) findViewById(R.id.imagen6_pantalla5_capacidadesparaelaprendizaje);
            imagen6_pantalla5_capacidadesparaelaprendizaje.setImageBitmap(bm);
        }
        if (ventana_capacidades == 6) {
            setContentView(R.layout.pantalla6_capacidadesparaelaprendizaje);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/texto_superior_capacidadesparaelaprendizaje.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen1_pantalla6_capacidadesparaelaprendizaje = (ImageView) findViewById(R.id.imagen1_pantalla6_capacidadesparaelaprendizaje);
            imagen1_pantalla6_capacidadesparaelaprendizaje.setImageBitmap(bm);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/texto_pantalla6_capacidadesparaelaprendizaje.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            bmDrawable = new BitmapDrawable(bm);
            fondo1_pantalla6_capacidadesparaelaprendizaje = (ImageView) findViewById(R.id.fondo1_pantalla6_capacidadesparaelaprendizaje);
            fondo1_pantalla6_capacidadesparaelaprendizaje.setBackgroundDrawable(bmDrawable);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/rectangulo1_capacidadesparaelaprendizaje.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen2_pantalla6_capacidadesparaelaprendizaje = (ImageView) findViewById(R.id.imagen2_pantalla6_capacidadesparaelaprendizaje);
            imagen2_pantalla6_capacidadesparaelaprendizaje.setImageBitmap(bm);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/rectangulo2_capacidadesparaelaprendizaje.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen3_pantalla6_capacidadesparaelaprendizaje = (ImageView) findViewById(R.id.imagen3_pantalla6_capacidadesparaelaprendizaje);
            imagen3_pantalla6_capacidadesparaelaprendizaje.setImageBitmap(bm);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/boton_anterior_capacidadesparaelaprendizaje.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen4_pantalla6_capacidadesparaelaprendizaje = (ImageView) findViewById(R.id.imagen4_pantalla6_capacidadesparaelaprendizaje);
            imagen4_pantalla6_capacidadesparaelaprendizaje.setImageBitmap(bm);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/texto_anterior_capacidadesparaelaprendizaje.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen5_pantalla6_capacidadesparaelaprendizaje = (ImageView) findViewById(R.id.imagen5_pantalla6_capacidadesparaelaprendizaje);
            imagen5_pantalla6_capacidadesparaelaprendizaje.setImageBitmap(bm);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/texto_siguiente_capacidadesparaelaprendizaje.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen6_pantalla6_capacidadesparaelaprendizaje = (ImageView) findViewById(R.id.imagen6_pantalla6_capacidadesparaelaprendizaje);
            imagen6_pantalla6_capacidadesparaelaprendizaje.setImageBitmap(bm);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/boton_siguiente_capacidadesparaelaprendizaje.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen7_pantalla6_capacidadesparaelaprendizaje = (ImageView) findViewById(R.id.imagen7_pantalla6_capacidadesparaelaprendizaje);
            imagen7_pantalla6_capacidadesparaelaprendizaje.setImageBitmap(bm);
        }
        if (ventana_capacidades == 7) {
            setContentView(R.layout.pantalla7_capacidadesparaelaprendizaje);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/texto_superior_capacidadesparaelaprendizaje.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen1_pantalla7_capacidadesparaelaprendizaje = (ImageView) findViewById(R.id.imagen1_pantalla7_capacidadesparaelaprendizaje);
            imagen1_pantalla7_capacidadesparaelaprendizaje.setImageBitmap(bm);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/texto_pantalla7_capacidadesparaelaprendizaje.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            bmDrawable = new BitmapDrawable(bm);
            fondo1_pantalla7_capacidadesparaelaprendizaje = (ImageView) findViewById(R.id.fondo1_pantalla7_capacidadesparaelaprendizaje);
            fondo1_pantalla7_capacidadesparaelaprendizaje.setBackgroundDrawable(bmDrawable);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/rectangulo1_capacidadesparaelaprendizaje.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen2_pantalla7_capacidadesparaelaprendizaje = (ImageView) findViewById(R.id.imagen2_pantalla7_capacidadesparaelaprendizaje);
            imagen2_pantalla7_capacidadesparaelaprendizaje.setImageBitmap(bm);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/rectangulo2_capacidadesparaelaprendizaje.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen3_pantalla7_capacidadesparaelaprendizaje = (ImageView) findViewById(R.id.imagen3_pantalla7_capacidadesparaelaprendizaje);
            imagen3_pantalla7_capacidadesparaelaprendizaje.setImageBitmap(bm);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/rectangulo3_capacidadesparaelaprendizaje.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen4_pantalla7_capacidadesparaelaprendizaje = (ImageView) findViewById(R.id.imagen4_pantalla7_capacidadesparaelaprendizaje);
            imagen4_pantalla7_capacidadesparaelaprendizaje.setImageBitmap(bm);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/boton_anterior_capacidadesparaelaprendizaje.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen5_pantalla7_capacidadesparaelaprendizaje = (ImageView) findViewById(R.id.imagen5_pantalla7_capacidadesparaelaprendizaje);
            imagen5_pantalla7_capacidadesparaelaprendizaje.setImageBitmap(bm);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/texto_anterior_capacidadesparaelaprendizaje.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen6_pantalla7_capacidadesparaelaprendizaje = (ImageView) findViewById(R.id.imagen6_pantalla7_capacidadesparaelaprendizaje);
            imagen6_pantalla7_capacidadesparaelaprendizaje.setImageBitmap(bm);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/texto_siguiente_capacidadesparaelaprendizaje.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen7_pantalla7_capacidadesparaelaprendizaje = (ImageView) findViewById(R.id.imagen7_pantalla7_capacidadesparaelaprendizaje);
            imagen7_pantalla7_capacidadesparaelaprendizaje.setImageBitmap(bm);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/boton_siguiente_capacidadesparaelaprendizaje.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen8_pantalla7_capacidadesparaelaprendizaje = (ImageView) findViewById(R.id.imagen8_pantalla7_capacidadesparaelaprendizaje);
            imagen8_pantalla7_capacidadesparaelaprendizaje.setImageBitmap(bm);
        }
        if (ventana_capacidades == 8) {
            setContentView(R.layout.pantalla8_capacidadesparaelaprendizaje);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/texto_superior_capacidadesparaelaprendizaje.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen1_pantalla8_capacidadesparaelaprendizaje = (ImageView) findViewById(R.id.imagen1_pantalla8_capacidadesparaelaprendizaje);
            imagen1_pantalla8_capacidadesparaelaprendizaje.setImageBitmap(bm);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/texto_pantalla8_capacidadesparaelaprendizaje.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            bmDrawable = new BitmapDrawable(bm);
            fondo1_pantalla8_capacidadesparaelaprendizaje = (ImageView) findViewById(R.id.fondo1_pantalla8_capacidadesparaelaprendizaje);
            fondo1_pantalla8_capacidadesparaelaprendizaje.setBackgroundDrawable(bmDrawable);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/rectangulo1_capacidadesparaelaprendizaje.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen2_pantalla8_capacidadesparaelaprendizaje = (ImageView) findViewById(R.id.imagen2_pantalla8_capacidadesparaelaprendizaje);
            imagen2_pantalla8_capacidadesparaelaprendizaje.setImageBitmap(bm);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/rectangulo2_capacidadesparaelaprendizaje.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen3_pantalla8_capacidadesparaelaprendizaje = (ImageView) findViewById(R.id.imagen3_pantalla8_capacidadesparaelaprendizaje);
            imagen3_pantalla8_capacidadesparaelaprendizaje.setImageBitmap(bm);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/rectangulo3_capacidadesparaelaprendizaje.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen4_pantalla8_capacidadesparaelaprendizaje = (ImageView) findViewById(R.id.imagen4_pantalla8_capacidadesparaelaprendizaje);
            imagen4_pantalla8_capacidadesparaelaprendizaje.setImageBitmap(bm);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/rectangulo4_capacidadesparaelaprendizaje.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen5_pantalla8_capacidadesparaelaprendizaje = (ImageView) findViewById(R.id.imagen5_pantalla8_capacidadesparaelaprendizaje);
            imagen5_pantalla8_capacidadesparaelaprendizaje.setImageBitmap(bm);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/boton_anterior_capacidadesparaelaprendizaje.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen6_pantalla8_capacidadesparaelaprendizaje = (ImageView) findViewById(R.id.imagen6_pantalla8_capacidadesparaelaprendizaje);
            imagen6_pantalla8_capacidadesparaelaprendizaje.setImageBitmap(bm);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/texto_anterior_capacidadesparaelaprendizaje.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen7_pantalla8_capacidadesparaelaprendizaje = (ImageView) findViewById(R.id.imagen7_pantalla8_capacidadesparaelaprendizaje);
            imagen7_pantalla8_capacidadesparaelaprendizaje.setImageBitmap(bm);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/texto_siguiente_capacidadesparaelaprendizaje.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen8_pantalla8_capacidadesparaelaprendizaje = (ImageView) findViewById(R.id.imagen8_pantalla8_capacidadesparaelaprendizaje);
            imagen8_pantalla8_capacidadesparaelaprendizaje.setImageBitmap(bm);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/boton_siguiente_capacidadesparaelaprendizaje.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen9_pantalla8_capacidadesparaelaprendizaje = (ImageView) findViewById(R.id.imagen9_pantalla8_capacidadesparaelaprendizaje);
            imagen9_pantalla8_capacidadesparaelaprendizaje.setImageBitmap(bm);
        }
        if (ventana_capacidades == 9) {
            setContentView(R.layout.pantalla9_capacidadesparaelaprendizaje);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/texto_superior_capacidadesparaelaprendizaje.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen1_pantalla9_capacidadesparaelaprendizaje = (ImageView) findViewById(R.id.imagen1_pantalla9_capacidadesparaelaprendizaje);
            imagen1_pantalla9_capacidadesparaelaprendizaje.setImageBitmap(bm);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/texto_pantalla9_capacidadesparaelaprendizaje.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            bmDrawable = new BitmapDrawable(bm);
            fondo1_pantalla9_capacidadesparaelaprendizaje = (ImageView) findViewById(R.id.fondo1_pantalla9_capacidadesparaelaprendizaje);
            fondo1_pantalla9_capacidadesparaelaprendizaje.setBackgroundDrawable(bmDrawable);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/rectangulo1_capacidadesparaelaprendizaje.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen2_pantalla9_capacidadesparaelaprendizaje = (ImageView) findViewById(R.id.imagen2_pantalla9_capacidadesparaelaprendizaje);
            imagen2_pantalla9_capacidadesparaelaprendizaje.setImageBitmap(bm);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/rectangulo2_capacidadesparaelaprendizaje.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen3_pantalla9_capacidadesparaelaprendizaje = (ImageView) findViewById(R.id.imagen3_pantalla9_capacidadesparaelaprendizaje);
            imagen3_pantalla9_capacidadesparaelaprendizaje.setImageBitmap(bm);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/rectangulo3_capacidadesparaelaprendizaje.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen4_pantalla9_capacidadesparaelaprendizaje = (ImageView) findViewById(R.id.imagen4_pantalla9_capacidadesparaelaprendizaje);
            imagen4_pantalla9_capacidadesparaelaprendizaje.setImageBitmap(bm);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/rectangulo4_capacidadesparaelaprendizaje.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen5_pantalla9_capacidadesparaelaprendizaje = (ImageView) findViewById(R.id.imagen5_pantalla9_capacidadesparaelaprendizaje);
            imagen5_pantalla9_capacidadesparaelaprendizaje.setImageBitmap(bm);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/rectangulo5_capacidadesparaelaprendizaje.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen6_pantalla9_capacidadesparaelaprendizaje = (ImageView) findViewById(R.id.imagen6_pantalla9_capacidadesparaelaprendizaje);
            imagen6_pantalla9_capacidadesparaelaprendizaje.setImageBitmap(bm);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/boton_anterior_capacidadesparaelaprendizaje.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen7_pantalla9_capacidadesparaelaprendizaje = (ImageView) findViewById(R.id.imagen7_pantalla9_capacidadesparaelaprendizaje);
            imagen7_pantalla9_capacidadesparaelaprendizaje.setImageBitmap(bm);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/texto_anterior_capacidadesparaelaprendizaje.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen8_pantalla9_capacidadesparaelaprendizaje = (ImageView) findViewById(R.id.imagen8_pantalla9_capacidadesparaelaprendizaje);
            imagen8_pantalla9_capacidadesparaelaprendizaje.setImageBitmap(bm);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/texto_siguiente_capacidadesparaelaprendizaje.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen9_pantalla9_capacidadesparaelaprendizaje = (ImageView) findViewById(R.id.imagen9_pantalla9_capacidadesparaelaprendizaje);
            imagen9_pantalla9_capacidadesparaelaprendizaje.setImageBitmap(bm);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/boton_siguiente_capacidadesparaelaprendizaje.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen10_pantalla9_capacidadesparaelaprendizaje = (ImageView) findViewById(R.id.imagen10_pantalla9_capacidadesparaelaprendizaje);
            imagen10_pantalla9_capacidadesparaelaprendizaje.setImageBitmap(bm);
        }
        if (ventana_capacidades == 10) {
            setContentView(R.layout.pantalla10_capacidadesparaelaprendizaje);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/texto_superior_capacidadesparaelaprendizaje.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen1_pantalla10_capacidadesparaelaprendizaje = (ImageView) findViewById(R.id.imagen1_pantalla10_capacidadesparaelaprendizaje);
            imagen1_pantalla10_capacidadesparaelaprendizaje.setImageBitmap(bm);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/texto_pantalla10_capacidadesparaelaprendizaje.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            bmDrawable = new BitmapDrawable(bm);
            fondo1_pantalla10_capacidadesparaelaprendizaje = (ImageView) findViewById(R.id.fondo1_pantalla10_capacidadesparaelaprendizaje);
            fondo1_pantalla10_capacidadesparaelaprendizaje.setBackgroundDrawable(bmDrawable);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/rectangulo1_capacidadesparaelaprendizaje.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen2_pantalla10_capacidadesparaelaprendizaje = (ImageView) findViewById(R.id.imagen2_pantalla10_capacidadesparaelaprendizaje);
            imagen2_pantalla10_capacidadesparaelaprendizaje.setImageBitmap(bm);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/rectangulo2_capacidadesparaelaprendizaje.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen3_pantalla10_capacidadesparaelaprendizaje = (ImageView) findViewById(R.id.imagen3_pantalla10_capacidadesparaelaprendizaje);
            imagen3_pantalla10_capacidadesparaelaprendizaje.setImageBitmap(bm);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/rectangulo3_capacidadesparaelaprendizaje.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen4_pantalla10_capacidadesparaelaprendizaje = (ImageView) findViewById(R.id.imagen4_pantalla10_capacidadesparaelaprendizaje);
            imagen4_pantalla10_capacidadesparaelaprendizaje.setImageBitmap(bm);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/rectangulo4_capacidadesparaelaprendizaje.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen5_pantalla10_capacidadesparaelaprendizaje = (ImageView) findViewById(R.id.imagen5_pantalla10_capacidadesparaelaprendizaje);
            imagen5_pantalla10_capacidadesparaelaprendizaje.setImageBitmap(bm);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/rectangulo5_capacidadesparaelaprendizaje.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen6_pantalla10_capacidadesparaelaprendizaje = (ImageView) findViewById(R.id.imagen6_pantalla10_capacidadesparaelaprendizaje);
            imagen6_pantalla10_capacidadesparaelaprendizaje.setImageBitmap(bm);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/rectangulo6_capacidadesparaelaprendizaje.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen7_pantalla10_capacidadesparaelaprendizaje = (ImageView) findViewById(R.id.imagen7_pantalla10_capacidadesparaelaprendizaje);
            imagen7_pantalla10_capacidadesparaelaprendizaje.setImageBitmap(bm);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/boton_anterior_capacidadesparaelaprendizaje.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen8_pantalla10_capacidadesparaelaprendizaje = (ImageView) findViewById(R.id.imagen8_pantalla10_capacidadesparaelaprendizaje);
            imagen8_pantalla10_capacidadesparaelaprendizaje.setImageBitmap(bm);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/texto_anterior_capacidadesparaelaprendizaje.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen9_pantalla10_capacidadesparaelaprendizaje = (ImageView) findViewById(R.id.imagen9_pantalla10_capacidadesparaelaprendizaje);
            imagen9_pantalla10_capacidadesparaelaprendizaje.setImageBitmap(bm);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/texto_siguiente_capacidadesparaelaprendizaje.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen10_pantalla10_capacidadesparaelaprendizaje = (ImageView) findViewById(R.id.imagen10_pantalla10_capacidadesparaelaprendizaje);
            imagen10_pantalla10_capacidadesparaelaprendizaje.setImageBitmap(bm);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/boton_siguiente_capacidadesparaelaprendizaje.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen11_pantalla10_capacidadesparaelaprendizaje = (ImageView) findViewById(R.id.imagen11_pantalla10_capacidadesparaelaprendizaje);
            imagen11_pantalla10_capacidadesparaelaprendizaje.setImageBitmap(bm);
        }
        if (ventana_capacidades == 11) {
            setContentView(R.layout.pantalla11_capacidadesparaelaprendizaje);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/texto_superior_capacidadesparaelaprendizaje.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen1_pantalla11_capacidadesparaelaprendizaje = (ImageView) findViewById(R.id.imagen1_pantalla11_capacidadesparaelaprendizaje);
            imagen1_pantalla11_capacidadesparaelaprendizaje.setImageBitmap(bm);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/texto_pantalla11_capacidadesparaelaprendizaje.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            bmDrawable = new BitmapDrawable(bm);
            fondo1_pantalla11_capacidadesparaelaprendizaje = (ImageView) findViewById(R.id.fondo1_pantalla11_capacidadesparaelaprendizaje);
            fondo1_pantalla11_capacidadesparaelaprendizaje.setBackgroundDrawable(bmDrawable);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/rectangulo1_capacidadesparaelaprendizaje.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen2_pantalla11_capacidadesparaelaprendizaje = (ImageView) findViewById(R.id.imagen2_pantalla11_capacidadesparaelaprendizaje);
            imagen2_pantalla11_capacidadesparaelaprendizaje.setImageBitmap(bm);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/rectangulo2_capacidadesparaelaprendizaje.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen3_pantalla11_capacidadesparaelaprendizaje = (ImageView) findViewById(R.id.imagen3_pantalla11_capacidadesparaelaprendizaje);
            imagen3_pantalla11_capacidadesparaelaprendizaje.setImageBitmap(bm);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/rectangulo3_capacidadesparaelaprendizaje.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen4_pantalla11_capacidadesparaelaprendizaje = (ImageView) findViewById(R.id.imagen4_pantalla11_capacidadesparaelaprendizaje);
            imagen4_pantalla11_capacidadesparaelaprendizaje.setImageBitmap(bm);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/rectangulo4_capacidadesparaelaprendizaje.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen5_pantalla11_capacidadesparaelaprendizaje = (ImageView) findViewById(R.id.imagen5_pantalla11_capacidadesparaelaprendizaje);
            imagen5_pantalla11_capacidadesparaelaprendizaje.setImageBitmap(bm);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/rectangulo5_capacidadesparaelaprendizaje.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen6_pantalla11_capacidadesparaelaprendizaje = (ImageView) findViewById(R.id.imagen6_pantalla11_capacidadesparaelaprendizaje);
            imagen6_pantalla11_capacidadesparaelaprendizaje.setImageBitmap(bm);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/rectangulo6_capacidadesparaelaprendizaje.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen7_pantalla11_capacidadesparaelaprendizaje = (ImageView) findViewById(R.id.imagen7_pantalla11_capacidadesparaelaprendizaje);
            imagen7_pantalla11_capacidadesparaelaprendizaje.setImageBitmap(bm);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/rectangulo7_capacidadesparaelaprendizaje.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen8_pantalla11_capacidadesparaelaprendizaje = (ImageView) findViewById(R.id.imagen8_pantalla11_capacidadesparaelaprendizaje);
            imagen8_pantalla11_capacidadesparaelaprendizaje.setImageBitmap(bm);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/boton_anterior_capacidadesparaelaprendizaje.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen9_pantalla11_capacidadesparaelaprendizaje = (ImageView) findViewById(R.id.imagen9_pantalla11_capacidadesparaelaprendizaje);
            imagen9_pantalla11_capacidadesparaelaprendizaje.setImageBitmap(bm);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/texto_anterior_capacidadesparaelaprendizaje.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen10_pantalla11_capacidadesparaelaprendizaje = (ImageView) findViewById(R.id.imagen10_pantalla11_capacidadesparaelaprendizaje);
            imagen10_pantalla11_capacidadesparaelaprendizaje.setImageBitmap(bm);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/texto_siguiente_capacidadesparaelaprendizaje.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen11_pantalla11_capacidadesparaelaprendizaje = (ImageView) findViewById(R.id.imagen11_pantalla11_capacidadesparaelaprendizaje);
            imagen11_pantalla11_capacidadesparaelaprendizaje.setImageBitmap(bm);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/boton_siguiente_capacidadesparaelaprendizaje.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen12_pantalla11_capacidadesparaelaprendizaje = (ImageView) findViewById(R.id.imagen12_pantalla11_capacidadesparaelaprendizaje);
            imagen12_pantalla11_capacidadesparaelaprendizaje.setImageBitmap(bm);
        }
        if (ventana_capacidades == 12) {
            setContentView(R.layout.pantalla12_capacidadesparaelaprendizaje);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/texto_pantalla12_capacidadesparaelaprendizaje.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen1_pantalla12_capacidadesparaelaprendizaje = (ImageView) findViewById(R.id.imagen1_pantalla12_capacidadesparaelaprendizaje);
            imagen1_pantalla12_capacidadesparaelaprendizaje.setImageBitmap(bm);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/ilustracion_pantalla12_capacidadesparaelaprendizaje.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen2_pantalla12_capacidadesparaelaprendizaje = (ImageView) findViewById(R.id.imagen2_pantalla12_capacidadesparaelaprendizaje);
            imagen2_pantalla12_capacidadesparaelaprendizaje.setImageBitmap(bm);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/boton_anterior_capacidadesparaelaprendizaje.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen3_pantalla12_capacidadesparaelaprendizaje = (ImageView) findViewById(R.id.imagen3_pantalla12_capacidadesparaelaprendizaje);
            imagen3_pantalla12_capacidadesparaelaprendizaje.setImageBitmap(bm);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/texto_anterior_capacidadesparaelaprendizaje.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen4_pantalla12_capacidadesparaelaprendizaje = (ImageView) findViewById(R.id.imagen4_pantalla12_capacidadesparaelaprendizaje);
            imagen4_pantalla12_capacidadesparaelaprendizaje.setImageBitmap(bm);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/texto_siguiente_capacidadesparaelaprendizaje.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen5_pantalla12_capacidadesparaelaprendizaje = (ImageView) findViewById(R.id.imagen5_pantalla12_capacidadesparaelaprendizaje);
            imagen5_pantalla12_capacidadesparaelaprendizaje.setImageBitmap(bm);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/boton_siguiente_capacidadesparaelaprendizaje.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen6_pantalla12_capacidadesparaelaprendizaje = (ImageView) findViewById(R.id.imagen6_pantalla12_capacidadesparaelaprendizaje);
            imagen6_pantalla12_capacidadesparaelaprendizaje.setImageBitmap(bm);
        }
        if (ventana_capacidades == 13) {
            setContentView(R.layout.pantalla13_capacidadesparaelaprendizaje);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/texto_pantalla13_capacidadesparaelaprendizaje.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen1_pantalla13_capacidadesparaelaprendizaje = (ImageView) findViewById(R.id.imagen1_pantalla13_capacidadesparaelaprendizaje);
            imagen1_pantalla13_capacidadesparaelaprendizaje.setImageBitmap(bm);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/boton_anterior_capacidadesparaelaprendizaje.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen2_pantalla13_capacidadesparaelaprendizaje = (ImageView) findViewById(R.id.imagen2_pantalla13_capacidadesparaelaprendizaje);
            imagen2_pantalla13_capacidadesparaelaprendizaje.setImageBitmap(bm);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/texto_anterior_capacidadesparaelaprendizaje.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen3_pantalla13_capacidadesparaelaprendizaje = (ImageView) findViewById(R.id.imagen3_pantalla13_capacidadesparaelaprendizaje);
            imagen3_pantalla13_capacidadesparaelaprendizaje.setImageBitmap(bm);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/texto_siguiente_capacidadesparaelaprendizaje.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen4_pantalla13_capacidadesparaelaprendizaje = (ImageView) findViewById(R.id.imagen4_pantalla13_capacidadesparaelaprendizaje);
            imagen4_pantalla13_capacidadesparaelaprendizaje.setImageBitmap(bm);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/boton_siguiente_capacidadesparaelaprendizaje.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen5_pantalla13_capacidadesparaelaprendizaje = (ImageView) findViewById(R.id.imagen5_pantalla13_capacidadesparaelaprendizaje);
            imagen5_pantalla13_capacidadesparaelaprendizaje.setImageBitmap(bm);
        }
        if (ventana_capacidades == 14) {
            setContentView(R.layout.pantalla14_capacidadesparaelaprendizaje);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/texto_pantalla14_capacidadesparaelaprendizaje.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen1_pantalla14_capacidadesparaelaprendizaje = (ImageView) findViewById(R.id.imagen1_pantalla14_capacidadesparaelaprendizaje);
            imagen1_pantalla14_capacidadesparaelaprendizaje.setImageBitmap(bm);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/ejercicio_pantalla14_capacidadesparaelaprendizaje.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen2_pantalla14_capacidadesparaelaprendizaje = (ImageView) findViewById(R.id.imagen2_pantalla14_capacidadesparaelaprendizaje);
            imagen2_pantalla14_capacidadesparaelaprendizaje.setImageBitmap(bm);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/linea1_pantalla14_capacidadesparaelaprendizaje.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen3_pantalla14_capacidadesparaelaprendizaje = (ImageView) findViewById(R.id.imagen3_pantalla14_capacidadesparaelaprendizaje);
            imagen3_pantalla14_capacidadesparaelaprendizaje.setImageBitmap(bm);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/linea2_pantalla14_capacidadesparaelaprendizaje.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen4_pantalla14_capacidadesparaelaprendizaje = (ImageView) findViewById(R.id.imagen4_pantalla14_capacidadesparaelaprendizaje);
            imagen4_pantalla14_capacidadesparaelaprendizaje.setImageBitmap(bm);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/linea3_pantalla14_capacidadesparaelaprendizaje.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen5_pantalla14_capacidadesparaelaprendizaje = (ImageView) findViewById(R.id.imagen5_pantalla14_capacidadesparaelaprendizaje);
            imagen5_pantalla14_capacidadesparaelaprendizaje.setImageBitmap(bm);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/linea4_pantalla14_capacidadesparaelaprendizaje.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen6_pantalla14_capacidadesparaelaprendizaje = (ImageView) findViewById(R.id.imagen6_pantalla14_capacidadesparaelaprendizaje);
            imagen6_pantalla14_capacidadesparaelaprendizaje.setImageBitmap(bm);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/linea5_pantalla14_capacidadesparaelaprendizaje.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen7_pantalla14_capacidadesparaelaprendizaje = (ImageView) findViewById(R.id.imagen7_pantalla14_capacidadesparaelaprendizaje);
            imagen7_pantalla14_capacidadesparaelaprendizaje.setImageBitmap(bm);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/linea6_pantalla14_capacidadesparaelaprendizaje.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen8_pantalla14_capacidadesparaelaprendizaje = (ImageView) findViewById(R.id.imagen8_pantalla14_capacidadesparaelaprendizaje);
            imagen8_pantalla14_capacidadesparaelaprendizaje.setImageBitmap(bm);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/linea7_pantalla14_capacidadesparaelaprendizaje.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen9_pantalla14_capacidadesparaelaprendizaje = (ImageView) findViewById(R.id.imagen9_pantalla14_capacidadesparaelaprendizaje);
            imagen9_pantalla14_capacidadesparaelaprendizaje.setImageBitmap(bm);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/linea8_pantalla14_capacidadesparaelaprendizaje.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen10_pantalla14_capacidadesparaelaprendizaje = (ImageView) findViewById(R.id.imagen10_pantalla14_capacidadesparaelaprendizaje);
            imagen10_pantalla14_capacidadesparaelaprendizaje.setImageBitmap(bm);
            carga = Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/ilustracion_pantalla14_capacidadesparaelaprendizaje.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen11_pantalla14_capacidadesparaelaprendizaje = (ImageView) findViewById(R.id.imagen11_pantalla14_capacidadesparaelaprendizaje);
            imagen11_pantalla14_capacidadesparaelaprendizaje.setImageBitmap(bm);
        }
    }

    public void validaVentana10(){
        if (ventana_habilidadesdelectura == 1) {
            setContentView(R.layout.pantalla1_habilidadesdelectura);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia10/encabezado_habilidadesdelectura.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            bmDrawable = new BitmapDrawable(bm);
            fondo1_pantalla1_habilidadesdelectura=(LinearLayout)findViewById(R.id.fondo1_pantalla1_habilidadesdelectura);
            fondo1_pantalla1_habilidadesdelectura.setBackgroundDrawable(bmDrawable);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia10/ilustracion1_pantalla1_habilidadesdelectura.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen1_pantalla1_habilidadesdelectura=(ImageView)findViewById(R.id.imagen1_pantalla1_habilidadesdelectura);
            imagen1_pantalla1_habilidadesdelectura.setImageBitmap(bm);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia10/bienvenido_habilidadesdelectura.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen2_pantalla1_habilidadesdelectura=(ImageView)findViewById(R.id.imagen2_pantalla1_habilidadesdelectura);
            imagen2_pantalla1_habilidadesdelectura.setImageBitmap(bm);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia10/comienzo_habilidadesdelectura.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            comenzar_habilidadesdelectura=(ImageView)findViewById(R.id.comenzar_habilidadesdelectura);
            comenzar_habilidadesdelectura.setImageBitmap(bm);
        }
        if (ventana_habilidadesdelectura== 2) {
            setContentView(R.layout.pantalla2_habilidadesdelectura);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia10/ilustracion1_pantalla2_7_habilidadesdelectura.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen1_pantalla2_habilidadesdelectura=(ImageView)findViewById(R.id.imagen1_pantalla2_habilidadesdelectura);
            imagen1_pantalla2_habilidadesdelectura.setImageBitmap(bm);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia10/anterior_habilidadesdelectura.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen2_pantalla2_habilidadesdelectura=(ImageView)findViewById(R.id.imagen2_pantalla2_habilidadesdelectura);
            imagen2_pantalla2_habilidadesdelectura.setImageBitmap(bm);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia10/siguiente_habilidadesdelectura.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen3_pantalla2_habilidadesdelectura=(ImageView)findViewById(R.id.imagen3_pantalla2_habilidadesdelectura);
            imagen3_pantalla2_habilidadesdelectura.setImageBitmap(bm);
        }
        if (ventana_habilidadesdelectura == 3) {
            setContentView(R.layout.pantalla3_habilidadesdelectura);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia10/ilustracion1_pantalla3_habilidadesdelectura.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen1_pantalla3_habilidadesdelectura=(ImageView)findViewById(R.id.imagen1_pantalla3_habilidadesdelectura);
            imagen1_pantalla3_habilidadesdelectura.setImageBitmap(bm);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia10/anterior_habilidadesdelectura.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen2_pantalla3_habilidadesdelectura=(ImageView)findViewById(R.id.imagen2_pantalla3_habilidadesdelectura);
            imagen2_pantalla3_habilidadesdelectura.setImageBitmap(bm);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia10/siguiente_habilidadesdelectura.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen3_pantalla3_habilidadesdelectura=(ImageView)findViewById(R.id.imagen3_pantalla3_habilidadesdelectura);
            imagen3_pantalla3_habilidadesdelectura.setImageBitmap(bm);
        }
        if (ventana_habilidadesdelectura == 4) {
            setContentView(R.layout.pantalla4_habilidadesdelectura);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia10/ilustracion1_pantalla4_habilidadesdelectura.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen1_pantalla4_habilidadesdelectura=(ImageView)findViewById(R.id.imagen1_pantalla4_habilidadesdelectura);
            imagen1_pantalla4_habilidadesdelectura.setImageBitmap(bm);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia10/ilustracion2_pantalla4_habilidadesdelectura.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen2_pantalla4_habilidadesdelectura=(ImageView)findViewById(R.id.imagen2_pantalla4_habilidadesdelectura);
            imagen2_pantalla4_habilidadesdelectura.setImageBitmap(bm);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia10/anterior_habilidadesdelectura.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen3_pantalla4_habilidadesdelectura=(ImageView)findViewById(R.id.imagen3_pantalla4_habilidadesdelectura);
            imagen3_pantalla4_habilidadesdelectura.setImageBitmap(bm);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia10/siguiente_habilidadesdelectura.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen4_pantalla4_habilidadesdelectura=(ImageView)findViewById(R.id.imagen4_pantalla4_habilidadesdelectura);
            imagen4_pantalla4_habilidadesdelectura.setImageBitmap(bm);
        }
        if (ventana_habilidadesdelectura == 5) {
            setContentView(R.layout.pantalla5_habilidadesdelectura);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia10/ilustracion1_pantalla5_habilidadesdelectura.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen1_pantalla5_habilidadesdelectura=(ImageView)findViewById(R.id.imagen1_pantalla5_habilidadesdelectura);
            imagen1_pantalla5_habilidadesdelectura.setImageBitmap(bm);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia10/anterior_habilidadesdelectura.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen2_pantalla5_habilidadesdelectura=(ImageView)findViewById(R.id.imagen2_pantalla5_habilidadesdelectura);
            imagen2_pantalla5_habilidadesdelectura.setImageBitmap(bm);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia10/siguiente_habilidadesdelectura.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen3_pantalla5_habilidadesdelectura=(ImageView)findViewById(R.id.imagen3_pantalla5_habilidadesdelectura);
            imagen3_pantalla5_habilidadesdelectura.setImageBitmap(bm);
        }
        if (ventana_habilidadesdelectura == 6) {
            setContentView(R.layout.pantalla6_habilidadesdelectura);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia10/ilustracion1_pantalla6_habilidadesdelectura.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen1_pantalla6_habilidadesdelectura=(ImageView)findViewById(R.id.imagen1_pantalla6_habilidadesdelectura);
            imagen1_pantalla6_habilidadesdelectura.setImageBitmap(bm);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia10/anterior_habilidadesdelectura.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen2_pantalla6_habilidadesdelectura=(ImageView)findViewById(R.id.imagen2_pantalla6_habilidadesdelectura);
            imagen2_pantalla6_habilidadesdelectura.setImageBitmap(bm);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia10/siguiente_habilidadesdelectura.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen3_pantalla6_habilidadesdelectura=(ImageView)findViewById(R.id.imagen3_pantalla6_habilidadesdelectura);
            imagen3_pantalla6_habilidadesdelectura.setImageBitmap(bm);
        }
        if (ventana_habilidadesdelectura == 7) {
            setContentView(R.layout.pantalla7_habilidadesdelectura);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia10/ilustracion1_pantalla2_7_habilidadesdelectura.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen1_pantalla7_habilidadesdelectura=(ImageView)findViewById(R.id.imagen1_pantalla7_habilidadesdelectura);
            imagen1_pantalla7_habilidadesdelectura.setImageBitmap(bm);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia10/anterior_habilidadesdelectura.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen2_pantalla7_habilidadesdelectura=(ImageView)findViewById(R.id.imagen2_pantalla7_habilidadesdelectura);
            imagen2_pantalla7_habilidadesdelectura.setImageBitmap(bm);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia10/siguiente_habilidadesdelectura.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen3_pantalla7_habilidadesdelectura=(ImageView)findViewById(R.id.imagen3_pantalla7_habilidadesdelectura);
            imagen3_pantalla7_habilidadesdelectura.setImageBitmap(bm);
        }
        if (ventana_habilidadesdelectura == 8) {
            setContentView(R.layout.pantalla8_habilidadesdelectura);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia10/ilustracion1_pantalla8_habilidadesdelectura.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen1_pantalla8_habilidadesdelectura=(ImageView)findViewById(R.id.imagen1_pantalla8_habilidadesdelectura);
            imagen1_pantalla8_habilidadesdelectura.setImageBitmap(bm);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia10/anterior_habilidadesdelectura.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen2_pantalla8_habilidadesdelectura=(ImageView)findViewById(R.id.imagen2_pantalla8_habilidadesdelectura);
            imagen2_pantalla8_habilidadesdelectura.setImageBitmap(bm);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia10/siguiente_habilidadesdelectura.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen3_pantalla8_habilidadesdelectura=(ImageView)findViewById(R.id.imagen3_pantalla8_habilidadesdelectura);
            imagen3_pantalla8_habilidadesdelectura.setImageBitmap(bm);
        }
        if (ventana_habilidadesdelectura == 9) {
            setContentView(R.layout.pantalla9_habilidadesdelectura);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia10/ilustracion1_pantalla9_habilidadesdelectura.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen1_pantalla9_habilidadesdelectura=(ImageView)findViewById(R.id.imagen1_pantalla9_habilidadesdelectura);
            imagen1_pantalla9_habilidadesdelectura.setImageBitmap(bm);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia10/ilustracion2_pantalla9_habilidadesdelectura.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen2_pantalla9_habilidadesdelectura=(ImageView)findViewById(R.id.imagen2_pantalla9_habilidadesdelectura);
            imagen2_pantalla9_habilidadesdelectura.setImageBitmap(bm);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia10/anterior_habilidadesdelectura.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen3_pantalla9_habilidadesdelectura=(ImageView)findViewById(R.id.imagen3_pantalla9_habilidadesdelectura);
            imagen3_pantalla9_habilidadesdelectura.setImageBitmap(bm);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia10/siguiente_habilidadesdelectura.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen4_pantalla9_habilidadesdelectura=(ImageView)findViewById(R.id.imagen4_pantalla9_habilidadesdelectura);
            imagen4_pantalla9_habilidadesdelectura.setImageBitmap(bm);
        }
        if (ventana_habilidadesdelectura == 10) {
            setContentView(R.layout.pantalla10_habilidadesdelectura);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia10/ilustracion1_pantalla10_habilidadesdelectura.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen1_pantalla10_habilidadesdelectura=(ImageView)findViewById(R.id.imagen1_pantalla10_habilidadesdelectura);
            imagen1_pantalla10_habilidadesdelectura.setImageBitmap(bm);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia10/anterior_habilidadesdelectura.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen2_pantalla10_habilidadesdelectura=(ImageView)findViewById(R.id.imagen2_pantalla10_habilidadesdelectura);
            imagen2_pantalla10_habilidadesdelectura.setImageBitmap(bm);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia10/siguiente_habilidadesdelectura.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen3_pantalla10_habilidadesdelectura=(ImageView)findViewById(R.id.imagen3_pantalla10_habilidadesdelectura);
            imagen3_pantalla10_habilidadesdelectura.setImageBitmap(bm);
        }
        if (ventana_habilidadesdelectura == 11) {
            setContentView(R.layout.pantalla11_habilidadesdelectura);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia10/ilustracion1_pantalla11_habilidadesdelectura.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen1_pantalla11_habilidadesdelectura=(ImageView)findViewById(R.id.imagen1_pantalla11_habilidadesdelectura);
            imagen1_pantalla11_habilidadesdelectura.setImageBitmap(bm);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia10/anterior_habilidadesdelectura.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen2_pantalla11_habilidadesdelectura=(ImageView)findViewById(R.id.imagen2_pantalla11_habilidadesdelectura);
            imagen2_pantalla11_habilidadesdelectura.setImageBitmap(bm);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia10/siguiente_habilidadesdelectura.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen3_pantalla11_habilidadesdelectura=(ImageView)findViewById(R.id.imagen3_pantalla11_habilidadesdelectura);
            imagen3_pantalla11_habilidadesdelectura.setImageBitmap(bm);
        }
        if (ventana_habilidadesdelectura == 12) {
            setContentView(R.layout.pantalla12_habilidadesdelectura);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia10/ilustracion1_pantalla12_habilidadesdelectura.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen1_pantalla12_habilidadesdelectura=(ImageView)findViewById(R.id.imagen1_pantalla12_habilidadesdelectura);
            imagen1_pantalla12_habilidadesdelectura.setImageBitmap(bm);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia10/anterior_habilidadesdelectura.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen2_pantalla12_habilidadesdelectura=(ImageView)findViewById(R.id.imagen2_pantalla12_habilidadesdelectura);
            imagen2_pantalla12_habilidadesdelectura.setImageBitmap(bm);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia10/siguiente_habilidadesdelectura.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen3_pantalla12_habilidadesdelectura=(ImageView)findViewById(R.id.imagen3_pantalla12_habilidadesdelectura);
            imagen3_pantalla12_habilidadesdelectura.setImageBitmap(bm);
        }
        if (ventana_habilidadesdelectura == 13) {
            setContentView(R.layout.pantalla13_habilidadesdelectura);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia10/ilustracion1_pantalla13_habilidadesdelectura.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen1_pantalla13_habilidadesdelectura=(ImageView)findViewById(R.id.imagen1_pantalla13_habilidadesdelectura);
            imagen1_pantalla13_habilidadesdelectura.setImageBitmap(bm);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia10/anterior_habilidadesdelectura.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen2_pantalla13_habilidadesdelectura=(ImageView)findViewById(R.id.imagen2_pantalla13_habilidadesdelectura);
            imagen2_pantalla13_habilidadesdelectura.setImageBitmap(bm);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia10/siguiente_habilidadesdelectura.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen3_pantalla13_habilidadesdelectura=(ImageView)findViewById(R.id.imagen3_pantalla13_habilidadesdelectura);
            imagen3_pantalla13_habilidadesdelectura.setImageBitmap(bm);
        }
        if (ventana_habilidadesdelectura == 14) {
            setContentView(R.layout.pantalla14_habilidadesdelectura);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia10/ilustracion1_pantalla14_habilidadesdelectura.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen1_pantalla14_habilidadesdelectura=(ImageView)findViewById(R.id.imagen1_pantalla14_habilidadesdelectura);
            imagen1_pantalla14_habilidadesdelectura.setImageBitmap(bm);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia10/anterior_habilidadesdelectura.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen2_pantalla14_habilidadesdelectura=(ImageView)findViewById(R.id.imagen2_pantalla14_habilidadesdelectura);
            imagen2_pantalla14_habilidadesdelectura.setImageBitmap(bm);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia10/siguiente_habilidadesdelectura.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen3_pantalla14_habilidadesdelectura=(ImageView)findViewById(R.id.imagen3_pantalla14_habilidadesdelectura);
            imagen3_pantalla14_habilidadesdelectura.setImageBitmap(bm);
        }
        if (ventana_habilidadesdelectura == 15) {
            setContentView(R.layout.pantalla15_habilidadesdelectura);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia10/ilustracion1_pantalla15_habilidadesdelectura.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen1_pantalla15_habilidadesdelectura=(ImageView)findViewById(R.id.imagen1_pantalla15_habilidadesdelectura);
            imagen1_pantalla15_habilidadesdelectura.setImageBitmap(bm);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia10/anterior_habilidadesdelectura.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen2_pantalla15_habilidadesdelectura=(ImageView)findViewById(R.id.imagen2_pantalla15_habilidadesdelectura);
            imagen2_pantalla15_habilidadesdelectura.setImageBitmap(bm);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia10/siguiente_habilidadesdelectura.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen3_pantalla15_habilidadesdelectura=(ImageView)findViewById(R.id.imagen3_pantalla15_habilidadesdelectura);
            imagen3_pantalla15_habilidadesdelectura.setImageBitmap(bm);
        }
        if (ventana_habilidadesdelectura == 16) {
            setContentView(R.layout.pantalla16_habilidadesdelectura);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia10/ilustracion1_pantalla16_habilidadesdelectura.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen1_pantalla16_habilidadesdelectura=(ImageView)findViewById(R.id.imagen1_pantalla16_habilidadesdelectura);
            imagen1_pantalla16_habilidadesdelectura.setImageBitmap(bm);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia10/anterior_habilidadesdelectura.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen2_pantalla16_habilidadesdelectura=(ImageView)findViewById(R.id.imagen2_pantalla16_habilidadesdelectura);
            imagen2_pantalla16_habilidadesdelectura.setImageBitmap(bm);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia10/siguiente_habilidadesdelectura.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen3_pantalla16_habilidadesdelectura=(ImageView)findViewById(R.id.imagen3_pantalla16_habilidadesdelectura);
            imagen3_pantalla16_habilidadesdelectura.setImageBitmap(bm);
        }
        if (ventana_habilidadesdelectura == 17) {
            setContentView(R.layout.pantalla17_habilidadesdelectura);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia10/ilustracion1_pantalla17_habilidadesdelectura.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen1_pantalla17_habilidadesdelectura=(ImageView)findViewById(R.id.imagen1_pantalla17_habilidadesdelectura);
            imagen1_pantalla17_habilidadesdelectura.setImageBitmap(bm);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia10/anterior_habilidadesdelectura.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen2_pantalla17_habilidadesdelectura=(ImageView)findViewById(R.id.imagen2_pantalla17_habilidadesdelectura);
            imagen2_pantalla17_habilidadesdelectura.setImageBitmap(bm);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia10/siguiente_habilidadesdelectura.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen3_pantalla17_habilidadesdelectura=(ImageView)findViewById(R.id.imagen3_pantalla17_habilidadesdelectura);
            imagen3_pantalla17_habilidadesdelectura.setImageBitmap(bm);
        }
        if (ventana_habilidadesdelectura == 18) {
            setContentView(R.layout.pantalla18_habilidadesdelectura);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia10/anterior_habilidadesdelectura.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen1_pantalla18_habilidadesdelectura=(ImageView)findViewById(R.id.imagen1_pantalla18_habilidadesdelectura);
            imagen1_pantalla18_habilidadesdelectura.setImageBitmap(bm);
        }
    }

    public void validaVentana11(){
        if (ventana_foros == 1) {
            setContentView(R.layout.pantalla1_forosvirtuales);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia11/portada_forosvirtuales.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            bmDrawable = new BitmapDrawable(bm);
            fondo1_pantalla1_forosvirtuales=(LinearLayout)findViewById(R.id.fondo1_pantalla1_forosvirtuales);
            fondo1_pantalla1_forosvirtuales.setBackgroundDrawable(bmDrawable);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia11/bienvenida_forosvirtuales.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen1_pantalla1_forosvirtuales=(ImageView)findViewById(R.id.imagen1_pantalla1_forosvirtuales);
            imagen1_pantalla1_forosvirtuales.setImageBitmap(bm);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia11/barra_negra_botones_forosvirtuales.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            bmDrawable = new BitmapDrawable(bm);
            fondo2_pantalla1_forosvirtuales=(LinearLayout)findViewById(R.id.fondo2_pantalla1_forosvirtuales);
            fondo2_pantalla1_forosvirtuales.setBackgroundDrawable(bmDrawable);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia11/comenzar_forosvirtuales.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            comenzar_forosvirtuales=(ImageView)findViewById(R.id.comenzar_forosvirtuales);
            comenzar_forosvirtuales.setImageBitmap(bm);
        }
        if (ventana_foros == 2) {
            setContentView(R.layout.pantalla2_forosvirtuales);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia11/texto_pantalla2_forosvirtuales.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen2_pantalla2_forosvirtuales=(ImageView)findViewById(R.id.imagen2_pantalla2_forosvirtuales);
            imagen2_pantalla2_forosvirtuales.setImageBitmap(bm);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia11/barra_negra_botones_forosvirtuales.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            bmDrawable = new BitmapDrawable(bm);
            fondo1_pantalla2_forosvirtuales=(LinearLayout)findViewById(R.id.fondo1_pantalla2_forosvirtuales);
            fondo1_pantalla2_forosvirtuales.setBackgroundDrawable(bmDrawable);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia11/menu_pantalla2_forosvirtuales.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            menu_forosvirtuales=(ImageView)findViewById(R.id.menu_forosvirtuales);
            menu_forosvirtuales.setImageBitmap(bm);
        }
        if (ventana_foros == 3) {
            setContentView(R.layout.pantalla3_forosvirtuales);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia11/texto_pantalla3_forosvirtuales.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            bmDrawable = new BitmapDrawable(bm);
            fondo1_pantalla3_forosvirtuales=(ImageView)findViewById(R.id.fondo1_pantalla3_forosvirtuales);
            fondo1_pantalla3_forosvirtuales.setBackgroundDrawable(bmDrawable);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia11/boton_anterior_forosvirtuales.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen1_pantalla3_forosvirtuales=(ImageView)findViewById(R.id.imagen1_pantalla3_forosvirtuales);
            imagen1_pantalla3_forosvirtuales.setImageBitmap(bm);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia11/texto_anterior_forosvirtuales.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen2_pantalla3_forosvirtuales=(ImageView)findViewById(R.id.imagen2_pantalla3_forosvirtuales);
            imagen2_pantalla3_forosvirtuales.setImageBitmap(bm);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia11/texto_siguiente_forosvirtuales.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen3_pantalla3_forosvirtuales=(ImageView)findViewById(R.id.imagen3_pantalla3_forosvirtuales);
            imagen3_pantalla3_forosvirtuales.setImageBitmap(bm);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia11/boton_siguiente_forosvirtuales.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen4_pantalla3_forosvirtuales=(ImageView)findViewById(R.id.imagen4_pantalla3_forosvirtuales);
            imagen4_pantalla3_forosvirtuales.setImageBitmap(bm);
        }
        if (ventana_foros == 4) {
            setContentView(R.layout.pantalla4_forosvirtuales);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia11/texto_pantalla4_forosvirtuales.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            bmDrawable = new BitmapDrawable(bm);
            fondo1_pantalla4_forosvirtuales=(ImageView)findViewById(R.id.fondo1_pantalla4_forosvirtuales);
            fondo1_pantalla4_forosvirtuales.setBackgroundDrawable(bmDrawable);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia11/ilustracion_pantalla4_forosvirtuales.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen1_pantalla4_forosvirtuales=(ImageView)findViewById(R.id.imagen1_pantalla4_forosvirtuales);
            imagen1_pantalla4_forosvirtuales.setImageBitmap(bm);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia11/boton_anterior_forosvirtuales.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen2_pantalla4_forosvirtuales=(ImageView)findViewById(R.id.imagen2_pantalla4_forosvirtuales);
            imagen2_pantalla4_forosvirtuales.setImageBitmap(bm);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia11/texto_anterior_forosvirtuales.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen3_pantalla4_forosvirtuales=(ImageView)findViewById(R.id.imagen3_pantalla4_forosvirtuales);
            imagen3_pantalla4_forosvirtuales.setImageBitmap(bm);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia11/texto_siguiente_forosvirtuales.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen4_pantalla4_forosvirtuales=(ImageView)findViewById(R.id.imagen4_pantalla4_forosvirtuales);
            imagen4_pantalla4_forosvirtuales.setImageBitmap(bm);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia11/boton_siguiente_forosvirtuales.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen5_pantalla4_forosvirtuales=(ImageView)findViewById(R.id.imagen5_pantalla4_forosvirtuales);
            imagen5_pantalla4_forosvirtuales.setImageBitmap(bm);
        }
        if (ventana_foros == 5) {
            setContentView(R.layout.pantalla5_forosvirtuales);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia11/texto_pantalla5_forosvirtuales.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            bmDrawable = new BitmapDrawable(bm);
            fondo1_pantalla5_forosvirtuales=(ImageView)findViewById(R.id.fondo1_pantalla5_forosvirtuales);
            fondo1_pantalla5_forosvirtuales.setBackgroundDrawable(bmDrawable);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia11/ilustracion_pantalla5_forosvirtuales.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen1_pantalla5_forosvirtuales=(ImageView)findViewById(R.id.imagen1_pantalla5_forosvirtuales);
            imagen1_pantalla5_forosvirtuales.setImageBitmap(bm);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia11/boton_anterior_forosvirtuales.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen2_pantalla5_forosvirtuales=(ImageView)findViewById(R.id.imagen2_pantalla5_forosvirtuales);
            imagen2_pantalla5_forosvirtuales.setImageBitmap(bm);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia11/texto_anterior_forosvirtuales.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen3_pantalla5_forosvirtuales=(ImageView)findViewById(R.id.imagen3_pantalla5_forosvirtuales);
            imagen3_pantalla5_forosvirtuales.setImageBitmap(bm);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia11/texto_siguiente_forosvirtuales.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen4_pantalla5_forosvirtuales=(ImageView)findViewById(R.id.imagen4_pantalla5_forosvirtuales);
            imagen4_pantalla5_forosvirtuales.setImageBitmap(bm);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia11/boton_siguiente_forosvirtuales.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen5_pantalla5_forosvirtuales=(ImageView)findViewById(R.id.imagen5_pantalla5_forosvirtuales);
            imagen5_pantalla5_forosvirtuales.setImageBitmap(bm);
        }
        if (ventana_foros == 6) {
            setContentView(R.layout.pantalla6_forosvirtuales);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia11/texto_pantalla6_forosvirtuales.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen1_pantalla6_forosvirtuales=(ImageView)findViewById(R.id.imagen1_pantalla6_forosvirtuales);
            imagen1_pantalla6_forosvirtuales.setImageBitmap(bm);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia11/boton_anterior_forosvirtuales.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen2_pantalla6_forosvirtuales=(ImageView)findViewById(R.id.imagen2_pantalla6_forosvirtuales);
            imagen2_pantalla6_forosvirtuales.setImageBitmap(bm);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia11/texto_anterior_forosvirtuales.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen3_pantalla6_forosvirtuales=(ImageView)findViewById(R.id.imagen3_pantalla6_forosvirtuales);
            imagen3_pantalla6_forosvirtuales.setImageBitmap(bm);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia11/texto_siguiente_forosvirtuales.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen4_pantalla6_forosvirtuales=(ImageView)findViewById(R.id.imagen4_pantalla6_forosvirtuales);
            imagen4_pantalla6_forosvirtuales.setImageBitmap(bm);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia11/boton_siguiente_forosvirtuales.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen5_pantalla6_forosvirtuales=(ImageView)findViewById(R.id.imagen5_pantalla6_forosvirtuales);
            imagen5_pantalla6_forosvirtuales.setImageBitmap(bm);
        }
        if (ventana_foros == 7) {
            setContentView(R.layout.pantalla7_forosvirtuales);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia11/texto_pantalla7_forosvirtuales.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            bmDrawable = new BitmapDrawable(bm);
            fondo1_pantalla7_forosvirtuales=(ImageView)findViewById(R.id.fondo1_pantalla7_forosvirtuales);
            fondo1_pantalla7_forosvirtuales.setBackgroundDrawable(bmDrawable);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia11/ilustracion_pantalla7_forosvirtuales.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen1_pantalla7_forosvirtuales=(ImageView)findViewById(R.id.imagen1_pantalla7_forosvirtuales);
            imagen1_pantalla7_forosvirtuales.setImageBitmap(bm);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia11/boton_anterior_forosvirtuales.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen2_pantalla7_forosvirtuales=(ImageView)findViewById(R.id.imagen2_pantalla7_forosvirtuales);
            imagen2_pantalla7_forosvirtuales.setImageBitmap(bm);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia11/texto_anterior_forosvirtuales.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen3_pantalla7_forosvirtuales=(ImageView)findViewById(R.id.imagen3_pantalla7_forosvirtuales);
            imagen3_pantalla7_forosvirtuales.setImageBitmap(bm);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia11/texto_siguiente_forosvirtuales.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen4_pantalla7_forosvirtuales=(ImageView)findViewById(R.id.imagen4_pantalla7_forosvirtuales);
            imagen4_pantalla7_forosvirtuales.setImageBitmap(bm);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia11/boton_siguiente_forosvirtuales.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen5_pantalla7_forosvirtuales=(ImageView)findViewById(R.id.imagen5_pantalla7_forosvirtuales);
            imagen5_pantalla7_forosvirtuales.setImageBitmap(bm);
        }
        if (ventana_foros == 8) {
            setContentView(R.layout.pantalla8_forosvirtuales);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia11/texto_pantalla8_forosvirtuales.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen1_pantalla8_forosvirtuales=(ImageView)findViewById(R.id.imagen1_pantalla8_forosvirtuales);
            imagen1_pantalla8_forosvirtuales.setImageBitmap(bm);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia11/boton_anterior_forosvirtuales.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen2_pantalla8_forosvirtuales=(ImageView)findViewById(R.id.imagen2_pantalla8_forosvirtuales);
            imagen2_pantalla8_forosvirtuales.setImageBitmap(bm);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia11/texto_anterior_forosvirtuales.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen3_pantalla8_forosvirtuales=(ImageView)findViewById(R.id.imagen3_pantalla8_forosvirtuales);
            imagen3_pantalla8_forosvirtuales.setImageBitmap(bm);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia11/texto_siguiente_forosvirtuales.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen4_pantalla8_forosvirtuales=(ImageView)findViewById(R.id.imagen4_pantalla8_forosvirtuales);
            imagen4_pantalla8_forosvirtuales.setImageBitmap(bm);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia11/boton_siguiente_forosvirtuales.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen5_pantalla8_forosvirtuales=(ImageView)findViewById(R.id.imagen5_pantalla8_forosvirtuales);
            imagen5_pantalla8_forosvirtuales.setImageBitmap(bm);
        }
        if (ventana_foros == 9) {
            setContentView(R.layout.pantalla9_forosvirtuales);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia11/texto_pantalla9_forosvirtuales.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            bmDrawable = new BitmapDrawable(bm);
            fondo1_pantalla9_forosvirtuales=(ImageView)findViewById(R.id.fondo1_pantalla9_forosvirtuales);
            fondo1_pantalla9_forosvirtuales.setBackgroundDrawable(bmDrawable);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia11/boton_anterior_forosvirtuales.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen1_pantalla9_forosvirtuales=(ImageView)findViewById(R.id.imagen1_pantalla9_forosvirtuales);
            imagen1_pantalla9_forosvirtuales.setImageBitmap(bm);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia11/texto_anterior_forosvirtuales.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen2_pantalla9_forosvirtuales=(ImageView)findViewById(R.id.imagen2_pantalla9_forosvirtuales);
            imagen2_pantalla9_forosvirtuales.setImageBitmap(bm);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia11/texto_siguiente_forosvirtuales.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen3_pantalla9_forosvirtuales=(ImageView)findViewById(R.id.imagen3_pantalla9_forosvirtuales);
            imagen3_pantalla9_forosvirtuales.setImageBitmap(bm);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia11/boton_siguiente_forosvirtuales.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen4_pantalla9_forosvirtuales=(ImageView)findViewById(R.id.imagen4_pantalla9_forosvirtuales);
            imagen4_pantalla9_forosvirtuales.setImageBitmap(bm);
        }
        if (ventana_foros == 10) {
            setContentView(R.layout.pantalla10_forosvirtuales);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia11/texto_pantalla10_forosvirtuales.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            bmDrawable = new BitmapDrawable(bm);
            fondo1_pantalla10_forosvirtuales=(ImageView)findViewById(R.id.fondo1_pantalla10_forosvirtuales);
            fondo1_pantalla10_forosvirtuales.setBackgroundDrawable(bmDrawable);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia11/ilustracion_pantalla10_forosvirtuales.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen1_pantalla10_forosvirtuales=(ImageView)findViewById(R.id.imagen1_pantalla10_forosvirtuales);
            imagen1_pantalla10_forosvirtuales.setImageBitmap(bm);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia11/boton_anterior_forosvirtuales.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen2_pantalla10_forosvirtuales=(ImageView)findViewById(R.id.imagen2_pantalla10_forosvirtuales);
            imagen2_pantalla10_forosvirtuales.setImageBitmap(bm);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia11/texto_anterior_forosvirtuales.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen3_pantalla10_forosvirtuales=(ImageView)findViewById(R.id.imagen3_pantalla10_forosvirtuales);
            imagen3_pantalla10_forosvirtuales.setImageBitmap(bm);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia11/texto_siguiente_forosvirtuales.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen4_pantalla10_forosvirtuales=(ImageView)findViewById(R.id.imagen4_pantalla10_forosvirtuales);
            imagen4_pantalla10_forosvirtuales.setImageBitmap(bm);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia11/boton_siguiente_forosvirtuales.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen5_pantalla10_forosvirtuales=(ImageView)findViewById(R.id.imagen5_pantalla10_forosvirtuales);
            imagen5_pantalla10_forosvirtuales.setImageBitmap(bm);
        }
        if (ventana_foros == 11) {
            setContentView(R.layout.pantalla11_forosvirtuales);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia11/texto_pantalla11_forosvirtuales.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            bmDrawable = new BitmapDrawable(bm);
            fondo1_pantalla11_forosvirtuales=(ImageView)findViewById(R.id.fondo1_pantalla11_forosvirtuales);
            fondo1_pantalla11_forosvirtuales.setBackgroundDrawable(bmDrawable);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia11/boton_anterior_forosvirtuales.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen1_pantalla11_forosvirtuales=(ImageView)findViewById(R.id.imagen1_pantalla11_forosvirtuales);
            imagen1_pantalla11_forosvirtuales.setImageBitmap(bm);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia11/texto_anterior_forosvirtuales.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen2_pantalla11_forosvirtuales=(ImageView)findViewById(R.id.imagen2_pantalla11_forosvirtuales);
            imagen2_pantalla11_forosvirtuales.setImageBitmap(bm);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia11/texto_siguiente_forosvirtuales.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen3_pantalla11_forosvirtuales=(ImageView)findViewById(R.id.imagen3_pantalla11_forosvirtuales);
            imagen3_pantalla11_forosvirtuales.setImageBitmap(bm);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia11/boton_siguiente_forosvirtuales.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen4_pantalla11_forosvirtuales=(ImageView)findViewById(R.id.imagen4_pantalla11_forosvirtuales);
            imagen4_pantalla11_forosvirtuales.setImageBitmap(bm);
        }
        if (ventana_foros == 12) {
            setContentView(R.layout.pantalla12_forosvirtuales);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia11/texto_pantalla12_forosvirtuales.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            bmDrawable = new BitmapDrawable(bm);
            fondo1_pantalla12_forosvirtuales=(ImageView)findViewById(R.id.fondo1_pantalla12_forosvirtuales);
            fondo1_pantalla12_forosvirtuales.setBackgroundDrawable(bmDrawable);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia11/boton_anterior_forosvirtuales.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen1_pantalla12_forosvirtuales=(ImageView)findViewById(R.id.imagen1_pantalla12_forosvirtuales);
            imagen1_pantalla12_forosvirtuales.setImageBitmap(bm);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia11/texto_anterior_forosvirtuales.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen2_pantalla12_forosvirtuales=(ImageView)findViewById(R.id.imagen2_pantalla12_forosvirtuales);
            imagen2_pantalla12_forosvirtuales.setImageBitmap(bm);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia11/texto_siguiente_forosvirtuales.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen3_pantalla12_forosvirtuales=(ImageView)findViewById(R.id.imagen3_pantalla12_forosvirtuales);
            imagen3_pantalla12_forosvirtuales.setImageBitmap(bm);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia11/boton_siguiente_forosvirtuales.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen4_pantalla12_forosvirtuales=(ImageView)findViewById(R.id.imagen4_pantalla12_forosvirtuales);
            imagen4_pantalla12_forosvirtuales.setImageBitmap(bm);
        }
        if (ventana_foros == 13) {
            setContentView(R.layout.pantalla13_forosvirtuales);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia11/texto_pantalla13_forosvirtuales.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            bmDrawable = new BitmapDrawable(bm);
            fondo1_pantalla13_forosvirtuales=(ImageView)findViewById(R.id.fondo1_pantalla13_forosvirtuales);
            fondo1_pantalla13_forosvirtuales.setBackgroundDrawable(bmDrawable);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia11/boton_anterior_forosvirtuales.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen1_pantalla13_forosvirtuales=(ImageView)findViewById(R.id.imagen1_pantalla13_forosvirtuales);
            imagen1_pantalla13_forosvirtuales.setImageBitmap(bm);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia11/texto_anterior_forosvirtuales.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen2_pantalla13_forosvirtuales=(ImageView)findViewById(R.id.imagen2_pantalla13_forosvirtuales);
            imagen2_pantalla13_forosvirtuales.setImageBitmap(bm);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia11/texto_siguiente_forosvirtuales.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen3_pantalla13_forosvirtuales=(ImageView)findViewById(R.id.imagen3_pantalla13_forosvirtuales);
            imagen3_pantalla13_forosvirtuales.setImageBitmap(bm);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia11/boton_siguiente_forosvirtuales.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen4_pantalla13_forosvirtuales=(ImageView)findViewById(R.id.imagen4_pantalla13_forosvirtuales);
            imagen4_pantalla13_forosvirtuales.setImageBitmap(bm);
        }
        if (ventana_foros == 14) {
            setContentView(R.layout.pantalla14_forosvirtuales);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia11/texto_pantalla14_forosvirtuales.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            bmDrawable = new BitmapDrawable(bm);
            fondo1_pantalla14_forosvirtuales=(ImageView)findViewById(R.id.fondo1_pantalla14_forosvirtuales);
            fondo1_pantalla14_forosvirtuales.setBackgroundDrawable(bmDrawable);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia11/boton_anterior_forosvirtuales.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen1_pantalla14_forosvirtuales=(ImageView)findViewById(R.id.imagen1_pantalla14_forosvirtuales);
            imagen1_pantalla14_forosvirtuales.setImageBitmap(bm);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia11/texto_anterior_forosvirtuales.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen2_pantalla14_forosvirtuales=(ImageView)findViewById(R.id.imagen2_pantalla14_forosvirtuales);
            imagen2_pantalla14_forosvirtuales.setImageBitmap(bm);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia11/texto_siguiente_forosvirtuales.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen3_pantalla14_forosvirtuales=(ImageView)findViewById(R.id.imagen3_pantalla14_forosvirtuales);
            imagen3_pantalla14_forosvirtuales.setImageBitmap(bm);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia11/boton_siguiente_forosvirtuales.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen4_pantalla14_forosvirtuales=(ImageView)findViewById(R.id.imagen4_pantalla14_forosvirtuales);
            imagen4_pantalla14_forosvirtuales.setImageBitmap(bm);
        }
        if (ventana_foros == 15) {
            setContentView(R.layout.pantalla15_forosvirtuales);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia11/texto_pantalla15_forosvirtuales.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            bmDrawable = new BitmapDrawable(bm);
            fondo1_pantalla15_forosvirtuales=(ImageView)findViewById(R.id.fondo1_pantalla15_forosvirtuales);
            fondo1_pantalla15_forosvirtuales.setBackgroundDrawable(bmDrawable);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia11/boton_anterior_forosvirtuales.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen1_pantalla15_forosvirtuales=(ImageView)findViewById(R.id.imagen1_pantalla15_forosvirtuales);
            imagen1_pantalla15_forosvirtuales.setImageBitmap(bm);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia11/texto_anterior_forosvirtuales.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen2_pantalla15_forosvirtuales=(ImageView)findViewById(R.id.imagen2_pantalla15_forosvirtuales);
            imagen2_pantalla15_forosvirtuales.setImageBitmap(bm);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia11/texto_siguiente_forosvirtuales.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen3_pantalla15_forosvirtuales=(ImageView)findViewById(R.id.imagen3_pantalla15_forosvirtuales);
            imagen3_pantalla15_forosvirtuales.setImageBitmap(bm);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia11/boton_siguiente_forosvirtuales.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen4_pantalla15_forosvirtuales=(ImageView)findViewById(R.id.imagen4_pantalla15_forosvirtuales);
            imagen4_pantalla15_forosvirtuales.setImageBitmap(bm);
        }
        if (ventana_foros == 16) {
            setContentView(R.layout.pantalla16_forosvirtuales);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia11/panel_superior_forosvirtuales.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen1_pantalla16_forosvirtuales=(ImageView)findViewById(R.id.imagen1_pantalla16_forosvirtuales);
            imagen1_pantalla16_forosvirtuales.setImageBitmap(bm);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia11/texto_pantalla16_forosvirtuales.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            imagen2_pantalla16_forosvirtuales=(ImageView)findViewById(R.id.imagen2_pantalla16_forosvirtuales);
            imagen2_pantalla16_forosvirtuales.setImageBitmap(bm);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia11/barra_negra_botones_forosvirtuales.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            bmDrawable = new BitmapDrawable(bm);
            fondo1_pantalla16_forosvirtuales=(LinearLayout)findViewById(R.id.fondo1_pantalla16_forosvirtuales);
            fondo1_pantalla16_forosvirtuales.setBackgroundDrawable(bmDrawable);
            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia11/boton_salir_forosvirtuales.zip");
            bm = BitmapFactory.decodeFile(String.valueOf(carga));
            salir_forosvirtuales=(ImageView)findViewById(R.id.salir_forosvirtuales);
            salir_forosvirtuales.setImageBitmap(bm);
        }
    }

    public Boolean validaVersion(){
        Boolean band=false;
        if(android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1){
            band=true;
        }
        return band;
    }

    public void eliminareg8(){
        String linea=null;
        String linea2=null;
        String usu=null;
        try {
            FileInputStream fIn = new FileInputStream(guardadatosnum);
            InputStreamReader archivo1 = new InputStreamReader(fIn);
            BufferedReader br = new BufferedReader(archivo1);
            linea = br.readLine();
            while(linea!=null){
                StringTokenizer tkn = new StringTokenizer(linea, "&");
                usu=tkn.nextToken();
                if(!usu.equals(usuario)){
                    linea2=linea+salto;
                }
                linea=br.readLine();
            }
            archivo1.close();
            guardadatosnum.delete();
            OutputStreamWriter archivo2 = new OutputStreamWriter(
                    new FileOutputStream(guardadatosnum));
            archivo2.write(linea2);
            archivo2.flush();
            archivo2.close();
        } catch (Exception ex) {
            Log.e("Ficheros", "Error al escribir fichero a memoria interna");
        }
    }

    public void consulta(final String usuario, final String password){
        Thread hilo = new Thread(){
            public void run(){
                try{
                    SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);
                    request.addProperty("usuario", usuario);
                    request.addProperty("password", password);
                    request.addProperty("key", key);
                    SoapSerializationEnvelope sobre = new SoapSerializationEnvelope(SoapEnvelope.VER11);
                    sobre.setOutputSoapObject(request);
                    HttpTransportSE transporte = new HttpTransportSE(URL);
                    transporte.call(SOAP_ACTION, sobre);
                    temp=sobre.getResponse().toString();
                    if(temp.equals("0")){
                        MainActivity.this.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(MainActivity.this, "Usuario o contraseña invalidos, vuelve a intentar", Toast.LENGTH_LONG).show();
                                entrar21.setEnabled(true);
                            }
                        });
                    }
                    else{
                        MainActivity.this.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                temp=extiende(temp);
                                agregar(temp + "," + usuario + "," + password);
                                temp=verifica(usuario);
                                separa(temp);
                                setContentView(R.layout.guias);
                                logeo=true;
                                opcion1.setVisible(true);
                                opcion2.setVisible(true);
                                try {
                                    OutputStreamWriter archivo = new OutputStreamWriter(
                                            new FileOutputStream(temploggeo));
                                    linea = (usuario + "," + password);
                                    archivo.write(linea);
                                    archivo.flush();
                                    archivo.close();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                        });
                    }
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }
        };
        hilo.start();
    }

    public void separa(final String linea){
        StringTokenizer tkn=new StringTokenizer(linea,",");
        this.situacion1=tkn.nextToken();
        this.codigo1=tkn.nextToken();
        this.nombre1=tkn.nextToken();
        if(situacion1.equals("TRABAJADOR")){
            this.departamento1=tkn.nextToken();
            this.centro1=tkn.nextToken();
        }
        else{
            this.centro1=tkn.nextToken();
            this.carrera1=tkn.nextToken();
        }
    }

    public String extiende (String linea){
        String aux;
        aux = linea.substring(1);
        if(linea.startsWith("A")){
            linea="ACTIVO"+aux;
        }
        else{
            if(linea.startsWith("E")){
                linea="EGRESADO"+aux;
            }
            else{
                if(linea.startsWith("T")){
                    linea="TRABAJADOR"+aux;
                }
            }
        }
        return linea;
    }

    public void agregar(String linea){
        try
        {
            FileInputStream fIn = new FileInputStream(nomar);
            InputStreamReader archivo1 = new InputStreamReader(fIn);
            BufferedReader br = new BufferedReader(archivo1);
            String linea2 = br.readLine();
            while(linea2!=null){
                total=total+linea2+salto;
                linea2 = br.readLine();
            }
            archivo1.close();
            total=total+linea;
            OutputStreamWriter archivo2 = new OutputStreamWriter(
                    new FileOutputStream(nomar));
            archivo2.write(total+salto);
            archivo2.flush();
            archivo2.close();
            total="";
        }
        catch (Exception ex)
        {
            Log.e("Ficheros", "Error al escribir fichero a memoria interna");
        }
    }

    public void carga(){
        if(situacion1.equals("TRABAJADOR")){
            setContentView(R.layout.logint);
            situacion=(EditText)findViewById(R.id.situacion4);
            codigo=(EditText)findViewById(R.id.codigo4);
            nombre=(EditText)findViewById(R.id.nombre4);
            departamento=(EditText)findViewById(R.id.depa4);
            centro=(EditText)findViewById(R.id.centro4);
            situacion.setText(situacion1);
            codigo.setText(codigo1);
            nombre.setText(nombre1);
            departamento.setText(departamento1);
            centro.setText(centro1);
        }
        else{
            setContentView(R.layout.login);
            situacion=(EditText)findViewById(R.id.situacion2);
            codigo=(EditText)findViewById(R.id.codigo2);
            nombre=(EditText)findViewById(R.id.nombre2);
            centro=(EditText)findViewById(R.id.centro2);
            carrera=(EditText)findViewById(R.id.carrera2);
            situacion.setText(situacion1);
            codigo.setText(codigo1);
            nombre.setText(nombre1);
            centro.setText(centro1);
            carrera.setText(carrera1);
        }

    }

    public String verifica(String campo1){
        String usuario="";
        String linea2 ="";
        String linea3="";
        try
        {
            FileInputStream fIn = new FileInputStream(nomar);
            InputStreamReader archivo = new InputStreamReader(fIn);
            BufferedReader br = new BufferedReader(archivo);
            linea3 = br.readLine();
            while(linea3!=null){
                StringTokenizer tokens=new StringTokenizer(linea3, ",");
                this.situacion1=tokens.nextToken();
                this.codigo1=tokens.nextToken();
                this.nombre1=tokens.nextToken();
                this.centro1=tokens.nextToken();
                this.carrera1=tokens.nextToken();
                usuario=tokens.nextToken();
                if(campo1.equals(usuario)){
                    confirmacion=true;
                    linea2=linea3;
                }
                if(confirmacion==true){
                    linea3=null;
                }
                else{
                    linea3 = br.readLine();
                }
            }
            archivo.close();
        }
        catch (Exception ex)
        {
            Log.e("Ficheros", "Error al leer fichero desde memoria interna");
        }
        return linea2;
    }

    public Boolean conectadoWifi()
    {
        ConnectivityManager connectivity = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivity != null)
        {
            NetworkInfo info = connectivity.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
            if (info != null)
            {
                if (info.isConnected())
                    return true;
            }
        }
        return false;
    }

    public Boolean conectadoRedMovil()
    {
        ConnectivityManager connectivity = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivity != null)
        {
            NetworkInfo info = connectivity.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
            if (info != null)
            {
                if (info.isConnected())
                    return true;
            }
        }
        return false;
    }

    public Boolean estaConectado()
    {
        if(conectadoWifi())
            return true;
        else
        {
            if(conectadoRedMovil())
                return true;
            else
                return false;
        }
    }

    public void titulo(int numguia) throws FileNotFoundException {
        if(numguia==0){
            this.setTitle("estu@pp");
            getSupportActionBar().setSubtitle("");
            getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#ff137684")));
            opcion1.setVisible(true);
            opcion2.setVisible(true);
            submenu1.setVisible(false);
            submenu3.setVisible(false);
            submenu5.setVisible(false);
            submenu6.setVisible(false);
            submenu7.setVisible(false);
            submenu8.setVisible(false);
            submenu9.setVisible(false);
            submenu10.setVisible(false);
            submenu11.setVisible(false);
        }
        if(numguia==1){
            this.setTitle("");
            getSupportActionBar().setSubtitle("Guía de Habilidades para el Aprendizaje");
            getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#1e40ac")));
            opcion1.setVisible(false);
            opcion2.setVisible(false);
            submenu1.setVisible(true);
            submenu1.setIcon(R.drawable.icono_menu);
        }
        if(numguia==3){
            this.setTitle("");
            getSupportActionBar().setSubtitle("Guía de Habilidades para el Aprendizaje");
            getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#e95e03")));
            opcion1.setVisible(false);
            opcion2.setVisible(false);
            submenu3.setVisible(true);
            submenu3.setIcon(R.drawable.icono_menu);
        }
        if(numguia==5){
            this.setTitle("");
            getSupportActionBar().setSubtitle("Guía de Habilidades para el Aprendizaje");
            getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#08478a")));
            opcion1.setVisible(false);
            opcion2.setVisible(false);
            submenu5.setVisible(true);
            submenu5.setIcon(R.drawable.icono_menu);
        }
        if(numguia==6){
            this.setTitle("");
            getSupportActionBar().setSubtitle("Guía de Habilidades para el Aprendizaje");
            getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#6d2401")));
            opcion1.setVisible(false);
            opcion2.setVisible(false);
            submenu6.setVisible(true);
            submenu6.setIcon(R.drawable.icono_menu);
        }
        if(numguia==7){
            this.setTitle("");
            getSupportActionBar().setSubtitle("Guía de Habilidades para el Aprendizaje");
            getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#083f9c")));
            opcion1.setVisible(false);
            opcion2.setVisible(false);
            submenu7.setVisible(true);
            submenu7.setIcon(R.drawable.icono_menu);
        }
        if(numguia==8){
            this.setTitle("");
            getSupportActionBar().setSubtitle("Guía de Habilidades para el Aprendizaje");
            opcion1.setVisible(false);
            opcion2.setVisible(false);
            submenu8.setVisible(true);
            submenu8.setIcon(R.drawable.icono_menu);
        }
        if(numguia==9){
            this.setTitle("");
            getSupportActionBar().setSubtitle("Capacidades para el aprendizaje de las matemáticas");
            getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FF5DA233")));
            opcion1.setVisible(false);
            opcion2.setVisible(false);
            submenu9.setVisible(true);
        }
        if(numguia==10){
            this.setTitle("");
            getSupportActionBar().setSubtitle("Guía de Habilidades para el Aprendizaje");
            getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FFC0B080")));
            opcion1.setVisible(false);
            opcion2.setVisible(false);
            submenu10.setVisible(true);
        }
        if(numguia==11){
            this.setTitle("");
            getSupportActionBar().setSubtitle("Participación en foros virtuales");
            getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FF4A4A4A")));
            opcion1.setVisible(false);
            opcion2.setVisible(false);
            submenu11.setVisible(true);
        }
    }

    public void Alerta(String title, String message, final int pregunta){
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
        alertDialog.setTitle(title);
        alertDialog.setMessage(message);
        alertDialog.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {

                dialog.dismiss();
            }
        });
        if(android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1){
            alertDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                public void onDismiss(DialogInterface arg0) {
                    SeCerro(pregunta);
                }

            });
        }
        else{
            SeCerro(pregunta);
        }
        alertDialog.show();
    }

    public void SeCerro(int pregunta){
        if(pregunta==1){
            ventana_datosnum=15;
            validaVentana8();
            seleccion8=false;
        }
        if(pregunta==2){
            ventana_datosnum=16;
            validaVentana8();
            seleccion8=false;
        }
        if(pregunta==3){
            ventana_datosnum=17;
            validaVentana8();
            seleccion8=false;
        }
        if(pregunta==4){
            ventana_datosnum=18;
            validaVentana8();
            seleccion8=false;
        }
        if(pregunta==5){
            ventana_datosnum=19;
            validaVentana8();
            seleccion8=false;
        }
        if(pregunta==6){
            ventana_datosnum=20;
            validaVentana8();
            seleccion8=false;
        }
        if(pregunta==7){
            ventana_datosnum=21;
            validaVentana8();
            seleccion8=false;
        }
        if(pregunta==8){
            ventana_datosnum=22;
            validaVentana8();
            seleccion8=false;
        }
        if(pregunta==9){
            ventana_datosnum=23;
            validaVentana8();
            seleccion8=false;
        }
        if(pregunta==10){
            ventana_datosnum=24;
            validaVentana8();
            seleccion8=false;
        }
        if(pregunta==11){
            ventana_datosnum=25;
            validaVentana8();
            seleccion8=false;
        }
        if(pregunta==12){
            ventana_datosnum=26;
            validaVentana8();
            seleccion8=false;
        }
        if(pregunta==13){
            ventana_datosnum=27;
            validaVentana8();
            seleccion8=false;
        }
        if(pregunta==14){
            ventana_datosnum=28;
            validaVentana8();
            seleccion8=false;
        }
    }

    private void tiempo(final String title, final String message, final int pregunta)
    {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                Alerta(title, message, pregunta);
            }
        }, TIEMPO);
    }

    private void descargar(String rutaarchivos, String Url, String nombrearc) {
        File dir=Environment.getExternalStoragePublicDirectory(rutaarchivos);
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

    public Boolean dropbox(){
        String rutaarchivos;
        String url;
        String nomarchivo;
        File dir;
        if(numguia==1){
            rutaarchivos="/.estu@pp/guia1/";
            dir = Environment.getExternalStoragePublicDirectory(rutaarchivos);
            if (!dir.exists())
            {
                url = "https://dl.dropbox.com/s/cdj6eyfrz8zsvwq/bienvenida_frances.png?dl=0";
                nomarchivo = "bienvenida_frances.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/lcebudac2w6f25f/boton_anterior_frances.png?dl=0";
                nomarchivo = "boton_anterior_frances.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/oa4rc1fbwfdyf0j/boton_salir_frances.png?dl=0";
                nomarchivo = "boton_salir_frances.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/0654yri9r0786ts/boton_siguiente_frances.png?dl=0";
                nomarchivo = "boton_siguiente_frances.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/gz97lfkyi697ujd/comenzar_frances.png?dl=0";
                nomarchivo = "comenzar_frances.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/oq5t544u6lqnp8m/ilustracion1_pantalla1_14_frances.png?dl=0";
                nomarchivo = "ilustracion1_pantalla1_14_frances.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/8bhak362c7xan41/ilustracion1_pantalla2_3_frances.png?dl=0";
                nomarchivo = "ilustracion1_pantalla2_3_frances.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/cxh23gk6jnacqix/ilustracion1_pantalla3_frances.png?dl=0";
                nomarchivo = "ilustracion1_pantalla3_frances.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/02gd45dc9icayf4/ilustracion1_pantalla4_frances.png?dl=0";
                nomarchivo = "ilustracion1_pantalla4_frances.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/4vrzzgajssc4edu/ilustracion1_pantalla5_frances.png?dl=0";
                nomarchivo = "ilustracion1_pantalla5_frances.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/4sfoi33r75e8vdl/ilustracion1_pantalla6_frances.png?dl=0";
                nomarchivo = "ilustracion1_pantalla6_frances.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/phwozc4aew7a7j3/ilustracion1_pantalla7_frances.png?dl=0";
                nomarchivo = "ilustracion1_pantalla7_frances.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/2j9tf0feuw2zflv/ilustracion1_pantalla8_frances.png?dl=0";
                nomarchivo = "ilustracion1_pantalla8_frances.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/qu5jrmwhc61oiz2/ilustracion1_pantalla9_frances.png?dl=0";
                nomarchivo = "ilustracion1_pantalla9_frances.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/qhqs1rutkbeymqu/ilustracion1_pantalla12_frances.png?dl=0";
                nomarchivo = "ilustracion1_pantalla12_frances.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/p4yo2cabiz5ybuh/ilustracion1_pantalla13_frances.png?dl=0";
                nomarchivo = "ilustracion1_pantalla13_frances.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/vacqc3do319s2x8/ilustracion1_pantalla15_frances.png?dl=0";
                nomarchivo = "ilustracion1_pantalla15_frances.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/k09tiq4i04ig3pk/ilustracion1_pantalla16_frances.png?dl=0";
                nomarchivo = "ilustracion1_pantalla16_frances.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/it1268wx3czcf1l/ilustracion1_pantalla18_frances.png?dl=0";
                nomarchivo = "ilustracion1_pantalla18_frances.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/h5ytn087bjmxxvz/ilustracion1_pantalla19_frances.png?dl=0";
                nomarchivo = "ilustracion1_pantalla19_frances.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/1iut4or4vu0pvte/ilustracion1_pantalla20_frances.png?dl=0";
                nomarchivo = "ilustracion1_pantalla20_frances.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/1e57lldi2gkimcz/ilustracion1_pantalla21_22_frances.png?dl=0";
                nomarchivo = "ilustracion1_pantalla21_22_frances.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/48e0gb1rmtlcug3/ilustracion1_pantalla22_frances.png?dl=0";
                nomarchivo = "ilustracion1_pantalla22_frances.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/bbfrvk0fciqnm3n/ilustracion1_pantalla23_frances.png?dl=0";
                nomarchivo = "ilustracion1_pantalla23_frances.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/7ccx6qoova0oizj/ilustracion2_pantalla6_frances.png?dl=0";
                nomarchivo = "ilustracion2_pantalla6_frances.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/nl8g4t5go9ns0g6/ilustracion2_pantalla22_frances.png?dl=0";
                nomarchivo = "ilustracion2_pantalla22_frances.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/dmop7k4uw5m7low/ilustracion3_pantalla22_frances.png?dl=0";
                nomarchivo = "ilustracion3_pantalla22_frances.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/tttgrxwq9gwyme1/ilustracion4_pantalla22_frances.png?dl=0";
                nomarchivo = "ilustracion4_pantalla22_frances.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/h2vgnntg265er5d/ilustracion5_pantalla22_frances.png?dl=0";
                nomarchivo = "ilustracion5_pantalla22_frances.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/n6px8v0iwjzrb50/ilustracion6_pantalla22_frances.png?dl=0";
                nomarchivo = "ilustracion6_pantalla22_frances.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/zcrq1f9digvtrdg/ilustracion7_pantalla22_frances.png?dl=0";
                nomarchivo = "ilustracion7_pantalla22_frances.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/6r05cozbuoygdhb/ilustracion8_pantalla22_frances.png?dl=0";
                nomarchivo = "ilustracion8_pantalla22_frances.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/s9rx46w20f0ip0z/ilustracion9_pantalla22_frances.png?dl=0";
                nomarchivo = "ilustracion9_pantalla22_frances.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/aar4tay1d1mp5wp/ilustracion10_pantalla22_frances.png?dl=0";
                nomarchivo = "ilustracion10_pantalla22_frances.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/5ybnkg17z814v12/ilustracion11_pantalla22_frances.png?dl=0";
                nomarchivo = "ilustracion11_pantalla22_frances.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/595emgmg9q19jkf/ilustracion12_pantalla22_frances.png?dl=0";
                nomarchivo = "ilustracion12_pantalla22_frances.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/4p9pix3nfhvraxt/portada_frances.png?dl=0";
                nomarchivo = "portada_frances.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/s4j3fnsyd4p7ojo/ilustracion1_pantalla11_frances.png?dl=0";
                nomarchivo = "ilustracion1_pantalla11_frances.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/h3qw2g3359dufiv/ilustracion1_pantalla14_frances.png?dl=0";
                nomarchivo = "ilustracion1_pantalla14_frances.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/dvf7juumd56808a/ilustracion1_pantalla17_frances.png?dl=0";
                nomarchivo = "ilustracion1_pantalla17_frances.zip";
                descargar(rutaarchivos, url, nomarchivo);
            }
            else
            {
                url = "https://dl.dropbox.com/s/cdj6eyfrz8zsvwq/bienvenida_frances.png?dl=0";
                nomarchivo = "bienvenida_frances.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/lcebudac2w6f25f/boton_anterior_frances.png?dl=0";
                nomarchivo = "boton_anterior_frances.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/oa4rc1fbwfdyf0j/boton_salir_frances.png?dl=0";
                nomarchivo = "boton_salir_frances.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/0654yri9r0786ts/boton_siguiente_frances.png?dl=0";
                nomarchivo = "boton_siguiente_frances.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/gz97lfkyi697ujd/comenzar_frances.png?dl=0";
                nomarchivo = "comenzar_frances.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/oq5t544u6lqnp8m/ilustracion1_pantalla1_14_frances.png?dl=0";
                nomarchivo = "ilustracion1_pantalla1_14_frances.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/8bhak362c7xan41/ilustracion1_pantalla2_3_frances.png?dl=0";
                nomarchivo = "ilustracion1_pantalla2_3_frances.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/cxh23gk6jnacqix/ilustracion1_pantalla3_frances.png?dl=0";
                nomarchivo = "ilustracion1_pantalla3_frances.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/02gd45dc9icayf4/ilustracion1_pantalla4_frances.png?dl=0";
                nomarchivo = "ilustracion1_pantalla4_frances.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/4vrzzgajssc4edu/ilustracion1_pantalla5_frances.png?dl=0";
                nomarchivo = "ilustracion1_pantalla5_frances.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/4sfoi33r75e8vdl/ilustracion1_pantalla6_frances.png?dl=0";
                nomarchivo = "ilustracion1_pantalla6_frances.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/phwozc4aew7a7j3/ilustracion1_pantalla7_frances.png?dl=0";
                nomarchivo = "ilustracion1_pantalla7_frances.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/2j9tf0feuw2zflv/ilustracion1_pantalla8_frances.png?dl=0";
                nomarchivo = "ilustracion1_pantalla8_frances.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/qu5jrmwhc61oiz2/ilustracion1_pantalla9_frances.png?dl=0";
                nomarchivo = "ilustracion1_pantalla9_frances.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/s4j3fnsyd4p7ojo/ilustracion1_pantalla11_frances.png?dl=0";
                nomarchivo = "ilustracion1_pantalla11_frances.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/qhqs1rutkbeymqu/ilustracion1_pantalla12_frances.png?dl=0";
                nomarchivo = "ilustracion1_pantalla12_frances.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/p4yo2cabiz5ybuh/ilustracion1_pantalla13_frances.png?dl=0";
                nomarchivo = "ilustracion1_pantalla13_frances.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/h3qw2g3359dufiv/ilustracion1_pantalla14_frances.png?dl=0";
                nomarchivo = "ilustracion1_pantalla14_frances.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if(!dir.exists())
                {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/vacqc3do319s2x8/ilustracion1_pantalla15_frances.png?dl=0";
                nomarchivo = "ilustracion1_pantalla15_frances.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/k09tiq4i04ig3pk/ilustracion1_pantalla16_frances.png?dl=0";
                nomarchivo = "ilustracion1_pantalla16_frances.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/dvf7juumd56808a/ilustracion1_pantalla17_frances.png?dl=0";
                nomarchivo = "ilustracion1_pantalla17_frances.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if(!dir.exists())
                {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/it1268wx3czcf1l/ilustracion1_pantalla18_frances.png?dl=0";
                nomarchivo = "ilustracion1_pantalla18_frances.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/h5ytn087bjmxxvz/ilustracion1_pantalla19_frances.png?dl=0";
                nomarchivo = "ilustracion1_pantalla19_frances.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if(!dir.exists())
                {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/1iut4or4vu0pvte/ilustracion1_pantalla20_frances.png?dl=0";
                nomarchivo = "ilustracion1_pantalla20_frances.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/1e57lldi2gkimcz/ilustracion1_pantalla21_22_frances.png?dl=0";
                nomarchivo = "ilustracion1_pantalla21_22_frances.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/48e0gb1rmtlcug3/ilustracion1_pantalla22_frances.png?dl=0";
                nomarchivo = "ilustracion1_pantalla22_frances.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/bbfrvk0fciqnm3n/ilustracion1_pantalla23_frances.png?dl=0";
                nomarchivo = "ilustracion1_pantalla23_frances.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/7ccx6qoova0oizj/ilustracion2_pantalla6_frances.png?dl=0";
                nomarchivo = "ilustracion2_pantalla6_frances.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/nl8g4t5go9ns0g6/ilustracion2_pantalla22_frances.png?dl=0";
                nomarchivo = "ilustracion2_pantalla22_frances.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/dmop7k4uw5m7low/ilustracion3_pantalla22_frances.png?dl=0";
                nomarchivo = "ilustracion3_pantalla22_frances.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/tttgrxwq9gwyme1/ilustracion4_pantalla22_frances.png?dl=0";
                nomarchivo = "ilustracion4_pantalla22_frances.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/h2vgnntg265er5d/ilustracion5_pantalla22_frances.png?dl=0";
                nomarchivo = "ilustracion5_pantalla22_frances.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/n6px8v0iwjzrb50/ilustracion6_pantalla22_frances.png?dl=0";
                nomarchivo = "ilustracion6_pantalla22_frances.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/zcrq1f9digvtrdg/ilustracion7_pantalla22_frances.png?dl=0";
                nomarchivo = "ilustracion7_pantalla22_frances.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/6r05cozbuoygdhb/ilustracion8_pantalla22_frances.png?dl=0";
                nomarchivo = "ilustracion8_pantalla22_frances.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/s9rx46w20f0ip0z/ilustracion9_pantalla22_frances.png?dl=0";
                nomarchivo = "ilustracion9_pantalla22_frances.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/aar4tay1d1mp5wp/ilustracion10_pantalla22_frances.png?dl=0";
                nomarchivo = "ilustracion10_pantalla22_frances.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/5ybnkg17z814v12/ilustracion11_pantalla22_frances.png?dl=0";
                nomarchivo = "ilustracion11_pantalla22_frances.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/595emgmg9q19jkf/ilustracion12_pantalla22_frances.png?dl=0";
                nomarchivo = "ilustracion12_pantalla22_frances.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/4p9pix3nfhvraxt/portada_frances.png?dl=0";
                nomarchivo = "portada_frances.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
            }
            return true;
        }
        if(numguia==3){
            rutaarchivos="/.estu@pp/guia3/";
            dir = Environment.getExternalStoragePublicDirectory(rutaarchivos);
            if (!dir.exists()) {
                url = "https://dl.dropbox.com/s/tztm5m394m6usry/boton_anterior_administraciondeltiempo.png?dl=0";
                nomarchivo = "boton_anterior_administraciondeltiempo.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/stes4qn58j12otb/boton_salir_administraciondeltiempo.png?dl=0";
                nomarchivo = "boton_salir_administraciondeltiempo.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/hmjdrpcblb0aei1/boton_siguiente_administraciondeltiempo.png?dl=0";
                nomarchivo = "boton_siguiente_administraciondeltiempo.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/9y8ubbm74tnl6wd/comenzar_administraciondeltiempo.png?dl=0";
                nomarchivo = "comenzar_administraciondeltiempo.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/xto9omn0pm1tlxd/ilustracion1_pantalla1_administraciondeltiempo.png?dl=0";
                nomarchivo = "ilustracion1_pantalla1_administraciondeltiempo.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/e5f7b803j3wxemi/ilustracion1_pantalla2_administraciondeltiempo.png?dl=0";
                nomarchivo = "ilustracion1_pantalla2_administraciondeltiempo.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/nmbwcrtcheai16a/ilustracion1_pantalla3_administraciondeltiempo.png?dl=0";
                nomarchivo = "ilustracion1_pantalla3_administraciondeltiempo.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/i0l6vny0k39yjl0/ilustracion1_pantalla4_administraciondeltiempo.png?dl=0";
                nomarchivo = "ilustracion1_pantalla4_administraciondeltiempo.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/18j1qqnktzgav0c/ilustracion1_pantalla5_administraciondeltiempo.png?dl=0";
                nomarchivo = "ilustracion1_pantalla5_administraciondeltiempo.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/bb9u72r2xpetozl/ilustracion1_pantalla6_administraciondeltiempo.png?dl=0";
                nomarchivo = "ilustracion1_pantalla6_administraciondeltiempo.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/plygwnyoopgdnds/ilustracion1_pantalla7_administraciondeltiempo.png?dl=0";
                nomarchivo = "ilustracion1_pantalla7_administraciondeltiempo.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/5oh4qgq0veleda9/ilustracion1_pantalla8_administraciondeltiempo.png?dl=0";
                nomarchivo = "ilustracion1_pantalla8_administraciondeltiempo.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/ifcssbpz306fbgy/ilustracion1_pantalla9_administraciondeltiempo.png?dl=0";
                nomarchivo = "ilustracion1_pantalla9_administraciondeltiempo.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/bc8dlm47rjy7oei/ilustracion1_pantalla10_administraciondeltiempo.png?dl=0";
                nomarchivo = "ilustracion1_pantalla10_administraciondeltiempo.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/7l7fldf8sqk7j9c/ilustracion1_pantalla11_administraciondeltiempo.png?dl=0";
                nomarchivo = "ilustracion1_pantalla11_administraciondeltiempo.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/y6m8ivnv0vaghlk/ilustracion1_pantalla12_administraciondeltiempo.png?dl=0";
                nomarchivo = "ilustracion1_pantalla12_administraciondeltiempo.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/92z33u9iksapldh/ilustracion1_pantalla13_administraciondeltiempo.png?dl=0";
                nomarchivo = "ilustracion1_pantalla13_administraciondeltiempo.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/4dhjd0jf765y2mi/ilustracion1_pantalla14_administraciondeltiempo.png?dl=0";
                nomarchivo = "ilustracion1_pantalla14_administraciondeltiempo.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/saybc5meojooass/ilustracion1_pantalla15_administraciondeltiempo.png?dl=0";
                nomarchivo = "ilustracion1_pantalla15_administraciondeltiempo.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/b4ajw86d3nbdu51/ilustracion1_pantalla16_administraciondeltiempo.png?dl=0";
                nomarchivo = "ilustracion1_pantalla16_administraciondeltiempo.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/xnsoxjzqvlf2c9b/ilustracion1_pantalla17_administraciondeltiempo.png?dl=0";
                nomarchivo = "ilustracion1_pantalla17_administraciondeltiempo.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/sa00r8bfe2jmzwf/ilustracion1_pantalla18_administraciondeltiempo.png?dl=0";
                nomarchivo = "ilustracion1_pantalla18_administraciondeltiempo.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/9j928uurevd1cp9/ilustracion1_pantalla19_administraciondeltiempo.png?dl=0";
                nomarchivo = "ilustracion1_pantalla19_administraciondeltiempo.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/az2qa9ju3wzzi2w/ilustracion1_pantalla20_administraciondeltiempo.png?dl=0";
                nomarchivo = "ilustracion1_pantalla20_administraciondeltiempo.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/tmebn2nb5mmiaj3/ilustracion1_pantalla21_administraciondeltiempo.png?dl=0";
                nomarchivo = "ilustracion1_pantalla21_administraciondeltiempo.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/ko88qb2qldbg6qd/ilustracion1_pantalla22_administraciondeltiempo.png?dl=0";
                nomarchivo = "ilustracion1_pantalla22_administraciondeltiempo.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/vgcmnv8q6ytcabq/ilustracion2_pantalla2_administraciondeltiempo.png?dl=0";
                nomarchivo = "ilustracion2_pantalla2_administraciondeltiempo.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/eyx9hxag6semo4c/ilustracion2_pantalla3_administraciondeltiempo.png?dl=0";
                nomarchivo = "ilustracion2_pantalla3_administraciondeltiempo.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/7yidwtu3u2a5e39/ilustracion2_pantalla4_administraciondeltiempo.png?dl=0";
                nomarchivo = "ilustracion2_pantalla4_administraciondeltiempo.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/4nny3lwduujzvfe/ilustracion2_pantalla5_administraciondeltiempo.png?dl=0";
                nomarchivo = "ilustracion2_pantalla5_administraciondeltiempo.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/5y5mlpb4vyefle4/ilustracion2_pantalla6_administraciondeltiempo.png?dl=0";
                nomarchivo = "ilustracion2_pantalla6_administraciondeltiempo.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/se9cgt1hl20hj8q/ilustracion2_pantalla7_administraciondeltiempo.png?dl=0";
                nomarchivo = "ilustracion2_pantalla7_administraciondeltiempo.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/1awbekpomr7pe96/ilustracion2_pantalla8_administraciondeltiempo.png?dl=0";
                nomarchivo = "ilustracion2_pantalla8_administraciondeltiempo.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/igljic7iiyf8nsp/ilustracion2_pantalla11_administraciondeltiempo.png?dl=0";
                nomarchivo = "ilustracion2_pantalla11_administraciondeltiempo.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/7kqtae705aub8nk/ilustracion2_pantalla12_administraciondeltiempo.png?dl=0";
                nomarchivo = "ilustracion2_pantalla12_administraciondeltiempo.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/pw2m80blf3da3p1/ilustracion2_pantalla13_administraciondeltiempo.png?dl=0";
                nomarchivo = "ilustracion2_pantalla13_administraciondeltiempo.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/hgrw5xt24dziext/ilustracion2_pantalla14_administraciondeltiempo.png?dl=0";
                nomarchivo = "ilustracion2_pantalla14_administraciondeltiempo.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/ou57jopktqgf9ua/ilustracion2_pantalla15_administraciondeltiempo.png?dl=0";
                nomarchivo = "ilustracion2_pantalla15_administraciondeltiempo.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/76g30wl5newvzy5/ilustracion2_pantalla16_administraciondeltiempo.png?dl=0";
                nomarchivo = "ilustracion2_pantalla16_administraciondeltiempo.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/5om05y312b4vscw/ilustracion2_pantalla17_administraciondeltiempo.png?dl=0";
                nomarchivo = "ilustracion2_pantalla17_administraciondeltiempo.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/k7f4obdxnddig5v/ilustracion2_pantalla18_administraciondeltiempo.png?dl=0";
                nomarchivo = "ilustracion2_pantalla18_administraciondeltiempo.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/84nv0qg9ys7j81v/ilustracion2_pantalla21_administraciondeltiempo.png?dl=0";
                nomarchivo = "ilustracion2_pantalla21_administraciondeltiempo.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/mgum3byjv4bp9v3/ilustracion3_pantalla5_administraciondeltiempo.png?dl=0";
                nomarchivo = "ilustracion3_pantalla5_administraciondeltiempo.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/vvbuz1rtzha4npr/ilustracion4_pantalla5_administraciondeltiempo.png?dl=0";
                nomarchivo = "ilustracion4_pantalla5_administraciondeltiempo.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/ucl0po7vap3s0rw/portada_administraciondeltiempo.png?dl=0";
                nomarchivo = "portada_administraciondeltiempo.zip";
                descargar(rutaarchivos, url, nomarchivo);
            }
            else
            {
                url = "https://dl.dropbox.com/s/tztm5m394m6usry/boton_anterior_administraciondeltiempo.png?dl=0";
                nomarchivo = "boton_anterior_administraciondeltiempo.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/stes4qn58j12otb/boton_salir_administraciondeltiempo.png?dl=0";
                nomarchivo = "boton_salir_administraciondeltiempo.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/hmjdrpcblb0aei1/boton_siguiente_administraciondeltiempo.png?dl=0";
                nomarchivo = "boton_siguiente_administraciondeltiempo.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/9y8ubbm74tnl6wd/comenzar_administraciondeltiempo.png?dl=0";
                nomarchivo = "comenzar_administraciondeltiempo.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/xto9omn0pm1tlxd/ilustracion1_pantalla1_administraciondeltiempo.png?dl=0";
                nomarchivo = "ilustracion1_pantalla1_administraciondeltiempo.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/e5f7b803j3wxemi/ilustracion1_pantalla2_administraciondeltiempo.png?dl=0";
                nomarchivo = "ilustracion1_pantalla2_administraciondeltiempo.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/nmbwcrtcheai16a/ilustracion1_pantalla3_administraciondeltiempo.png?dl=0";
                nomarchivo = "ilustracion1_pantalla3_administraciondeltiempo.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/i0l6vny0k39yjl0/ilustracion1_pantalla4_administraciondeltiempo.png?dl=0";
                nomarchivo = "ilustracion1_pantalla4_administraciondeltiempo.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/18j1qqnktzgav0c/ilustracion1_pantalla5_administraciondeltiempo.png?dl=0";
                nomarchivo = "ilustracion1_pantalla5_administraciondeltiempo.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/bb9u72r2xpetozl/ilustracion1_pantalla6_administraciondeltiempo.png?dl=0";
                nomarchivo = "ilustracion1_pantalla6_administraciondeltiempo.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/plygwnyoopgdnds/ilustracion1_pantalla7_administraciondeltiempo.png?dl=0";
                nomarchivo = "ilustracion1_pantalla7_administraciondeltiempo.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/5oh4qgq0veleda9/ilustracion1_pantalla8_administraciondeltiempo.png?dl=0";
                nomarchivo = "ilustracion1_pantalla8_administraciondeltiempo.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/ifcssbpz306fbgy/ilustracion1_pantalla9_administraciondeltiempo.png?dl=0";
                nomarchivo = "ilustracion1_pantalla9_administraciondeltiempo.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/bc8dlm47rjy7oei/ilustracion1_pantalla10_administraciondeltiempo.png?dl=0";
                nomarchivo = "ilustracion1_pantalla10_administraciondeltiempo.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/7l7fldf8sqk7j9c/ilustracion1_pantalla11_administraciondeltiempo.png?dl=0";
                nomarchivo = "ilustracion1_pantalla11_administraciondeltiempo.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/y6m8ivnv0vaghlk/ilustracion1_pantalla12_administraciondeltiempo.png?dl=0";
                nomarchivo = "ilustracion1_pantalla12_administraciondeltiempo.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/92z33u9iksapldh/ilustracion1_pantalla13_administraciondeltiempo.png?dl=0";
                nomarchivo = "ilustracion1_pantalla13_administraciondeltiempo.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/4dhjd0jf765y2mi/ilustracion1_pantalla14_administraciondeltiempo.png?dl=0";
                nomarchivo = "ilustracion1_pantalla14_administraciondeltiempo.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/saybc5meojooass/ilustracion1_pantalla15_administraciondeltiempo.png?dl=0";
                nomarchivo = "ilustracion1_pantalla15_administraciondeltiempo.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/b4ajw86d3nbdu51/ilustracion1_pantalla16_administraciondeltiempo.png?dl=0";
                nomarchivo = "ilustracion1_pantalla16_administraciondeltiempo.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/xnsoxjzqvlf2c9b/ilustracion1_pantalla17_administraciondeltiempo.png?dl=0";
                nomarchivo = "ilustracion1_pantalla17_administraciondeltiempo.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/sa00r8bfe2jmzwf/ilustracion1_pantalla18_administraciondeltiempo.png?dl=0";
                nomarchivo = "ilustracion1_pantalla18_administraciondeltiempo.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/9j928uurevd1cp9/ilustracion1_pantalla19_administraciondeltiempo.png?dl=0";
                nomarchivo = "ilustracion1_pantalla19_administraciondeltiempo.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/az2qa9ju3wzzi2w/ilustracion1_pantalla20_administraciondeltiempo.png?dl=0";
                nomarchivo = "ilustracion1_pantalla20_administraciondeltiempo.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/tmebn2nb5mmiaj3/ilustracion1_pantalla21_administraciondeltiempo.png?dl=0";
                nomarchivo = "ilustracion1_pantalla21_administraciondeltiempo.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/ko88qb2qldbg6qd/ilustracion1_pantalla22_administraciondeltiempo.png?dl=0";
                nomarchivo = "ilustracion1_pantalla22_administraciondeltiempo.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/vgcmnv8q6ytcabq/ilustracion2_pantalla2_administraciondeltiempo.png?dl=0";
                nomarchivo = "ilustracion2_pantalla2_administraciondeltiempo.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/eyx9hxag6semo4c/ilustracion2_pantalla3_administraciondeltiempo.png?dl=0";
                nomarchivo = "ilustracion2_pantalla3_administraciondeltiempo.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/7yidwtu3u2a5e39/ilustracion2_pantalla4_administraciondeltiempo.png?dl=0";
                nomarchivo = "ilustracion2_pantalla4_administraciondeltiempo.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/4nny3lwduujzvfe/ilustracion2_pantalla5_administraciondeltiempo.png?dl=0";
                nomarchivo = "ilustracion2_pantalla5_administraciondeltiempo.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/5y5mlpb4vyefle4/ilustracion2_pantalla6_administraciondeltiempo.png?dl=0";
                nomarchivo = "ilustracion2_pantalla6_administraciondeltiempo.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/se9cgt1hl20hj8q/ilustracion2_pantalla7_administraciondeltiempo.png?dl=0";
                nomarchivo = "ilustracion2_pantalla7_administraciondeltiempo.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/1awbekpomr7pe96/ilustracion2_pantalla8_administraciondeltiempo.png?dl=0";
                nomarchivo = "ilustracion2_pantalla8_administraciondeltiempo.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/igljic7iiyf8nsp/ilustracion2_pantalla11_administraciondeltiempo.png?dl=0";
                nomarchivo = "ilustracion2_pantalla11_administraciondeltiempo.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/7kqtae705aub8nk/ilustracion2_pantalla12_administraciondeltiempo.png?dl=0";
                nomarchivo = "ilustracion2_pantalla12_administraciondeltiempo.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/pw2m80blf3da3p1/ilustracion2_pantalla13_administraciondeltiempo.png?dl=0";
                nomarchivo = "ilustracion2_pantalla13_administraciondeltiempo.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/hgrw5xt24dziext/ilustracion2_pantalla14_administraciondeltiempo.png?dl=0";
                nomarchivo = "ilustracion2_pantalla14_administraciondeltiempo.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/ou57jopktqgf9ua/ilustracion2_pantalla15_administraciondeltiempo.png?dl=0";
                nomarchivo = "ilustracion2_pantalla15_administraciondeltiempo.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/76g30wl5newvzy5/ilustracion2_pantalla16_administraciondeltiempo.png?dl=0";
                nomarchivo = "ilustracion2_pantalla16_administraciondeltiempo.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/5om05y312b4vscw/ilustracion2_pantalla17_administraciondeltiempo.png?dl=0";
                nomarchivo = "ilustracion2_pantalla17_administraciondeltiempo.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/k7f4obdxnddig5v/ilustracion2_pantalla18_administraciondeltiempo.png?dl=0";
                nomarchivo = "ilustracion2_pantalla18_administraciondeltiempo.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/84nv0qg9ys7j81v/ilustracion2_pantalla21_administraciondeltiempo.png?dl=0";
                nomarchivo = "ilustracion2_pantalla21_administraciondeltiempo.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/mgum3byjv4bp9v3/ilustracion3_pantalla5_administraciondeltiempo.png?dl=0";
                nomarchivo = "ilustracion3_pantalla5_administraciondeltiempo.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/vvbuz1rtzha4npr/ilustracion4_pantalla5_administraciondeltiempo.png?dl=0";
                nomarchivo = "ilustracion4_pantalla5_administraciondeltiempo.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/ucl0po7vap3s0rw/portada_administraciondeltiempo.png?dl=0";
                nomarchivo = "portada_administraciondeltiempo.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
            }
            return true;
        }
        if(numguia==5){
            rutaarchivos="/.estu@pp/guia5/";
            dir = Environment.getExternalStoragePublicDirectory(rutaarchivos);
            if (!dir.exists()) {
                url = "https://dl.dropbox.com/s/5p9uxzrtgx3v4tm/boton_anterior_estres.png?dl=0";
                nomarchivo = "boton_anterior_estres.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/zimjo44oyfhb7mc/boton_siguiente_estres.png?dl=0";
                nomarchivo = "boton_siguiente_estres.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/5n1ft6ljh5zp8il/comenzar_estres.png?dl=0";
                nomarchivo = "comenzar_estres.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/ikmkpr0cgav31ex/ilustracion1_pantalal12_estres.png?dl=0";
                nomarchivo = "ilustracion1_pantalal12_estres.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/q0dhaauens9t07m/ilustracion1_pantalla1_estres.png?dl=0";
                nomarchivo = "ilustracion1_pantalla1_estres.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/rb64j9s0wwkozzz/ilustracion1_pantalla2_estres.png?dl=0";
                nomarchivo = "ilustracion1_pantalla2_estres.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/g0ruqugidme75yj/ilustracion1_pantalla3_estres.png?dl=0";
                nomarchivo = "ilustracion1_pantalla3_estres.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/86pruer739qu7pw/ilustracion1_pantalla6_estres.png?dl=0";
                nomarchivo = "ilustracion1_pantalla6_estres.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/gxjgk8jt8wobs0a/ilustracion1_pantalla7_estres.png?dl=0";
                nomarchivo = "ilustracion1_pantalla7_estres.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/um4zrpghoa0k7ql/ilustracion1_pantalla8_estres.png?dl=0";
                nomarchivo = "ilustracion1_pantalla8_estres.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/byuazs2ak89f19d/ilustracion1_pantalla9_estres.png?dl=0";
                nomarchivo = "ilustracion1_pantalla9_estres.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/61p77hb7c2iw06k/ilustracion1_pantalla10_estres.png?dl=0";
                nomarchivo = "ilustracion1_pantalla10_estres.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/8xgbnpr20iug39t/ilustracion1_pantalla11_estres.png?dl=0";
                nomarchivo = "ilustracion1_pantalla11_estres.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/o2y0licvdq1fgjd/ilustracion1_pantalla13_estres.png?dl=0";
                nomarchivo = "ilustracion1_pantalla13_estres.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/a02yns45ppub12g/ilustracion1_pantalla14_estres.png?dl=0";
                nomarchivo = "ilustracion1_pantalla14_estres.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/1n8q6azvqhkicfb/ilustracion1_pantalla15_estres.png?dl=0";
                nomarchivo = "ilustracion1_pantalla15_estres.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/kcuglzpb17maerd/ilustracion1_pantalla16_estres.png?dl=0";
                nomarchivo = "ilustracion1_pantalla16_estres.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/o4vcwllvdfwfk8c/ilustracion1_pantalla17_estres.png?dl=0";
                nomarchivo = "ilustracion1_pantalla17_estres.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/so7c3x6reb01cbc/ilustracion1_pantalla18_estres.png?dl=0";
                nomarchivo = "ilustracion1_pantalla18_estres.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/b9c03mr6dhlcqip/ilustracion1_pantalla19_estres.png?dl=0";
                nomarchivo = "ilustracion1_pantalla19_estres.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/jlxoys4unnuk77j/ilustracion1_pantalla20_estres.png?dl=0";
                nomarchivo = "ilustracion1_pantalla20_estres.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/nxewlr2jtylvmpa/ilustracion1_pantalla21_estres.png?dl=0";
                nomarchivo = "ilustracion1_pantalla21_estres.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/2p75a0oel8g6xxe/ilustracion1_pantalla22_estres.png?dl=0";
                nomarchivo = "ilustracion1_pantalla22_estres.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/y9xa0senr847tke/ilustracion1_pantalla23_estres.png?dl=0";
                nomarchivo = "ilustracion1_pantalla23_estres.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/u755s5cg8ifo9mf/ilustracion1_pantalla24_estres.png?dl=0";
                nomarchivo = "ilustracion1_pantalla24_estres.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/d82zzofzwpz3i2c/ilustracion1_pantalla25_estres.png?dl=0";
                nomarchivo = "ilustracion1_pantalla25_estres.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/f5ksdpoddxn93fx/ilustracion1_pantalla26_estres.png?dl=0";
                nomarchivo = "ilustracion1_pantalla26_estres.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/c1vn4a4n7jy2t5n/ilustracion1_pantalla27_estres.png?dl=0";
                nomarchivo = "ilustracion1_pantalla27_estres.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/x1466vt8zz70wgx/ilustracion2_5_pantalla2_estres.png?dl=0";
                nomarchivo = "ilustracion2_5_pantalla2_estres.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/wxq8nb6808ijti4/ilustracion2_pantalla3_estres.png?dl=0";
                nomarchivo = "ilustracion2_pantalla3_estres.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/59hg05w5d8wjv1j/portada_estres.png?dl=0";
                nomarchivo = "portada_estres.zip";
                descargar(rutaarchivos, url, nomarchivo);
            }
            else
            {
                url = "https://dl.dropbox.com/s/5p9uxzrtgx3v4tm/boton_anterior_estres.png?dl=0";
                nomarchivo = "boton_anterior_estres.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/zimjo44oyfhb7mc/boton_siguiente_estres.png?dl=0";
                nomarchivo = "boton_siguiente_estres.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/5n1ft6ljh5zp8il/comenzar_estres.png?dl=0";
                nomarchivo = "comenzar_estres.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/ikmkpr0cgav31ex/ilustracion1_pantalal12_estres.png?dl=0";
                nomarchivo = "ilustracion1_pantalal12_estres.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/q0dhaauens9t07m/ilustracion1_pantalla1_estres.png?dl=0";
                nomarchivo = "ilustracion1_pantalla1_estres.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/rb64j9s0wwkozzz/ilustracion1_pantalla2_estres.png?dl=0";
                nomarchivo = "ilustracion1_pantalla2_estres.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/g0ruqugidme75yj/ilustracion1_pantalla3_estres.png?dl=0";
                nomarchivo = "ilustracion1_pantalla3_estres.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/86pruer739qu7pw/ilustracion1_pantalla6_estres.png?dl=0";
                nomarchivo = "ilustracion1_pantalla6_estres.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/gxjgk8jt8wobs0a/ilustracion1_pantalla7_estres.png?dl=0";
                nomarchivo = "ilustracion1_pantalla7_estres.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/um4zrpghoa0k7ql/ilustracion1_pantalla8_estres.png?dl=0";
                nomarchivo = "ilustracion1_pantalla8_estres.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/byuazs2ak89f19d/ilustracion1_pantalla9_estres.png?dl=0";
                nomarchivo = "ilustracion1_pantalla9_estres.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/61p77hb7c2iw06k/ilustracion1_pantalla10_estres.png?dl=0";
                nomarchivo = "ilustracion1_pantalla10_estres.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/8xgbnpr20iug39t/ilustracion1_pantalla11_estres.png?dl=0";
                nomarchivo = "ilustracion1_pantalla11_estres.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/o2y0licvdq1fgjd/ilustracion1_pantalla13_estres.png?dl=0";
                nomarchivo = "ilustracion1_pantalla13_estres.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/a02yns45ppub12g/ilustracion1_pantalla14_estres.png?dl=0";
                nomarchivo = "ilustracion1_pantalla14_estres.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/1n8q6azvqhkicfb/ilustracion1_pantalla15_estres.png?dl=0";
                nomarchivo = "ilustracion1_pantalla15_estres.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/kcuglzpb17maerd/ilustracion1_pantalla16_estres.png?dl=0";
                nomarchivo = "ilustracion1_pantalla16_estres.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/o4vcwllvdfwfk8c/ilustracion1_pantalla17_estres.png?dl=0";
                nomarchivo = "ilustracion1_pantalla17_estres.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/so7c3x6reb01cbc/ilustracion1_pantalla18_estres.png?dl=0";
                nomarchivo = "ilustracion1_pantalla18_estres.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/b9c03mr6dhlcqip/ilustracion1_pantalla19_estres.png?dl=0";
                nomarchivo = "ilustracion1_pantalla19_estres.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/jlxoys4unnuk77j/ilustracion1_pantalla20_estres.png?dl=0";
                nomarchivo = "ilustracion1_pantalla20_estres.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/nxewlr2jtylvmpa/ilustracion1_pantalla21_estres.png?dl=0";
                nomarchivo = "ilustracion1_pantalla21_estres.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/2p75a0oel8g6xxe/ilustracion1_pantalla22_estres.png?dl=0";
                nomarchivo = "ilustracion1_pantalla22_estres.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/y9xa0senr847tke/ilustracion1_pantalla23_estres.png?dl=0";
                nomarchivo = "ilustracion1_pantalla23_estres.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/u755s5cg8ifo9mf/ilustracion1_pantalla24_estres.png?dl=0";
                nomarchivo = "ilustracion1_pantalla24_estres.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/d82zzofzwpz3i2c/ilustracion1_pantalla25_estres.png?dl=0";
                nomarchivo = "ilustracion1_pantalla25_estres.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/f5ksdpoddxn93fx/ilustracion1_pantalla26_estres.png?dl=0";
                nomarchivo = "ilustracion1_pantalla26_estres.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/c1vn4a4n7jy2t5n/ilustracion1_pantalla27_estres.png?dl=0";
                nomarchivo = "ilustracion1_pantalla27_estres.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/x1466vt8zz70wgx/ilustracion2_5_pantalla2_estres.png?dl=0";
                nomarchivo = "ilustracion2_5_pantalla2_estres.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/wxq8nb6808ijti4/ilustracion2_pantalla3_estres.png?dl=0";
                nomarchivo = "ilustracion2_pantalla3_estres.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/59hg05w5d8wjv1j/portada_estres.png?dl=0";
                nomarchivo = "portada_estres.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/td76xa37eic1e8t/bocina.png?dl=0";
                nomarchivo = "bocina.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
            }
            return true;
        }
        if(numguia==6){
            rutaarchivos="/.estu@pp/guia6/";
            dir = Environment.getExternalStoragePublicDirectory(rutaarchivos);
            if (!dir.exists()) {
                url = "https://dl.dropbox.com/s/43m3ao7jadcqkxn/bienvenida_mapasmentales.png?dl=0";
                nomarchivo = "bienvenida_mapasmentales.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/mepitowt9z8m3ym/boton_anterior_mapasmentales.png?dl=0";
                nomarchivo = "boton_anterior_mapasmentales.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/5ctqfi06deili66/boton_siguiente_mapasmentales.png?dl=0";
                nomarchivo = "boton_siguiente_mapasmentales.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/sui0isza9dxsc4b/bubbl.png?dl=0";
                nomarchivo = "bubbl.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/g5nzlgrpdvaipve/comenzar_mapasmentales.png?dl=0";
                nomarchivo = "comenzar_mapasmentales.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/08uasekeyf4asev/freemind.png?dl=0";
                nomarchivo = "freemind.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/6kat1dfrqdsyswg/ilustracion1_pantalla1_mapasmentales.png?dl=0";
                nomarchivo = "ilustracion1_pantalla1_mapasmentales.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/fwlc903lc43tfts/ilustracion1_pantalla2_mapasmentales.png?dl=0";
                nomarchivo = "ilustracion1_pantalla2_mapasmentales.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/06s4x6qb7tjtq4g/ilustracion1_pantalla3_mapasmentales.png?dl=0";
                nomarchivo = "ilustracion1_pantalla3_mapasmentales.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/ghwatkdliuluqi7/ilustracion1_pantalla4_mapasmentales.png?dl=0";
                nomarchivo = "ilustracion1_pantalla4_mapasmentales.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/ejaypuugw3b93ms/ilustracion1_pantalla5_mapasmentales.png?dl=0";
                nomarchivo = "ilustracion1_pantalla5_mapasmentales.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/b58z9ryna7mlxdi/ilustracion1_pantalla6_mapasmentales.png?dl=0";
                nomarchivo = "ilustracion1_pantalla6_mapasmentales.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/wds07la4zp46mg9/ilustracion1_pantalla7_mapasmentales.png?dl=0";
                nomarchivo = "ilustracion1_pantalla7_mapasmentales.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/e96q1m0xxipktxi/ilustracion1_pantalla8_mapasmentales.png?dl=0";
                nomarchivo = "ilustracion1_pantalla8_mapasmentales.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/5uxy1f79d12ejdx/ilustracion1_pantalla9_mapasmentales.png?dl=0";
                nomarchivo = "ilustracion1_pantalla9_mapasmentales.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/2o7a4emxumi1jss/ilustracion1_pantalla10_mapasmentales.png?dl=0";
                nomarchivo = "ilustracion1_pantalla10_mapasmentales.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/dq7fktjgz050h8a/ilustracion1_pantalla11_mapasmentales.png?dl=0";
                nomarchivo = "ilustracion1_pantalla11_mapasmentales.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/yjuf2g2iyjoez6z/ilustracion1_pantalla12_mapasmentales.png?dl=0";
                nomarchivo = "ilustracion1_pantalla12_mapasmentales.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/b1f71nma4b95m70/ilustracion1_pantalla13_mapasmentales.png?dl=0";
                nomarchivo = "ilustracion1_pantalla13_mapasmentales.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/4w09e1h525c252j/ilustracion1_pantalla14_mapasmentales.png?dl=0";
                nomarchivo = "ilustracion1_pantalla14_mapasmentales.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/868mvtuj4lwushs/ilustracion1_pantalla15_mapasmentales.png?dl=0";
                nomarchivo = "ilustracion1_pantalla15_mapasmentales.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/32iefzdv16z795b/ilustracion1_pantalla16_mapasmentales.png?dl=0";
                nomarchivo = "ilustracion1_pantalla16_mapasmentales.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/i8g6cbeyg9nlxed/ilustracion1_pantalla17_mapasmentales.png?dl=0";
                nomarchivo = "ilustracion1_pantalla17_mapasmentales.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/k6olri6xcve9z4b/ilustracion1_pantalla19_mapasmentales.png?dl=0";
                nomarchivo = "ilustracion1_pantalla19_mapasmentales.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/j6exen2n83xru3g/ilustracion2_pantalla2_mapasmentales.png?dl=0";
                nomarchivo = "ilustracion2_pantalla2_mapasmentales.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/nd86894gbkb45lc/ilustracion2_pantalla9_mapasmentales.png?dl=0";
                nomarchivo = "ilustracion2_pantalla9_mapasmentales.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/hi7vnvmua4siys2/ilustracion2_pantalla10_mapasmentales.png?dl=0";
                nomarchivo = "ilustracion2_pantalla10_mapasmentales.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/49qhebopiebp17z/ilustracion3_pantalla9_mapasmentales.png?dl=0";
                nomarchivo = "ilustracion3_pantalla9_mapasmentales.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/3xov5srclnih52g/ilustracion3_pantalla10_mapasmentales.png?dl=0";
                nomarchivo = "ilustracion3_pantalla10_mapasmentales.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/wdqh9kchvae0160/ilustracion4_pantalla9_mapasmentales.png?dl=0";
                nomarchivo = "ilustracion4_pantalla9_mapasmentales.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/90bc8a89riv32az/ilustracion4_pantalla10_mapasmentales.png?dl=0";
                nomarchivo = "ilustracion4_pantalla10_mapasmentales.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/h5hdsl75g0mbpe7/mind42.png?dl=0";
                nomarchivo = "mind42.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/puqodrb044niufs/mindmapr.png?dl=0";
                nomarchivo = "mindmapr.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/kexcvzlv7ki7f35/mindmeister.png?dl=0";
                nomarchivo = "mindmapr.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/ahip54xjymyccn6/mindnode.png?dl=0";
                nomarchivo = "mindnode.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/ld0pefpcd6wh4em/mindomo.png?dl=0";
                nomarchivo = "mindomo.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/8oet80izqvwfb1q/my_thoughts_for_mac.png?dl=0";
                nomarchivo = "my_thoughts_for_mac.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/cwxoyhfm5s7c913/portada_mapasmentales.png?dl=0";
                nomarchivo = "portada_mapasmentales.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/1cdq0ytl2y8j6jk/simplemind.png?dl=0";
                nomarchivo = "simplemind.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/9knnjg6rialnw2m/spider_scribe.png?dl=0";
                nomarchivo = "spider_scribe.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/ff3i6k2b600ehdh/wise_mapping.png?dl=0";
                nomarchivo = "wise_mapping.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/fzc3hz1vaii6huf/xmind6.png?dl=0";
                nomarchivo = "xmind6.zip";
                descargar(rutaarchivos, url, nomarchivo);
            }
            else
            {
                url = "https://dl.dropbox.com/s/43m3ao7jadcqkxn/bienvenida_mapasmentales.png?dl=0";
                nomarchivo = "bienvenida_mapasmentales.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/mepitowt9z8m3ym/boton_anterior_mapasmentales.png?dl=0";
                nomarchivo = "boton_anterior_mapasmentales.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/5ctqfi06deili66/boton_siguiente_mapasmentales.png?dl=0";
                nomarchivo = "boton_siguiente_mapasmentales.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/sui0isza9dxsc4b/bubbl.png?dl=0";
                nomarchivo = "bubbl.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/g5nzlgrpdvaipve/comenzar_mapasmentales.png?dl=0";
                nomarchivo = "comenzar_mapasmentales.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/08uasekeyf4asev/freemind.png?dl=0";
                nomarchivo = "freemind.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/6kat1dfrqdsyswg/ilustracion1_pantalla1_mapasmentales.png?dl=0";
                nomarchivo = "ilustracion1_pantalla1_mapasmentales.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/fwlc903lc43tfts/ilustracion1_pantalla2_mapasmentales.png?dl=0";
                nomarchivo = "ilustracion1_pantalla2_mapasmentales.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/06s4x6qb7tjtq4g/ilustracion1_pantalla3_mapasmentales.png?dl=0";
                nomarchivo = "ilustracion1_pantalla3_mapasmentales.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/ghwatkdliuluqi7/ilustracion1_pantalla4_mapasmentales.png?dl=0";
                nomarchivo = "ilustracion1_pantalla4_mapasmentales.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/ejaypuugw3b93ms/ilustracion1_pantalla5_mapasmentales.png?dl=0";
                nomarchivo = "ilustracion1_pantalla5_mapasmentales.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/b58z9ryna7mlxdi/ilustracion1_pantalla6_mapasmentales.png?dl=0";
                nomarchivo = "ilustracion1_pantalla6_mapasmentales.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/wds07la4zp46mg9/ilustracion1_pantalla7_mapasmentales.png?dl=0";
                nomarchivo = "ilustracion1_pantalla7_mapasmentales.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/e96q1m0xxipktxi/ilustracion1_pantalla8_mapasmentales.png?dl=0";
                nomarchivo = "ilustracion1_pantalla8_mapasmentales.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/5uxy1f79d12ejdx/ilustracion1_pantalla9_mapasmentales.png?dl=0";
                nomarchivo = "ilustracion1_pantalla9_mapasmentales.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/2o7a4emxumi1jss/ilustracion1_pantalla10_mapasmentales.png?dl=0";
                nomarchivo = "ilustracion1_pantalla10_mapasmentales.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/dq7fktjgz050h8a/ilustracion1_pantalla11_mapasmentales.png?dl=0";
                nomarchivo = "ilustracion1_pantalla11_mapasmentales.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/yjuf2g2iyjoez6z/ilustracion1_pantalla12_mapasmentales.png?dl=0";
                nomarchivo = "ilustracion1_pantalla12_mapasmentales.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/b1f71nma4b95m70/ilustracion1_pantalla13_mapasmentales.png?dl=0";
                nomarchivo = "ilustracion1_pantalla13_mapasmentales.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/4w09e1h525c252j/ilustracion1_pantalla14_mapasmentales.png?dl=0";
                nomarchivo = "ilustracion1_pantalla14_mapasmentales.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/868mvtuj4lwushs/ilustracion1_pantalla15_mapasmentales.png?dl=0";
                nomarchivo = "ilustracion1_pantalla15_mapasmentales.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/32iefzdv16z795b/ilustracion1_pantalla16_mapasmentales.png?dl=0";
                nomarchivo = "ilustracion1_pantalla16_mapasmentales.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/i8g6cbeyg9nlxed/ilustracion1_pantalla17_mapasmentales.png?dl=0";
                nomarchivo = "ilustracion1_pantalla17_mapasmentales.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/k6olri6xcve9z4b/ilustracion1_pantalla19_mapasmentales.png?dl=0";
                nomarchivo = "ilustracion1_pantalla19_mapasmentales.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/j6exen2n83xru3g/ilustracion2_pantalla2_mapasmentales.png?dl=0";
                nomarchivo = "ilustracion2_pantalla2_mapasmentales.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/nd86894gbkb45lc/ilustracion2_pantalla9_mapasmentales.png?dl=0";
                nomarchivo = "ilustracion2_pantalla9_mapasmentales.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/hi7vnvmua4siys2/ilustracion2_pantalla10_mapasmentales.png?dl=0";
                nomarchivo = "ilustracion2_pantalla10_mapasmentales.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/49qhebopiebp17z/ilustracion3_pantalla9_mapasmentales.png?dl=0";
                nomarchivo = "ilustracion3_pantalla9_mapasmentales.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/3xov5srclnih52g/ilustracion3_pantalla10_mapasmentales.png?dl=0";
                nomarchivo = "ilustracion3_pantalla10_mapasmentales.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/wdqh9kchvae0160/ilustracion4_pantalla9_mapasmentales.png?dl=0";
                nomarchivo = "ilustracion4_pantalla9_mapasmentales.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/90bc8a89riv32az/ilustracion4_pantalla10_mapasmentales.png?dl=0";
                nomarchivo = "ilustracion4_pantalla10_mapasmentales.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/h5hdsl75g0mbpe7/mind42.png?dl=0";
                nomarchivo = "mind42.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/puqodrb044niufs/mindmapr.png?dl=0";
                nomarchivo = "mindmapr.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/kexcvzlv7ki7f35/mindmeister.png?dl=0";
                nomarchivo = "mindmapr.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/ahip54xjymyccn6/mindnode.png?dl=0";
                nomarchivo = "mindnode.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/ld0pefpcd6wh4em/mindomo.png?dl=0";
                nomarchivo = "mindomo.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/8oet80izqvwfb1q/my_thoughts_for_mac.png?dl=0";
                nomarchivo = "my_thoughts_for_mac.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/cwxoyhfm5s7c913/portada_mapasmentales.png?dl=0";
                nomarchivo = "portada_mapasmentales.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/1cdq0ytl2y8j6jk/simplemind.png?dl=0";
                nomarchivo = "simplemind.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/9knnjg6rialnw2m/spider_scribe.png?dl=0";
                nomarchivo = "spider_scribe.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/ff3i6k2b600ehdh/wise_mapping.png?dl=0";
                nomarchivo = "wise_mapping.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/fzc3hz1vaii6huf/xmind6.png?dl=0";
                nomarchivo = "xmind6.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
            }
            return true;
        }
        if(numguia==7){
            rutaarchivos="/.estu@pp/guia7/";
            dir = Environment.getExternalStoragePublicDirectory(rutaarchivos);
            if (!dir.exists()) {
                url = "https://dl.dropbox.com/s/qwr4kdqbomnrt8v/aldiko.png?dl=0";
                nomarchivo = "aldiko.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/5f33s0zjucvzasq/babbel.png?dl=0";
                nomarchivo = "babbel.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/0ov7t3mpu4eybph/bienvenida_importanciadelingles.png?dl=0";
                nomarchivo = "bienvenida_importanciadelingles.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/s4kwzimlmqk7y5n/binaurality.png?dl=0";
                nomarchivo = "binaurality.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/grxp2zleaih056g/boton_anterior_importanciadelingles.png?dl=0";
                nomarchivo = "boton_anterior_importanciadelingles.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/b8yuvmtl9zc8j8v/boton_salir_importanciadelingles.png?dl=0";
                nomarchivo = "boton_salir_importanciadelingles.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/sbe2pfwjfwfofim/boton_siguiente_importanciadelingles.png?dl=0";
                nomarchivo = "boton_siguiente_importanciadelingles.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/28gbleni5oha4l2/busuu.png?dl=0";
                nomarchivo = "busuu.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/qstz4ionkyacwax/chumkee.png?dl=0";
                nomarchivo = "chumkee.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/ylifv8xeq89sotv/comenzar_importanciadelingles.png?dl=0";
                nomarchivo = "comenzar_importanciadelingles.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/adk938k2amrsnxr/duolingo.png?dl=0";
                nomarchivo = "duolingo.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/3zy876yk9dcve8w/ibooks.png?dl=0";
                nomarchivo = "ibooks.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/wxn0f79t3pdtlij/ilustracion1_pantalla1_importanciadelingles.png?dl=0";
                nomarchivo = "ilustracion1_pantalla1_importanciadelingles.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/80hd30v3fqmf4x3/ilustracion1_pantalla2_importanciadelingles.png?dl=0";
                nomarchivo = "ilustracion1_pantalla2_importanciadelingles.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/xr9qed5l221zi4f/ilustracion1_pantalla3_importanciadelingles.png?dl=0";
                nomarchivo = "ilustracion1_pantalla3_importanciadelingles.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/yoz6zjzoiqktphf/ilustracion1_pantalla4_importanciadelingles.png?dl=0";
                nomarchivo = "ilustracion1_pantalla4_importanciadelingles.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/1g3okucmxf84yag/ilustracion2_pantalla2_importanciadelingles.png?dl=0";
                nomarchivo = "ilustracion2_pantalla2_importanciadelingles.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/pyrxh71sazo5md5/ilustracion2_pantalla3_importanciadelingles.png?dl=0";
                nomarchivo = "ilustracion2_pantalla3_importanciadelingles.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/9c14u51r8bpv9nq/ilustracion2_pantalla4_importanciadelingles.png?dl=0";
                nomarchivo = "ilustracion2_pantalla4_importanciadelingles.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/pzss2arkeaok2os/ilustracion3_pantalla2_importanciadelingles.png?dl=0";
                nomarchivo = "ilustracion3_pantalla2_importanciadelingles.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/fzvjb5pjxn3rkgp/ilustracion3_pantalla3_importanciadelingles.png?dl=0";
                nomarchivo = "ilustracion3_pantalla3_importanciadelingles.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/meuxkabvv2m4d68/ilustracion3_pantalla4_importanciadelingles.png?dl=0";
                nomarchivo = "ilustracion3_pantalla4_importanciadelingles.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/hwgzwsahv0qqmmq/ilustracion4_pantalla4_importanciadelingles.png?dl=0";
                nomarchivo = "ilustracion4_pantalla4_importanciadelingles.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/a6id6zxovrze44w/ilustracion5_pantalla4_importanciadelingles.png?dl=0";
                nomarchivo = "ilustracion5_pantalla4_importanciadelingles.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/ktm9xoe0hans02q/internet.png?dl=0";
                nomarchivo = "internet.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/mmkr3dxpc4ld29v/kindle.png?dl=0";
                nomarchivo = "kindle.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/9eertu7rkl5rst1/mindsnacks.png?dl=0";
                nomarchivo = "mindsnacks.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/tkl2wvs8rouv23k/mylingo.png?dl=0";
                nomarchivo = "mylingo.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/leqz0y3wmgx0o64/pdfreader.png?dl=0";
                nomarchivo = "pdfreader.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/dj6x4lblli91k2s/portada_importanciadelingles.png?dl=0";
                nomarchivo = "portada_importanciadelingles.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/120qyg9lsgzq06i/project.png?dl=0";
                nomarchivo = "project.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/6x6klv5sjrdktsj/speaking.png?dl=0";
                nomarchivo = "speaking.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/ptdtrmnxq1rh17k/texto1_pantalla5_importanciadelingles.png?dl=0";
                nomarchivo = "texto1_pantalla5_importanciadelingles.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/b08fo301375xo6y/texto2_pantalla5_importanciadelingles.png?dl=0";
                nomarchivo = "texto2_pantalla5_importanciadelingles.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/zdlk8ab0zqpmi2v/voxy.png?dl=0";
                nomarchivo = "voxy.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/wzv6lczttcez5ia/wilingua.png?dl=0";
                nomarchivo = "wilingua.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/anhyofunoq2ar9y/ficha%20aldiko.png?dl=0";
                nomarchivo = "ficha_aldiko.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/uukzmvg1keoqkdd/ficha%20babbel.png?dl=0";
                nomarchivo = "ficha_babbel.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/ylpcee0pyy5vn3c/ficha%20busuu.png?dl=0";
                nomarchivo = "ficha_bussu.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/8ziwfcemt408dpg/ficha%20chumkee.png?dl=0";
                nomarchivo = "ficha_chumkee.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/w5xlhwv2s9miwq6/ficha%20Duolingoi.png?dl=0";
                nomarchivo = "ficha_duolingo.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/kpf8p639sde1yr4/ficha%20ezpdf.png?dl=0";
                nomarchivo = "ficha_ezpdf.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/wfijryamqkd753x/ficha%20ibooks.png?dl=0";
                nomarchivo = "ficha_ibooks.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/5u804z6rqphnxq6/ficha%20internet%20archive.png?dl=0";
                nomarchivo = "ficha_ainternet_archive.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/8vl6klngyu5xx85/ficha%20kindle.png?dl=0";
                nomarchivo = "ficha_kindle.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/b1y9mmo62rpmttd/ficha%20Mindsnacks.png?dl=0";
                nomarchivo = "ficha_mindsnack.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/irnyq1niig7pq6j/ficha%20mylingo.png?dl=0";
                nomarchivo = "ficha_bmylingo.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/1mdn10jr68xyrzp/ficha%20project.png?dl=0";
                nomarchivo = "ficha_project.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/tojpszo1tmjlzhq/ficha%20speaking.png?dl=0";
                nomarchivo = "ficha_speaking.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/to2gs3xgjljcje2/ficha%20Voxy.png?dl=0";
                nomarchivo = "ficha_voxy.zip";
                descargar(rutaarchivos, url, nomarchivo);


            }
            else
            {
                url = "https://dl.dropbox.com/s/qwr4kdqbomnrt8v/aldiko.png?dl=0";
                nomarchivo = "aldiko.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/5f33s0zjucvzasq/babbel.png?dl=0";
                nomarchivo = "babbel.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/0ov7t3mpu4eybph/bienvenida_importanciadelingles.png?dl=0";
                nomarchivo = "bienvenida_importanciadelingles.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/s4kwzimlmqk7y5n/binaurality.png?dl=0";
                nomarchivo = "binaurality.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/grxp2zleaih056g/boton_anterior_importanciadelingles.png?dl=0";
                nomarchivo = "boton_anterior_importanciadelingles.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/b8yuvmtl9zc8j8v/boton_salir_importanciadelingles.png?dl=0";
                nomarchivo = "boton_salir_importanciadelingles.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/sbe2pfwjfwfofim/boton_siguiente_importanciadelingles.png?dl=0";
                nomarchivo = "boton_siguiente_importanciadelingles.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/28gbleni5oha4l2/busuu.png?dl=0";
                nomarchivo = "busuu.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/qstz4ionkyacwax/chumkee.png?dl=0";
                nomarchivo = "chumkee.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/ylifv8xeq89sotv/comenzar_importanciadelingles.png?dl=0";
                nomarchivo = "comenzar_importanciadelingles.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/adk938k2amrsnxr/duolingo.png?dl=0";
                nomarchivo = "duolingo.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/3zy876yk9dcve8w/ibooks.png?dl=0";
                nomarchivo = "ibooks.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/wxn0f79t3pdtlij/ilustracion1_pantalla1_importanciadelingles.png?dl=0";
                nomarchivo = "ilustracion1_pantalla1_importanciadelingles.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/80hd30v3fqmf4x3/ilustracion1_pantalla2_importanciadelingles.png?dl=0";
                nomarchivo = "ilustracion1_pantalla2_importanciadelingles.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/xr9qed5l221zi4f/ilustracion1_pantalla3_importanciadelingles.png?dl=0";
                nomarchivo = "ilustracion1_pantalla3_importanciadelingles.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/yoz6zjzoiqktphf/ilustracion1_pantalla4_importanciadelingles.png?dl=0";
                nomarchivo = "ilustracion1_pantalla4_importanciadelingles.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/1g3okucmxf84yag/ilustracion2_pantalla2_importanciadelingles.png?dl=0";
                nomarchivo = "ilustracion2_pantalla2_importanciadelingles.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/pyrxh71sazo5md5/ilustracion2_pantalla3_importanciadelingles.png?dl=0";
                nomarchivo = "ilustracion2_pantalla3_importanciadelingles.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/9c14u51r8bpv9nq/ilustracion2_pantalla4_importanciadelingles.png?dl=0";
                nomarchivo = "ilustracion2_pantalla4_importanciadelingles.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/pzss2arkeaok2os/ilustracion3_pantalla2_importanciadelingles.png?dl=0";
                nomarchivo = "ilustracion3_pantalla2_importanciadelingles.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/fzvjb5pjxn3rkgp/ilustracion3_pantalla3_importanciadelingles.png?dl=0";
                nomarchivo = "ilustracion3_pantalla3_importanciadelingles.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/meuxkabvv2m4d68/ilustracion3_pantalla4_importanciadelingles.png?dl=0";
                nomarchivo = "ilustracion3_pantalla4_importanciadelingles.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/hwgzwsahv0qqmmq/ilustracion4_pantalla4_importanciadelingles.png?dl=0";
                nomarchivo = "ilustracion4_pantalla4_importanciadelingles.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/a6id6zxovrze44w/ilustracion5_pantalla4_importanciadelingles.png?dl=0";
                nomarchivo = "ilustracion5_pantalla4_importanciadelingles.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/ktm9xoe0hans02q/internet.png?dl=0";
                nomarchivo = "internet.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/mmkr3dxpc4ld29v/kindle.png?dl=0";
                nomarchivo = "kindle.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/9eertu7rkl5rst1/mindsnacks.png?dl=0";
                nomarchivo = "mindsnacks.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/tkl2wvs8rouv23k/mylingo.png?dl=0";
                nomarchivo = "mylingo.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/leqz0y3wmgx0o64/pdfreader.png?dl=0";
                nomarchivo = "pdfreader.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/dj6x4lblli91k2s/portada_importanciadelingles.png?dl=0";
                nomarchivo = "portada_importanciadelingles.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/120qyg9lsgzq06i/project.png?dl=0";
                nomarchivo = "project.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/6x6klv5sjrdktsj/speaking.png?dl=0";
                nomarchivo = "speaking.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/ptdtrmnxq1rh17k/texto1_pantalla5_importanciadelingles.png?dl=0";
                nomarchivo = "texto1_pantalla5_importanciadelingles.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/b08fo301375xo6y/texto2_pantalla5_importanciadelingles.png?dl=0";
                nomarchivo = "texto2_pantalla5_importanciadelingles.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/zdlk8ab0zqpmi2v/voxy.png?dl=0";
                nomarchivo = "voxy.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/wzv6lczttcez5ia/wilingua.png?dl=0";
                nomarchivo = "wilingua.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/anhyofunoq2ar9y/ficha%20aldiko.png?dl=0";
                nomarchivo = "ficha_aldiko.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/uukzmvg1keoqkdd/ficha%20babbel.png?dl=0";
                nomarchivo = "ficha_babbel.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/ylpcee0pyy5vn3c/ficha%20busuu.png?dl=0";
                nomarchivo = "ficha_bussu.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/8ziwfcemt408dpg/ficha%20chumkee.png?dl=0";
                nomarchivo = "ficha_chumkee.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/w5xlhwv2s9miwq6/ficha%20Duolingoi.png?dl=0";
                nomarchivo = "ficha_duolingo.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/kpf8p639sde1yr4/ficha%20ezpdf.png?dl=0";
                nomarchivo = "ficha_ezpdf.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/wfijryamqkd753x/ficha%20ibooks.png?dl=0";
                nomarchivo = "ficha_ibooks.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/5u804z6rqphnxq6/ficha%20internet%20archive.png?dl=0";
                nomarchivo = "ficha_ainternet_archive.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/8vl6klngyu5xx85/ficha%20kindle.png?dl=0";
                nomarchivo = "ficha_kindle.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/b1y9mmo62rpmttd/ficha%20Mindsnacks.png?dl=0";
                nomarchivo = "ficha_mindsnack.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/irnyq1niig7pq6j/ficha%20mylingo.png?dl=0";
                nomarchivo = "ficha_bmylingo.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/1mdn10jr68xyrzp/ficha%20project.png?dl=0";
                nomarchivo = "ficha_project.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/tojpszo1tmjlzhq/ficha%20speaking.png?dl=0";
                nomarchivo = "ficha_speaking.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/to2gs3xgjljcje2/ficha%20Voxy.png?dl=0";
                nomarchivo = "ficha_voxy.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
            }
            return true;
        }
        if(numguia==8){
            rutaarchivos="/.estu@pp/guia8/";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos);
            if(!dir.exists()){
                url = "https://dl.dropbox.com/s/d0xws3twtqg99mi/anterior_datosnumericos.png?dl=0";
                nomarchivo = "anterior_datosnumericos.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/psy2exzbmcv97gt/audio1.mp3?dl=0";
                nomarchivo = "audio1.rar";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/0mfkhjkgxg3dy0u/audio2.mp3?dl=0";
                nomarchivo = "audio2.rar";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/aphplyveykeekb8/audio3.mp3?dl=0";
                nomarchivo = "audio3.rar";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/djiavpqoy96wdt9/audio4.mp3?dl=0";
                nomarchivo = "audio4.rar";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/2o86picioj7z0ms/audio5.mp3?dl=0";
                nomarchivo = "audio5.rar";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/xv9t32flekkq7rb/audio6.mp3?dl=0";
                nomarchivo = "audio6.rar";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/4x1qmcjhj6pkb11/audio7.mp3?dl=0";
                nomarchivo = "audio7.rar";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/d4tnfvla5hf7nxt/audio8.mp3?dl=0";
                nomarchivo = "audio8.rar";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/pmqd7s4qq2i9we4/audio9.mp3?dl=0";
                nomarchivo = "audio9.rar";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/1vjelammj81gzpo/audio10.mp3?dl=0";
                nomarchivo = "audio10.rar";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/ly1euzouyholvnh/audio11.mp3?dl=0";
                nomarchivo = "audio11.rar";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/laz8w9yrxjd2trs/audio12.mp3?dl=0";
                nomarchivo = "audio12.rar";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/1490hkarxe1ajgy/audio13.mp3?dl=0";
                nomarchivo = "audio13.rar";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/od5b55b1248jp02/autoevaluacion.png?dl=0";
                nomarchivo = "autoevaluacion.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/05172gl7sliegr5/estrella_bien_datosnumericos.png?dl=0";
                nomarchivo = "estrella_bien_datosnumericos.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/7s4aadkk39q6oub/estrella_mal_datosnumericos.jpg?dl=0";
                nomarchivo = "estrella_mal_datosnumericos.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/vry2h70op3x9kiz/grafica1_autoevaluacion_datosnumericos.png?dl=0";
                nomarchivo = "grafica1_autoevaluacion_datosnumericos.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/6gih6j73o3fy93m/grafica2_autoevaluacion_datosnumericos.png?dl=0";
                nomarchivo = "grafica2_autoevaluacion_datosnumericos.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/812ovio4zj5twug/graficas_de_pastel.png?dl=0";
                nomarchivo = "graficas_de_pastel.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/9y5os8cqzqg3wry/histogramas.png?dl=0";
                nomarchivo = "histogramas.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/483d3c1h0vu7dh1/ilustracion1_bien_pantalla28_datosnumericos.png?dl=0";
                nomarchivo = "ilustracion1_bien_pantalla28_datosnumericos.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/wfkui32acoau8iw/ilustracion1_mal_pantalla28_datosnumericos.png?dl=0";
                nomarchivo = "ilustracion1_mal_pantalla28_datosnumericos.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/qhu8lvlxejikygm/ilustracion1_pantalla1_datosnumericos.png?dl=0";
                nomarchivo = "ilustracion1_pantalla1_datosnumericos.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/rxpha9lhq253cl8/ilustracion1_pantalla3_datosnumericos.png?dl=0";
                nomarchivo = "ilustracion1_pantalla3_datosnumericos.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/c242k0rgy5z3b6f/ilustracion1_pantalla4_datosnumericos.png?dl=0";
                nomarchivo = "ilustracion1_pantalla4_datosnumericos.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/fkz4uimtgy4orey/ilustracion1_pantalla5_datosnumericos.png?dl=0";
                nomarchivo = "ilustracion1_pantalla5_datosnumericos.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/zdjksqamcgsr5sf/ilustracion1_pantalla6_datosnumericos.png?dl=0";
                nomarchivo = "ilustracion1_pantalla6_datosnumericos.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/9v7br9bxq4bloft/ilustracion1_pantalla7_datosnumericos.png?dl=0";
                nomarchivo = "ilustracion1_pantalla7_datosnumericos.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/borxu5darp6n6vt/ilustracion1_pantalla8_datosnumericos.png?dl=0";
                nomarchivo = "ilustracion1_pantalla8_datosnumericos.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/gddgxczxxg0l9bq/ilustracion1_pantalla9_datosnumericos.png?dl=0";
                nomarchivo = "ilustracion1_pantalla9_datosnumericos.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/tpk0kzll85ljv1p/ilustracion1_pantalla10_datosnumericos.png?dl=0";
                nomarchivo = "ilustracion1_pantalla10_datosnumericos.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/39zatjx9ck4mk6l/ilustracion1_pantalla11_datosnumericos.png?dl=0";
                nomarchivo = "ilustracion1_pantalla11_datosnumericos.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/7dheg5p029khzia/ilustracion1_pantalla12_datosnumericos.png?dl=0";
                nomarchivo = "ilustracion1_pantalla12_datosnumericos.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/zroihavq8gw6suv/ilustracion1_pantalla13_datosnumericos.png?dl=0";
                nomarchivo = "ilustracion1_pantalla13_datosnumericos.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/nbzhim8k5dlhxsp/ilustracion1_pantalla14_datosnumericos.png?dl=0";
                nomarchivo = "ilustracion1_pantalla14_datosnumericos.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/uej9ckw89tu2omo/ilustracion1_pantalla15_datosnumericos.png?dl=0";
                nomarchivo = "ilustracion1_pantalla15_datosnumericos.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/ot0b10x7vti1w79/ilustracion1_pantalla16_datosnumericos.png?dl=0";
                nomarchivo = "ilustracion1_pantalla16_datosnumericos.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/dhoway7xutmoeol/ilustracion1_pantalla17_datosnumericos.png?dl=0";
                nomarchivo = "ilustracion1_pantalla17_datosnumericos.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/3mkbqi25emccuzl/ilustracion1_pantalla18_datosnumericos.png?dl=0";
                nomarchivo = "ilustracion1_pantalla18_datosnumericos.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/pzp17vtnx5ehom9/ilustracion1_pantalla19_datosnumericos.png?dl=0";
                nomarchivo = "ilustracion1_pantalla19_datosnumericos.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/db11lmzyt5zq6lo/ilustracion1_pantalla20_datosnumericos.png?dl=0";
                nomarchivo = "ilustracion1_pantalla20_datosnumericos.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/1826pkzifo1w78f/ilustracion1_pantalla21_datosnumericos.png?dl=0";
                nomarchivo = "ilustracion1_pantalla21_datosnumericos.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/x3ydw0rw496rtu0/ilustracion1_pantalla22_datosnumericos.png?dl=0";
                nomarchivo = "ilustracion1_pantalla22_datosnumericos.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/tk0m07zpbjai6fa/ilustracion1_pantalla23_datosnumericos.png?dl=0";
                nomarchivo = "ilustracion1_pantalla23_datosnumericos.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/v5q9anu27cqjk3e/ilustracion1_pantalla24_datosnumericos.png?dl=0";
                nomarchivo = "ilustracion1_pantalla24_datosnumericos.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/sf2yiycc16ik2up/ilustracion1_pantalla25_datosnumericos.png?dl=0";
                nomarchivo = "ilustracion1_pantalla25_datosnumericos.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/qu72ie7uxi2ejv7/ilustracion1_pantalla26_datosnumericos.png?dl=0";
                nomarchivo = "ilustracion1_pantalla26_datosnumericos.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/7f95od2225wjafd/ilustracion1_pantalla27_datosnumericos.png?dl=0";
                nomarchivo = "ilustracion1_pantalla27_datosnumericos.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/i65xvhazs8jwp27/ilustracion2_pantalla3_datosnumericos.png?dl=0";
                nomarchivo = "ilustracion2_pantalla3_datosnumericos.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/10mrv1rm04bnqpc/ilustracion2_pantalla9_datosnumericos.png?dl=0";
                nomarchivo = "ilustracion2_pantalla9_datosnumericos.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/0iejsqrsxqagnf3/ilustracion2_pantalla13_datosnumericos.png?dl=0";
                nomarchivo = "ilustracion2_pantalla13_datosnumericos.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/37xjgmv0lyrpb9r/ilustracion2_pantalla28_datosnumericos.png?dl=0";
                nomarchivo = "ilustracion2_pantalla28_datosnumericos.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/n9gth933rnqoosa/ilustracion3_pantalla28_datosnumericos.png?dl=0";
                nomarchivo = "ilustracion3_pantalla28_datosnumericos.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/ek249f5y7uqa5ea/menu_datosnumericos.png?dl=0";
                nomarchivo = "menu_datosnumericos.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/0xhs74rf50402xp/porcentajes.png?dl=0";
                nomarchivo = "porcentajes.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/j6gnz3t9krdlis3/portada_autoevaluacion_datosnumericos.png?dl=0";
                nomarchivo = "portada_autoevaluacion_datosnumericos.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/0rwyp4tsv4hgqpd/portada_datosnumericos.png?dl=0";
                nomarchivo = "portada_datosnumericos.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/1fixvvfse3ubm65/salir_datosnumericos.png?dl=0";
                nomarchivo = "salir_datosnumericos.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/pc4az50qjx6sgp3/siguiente_datosnumericos.png?dl=0";
                nomarchivo = "siguiente_datosnumericos.zip";
                descargar(rutaarchivos, url, nomarchivo);
            }
            else{
                url = "https://dl.dropbox.com/s/d0xws3twtqg99mi/anterior_datosnumericos.png?dl=0";
                nomarchivo = "anterior_datosnumericos.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/psy2exzbmcv97gt/audio1.mp3?dl=0";
                nomarchivo = "audio1.rar";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/0mfkhjkgxg3dy0u/audio2.mp3?dl=0";
                nomarchivo = "audio2.rar";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/aphplyveykeekb8/audio3.mp3?dl=0";
                nomarchivo = "audio3.rar";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/djiavpqoy96wdt9/audio4.mp3?dl=0";
                nomarchivo = "audio4.rar";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/2o86picioj7z0ms/audio5.mp3?dl=0";
                nomarchivo = "audio5.rar";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/xv9t32flekkq7rb/audio6.mp3?dl=0";
                nomarchivo = "audio6.rar";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/4x1qmcjhj6pkb11/audio7.mp3?dl=0";
                nomarchivo = "audio7.rar";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/d4tnfvla5hf7nxt/audio8.mp3?dl=0";
                nomarchivo = "audio8.rar";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/pmqd7s4qq2i9we4/audio9.mp3?dl=0";
                nomarchivo = "audio9.rar";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/1vjelammj81gzpo/audio10.mp3?dl=0";
                nomarchivo = "audio10.rar";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/ly1euzouyholvnh/audio11.mp3?dl=0";
                nomarchivo = "audio11.rar";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/laz8w9yrxjd2trs/audio12.mp3?dl=0";
                nomarchivo = "audio12.rar";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/1490hkarxe1ajgy/audio13.mp3?dl=0";
                nomarchivo = "audio13.rar";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/od5b55b1248jp02/autoevaluacion.png?dl=0";
                nomarchivo = "autoevaluacion.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/05172gl7sliegr5/estrella_bien_datosnumericos.png?dl=0";
                nomarchivo = "estrella_bien_datosnumericos.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/7s4aadkk39q6oub/estrella_mal_datosnumericos.jpg?dl=0";
                nomarchivo = "estrella_mal_datosnumericos.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/vry2h70op3x9kiz/grafica1_autoevaluacion_datosnumericos.png?dl=0";
                nomarchivo = "grafica1_autoevaluacion_datosnumericos.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/6gih6j73o3fy93m/grafica2_autoevaluacion_datosnumericos.png?dl=0";
                nomarchivo = "grafica2_autoevaluacion_datosnumericos.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/812ovio4zj5twug/graficas_de_pastel.png?dl=0";
                nomarchivo = "graficas_de_pastel.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/9y5os8cqzqg3wry/histogramas.png?dl=0";
                nomarchivo = "histogramas.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/483d3c1h0vu7dh1/ilustracion1_bien_pantalla28_datosnumericos.png?dl=0";
                nomarchivo = "ilustracion1_bien_pantalla28_datosnumericos.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/wfkui32acoau8iw/ilustracion1_mal_pantalla28_datosnumericos.png?dl=0";
                nomarchivo = "ilustracion1_mal_pantalla28_datosnumericos.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/qhu8lvlxejikygm/ilustracion1_pantalla1_datosnumericos.png?dl=0";
                nomarchivo = "ilustracion1_pantalla1_datosnumericos.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/rxpha9lhq253cl8/ilustracion1_pantalla3_datosnumericos.png?dl=0";
                nomarchivo = "ilustracion1_pantalla3_datosnumericos.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/c242k0rgy5z3b6f/ilustracion1_pantalla4_datosnumericos.png?dl=0";
                nomarchivo = "ilustracion1_pantalla4_datosnumericos.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/fkz4uimtgy4orey/ilustracion1_pantalla5_datosnumericos.png?dl=0";
                nomarchivo = "ilustracion1_pantalla5_datosnumericos.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/zdjksqamcgsr5sf/ilustracion1_pantalla6_datosnumericos.png?dl=0";
                nomarchivo = "ilustracion1_pantalla6_datosnumericos.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/9v7br9bxq4bloft/ilustracion1_pantalla7_datosnumericos.png?dl=0";
                nomarchivo = "ilustracion1_pantalla7_datosnumericos.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/borxu5darp6n6vt/ilustracion1_pantalla8_datosnumericos.png?dl=0";
                nomarchivo = "ilustracion1_pantalla8_datosnumericos.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/gddgxczxxg0l9bq/ilustracion1_pantalla9_datosnumericos.png?dl=0";
                nomarchivo = "ilustracion1_pantalla9_datosnumericos.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/tpk0kzll85ljv1p/ilustracion1_pantalla10_datosnumericos.png?dl=0";
                nomarchivo = "ilustracion1_pantalla10_datosnumericos.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/39zatjx9ck4mk6l/ilustracion1_pantalla11_datosnumericos.png?dl=0";
                nomarchivo = "ilustracion1_pantalla11_datosnumericos.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/7dheg5p029khzia/ilustracion1_pantalla12_datosnumericos.png?dl=0";
                nomarchivo = "ilustracion1_pantalla12_datosnumericos.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/zroihavq8gw6suv/ilustracion1_pantalla13_datosnumericos.png?dl=0";
                nomarchivo = "ilustracion1_pantalla13_datosnumericos.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/nbzhim8k5dlhxsp/ilustracion1_pantalla14_datosnumericos.png?dl=0";
                nomarchivo = "ilustracion1_pantalla14_datosnumericos.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/uej9ckw89tu2omo/ilustracion1_pantalla15_datosnumericos.png?dl=0";
                nomarchivo = "ilustracion1_pantalla15_datosnumericos.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/ot0b10x7vti1w79/ilustracion1_pantalla16_datosnumericos.png?dl=0";
                nomarchivo = "ilustracion1_pantalla16_datosnumericos.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/dhoway7xutmoeol/ilustracion1_pantalla17_datosnumericos.png?dl=0";
                nomarchivo = "ilustracion1_pantalla17_datosnumericos.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/3mkbqi25emccuzl/ilustracion1_pantalla18_datosnumericos.png?dl=0";
                nomarchivo = "ilustracion1_pantalla18_datosnumericos.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/pzp17vtnx5ehom9/ilustracion1_pantalla19_datosnumericos.png?dl=0";
                nomarchivo = "ilustracion1_pantalla19_datosnumericos.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/db11lmzyt5zq6lo/ilustracion1_pantalla20_datosnumericos.png?dl=0";
                nomarchivo = "ilustracion1_pantalla20_datosnumericos.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/1826pkzifo1w78f/ilustracion1_pantalla21_datosnumericos.png?dl=0";
                nomarchivo = "ilustracion1_pantalla21_datosnumericos.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/x3ydw0rw496rtu0/ilustracion1_pantalla22_datosnumericos.png?dl=0";
                nomarchivo = "ilustracion1_pantalla22_datosnumericos.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/tk0m07zpbjai6fa/ilustracion1_pantalla23_datosnumericos.png?dl=0";
                nomarchivo = "ilustracion1_pantalla23_datosnumericos.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/v5q9anu27cqjk3e/ilustracion1_pantalla24_datosnumericos.png?dl=0";
                nomarchivo = "ilustracion1_pantalla24_datosnumericos.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/sf2yiycc16ik2up/ilustracion1_pantalla25_datosnumericos.png?dl=0";
                nomarchivo = "ilustracion1_pantalla25_datosnumericos.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/qu72ie7uxi2ejv7/ilustracion1_pantalla26_datosnumericos.png?dl=0";
                nomarchivo = "ilustracion1_pantalla26_datosnumericos.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/7f95od2225wjafd/ilustracion1_pantalla27_datosnumericos.png?dl=0";
                nomarchivo = "ilustracion1_pantalla27_datosnumericos.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/i65xvhazs8jwp27/ilustracion2_pantalla3_datosnumericos.png?dl=0";
                nomarchivo = "ilustracion2_pantalla3_datosnumericos.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/10mrv1rm04bnqpc/ilustracion2_pantalla9_datosnumericos.png?dl=0";
                nomarchivo = "ilustracion2_pantalla9_datosnumericos.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/0iejsqrsxqagnf3/ilustracion2_pantalla13_datosnumericos.png?dl=0";
                nomarchivo = "ilustracion2_pantalla13_datosnumericos.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/37xjgmv0lyrpb9r/ilustracion2_pantalla28_datosnumericos.png?dl=0";
                nomarchivo = "ilustracion2_pantalla28_datosnumericos.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/n9gth933rnqoosa/ilustracion3_pantalla28_datosnumericos.png?dl=0";
                nomarchivo = "ilustracion3_pantalla28_datosnumericos.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/ek249f5y7uqa5ea/menu_datosnumericos.png?dl=0";
                nomarchivo = "menu_datosnumericos.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/0xhs74rf50402xp/porcentajes.png?dl=0";
                nomarchivo = "porcentajes.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/j6gnz3t9krdlis3/portada_autoevaluacion_datosnumericos.png?dl=0";
                nomarchivo = "portada_autoevaluacion_datosnumericos.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/0rwyp4tsv4hgqpd/portada_datosnumericos.png?dl=0";
                nomarchivo = "portada_datosnumericos.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/1fixvvfse3ubm65/salir_datosnumericos.png?dl=0";
                nomarchivo = "salir_datosnumericos.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/pc4az50qjx6sgp3/siguiente_datosnumericos.png?dl=0";
                nomarchivo = "siguiente_datosnumericos.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
            }
            return true;
        }
        if(numguia==9){
            rutaarchivos="/.estu@pp/guia9/";
            dir = Environment.getExternalStoragePublicDirectory(rutaarchivos);
            if (!dir.exists()) {
                url = "https://dl.dropbox.com/s/fv07yxfxsw3efao/boton_anterior_capacidadesparaelaprendizaje.png?dl=0";
                nomarchivo = "boton_anterior_capacidadesparaelaprendizaje.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/45em6jitxku23dy/boton_siguiente_capacidadesparaelaprendizaje.png?dl=0";
                nomarchivo = "boton_siguiente_capacidadesparaelaprendizaje.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/3as93iblxfrunwj/comenzar_capacidadesparaelaprendizaje.png?dl=0";
                nomarchivo = "comenzar_capacidadesparaelaprendizaje.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/g1tpy9j15gpuulf/correcto_capacidadesparaelaprendizaje.png?dl=0";
                nomarchivo = "correcto_capacidadesparaelaprendizaje.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/qai1tulf4arrn89/ejercicio_pantalla14_capacidadesparaelaprendizaje.png?dl=0";
                nomarchivo = "ejercicio_pantalla14_capacidadesparaelaprendizaje.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/gw0rw85f4zr2b1y/ilustracion_pantalla1_capacidadesparaelaprendizaje.png?dl=0";
                nomarchivo = "ilustracion_pantalla1_capacidadesparaelaprendizaje.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/pyfr5ll8l90el85/ilustracion_pantalla2_capacidadesparaelaprendizaje.png?dl=0";
                nomarchivo = "ilustracion_pantalla2_capacidadesparaelaprendizaje.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/gm5073x9j5zhz7q/ilustracion_pantalla3_capacidadesparaelaprendizaje.png?dl=0";
                nomarchivo = "ilustracion_pantalla3_capacidadesparaelaprendizaje.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/mjnhjret9hore64/ilustracion_pantalla4_capacidadesparaelaprendizaje.png?dl=0";
                nomarchivo = "ilustracion_pantalla4_capacidadesparaelaprendizaje.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/wqhupu7uihmwckh/ilustracion_pantalla12_capacidadesparaelaprendizaje.png?dl=0";
                nomarchivo = "ilustracion_pantalla12_capacidadesparaelaprendizaje.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/fy6br7f2s7c7eg4/ilustracion_pantalla14_capacidadesparaelaprendizaje.png?dl=0";
                nomarchivo = "ilustracion_pantalla14_capacidadesparaelaprendizaje.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/3kanstlk1eyc5k5/incorrecto_capacidadesparaelaprendizaje.png?dl=0";
                nomarchivo = "incorrecto_capacidadesparaelaprendizaje.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/frnzv0j91pitt5x/linea1_pantalla14_capacidadesparaelaprendizaje.png?dl=0";
                nomarchivo = "linea1_pantalla14_capacidadesparaelaprendizaje.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/e1ls8w1dzo0xy1i/linea2_pantalla14_capacidadesparaelaprendizaje.png?dl=0";
                nomarchivo = "linea2_pantalla14_capacidadesparaelaprendizaje.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/gugmbd1irl92snu/linea3_pantalla14_capacidadesparaelaprendizaje.png?dl=0";
                nomarchivo = "linea3_pantalla14_capacidadesparaelaprendizaje.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/gens7fi8q2wegin/linea4_pantalla14_capacidadesparaelaprendizaje.png?dl=0";
                nomarchivo = "linea4_pantalla14_capacidadesparaelaprendizaje.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/wywwave2yexr5xu/linea5_pantalla14_capacidadesparaelaprendizaje.png?dl=0";
                nomarchivo = "linea5_pantalla14_capacidadesparaelaprendizaje.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/1b33n17qllwj5b5/linea6_pantalla14_capacidadesparaelaprendizaje.png?dl=0";
                nomarchivo = "linea6_pantalla14_capacidadesparaelaprendizaje.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/05z3i0s8u51eocw/linea7_pantalla14_capacidadesparaelaprendizaje.png?dl=0";
                nomarchivo = "linea7_pantalla14_capacidadesparaelaprendizaje.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/xflrc0blpmmcin6/linea8_pantalla14_capacidadesparaelaprendizaje.png?dl=0";
                nomarchivo = "linea8_pantalla14_capacidadesparaelaprendizaje.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/i5cujya3rlz1zr7/menu_pantalla2_capacidadesparaelaprendizaje.png?dl=0";
                nomarchivo = "menu_pantalla2_capacidadesparaelaprendizaje.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/4so6a6hjg6ze359/portada_capacidadesparaelaprendizaje.png?dl=0";
                nomarchivo = "portada_capacidadesparaelaprendizaje.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/wbc428v5mxd7y69/rectangulo1_capacidadesparaelaprendizaje.png?dl=0";
                nomarchivo = "rectangulo1_capacidadesparaelaprendizaje.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/crelq97152zi9aa/rectangulo2_capacidadesparaelaprendizaje.png?dl=0";
                nomarchivo = "rectangulo2_capacidadesparaelaprendizaje.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/rcimsydaw7lx3ab/rectangulo3_capacidadesparaelaprendizaje.png?dl=0";
                nomarchivo = "rectangulo3_capacidadesparaelaprendizaje.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/1uy1v32cnt51lsh/rectangulo4_capacidadesparaelaprendizaje.png?dl=0";
                nomarchivo = "rectangulo4_capacidadesparaelaprendizaje.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/4ihcl02d4c84vtp/rectangulo5_capacidadesparaelaprendizaje.png?dl=0";
                nomarchivo = "rectangulo5_capacidadesparaelaprendizaje.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/10aj1qjdgzdla0c/rectangulo6_capacidadesparaelaprendizaje.png?dl=0";
                nomarchivo = "rectangulo6_capacidadesparaelaprendizaje.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/qw5njzv08ehugwf/rectangulo7_capacidadesparaelaprendizaje.png?dl=0";
                nomarchivo = "rectangulo7_capacidadesparaelaprendizaje.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/x2wfg8ompobxdhb/texto_anterior_capacidadesparaelaprendizaje.png?dl=0";
                nomarchivo = "texto_anterior_capacidadesparaelaprendizaje.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/bhxkw13p4qmmthb/texto_pantalla2_capacidadesparaelaprendizaje.png?dl=0";
                nomarchivo = "texto_pantalla2_capacidadesparaelaprendizaje.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/feb10r5yrfwsms2/texto_pantalla3_capacidadesparaelaprendizaje.png?dl=0";
                nomarchivo = "texto_pantalla3_capacidadesparaelaprendizaje.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/g5yawmq1kfsc21j/texto_pantalla4_capacidadesparaelaprendizaje.png?dl=0";
                nomarchivo = "texto_pantalla4_capacidadesparaelaprendizaje.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/h7fjmdzftqo93my/texto_pantalla5_capacidadesparaelaprendizaje.png?dl=0";
                nomarchivo = "texto_pantalla5_capacidadesparaelaprendizaje.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/rwudf0nnpjc0zff/texto_pantalla6_capacidadesparaelaprendizaje.png?dl=0";
                nomarchivo = "texto_pantalla6_capacidadesparaelaprendizaje.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/9tfih0oyaymupan/texto_pantalla7_capacidadesparaelaprendizaje.png?dl=0";
                nomarchivo = "texto_pantalla7_capacidadesparaelaprendizaje.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/v818ca0gy2ecabo/texto_pantalla8_capacidadesparaelaprendizaje.png?dl=0";
                nomarchivo = "texto_pantalla8_capacidadesparaelaprendizaje.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/bi5burcaj0dx6rw/texto_pantalla9_capacidadesparaelaprendizaje.png?dl=0";
                nomarchivo = "texto_pantalla9_capacidadesparaelaprendizaje.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/ytplspd04y8bfg4/texto_pantalla10_capacidadesparaelaprendizaje.png?dl=0";
                nomarchivo = "texto_pantalla10_capacidadesparaelaprendizaje.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/dvi3h2u3spei6rw/texto_pantalla11_capacidadesparaelaprendizaje.png?dl=0";
                nomarchivo = "texto_pantalla11_capacidadesparaelaprendizaje.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/193asffdptsjzwy/texto_pantalla12_capacidadesparaelaprendizaje.png?dl=0";
                nomarchivo = "texto_pantalla12_capacidadesparaelaprendizaje.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/kz40hj6svgsb8lr/texto_pantalla13_capacidadesparaelaprendizaje.png?dl=0";
                nomarchivo = "texto_pantalla13_capacidadesparaelaprendizaje.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/mlc3d6vli4fuvo7/texto_pantalla14_capacidadesparaelaprendizaje.png?dl=0";
                nomarchivo = "texto_pantalla14_capacidadesparaelaprendizaje.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/5g62btnopbnsvht/texto_siguiente_capacidadesparaelaprendizaje.png?dl=0";
                nomarchivo = "texto_siguiente_capacidadesparaelaprendizaje.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/7y47wshxqzpfagh/texto_superior_capacidadesparaelaprendizaje.png?dl=0";
                nomarchivo = "texto_superior_capacidadesparaelaprendizaje.zip";
                descargar(rutaarchivos, url, nomarchivo);
            }
            else{
                url = "https://dl.dropbox.com/s/fv07yxfxsw3efao/boton_anterior_capacidadesparaelaprendizaje.png?dl=0";
                nomarchivo = "boton_anterior_capacidadesparaelaprendizaje.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/45em6jitxku23dy/boton_siguiente_capacidadesparaelaprendizaje.png?dl=0";
                nomarchivo = "boton_siguiente_capacidadesparaelaprendizaje.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/3as93iblxfrunwj/comenzar_capacidadesparaelaprendizaje.png?dl=0";
                nomarchivo = "comenzar_capacidadesparaelaprendizaje.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/g1tpy9j15gpuulf/correcto_capacidadesparaelaprendizaje.png?dl=0";
                nomarchivo = "correcto_capacidadesparaelaprendizaje.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/qai1tulf4arrn89/ejercicio_pantalla14_capacidadesparaelaprendizaje.png?dl=0";
                nomarchivo = "ejercicio_pantalla14_capacidadesparaelaprendizaje.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/gw0rw85f4zr2b1y/ilustracion_pantalla1_capacidadesparaelaprendizaje.png?dl=0";
                nomarchivo = "ilustracion_pantalla1_capacidadesparaelaprendizaje.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/pyfr5ll8l90el85/ilustracion_pantalla2_capacidadesparaelaprendizaje.png?dl=0";
                nomarchivo = "ilustracion_pantalla2_capacidadesparaelaprendizaje.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/gm5073x9j5zhz7q/ilustracion_pantalla3_capacidadesparaelaprendizaje.png?dl=0";
                nomarchivo = "ilustracion_pantalla3_capacidadesparaelaprendizaje.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/mjnhjret9hore64/ilustracion_pantalla4_capacidadesparaelaprendizaje.png?dl=0";
                nomarchivo = "ilustracion_pantalla4_capacidadesparaelaprendizaje.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/wqhupu7uihmwckh/ilustracion_pantalla12_capacidadesparaelaprendizaje.png?dl=0";
                nomarchivo = "ilustracion_pantalla12_capacidadesparaelaprendizaje.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/fy6br7f2s7c7eg4/ilustracion_pantalla14_capacidadesparaelaprendizaje.png?dl=0";
                nomarchivo = "ilustracion_pantalla14_capacidadesparaelaprendizaje.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/3kanstlk1eyc5k5/incorrecto_capacidadesparaelaprendizaje.png?dl=0";
                nomarchivo = "incorrecto_capacidadesparaelaprendizaje.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/frnzv0j91pitt5x/linea1_pantalla14_capacidadesparaelaprendizaje.png?dl=0";
                nomarchivo = "linea1_pantalla14_capacidadesparaelaprendizaje.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/e1ls8w1dzo0xy1i/linea2_pantalla14_capacidadesparaelaprendizaje.png?dl=0";
                nomarchivo = "linea2_pantalla14_capacidadesparaelaprendizaje.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/gugmbd1irl92snu/linea3_pantalla14_capacidadesparaelaprendizaje.png?dl=0";
                nomarchivo = "linea3_pantalla14_capacidadesparaelaprendizaje.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/gens7fi8q2wegin/linea4_pantalla14_capacidadesparaelaprendizaje.png?dl=0";
                nomarchivo = "linea4_pantalla14_capacidadesparaelaprendizaje.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/wywwave2yexr5xu/linea5_pantalla14_capacidadesparaelaprendizaje.png?dl=0";
                nomarchivo = "linea5_pantalla14_capacidadesparaelaprendizaje.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/1b33n17qllwj5b5/linea6_pantalla14_capacidadesparaelaprendizaje.png?dl=0";
                nomarchivo = "linea6_pantalla14_capacidadesparaelaprendizaje.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/05z3i0s8u51eocw/linea7_pantalla14_capacidadesparaelaprendizaje.png?dl=0";
                nomarchivo = "linea7_pantalla14_capacidadesparaelaprendizaje.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/xflrc0blpmmcin6/linea8_pantalla14_capacidadesparaelaprendizaje.png?dl=0";
                nomarchivo = "linea8_pantalla14_capacidadesparaelaprendizaje.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/i5cujya3rlz1zr7/menu_pantalla2_capacidadesparaelaprendizaje.png?dl=0";
                nomarchivo = "menu_pantalla2_capacidadesparaelaprendizaje.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/4so6a6hjg6ze359/portada_capacidadesparaelaprendizaje.png?dl=0";
                nomarchivo = "portada_capacidadesparaelaprendizaje.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/wbc428v5mxd7y69/rectangulo1_capacidadesparaelaprendizaje.png?dl=0";
                nomarchivo = "rectangulo1_capacidadesparaelaprendizaje.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/crelq97152zi9aa/rectangulo2_capacidadesparaelaprendizaje.png?dl=0";
                nomarchivo = "rectangulo2_capacidadesparaelaprendizaje.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/rcimsydaw7lx3ab/rectangulo3_capacidadesparaelaprendizaje.png?dl=0";
                nomarchivo = "rectangulo3_capacidadesparaelaprendizaje.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/1uy1v32cnt51lsh/rectangulo4_capacidadesparaelaprendizaje.png?dl=0";
                nomarchivo = "rectangulo4_capacidadesparaelaprendizaje.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/4ihcl02d4c84vtp/rectangulo5_capacidadesparaelaprendizaje.png?dl=0";
                nomarchivo = "rectangulo5_capacidadesparaelaprendizaje.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/10aj1qjdgzdla0c/rectangulo6_capacidadesparaelaprendizaje.png?dl=0";
                nomarchivo = "rectangulo6_capacidadesparaelaprendizaje.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/qw5njzv08ehugwf/rectangulo7_capacidadesparaelaprendizaje.png?dl=0";
                nomarchivo = "rectangulo7_capacidadesparaelaprendizaje.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/x2wfg8ompobxdhb/texto_anterior_capacidadesparaelaprendizaje.png?dl=0";
                nomarchivo = "texto_anterior_capacidadesparaelaprendizaje.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/bhxkw13p4qmmthb/texto_pantalla2_capacidadesparaelaprendizaje.png?dl=0";
                nomarchivo = "texto_pantalla2_capacidadesparaelaprendizaje.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/feb10r5yrfwsms2/texto_pantalla3_capacidadesparaelaprendizaje.png?dl=0";
                nomarchivo = "texto_pantalla3_capacidadesparaelaprendizaje.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/g5yawmq1kfsc21j/texto_pantalla4_capacidadesparaelaprendizaje.png?dl=0";
                nomarchivo = "texto_pantalla4_capacidadesparaelaprendizaje.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/h7fjmdzftqo93my/texto_pantalla5_capacidadesparaelaprendizaje.png?dl=0";
                nomarchivo = "texto_pantalla5_capacidadesparaelaprendizaje.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/rwudf0nnpjc0zff/texto_pantalla6_capacidadesparaelaprendizaje.png?dl=0";
                nomarchivo = "texto_pantalla6_capacidadesparaelaprendizaje.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/9tfih0oyaymupan/texto_pantalla7_capacidadesparaelaprendizaje.png?dl=0";
                nomarchivo = "texto_pantalla7_capacidadesparaelaprendizaje.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/v818ca0gy2ecabo/texto_pantalla8_capacidadesparaelaprendizaje.png?dl=0";
                nomarchivo = "texto_pantalla8_capacidadesparaelaprendizaje.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/bi5burcaj0dx6rw/texto_pantalla9_capacidadesparaelaprendizaje.png?dl=0";
                nomarchivo = "texto_pantalla9_capacidadesparaelaprendizaje.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/ytplspd04y8bfg4/texto_pantalla10_capacidadesparaelaprendizaje.png?dl=0";
                nomarchivo = "texto_pantalla10_capacidadesparaelaprendizaje.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/dvi3h2u3spei6rw/texto_pantalla11_capacidadesparaelaprendizaje.png?dl=0";
                nomarchivo = "texto_pantalla11_capacidadesparaelaprendizaje.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/193asffdptsjzwy/texto_pantalla12_capacidadesparaelaprendizaje.png?dl=0";
                nomarchivo = "texto_pantalla12_capacidadesparaelaprendizaje.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/kz40hj6svgsb8lr/texto_pantalla13_capacidadesparaelaprendizaje.png?dl=0";
                nomarchivo = "texto_pantalla13_capacidadesparaelaprendizaje.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/mlc3d6vli4fuvo7/texto_pantalla14_capacidadesparaelaprendizaje.png?dl=0";
                nomarchivo = "texto_pantalla14_capacidadesparaelaprendizaje.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/5g62btnopbnsvht/texto_siguiente_capacidadesparaelaprendizaje.png?dl=0";
                nomarchivo = "texto_siguiente_capacidadesparaelaprendizaje.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/7y47wshxqzpfagh/texto_superior_capacidadesparaelaprendizaje.png?dl=0";
                nomarchivo = "texto_superior_capacidadesparaelaprendizaje.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
            }
            return true;
        }
        if(numguia==10){
            rutaarchivos="/.estu@pp/guia10/";
            dir = Environment.getExternalStoragePublicDirectory(rutaarchivos);
            if(!dir.exists()){
                url = "https://dl.dropbox.com/s/v1ytb2ovt3sk7bf/anterior_habilidadesdelectura.png?dl=0";
                nomarchivo = "anterior_habilidadesdelectura.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/rg2xke9oxtj4nsb/bienvenido_habilidadesdelectura.png?dl=0";
                nomarchivo = "bienvenido_habilidadesdelectura.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/o5n0l93spl2loam/comienzo_habilidadesdelectura.png?dl=0";
                nomarchivo = "comienzo_habilidadesdelectura.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/78fq819n9y6a4is/encabezado_habilidadesdelectura.png?dl=0";
                nomarchivo = "encabezado_habilidadesdelectura.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/w1t3jjxt4rxtja3/ilustracion1_pantalla1_habilidadesdelectura.png?dl=0";
                nomarchivo = "ilustracion1_pantalla1_habilidadesdelectura.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/h6bxfcnof81l9v4/ilustracion1_pantalla2_7_habilidadesdelectura.png?dl=0";
                nomarchivo = "ilustracion1_pantalla2_7_habilidadesdelectura.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/jr0j51j3w9qv78s/ilustracion1_pantalla3_habilidadesdelectura.png?dl=0";
                nomarchivo = "ilustracion1_pantalla3_habilidadesdelectura.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/7t1hllo2spzyw3s/ilustracion1_pantalla4_habilidadesdelectura.png?dl=0";
                nomarchivo = "ilustracion1_pantalla4_habilidadesdelectura.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/cpeh6kddrc5mtbj/ilustracion1_pantalla5_habilidadesdelectura.png?dl=0";
                nomarchivo = "ilustracion1_pantalla5_habilidadesdelectura.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/cd35ryp055ohyv0/ilustracion1_pantalla6_habilidadesdelectura.png?dl=0";
                nomarchivo = "ilustracion1_pantalla6_habilidadesdelectura.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/vo7rqki7wymey9f/ilustracion1_pantalla8_habilidadesdelectura.png?dl=0";
                nomarchivo = "ilustracion1_pantalla8_habilidadesdelectura.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/uhpyrf2y7c3pdrk/ilustracion1_pantalla9_habilidadesdelectura.png?dl=0";
                nomarchivo = "ilustracion1_pantalla9_habilidadesdelectura.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/okemx5lgxm2nxzv/ilustracion1_pantalla10_habilidadesdelectura.png?dl=0";
                nomarchivo = "ilustracion1_pantalla10_habilidadesdelectura.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/d23wn72t66xw6yj/ilustracion1_pantalla11_habilidadesdelectura.png?dl=0";
                nomarchivo = "ilustracion1_pantalla11_habilidadesdelectura.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/8mwcg7d9hif6bym/ilustracion1_pantalla12_habilidadesdelectura.png?dl=0";
                nomarchivo = "ilustracion1_pantalla12_habilidadesdelectura.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/9c94sg8dwqbdevm/ilustracion1_pantalla13_habilidadesdelectura.png?dl=0";
                nomarchivo = "ilustracion1_pantalla13_habilidadesdelectura.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/9a8cwe5zv4zqx70/ilustracion1_pantalla14_habilidadesdelectura.png?dl=0";
                nomarchivo = "ilustracion1_pantalla14_habilidadesdelectura.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/ggr02vxfdcp0epm/ilustracion1_pantalla15_habilidadesdelectura.png?dl=0";
                nomarchivo = "ilustracion1_pantalla15_habilidadesdelectura.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/hfu4d8zs0iljp3f/ilustracion1_pantalla16_habilidadesdelectura.png?dl=0";
                nomarchivo = "ilustracion1_pantalla16_habilidadesdelectura.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/84stcxard2jicnd/ilustracion1_pantalla17_habilidadesdelectura.png?dl=0";
                nomarchivo = "ilustracion1_pantalla17_habilidadesdelectura.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/9exr5itntkm6l5v/ilustracion2_pantalla4_habilidadesdelectura.png?dl=0";
                nomarchivo = "ilustracion2_pantalla4_habilidadesdelectura.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/jera4hnai7e2dw0/ilustracion2_pantalla9_habilidadesdelectura.png?dl=0";
                nomarchivo = "ilustracion2_pantalla9_habilidadesdelectura.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/y8eaueptp59kmgd/siguiente_habilidadesdelectura.png?dl=0";
                nomarchivo = "siguiente_habilidadesdelectura.zip";
                descargar(rutaarchivos, url, nomarchivo);
            }
            else{
                url = "https://dl.dropbox.com/s/v1ytb2ovt3sk7bf/anterior_habilidadesdelectura.png?dl=0";
                nomarchivo = "anterior_habilidadesdelectura.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/rg2xke9oxtj4nsb/bienvenido_habilidadesdelectura.png?dl=0";
                nomarchivo = "bienvenido_habilidadesdelectura.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/o5n0l93spl2loam/comienzo_habilidadesdelectura.png?dl=0";
                nomarchivo = "comienzo_habilidadesdelectura.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/78fq819n9y6a4is/encabezado_habilidadesdelectura.png?dl=0";
                nomarchivo = "encabezado_habilidadesdelectura.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/w1t3jjxt4rxtja3/ilustracion1_pantalla1_habilidadesdelectura.png?dl=0";
                nomarchivo = "ilustracion1_pantalla1_habilidadesdelectura.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/h6bxfcnof81l9v4/ilustracion1_pantalla2_7_habilidadesdelectura.png?dl=0";
                nomarchivo = "ilustracion1_pantalla2_7_habilidadesdelectura.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/jr0j51j3w9qv78s/ilustracion1_pantalla3_habilidadesdelectura.png?dl=0";
                nomarchivo = "ilustracion1_pantalla3_habilidadesdelectura.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/7t1hllo2spzyw3s/ilustracion1_pantalla4_habilidadesdelectura.png?dl=0";
                nomarchivo = "ilustracion1_pantalla4_habilidadesdelectura.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/cpeh6kddrc5mtbj/ilustracion1_pantalla5_habilidadesdelectura.png?dl=0";
                nomarchivo = "ilustracion1_pantalla5_habilidadesdelectura.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/cd35ryp055ohyv0/ilustracion1_pantalla6_habilidadesdelectura.png?dl=0";
                nomarchivo = "ilustracion1_pantalla6_habilidadesdelectura.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/vo7rqki7wymey9f/ilustracion1_pantalla8_habilidadesdelectura.png?dl=0";
                nomarchivo = "ilustracion1_pantalla8_habilidadesdelectura.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/uhpyrf2y7c3pdrk/ilustracion1_pantalla9_habilidadesdelectura.png?dl=0";
                nomarchivo = "ilustracion1_pantalla9_habilidadesdelectura.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/okemx5lgxm2nxzv/ilustracion1_pantalla10_habilidadesdelectura.png?dl=0";
                nomarchivo = "ilustracion1_pantalla10_habilidadesdelectura.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/d23wn72t66xw6yj/ilustracion1_pantalla11_habilidadesdelectura.png?dl=0";
                nomarchivo = "ilustracion1_pantalla11_habilidadesdelectura.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/8mwcg7d9hif6bym/ilustracion1_pantalla12_habilidadesdelectura.png?dl=0";
                nomarchivo = "ilustracion1_pantalla12_habilidadesdelectura.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/9c94sg8dwqbdevm/ilustracion1_pantalla13_habilidadesdelectura.png?dl=0";
                nomarchivo = "ilustracion1_pantalla13_habilidadesdelectura.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/9a8cwe5zv4zqx70/ilustracion1_pantalla14_habilidadesdelectura.png?dl=0";
                nomarchivo = "ilustracion1_pantalla14_habilidadesdelectura.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/ggr02vxfdcp0epm/ilustracion1_pantalla15_habilidadesdelectura.png?dl=0";
                nomarchivo = "ilustracion1_pantalla15_habilidadesdelectura.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/hfu4d8zs0iljp3f/ilustracion1_pantalla16_habilidadesdelectura.png?dl=0";
                nomarchivo = "ilustracion1_pantalla16_habilidadesdelectura.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/84stcxard2jicnd/ilustracion1_pantalla17_habilidadesdelectura.png?dl=0";
                nomarchivo = "ilustracion1_pantalla17_habilidadesdelectura.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/9exr5itntkm6l5v/ilustracion2_pantalla4_habilidadesdelectura.png?dl=0";
                nomarchivo = "ilustracion2_pantalla4_habilidadesdelectura.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/jera4hnai7e2dw0/ilustracion2_pantalla9_habilidadesdelectura.png?dl=0";
                nomarchivo = "ilustracion2_pantalla9_habilidadesdelectura.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/y8eaueptp59kmgd/siguiente_habilidadesdelectura.png?dl=0";
                nomarchivo = "siguiente_habilidadesdelectura.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
            }
            return true;
        }
        if(numguia==11) {
            rutaarchivos="/.estu@pp/guia11/";
            dir = Environment.getExternalStoragePublicDirectory(rutaarchivos);
            if (!dir.exists()) {
                url = "https://dl.dropbox.com/s/51nlkg8w5n1q0sg/barra_negra_botones_forosvirtuales.png?dl=0";
                nomarchivo = "barra_negra_botones_forosvirtuales.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/cec97l94ychp1wf/bienvenida_forosvirtuales.png?dl=0";
                nomarchivo = "bienvenida_forosvirtuales.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/kpczn53cztvym1m/boton_anterior_forosvirtuales.png?dl=0";
                nomarchivo = "boton_anterior_forosvirtuales.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/ubgx7wkiixyv6yy/boton_salir_forosvirtuales.png?dl=0";
                nomarchivo = "boton_salir_forosvirtuales.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/ev5st26dh8dcv9c/boton_siguiente_forosvirtuales.png?dl=0";
                nomarchivo = "boton_siguiente_forosvirtuales.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/bqt6hzfh93xaggu/comenzar_forosvirtuales.png?dl=0";
                nomarchivo = "comenzar_forosvirtuales.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/6u2l7bru21z8x6w/ilustracion_pantalla4_forosvirtuales.png?dl=0";
                nomarchivo = "ilustracion_pantalla4_forosvirtuales.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/6u7scsbs5w5d02k/ilustracion_pantalla5_forosvirtuales.png?dl=0";
                nomarchivo = "ilustracion_pantalla5_forosvirtuales.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/8hcrig9d0thorn4/ilustracion_pantalla7_forosvirtuales.png?dl=0";
                nomarchivo = "ilustracion_pantalla7_forosvirtuales.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/40pay9f3zwsfelz/ilustracion_pantalla10_forosvirtuales.png?dl=0";
                nomarchivo = "ilustracion_pantalla10_forosvirtuales.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/zly7rxtalw0yl5c/menu_pantalla2_forosvirtuales.png?dl=0";
                nomarchivo = "menu_pantalla2_forosvirtuales.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/rwn4o8pxmgbkvxe/panal_superior_forosvirtuales.png?dl=0";
                nomarchivo = "panel_superior_forosvirtuales.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/8b01iy45lekzlyw/portada_forosvirtuales.png?dl=0";
                nomarchivo = "portada_forosvirtuales.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/go2rhp3wsn7i46w/texto_anterior_forosvirtuales.png?dl=0";
                nomarchivo = "texto_anterior_forosvirtuales.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/4a0iavgf3i5d537/texto_pantalla2_forosvirtuales.png?dl=0";
                nomarchivo = "texto_pantalla2_forosvirtuales.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/efgqmw78t86ba09/texto_pantalla3_forosvirtuales.png?dl=0";
                nomarchivo = "texto_pantalla3_forosvirtuales.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/au9aq7q1suamog9/texto_pantalla4_forosvirtuales.png?dl=0";
                nomarchivo = "texto_pantalla4_forosvirtuales.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/6zh1azigr43flak/texto_pantalla5_forosvirtuales.png?dl=0";
                nomarchivo = "texto_pantalla5_forosvirtuales.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/fi70lhgl0igfu94/texto_pantalla6_forosvirtuales.png?dl=0";
                nomarchivo = "texto_pantalla6_forosvirtuales.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/ic4jnm6bnmxjinz/texto_pantalla7_forosvirtuales.png?dl=0";
                nomarchivo = "texto_pantalla7_forosvirtuales.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/5ouzeywt3b4nodc/texto_pantalla8_forosvirtuales.png?dl=0";
                nomarchivo = "texto_pantalla8_forosvirtuales.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/o22mungvh2y3ri3/texto_pantalla9_forosvirtuales.png?dl=0";
                nomarchivo = "texto_pantalla9_forosvirtuales.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/rytcqnbw1t83onu/texto_pantalla10_forosvirtuales.png?dl=0";
                nomarchivo = "texto_pantalla10_forosvirtuales.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/p6alq3s8ku7lr21/texto_pantalla11_forosvirtuales.png?dl=0";
                nomarchivo = "texto_pantalla11_forosvirtuales.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/f4sfe4j35bsdhtk/texto_pantalla12_forosvirtuales.png?dl=0";
                nomarchivo = "texto_pantalla12_forosvirtuales.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/g53sjhxw9bofoj1/texto_pantalla13_forosvirtuales.png?dl=0";
                nomarchivo = "texto_pantalla13_forosvirtuales.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/boewxlnno8g0teb/texto_pantalla14_forosvirtuales.png?dl=0";
                nomarchivo = "texto_pantalla14_forosvirtuales.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/u93i5fd0lbqpjbl/texto_pantalla15_forosvirtuales.png?dl=0";
                nomarchivo = "texto_pantalla15_forosvirtuales.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/p68v6eick7gajra/texto_pantalla16_forosvirtuales.png?dl=0";
                nomarchivo = "texto_pantalla16_forosvirtuales.zip";
                descargar(rutaarchivos, url, nomarchivo);
                url = "https://dl.dropbox.com/s/wrpbkhtokxxmyp8/texto_siguiente_forosvirtuales.png?dl=0";
                nomarchivo = "texto_siguiente_forosvirtuales.zip";
                descargar(rutaarchivos, url, nomarchivo);
            }
            else{
                url = "https://dl.dropbox.com/s/51nlkg8w5n1q0sg/barra_negra_botones_forosvirtuales.png?dl=0";
                nomarchivo = "barra_negra_botones_forosvirtuales.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/cec97l94ychp1wf/bienvenida_forosvirtuales.png?dl=0";
                nomarchivo = "bienvenida_forosvirtuales.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/kpczn53cztvym1m/boton_anterior_forosvirtuales.png?dl=0";
                nomarchivo = "boton_anterior_forosvirtuales.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/ubgx7wkiixyv6yy/boton_salir_forosvirtuales.png?dl=0";
                nomarchivo = "boton_salir_forosvirtuales.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/ev5st26dh8dcv9c/boton_siguiente_forosvirtuales.png?dl=0";
                nomarchivo = "boton_siguiente_forosvirtuales.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/bqt6hzfh93xaggu/comenzar_forosvirtuales.png?dl=0";
                nomarchivo = "comenzar_forosvirtuales.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/6u2l7bru21z8x6w/ilustracion_pantalla4_forosvirtuales.png?dl=0";
                nomarchivo = "ilustracion_pantalla4_forosvirtuales.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/6u7scsbs5w5d02k/ilustracion_pantalla5_forosvirtuales.png?dl=0";
                nomarchivo = "ilustracion_pantalla5_forosvirtuales.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/8hcrig9d0thorn4/ilustracion_pantalla7_forosvirtuales.png?dl=0";
                nomarchivo = "ilustracion_pantalla7_forosvirtuales.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/40pay9f3zwsfelz/ilustracion_pantalla10_forosvirtuales.png?dl=0";
                nomarchivo = "ilustracion_pantalla10_forosvirtuales.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/zly7rxtalw0yl5c/menu_pantalla2_forosvirtuales.png?dl=0";
                nomarchivo = "menu_pantalla2_forosvirtuales.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/rwn4o8pxmgbkvxe/panal_superior_forosvirtuales.png?dl=0";
                nomarchivo = "panel_superior_forosvirtuales.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/8b01iy45lekzlyw/portada_forosvirtuales.png?dl=0";
                nomarchivo = "portada_forosvirtuales.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/go2rhp3wsn7i46w/texto_anterior_forosvirtuales.png?dl=0";
                nomarchivo = "texto_anterior_forosvirtuales.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/4a0iavgf3i5d537/texto_pantalla2_forosvirtuales.png?dl=0";
                nomarchivo = "texto_pantalla2_forosvirtuales.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/efgqmw78t86ba09/texto_pantalla3_forosvirtuales.png?dl=0";
                nomarchivo = "texto_pantalla3_forosvirtuales.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/au9aq7q1suamog9/texto_pantalla4_forosvirtuales.png?dl=0";
                nomarchivo = "texto_pantalla4_forosvirtuales.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/6zh1azigr43flak/texto_pantalla5_forosvirtuales.png?dl=0";
                nomarchivo = "texto_pantalla5_forosvirtuales.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/fi70lhgl0igfu94/texto_pantalla6_forosvirtuales.png?dl=0";
                nomarchivo = "texto_pantalla6_forosvirtuales.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/ic4jnm6bnmxjinz/texto_pantalla7_forosvirtuales.png?dl=0";
                nomarchivo = "texto_pantalla7_forosvirtuales.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/5ouzeywt3b4nodc/texto_pantalla8_forosvirtuales.png?dl=0";
                nomarchivo = "texto_pantalla8_forosvirtuales.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/o22mungvh2y3ri3/texto_pantalla9_forosvirtuales.png?dl=0";
                nomarchivo = "texto_pantalla9_forosvirtuales.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/rytcqnbw1t83onu/texto_pantalla10_forosvirtuales.png?dl=0";
                nomarchivo = "texto_pantalla10_forosvirtuales.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/p6alq3s8ku7lr21/texto_pantalla11_forosvirtuales.png?dl=0";
                nomarchivo = "texto_pantalla11_forosvirtuales.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/f4sfe4j35bsdhtk/texto_pantalla12_forosvirtuales.png?dl=0";
                nomarchivo = "texto_pantalla12_forosvirtuales.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/g53sjhxw9bofoj1/texto_pantalla13_forosvirtuales.png?dl=0";
                nomarchivo = "texto_pantalla13_forosvirtuales.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/boewxlnno8g0teb/texto_pantalla14_forosvirtuales.png?dl=0";
                nomarchivo = "texto_pantalla14_forosvirtuales.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/u93i5fd0lbqpjbl/texto_pantalla15_forosvirtuales.png?dl=0";
                nomarchivo = "texto_pantalla15_forosvirtuales.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/p68v6eick7gajra/texto_pantalla16_forosvirtuales.png?dl=0";
                nomarchivo = "texto_pantalla16_forosvirtuales.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
                url = "https://dl.dropbox.com/s/wrpbkhtokxxmyp8/texto_siguiente_forosvirtuales.png?dl=0";
                nomarchivo = "texto_siguiente_forosvirtuales.zip";
                dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
                if (!dir.exists()) {
                    descargar(rutaarchivos, url, nomarchivo);
                }
            }
            return true;
        }
        return false;
    }

    public int validaArchivos(){
        String nomarchivo;
        String rutaarchivos;
        int ar=0;
        File dir;
        if(numguia==1){
            rutaarchivos="/.estu@pp/guia1/";
            nomarchivo = "bienvenida_frances.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "boton_anterior_frances.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "boton_salir_frances.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "boton_siguiente_frances.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "comenzar_frances.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion1_pantalla1_14_frances.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion1_pantalla2_3_frances.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion1_pantalla3_frances.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists())
            {
                ar++;
            }
            nomarchivo = "ilustracion1_pantalla4_frances.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion1_pantalla5_frances.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion1_pantalla6_frances.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion1_pantalla7_frances.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion1_pantalla8_frances.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion1_pantalla9_frances.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion1_pantalla11_frances.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion1_pantalla12_frances.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion1_pantalla13_frances.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion1_pantalla15_frances.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion1_pantalla16_frances.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion1_pantalla18_frances.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion1_pantalla19_frances.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion1_pantalla20_frances.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion1_pantalla21_22_frances.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion1_pantalla22_frances.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion1_pantalla23_frances.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion2_pantalla6_frances.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion2_pantalla22_frances.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion3_pantalla22_frances.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion4_pantalla22_frances.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion5_pantalla22_frances.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion6_pantalla22_frances.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion7_pantalla22_frances.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion8_pantalla22_frances.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion9_pantalla22_frances.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion10_pantalla22_frances.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion11_pantalla22_frances.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion12_pantalla22_frances.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "portada_frances.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()) {
                ar++;
            }
            nomarchivo = "ilustracion1_pantalla14_frances.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists())
            {
                ar++;
            }
            nomarchivo = "ilustracion1_pantalla17_frances.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists())
            {
                ar++;
            }
            nomarchivo = "ilustracion1_pantalla19_frances.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists())
            {
                ar++;
            }

        }
        if(numguia==3){
            rutaarchivos="/.estu@pp/guia3/";
            nomarchivo = "boton_anterior_administraciondeltiempo.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "boton_salir_administraciondeltiempo.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "boton_siguiente_administraciondeltiempo.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "comenzar_administraciondeltiempo.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion1_pantalla1_administraciondeltiempo.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion1_pantalla2_administraciondeltiempo.zip";
           dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion1_pantalla3_administraciondeltiempo.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion1_pantalla4_administraciondeltiempo.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion1_pantalla5_administraciondeltiempo.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion1_pantalla6_administraciondeltiempo.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion1_pantalla7_administraciondeltiempo.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion1_pantalla8_administraciondeltiempo.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion1_pantalla9_administraciondeltiempo.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion1_pantalla10_administraciondeltiempo.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion1_pantalla11_administraciondeltiempo.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion1_pantalla12_administraciondeltiempo.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion1_pantalla13_administraciondeltiempo.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion1_pantalla14_administraciondeltiempo.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion1_pantalla15_administraciondeltiempo.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion1_pantalla16_administraciondeltiempo.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion1_pantalla17_administraciondeltiempo.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion1_pantalla18_administraciondeltiempo.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion1_pantalla19_administraciondeltiempo.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion1_pantalla20_administraciondeltiempo.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion1_pantalla21_administraciondeltiempo.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion1_pantalla22_administraciondeltiempo.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion2_pantalla2_administraciondeltiempo.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion2_pantalla3_administraciondeltiempo.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion2_pantalla4_administraciondeltiempo.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion2_pantalla5_administraciondeltiempo.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion2_pantalla6_administraciondeltiempo.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion2_pantalla7_administraciondeltiempo.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion2_pantalla8_administraciondeltiempo.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion2_pantalla11_administraciondeltiempo.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion2_pantalla12_administraciondeltiempo.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion2_pantalla13_administraciondeltiempo.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion2_pantalla14_administraciondeltiempo.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion2_pantalla15_administraciondeltiempo.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion2_pantalla16_administraciondeltiempo.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion2_pantalla17_administraciondeltiempo.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion2_pantalla18_administraciondeltiempo.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion2_pantalla21_administraciondeltiempo.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion3_pantalla5_administraciondeltiempo.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion4_pantalla5_administraciondeltiempo.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "portada_administraciondeltiempo.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
        }
        if(numguia==5){
            rutaarchivos="/.estu@pp/guia5/";
            nomarchivo = "boton_anterior_estres.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "boton_siguiente_estres.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "comenzar_estres.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion1_pantalal12_estres.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion1_pantalla1_estres.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion1_pantalla2_estres.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion1_pantalla3_estres.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion1_pantalla6_estres.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion1_pantalla7_estres.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion1_pantalla8_estres.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion1_pantalla9_estres.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion1_pantalla10_estres.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion1_pantalla11_estres.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion1_pantalla13_estres.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion1_pantalla14_estres.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion1_pantalla15_estres.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion1_pantalla16_estres.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion1_pantalla17_estres.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion1_pantalla18_estres.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion1_pantalla19_estres.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion1_pantalla20_estres.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion1_pantalla21_estres.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion1_pantalla22_estres.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion1_pantalla23_estres.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion1_pantalla24_estres.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion1_pantalla25_estres.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion1_pantalla26_estres.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion1_pantalla27_estres.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion2_5_pantalla2_estres.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion2_pantalla3_estres.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "portada_estres.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
        }
        if(numguia==6){
            rutaarchivos="/.estu@pp/guia6/";
            nomarchivo = "bienvenida_mapasmentales.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "boton_anterior_mapasmentales.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "boton_siguiente_mapasmentales.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "bubbl.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "comenzar_mapasmentales.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "freemind.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion1_pantalla1_mapasmentales.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion1_pantalla2_mapasmentales.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion1_pantalla3_mapasmentales.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion1_pantalla4_mapasmentales.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion1_pantalla5_mapasmentales.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion1_pantalla6_mapasmentales.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion1_pantalla7_mapasmentales.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion1_pantalla8_mapasmentales.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion1_pantalla9_mapasmentales.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion1_pantalla10_mapasmentales.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion1_pantalla11_mapasmentales.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion1_pantalla12_mapasmentales.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion1_pantalla13_mapasmentales.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion1_pantalla14_mapasmentales.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion1_pantalla15_mapasmentales.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion1_pantalla16_mapasmentales.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion1_pantalla17_mapasmentales.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion1_pantalla19_mapasmentales.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion2_pantalla2_mapasmentales.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion2_pantalla9_mapasmentales.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion2_pantalla10_mapasmentales.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion3_pantalla9_mapasmentales.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion3_pantalla10_mapasmentales.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion4_pantalla9_mapasmentales.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion4_pantalla10_mapasmentales.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "mind42.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "mindmapr.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "mindmapr.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "mindnode.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "mindomo.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "my_thoughts_for_mac.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "portada_mapasmentales.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "simplemind.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "spider_scribe.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "wise_mapping.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "xmind6.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
        }
        if(numguia==7){
            rutaarchivos="/.estu@pp/guia7/";
            nomarchivo = "aldiko.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "babbel.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "bienvenida_importanciadelingles.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "binaurality.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "boton_anterior_importanciadelingles.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "boton_salir_importanciadelingles.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "boton_siguiente_importanciadelingles.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "busuu.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "chumkee.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "comenzar_importanciadelingles.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "duolingo.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ibooks.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion1_pantalla1_importanciadelingles.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion1_pantalla2_importanciadelingles.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion1_pantalla3_importanciadelingles.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion1_pantalla4_importanciadelingles.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion2_pantalla2_importanciadelingles.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion2_pantalla3_importanciadelingles.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion2_pantalla4_importanciadelingles.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion3_pantalla2_importanciadelingles.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion3_pantalla3_importanciadelingles.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion3_pantalla4_importanciadelingles.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion4_pantalla4_importanciadelingles.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion5_pantalla4_importanciadelingles.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "internet.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "kindle.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "mindsnacks.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "mylingo.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "pdfreader.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "portada_importanciadelingles.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "project.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "speaking.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "texto1_pantalla5_importanciadelingles.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "texto2_pantalla5_importanciadelingles.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "voxy.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "wilingua.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ficha_aldiko.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if (dir.exists()) {
                ar++;
            }

            nomarchivo = "ficha_babbel.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if (dir.exists()) {
                ar++;
            }

            nomarchivo = "ficha_bussu.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if (dir.exists()) {
                ar++;
            }

            nomarchivo = "ficha_chumkee.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if (dir.exists()) {
                ar++;
            }

            nomarchivo = "ficha_duolingo.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if (dir.exists()) {
                ar++;
            }

            nomarchivo = "ficha_ezpdf.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if (dir.exists()) {
                ar++;
            }

            nomarchivo = "ficha_ibooks.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if (dir.exists()) {
                ar++;
            }

            nomarchivo = "ficha_ainternet_archive.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if (dir.exists()) {
                ar++;
            }

            nomarchivo = "ficha_kindle.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if (dir.exists()) {
                ar++;
            }

            nomarchivo = "ficha_mindsnack.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if (dir.exists()) {
                ar++;
            }

            nomarchivo = "ficha_bmylingo.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if (dir.exists()) {
                ar++;
            }

            nomarchivo = "ficha_project.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if (dir.exists()) {
                ar++;
            }

            nomarchivo = "ficha_speaking.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if (dir.exists()) {
                ar++;
            }

            nomarchivo = "ficha_voxy.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if (dir.exists()) {
                ar++;
            }

        }
        if(numguia==8){
            rutaarchivos="/.estu@pp/guia8/";
            nomarchivo = "anterior_datosnumericos.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "audio1.rar";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "audio2.rar";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "audio3.rar";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "audio4.rar";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "audio5.rar";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "audio6.rar";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "audio7.rar";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "audio8.rar";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "audio9.rar";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "audio10.rar";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "audio11.rar";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "audio12.rar";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "audio13.rar";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "autoevaluacion.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "estrella_bien_datosnumericos.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "estrella_mal_datosnumericos.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "grafica1_autoevaluacion_datosnumericos.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "grafica2_autoevaluacion_datosnumericos.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "graficas_de_pastel.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "histogramas.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion1_bien_pantalla28_datosnumericos.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion1_mal_pantalla28_datosnumericos.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion1_pantalla1_datosnumericos.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion1_pantalla3_datosnumericos.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion1_pantalla4_datosnumericos.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion1_pantalla5_datosnumericos.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion1_pantalla6_datosnumericos.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion1_pantalla7_datosnumericos.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion1_pantalla8_datosnumericos.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion1_pantalla9_datosnumericos.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion1_pantalla10_datosnumericos.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion1_pantalla11_datosnumericos.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion1_pantalla12_datosnumericos.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion1_pantalla13_datosnumericos.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion1_pantalla14_datosnumericos.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion1_pantalla15_datosnumericos.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion1_pantalla16_datosnumericos.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion1_pantalla17_datosnumericos.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion1_pantalla18_datosnumericos.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion1_pantalla19_datosnumericos.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion1_pantalla20_datosnumericos.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion1_pantalla21_datosnumericos.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion1_pantalla22_datosnumericos.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion1_pantalla23_datosnumericos.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion1_pantalla24_datosnumericos.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion1_pantalla25_datosnumericos.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion1_pantalla26_datosnumericos.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion1_pantalla27_datosnumericos.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion2_pantalla3_datosnumericos.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion2_pantalla9_datosnumericos.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion2_pantalla13_datosnumericos.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion2_pantalla28_datosnumericos.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion3_pantalla28_datosnumericos.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "menu_datosnumericos.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "porcentajes.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "portada_autoevaluacion_datosnumericos.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "portada_datosnumericos.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "salir_datosnumericos.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "siguiente_datosnumericos.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
        }
        if(numguia==9) {
            rutaarchivos = "/.estu@pp/guia9/";
            nomarchivo = "boton_anterior_capacidadesparaelaprendizaje.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "boton_siguiente_capacidadesparaelaprendizaje.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "comenzar_capacidadesparaelaprendizaje.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "correcto_capacidadesparaelaprendizaje.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ejercicio_pantalla14_capacidadesparaelaprendizaje.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion_pantalla1_capacidadesparaelaprendizaje.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion_pantalla2_capacidadesparaelaprendizaje.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion_pantalla3_capacidadesparaelaprendizaje.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion_pantalla4_capacidadesparaelaprendizaje.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion_pantalla12_capacidadesparaelaprendizaje.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion_pantalla14_capacidadesparaelaprendizaje.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "incorrecto_capacidadesparaelaprendizaje.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "linea1_pantalla14_capacidadesparaelaprendizaje.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "linea2_pantalla14_capacidadesparaelaprendizaje.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "linea3_pantalla14_capacidadesparaelaprendizaje.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "linea4_pantalla14_capacidadesparaelaprendizaje.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "linea5_pantalla14_capacidadesparaelaprendizaje.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "linea6_pantalla14_capacidadesparaelaprendizaje.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "linea7_pantalla14_capacidadesparaelaprendizaje.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "linea8_pantalla14_capacidadesparaelaprendizaje.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "menu_pantalla2_capacidadesparaelaprendizaje.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "portada_capacidadesparaelaprendizaje.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "rectangulo1_capacidadesparaelaprendizaje.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "rectangulo2_capacidadesparaelaprendizaje.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "rectangulo3_capacidadesparaelaprendizaje.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "rectangulo4_capacidadesparaelaprendizaje.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "rectangulo5_capacidadesparaelaprendizaje.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "rectangulo6_capacidadesparaelaprendizaje.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "rectangulo7_capacidadesparaelaprendizaje.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "texto_anterior_capacidadesparaelaprendizaje.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "texto_pantalla2_capacidadesparaelaprendizaje.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "texto_pantalla3_capacidadesparaelaprendizaje.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "texto_pantalla4_capacidadesparaelaprendizaje.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "texto_pantalla5_capacidadesparaelaprendizaje.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "texto_pantalla6_capacidadesparaelaprendizaje.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "texto_pantalla7_capacidadesparaelaprendizaje.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "texto_pantalla8_capacidadesparaelaprendizaje.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "texto_pantalla9_capacidadesparaelaprendizaje.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "texto_pantalla10_capacidadesparaelaprendizaje.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "texto_pantalla11_capacidadesparaelaprendizaje.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "texto_pantalla12_capacidadesparaelaprendizaje.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "texto_pantalla13_capacidadesparaelaprendizaje.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "texto_pantalla14_capacidadesparaelaprendizaje.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "texto_siguiente_capacidadesparaelaprendizaje.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "texto_superior_capacidadesparaelaprendizaje.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
        }
        if(numguia==10){
            rutaarchivos="/.estu@pp/guia10/";
            nomarchivo = "anterior_habilidadesdelectura.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "bienvenido_habilidadesdelectura.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "comienzo_habilidadesdelectura.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "encabezado_habilidadesdelectura.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion1_pantalla1_habilidadesdelectura.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion1_pantalla2_7_habilidadesdelectura.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion1_pantalla3_habilidadesdelectura.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion1_pantalla4_habilidadesdelectura.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion1_pantalla5_habilidadesdelectura.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion1_pantalla6_habilidadesdelectura.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion1_pantalla8_habilidadesdelectura.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion1_pantalla9_habilidadesdelectura.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion1_pantalla10_habilidadesdelectura.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion1_pantalla11_habilidadesdelectura.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion1_pantalla12_habilidadesdelectura.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion1_pantalla13_habilidadesdelectura.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion1_pantalla14_habilidadesdelectura.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion1_pantalla15_habilidadesdelectura.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion1_pantalla16_habilidadesdelectura.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion1_pantalla17_habilidadesdelectura.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion2_pantalla4_habilidadesdelectura.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion2_pantalla9_habilidadesdelectura.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "siguiente_habilidadesdelectura.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
        }
        if(numguia==11){
            rutaarchivos="/.estu@pp/guia11/";
            nomarchivo = "barra_negra_botones_forosvirtuales.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "bienvenida_forosvirtuales.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "boton_anterior_forosvirtuales.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "boton_salir_forosvirtuales.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "boton_siguiente_forosvirtuales.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "comenzar_forosvirtuales.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion_pantalla4_forosvirtuales.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion_pantalla5_forosvirtuales.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion_pantalla7_forosvirtuales.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "ilustracion_pantalla10_forosvirtuales.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "menu_pantalla2_forosvirtuales.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "panel_superior_forosvirtuales.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "portada_forosvirtuales.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "texto_anterior_forosvirtuales.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "texto_pantalla2_forosvirtuales.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "texto_pantalla3_forosvirtuales.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "texto_pantalla4_forosvirtuales.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "texto_pantalla5_forosvirtuales.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "texto_pantalla6_forosvirtuales.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "texto_pantalla7_forosvirtuales.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "texto_pantalla8_forosvirtuales.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "texto_pantalla9_forosvirtuales.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "texto_pantalla10_forosvirtuales.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "texto_pantalla11_forosvirtuales.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "texto_pantalla12_forosvirtuales.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "texto_pantalla13_forosvirtuales.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "texto_pantalla14_forosvirtuales.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "texto_pantalla15_forosvirtuales.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "texto_pantalla16_forosvirtuales.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
            nomarchivo = "texto_siguiente_forosvirtuales.zip";
            dir=Environment.getExternalStoragePublicDirectory(rutaarchivos+nomarchivo);
            if(dir.exists()){
                ar++;
            }
        }
        return ar;
    }

    public void mensaje(int mensaje) {
        if (mensaje == 1) {
            Toast.makeText(MainActivity.this, "Descargando archivos, espere un momento por favor", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(MainActivity.this, "Archivos descargados exitosamente", Toast.LENGTH_LONG).show();
        }
    }

    public void AlertaDatosLoggeoMayor() {
        final AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
        alertDialog.setTitle("Descarga de archivos");
        alertDialog.setMessage("Estas utilizando tus datos moviles.\n¿Deseas continuar con la conexión?");
        alertDialog.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.dismiss();
                consulta(usuario, password);
            }
        });
        alertDialog.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.dismiss();
                entrar21.setEnabled(true);
            }
        });
        alertDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            public void onDismiss(DialogInterface arg0) {
                entrar21.setEnabled(true);
            }
        });
        alertDialog.show();
    }

    public void AlertaDatosLoggeoMenor() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
        alertDialog.setTitle("Descarga de archivos");
        alertDialog.setMessage("Estas utilizando tus datos moviles.\n¿Deseas continuar con la conexión?");
        alertDialog.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.dismiss();
                consulta(usuario, password);
            }
        });
        alertDialog.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.dismiss();
                entrar21.setEnabled(true);
            }
        });
        alertDialog.show();
    }

    public void AlertaDatosDescargaMayor() {
        final AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
        alertDialog.setTitle("Descarga de archivos");
        alertDialog.setMessage("Estas utilizando tus datos moviles.\n¿Deseas continuar con la descarga?");
        alertDialog.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.dismiss();
                if (numguia == 1) {
                    mensaje(1);
                    guia = true;
                    descarga = dropbox();
                    if (descarga == true) {
                        numar = validaArchivos();
                        while (numar != 41) {
                            numar = validaArchivos();
                        }
                        mensaje(2);
                        if (numar == 41) {
                            try {
                                titulo(numguia);
                            } catch (FileNotFoundException e) {
                                e.printStackTrace();
                            }
                            ventana_frances = 1;
                            validaVentana1();
                        }
                    }
                }
                if (numguia == 3) {
                    mensaje(1);
                    guia = true;
                    descarga = dropbox();
                    if (descarga == true) {
                        numar = validaArchivos();
                        while (numar != 45) {
                            numar = validaArchivos();
                        }
                        mensaje(2);
                        if (numar == 45) {
                            try {
                                titulo(numguia);
                            } catch (FileNotFoundException e) {
                                e.printStackTrace();
                            }
                            ventana_administraciondeltiempo = 1;
                            validaVentana3();
                        }
                    }
                }
                if (numguia == 5) {
                    mensaje(1);
                    guia = true;
                    descarga = dropbox();
                    if (descarga == true) {
                        numar = validaArchivos();
                        while (numar != 31) {
                            numar = validaArchivos();
                        }
                        mensaje(2);
                        if (numar == 31) {
                            try {
                                titulo(numguia);
                            } catch (FileNotFoundException e) {
                                e.printStackTrace();
                            }
                            ventana_estres = 1;
                            validaVentana5();
                        }
                    }
                }
                if (numguia == 6) {
                    mensaje(1);
                    guia = true;
                    descarga = dropbox();
                    if (descarga == true) {
                        numar = validaArchivos();
                        while (numar != 42) {
                            numar = validaArchivos();
                        }
                        mensaje(2);
                        if (numar == 42) {
                            try {
                                titulo(numguia);
                            } catch (FileNotFoundException e) {
                                e.printStackTrace();
                            }
                            ventana_mapasmentales = 1;
                            validaVentana6();
                        }
                    }
                }
                if (numguia == 7) {
                    mensaje(1);
                    guia = true;
                    descarga = dropbox();
                    if (descarga == true) {
                        numar = validaArchivos();
                        while (numar != 50) {
                            numar = validaArchivos();
                        }
                        mensaje(2);
                        if (numar == 50) {
                            try {
                                titulo(numguia);
                            } catch (FileNotFoundException e) {
                                e.printStackTrace();
                            }
                            ventana_importanciadelingles = 1;
                            validaVentana7();
                        }
                    }
                }
                if (numguia == 8) {
                    mensaje(1);
                    guia = true;
                    descarga = dropbox();
                    if (descarga == true) {
                        numar = validaArchivos();
                        while (numar != 44) {
                            numar = validaArchivos();
                        }
                        mensaje(2);
                        if (numar == 44) {
                            try {
                                titulo(numguia);
                            } catch (FileNotFoundException e) {
                                e.printStackTrace();
                            }
                            if (!guardadatosnum.exists()) {
                                numaudguia8 = 1;
                                ventana_datosnum = 1;
                                validaVentana8();
                                validaudio(ventana_datosnum);
                            } else {
                                inicio_datosnum();
                            }
                        }
                    }
                }
                if (numguia == 9) {
                    mensaje(1);
                    guia = true;
                    descarga = dropbox();
                    if (descarga == true) {
                        numar = validaArchivos();
                        while (numar != 45) {
                            numar = validaArchivos();
                        }
                        mensaje(2);
                        if (numar == 45) {
                            try {
                                titulo(numguia);
                            } catch (FileNotFoundException e) {
                                e.printStackTrace();
                            }
                            ventana_capacidades = 1;
                            validaVentana9();
                        }
                    }
                }
                if (numguia == 10) {
                    mensaje(1);
                    guia = true;
                    descarga = dropbox();
                    if (descarga == true) {
                        numar = validaArchivos();
                        while (numar != 23) {
                            numar = validaArchivos();
                        }
                        mensaje(2);
                        if (numar == 23) {
                            try {
                                titulo(numguia);
                            } catch (FileNotFoundException e) {
                                e.printStackTrace();
                            }
                            ventana_habilidadesdelectura = 1;
                            validaVentana10();
                        }
                    }
                }
                if (numguia == 11) {
                    mensaje(1);
                    guia = true;
                    descarga = dropbox();
                    if (descarga == true) {
                        numar = validaArchivos();
                        while (numar != 30) {
                            numar = validaArchivos();
                        }
                        mensaje(2);
                        if (numar == 30) {
                            try {
                                titulo(numguia);
                            } catch (FileNotFoundException e) {
                                e.printStackTrace();
                            }
                            ventana_foros = 1;
                            validaVentana11();
                        }
                    }
                }
            }
        });
        alertDialog.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.dismiss();
                numguia = 0;
            }
        });
        alertDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            public void onDismiss(DialogInterface arg0) {
                numguia=0;
            }
        });
        alertDialog.show();
    }

    public void AlertaDatosDescargaMenor(){
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
        alertDialog.setTitle("Descarga de archivos");
        alertDialog.setMessage("Estas utilizando tus datos moviles.\n¿Deseas continuar con la descarga?");
        alertDialog.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.dismiss();
                if (numguia == 1) {
                    mensaje(1);
                    guia = true;
                    descarga = dropbox();
                    if (descarga == true) {
                        numar = validaArchivos();
                        while (numar!=41) {
                            numar = validaArchivos();
                        }
                        mensaje(2);
                        if (numar==41) {
                            try {
                                titulo(numguia);
                            } catch (FileNotFoundException e) {
                                e.printStackTrace();
                            }
                            ventana_frances = 1;
                            validaVentana1();
                        }
                    }
                }
                if (numguia == 3) {
                    mensaje(1);
                    guia = true;
                    descarga = dropbox();
                    if (descarga == true) {
                        numar = validaArchivos();
                        while (numar != 45) {
                            numar = validaArchivos();
                        }
                        mensaje(2);
                        if (numar == 45) {
                            try {
                                titulo(numguia);
                            } catch (FileNotFoundException e) {
                                e.printStackTrace();
                            }
                            ventana_administraciondeltiempo = 1;
                            validaVentana3();
                        }
                    }
                }
                if (numguia == 5) {
                    mensaje(1);
                    guia = true;
                    descarga = dropbox();
                    if (descarga == true) {
                        numar = validaArchivos();
                        while (numar != 31) {
                            numar = validaArchivos();
                        }
                        mensaje(2);
                        if (numar == 31) {
                            try {
                                titulo(numguia);
                            } catch (FileNotFoundException e) {
                                e.printStackTrace();
                            }
                            ventana_estres = 1;
                            validaVentana5();
                        }
                    }
                }
                if (numguia == 6) {
                    mensaje(1);
                    guia = true;
                    descarga = dropbox();
                    if (descarga == true) {
                        numar = validaArchivos();
                        while (numar != 42) {
                            numar = validaArchivos();
                        }
                        mensaje(2);
                        if (numar == 42) {
                            try {
                                titulo(numguia);
                            } catch (FileNotFoundException e) {
                                e.printStackTrace();
                            }
                            ventana_mapasmentales = 1;
                            validaVentana6();
                        }
                    }
                }
                if (numguia == 7) {
                    mensaje(1);
                    guia = true;
                    descarga = dropbox();
                    if (descarga == true) {
                        numar = validaArchivos();
                        while (numar != 50) {
                            numar = validaArchivos();
                        }
                        mensaje(2);
                        if (numar == 50) {
                            try {
                                titulo(numguia);
                            } catch (FileNotFoundException e) {
                                e.printStackTrace();
                            }
                            ventana_importanciadelingles = 1;
                            validaVentana7();
                        }
                    }
                }
                if (numguia == 8) {
                    mensaje(1);
                    guia = true;
                    descarga = dropbox();
                    if (descarga == true) {
                        numar = validaArchivos();
                        while (numar != 44) {
                            numar = validaArchivos();
                        }
                        mensaje(2);
                        if (numar == 44) {
                            try {
                                titulo(numguia);
                            } catch (FileNotFoundException e) {
                                e.printStackTrace();
                            }
                            if (!guardadatosnum.exists()) {
                                numaudguia8 = 1;
                                ventana_datosnum = 1;
                                validaVentana8();
                                validaudio(ventana_datosnum);
                            } else {
                                inicio_datosnum();
                            }
                        }
                    }
                }
                if (numguia == 9) {
                    mensaje(1);
                    guia = true;
                    descarga = dropbox();
                    if (descarga == true) {
                        numar = validaArchivos();
                        while (numar != 45) {
                            numar = validaArchivos();
                        }
                        mensaje(2);
                        if (numar == 45) {
                            try {
                                titulo(numguia);
                            } catch (FileNotFoundException e) {
                                e.printStackTrace();
                            }
                            ventana_capacidades = 1;
                            validaVentana9();
                        }
                    }
                }
                if (numguia == 10) {
                    mensaje(1);
                    guia = true;
                    descarga = dropbox();
                    if (descarga == true) {
                        numar = validaArchivos();
                        while (numar != 23) {
                            numar = validaArchivos();
                        }
                        mensaje(2);
                        if (numar == 23) {
                            try {
                                titulo(numguia);
                            } catch (FileNotFoundException e) {
                                e.printStackTrace();
                            }
                            ventana_habilidadesdelectura = 1;
                            validaVentana10();
                        }
                    }
                }
                if (numguia == 11) {
                    mensaje(1);
                    guia = true;
                    descarga = dropbox();
                    if (descarga == true) {
                        numar = validaArchivos();
                        while (numar != 30) {
                            numar = validaArchivos();
                        }
                        mensaje(2);
                        if (numar == 30) {
                            try {
                                titulo(numguia);
                            } catch (FileNotFoundException e) {
                                e.printStackTrace();
                            }
                            ventana_foros = 1;
                            validaVentana11();
                        }
                    }
                }
            }
        });
        alertDialog.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.dismiss();
                numguia=0;
            }
        });
        alertDialog.show();
    }

    public void onClick(View view) throws IOException {
        switch (view.getId()){
            case R.id.entrar:
                entrar1=(Button)findViewById(R.id.entrar);
                entrar1.setEnabled(false);
                Usuario=(EditText)findViewById(R.id.usuario);
                Contraseña=(EditText)findViewById(R.id.contraseña);
                usuario=Usuario.getText().toString();
                password=Contraseña.getText().toString();
                if (usuario.equals("") && !password.equals("")){
                    Toast.makeText(MainActivity.this, "Porfavor ingresa un usuario", Toast.LENGTH_SHORT).show();
                    entrar1.setEnabled(true);
                }
                else{
                    if(!usuario.equals("") && password.equals("")){
                        Toast.makeText(MainActivity.this, "Porfavor ingresa una contraseña", Toast.LENGTH_SHORT).show();
                        entrar1.setEnabled(true);
                    }
                    else{
                        if(usuario.equals("") && password.equals("")){
                            Toast.makeText(MainActivity.this, "Porfavor ingresa sus datos", Toast.LENGTH_SHORT).show();
                            entrar1.setEnabled(true);
                        }
                        else{
                            confirmacion=false;
                            linea=verifica(usuario);
                            if(confirmacion==true){
                                separa(linea);
                                linea=null;
                                confirmacion=false;
                                setContentView(R.layout.guias);
                                logeo=true;
                                titulo(numguia);
                                try {
                                    OutputStreamWriter archivo = new OutputStreamWriter(
                                            new FileOutputStream(temploggeo));
                                    linea = (usuario + "," + password);
                                    archivo.write(linea);
                                    archivo.flush();
                                    archivo.close();
                                    linea=null;
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                            else{
                                Toast.makeText(MainActivity.this, "Usuario no registrado, por favor registrate o conectate con siiau", Toast.LENGTH_SHORT).show();
                                entrar1.setEnabled(true);
                            }
                        }
                    }
                }
                break;
            case R.id.entrar2:
                entrar21=(Button)findViewById(R.id.entrar2);
                entrar21.setEnabled(false);
                Usuario=(EditText)findViewById(R.id.codigo);
                Contraseña=(EditText)findViewById(R.id.nip);
                usuario=Usuario.getText().toString();
                password=Contraseña.getText().toString();
                if(usuario.equals("") && !password.equals("")){
                    Toast.makeText(MainActivity.this, "Porfavor ingresa un usuario", Toast.LENGTH_SHORT).show();
                    entrar21.setEnabled(true);
                }
                else{
                    if(!usuario.equals("") && password.equals("")){
                        Toast.makeText(MainActivity.this, "Porfavor ingresa una contraseña", Toast.LENGTH_SHORT).show();
                        entrar21.setEnabled(true);
                    }
                    else{
                        if(usuario.equals("") && password.equals("")){
                            Toast.makeText(MainActivity.this, "Porfavor ingresa sus datos", Toast.LENGTH_SHORT).show();
                            entrar21.setEnabled(true);
                        }
                        else{
                            linea=verifica(usuario);
                            if(confirmacion==true){
                                separa(linea);
                                linea=null;
                                confirmacion=false;
                                setContentView(R.layout.guias);
                                logeo=true;
                                titulo(numguia);
                                try {
                                    OutputStreamWriter archivo = new OutputStreamWriter(
                                            new FileOutputStream(temploggeo));
                                    linea = (usuario + "," + password);
                                    archivo.write(linea);
                                    archivo.flush();
                                    archivo.close();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                            else{
                                if(estaConectado()){
                                    if(!conectadoRedMovil()){
                                        consulta(usuario, password);
                                    }
                                    else{
                                        if(validaVersion()==true){
                                            AlertaDatosLoggeoMayor();
                                        }
                                        else{
                                            AlertaDatosLoggeoMenor();
                                        }
                                    }
                                }
                                else{
                                    Toast.makeText(MainActivity.this, "No tienes una conexion de internet estable, porfavor accede a una o registrate", Toast.LENGTH_LONG).show();
                                    entrar21.setEnabled(true);
                                }
                            }
                        }
                    }
                }
                break;
            case R.id.siguiente:
                siguiente1=(Button)findViewById(R.id.siguiente);
                siguiente1.setEnabled(false);
                setContentView(R.layout.siiau);
                if(validaVersion()==true){
                    video(2);
                }
                else{
                    imagen(2);
                }
                break;
            case R.id.registro:
                setContentView(R.layout.registro);
                centro4=(EditText)findViewById(R.id.centroreg);
                carrera4=(EditText)findViewById(R.id.carrerareg);
                sp = (Spinner) findViewById(R.id.spinner);
                ArrayAdapter<String> adapter= new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item ,array);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                sp.setAdapter(adapter);
                sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
                {
                    public void onItemSelected(AdapterView<?> parentView, View selectedItemView,int position, long id)
                    {
                        pos = position;
                        if(pos==2){
                            centro4.setHint("Departamento");
                            carrera4.setHint("Centro");
                        }
                        else{
                            centro4.setHint("Centro");
                            carrera4.setHint("Carrera");
                        }
                    }
                    public void onNothingSelected(AdapterView<?> parentView) { }
                });
                break;
            case R.id.registrar:
                registrar1=(Button)findViewById(R.id.registrar);
                registrar1.setEnabled(false);
                codigo4=(EditText)findViewById(R.id.codigoreg);
                nombre4=(EditText)findViewById(R.id.nombrereg);
                usuario4=(EditText)findViewById(R.id.usuarioreg);
                contraseña4=(EditText)findViewById(R.id.contraseñareg);
                contraseña5=(EditText)findViewById(R.id.contraseñareg2);
                codigo3=codigo4.getText().toString();
                nombre3=nombre4.getText().toString();
                centro3=centro4.getText().toString();
                carrera3=carrera4.getText().toString();
                usuario3=usuario4.getText().toString();
                password3=contraseña4.getText().toString();
                password32=contraseña5.getText().toString();
                situacion3=array[pos];
                if(situacion3.equals("")||codigo3.equals("")||nombre3.equals("")||centro3.equals("")||carrera3.equals("")||usuario3.equals("")||password3.equals("")||password32.equals("")){
                    Toast.makeText(MainActivity.this, "Porfavor completa todos los campos", Toast.LENGTH_SHORT).show();
                    registrar1.setEnabled(true);
                }
                else{
                    if(password3.equals(password32)==false){
                        Toast.makeText(MainActivity.this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show();
                        registrar1.setEnabled(true);
                    }
                    else{
                        verifica(usuario3);
                        if(confirmacion==false){
                            Toast.makeText(MainActivity.this, "Registro realizado correctamente", Toast.LENGTH_SHORT).show();
                            agregar(situacion3.toUpperCase() + "," + codigo3.toUpperCase() + "," + nombre3.toUpperCase() + "," + centro3.toUpperCase() + "," + carrera3.toUpperCase() + "," + usuario3 + "," + password3);
                            setContentView(R.layout.activity_main);
                            if(validaVersion()==true){
                                video(1);
                            }
                            else{
                                imagen(1);
                            }
                        }
                        else{
                            Toast.makeText(MainActivity.this, "Usuario ya existe, intenta con otro usuario", Toast.LENGTH_SHORT).show();
                            registrar1.setEnabled(true);
                        }
                    }
                }
                break;
            case R.id.cancelar:
                cancelar1=(Button)findViewById(R.id.cancelar);
                cancelar1.setEnabled(false);
                setContentView(R.layout.activity_main);
                if(validaVersion()==true){
                    video(1);
                }
                else{
                    imagen(1);
                }
                break;
            case R.id.regresar:
                regresar1=(Button)findViewById(R.id.regresar);
                regresar1.setEnabled(false);
                setContentView(R.layout.activity_main);
                if(validaVersion()==true){
                    video(1);
                }
                else{
                    imagen(1);
                }
                break;
            case R.id.cerrar:
                cerrar1=(Button)findViewById(R.id.cerrar);
                cerrar1.setEnabled(false);
                setContentView(R.layout.guias);
                break;
            case R.id.cerrar2:
                cerrar3=(Button)findViewById(R.id.cerrar2);
                cerrar3.setEnabled(false);
                setContentView(R.layout.guias);
                break;
            case R.id.intro_anterior_datosnumericos2:
                aud.stop();
                validaudio(ventana_datosnum);
                ventana_datosnum--;
                validaVentana8();
                numaudguia8--;
                break;
            case R.id.intro_anterior_datosnumericos3:
                aud.stop();
                numaudguia8--;
                ventana_datosnum--;
                validaVentana8();
                validaudio(ventana_datosnum);
                break;
            case R.id.intro_anterior_datosnumericos4:
                aud.stop();
                numaudguia8--;
                ventana_datosnum--;
                validaVentana8();
                validaudio(ventana_datosnum);
                break;
            case R.id.intro_anterior_datosnumericos5:
                aud.stop();
                numaudguia8--;
                ventana_datosnum--;
                validaVentana8();
                validaudio(ventana_datosnum);
                break;
            case R.id.intro_anterior_datosnumericos6:
                aud.stop();
                numaudguia8--;
                ventana_datosnum--;
                validaVentana8();
                validaudio(ventana_datosnum);
                break;
            case R.id.intro_anterior_datosnumericos7:
                aud.stop();
                numaudguia8--;
                ventana_datosnum--;
                validaVentana8();
                validaudio(ventana_datosnum);
                break;
            case R.id.intro_anterior_datosnumericos8:
                aud.stop();
                numaudguia8--;
                ventana_datosnum--;
                validaVentana8();
                validaudio(ventana_datosnum);
                break;
            case R.id.intro_anterior_datosnumericos9:
                aud.stop();
                numaudguia8--;
                ventana_datosnum--;
                validaVentana8();
                validaudio(ventana_datosnum);
                break;
            case R.id.intro_anterior_datosnumericos10:
                aud.stop();
                numaudguia8--;
                ventana_datosnum--;
                validaVentana8();
                validaudio(ventana_datosnum);
                break;
            case R.id.intro_anterior_datosnumericos11:
                aud.stop();
                numaudguia8--;
                ventana_datosnum--;
                validaVentana8();
                validaudio(ventana_datosnum);
                break;
            case R.id.intro_anterior_datosnumericos12:
                aud.stop();
                numaudguia8--;
                ventana_datosnum--;
                validaVentana8();
                validaudio(ventana_datosnum);
                break;
            case R.id.intro_siguiente_datosnumericos:
                getSupportActionBar().setSubtitle("¿Cómo representar datos numéricos?");
                aud.stop();
                validaudio(ventana_datosnum);
                numaudguia8++;
                ventana_datosnum++;
                validaVentana8();
                break;
            case R.id.intro_siguiente_datosnumericos2:
                aud.stop();
                numaudguia8++;
                ventana_datosnum++;
                validaVentana8();
                validaudio(ventana_datosnum);
                break;
            case R.id.intro_siguiente_datosnumericos3:
                aud.stop();
                numaudguia8++;
                ventana_datosnum++;
                validaVentana8();
                validaudio(ventana_datosnum);
                break;
            case R.id.intro_siguiente_datosnumericos4:
                aud.stop();
                numaudguia8++;
                ventana_datosnum++;
                validaVentana8();
                validaudio(ventana_datosnum);
                break;
            case R.id.intro_siguiente_datosnumericos5:
                aud.stop();
                numaudguia8++;
                ventana_datosnum++;
                validaVentana8();
                validaudio(ventana_datosnum);
                break;
            case R.id.intro_siguiente_datosnumericos6:
                aud.stop();
                numaudguia8++;
                ventana_datosnum++;
                validaVentana8();
                validaudio(ventana_datosnum);
                break;
            case R.id.intro_siguiente_datosnumericos7:
                aud.stop();
                numaudguia8++;
                ventana_datosnum++;
                validaVentana8();
                validaudio(ventana_datosnum);
                break;
            case R.id.intro_siguiente_datosnumericos8:
                aud.stop();
                numaudguia8++;
                ventana_datosnum++;
                validaVentana8();
                validaudio(ventana_datosnum);
                break;
            case R.id.intro_siguiente_datosnumericos9:
                aud.stop();
                numaudguia8++;
                ventana_datosnum++;
                validaVentana8();
                validaudio(ventana_datosnum);
                break;
            case R.id.intro_siguiente_datosnumericos10:
                aud.stop();
                numaudguia8++;
                ventana_datosnum++;
                validaVentana8();
                validaudio(ventana_datosnum);
                break;
            case R.id.intro_siguiente_datosnumericos11:
                aud.stop();
                numaudguia8++;
                ventana_datosnum++;
                validaVentana8();
                validaudio(ventana_datosnum);
                break;
            case R.id.empezar_datosnum:
                aud.stop();
                ventana_datosnum++;
                validaVentana8();
                break;
            case R.id.sonido1_datosnumericos:
                clickaud();
                break;
            case R.id.sonido3_datosnumericos:
                clickaud();
                break;
            case R.id.sonido4_datosnumericos:
                clickaud();
                break;
            case R.id.sonido5_datosnumericos:
                clickaud();
                break;
            case R.id.sonido6_datosnumericos:
                clickaud();
                break;
            case R.id.sonido7_datosnumericos:
                clickaud();
                break;
            case R.id.sonido8_datosnumericos:
                clickaud();
                break;
            case R.id.sonido9_datosnumericos:
                clickaud();
                break;
            case R.id.sonido10_datosnumericos:
                clickaud();
                break;
            case R.id.sonido11_datosnumericos:
                clickaud();
                break;
            case R.id.sonido12_datosnumericos:
                clickaud();
                break;
            case R.id.sonido13_datosnumericos:
                clickaud();
                break;
            case R.id.respuesta1_1:
                if(seleccion8==false){
                    op1_1=(TextView)findViewById(R.id.texto1_1);
                    op1_4=(TextView)findViewById(R.id.texto1_4);
                    op1_1.setBackgroundDrawable(getResources().getDrawable(R.drawable.rectangulo_redondeado_rojo));
                    op1_4.setBackgroundDrawable(getResources().getDrawable(R.drawable.rectangulo_redondeado_verde));
                    tiempo("Respuesta Incorrecta", "Para calcular este valor, solo multiplicas el 15% por 20 en su expresión decimal; o sea, recorriendo el punto dos lugares a la derecha: \n\n (0.15)(20)=3", 1);
                    seleccion8=true;
                }
                break;
            case R.id.respuesta1_2:
                if(seleccion8==false){
                    op1_2=(TextView)findViewById(R.id.texto1_2);
                    op1_4=(TextView)findViewById(R.id.texto1_4);
                    op1_2.setBackgroundDrawable(getResources().getDrawable(R.drawable.rectangulo_redondeado_rojo));
                    op1_4.setBackgroundDrawable(getResources().getDrawable(R.drawable.rectangulo_redondeado_verde));
                    tiempo("Respuesta Incorrecta", "Para calcular este valor, solo multiplicas el 15% por 20 en su expresión decimal; o sea, recorriendo el punto dos lugares a la derecha: \n\n (0.15)(20)=3", 1);
                    seleccion8=true;
                    ventana_datosnum++;
                }
                break;
            case R.id.respuesta1_3:
                if(seleccion8==false){
                    op1_3=(TextView)findViewById(R.id.texto1_3);
                    op1_4=(TextView)findViewById(R.id.texto1_4);
                    op1_3.setBackgroundDrawable(getResources().getDrawable(R.drawable.rectangulo_redondeado_rojo));
                    op1_4.setBackgroundDrawable(getResources().getDrawable(R.drawable.rectangulo_redondeado_verde));
                    tiempo("Respuesta Incorrecta", "Para calcular este valor, solo multiplicas el 15% por 20 en su expresión decimal; o sea, recorriendo el punto dos lugares a la derecha: \n\n (0.15)(20)=3", 1);
                    seleccion8=true;
                    ventana_datosnum++;
                }
                break;
            case R.id.respuesta1_4:
                if(seleccion8==false){
                    op1_4=(TextView)findViewById(R.id.texto1_4);
                    op1_4.setBackgroundDrawable(getResources().getDrawable(R.drawable.rectangulo_redondeado_verde));
                    tiempo("Respuesta Correcta", "Para calcular este valor, solo multiplicas el 15% por 20 en su expresión decimal; o sea, recorriendo el punto dos lugares a la derecha: \n\n (0.15)(20)=3", 1);
                    correctas8++;
                    seleccion8=true;
                    ventana_datosnum++;
                }
                break;
            case R.id.respuesta2_1:
                if(seleccion8==false){
                    op2_1=(TextView)findViewById(R.id.texto2_1);
                    op2_2=(TextView)findViewById(R.id.texto2_2);
                    op2_1.setBackgroundDrawable(getResources().getDrawable(R.drawable.rectangulo_redondeado_rojo));
                    op2_2.setBackgroundDrawable(getResources().getDrawable(R.drawable.rectangulo_redondeado_verde));
                    tiempo("Respuesta Incorrecta", "Para calcular este valor, solo multiplicas el 200% por 6 en su expresión decimal; o sea, recorriendo el punto dos lugares a la derecha:  \n\n (2)(6)=12", 2);
                    seleccion8=true;
                    ventana_datosnum++;
                }
                break;
            case R.id.respuesta2_2:
                if(seleccion8==false){
                    op2_2=(TextView)findViewById(R.id.texto2_2);
                    op2_2.setBackgroundDrawable(getResources().getDrawable(R.drawable.rectangulo_redondeado_verde));
                    tiempo("Respuesta Correcta", "Para calcular este valor, solo multiplicas el 200% por 6 en su expresión decimal; o sea, recorriendo el punto dos lugares a la derecha:  \n\n (2)(6)=12", 2);
                    correctas8++;
                    seleccion8=true;
                    ventana_datosnum++;
                }
                break;
            case R.id.respuesta2_3:
                if(seleccion8==false){
                    op2_2=(TextView)findViewById(R.id.texto2_2);
                    op2_3=(TextView)findViewById(R.id.texto2_3);
                    op2_3.setBackgroundDrawable(getResources().getDrawable(R.drawable.rectangulo_redondeado_rojo));
                    op2_2.setBackgroundDrawable(getResources().getDrawable(R.drawable.rectangulo_redondeado_verde));
                    tiempo("Respuesta Incorrecta", "Para calcular este valor, solo multiplicas el 200% por 6 en su expresión decimal; o sea, recorriendo el punto dos lugares a la derecha:  \n\n (2)(6)=12", 2);
                    seleccion8=true;
                    ventana_datosnum++;
                }
                break;
            case R.id.respuesta2_4:
                if(seleccion8==false){
                    op2_2=(TextView)findViewById(R.id.texto2_2);
                    op2_4=(TextView)findViewById(R.id.texto2_4);
                    op2_4.setBackgroundDrawable(getResources().getDrawable(R.drawable.rectangulo_redondeado_rojo));
                    op2_2.setBackgroundDrawable(getResources().getDrawable(R.drawable.rectangulo_redondeado_verde));
                    tiempo("Respuesta Incorrecta", "Para calcular este valor, solo multiplicas el 200% por 6 en su expresión decimal; o sea, recorriendo el punto dos lugares a la derecha:  \n\n (2)(6)=12", 2);
                    seleccion8=true;
                    ventana_datosnum++;
                }
                break;
            case R.id.respuesta3_1:
                if(seleccion8==false){
                    op3_1=(TextView)findViewById(R.id.texto3_1);
                    op3_2=(TextView)findViewById(R.id.texto3_2);
                    op3_1.setBackgroundDrawable(getResources().getDrawable(R.drawable.rectangulo_redondeado_rojo));
                    op3_2.setBackgroundDrawable(getResources().getDrawable(R.drawable.rectangulo_redondeado_verde));
                    tiempo("Respuesta Incorrecta", "Para calcular este porcentaje, solo divide el total de hombres entre 500 y obtendrás la expresión del porcentaje en decimal, para expresar en porcentaje, recorre el punto 2 casillas a la izquierda (multiplica por 100).", 3);
                    seleccion8=true;
                    ventana_datosnum++;
                }
                break;
            case R.id.respuesta3_2:
                if(seleccion8==false){
                    op3_2=(TextView)findViewById(R.id.texto3_2);
                    op3_2.setBackgroundDrawable(getResources().getDrawable(R.drawable.rectangulo_redondeado_verde));
                    tiempo("Respuesta Correcta", "Para calcular este porcentaje, solo divide el total de hombres entre 500 y obtendrás la expresión del porcentaje en decimal, para expresar en porcentaje, recorre el punto 2 casillas a la izquierda (multiplica por 100).", 3);
                    correctas8++;
                    seleccion8=true;
                    ventana_datosnum++;
                }
                break;
            case R.id.respuesta3_3:
                if(seleccion8==false){
                    op3_2=(TextView)findViewById(R.id.texto3_2);
                    op3_3=(TextView)findViewById(R.id.texto3_3);
                    op3_3.setBackgroundDrawable(getResources().getDrawable(R.drawable.rectangulo_redondeado_rojo));
                    op3_2.setBackgroundDrawable(getResources().getDrawable(R.drawable.rectangulo_redondeado_verde));
                    tiempo("Respuesta Incorrecta", "Para calcular este porcentaje, solo divide el total de hombres entre 500 y obtendrás la expresión del porcentaje en decimal, para expresar en porcentaje, recorre el punto 2 casillas a la izquierda (multiplica por 100).", 3);
                    seleccion8=true;
                    ventana_datosnum++;
                }
                break;
            case R.id.respuesta3_4:
                if(seleccion8==false){
                    op3_2=(TextView)findViewById(R.id.texto3_2);
                    op3_4=(TextView)findViewById(R.id.texto3_4);
                    op3_4.setBackgroundDrawable(getResources().getDrawable(R.drawable.rectangulo_redondeado_rojo));
                    op3_2.setBackgroundDrawable(getResources().getDrawable(R.drawable.rectangulo_redondeado_verde));
                    tiempo("Respuesta Incorrecta", "Para calcular este porcentaje, solo divide el total de hombres entre 500 y obtendrás la expresión del porcentaje en decimal, para expresar en porcentaje, recorre el punto 2 casillas a la izquierda (multiplica por 100).", 3);
                    seleccion8=true;
                    ventana_datosnum++;
                }
                break;
            case R.id.respuesta5_1:
                if(seleccion8==false){
                    op5_4=(TextView)findViewById(R.id.texto5_4);
                    op5_1=(TextView)findViewById(R.id.texto5_1);
                    op5_1.setBackgroundDrawable(getResources().getDrawable(R.drawable.rectangulo_redondeado_rojo));
                    op5_4.setBackgroundDrawable(getResources().getDrawable(R.drawable.rectangulo_redondeado_verde));
                    tiempo("Respuesta Incorrecta", "Para encontrar este valor, se multiplican los $32,000 por 12% (en decimal). El valor obtenido representa la ganancia que obtuviste. Para obtener la cantidad en la que lo compraste, basta con restar esta cantidad a los $32,000.  \n32,000 x .12 = 3840 \n32,000 – 3,840 = 28,160 ", 4);
                    seleccion8=true;
                    ventana_datosnum++;
                }
                break;
            case R.id.respuesta5_2:
                if(seleccion8==false){
                    op5_4=(TextView)findViewById(R.id.texto5_4);
                    op5_2=(TextView)findViewById(R.id.texto5_2);
                    op5_2.setBackgroundDrawable(getResources().getDrawable(R.drawable.rectangulo_redondeado_rojo));
                    op5_4.setBackgroundDrawable(getResources().getDrawable(R.drawable.rectangulo_redondeado_verde));
                    tiempo("Respuesta Incorrecta", "Para encontrar este valor, se multiplican los $32,000 por 12% (en decimal). El valor obtenido representa la ganancia que obtuviste. Para obtener la cantidad en la que lo compraste, basta con restar esta cantidad a los $32,000.  \n32,000 x .12 = 3840 \n32,000 – 3,840 = 28,160 ", 4);
                    seleccion8=true;
                    ventana_datosnum++;
                }
                break;
            case R.id.respuesta5_3:
                if(seleccion8==false){
                    op5_4=(TextView)findViewById(R.id.texto5_4);
                    op5_3=(TextView)findViewById(R.id.texto5_3);
                    op5_3.setBackgroundDrawable(getResources().getDrawable(R.drawable.rectangulo_redondeado_rojo));
                    op5_4.setBackgroundDrawable(getResources().getDrawable(R.drawable.rectangulo_redondeado_verde));
                    tiempo("Respuesta Incorrecta", "Para encontrar este valor, se multiplican los $32,000 por 12% (en decimal). El valor obtenido representa la ganancia que obtuviste. Para obtener la cantidad en la que lo compraste, basta con restar esta cantidad a los $32,000.  \n32,000 x .12 = 3840 \n32,000 – 3,840 = 28,160 ", 4);
                    seleccion8=true;
                    ventana_datosnum++;
                }
                break;
            case R.id.respuesta5_4:
                if(seleccion8==false){
                    op5_4=(TextView)findViewById(R.id.texto5_4);
                    op5_4.setBackgroundDrawable(getResources().getDrawable(R.drawable.rectangulo_redondeado_verde));
                    tiempo("Respuesta Correcta", "Para encontrar este valor, se multiplican los $32,000 por 12% (en decimal). El valor obtenido representa la ganancia que obtuviste. Para obtener la cantidad en la que lo compraste, basta con restar esta cantidad a los $32,000.  \n32,000 x .12 = 3840 \n32,000 – 3,840 = 28,160 ", 4);
                    correctas8++;
                    seleccion8=true;
                    ventana_datosnum++;
                }
                break;
            case R.id.respuesta6_1:
                if(seleccion8==false){
                    op6_4=(TextView)findViewById(R.id.texto6_4);
                    op6_1=(TextView)findViewById(R.id.texto6_1);
                    op6_1.setBackgroundDrawable(getResources().getDrawable(R.drawable.rectangulo_redondeado_rojo));
                    op6_4.setBackgroundDrawable(getResources().getDrawable(R.drawable.rectangulo_redondeado_verde));
                    tiempo("Respuesta Incorrecta", "En este caso tenemos una razón, esto es, una fracción que nos representa:\n\n25%/100% = 1/4", 5);
                    seleccion8=true;
                    ventana_datosnum++;
                }
                break;
            case R.id.respuesta6_2:
                if(seleccion8==false){
                    op6_4=(TextView)findViewById(R.id.texto6_4);
                    op6_2=(TextView)findViewById(R.id.texto6_2);
                    op6_2.setBackgroundDrawable(getResources().getDrawable(R.drawable.rectangulo_redondeado_rojo));
                    op6_4.setBackgroundDrawable(getResources().getDrawable(R.drawable.rectangulo_redondeado_verde));
                    tiempo("Respuesta Incorrecta", "En este caso tenemos una razón, esto es, una fracción que nos representa:\n\n25%/100% = 1/4", 5);
                    seleccion8=true;
                    ventana_datosnum++;
                }
                break;
            case R.id.respuesta6_3:
                if(seleccion8==false){
                    op6_4=(TextView)findViewById(R.id.texto6_4);
                    op6_3=(TextView)findViewById(R.id.texto6_3);
                    op6_3.setBackgroundDrawable(getResources().getDrawable(R.drawable.rectangulo_redondeado_rojo));
                    op6_4.setBackgroundDrawable(getResources().getDrawable(R.drawable.rectangulo_redondeado_verde));
                    tiempo("Respuesta Incorrecta", "En este caso tenemos una razón, esto es, una fracción que nos representa:\n\n25%/100% = 1/4", 5);
                    seleccion8=true;
                    ventana_datosnum++;
                }
                break;
            case R.id.respuesta6_4:
                if(seleccion8==false){
                    op6_4=(TextView)findViewById(R.id.texto6_4);
                    op6_4.setBackgroundDrawable(getResources().getDrawable(R.drawable.rectangulo_redondeado_verde));
                    tiempo("Respuesta Correcta", "En este caso tenemos una razón, esto es, una fracción que nos representa:\n\n25%/100% = 1/4", 5);
                    correctas8++;
                    seleccion8=true;
                    ventana_datosnum++;
                }
                break;
            case R.id.respuesta7_1:
                if(seleccion8==false){
                    op7_4=(TextView)findViewById(R.id.texto7_4);
                    op7_1=(TextView)findViewById(R.id.texto7_1);
                    op7_1.setBackgroundDrawable(getResources().getDrawable(R.drawable.rectangulo_redondeado_rojo));
                    op7_4.setBackgroundDrawable(getResources().getDrawable(R.drawable.rectangulo_redondeado_verde));
                    tiempo("Respuesta Incorrecta", "En este caso es más fácil resolver por regla de 3:\nSi 60 votos ---- 100%\n      ¿?       ----- 40%\n\n(60)(40)/100 = 24", 6);
                    seleccion8=true;
                    ventana_datosnum++;
                }
                break;
            case R.id.respuesta7_2:
                if(seleccion8==false){
                    op7_4=(TextView)findViewById(R.id.texto7_4);
                    op7_2=(TextView)findViewById(R.id.texto7_2);
                    op7_2.setBackgroundDrawable(getResources().getDrawable(R.drawable.rectangulo_redondeado_rojo));
                    op7_4.setBackgroundDrawable(getResources().getDrawable(R.drawable.rectangulo_redondeado_verde));
                    tiempo("Respuesta Incorrecta", "En este caso es más fácil resolver por regla de 3:\nSi 60 votos ---- 100%\n      ¿?       ----- 40%\n\n(60)(40)/100 = 24", 6);
                    seleccion8=true;
                    ventana_datosnum++;
                }
                break;
            case R.id.respuesta7_3:
                if(seleccion8==false){
                    op7_4=(TextView)findViewById(R.id.texto7_4);
                    op7_3=(TextView)findViewById(R.id.texto7_3);
                    op7_3.setBackgroundDrawable(getResources().getDrawable(R.drawable.rectangulo_redondeado_rojo));
                    op7_4.setBackgroundDrawable(getResources().getDrawable(R.drawable.rectangulo_redondeado_verde));
                    tiempo("Respuesta Incorrecta", "En este caso es más fácil resolver por regla de 3:\nSi 60 votos ---- 100%\n      ¿?       ----- 40%\n\n(60)(40)/100 = 24", 6);
                    seleccion8=true;
                    ventana_datosnum++;
                }
                break;
            case R.id.respuesta7_4:
                if(seleccion8==false){
                    op7_4=(TextView)findViewById(R.id.texto7_4);
                    op7_4.setBackgroundDrawable(getResources().getDrawable(R.drawable.rectangulo_redondeado_verde));
                    tiempo("Respuesta Correcta", "En este caso es más fácil resolver por regla de 3:\nSi 60 votos ---- 100%\n      ¿?       ----- 40%\n\n(60)(40)/100 = 24", 6);
                    correctas8++;
                    seleccion8=true;
                    ventana_datosnum++;
                }
                break;
            case R.id.respuesta8_1:
                if(seleccion8==false){
                    op8_1=(TextView)findViewById(R.id.texto8_1);
                    op8_1.setBackgroundDrawable(getResources().getDrawable(R.drawable.rectangulo_redondeado_verde));
                    tiempo("Respuesta Correcta", "En este caso también tenemos una razón, esto es, una fracción que nos representa:\n\n20%/100% = 1/5", 7);
                    correctas8++;
                    seleccion8=true;
                    ventana_datosnum++;
                }
                break;
            case R.id.respuesta8_2:
                if(seleccion8==false){
                    op8_1=(TextView)findViewById(R.id.texto8_1);
                    op8_2=(TextView)findViewById(R.id.texto8_2);
                    op8_2.setBackgroundDrawable(getResources().getDrawable(R.drawable.rectangulo_redondeado_rojo));
                    op8_1.setBackgroundDrawable(getResources().getDrawable(R.drawable.rectangulo_redondeado_verde));
                    tiempo("Respuesta Incorrecta", "En este caso también tenemos una razón, esto es, una fracción que nos representa:\n\n20%/100% = 1/5", 7);
                    seleccion8=true;
                    ventana_datosnum++;
                }
                break;
            case R.id.respuesta8_3:
                if(seleccion8==false){
                    op8_1=(TextView)findViewById(R.id.texto8_1);
                    op8_3=(TextView)findViewById(R.id.texto8_3);
                    op8_3.setBackgroundDrawable(getResources().getDrawable(R.drawable.rectangulo_redondeado_rojo));
                    op8_1.setBackgroundDrawable(getResources().getDrawable(R.drawable.rectangulo_redondeado_verde));
                    tiempo("Respuesta Incorrecta", "En este caso también tenemos una razón, esto es, una fracción que nos representa:\n\n20%/100% = 1/5", 7);
                    seleccion8=true;
                    ventana_datosnum++;
                }
                break;
            case R.id.respuesta8_4:
                if(seleccion8==false){
                    op8_1=(TextView)findViewById(R.id.texto8_1);
                    op8_4=(TextView)findViewById(R.id.texto8_4);
                    op8_4.setBackgroundDrawable(getResources().getDrawable(R.drawable.rectangulo_redondeado_rojo));
                    op8_1.setBackgroundDrawable(getResources().getDrawable(R.drawable.rectangulo_redondeado_verde));
                    tiempo("Respuesta Incorrecta", "En este caso también tenemos una razón, esto es, una fracción que nos representa:\n\n20%/100% = 1/5", 7);
                    seleccion8=true;
                    ventana_datosnum++;
                }
                break;
            case R.id.respuesta9_1:
                if(seleccion8==false){
                    op9_3=(TextView)findViewById(R.id.texto9_3);
                    op9_1=(TextView)findViewById(R.id.texto9_1);
                    op9_1.setBackgroundDrawable(getResources().getDrawable(R.drawable.rectangulo_redondeado_rojo));
                    op9_3.setBackgroundDrawable(getResources().getDrawable(R.drawable.rectangulo_redondeado_verde));
                    tiempo("Respuesta Incorrecta", "En este caso también se resuelve por regla de 3:\nSi 60 votos ---- 100%\n      ¿?       ----- 15%\n\n(60)(15)/100 = 9", 8);
                    seleccion8=true;
                    ventana_datosnum++;
                }
                break;
            case R.id.respuesta9_2:
                if(seleccion8==false){
                    op9_3=(TextView)findViewById(R.id.texto9_3);
                    op9_2=(TextView)findViewById(R.id.texto9_2);
                    op9_2.setBackgroundDrawable(getResources().getDrawable(R.drawable.rectangulo_redondeado_rojo));
                    op9_3.setBackgroundDrawable(getResources().getDrawable(R.drawable.rectangulo_redondeado_verde));
                    tiempo("Respuesta Incorrecta", "En este caso también se resuelve por regla de 3:\nSi 60 votos ---- 100%\n      ¿?       ----- 15%\n\n(60)(15)/100 = 9", 8);
                    seleccion8=true;
                    ventana_datosnum++;
                }
                break;
            case R.id.respuesta9_3:
                if(seleccion8==false){
                    op9_3=(TextView)findViewById(R.id.texto9_3);
                    op9_3.setBackgroundDrawable(getResources().getDrawable(R.drawable.rectangulo_redondeado_verde));
                    tiempo("Respuesta Correcta", "En este caso también se resuelve por regla de 3:\nSi 60 votos ---- 100%\n      ¿?       ----- 15%\n\n(60)(15)/100 = 9", 8);
                    correctas8++;
                    seleccion8=true;
                    ventana_datosnum++;
                }
                break;
            case R.id.respuesta9_4:
                if(seleccion8==false){
                    op9_3=(TextView)findViewById(R.id.texto9_3);
                    op9_4=(TextView)findViewById(R.id.texto9_4);
                    op9_4.setBackgroundDrawable(getResources().getDrawable(R.drawable.rectangulo_redondeado_rojo));
                    op9_3.setBackgroundDrawable(getResources().getDrawable(R.drawable.rectangulo_redondeado_verde));
                    tiempo("Respuesta Incorrecta", "En este caso también se resuelve por regla de 3:\nSi 60 votos ---- 100%\n      ¿?       ----- 15%\n\n(60)(15)/100 = 9", 8);
                    seleccion8=true;
                    ventana_datosnum++;
                }
                break;
            case R.id.respuesta10_1:
                if(seleccion8==false){
                    op10_3=(TextView)findViewById(R.id.texto10_3);
                    op10_1=(TextView)findViewById(R.id.texto10_1);
                    op10_1.setBackgroundDrawable(getResources().getDrawable(R.drawable.rectangulo_redondeado_rojo));
                    op10_3.setBackgroundDrawable(getResources().getDrawable(R.drawable.rectangulo_redondeado_verde));
                    tiempo("Respuesta Incorrecta", "En este caso también se resuelve por regla de 3:\nSi 60 votos ---- 100%\n      ¿?       ----- 25%\n\n(60)(25)/100 = 15", 9);
                    seleccion8=true;
                    ventana_datosnum++;
                }
                break;
            case R.id.respuesta10_2:
                if(seleccion8==false){
                    op10_3=(TextView)findViewById(R.id.texto10_3);
                    op10_2=(TextView)findViewById(R.id.texto10_2);
                    op10_2.setBackgroundDrawable(getResources().getDrawable(R.drawable.rectangulo_redondeado_rojo));
                    op10_3.setBackgroundDrawable(getResources().getDrawable(R.drawable.rectangulo_redondeado_verde));
                    tiempo("Respuesta Incorrecta", "En este caso también se resuelve por regla de 3:\nSi 60 votos ---- 100%\n      ¿?       ----- 25%\n\n(60)(25)/100 = 15", 9);
                    seleccion8=true;
                    ventana_datosnum++;
                }
                break;
            case R.id.respuesta10_3:
                if(seleccion8==false){
                    op10_3=(TextView)findViewById(R.id.texto10_3);
                    op10_3.setBackgroundDrawable(getResources().getDrawable(R.drawable.rectangulo_redondeado_verde));
                    tiempo("Respuesta Correcta", "En este caso también se resuelve por regla de 3: \nSi 60 votos ---- 100%\n      ¿?       ----- 25%\n\n(60)(25)/100 = 15", 9);
                    correctas8++;
                    seleccion8=true;
                    ventana_datosnum++;
                }
                break;
            case R.id.respuesta10_4:
                if(seleccion8==false){
                    op10_3=(TextView)findViewById(R.id.texto10_3);
                    op10_4=(TextView)findViewById(R.id.texto10_4);
                    op10_4.setBackgroundDrawable(getResources().getDrawable(R.drawable.rectangulo_redondeado_rojo));
                    op10_3.setBackgroundDrawable(getResources().getDrawable(R.drawable.rectangulo_redondeado_verde));
                    tiempo("Respuesta Incorrecta", "En este caso también se resuelve por regla de 3:\nSi 60 votos ---- 100%\n      ¿?       ----- 25%\n\n(60)(25)/100 = 15", 9);
                    seleccion8=true;
                    ventana_datosnum++;
                }
                break;
            case R.id.respuesta11_1:
                if(seleccion8==false){
                    op11_4=(TextView)findViewById(R.id.texto11_4);
                    op11_1=(TextView)findViewById(R.id.texto11_1);
                    op11_1.setBackgroundDrawable(getResources().getDrawable(R.drawable.rectangulonormal_rojo));
                    op11_4.setBackgroundDrawable(getResources().getDrawable(R.drawable.rectangulonormal_verde));
                    tiempo("Respuesta Incorrecta", "Si lo que se pregunta es por la desocupación, es fácil verificar en el histograma que la columna más alta corresponde a Alemania. ", 10);
                    seleccion8=true;
                    ventana_datosnum++;
                }
                break;
            case R.id.respuesta11_2:
                if(seleccion8==false){
                    op11_4=(TextView)findViewById(R.id.texto11_4);
                    op11_2=(TextView)findViewById(R.id.texto11_2);
                    op11_2.setBackgroundDrawable(getResources().getDrawable(R.drawable.rectangulonormal_rojo));
                    op11_4.setBackgroundDrawable(getResources().getDrawable(R.drawable.rectangulonormal_verde));
                    tiempo("Respuesta Incorrecta", "Si lo que se pregunta es por la desocupación, es fácil verificar en el histograma que la columna más alta corresponde a Alemania. ", 10);
                    seleccion8=true;
                    ventana_datosnum++;
                }
                break;
            case R.id.respuesta11_3:
                if(seleccion8==false){
                    op11_4=(TextView)findViewById(R.id.texto11_4);
                    op11_3=(TextView)findViewById(R.id.texto11_3);
                    op11_3.setBackgroundDrawable(getResources().getDrawable(R.drawable.rectangulonormal_rojo));
                    op11_4.setBackgroundDrawable(getResources().getDrawable(R.drawable.rectangulonormal_verde));
                    tiempo("Respuesta Incorrecta", "Si lo que se pregunta es por la desocupación, es fácil verificar en el histograma que la columna más alta corresponde a Alemania. ", 10);
                    seleccion8=true;
                    ventana_datosnum++;
                }
                break;
            case R.id.respuesta11_4:
                if(seleccion8==false){
                    op11_4=(TextView)findViewById(R.id.texto11_4);
                    op11_4.setBackgroundDrawable(getResources().getDrawable(R.drawable.rectangulonormal_verde));
                    tiempo("Respuesta Correcta", "Si lo que se pregunta es por la desocupación, es fácil verificar en el histograma que la columna más alta corresponde a Alemania. ", 10);
                    correctas8++;
                    seleccion8=true;
                    ventana_datosnum++;
                }
                break;
            case R.id.respuesta12_1:
                if(seleccion8==false){
                    op12_2=(TextView)findViewById(R.id.texto12_2);
                    op12_1=(TextView)findViewById(R.id.texto12_1);
                    op12_1.setBackgroundDrawable(getResources().getDrawable(R.drawable.rectangulonormal_rojo));
                    op12_2.setBackgroundDrawable(getResources().getDrawable(R.drawable.rectangulonormal_verde));
                    tiempo("Respuesta Incorrecta", "En primera instancia, es fácil encontrar que lo que se te pregunta es lo inverso a lo que la gráfica expresa o representa: lo contrario de la desocupación es la ocupación. En consecuencia, Japón no existe entre las opciones, por lo que debes buscar el siguiente valor más cercano a 4, que es el correspondiente a los Estados Unidos (4.6).", 11);
                    seleccion8=true;
                    ventana_datosnum++;
                }
                break;
            case R.id.respuesta12_2:
                if(seleccion8==false){
                    op12_2=(TextView)findViewById(R.id.texto12_2);
                    op12_2.setBackgroundDrawable(getResources().getDrawable(R.drawable.rectangulonormal_verde));
                    tiempo("Respuesta Correcta", "En primera instancia, es fácil encontrar que lo que se te pregunta es lo inverso a lo que la gráfica expresa o representa: lo contrario de la desocupación es la ocupación. En consecuencia, Japón no existe entre las opciones, por lo que debes buscar el siguiente valor más cercano a 4, que es el correspondiente a los Estados Unidos (4.6).", 11);
                    correctas8++;
                    seleccion8=true;
                    ventana_datosnum++;
                }
                break;
            case R.id.respuesta12_3:
                if(seleccion8==false){
                    op12_2=(TextView)findViewById(R.id.texto12_2);
                    op12_3=(TextView)findViewById(R.id.texto12_3);
                    op12_3.setBackgroundDrawable(getResources().getDrawable(R.drawable.rectangulonormal_rojo));
                    op12_2.setBackgroundDrawable(getResources().getDrawable(R.drawable.rectangulonormal_verde));
                    tiempo("Respuesta Incorrecta", "En primera instancia, es fácil encontrar que lo que se te pregunta es lo inverso a lo que la gráfica expresa o representa: lo contrario de la desocupación es la ocupación. En consecuencia, Japón no existe entre las opciones, por lo que debes buscar el siguiente valor más cercano a 4, que es el correspondiente a los Estados Unidos (4.6).", 11);
                    seleccion8=true;
                    ventana_datosnum++;
                }
                break;
            case R.id.respuesta12_4:
                if(seleccion8==false){
                    op12_2=(TextView)findViewById(R.id.texto12_2);
                    op12_4=(TextView)findViewById(R.id.texto12_4);
                    op12_4.setBackgroundDrawable(getResources().getDrawable(R.drawable.rectangulonormal_rojo));
                    op12_2.setBackgroundDrawable(getResources().getDrawable(R.drawable.rectangulonormal_verde));
                    tiempo("Respuesta Incorrecta", "En primera instancia, es fácil encontrar que lo que se te pregunta es lo inverso a lo que la gráfica expresa o representa: lo contrario de la desocupación es la ocupación. En consecuencia, Japón no existe entre las opciones, por lo que debes buscar el siguiente valor más cercano a 4, que es el correspondiente a los Estados Unidos (4.6).", 11);
                    seleccion8=true;
                    ventana_datosnum++;
                }
                break;
            case R.id.respuesta13_1:
                if(seleccion8==false){
                    op13_1=(TextView)findViewById(R.id.texto13_1);
                    op13_1.setBackgroundDrawable(getResources().getDrawable(R.drawable.rectangulonormal_verde));
                    tiempo("Respuesta Correcta", "De nuevo con Japón. Su valor en la gráfica es 4. Debes multiplicar dicho valor por 2.75 (equivalente a 2 3/4) con lo que obtienes el resultado de 11, es decir, el expresado para Alemania.", 12);
                    correctas8++;
                    seleccion8=true;
                    ventana_datosnum++;
                }
                break;
            case R.id.respuesta13_2:
                if(seleccion8==false){
                    op13_1=(TextView)findViewById(R.id.texto13_1);
                    op13_2=(TextView)findViewById(R.id.texto13_2);
                    op13_2.setBackgroundDrawable(getResources().getDrawable(R.drawable.rectangulonormal_rojo));
                    op13_1.setBackgroundDrawable(getResources().getDrawable(R.drawable.rectangulonormal_verde));
                    tiempo("Respuesta Incorrecta", "De nuevo con Japón. Su valor en la gráfica es 4. Debes multiplicar dicho valor por 2.75 (equivalente a 2 3/4) con lo que obtienes el resultado de 11, es decir, el expresado para Alemania.", 12);
                    seleccion8=true;
                    ventana_datosnum++;
                }
                break;
            case R.id.respuesta13_3:
                if(seleccion8==false){
                    op13_1=(TextView)findViewById(R.id.texto13_1);
                    op13_3=(TextView)findViewById(R.id.texto13_3);
                    op13_3.setBackgroundDrawable(getResources().getDrawable(R.drawable.rectangulonormal_rojo));
                    op13_1.setBackgroundDrawable(getResources().getDrawable(R.drawable.rectangulonormal_verde));
                    tiempo("Respuesta Incorrecta", "De nuevo con Japón. Su valor en la gráfica es 4. Debes multiplicar dicho valor por 2.75 (equivalente a 2 3/4) con lo que obtienes el resultado de 11, es decir, el expresado para Alemania.", 12);
                    seleccion8=true;
                    ventana_datosnum++;
                }
                break;
            case R.id.respuesta13_4:
                if(seleccion8==false){
                    op13_1=(TextView)findViewById(R.id.texto13_1);
                    op13_4=(TextView)findViewById(R.id.texto13_4);
                    op13_4.setBackgroundDrawable(getResources().getDrawable(R.drawable.rectangulonormal_rojo));
                    op13_1.setBackgroundDrawable(getResources().getDrawable(R.drawable.rectangulonormal_verde));
                    tiempo("Respuesta Incorrecta", "De nuevo con Japón. Su valor en la gráfica es 4. Debes multiplicar dicho valor por 2.75 (equivalente a 2 3/4) con lo que obtienes el resultado de 11, es decir, el expresado para Alemania.", 12);
                    seleccion8=true;
                    ventana_datosnum++;
                }
                break;
            case R.id.respuesta14_1:
                if(seleccion8==false){
                    op14_3=(TextView)findViewById(R.id.texto14_3);
                    op14_1=(TextView)findViewById(R.id.texto14_1);
                    op14_1.setBackgroundDrawable(getResources().getDrawable(R.drawable.rectangulonormal_rojo));
                    op14_3.setBackgroundDrawable(getResources().getDrawable(R.drawable.rectangulonormal_verde));
                    tiempo("Respuesta Incorrecta", "Sigamos haciendo multiplicaciones, para encontrar los valores de estos resultados, multiplica cada uno de ellos, el más alto será el de canadá pues es igual a 15.25.\n\n(2.5)(6.1) = 15.25", 13);
                    seleccion8=true;
                    ventana_datosnum++;
                }
                break;
            case R.id.respuesta14_2:
                if(seleccion8==false){
                    op14_3=(TextView)findViewById(R.id.texto14_3);
                    op14_2=(TextView)findViewById(R.id.texto14_2);
                    op14_2.setBackgroundDrawable(getResources().getDrawable(R.drawable.rectangulonormal_rojo));
                    op14_3.setBackgroundDrawable(getResources().getDrawable(R.drawable.rectangulonormal_verde));
                    tiempo("Respuesta Incorrecta", "Sigamos haciendo multiplicaciones, para encontrar los valores de estos resultados, multiplica cada uno de ellos, el más alto será el de canadá pues es igual a 15.25.\n\n(2.5)(6.1) = 15.25", 13);
                    seleccion8=true;
                    ventana_datosnum++;
                }
                break;
            case R.id.respuesta14_3:
                if(seleccion8==false){
                    op14_3=(TextView)findViewById(R.id.texto14_3);
                    op14_3.setBackgroundDrawable(getResources().getDrawable(R.drawable.rectangulonormal_verde));
                    tiempo("Respuesta Correcta", "Sigamos haciendo multiplicaciones, para encontrar los valores de estos resultados, multiplica cada uno de ellos, el más alto será el de canadá pues es igual a 15.25.\n\n(2.5)(6.1) = 15.25", 13);
                    correctas8++;
                    seleccion8=true;
                    ventana_datosnum++;
                }
                break;
            case R.id.respuesta14_4:
                if(seleccion8==false){
                    op14_3=(TextView)findViewById(R.id.texto14_3);
                    op14_4=(TextView)findViewById(R.id.texto14_4);
                    op14_4.setBackgroundDrawable(getResources().getDrawable(R.drawable.rectangulonormal_rojo));
                    op14_3.setBackgroundDrawable(getResources().getDrawable(R.drawable.rectangulonormal_verde));
                    tiempo("Respuesta Incorrecta", "Sigamos haciendo multiplicaciones, para encontrar los valores de estos resultados, multiplica cada uno de ellos, el más alto será el de canadá pues es igual a 15.25.\n\n(2.5)(6.1) = 15.25", 13);
                    seleccion8=true;
                    ventana_datosnum++;
                }
                break;
            case R.id.respuesta15_1:
                if(seleccion8==false){
                    op15_2=(TextView)findViewById(R.id.texto15_2);
                    op15_1=(TextView)findViewById(R.id.texto15_1);
                    op15_1.setBackgroundDrawable(getResources().getDrawable(R.drawable.rectangulonormal_rojo));
                    op15_2.setBackgroundDrawable(getResources().getDrawable(R.drawable.rectangulonormal_verde));
                    tiempo("Respuesta Incorrecta", "Se obtiene mediante la suma de todos los valores y su posterior división entre el número de valores.", 14);
                    seleccion8=true;
                    ventana_datosnum++;
                }
                break;
            case R.id.respuesta15_2:
                if(seleccion8==false){
                    op15_2=(TextView)findViewById(R.id.texto15_2);
                    op15_2.setBackgroundDrawable(getResources().getDrawable(R.drawable.rectangulonormal_verde));
                    tiempo("Respuesta Correcta", "Se obtiene mediante la suma de todos los valores y su posterior división entre el número de valores.", 14);
                    correctas8++;
                    seleccion8=true;
                    ventana_datosnum++;
                }
                break;
            case R.id.respuesta15_3:
                if(seleccion8==false){
                    op15_2=(TextView)findViewById(R.id.texto15_2);
                    op15_3=(TextView)findViewById(R.id.texto15_3);
                    op15_3.setBackgroundDrawable(getResources().getDrawable(R.drawable.rectangulonormal_rojo));
                    op15_2.setBackgroundDrawable(getResources().getDrawable(R.drawable.rectangulonormal_verde));
                    tiempo("Respuesta Incorrecta", "Se obtiene mediante la suma de todos los valores y su posterior división entre el número de valores.", 14);
                    seleccion8=true;
                    ventana_datosnum++;
                }
                break;
            case R.id.respuesta15_4:
                if(seleccion8==false){
                    op15_2=(TextView)findViewById(R.id.texto15_2);
                    op15_4=(TextView)findViewById(R.id.texto15_4);
                    op15_4.setBackgroundDrawable(getResources().getDrawable(R.drawable.rectangulonormal_rojo));
                    op15_2.setBackgroundDrawable(getResources().getDrawable(R.drawable.rectangulonormal_verde));
                    tiempo("Respuesta Incorrecta", "Se obtiene mediante la suma de todos los valores y su posterior división entre el número de valores.", 14);
                    seleccion8=true;
                    ventana_datosnum++;
                }
                break;
            case R.id.salir_datosnumericos:
                setContentView(R.layout.guias);
                guia = false;
                numguia=0;
                correctas8=0;
                numaudguia8=0;
                ventana_datosnum=0;
                titulo(numguia);
                break;
            case R.id.guia1:
                numguia=1;
                numar=0;
                numar=validaArchivos();
                if(numar==41)
                {
                    guia=true;
                    titulo(numguia);
                    ventana_frances=1;
                    validaVentana1();
                }
                else
                {
                    if(estaConectado())
                    {
                        if(!conectadoRedMovil())
                        {
                            mensaje(1);
                            guia=true;
                            descarga=dropbox();
                            if(descarga==true)
                            {
                                numar=validaArchivos();
                                while(numar!=41)
                                {
                                    numar=validaArchivos();
                                }
                                mensaje(2);
                                if(numar==41)
                                {
                                    titulo(numguia);
                                    ventana_frances=1;
                                    validaVentana1();
                                }
                            }
                        }
                        else
                        {
                            if(validaVersion()==true)
                            {
                                AlertaDatosDescargaMayor();
                            }
                            else
                            {
                                AlertaDatosDescargaMenor();
                            }
                        }
                    }
                    else
                    {
                        Toast.makeText(MainActivity.this, "No tienes una conexion de internet estable, porfavor accede a una para descargar el contenido", Toast.LENGTH_LONG).show();
                        numguia=0;
                    }
                }
                break;
            case R.id.guia2:
                Toast.makeText(MainActivity.this, "Aun no esta programado, CuceiMobile trabajando", Toast.LENGTH_SHORT).show();
                numguia=2;
                numar=0;
                numar=validaArchivos();
                if(numar==45){
                    guia=true;
                    titulo(numguia);
                }
     // ____________________________________
                break;
            case R.id.guia3:
                numguia=3;
                numar=0;
                numar=validaArchivos();
                if(numar==45){
                    guia=true;
                    titulo(numguia);
                    ventana_administraciondeltiempo=1;
                    validaVentana3();
                }
                else{
                    if(estaConectado()){
                        if(!conectadoRedMovil()){
                            mensaje(1);
                            guia=true;
                            descarga=dropbox();
                            if(descarga==true){
                                numar=validaArchivos();
                                while(numar!=45){
                                    numar=validaArchivos();
                                }
                                mensaje(2);
                                if(numar==45){
                                    titulo(numguia);
                                    ventana_administraciondeltiempo=1;
                                    validaVentana3();
                                }
                            }
                        }
                        else{
                            if(validaVersion()==true){
                                AlertaDatosDescargaMayor();
                            }
                            else{
                                AlertaDatosDescargaMenor();
                            }
                        }
                    }
                    else{
                        Toast.makeText(MainActivity.this, "No tienes una conexion de internet estable, porfavor accede a una para descargar el contenido", Toast.LENGTH_LONG).show();
                        numguia=0;
                    }
                }
                break;
            case R.id.guia4:
                Toast.makeText(MainActivity.this, "Aun no esta programado, CuceiMobile trabajando", Toast.LENGTH_SHORT).show();
                break;
            case R.id.guia5:
                numguia=5;
                numar=0;
                numar=validaArchivos();
                if(numar==31){
                    guia=true;
                    titulo(numguia);
                    ventana_estres=1;
                    validaVentana5();
                }
                else{
                    if(estaConectado()){
                        if(!conectadoRedMovil()){
                            mensaje(1);
                            guia=true;
                            descarga=dropbox();
                            if(descarga==true){
                                numar=validaArchivos();
                                while(numar!=31){
                                    numar=validaArchivos();
                                }
                                mensaje(2);
                                if(numar==31){
                                    titulo(numguia);
                                    ventana_estres=1;
                                    validaVentana5();
                                }
                            }
                        }
                        else{
                            if(validaVersion()==true){
                                AlertaDatosDescargaMayor();
                            }
                            else{
                                AlertaDatosDescargaMenor();
                            }
                        }
                    }
                    else{
                        Toast.makeText(MainActivity.this, "No tienes una conexion de internet estable, porfavor accede a una para descargar el contenido", Toast.LENGTH_LONG).show();
                        numguia=0;
                    }
                }
                break;
            case R.id.guia6:
                numguia=6;
                numar=0;
                numar=validaArchivos();
                if(numar==42){
                    guia=true;
                    titulo(numguia);
                    ventana_mapasmentales=1;
                    validaVentana6();
                }
                else{
                    if(estaConectado()){
                        if(!conectadoRedMovil()){
                            mensaje(1);
                            guia=true;
                            descarga=dropbox();
                            if(descarga==true){
                                numar=validaArchivos();
                                while(numar!=42){
                                    numar=validaArchivos();
                                }
                                mensaje(2);
                                if(numar==42){
                                    titulo(numguia);
                                    ventana_mapasmentales=1;
                                    validaVentana6();
                                }
                            }
                        }
                        else{
                            if(validaVersion()==true){
                                AlertaDatosDescargaMayor();
                            }
                            else{
                                AlertaDatosDescargaMenor();
                            }
                        }
                    }
                    else{
                        Toast.makeText(MainActivity.this, "No tienes una conexion de internet estable, porfavor accede a una para descargar el contenido", Toast.LENGTH_LONG).show();
                        numguia=0;
                    }
                }
                break;
            case R.id.guia7:
                numguia=7;
                numar=0;
                numar=validaArchivos();
                if(numar==50){
                    guia=true;
                    titulo(numguia);
                    ventana_importanciadelingles=1;
                    validaVentana7();
                }
                else{
                    if(estaConectado()){
                        if(!conectadoRedMovil()){
                            mensaje(1);
                            guia=true;
                            descarga=dropbox();
                            if(descarga==true){
                                numar=validaArchivos();
                                while(numar!=50){
                                    numar=validaArchivos();
                                }
                                mensaje(2);
                                if(numar==50){
                                    titulo(numguia);
                                    ventana_importanciadelingles=1;
                                    validaVentana7();
                                }
                            }
                        }
                        else{
                            if(validaVersion()==true){
                                AlertaDatosDescargaMayor();
                            }
                            else{
                                AlertaDatosDescargaMenor();
                            }
                        }
                    }
                    else{
                        Toast.makeText(MainActivity.this, "No tienes una conexion de internet estable, porfavor accede a una para descargar el contenido", Toast.LENGTH_LONG).show();
                        numguia=0;
                    }
                }
                break;
            case R.id.guia8:
                numguia=8;
                numar=0;
                numar=validaArchivos();
                if(numar==60){
                    guia=true;
                    titulo(numguia);
                    if(!guardadatosnum.exists())
                    {
                        numaudguia8=1;
                        ventana_datosnum=1;
                        validaVentana8();
                        validaudio(ventana_datosnum);
                    }
                    else{
                        inicio_datosnum();
                    }
                }
                else{
                    if(estaConectado()){
                        if(!conectadoRedMovil()){
                            mensaje(1);
                            guia=true;
                            descarga=dropbox();
                            if(descarga==true){
                                numar=validaArchivos();
                                while(numar!=60){
                                    numar=validaArchivos();
                                }
                                mensaje(2);
                                if(numar==60){
                                    titulo(numguia);
                                    if(!guardadatosnum.exists())
                                    {
                                        numaudguia8=1;
                                        ventana_datosnum=1;
                                        validaVentana8();
                                        validaudio(ventana_datosnum);
                                    }
                                    else{
                                        inicio_datosnum();
                                    }
                                }
                            }
                        }
                        else{
                            if(validaVersion()==true){
                                AlertaDatosDescargaMayor();
                            }
                            else{
                                AlertaDatosDescargaMenor();
                            }
                        }
                    }
                    else{
                        Toast.makeText(MainActivity.this, "No tienes una conexion de internet estable, porfavor accede a una para descargar el contenido", Toast.LENGTH_LONG).show();
                        numguia=0;
                    }
                }
                break;
            case R.id.guia9:
                numguia=9;
                numar=0;
                numar=validaArchivos();
                if(numar==45){
                    guia=true;
                    titulo(numguia);
                    ventana_capacidades=1;
                    validaVentana9();
                }
                else{
                    if(estaConectado()){
                        if(!conectadoRedMovil()){
                            mensaje(1);
                            guia=true;
                            descarga=dropbox();
                            if(descarga==true){
                                numar=validaArchivos();
                                while(numar!=45){
                                    numar=validaArchivos();
                                }
                                mensaje(2);
                                if(numar==45){
                                    titulo(numguia);
                                    ventana_capacidades=1;
                                    validaVentana9();
                                }
                            }
                        }
                        else{
                            if(validaVersion()==true){
                                AlertaDatosDescargaMayor();
                            }
                            else{
                                AlertaDatosDescargaMenor();
                            }
                        }
                    }
                    else{
                        Toast.makeText(MainActivity.this, "No tienes una conexion de internet estable, porfavor accede a una para descargar el contenido", Toast.LENGTH_LONG).show();
                        numguia=0;
                    }
                }
                break;
            case R.id.guia10:
                numguia=10;
                numar=0;
                numar=validaArchivos();
                if(numar==23){
                    guia=true;
                    titulo(numguia);
                    ventana_habilidadesdelectura=1;
                    validaVentana10();
                }
                else{
                    if(estaConectado()){
                        if(!conectadoRedMovil()){
                            mensaje(1);
                            guia=true;
                            descarga=dropbox();
                            if(descarga==true){
                                numar=validaArchivos();
                                while(numar!=23){
                                    numar=validaArchivos();
                                }
                                mensaje(2);
                                if(numar==23){
                                    titulo(numguia);
                                    ventana_habilidadesdelectura=1;
                                    validaVentana10();
                                }
                            }
                        }
                        else{
                            if(validaVersion()==true){
                                AlertaDatosDescargaMayor();
                            }
                            else{
                                AlertaDatosDescargaMenor();
                            }
                        }
                    }
                    else{
                        Toast.makeText(MainActivity.this, "No tienes una conexion de internet estable, porfavor accede a una para descargar el contenido", Toast.LENGTH_LONG).show();
                        numguia=0;
                    }
                }
                break;
            case R.id.guia11:
                numguia=11;
                numar=0;
                numar=validaArchivos();
                if(numar==30){
                    guia=true;
                    titulo(numguia);
                    ventana_foros=1;
                    validaVentana11();
                }
                else{
                    if(estaConectado()){
                        if(!conectadoRedMovil()){
                            mensaje(1);
                            guia=true;
                            descarga=dropbox();
                            if(descarga==true){
                                numar=validaArchivos();
                                while(numar!=30){
                                    numar=validaArchivos();
                                }
                                mensaje(2);
                                if(numar==30){
                                    titulo(numguia);
                                    ventana_foros=1;
                                    validaVentana11();
                                }
                            }
                        }
                        else{
                            if(validaVersion()==true){
                                AlertaDatosDescargaMayor();
                            }
                            else{
                                AlertaDatosDescargaMenor();
                            }
                        }
                    }
                    else{
                        Toast.makeText(MainActivity.this, "No tienes una conexion de internet estable, porfavor accede a una para descargar el contenido", Toast.LENGTH_LONG).show();
                        numguia=0;
                    }
                }
                break;
            case R.id.guia12:
                Toast.makeText(MainActivity.this, "Aun no esta programado, CuceiMobile trabajando", Toast.LENGTH_SHORT).show();
                break;
            // BOTONES GUIA 1
            case R.id.comenzar_frances:
                ventana_frances++;
                validaVentana1();
                getSupportActionBar().setSubtitle("Primer contacto con el Francés");
                break;
            case R.id.anterior_pantalla2_frances:
                ventana_frances--;
                validaVentana1();
                getSupportActionBar().setSubtitle("Guia de habilidades para el Aprendizaje");
                break;
            case R.id.siguiente_pantalla2_frances:
                ventana_frances++;
                validaVentana1();
                break;
            case R.id.anterior_pantalla3_frances:
                ventana_frances--;
                validaVentana1();
                break;
            case R.id.siguiente_pantalla3_frances:
                ventana_frances++;
                validaVentana1();
                break;
            case R.id.anterior_pantalla4_frances:
                ventana_frances--;
                validaVentana1();
                break;
            case R.id.siguiente_pantalla4_frances:
                ventana_frances++;
                validaVentana1();
                break;
            case R.id.anterior_pantalla5_frances:
                ventana_frances--;
                validaVentana1();
                break;
            case R.id.siguiente_pantalla5_frances:
                ventana_frances++;
                validaVentana1();
                break;
            case R.id.anterior_pantalla6_frances:
                ventana_frances--;
                validaVentana1();
                break;
            case R.id.siguiente_pantalla6_frances:
                ventana_frances++;
                validaVentana1();
                break;
            case R.id.anterior_pantalla7_frances:
                ventana_frances--;
                validaVentana1();
                break;
            case R.id.siguiente_pantalla7_frances:
                ventana_frances++;
                validaVentana1();
                break;
            case R.id.anterior_pantalla8_frances:
                ventana_frances--;
                validaVentana1();
                break;
            case R.id.siguiente_pantalla8_frances:
                ventana_frances++;
                validaVentana1();
                break;
            case R.id.anterior_pantalla9_frances:
                ventana_frances--;
                validaVentana1();
                break;
            case R.id.siguiente_pantalla9_frances:
                ventana_frances++;
                validaVentana1();
                break;
            case R.id.anterior_pantalla10_frances:
                ventana_frances--;
                validaVentana1();
                break;
            case R.id.siguiente_pantalla10_frances:
                ventana_frances++;
                validaVentana1();
                break;
            case R.id.anterior_pantalla11_frances:
                ventana_frances--;
                validaVentana1();
                break;
            case R.id.siguiente_pantalla11_frances:
                ventana_frances++;
                validaVentana1();
                break;
            case R.id.anterior_pantalla12_frances:
                ventana_frances--;
                validaVentana1();
                break;
            case R.id.siguiente_pantalla12_frances:
                ventana_frances++;
                validaVentana1();
                break;
            case R.id.anterior_pantalla13_frances:
                ventana_frances--;
                validaVentana1();
                break;
            case R.id.siguiente_pantalla13_frances:
                ventana_frances++;
                validaVentana1();
                break;
            case R.id.anterior_pantalla14_frances:
                ventana_frances--;
                validaVentana1();
                break;
            case R.id.siguiente_pantalla14_frances:
                ventana_frances++;
                validaVentana1();
                break;
            case R.id.anterior_pantalla15_frances:
                ventana_frances--;
                validaVentana1();
                break;
            case R.id.siguiente_pantalla15_frances:
                ventana_frances++;
                validaVentana1();
                break;
            case R.id.anterior_pantalla16_frances:
                ventana_frances--;
                validaVentana1();
                break;
            case R.id.siguiente_pantalla16_frances:
                ventana_frances++;
                validaVentana1();
                break;
            case R.id.anterior_pantalla17_frances:
                ventana_frances--;
                validaVentana1();
                break;
            case R.id.siguiente_pantalla17_frances:
                ventana_frances++;
                validaVentana1();
                break;
            case R.id.anterior_pantalla18_frances:
                ventana_frances--;
                validaVentana1();
                break;
            case R.id.siguiente_pantalla18_frances:
                ventana_frances++;
                validaVentana1();
                break;
            case R.id.anterior_pantalla19_frances:
                ventana_frances--;
                validaVentana1();
                break;
            case R.id.siguiente_pantalla19_frances:
                ventana_frances++;
                validaVentana1();
                break;
            case R.id.anterior_pantalla20_frances:
                ventana_frances--;
                validaVentana1();
                break;
            case R.id.siguiente_pantalla20_frances:
                ventana_frances++;
                validaVentana1();
                break;
            case R.id.anterior_pantalla21_frances:
                ventana_frances--;
                validaVentana1();
                break;
            case R.id.siguiente_pantalla21_frances:
                ventana_frances++;
                validaVentana1();
                break;
            case R.id.anterior_pantalla22_frances:
                ventana_frances--;
                validaVentana1();
                break;
            case R.id.siguiente_pantalla22_frances:
                ventana_frances++;
                validaVentana1();
                break;
            case R.id.Salir_frances:
                setContentView(R.layout.guias);
                guia = false;
                numguia=0;
                titulo(numguia);
                break;

            //BOTONES GUIA 11 FOROS VIRTUALES
            case R.id.comenzar_forosvirtuales:
                ventana_foros++;
                validaVentana11();
                break;
            case R.id.menu_forosvirtuales:
                ventana_foros++;
                validaVentana11();
                break;
            case R.id.anterior_pantalla3_forosvirtuales:
                ventana_foros--;
                validaVentana11();
                break;
            case R.id.siguiente_pantalla3_forosvirtuales:
                ventana_foros++;
                validaVentana11();
                break;
            case R.id.anterior_pantalla4_forosvirtuales:
                ventana_foros--;
                validaVentana11();
                break;
            case R.id.siguiente_pantalla4_forosvirtuales:
                ventana_foros++;
                validaVentana11();
                break;
            case R.id.anterior_pantalla5_forosvirtuales:
                ventana_foros--;
                validaVentana11();
                break;
            case R.id.siguiente_pantalla5_forosvirtuales:
                ventana_foros++;
                validaVentana11();
                break;
            case R.id.anterior_pantalla6_forosvirtuales:
                ventana_foros--;
                validaVentana11();
                break;
            case R.id.siguiente_pantalla6_forosvirtuales:
                ventana_foros++;
                validaVentana11();
                break;
            case R.id.anterior_pantalla7_forosvirtuales:
                ventana_foros--;
                validaVentana11();
                break;
            case R.id.siguiente_pantalla7_forosvirtuales:
                ventana_foros++;
                validaVentana11();
                break;
            case R.id.anterior_pantalla8_forosvirtuales:
                ventana_foros--;
                validaVentana11();
                break;
            case R.id.siguiente_pantalla8_forosvirtuales:
                ventana_foros++;
                validaVentana11();
                break;
            case R.id.anterior_pantalla9_forosvirtuales:
                ventana_foros--;
                validaVentana11();
                break;
            case R.id.siguiente_pantalla9_forosvirtuales:
                ventana_foros++;
                validaVentana11();
                break;
            case R.id.anterior_pantalla10_forosvirtuales:
                ventana_foros--;
                validaVentana11();
                break;
            case R.id.siguiente_pantalla10_forosvirtuales:
                ventana_foros++;
                validaVentana11();
                break;
            case R.id.anterior_pantalla11_forosvirtuales:
                ventana_foros--;
                validaVentana11();
                break;
            case R.id.siguiente_pantalla11_forosvirtuales:
                ventana_foros++;
                validaVentana11();
                break;
            case R.id.anterior_pantalla12_forosvirtuales:
                ventana_foros--;
                validaVentana11();
                break;
            case R.id.siguiente_pantalla12_forosvirtuales:
                ventana_foros++;
                validaVentana11();
                break;
            case R.id.anterior_pantalla13_forosvirtuales:
                ventana_foros--;
                validaVentana11();
                break;
            case R.id.siguiente_pantalla13_forosvirtuales:
                ventana_foros++;
                validaVentana11();
                break;
            case R.id.anterior_pantalla14_forosvirtuales:
                ventana_foros--;
                validaVentana11();
                break;
            case R.id.siguiente_pantalla14_forosvirtuales:
                ventana_foros++;
                validaVentana11();
                break;
            case R.id.anterior_pantalla15_forosvirtuales:
                ventana_foros--;
                validaVentana11();
                break;
            case R.id.siguiente_pantalla15_forosvirtuales:
                ventana_foros++;
                validaVentana11();
                break;
            case R.id.salir_forosvirtuales:
                setContentView(R.layout.guias);
                guia = false;
                numguia=0;
                titulo(numguia);
                break;
            case R.id.respuesta1_pantalla12_forosvirtuales:
                Toast.makeText(MainActivity.this, "respuesta 1", Toast.LENGTH_SHORT).show();
                break;
            case R.id.respuesta2_pantalla12_forosvirtuales:
                Toast.makeText(MainActivity.this, "respuesta 2", Toast.LENGTH_SHORT).show();
                break;
            case R.id.respuesta3_pantalla12_forosvirtuales:
                Toast.makeText(MainActivity.this, "respuesta 3", Toast.LENGTH_SHORT).show();
                break;
            case R.id.respuesta1_pantalla13_forosvirtuales:
                Toast.makeText(MainActivity.this, "respuesta 1", Toast.LENGTH_SHORT).show();
                break;
            case R.id.respuesta2_pantalla13_forosvirtuales:
                Toast.makeText(MainActivity.this, "respuesta 2", Toast.LENGTH_SHORT).show();
                break;
            case R.id.respuesta1_pantalla14_forosvirtuales:
                Toast.makeText(MainActivity.this, "respuesta 1", Toast.LENGTH_SHORT).show();
                break;
            case R.id.respuesta2_pantalla14_forosvirtuales:
                Toast.makeText(MainActivity.this, "respuesta 2", Toast.LENGTH_SHORT).show();
                break;
            case R.id.respuesta3_pantalla14_forosvirtuales:
                Toast.makeText(MainActivity.this, "respuesta 3", Toast.LENGTH_SHORT).show();
                break;
            case R.id.respuesta1_pantalla15_forosvirtuales:
                Toast.makeText(MainActivity.this, "respuesta 1", Toast.LENGTH_SHORT).show();
                break;
            case R.id.respuesta2_pantalla15_forosvirtuales:
                Toast.makeText(MainActivity.this, "respuesta 2", Toast.LENGTH_SHORT).show();
                break;
            case R.id.respuesta3_pantalla15_forosvirtuales:
                Toast.makeText(MainActivity.this, "respuesta 3", Toast.LENGTH_SHORT).show();
                break;
            case R.id.comenzar_capacidadesparaelaprendizaje:
                ventana_capacidades++;
                validaVentana9();
                break;
            case R.id.anterior_pantalla2_capacidadesparaelaprendizaje:
                ventana_capacidades--;
                validaVentana9();
                break;
            case R.id.siguiente_pantalla2_capacidadesparaelaprendizaje:
                ventana_capacidades++;
                validaVentana9();
                break;
            case R.id.anterior_pantalla3_capacidadesparaelaprendizaje:
                ventana_capacidades--;
                validaVentana9();
                break;
            case R.id.siguiente_pantalla3_capacidadesparaelaprendizaje:
                ventana_capacidades++;
                validaVentana9();
                break;
            case R.id.anterior_pantalla4_capacidadesparaelaprendizaje:
                ventana_capacidades--;
                validaVentana9();
                break;
            case R.id.siguiente_pantalla4_capacidadesparaelaprendizaje:
                ventana_capacidades++;
                validaVentana9();
                if(preguntas9[0][0]!=0){
                    if(preguntas9[0][0]==1){
                        carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/correcto_capacidadesparaelaprendizaje.zip");
                        bm = BitmapFactory.decodeFile(String.valueOf(carga));
                        imagenguia9=(ImageView)findViewById(R.id.respuesta1_pantalla5_capacidadesparaelaprendizaje);
                        imagenguia9.setImageBitmap(bm);
                    }
                    if (preguntas9[0][0]==2){
                        carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/incorrecto_capacidadesparaelaprendizaje.zip");
                        bm = BitmapFactory.decodeFile(String.valueOf(carga));
                        imagenguia9=(ImageView)findViewById(R.id.respuesta2_pantalla5_capacidadesparaelaprendizaje);
                        imagenguia9.setImageBitmap(bm);
                    }
                    if (preguntas9[0][0]==3){
                        carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/incorrecto_capacidadesparaelaprendizaje.zip");
                        bm = BitmapFactory.decodeFile(String.valueOf(carga));
                        imagenguia9=(ImageView)findViewById(R.id.respuesta3_pantalla5_capacidadesparaelaprendizaje);
                        imagenguia9.setImageBitmap(bm);
                    }
                    if (preguntas9[0][0]==4){
                        carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/incorrecto_capacidadesparaelaprendizaje.zip");
                        bm = BitmapFactory.decodeFile(String.valueOf(carga));
                        imagenguia9=(ImageView)findViewById(R.id.respuesta4_pantalla5_capacidadesparaelaprendizaje);
                        imagenguia9.setImageBitmap(bm);
                    }
                }
                break;
            case R.id.anterior_pantalla5_capacidadesparaelaprendizaje:
                ventana_capacidades--;
                validaVentana9();
                break;
            case R.id.siguiente_pantalla5_capacidadesparaelaprendizaje:
                ventana_capacidades++;
                validaVentana9();
                if(preguntas9[1][0]!=0){
                    if(preguntas9[1][0]==1){
                        carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/incorrecto_capacidadesparaelaprendizaje.zip");
                        bm = BitmapFactory.decodeFile(String.valueOf(carga));
                        imagenguia9=(ImageView)findViewById(R.id.respuesta1_pantalla6_capacidadesparaelaprendizaje);
                        imagenguia9.setImageBitmap(bm);
                    }
                    if(preguntas9[1][0]==2){
                        carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/correcto_capacidadesparaelaprendizaje.zip");
                        bm = BitmapFactory.decodeFile(String.valueOf(carga));
                        imagenguia9=(ImageView)findViewById(R.id.respuesta2_pantalla6_capacidadesparaelaprendizaje);
                        imagenguia9.setImageBitmap(bm);
                    }
                    if(preguntas9[1][0]==3){
                        carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/incorrecto_capacidadesparaelaprendizaje.zip");
                        bm = BitmapFactory.decodeFile(String.valueOf(carga));
                        imagenguia9=(ImageView)findViewById(R.id.respuesta3_pantalla6_capacidadesparaelaprendizaje);
                        imagenguia9.setImageBitmap(bm);
                    }
                    if(preguntas9[1][0]==4){
                        carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/incorrecto_capacidadesparaelaprendizaje.zip");
                        bm = BitmapFactory.decodeFile(String.valueOf(carga));
                        imagenguia9=(ImageView)findViewById(R.id.respuesta4_pantalla6_capacidadesparaelaprendizaje);
                        imagenguia9.setImageBitmap(bm);
                    }
                }
                break;
            case R.id.anterior_pantalla6_capacidadesparaelaprendizaje:
                ventana_capacidades--;
                validaVentana9();
                if(preguntas9[0][0]!=0){
                    if(preguntas9[0][0]==1){
                        carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/correcto_capacidadesparaelaprendizaje.zip");
                        bm = BitmapFactory.decodeFile(String.valueOf(carga));
                        imagenguia9=(ImageView)findViewById(R.id.respuesta1_pantalla5_capacidadesparaelaprendizaje);
                        imagenguia9.setImageBitmap(bm);
                    }
                    if(preguntas9[0][0]==2){
                        carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/incorrecto_capacidadesparaelaprendizaje.zip");
                        bm = BitmapFactory.decodeFile(String.valueOf(carga));
                        imagenguia9=(ImageView)findViewById(R.id.respuesta2_pantalla5_capacidadesparaelaprendizaje);
                        imagenguia9.setImageBitmap(bm);
                    }
                    if(preguntas9[0][0]==3){
                        carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/incorrecto_capacidadesparaelaprendizaje.zip");
                        bm = BitmapFactory.decodeFile(String.valueOf(carga));
                        imagenguia9=(ImageView)findViewById(R.id.respuesta3_pantalla5_capacidadesparaelaprendizaje);
                        imagenguia9.setImageBitmap(bm);
                    }
                    if(preguntas9[0][0]==4){
                        carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/incorrecto_capacidadesparaelaprendizaje.zip");
                        bm = BitmapFactory.decodeFile(String.valueOf(carga));
                        imagenguia9=(ImageView)findViewById(R.id.respuesta4_pantalla5_capacidadesparaelaprendizaje);
                        imagenguia9.setImageBitmap(bm);
                    }
                }
                break;
            case R.id.siguiente_pantalla6_capacidadesparaelaprendizaje:
                ventana_capacidades++;
                validaVentana9();
                if(preguntas9[2][0]!=0){
                    if(preguntas9[2][0]==1){
                        carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/incorrecto_capacidadesparaelaprendizaje.zip");
                        bm = BitmapFactory.decodeFile(String.valueOf(carga));
                        imagenguia9=(ImageView)findViewById(R.id.respuesta1_pantalla7_capacidadesparaelaprendizaje);
                        imagenguia9.setImageBitmap(bm);
                    }
                    if(preguntas9[2][0]==2){
                        carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/correcto_capacidadesparaelaprendizaje.zip");
                        bm = BitmapFactory.decodeFile(String.valueOf(carga));
                        imagenguia9=(ImageView)findViewById(R.id.respuesta2_pantalla7_capacidadesparaelaprendizaje);
                        imagenguia9.setImageBitmap(bm);
                    }
                    if(preguntas9[2][0]==3){
                        carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/incorrecto_capacidadesparaelaprendizaje.zip");
                        bm = BitmapFactory.decodeFile(String.valueOf(carga));
                        imagenguia9=(ImageView)findViewById(R.id.respuesta3_pantalla7_capacidadesparaelaprendizaje);
                        imagenguia9.setImageBitmap(bm);
                    }
                    if(preguntas9[2][0]==4){
                        carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/incorrecto_capacidadesparaelaprendizaje.zip");
                        bm = BitmapFactory.decodeFile(String.valueOf(carga));
                        imagenguia9=(ImageView)findViewById(R.id.respuesta4_pantalla7_capacidadesparaelaprendizaje);
                        imagenguia9.setImageBitmap(bm);
                    }
                }
                break;
            case R.id.anterior_pantalla7_capacidadesparaelaprendizaje:
                ventana_capacidades--;
                validaVentana9();
                if(preguntas9[1][0]!=0){
                    if(preguntas9[1][0]==1){
                        carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/incorrecto_capacidadesparaelaprendizaje.zip");
                        bm = BitmapFactory.decodeFile(String.valueOf(carga));
                        imagenguia9=(ImageView)findViewById(R.id.respuesta1_pantalla6_capacidadesparaelaprendizaje);
                        imagenguia9.setImageBitmap(bm);
                    }
                    if(preguntas9[1][0]==2){
                        carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/correcto_capacidadesparaelaprendizaje.zip");
                        bm = BitmapFactory.decodeFile(String.valueOf(carga));
                        imagenguia9=(ImageView)findViewById(R.id.respuesta2_pantalla6_capacidadesparaelaprendizaje);
                        imagenguia9.setImageBitmap(bm);
                    }
                    if(preguntas9[1][0]==3){
                        carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/incorrecto_capacidadesparaelaprendizaje.zip");
                        bm = BitmapFactory.decodeFile(String.valueOf(carga));
                        imagenguia9=(ImageView)findViewById(R.id.respuesta3_pantalla6_capacidadesparaelaprendizaje);
                        imagenguia9.setImageBitmap(bm);
                    }
                    if(preguntas9[1][0]==4){
                        carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/incorrecto_capacidadesparaelaprendizaje.zip");
                        bm = BitmapFactory.decodeFile(String.valueOf(carga));
                        imagenguia9=(ImageView)findViewById(R.id.respuesta4_pantalla6_capacidadesparaelaprendizaje);
                        imagenguia9.setImageBitmap(bm);
                    }
                }
                break;
            case R.id.siguiente_pantalla7_capacidadesparaelaprendizaje:
                ventana_capacidades++;
                validaVentana9();
                if(preguntas9[3][0]!=0){
                    if(preguntas9[3][0]==1){
                        carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/correcto_capacidadesparaelaprendizaje.zip");
                        bm = BitmapFactory.decodeFile(String.valueOf(carga));
                        imagenguia9=(ImageView)findViewById(R.id.respuesta1_pantalla8_capacidadesparaelaprendizaje);
                        imagenguia9.setImageBitmap(bm);
                    }
                    if(preguntas9[3][0]==2){
                        carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/incorrecto_capacidadesparaelaprendizaje.zip");
                        bm = BitmapFactory.decodeFile(String.valueOf(carga));
                        imagenguia9=(ImageView)findViewById(R.id.respuesta2_pantalla8_capacidadesparaelaprendizaje);
                        imagenguia9.setImageBitmap(bm);
                    }
                    if(preguntas9[3][0]==3){
                        carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/incorrecto_capacidadesparaelaprendizaje.zip");
                        bm = BitmapFactory.decodeFile(String.valueOf(carga));
                        imagenguia9=(ImageView)findViewById(R.id.respuesta3_pantalla8_capacidadesparaelaprendizaje);
                        imagenguia9.setImageBitmap(bm);
                    }
                    if(preguntas9[3][0]==4){
                        carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/incorrecto_capacidadesparaelaprendizaje.zip");
                        bm = BitmapFactory.decodeFile(String.valueOf(carga));
                        imagenguia9=(ImageView)findViewById(R.id.respuesta4_pantalla8_capacidadesparaelaprendizaje);
                        imagenguia9.setImageBitmap(bm);
                    }
                }
                break;
            case R.id.anterior_pantalla8_capacidadesparaelaprendizaje:
                ventana_capacidades--;
                validaVentana9();
                if(preguntas9[2][0]!=0){
                    if(preguntas9[2][0]==1){
                        carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/incorrecto_capacidadesparaelaprendizaje.zip");
                        bm = BitmapFactory.decodeFile(String.valueOf(carga));
                        imagenguia9=(ImageView)findViewById(R.id.respuesta1_pantalla7_capacidadesparaelaprendizaje);
                        imagenguia9.setImageBitmap(bm);
                    }
                    if(preguntas9[2][0]==2){
                        carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/correcto_capacidadesparaelaprendizaje.zip");
                        bm = BitmapFactory.decodeFile(String.valueOf(carga));
                        imagenguia9=(ImageView)findViewById(R.id.respuesta2_pantalla7_capacidadesparaelaprendizaje);
                        imagenguia9.setImageBitmap(bm);
                    }
                    if(preguntas9[2][0]==3){
                        carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/incorrecto_capacidadesparaelaprendizaje.zip");
                        bm = BitmapFactory.decodeFile(String.valueOf(carga));
                        imagenguia9=(ImageView)findViewById(R.id.respuesta3_pantalla7_capacidadesparaelaprendizaje);
                        imagenguia9.setImageBitmap(bm);
                    }
                    if(preguntas9[2][0]==4){
                        carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/incorrecto_capacidadesparaelaprendizaje.zip");
                        bm = BitmapFactory.decodeFile(String.valueOf(carga));
                        imagenguia9=(ImageView)findViewById(R.id.respuesta4_pantalla7_capacidadesparaelaprendizaje);
                        imagenguia9.setImageBitmap(bm);
                    }
                }
                break;
            case R.id.siguiente_pantalla8_capacidadesparaelaprendizaje:
                ventana_capacidades++;
                validaVentana9();
                if(preguntas9[4][0]!=0){
                    if(preguntas9[4][0]==1){
                        carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/correcto_capacidadesparaelaprendizaje.zip");
                        bm = BitmapFactory.decodeFile(String.valueOf(carga));
                        imagenguia9=(ImageView)findViewById(R.id.respuesta1_pantalla9_capacidadesparaelaprendizaje);
                        imagenguia9.setImageBitmap(bm);
                    }
                    if(preguntas9[4][0]==2){
                        carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/correcto_capacidadesparaelaprendizaje.zip");
                        bm = BitmapFactory.decodeFile(String.valueOf(carga));
                        imagenguia9=(ImageView)findViewById(R.id.respuesta2_pantalla9_capacidadesparaelaprendizaje);
                        imagenguia9.setImageBitmap(bm);
                    }
                    if(preguntas9[4][0]==3){
                        carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/incorrecto_capacidadesparaelaprendizaje.zip");
                        bm = BitmapFactory.decodeFile(String.valueOf(carga));
                        imagenguia9=(ImageView)findViewById(R.id.respuesta3_pantalla9_capacidadesparaelaprendizaje);
                        imagenguia9.setImageBitmap(bm);
                    }
                    if(preguntas9[4][0]==4){
                        carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/incorrecto_capacidadesparaelaprendizaje.zip");
                        bm = BitmapFactory.decodeFile(String.valueOf(carga));
                        imagenguia9=(ImageView)findViewById(R.id.respuesta4_pantalla9_capacidadesparaelaprendizaje);
                        imagenguia9.setImageBitmap(bm);
                    }
                    if(preguntas9[4][1]==1){
                        carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/correcto_capacidadesparaelaprendizaje.zip");
                        bm = BitmapFactory.decodeFile(String.valueOf(carga));
                        imagenguia9=(ImageView)findViewById(R.id.respuesta1_pantalla9_capacidadesparaelaprendizaje);
                        imagenguia9.setImageBitmap(bm);
                    }
                    if(preguntas9[4][1]==2){
                        carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/correcto_capacidadesparaelaprendizaje.zip");
                        bm = BitmapFactory.decodeFile(String.valueOf(carga));
                        imagenguia9=(ImageView)findViewById(R.id.respuesta2_pantalla9_capacidadesparaelaprendizaje);
                        imagenguia9.setImageBitmap(bm);
                    }
                    if(preguntas9[4][1]==3){
                        carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/incorrecto_capacidadesparaelaprendizaje.zip");
                        bm = BitmapFactory.decodeFile(String.valueOf(carga));
                        imagenguia9=(ImageView)findViewById(R.id.respuesta3_pantalla9_capacidadesparaelaprendizaje);
                        imagenguia9.setImageBitmap(bm);
                    }
                    if(preguntas9[4][1]==4){
                        carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/incorrecto_capacidadesparaelaprendizaje.zip");
                        bm = BitmapFactory.decodeFile(String.valueOf(carga));
                        imagenguia9=(ImageView)findViewById(R.id.respuesta4_pantalla9_capacidadesparaelaprendizaje);
                        imagenguia9.setImageBitmap(bm);
                    }
                }
                break;
            case R.id.anterior_pantalla9_capacidadesparaelaprendizaje:
                ventana_capacidades--;
                validaVentana9();
                if(preguntas9[3][0]!=0){
                    if(preguntas9[3][0]==1){
                        carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/correcto_capacidadesparaelaprendizaje.zip");
                        bm = BitmapFactory.decodeFile(String.valueOf(carga));
                        imagenguia9=(ImageView)findViewById(R.id.respuesta1_pantalla8_capacidadesparaelaprendizaje);
                        imagenguia9.setImageBitmap(bm);
                    }
                    if(preguntas9[3][0]==2){
                        carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/incorrecto_capacidadesparaelaprendizaje.zip");
                        bm = BitmapFactory.decodeFile(String.valueOf(carga));
                        imagenguia9=(ImageView)findViewById(R.id.respuesta2_pantalla8_capacidadesparaelaprendizaje);
                        imagenguia9.setImageBitmap(bm);
                    }
                    if(preguntas9[3][0]==3){
                        carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/incorrecto_capacidadesparaelaprendizaje.zip");
                        bm = BitmapFactory.decodeFile(String.valueOf(carga));
                        imagenguia9=(ImageView)findViewById(R.id.respuesta3_pantalla8_capacidadesparaelaprendizaje);
                        imagenguia9.setImageBitmap(bm);
                    }
                    if(preguntas9[3][0]==4){
                        carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/incorrecto_capacidadesparaelaprendizaje.zip");
                        bm = BitmapFactory.decodeFile(String.valueOf(carga));
                        imagenguia9=(ImageView)findViewById(R.id.respuesta4_pantalla8_capacidadesparaelaprendizaje);
                        imagenguia9.setImageBitmap(bm);
                    }
                }
                break;
            case R.id.siguiente_pantalla9_capacidadesparaelaprendizaje:
                ventana_capacidades++;
                validaVentana9();
                if(preguntas9[5][0]!=0){
                    if(preguntas9[5][0]==1){
                        carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/incorrecto_capacidadesparaelaprendizaje.zip");
                        bm = BitmapFactory.decodeFile(String.valueOf(carga));
                        imagenguia9=(ImageView)findViewById(R.id.respuesta1_pantalla10_capacidadesparaelaprendizaje);
                        imagenguia9.setImageBitmap(bm);
                    }
                    if(preguntas9[5][0]==2){
                        carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/incorrecto_capacidadesparaelaprendizaje.zip");
                        bm = BitmapFactory.decodeFile(String.valueOf(carga));
                        imagenguia9=(ImageView)findViewById(R.id.respuesta2_pantalla10_capacidadesparaelaprendizaje);
                        imagenguia9.setImageBitmap(bm);
                    }
                    if(preguntas9[5][0]==3){
                        carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/correcto_capacidadesparaelaprendizaje.zip");
                        bm = BitmapFactory.decodeFile(String.valueOf(carga));
                        imagenguia9=(ImageView)findViewById(R.id.respuesta3_pantalla10_capacidadesparaelaprendizaje);
                        imagenguia9.setImageBitmap(bm);
                    }
                    if(preguntas9[5][0]==4){
                        carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/incorrecto_capacidadesparaelaprendizaje.zip");
                        bm = BitmapFactory.decodeFile(String.valueOf(carga));
                        imagenguia9=(ImageView)findViewById(R.id.respuesta4_pantalla10_capacidadesparaelaprendizaje);
                        imagenguia9.setImageBitmap(bm);
                    }
                }
                break;
            case R.id.anterior_pantalla10_capacidadesparaelaprendizaje:
                ventana_capacidades--;
                validaVentana9();
                if(preguntas9[4][0]!=0){
                    if(preguntas9[4][0]==1){
                        carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/correcto_capacidadesparaelaprendizaje.zip");
                        bm = BitmapFactory.decodeFile(String.valueOf(carga));
                        imagenguia9=(ImageView)findViewById(R.id.respuesta1_pantalla9_capacidadesparaelaprendizaje);
                        imagenguia9.setImageBitmap(bm);
                    }
                    if(preguntas9[4][0]==2){
                        carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/correcto_capacidadesparaelaprendizaje.zip");
                        bm = BitmapFactory.decodeFile(String.valueOf(carga));
                        imagenguia9=(ImageView)findViewById(R.id.respuesta2_pantalla9_capacidadesparaelaprendizaje);
                        imagenguia9.setImageBitmap(bm);
                    }
                    if(preguntas9[4][0]==3){
                        carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/incorrecto_capacidadesparaelaprendizaje.zip");
                        bm = BitmapFactory.decodeFile(String.valueOf(carga));
                        imagenguia9=(ImageView)findViewById(R.id.respuesta3_pantalla9_capacidadesparaelaprendizaje);
                        imagenguia9.setImageBitmap(bm);
                    }
                    if(preguntas9[4][0]==4){
                        carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/incorrecto_capacidadesparaelaprendizaje.zip");
                        bm = BitmapFactory.decodeFile(String.valueOf(carga));
                        imagenguia9=(ImageView)findViewById(R.id.respuesta4_pantalla9_capacidadesparaelaprendizaje);
                        imagenguia9.setImageBitmap(bm);
                    }
                    if(preguntas9[4][1]==1){
                        carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/correcto_capacidadesparaelaprendizaje.zip");
                        bm = BitmapFactory.decodeFile(String.valueOf(carga));
                        imagenguia9=(ImageView)findViewById(R.id.respuesta1_pantalla9_capacidadesparaelaprendizaje);
                        imagenguia9.setImageBitmap(bm);
                    }
                    if(preguntas9[4][1]==2){
                        carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/correcto_capacidadesparaelaprendizaje.zip");
                        bm = BitmapFactory.decodeFile(String.valueOf(carga));
                        imagenguia9=(ImageView)findViewById(R.id.respuesta2_pantalla9_capacidadesparaelaprendizaje);
                        imagenguia9.setImageBitmap(bm);
                    }
                    if(preguntas9[4][1]==3){
                        carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/incorrecto_capacidadesparaelaprendizaje.zip");
                        bm = BitmapFactory.decodeFile(String.valueOf(carga));
                        imagenguia9=(ImageView)findViewById(R.id.respuesta3_pantalla9_capacidadesparaelaprendizaje);
                        imagenguia9.setImageBitmap(bm);
                    }
                    if(preguntas9[4][1]==4){
                        carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/incorrecto_capacidadesparaelaprendizaje.zip");
                        bm = BitmapFactory.decodeFile(String.valueOf(carga));
                        imagenguia9=(ImageView)findViewById(R.id.respuesta4_pantalla9_capacidadesparaelaprendizaje);
                        imagenguia9.setImageBitmap(bm);
                    }
                }
                break;
            case R.id.siguiente_pantalla10_capacidadesparaelaprendizaje:
                ventana_capacidades++;
                validaVentana9();
                if(preguntas9[6][0]!=0){
                    if(preguntas9[6][0]==1){
                        carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/correcto_capacidadesparaelaprendizaje.zip");
                        bm = BitmapFactory.decodeFile(String.valueOf(carga));
                        imagenguia9=(ImageView)findViewById(R.id.respuesta1_pantalla11_capacidadesparaelaprendizaje);
                        imagenguia9.setImageBitmap(bm);
                    }
                    if(preguntas9[6][0]==2){
                        carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/incorrecto_capacidadesparaelaprendizaje.zip");
                        bm = BitmapFactory.decodeFile(String.valueOf(carga));
                        imagenguia9=(ImageView)findViewById(R.id.respuesta2_pantalla11_capacidadesparaelaprendizaje);
                        imagenguia9.setImageBitmap(bm);
                    }
                    if(preguntas9[6][0]==3){
                        carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/incorrecto_capacidadesparaelaprendizaje.zip");
                        bm = BitmapFactory.decodeFile(String.valueOf(carga));
                        imagenguia9=(ImageView)findViewById(R.id.respuesta3_pantalla11_capacidadesparaelaprendizaje);
                        imagenguia9.setImageBitmap(bm);
                    }
                    if(preguntas9[6][0]==4){
                        carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/correcto_capacidadesparaelaprendizaje.zip");
                        bm = BitmapFactory.decodeFile(String.valueOf(carga));
                        imagenguia9=(ImageView)findViewById(R.id.respuesta4_pantalla11_capacidadesparaelaprendizaje);
                        imagenguia9.setImageBitmap(bm);
                    }
                    if(preguntas9[6][1]==1){
                        carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/correcto_capacidadesparaelaprendizaje.zip");
                        bm = BitmapFactory.decodeFile(String.valueOf(carga));
                        imagenguia9=(ImageView)findViewById(R.id.respuesta1_pantalla11_capacidadesparaelaprendizaje);
                        imagenguia9.setImageBitmap(bm);
                    }
                    if(preguntas9[6][1]==2){
                        carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/incorrecto_capacidadesparaelaprendizaje.zip");
                        bm = BitmapFactory.decodeFile(String.valueOf(carga));
                        imagenguia9=(ImageView)findViewById(R.id.respuesta2_pantalla11_capacidadesparaelaprendizaje);
                        imagenguia9.setImageBitmap(bm);
                    }
                    if(preguntas9[6][1]==3){
                        carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/incorrecto_capacidadesparaelaprendizaje.zip");
                        bm = BitmapFactory.decodeFile(String.valueOf(carga));
                        imagenguia9=(ImageView)findViewById(R.id.respuesta3_pantalla11_capacidadesparaelaprendizaje);
                        imagenguia9.setImageBitmap(bm);
                    }
                    if(preguntas9[6][1]==4){
                        carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/correcto_capacidadesparaelaprendizaje.zip");
                        bm = BitmapFactory.decodeFile(String.valueOf(carga));
                        imagenguia9=(ImageView)findViewById(R.id.respuesta4_pantalla11_capacidadesparaelaprendizaje);
                        imagenguia9.setImageBitmap(bm);
                    }
                }
                break;
            case R.id.anterior_pantalla11_capacidadesparaelaprendizaje:
                ventana_capacidades--;
                validaVentana9();
                if(preguntas9[5][0]!=0){
                    if(preguntas9[5][0]==1){
                        carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/incorrecto_capacidadesparaelaprendizaje.zip");
                        bm = BitmapFactory.decodeFile(String.valueOf(carga));
                        imagenguia9=(ImageView)findViewById(R.id.respuesta1_pantalla10_capacidadesparaelaprendizaje);
                        imagenguia9.setImageBitmap(bm);
                    }
                    if(preguntas9[5][0]==2){
                        carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/incorrecto_capacidadesparaelaprendizaje.zip");
                        bm = BitmapFactory.decodeFile(String.valueOf(carga));
                        imagenguia9=(ImageView)findViewById(R.id.respuesta2_pantalla10_capacidadesparaelaprendizaje);
                        imagenguia9.setImageBitmap(bm);
                    }
                    if(preguntas9[5][0]==3){
                        carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/correcto_capacidadesparaelaprendizaje.zip");
                        bm = BitmapFactory.decodeFile(String.valueOf(carga));
                        imagenguia9=(ImageView)findViewById(R.id.respuesta3_pantalla10_capacidadesparaelaprendizaje);
                        imagenguia9.setImageBitmap(bm);
                    }
                    if(preguntas9[5][0]==4){
                        carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/incorrecto_capacidadesparaelaprendizaje.zip");
                        bm = BitmapFactory.decodeFile(String.valueOf(carga));
                        imagenguia9=(ImageView)findViewById(R.id.respuesta4_pantalla10_capacidadesparaelaprendizaje);
                        imagenguia9.setImageBitmap(bm);
                    }
                }
                break;
            case R.id.siguiente_pantalla11_capacidadesparaelaprendizaje:
                ventana_capacidades++;
                validaVentana9();
                if(preguntas9[0][0]!=0 && preguntas9[1][0]!=0 && preguntas9[2][0]!=0 && preguntas9[3][0]!=0 && preguntas9[4][0]!=0 && preguntas9[4][1]!=0 && preguntas9[5][0]!=0 && preguntas9[6][0]!=0 && preguntas9[6][1]!=0){
                    if(mensaje9==false){
                        Toast.makeText(MainActivity.this, nombre1+". Tienes un total de: "+correctas9+"/7 respuestas correctas", Toast.LENGTH_LONG).show();
                        mensaje9=true;
                    }
                }
                else{
                    Toast.makeText(MainActivity.this, "Por favor termina de resolver todas las preguntas", Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.anterior_pantalla12_capacidadesparaelaprendizaje:
                ventana_capacidades--;
                validaVentana9();
                if(preguntas9[6][0]!=0){
                    if(preguntas9[6][0]==1){
                        carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/correcto_capacidadesparaelaprendizaje.zip");
                        bm = BitmapFactory.decodeFile(String.valueOf(carga));
                        imagenguia9=(ImageView)findViewById(R.id.respuesta1_pantalla11_capacidadesparaelaprendizaje);
                        imagenguia9.setImageBitmap(bm);
                    }
                    if(preguntas9[6][0]==2){
                        carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/incorrecto_capacidadesparaelaprendizaje.zip");
                        bm = BitmapFactory.decodeFile(String.valueOf(carga));
                        imagenguia9=(ImageView)findViewById(R.id.respuesta2_pantalla11_capacidadesparaelaprendizaje);
                        imagenguia9.setImageBitmap(bm);
                    }
                    if(preguntas9[6][0]==3){
                        carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/incorrecto_capacidadesparaelaprendizaje.zip");
                        bm = BitmapFactory.decodeFile(String.valueOf(carga));
                        imagenguia9=(ImageView)findViewById(R.id.respuesta3_pantalla11_capacidadesparaelaprendizaje);
                        imagenguia9.setImageBitmap(bm);
                    }
                    if(preguntas9[6][0]==4){
                        carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/correcto_capacidadesparaelaprendizaje.zip");
                        bm = BitmapFactory.decodeFile(String.valueOf(carga));
                        imagenguia9=(ImageView)findViewById(R.id.respuesta4_pantalla11_capacidadesparaelaprendizaje);
                        imagenguia9.setImageBitmap(bm);
                    }
                    if(preguntas9[6][1]==1){
                        carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/correcto_capacidadesparaelaprendizaje.zip");
                        bm = BitmapFactory.decodeFile(String.valueOf(carga));
                        imagenguia9=(ImageView)findViewById(R.id.respuesta1_pantalla11_capacidadesparaelaprendizaje);
                        imagenguia9.setImageBitmap(bm);
                    }
                    if(preguntas9[6][1]==2){
                        carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/incorrecto_capacidadesparaelaprendizaje.zip");
                        bm = BitmapFactory.decodeFile(String.valueOf(carga));
                        imagenguia9=(ImageView)findViewById(R.id.respuesta2_pantalla11_capacidadesparaelaprendizaje);
                        imagenguia9.setImageBitmap(bm);
                    }
                    if(preguntas9[6][1]==3){
                        carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/incorrecto_capacidadesparaelaprendizaje.zip");
                        bm = BitmapFactory.decodeFile(String.valueOf(carga));
                        imagenguia9=(ImageView)findViewById(R.id.respuesta3_pantalla11_capacidadesparaelaprendizaje);
                        imagenguia9.setImageBitmap(bm);
                    }
                    if(preguntas9[6][1]==4){
                        carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/correcto_capacidadesparaelaprendizaje.zip");
                        bm = BitmapFactory.decodeFile(String.valueOf(carga));
                        imagenguia9=(ImageView)findViewById(R.id.respuesta4_pantalla11_capacidadesparaelaprendizaje);
                        imagenguia9.setImageBitmap(bm);
                    }
                }
                break;
            case R.id.siguiente_pantalla12_capacidadesparaelaprendizaje:
                ventana_capacidades++;
                validaVentana9();
                break;
            case R.id.anterior_pantalla13_capacidadesparaelaprendizaje:
                ventana_capacidades--;
                validaVentana9();
                break;
            case R.id.siguiente_pantalla13_capacidadesparaelaprendizaje:
                ventana_capacidades++;
                validaVentana9();
                break;
            case R.id.menu_pantallas2_capacidadesparaelaprendizaje:
                Toast.makeText(MainActivity.this, "No se a donde debe mandar este boton. Atte: CuceiMobile", Toast.LENGTH_LONG).show();
                break;
            case R.id.opcion1_pantalla5_capacidadesparaelaprendizaje:
                if(preguntas9[0][0]==0){
                    correctas9++;
                    preguntas9[0][0]=1;
                    carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/correcto_capacidadesparaelaprendizaje.zip");
                    bm = BitmapFactory.decodeFile(String.valueOf(carga));
                    imagenguia9=(ImageView)findViewById(R.id.respuesta1_pantalla5_capacidadesparaelaprendizaje);
                    imagenguia9.setImageBitmap(bm);
                }
                break;
            case R.id.opcion2_pantalla5_capacidadesparaelaprendizaje:
                if(preguntas9[0][0]==0){
                    preguntas9[0][0]=2;
                    carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/incorrecto_capacidadesparaelaprendizaje.zip");
                    bm = BitmapFactory.decodeFile(String.valueOf(carga));
                    imagenguia9=(ImageView)findViewById(R.id.respuesta2_pantalla5_capacidadesparaelaprendizaje);
                    imagenguia9.setImageBitmap(bm);
                }
                break;
            case R.id.opcion3_pantalla5_capacidadesparaelaprendizaje:
                if(preguntas9[0][0]==0){
                    preguntas9[0][0]=3;
                    carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/incorrecto_capacidadesparaelaprendizaje.zip");
                    bm = BitmapFactory.decodeFile(String.valueOf(carga));
                    imagenguia9=(ImageView)findViewById(R.id.respuesta3_pantalla5_capacidadesparaelaprendizaje);
                    imagenguia9.setImageBitmap(bm);
                }
                break;
            case R.id.opcion4_pantalla5_capacidadesparaelaprendizaje:
                if(preguntas9[0][0]==0){
                    preguntas9[0][0]=4;
                    carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/incorrecto_capacidadesparaelaprendizaje.zip");
                    bm = BitmapFactory.decodeFile(String.valueOf(carga));
                    imagenguia9=(ImageView)findViewById(R.id.respuesta4_pantalla5_capacidadesparaelaprendizaje);
                    imagenguia9.setImageBitmap(bm);
                }
                break;
            case R.id.opcion1_pantalla6_capacidadesparaelaprendizaje:
                if(preguntas9[1][0]==0){
                    preguntas9[1][0]=1;
                    carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/incorrecto_capacidadesparaelaprendizaje.zip");
                    bm = BitmapFactory.decodeFile(String.valueOf(carga));
                    imagenguia9=(ImageView)findViewById(R.id.respuesta1_pantalla6_capacidadesparaelaprendizaje);
                    imagenguia9.setImageBitmap(bm);
                }
                break;
            case R.id.opcion2_pantalla6_capacidadesparaelaprendizaje:
                if(preguntas9[1][0]==0){
                    correctas9++;
                    preguntas9[1][0]=2;
                    carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/correcto_capacidadesparaelaprendizaje.zip");
                    bm = BitmapFactory.decodeFile(String.valueOf(carga));
                    imagenguia9=(ImageView)findViewById(R.id.respuesta2_pantalla6_capacidadesparaelaprendizaje);
                    imagenguia9.setImageBitmap(bm);
                }
                break;
            case R.id.opcion3_pantalla6_capacidadesparaelaprendizaje:
                if(preguntas9[1][0]==0){
                    preguntas9[1][0]=3;
                    carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/incorrecto_capacidadesparaelaprendizaje.zip");
                    bm = BitmapFactory.decodeFile(String.valueOf(carga));
                    imagenguia9=(ImageView)findViewById(R.id.respuesta3_pantalla6_capacidadesparaelaprendizaje);
                    imagenguia9.setImageBitmap(bm);
                }
                break;
            case R.id.opcion4_pantalla6_capacidadesparaelaprendizaje:
                if(preguntas9[1][0]==0){
                    preguntas9[1][0]=4;
                    carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/incorrecto_capacidadesparaelaprendizaje.zip");
                    bm = BitmapFactory.decodeFile(String.valueOf(carga));
                    imagenguia9=(ImageView)findViewById(R.id.respuesta4_pantalla6_capacidadesparaelaprendizaje);
                    imagenguia9.setImageBitmap(bm);
                }
                break;
            case R.id.opcion1_pantalla7_capacidadesparaelaprendizaje:
                if(preguntas9[2][0]==0){
                    preguntas9[2][0]=1;
                    carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/incorrecto_capacidadesparaelaprendizaje.zip");
                    bm = BitmapFactory.decodeFile(String.valueOf(carga));
                    imagenguia9=(ImageView)findViewById(R.id.respuesta1_pantalla7_capacidadesparaelaprendizaje);
                    imagenguia9.setImageBitmap(bm);
                }
                break;
            case R.id.opcion2_pantalla7_capacidadesparaelaprendizaje:
                if(preguntas9[2][0]==0){
                    correctas9++;
                    preguntas9[2][0]=2;
                    carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/correcto_capacidadesparaelaprendizaje.zip");
                    bm = BitmapFactory.decodeFile(String.valueOf(carga));
                    imagenguia9=(ImageView)findViewById(R.id.respuesta2_pantalla7_capacidadesparaelaprendizaje);
                    imagenguia9.setImageBitmap(bm);
                }
                break;
            case R.id.opcion3_pantalla7_capacidadesparaelaprendizaje:
                if(preguntas9[2][0]==0){
                    preguntas9[2][0]=3;
                    carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/incorrecto_capacidadesparaelaprendizaje.zip");
                    bm = BitmapFactory.decodeFile(String.valueOf(carga));
                    imagenguia9=(ImageView)findViewById(R.id.respuesta3_pantalla7_capacidadesparaelaprendizaje);
                    imagenguia9.setImageBitmap(bm);
                }
                break;
            case R.id.opcion4_pantalla7_capacidadesparaelaprendizaje:
                if(preguntas9[2][0]==0){
                    preguntas9[2][0]=4;
                    carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/incorrecto_capacidadesparaelaprendizaje.zip");
                    bm = BitmapFactory.decodeFile(String.valueOf(carga));
                    imagenguia9=(ImageView)findViewById(R.id.respuesta4_pantalla7_capacidadesparaelaprendizaje);
                    imagenguia9.setImageBitmap(bm);
                }
                break;
            case R.id.opcion1_pantalla8_capacidadesparaelaprendizaje:
                if(preguntas9[3][0]==0){
                    correctas9++;
                    preguntas9[3][0]=1;
                    carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/correcto_capacidadesparaelaprendizaje.zip");
                    bm = BitmapFactory.decodeFile(String.valueOf(carga));
                    imagenguia9=(ImageView)findViewById(R.id.respuesta1_pantalla8_capacidadesparaelaprendizaje);
                    imagenguia9.setImageBitmap(bm);
                }
                break;
            case R.id.opcion2_pantalla8_capacidadesparaelaprendizaje:
                if(preguntas9[3][0]==0){
                    preguntas9[3][0]=2;
                    carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/incorrecto_capacidadesparaelaprendizaje.zip");
                    bm = BitmapFactory.decodeFile(String.valueOf(carga));
                    imagenguia9=(ImageView)findViewById(R.id.respuesta2_pantalla8_capacidadesparaelaprendizaje);
                    imagenguia9.setImageBitmap(bm);
                }
                break;
            case R.id.opcion3_pantalla8_capacidadesparaelaprendizaje:
                if(preguntas9[3][0]==0){
                    preguntas9[3][0]=3;
                    carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/incorrecto_capacidadesparaelaprendizaje.zip");
                    bm = BitmapFactory.decodeFile(String.valueOf(carga));
                    imagenguia9=(ImageView)findViewById(R.id.respuesta3_pantalla8_capacidadesparaelaprendizaje);
                    imagenguia9.setImageBitmap(bm);
                }
                break;
            case R.id.opcion4_pantalla8_capacidadesparaelaprendizaje:
                if(preguntas9[3][0]==0){
                    preguntas9[3][0]=4;
                    carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/incorrecto_capacidadesparaelaprendizaje.zip");
                    bm = BitmapFactory.decodeFile(String.valueOf(carga));
                    imagenguia9=(ImageView)findViewById(R.id.respuesta4_pantalla8_capacidadesparaelaprendizaje);
                    imagenguia9.setImageBitmap(bm);
                }
                break;
            case R.id.opcion1_pantalla9_capacidadesparaelaprendizaje:
                if(preguntas9[4][0]==0){
                    correctas9+=0.5;
                    preguntas9[4][0]=1;
                    carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/correcto_capacidadesparaelaprendizaje.zip");
                    bm = BitmapFactory.decodeFile(String.valueOf(carga));
                    imagenguia9=(ImageView)findViewById(R.id.respuesta1_pantalla9_capacidadesparaelaprendizaje);
                    imagenguia9.setImageBitmap(bm);
                }
                else{
                    if(preguntas9[4][1]==0){
                        if(preguntas9[4][0]!=1){
                            correctas9+=0.5;
                            preguntas9[4][1]=1;
                            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/correcto_capacidadesparaelaprendizaje.zip");
                            bm = BitmapFactory.decodeFile(String.valueOf(carga));
                            imagenguia9=(ImageView)findViewById(R.id.respuesta1_pantalla9_capacidadesparaelaprendizaje);
                            imagenguia9.setImageBitmap(bm);
                        }
                    }
                }
                break;
            case R.id.opcion2_pantalla9_capacidadesparaelaprendizaje:
                if(preguntas9[4][0]==0){
                    correctas9+=0.5;
                    preguntas9[4][0]=2;
                    carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/correcto_capacidadesparaelaprendizaje.zip");
                    bm = BitmapFactory.decodeFile(String.valueOf(carga));
                    imagenguia9=(ImageView)findViewById(R.id.respuesta2_pantalla9_capacidadesparaelaprendizaje);
                    imagenguia9.setImageBitmap(bm);
                }
                else{
                    if(preguntas9[4][1]==0){
                        if(preguntas9[4][0]!=2){
                            correctas9+=0.5;
                            preguntas9[4][1]=2;
                            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/correcto_capacidadesparaelaprendizaje.zip");
                            bm = BitmapFactory.decodeFile(String.valueOf(carga));
                            imagenguia9=(ImageView)findViewById(R.id.respuesta2_pantalla9_capacidadesparaelaprendizaje);
                            imagenguia9.setImageBitmap(bm);
                        }
                    }
                }
                break;
            case R.id.opcion3_pantalla9_capacidadesparaelaprendizaje:
                if(preguntas9[4][0]==0){
                    preguntas9[4][0]=3;
                    carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/incorrecto_capacidadesparaelaprendizaje.zip");
                    bm = BitmapFactory.decodeFile(String.valueOf(carga));
                    imagenguia9=(ImageView)findViewById(R.id.respuesta3_pantalla9_capacidadesparaelaprendizaje);
                    imagenguia9.setImageBitmap(bm);
                }
                else{
                    if(preguntas9[4][1]==0){
                        if(preguntas9[4][0]!=3){
                            preguntas9[4][1]=3;
                            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/incorrecto_capacidadesparaelaprendizaje.zip");
                            bm = BitmapFactory.decodeFile(String.valueOf(carga));
                            imagenguia9=(ImageView)findViewById(R.id.respuesta3_pantalla9_capacidadesparaelaprendizaje);
                            imagenguia9.setImageBitmap(bm);
                        }
                    }
                }
                break;
            case R.id.opcion4_pantalla9_capacidadesparaelaprendizaje:
                if(preguntas9[4][0]==0){
                    preguntas9[4][0]=4;
                    carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/incorrecto_capacidadesparaelaprendizaje.zip");
                    bm = BitmapFactory.decodeFile(String.valueOf(carga));
                    imagenguia9=(ImageView)findViewById(R.id.respuesta4_pantalla9_capacidadesparaelaprendizaje);
                    imagenguia9.setImageBitmap(bm);
                }
                else{
                    if(preguntas9[4][1]==0){
                        if(preguntas9[4][0]!=4){
                            preguntas9[4][1]=4;
                            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/incorrecto_capacidadesparaelaprendizaje.zip");
                            bm = BitmapFactory.decodeFile(String.valueOf(carga));
                            imagenguia9=(ImageView)findViewById(R.id.respuesta4_pantalla9_capacidadesparaelaprendizaje);
                            imagenguia9.setImageBitmap(bm);
                        }
                    }
                }
                break;
            case R.id.opcion1_pantalla10_capacidadesparaelaprendizaje:
                if(preguntas9[5][0]==0){
                    preguntas9[5][0]=1;
                    carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/incorrecto_capacidadesparaelaprendizaje.zip");
                    bm = BitmapFactory.decodeFile(String.valueOf(carga));
                    imagenguia9=(ImageView)findViewById(R.id.respuesta1_pantalla10_capacidadesparaelaprendizaje);
                    imagenguia9.setImageBitmap(bm);
                }
                break;
            case R.id.opcion2_pantalla10_capacidadesparaelaprendizaje:
                if(preguntas9[5][0]==0){
                    preguntas9[5][0]=2;
                    carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/incorrecto_capacidadesparaelaprendizaje.zip");
                    bm = BitmapFactory.decodeFile(String.valueOf(carga));
                    imagenguia9=(ImageView)findViewById(R.id.respuesta2_pantalla10_capacidadesparaelaprendizaje);
                    imagenguia9.setImageBitmap(bm);
                }
                break;
            case R.id.opcion3_pantalla10_capacidadesparaelaprendizaje:
                if(preguntas9[5][0]==0){
                    correctas9++;
                    preguntas9[5][0]=3;
                    carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/correcto_capacidadesparaelaprendizaje.zip");
                    bm = BitmapFactory.decodeFile(String.valueOf(carga));
                    imagenguia9=(ImageView)findViewById(R.id.respuesta3_pantalla10_capacidadesparaelaprendizaje);
                    imagenguia9.setImageBitmap(bm);
                }
                break;
            case R.id.opcion4_pantalla10_capacidadesparaelaprendizaje:
                if(preguntas9[5][0]==0){
                    preguntas9[5][0]=4;
                    carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/incorrecto_capacidadesparaelaprendizaje.zip");
                    bm = BitmapFactory.decodeFile(String.valueOf(carga));
                    imagenguia9=(ImageView)findViewById(R.id.respuesta4_pantalla10_capacidadesparaelaprendizaje);
                    imagenguia9.setImageBitmap(bm);
                }
                break;
            case R.id.opcion1_pantalla11_capacidadesparaelaprendizaje:
                if(preguntas9[6][0]==0){
                    correctas9+=0.5;
                    preguntas9[6][0]=1;
                    carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/correcto_capacidadesparaelaprendizaje.zip");
                    bm = BitmapFactory.decodeFile(String.valueOf(carga));
                    imagenguia9=(ImageView)findViewById(R.id.respuesta1_pantalla11_capacidadesparaelaprendizaje);
                    imagenguia9.setImageBitmap(bm);
                }
                else{
                    if(preguntas9[6][1]==0){
                        if(preguntas9[6][0]!=1){
                            correctas9+=0.5;
                            preguntas9[6][1]=1;
                            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/correcto_capacidadesparaelaprendizaje.zip");
                            bm = BitmapFactory.decodeFile(String.valueOf(carga));
                            imagenguia9=(ImageView)findViewById(R.id.respuesta1_pantalla11_capacidadesparaelaprendizaje);
                            imagenguia9.setImageBitmap(bm);
                        }
                    }
                }
                break;
            case R.id.opcion2_pantalla11_capacidadesparaelaprendizaje:
                if(preguntas9[6][0]==0){
                    preguntas9[6][0]=2;
                    carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/incorrecto_capacidadesparaelaprendizaje.zip");
                    bm = BitmapFactory.decodeFile(String.valueOf(carga));
                    imagenguia9=(ImageView)findViewById(R.id.respuesta2_pantalla11_capacidadesparaelaprendizaje);
                    imagenguia9.setImageBitmap(bm);
                }
                else{
                    if(preguntas9[6][1]==0){
                        if(preguntas9[6][0]!=2){
                            preguntas9[6][1]=2;
                            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/incorrecto_capacidadesparaelaprendizaje.zip");
                            bm = BitmapFactory.decodeFile(String.valueOf(carga));
                            imagenguia9=(ImageView)findViewById(R.id.respuesta2_pantalla11_capacidadesparaelaprendizaje);
                            imagenguia9.setImageBitmap(bm);
                        }
                    }
                }
                break;
            case R.id.opcion3_pantalla11_capacidadesparaelaprendizaje:
                if(preguntas9[6][0]==0){
                    preguntas9[6][0]=3;
                    carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/incorrecto_capacidadesparaelaprendizaje.zip");
                    bm = BitmapFactory.decodeFile(String.valueOf(carga));
                    imagenguia9=(ImageView)findViewById(R.id.respuesta3_pantalla11_capacidadesparaelaprendizaje);
                    imagenguia9.setImageBitmap(bm);
                }
                else{
                    if(preguntas9[6][1]==0){
                        if(preguntas9[6][0]!=3){
                            preguntas9[6][1]=3;
                            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/incorrecto_capacidadesparaelaprendizaje.zip");
                            bm = BitmapFactory.decodeFile(String.valueOf(carga));
                            imagenguia9=(ImageView)findViewById(R.id.respuesta3_pantalla11_capacidadesparaelaprendizaje);
                            imagenguia9.setImageBitmap(bm);
                        }
                    }
                }
                break;
            case R.id.opcion4_pantalla11_capacidadesparaelaprendizaje:
                if(preguntas9[6][0]==0){
                    correctas9+=0.5;
                    preguntas9[6][0]=4;
                    carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/correcto_capacidadesparaelaprendizaje.zip");
                    bm = BitmapFactory.decodeFile(String.valueOf(carga));
                    imagenguia9=(ImageView)findViewById(R.id.respuesta4_pantalla11_capacidadesparaelaprendizaje);
                    imagenguia9.setImageBitmap(bm);
                }
                else{
                    if(preguntas9[6][1]==0){
                        if(preguntas9[6][0]!=4){
                            correctas9+=0.5;
                            preguntas9[6][1]=4;
                            carga=Environment.getExternalStoragePublicDirectory(".estu@pp/guia9/correcto_capacidadesparaelaprendizaje.zip");
                            bm = BitmapFactory.decodeFile(String.valueOf(carga));
                            imagenguia9=(ImageView)findViewById(R.id.respuesta4_pantalla11_capacidadesparaelaprendizaje);
                            imagenguia9.setImageBitmap(bm);
                        }
                    }
                }
                break;
            case R.id.comenzar_habilidadesdelectura:
                ventana_habilidadesdelectura++;
                validaVentana10();
                getSupportActionBar().setSubtitle("Habilidades de lectura");
                break;
            case R.id.anterior_pantalla2_habilidadesdelectura:
                ventana_habilidadesdelectura--;
                validaVentana10();
                getSupportActionBar().setSubtitle("Guía de Habilidades para el Aprendizaje");
                break;
            case R.id.siguiente_pantalla2_habilidadesdelectura:
                ventana_habilidadesdelectura++;
                validaVentana10();
                break;
            case R.id.anterior_pantalla3_habilidadesdelectura:
                ventana_habilidadesdelectura--;
                validaVentana10();
                break;
            case R.id.siguiente_pantalla3_habilidadesdelectura:
                ventana_habilidadesdelectura++;
                validaVentana10();
                break;
            case R.id.anterior_pantalla4_habilidadesdelectura:
                ventana_habilidadesdelectura--;
                validaVentana10();
                break;
            case R.id.siguiente_pantalla4_habilidadesdelectura:
                ventana_habilidadesdelectura++;
                validaVentana10();
                break;
            case R.id.anterior_pantalla5_habilidadesdelectura:
                ventana_habilidadesdelectura--;
                validaVentana10();
                break;
            case R.id.siguiente_pantalla5_habilidadesdelectura:
                ventana_habilidadesdelectura++;
                validaVentana10();
                break;
            case R.id.anterior_pantalla6_habilidadesdelectura:
                ventana_habilidadesdelectura--;
                validaVentana10();
                break;
            case R.id.siguiente_pantalla6_habilidadesdelectura:
                ventana_habilidadesdelectura++;
                validaVentana10();
                break;
            case R.id.anterior_pantalla7_habilidadesdelectura:
                ventana_habilidadesdelectura--;
                validaVentana10();
                break;
            case R.id.siguiente_pantalla7_habilidadesdelectura:
                ventana_habilidadesdelectura++;
                validaVentana10();
                break;
            case R.id.anterior_pantalla8_habilidadesdelectura:
                ventana_habilidadesdelectura--;
                validaVentana10();
                break;
            case R.id.siguiente_pantalla8_habilidadesdelectura:
                ventana_habilidadesdelectura++;
                validaVentana10();
                break;
            case R.id.anterior_pantalla9_habilidadesdelectura:
                ventana_habilidadesdelectura--;
                validaVentana10();
                break;
            case R.id.siguiente_pantalla9_habilidadesdelectura:
                ventana_habilidadesdelectura++;
                validaVentana10();
                break;
            case R.id.anterior_pantalla10_habilidadesdelectura:
                ventana_habilidadesdelectura--;
                validaVentana10();
                break;
            case R.id.siguiente_pantalla10_habilidadesdelectura:
                ventana_habilidadesdelectura++;
                validaVentana10();
                break;
            case R.id.anterior_pantalla11_habilidadesdelectura:
                ventana_habilidadesdelectura--;
                validaVentana10();
                break;
            case R.id.siguiente_pantalla11_habilidadesdelectura:
                ventana_habilidadesdelectura++;
                validaVentana10();
                break;
            case R.id.anterior_pantalla12_habilidadesdelectura:
                ventana_habilidadesdelectura--;
                validaVentana10();
                break;
            case R.id.siguiente_pantalla12_habilidadesdelectura:
                ventana_habilidadesdelectura++;
                validaVentana10();
                break;
            case R.id.anterior_pantalla13_habilidadesdelectura:
                ventana_habilidadesdelectura--;
                validaVentana10();
                break;
            case R.id.siguiente_pantalla13_habilidadesdelectura:
                ventana_habilidadesdelectura++;
                validaVentana10();
                break;
            case R.id.anterior_pantalla14_habilidadesdelectura:
                ventana_habilidadesdelectura--;
                validaVentana10();
                break;
            case R.id.siguiente_pantalla14_habilidadesdelectura:
                ventana_habilidadesdelectura++;
                validaVentana10();
                break;
            case R.id.anterior_pantalla15_habilidadesdelectura:
                ventana_habilidadesdelectura--;
                validaVentana10();
                break;
            case R.id.siguiente_pantalla15_habilidadesdelectura:
                ventana_habilidadesdelectura++;
                validaVentana10();
                break;
            case R.id.anterior_pantalla16_habilidadesdelectura:
                ventana_habilidadesdelectura--;
                validaVentana10();
                break;
            case R.id.siguiente_pantalla16_habilidadesdelectura:
                ventana_habilidadesdelectura++;
                validaVentana10();
                break;
            case R.id.anterior_pantalla17_habilidadesdelectura:
                ventana_habilidadesdelectura--;
                validaVentana10();
                break;
            case R.id.siguiente_pantalla17_habilidadesdelectura:
                ventana_habilidadesdelectura++;
                validaVentana10();
                break;
            case R.id.anterior_pantalla18_habilidadesdelectura:
                ventana_habilidadesdelectura--;
                validaVentana10();
                break;
            case R.id.imagen6_pantalla2_datosnumericos:
                guia=false;
                setContentView(R.layout.guias);
                numguia=0;
                titulo(numguia);
                break;
            case R.id.introduccion_datosnumericos:
                ventana_datosnum++;
                validaVentana8();
                break;
            case R.id.porcentajes_datosnumericos:
                ventana_datosnum=4;
                validaVentana8();
                break;
            case R.id.graficas_datosnumericos:
                ventana_datosnum=7;
                validaVentana8();
                break;
            case R.id.histograma_datosnumericos:
                ventana_datosnum=10;
                validaVentana8();
                break;
            case R.id.autoevaluacion_datosnumericos:
                ventana_datosnum=13;
                validaVentana8();
                break;
            case R.id.imagen4_pantalla28_datosnumericos:
                ventana_datosnum=2;
                validaVentana8();
                break;
            case R.id.imagen3_pantalla28_datosnumericos:
                ventana_datosnum=29;
                validaVentana8();
                break;
            //BOTONES GUIA 7 IMPORTANCIA DEL INGLES
            case R.id.comenzar_importanciadelingles:
                ventana_importanciadelingles++;
                validaVentana7();
                getSupportActionBar().setSubtitle("Importancia del idioma Inglés");
                break;
            case R.id.anterior_pantalla2_importanciadelingles:
                ventana_importanciadelingles--;
                validaVentana7();
                titulo(numguia);
                break;
            case R.id.siguiente_pantalla2_importanciadelingles:
                ventana_importanciadelingles++;
                validaVentana7();
                break;
            case R.id.anterior_pantalla3_importanciadelingles:
                ventana_importanciadelingles--;
                validaVentana7();
                break;
            case R.id.siguiente_pantalla3_importanciadelingles:
                ventana_importanciadelingles++;
                validaVentana7();
                break;
            case R.id.anterior_pantalla4_importanciadelingles:
                ventana_importanciadelingles--;
                validaVentana7();
                break;
            case R.id.siguiente_pantalla4_importanciadelingles:
                ventana_importanciadelingles++;
                validaVentana7();
                break;
            case R.id.anterior_pantalla5_importanciadelingles:
                ventana_importanciadelingles--;
                validaVentana7();
                break;
            case R.id.salir_importanciadelingles:
            setContentView(R.layout.guias);
            guia = false;
            numguia=0;
            titulo(numguia);
            break;
        }
    }
}
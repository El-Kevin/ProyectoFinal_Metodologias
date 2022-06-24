package ec.edu.epn.Facade;

import Archivo.ManipularArchivo;
import ec.edu.epn.Citas.CitaMedica;
import ec.edu.epn.Manejador.ManejadorCita;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        ManipularArchivo archivo = new ManipularArchivo();
        String path ="C:\\Users\\Public\\Documents\\ProyectoFinal_Metodologias\\src\\main\\resources\\dataUsuario.csv";

        ArrayList<CitaMedica> listaCita = new ArrayList<CitaMedica>();
        CitaMedica cita = new CitaMedica("hola","mundo","hola","hola","hola","hola",false);
        CitaMedica cita0 = new CitaMedica("hxcvola","mundsdfo","holay","hrola","ho,jla","holaad",true);
        CitaMedica cita1 = new CitaMedica("holxcva","mundfdbo","holah","hobla","honfgla","hocxvdla",true);
        CitaMedica cita2 = new CitaMedica("holxdsfa","munddfbo","holae","holsa","horla","hregola",false);
        listaCita.add(cita);
        listaCita.add(cita0);
        listaCita.add(cita1);
        listaCita.add(cita2);

        archivo.leerArchivoCita();
       // archivo.escribirAchivo(path, listaCita);
    }
    }


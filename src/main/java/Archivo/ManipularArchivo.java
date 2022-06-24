package Archivo;

import ec.edu.epn.Citas.CitaMedica;
import ec.edu.epn.Usuario.Paciente;

import java.io.*;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Scanner;

public class ManipularArchivo {
    private BufferedReader lector;
    private String linea;
    private String partes[];
    String path ="C:\\Users\\Public\\Documents\\ProyectoFinal_Metodologias\\src\\main\\resources\\dataUsuario.csv";

    public void leerArchivoCita(){
        ArrayList<CitaMedica> listaCita = new ArrayList<CitaMedica>();
        CitaMedica cita;
        String datos[];

        try{
            Scanner scFile = new Scanner(new File(path));
            while(scFile.hasNextLine()){
                datos = scFile.nextLine().split(",");
                cita = new CitaMedica(datos[0],datos[1],datos[2],datos[3],datos[4],datos[5],Boolean.parseBoolean(datos[6]));
                listaCita.add(cita);
            }
        }catch (Exception e){
                System.out.println(e);
        }
        for(CitaMedica lista: listaCita){
            System.out.println(lista);

        }
    }

    public void escribirAchivo(ArrayList<CitaMedica> listaCita){
        File f = new File(path);
            if (f.exists()){
                f.delete();
            }
        try{
            FileWriter fw = new FileWriter(f,true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter printWriter = new PrintWriter(bw);


                for(CitaMedica cita:listaCita){
                    printWriter.println(cita.escribirCita());
            }
                printWriter.flush();
                printWriter.close();
        }catch(Exception e){
            System.out.println(e);
        }
    }
}


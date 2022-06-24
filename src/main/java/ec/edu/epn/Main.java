package ec.edu.epn;

import ec.edu.epn.Manejador.ManejadorUsuario;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hola pelotudos");
        System.out.println("Alucination");
        String pathFile = System.getProperty("user.dir") + "/src/main/resources/dataUsuario.json";
        System.out.println(pathFile);
        ManejadorUsuario manejadorUsuario = new ManejadorUsuario(pathFile);
//
//        try {
//            System.out.println(manejadorUsuario.leerArchivoUsuarios().get(0).getNumeroCedula());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        try {
            System.out.print("Enter Username: ");
            InputStreamReader streamReader = new InputStreamReader(System.in);
            BufferedReader bufferedReader = new BufferedReader(streamReader);
            String username = bufferedReader.readLine();
            System.out.println("Your username is : " + username );

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

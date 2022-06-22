package ec.edu.epn;

import ec.edu.epn.Manejador.ManejadorUsuario;

import java.util.Scanner;

public class Main {
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        System.out.println("Hola pelotudos");
        System.out.println("Alucination");
        String pathFile = System.getProperty("user.dir") + "/src/main/resources/dataUsuario.json";
        System.out.println(pathFile);
//        ManejadorUsuario manejadorUsuario = new ManejadorUsuario(pathFile);
//
//        try {
//            System.out.println(manejadorUsuario.leerArchivoUsuarios().get(0).getNumeroCedula());
//        } catch (Exception e){
//            e.printStackTrace();
//        }
        System.out.println("Ingrese algo");
        String letter = sc.nextLine();
        System.out.println(letter);
    }

}

package ec.edu.epn;

import ec.edu.epn.Facade.CLI;
import ec.edu.epn.Manejador.ManejadorUsuario;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, FileNotFoundException {

        System.out.println("***COMPILACIÓN ANTERIOR AL CAMBIO***");

        CLI cli = new CLI();
        cli.autenticarPacienteMedianteCedula();


    }
}

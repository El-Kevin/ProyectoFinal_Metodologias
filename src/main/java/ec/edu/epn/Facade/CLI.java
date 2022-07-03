package ec.edu.epn.Facade;

import ec.edu.epn.Citas.CitaMedica;
import ec.edu.epn.Manejador.ManejadorUsuario;
import ec.edu.epn.Usuario.Paciente;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class CLI {
    private boolean claveAutenticada;
    private CitaMedica citaMedica;
    private ManejadorUsuario mu = new ManejadorUsuario(System.getProperty("user.dir") + "/src/main/resources/dataUsuario.json");

    public boolean autenticarPacienteMedianteCedula() throws FileNotFoundException {

        String numeroCedula = "0707079653";
        String password = "2020";
        System.out.println("Ingrese su numero de cedula");
        System.out.println(numeroCedula);
        System.out.println("Ingrese su contrasenia");
        System.out.println("2020");
        ArrayList<Paciente> pacientes = mu.leerArchivoUsuarios();
        for (Paciente p : pacientes
             ) {

            if (p.getNumeroCedula().equals(numeroCedula) && p.getClave().equals(password)) {
                System.out.println("El usuario se ha autenticado exitosamente");
                return true;
            }
        }
        System.out.println("No se ha podido autenticar el paciente");
        return false;
    }

    public void agendarCita(String numeroDeCedula) throws IOException {
    }

    public void cancelarCita(String numeroDeCedula) throws IOException {

    }
}

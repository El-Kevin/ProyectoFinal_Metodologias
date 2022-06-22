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
;
    public boolean autenticarPacienteMedianteCedula() throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        String numeroCedula;
        String password;
        System.out.println("Ingrese su numero de cedula");
        numeroCedula = sc.nextLine();
        System.out.println("Ingrese su contrasenia");
        password = sc.nextLine();
        ArrayList<Paciente> pacientes = mu.leerArchivoUsuarios();
        for (Paciente p : pacientes
             ) {

            if (p.getNumeroCedula().equals(numeroCedula) && p.getClave().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public void agendarCita(String numeroDeCedula) throws IOException {
    }

    public void cancelarCita(String numeroDeCedula) throws IOException {

    }
}

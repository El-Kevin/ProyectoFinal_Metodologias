package ec.edu.epn.Facade;

import ec.edu.epn.Citas.CitaMedica;
import ec.edu.epn.Manejador.ManejadorCita;
import ec.edu.epn.Manejador.ManejadorUsuario;
import ec.edu.epn.Usuario.Admin;
import ec.edu.epn.Usuario.Paciente;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class CLI {
    private boolean claveAutenticada;
    private CitaMedica citaMedica;
    private Admin admin;
    private ManejadorUsuario mu = new ManejadorUsuario(System.getProperty("user.dir") + "/src/main/resources/dataUsuario.json");
;

    String directorioCitas = System.getProperty("user.dir") + "\\src\\resources\\dataCita.json";
    ManejadorCita manejadorCita = new ManejadorCita(directorioCitas);
    public boolean autenticarPacienteMedianteCedula(String numeroCedula, String password) throws FileNotFoundException {
        ArrayList<Paciente> pacientes = mu.leerArchivoUsuarios();
        for (Paciente p : pacientes
             ) {
            System.out.println("cedula " + p.getNumeroCedula() + " password " + p.getClave());
            System.out.println("numeroCedula " + numeroCedula + " password " + password);
            if (p.getNumeroCedula().equals(numeroCedula) && p.getClave().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public void agendarCita(String numeroDeCedula) throws IOException {
        manejadorCita.reservarCita(numeroDeCedula);
    }

    public void cancelarCita(String numeroDeCedula) throws IOException {
        manejadorCita.eliminarCita(numeroDeCedula);
    }

    public void agregarCita(CitaMedica cita) throws IOException {
        admin.agregarRegistro(cita);
    }
}

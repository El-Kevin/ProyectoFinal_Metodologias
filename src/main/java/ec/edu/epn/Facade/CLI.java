package ec.edu.epn.Facade;

import ec.edu.epn.Citas.CitaMedica;

import java.io.FileNotFoundException;
import java.io.IOException;

public class CLI {
    private boolean claveAutenticada;
    private CitaMedica citaMedica;
    //cambiar el path del proyecto
    //String directorioUsuarios = System.getProperty("user.dir") + "\\src\\resources\\data.json";
    //String directorioCitas = System.getProperty("user.dir") + "\\src\\resources\\citas_data.json";
;
    public boolean verificarPaciente(String usuario, String password) throws FileNotFoundException {
        return true;
    }

    public void agendarCita(String numeroDeCedula) throws IOException {
    }

    public void cancelarCita(String numeroDeCedula) throws IOException {

    }
}

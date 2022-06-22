package ec.edu.epn.Facade;

import ec.edu.epn.Manejador.ManejadorCita;
import ec.edu.epn.Usuario.Paciente;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        String pathCita = System.getProperty("user.dir") + "\\src\\main\\resources\\dataCita.json";
        ManejadorCita m = new ManejadorCita(pathCita);
        m.reservarCita("1752331700");

        CLI cli = new CLI();
        String cedula = "1752331700";
        String clave = "Rammor123";
        Paciente paciente;

        cli.autenticarPacienteMedianteCedula(cedula, clave);
        //Reservar Cita
        cli.agendarCita(cedula);
        //Eliminar cita
        cli.cancelarCita(cedula);
        //
    }
}

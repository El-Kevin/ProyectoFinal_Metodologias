package ec.edu.epn.anthony;

import ec.edu.epn.Facade.CLI;
import ec.edu.epn.Usuario.Admin;
import ec.edu.epn.Usuario.Paciente;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.Assert.*;
public class CLITest {
    @Test
        public void givenNumeroCedula_Contrasenia_correctos_whenIniciaSesion_then_ok() throws IOException, FileNotFoundException {
            CLI cli = new CLI();
            //Paciente p = new Paciente("1752331700", "Kevin", "Toasa", "Caupicho", "Terapia", "Rammor123");
            Paciente p2 = new Paciente("0707079653", "Anthony", "Chamba", "La Ferroviaria", "DOLOR ESPALDA", "2020");
            assertTrue(cli.autenticarPacienteMedianteCedula());

        }
}

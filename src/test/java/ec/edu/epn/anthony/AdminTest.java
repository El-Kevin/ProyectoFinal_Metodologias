package ec.edu.epn.anthony;

import ec.edu.epn.Usuario.Admin;
import ec.edu.epn.Usuario.Paciente;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.Assert.*;

public class AdminTest {
   /* @Test
    public void givenAdminAccountNewUser_whenAddNewUser_thenRegisterUser() throws IOException, FileNotFoundException {
        IiniciarSesion is = Mockito.mock(IiniciarSesion.class);
        Paciente p = new Paciente("1752331700", "Kevin", "Toasa", "Caupicho", "Terapia", "Rammor123");
        Admin a = new Admin();
        Mockito.when(is.iniciarSesion(a.getId(), a.getContrasenia())).thenReturn(true);
        if (!a.getHaIniciadoSesion()) {
            a.setHaIniciadoSesion(is.iniciarSesion(a.getId(), a.getContrasenia()));
        }

        assertTrue(a.registrarUsuario(p));

    }*/
}
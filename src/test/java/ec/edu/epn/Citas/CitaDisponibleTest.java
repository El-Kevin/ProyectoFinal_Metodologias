package ec.edu.epn.Citas;

import ec.edu.epn.Manejador.ManejadorCita;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class CitaDisponibleTest {

    ArrayList<CitaMedica> listacita = new ArrayList<>();
    ArrayList<CitaMedica> expect = new ArrayList<>();
    public void charge_log(){

        CitaMedica cita0 = new CitaMedica("1752331700","Ginecologo","21/05/2022","Anthony","27/06/2022","001",true);
        CitaMedica cita1 = new CitaMedica("1752331700","Ginecologo","21/05/2022","Anthony","14/06/2022","002",false);
        CitaMedica cita2 = new CitaMedica("1752331700","Ginecologo","21/05/2022","Anthony","14/06/2022","003",true);
        CitaMedica cita3 = new CitaMedica("1752331700","Ginecologo","21/05/2022","Anthony","14/06/2022","004",false);
        listacita.add(cita0);
        listacita.add(cita1);
        listacita.add(cita2);
        listacita.add(cita3);
        expect.add(cita0);
        expect.add(cita2);
    }

    @Test
    public void given_three_appointments_when_search_then_ok(){
        CitaDisponible citaDisponible = new CitaDisponible();
        charge_log();
        ArrayList<CitaMedica> actual = citaDisponible.mostrarCitasDisponibles(listacita);
        assertEquals(expect,actual);
    }

    @Test
    public void given_one_appointments_when_calculatedaysrest_then_ok(){
        ManejadorCita citaDisponible = new ManejadorCita(System.getProperty("user.dir") + "\\src\\main\\resources\\dataCita.json");
        charge_log();
        int expect = 5;
        int actual = citaDisponible.calcularDiasFaltantes(listacita.get(0));
        assertEquals(expect,actual);
    }
}
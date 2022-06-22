package ec.edu.epn.Facade;

import ec.edu.epn.Manejador.ManejadorCita;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        ManejadorCita m = new ManejadorCita();
        m.reservarCita("1752331700");

    }
}

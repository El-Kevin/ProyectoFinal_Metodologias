package ec.edu.epn.Usuario;

import ec.edu.epn.Manejador.ManejadorUsuario;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Admin {
    //private String pathFile = System.getProperty("user.dir") + "/src/main/resources/dataUsuario.json";
    private boolean haIniciadoSesion;
    private String id;
    private String contrasenia;
    private ManejadorUsuario manejadorUsuario = new ManejadorUsuario("/var/lib/jenkins/workspace/Proyecto1B/src/main/resources/dataUsuario.json");


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }




    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }


    //public boolean iniciarSesion(){};

    public boolean registrarUsuario(Paciente p) throws FileNotFoundException, IOException {
        int numeroUsuariosPrevios = manejadorUsuario.leerArchivoUsuarios().size();
        System.out.println("Usuarios previos: " + numeroUsuariosPrevios);
        System.out.println("paciente 00 : " + manejadorUsuario.leerArchivoUsuarios().get(1).getNumeroCedula());
        manejadorUsuario.agregarUsuario(p);
        int numeroUsuariosPosteriores = manejadorUsuario.leerArchivoUsuarios().size();
        System.out.println("Usuarios posteriores: " + numeroUsuariosPrevios);
        return numeroUsuariosPosteriores - numeroUsuariosPrevios == 1;


    };

    public boolean getHaIniciadoSesion() {
        return haIniciadoSesion;
    }
    public void setHaIniciadoSesion(boolean haIniciadoSesion ){
        this.haIniciadoSesion = haIniciadoSesion;
    }



}

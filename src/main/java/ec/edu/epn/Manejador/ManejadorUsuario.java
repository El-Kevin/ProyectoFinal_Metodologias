package ec.edu.epn.Manejador;
//
//import ec.edu.epn.Usuario.Paciente;
//
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.util.ArrayList;
//
//public class ManejadorUsuario {
//
//    private String pathUsuarios;
//
//    public void sobreescribirArchivo(ArrayList<Paciente> dataList) throws IOException {
//    }
//
//    public ArrayList<Paciente> leerArchivoUsuarios() throws FileNotFoundException {
//        return null;
//    }
//
//    public Boolean comprobarRegistro(String Usuario, String password) throws FileNotFoundException {
//        return null;
//    }
//}


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import ec.edu.epn.Usuario.Paciente;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

/**
 * @author lmamc
 */
public class ManejadorUsuario {

    public ManejadorUsuario(String pathCitas) {
        this.pathCitas = pathCitas;
    }

    private String pathCitas;

    public ArrayList<Paciente> leerArchivoUsuarios() throws FileNotFoundException {
        // ScoreData is the array where we can read the core from file
        ArrayList<Paciente> pacientes = new ArrayList<>();
        File file = new File(pathCitas);
        // If the file is empty or is not exist return the dataList
        if (!file.exists() || file.length() == 0) {
            System.out.println("File does not exists or has 0 length");
            return pacientes;
        }
        // Start to parser
        JSONTokener parser = new JSONTokener(new FileInputStream(file));
        //Initial the JSONArray
        JSONArray jsonList = new JSONArray(parser);
//        System.out.println("NUMERO DE REGISTROS TOTALES: " + jsonList.length());
        for (int i = 0; i < jsonList.length(); i++) {
            JSONObject jsonObject = (JSONObject) jsonList.get(i);
           String nombre;
           String apellido;
           String aectorDeVivienda;
           String motivoCita;
           String numeroCedula;
           String clave;


            nombre = (jsonObject.getString("Nombre"));
            motivoCita = (jsonObject.getString("MotivoCita"));
            apellido = (jsonObject.getString("Apellido"));
            clave = (jsonObject.getString("Clave"));
            aectorDeVivienda = (jsonObject.getString("AectorDeVivienda"));
            numeroCedula = (jsonObject.getString("NumeroCedula"));

            Paciente userData = new Paciente(numeroCedula, nombre, apellido, aectorDeVivienda, motivoCita ,clave){}
                    ;
            pacientes.add(userData);
        }

        return pacientes;
    }

    public void agregarUsuario(Paciente paciente) throws FileNotFoundException, IOException {
        Scanner sc = new Scanner(System.in);
        ArrayList<Paciente> pacientes = leerArchivoUsuarios();
        System.out.println("cedula nuevo = " + paciente.getNumeroCedula());
        for (Paciente p : pacientes
             ) {
            if(paciente.getNumeroCedula().equals(p.getNumeroCedula())){
                System.out.printf("El paciente ya esta registrado");
                return;
            }

        }
        pacientes.add(paciente);
        //Refactorizado el bucle for que recorre el array pacientes

        sobreescribirArchivo(pacientes);
    }


    public void sobreescribirArchivo(ArrayList<Paciente> dataList) throws IOException {
        File outputFile = new File(pathCitas);
        outputFile.getParentFile().mkdir();
        outputFile.createNewFile();
        JSONArray jsonList = new JSONArray();

        for (Paciente user : dataList) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("AectorDeVivienda", user.getAectorDeVivienda());
            jsonObject.put("Apellido", user.getApellido());
            jsonObject.put("Nombre", user.getNombre());
            jsonObject.put("MotivoCita", user.getMotivoCita());
            jsonObject.put("Clave", user.getClave());
            jsonObject.put("NumeroCedula", user.getNumeroCedula());


            jsonList.put(jsonObject);
        }
        // Create the buffer to write
        BufferedWriter bufferWriter = Files.newBufferedWriter(
                Paths.get(outputFile.toURI()));

        jsonList.write(bufferWriter);
        bufferWriter.close();
    }

}

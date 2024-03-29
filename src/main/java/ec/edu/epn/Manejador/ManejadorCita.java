package ec.edu.epn.Manejador;
import ec.edu.epn.Citas.CitaAgendada;
import ec.edu.epn.Citas.CitaDisponible;
import ec.edu.epn.Citas.CitaMedica;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Scanner;

public class ManejadorCita {

    private String pathCita = System.getProperty("user.dir") + "\\src\\main\\resources\\dataCita.json";

    public ManejadorCita(String pathCitas) {
        this.pathCitas = pathCitas;
    }
    private String pathCitas;


    public ArrayList<CitaMedica> leerArchivoCitas() throws FileNotFoundException {
        // ScoreData is the array where we can read the core from file
        ArrayList<CitaMedica> citaMedica = new ArrayList<>();
        File file = new File(pathCita);
        // If the file is empty or is not exist return the dataList
        if (!file.exists() || file.length() == 0) {
            return citaMedica;
        }
        // Start to parser
        JSONTokener parser = new JSONTokener(new FileInputStream(file));
        //Initial the JSONArray
        JSONArray jsonList = new JSONArray(parser);
        System.out.println("NUMERO DE REGISTROS TOTALES: " + jsonList.length());
        for (int i = 0; i < jsonList.length(); i++) {
            JSONObject jsonObject = (JSONObject) jsonList.get(i);
            CitaMedica userData = new CitaMedica() {
            };
            userData.setEspecialidad(jsonObject.getString("Especialidad"));
            userData.setFechaEmision(jsonObject.getString("FechaEmision"));
            userData.setNombreMedico(jsonObject.getString("NombreMedico"));
            userData.setFechaCita(jsonObject.getString("FechaCita"));
            userData.setCodigoCita(jsonObject.getString("CodigoCita"));
            userData.setDisponibilidad(jsonObject.getBoolean("Disponibilidad"));
            userData.setNumeroDeCedula(jsonObject.getString("NumeroDeCedula"));
            citaMedica.add(userData);
        }
        return citaMedica;
    }

    public void sobreescribirArchivo(ArrayList<CitaMedica> dataList) throws IOException {
        File outputFile = new File(pathCita);
        outputFile.getParentFile().mkdir();
        outputFile.createNewFile();
        JSONArray jsonList = new JSONArray();


        for (CitaMedica user : dataList){
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("Especialidad", user.getEspecialidad());
            jsonObject.put("FechaEmision", user.getFechaEmision());
            jsonObject.put("NombreMedico", user.getNombreMedico());
            jsonObject.put("FechaCita", user.getFechaCita());
            jsonObject.put("CodigoCita", user.getCodigoCita());
            jsonObject.put("Disponibilidad", user.isDisponibilidad());
            jsonObject.put("NumeroDeCedula", user.getNumeroDeCedula());
            jsonList.put(jsonObject);
        }
        // Create the buffer to write
        BufferedWriter bufferWriter = Files.newBufferedWriter(
                Paths.get(outputFile.toURI()));

        jsonList.write(bufferWriter);
        bufferWriter.close();
    }

    public void mostrarCita(CitaMedica cm) {
        System.out.print("\nLa cita medica: "+
                "\nNombre de cedula del solicitante: " + cm.getNumeroDeCedula()+
                "\nFecha de emision del documento: " + cm.getFechaEmision() +
                "\nFecha de la cita: " + cm.getFechaCita()
        );
    }


    public int calcularDiasFaltantes(CitaMedica cita) {
        final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        final LocalDate fechaDestino = LocalDate.parse(cita.getFechaCita(), formatter);
        final LocalDate fechaOrigen = LocalDate.now();
        final long res = ChronoUnit.DAYS.between(fechaOrigen, fechaDestino);
        return (int) res;
    }


    public void reservarCita(String numeroDeCedula) throws FileNotFoundException, IOException {
        Scanner sc = new Scanner(System.in);
        ArrayList<CitaMedica> citas = leerArchivoCitas();
        ArrayList<CitaMedica> citasDisponible = new ArrayList<CitaMedica>();

        CitaDisponible cd = new CitaDisponible();
        citasDisponible = cd.mostrarCitasDisponibles(citas);

        System.out.println("Ingrese el numero de la cita que desea agendar:");
        int citaSeleccionada = sc.nextInt();
        int index = citaSeleccionada;
        int i = 0;
        CitaAgendada ca = new CitaAgendada();

        final String auxCodCita = citasDisponible.get(index).getCodigoCita();

        for (CitaMedica cita : citas) {

            final String codCita = cita.getCodigoCita();

            if (auxCodCita.equals(codCita)) {
                citas.get(i).setDisponibilidad(false);
                citas.get(i).setNumeroDeCedula(numeroDeCedula);
                mostrarCita(citas.get(i));
                System.out.print("Quedan " + calcularDiasFaltantes(cita) + " días para su cita\n");
            }
            i++;
        }
        sobreescribirArchivo(citas);
    }


    public void eliminarCita(String numeroDeCedula) throws FileNotFoundException, IOException {
        Scanner sc = new Scanner(System.in);
        ArrayList<CitaMedica> citasNoDisponible = new ArrayList<CitaMedica>();
        ArrayList<CitaMedica> citas = leerArchivoCitas();

        CitaAgendada cd = new CitaAgendada();
        citasNoDisponible = cd.visualizarCitasAgendadas(citas, numeroDeCedula);

        System.out.println("Ingrese el numero de la cita que desea cancelar:");
        int citaSeleccionada = sc.nextInt();
        int index = citaSeleccionada;
        int i = 0;
        //Reempazando las partes de la expresion if en variables separadas
        final String auxCodCita = citasNoDisponible.get(index).getCodigoCita();
        for (CitaMedica cita : citas) {

            //Reempazando las partes de la expresion if en variables separadas
            final String codCita = cita.getCodigoCita();

            //Creando condicional más sencilla de entender
            if (auxCodCita.equals(codCita)) {
                citas.get(i).setDisponibilidad(true);
                citas.get(i).setNumeroDeCedula("000000000");
                mostrarCita(citas.get(i));
                System.out.println("Se ha cancelado exitosamente");
            }
            i++;
        }
        sobreescribirArchivo(citas);
    }

}

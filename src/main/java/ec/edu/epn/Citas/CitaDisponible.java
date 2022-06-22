package ec.edu.epn.Citas;

import java.util.ArrayList;

public class CitaDisponible {
    private int numeroCitasDisponibles;
    private ArrayList<CitaMedica> citasDisponibles;

    public CitaDisponible() {
        citasDisponibles = new ArrayList<>();
        numeroCitasDisponibles = citasDisponibles.size();
    }



    public ArrayList<CitaMedica> mostrarCitasDisponibles(ArrayList<CitaMedica> citasMedicas){
        for(int i = 0; i<citasMedicas.size(); i++){
            if(citasMedicas.get(i).isDisponibilidad() == true){
                citasDisponibles.add(citasMedicas.get(i));
            }
        }
        imprimirCitasDisponibles();
        return citasDisponibles;
    }



    public void imprimirCitasDisponibles(){
        for(int j = 0; j<citasDisponibles.size(); j++){
            CitaMedica cm = citasDisponibles.get(j);
            System.out.print("\n" + (j) +".- ");
            System.out.println("Nombre de cedula del solicitante: " + cm.getNumeroDeCedula()+
                    "\nFecha de emision del documento: " + cm.getFechaEmision()+
                    "\nFecha de la cita cancelada:" + cm.getFechaCita());
        }
    }
}

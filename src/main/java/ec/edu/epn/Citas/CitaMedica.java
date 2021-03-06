package ec.edu.epn.Citas;

public class CitaMedica {
    private String especialidad;
    private String fechaEmision;
    private String nombreMedico;
    private String fechaCita;
    private String codigoCita;
    private boolean disponibilidad;
    private String numeroDeCedula;
    public CitaMedica(String numeroDeCedula, String especialidad, String fechaEmision, String nombreMedico, String fechaCita, String codigoCita, boolean disponibilidad) {
        this.especialidad = especialidad;
        this.fechaEmision = fechaEmision;
        this.nombreMedico = nombreMedico;
        this.fechaCita = fechaCita;
        this.codigoCita = codigoCita;
        this.disponibilidad = disponibilidad;
        this.numeroDeCedula = numeroDeCedula;
    }
    public String getEspecialidad() {
        return especialidad;
    }

    public CitaMedica() {
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(String fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public String getNombreMedico() {
        return nombreMedico;
    }

    public void setNombreMedico(String nombreMedico) {
        this.nombreMedico = nombreMedico;
    }

    public String getFechaCita() {
        return fechaCita;
    }

    public void setFechaCita(String fechaCita) {
        this.fechaCita = fechaCita;
    }

    public String getCodigoCita() {
        return codigoCita;
    }

    public void setCodigoCita(String codigoCita) {
        this.codigoCita = codigoCita;
    }

    public boolean isDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }
    public String getNumeroDeCedula() {
        return numeroDeCedula;
    }

    public void setNumeroDeCedula(String numeroDeCedula) {
        this.numeroDeCedula = numeroDeCedula;
    }
}

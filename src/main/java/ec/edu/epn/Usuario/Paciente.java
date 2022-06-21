package ec.edu.epn.Usuario;

public class Paciente {
    private String numeroCedula;
    private String nombre;
    private String apellido;
    private String aectorDeVivienda;
    private String motivoCita;
    private String clave;

    public Paciente() {
    }

    public Paciente(String numeroCedula, String nombre, String apellido, String aectorDeVivienda, String motivoCita, String clave) {
        this.numeroCedula = numeroCedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.aectorDeVivienda = aectorDeVivienda;
        this.motivoCita = motivoCita;
        this.clave = clave;
    }

    public String getNumeroCedula() {
        return numeroCedula;
    }

    public void setNumeroCedula(String numeroCedula) {
        this.numeroCedula = numeroCedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getAectorDeVivienda() {
        return aectorDeVivienda;
    }

    public void setAectorDeVivienda(String aectorDeVivienda) {
        this.aectorDeVivienda = aectorDeVivienda;
    }

    public String getMotivoCita() {
        return motivoCita;
    }

    public void setMotivoCita(String motivoCita) {
        this.motivoCita = motivoCita;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
}

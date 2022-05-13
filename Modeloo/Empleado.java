
package Modeloo;

/**
 *
 * @author Negriz07
 */
public class Empleado {

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
     private int id;
    private String matricula;
    private String nombre;
    private String apellido;
    private String telefono;
    private String correo;
    private String sexo;

    public Empleado() {
    }

    public Empleado(int id, String matricula, String apellido, String telefono, String correo, String sexo) {
        this.id = id;
        this.matricula = matricula;
        this.apellido = apellido;
        this.telefono = telefono;
        this.correo = correo;
        this.sexo = sexo;
    }

}

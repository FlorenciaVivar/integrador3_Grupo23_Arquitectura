package tp3.integrador3_grupo23_arqui.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Entity
@Table(name = "estudiante")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Estudiante {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idEstudiante;

    @Column (nullable = false)
    private String nombre;

    @Column (nullable = false)
    private String apellido;

    @Column (name = "anios")
    private int edad;

    @Column (nullable = false)
    private String genero;

    @Column (nullable = false)
    private int DNI;

    @Column (nullable = false)
    private Long numLegajo;

    @Column
    private String ciudad;

    @Column(nullable = true)
    private int antiguedadEnCarrera;

    @Column (nullable = false)

    @OneToMany(mappedBy = "estudiante", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<EstudianteCarrera> carreras;/*Un estudiante tiene 1 o + carreras cursadas*/
                /*Tipo EstudianteCarrera, ya que es la tabla realacion*/

    public int getAntiguedadEnCarrera() {
        return antiguedadEnCarrera;
    }

    public void setAntiguedadEnCarrera(int antiguedadEnCarrera) {
        this.antiguedadEnCarrera = antiguedadEnCarrera;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDNI() {
        return DNI;
    }

    public void setDNI(int DNI) {
        this.DNI = DNI;
    }

    public Long getNumLegajo() {
        return numLegajo;
    }

    public void setNumLegajo(long numLegajo) {
        this.numLegajo = numLegajo;
    }

    public Integer getIdEstudiante() {
        return idEstudiante;
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "antiguedadEnCarrera=" + antiguedadEnCarrera +
                ", ciudad='" + ciudad + '\'' +
                ", numLegajo='" + numLegajo + '\'' +
                ", DNI=" + DNI +
                ", genero='" + genero + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", edad=" + edad +
                '}';
    }
}

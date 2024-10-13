package tp3.integrador3_grupo23_arqui.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "carrera")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Carrera {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idCarrera;

    @Column(nullable = false)
    private String nombre;

    @OneToMany(mappedBy = "carrera")
    @JsonIgnore
    private List<EstudianteCarrera> estudiantes;

//    public Carrera(){}
//
//    public Carrera(String nombre){
//        this.nombre = nombre;
//        this.estudiantes = new ArrayList<>();
//    }
    public Integer getIdCarrera() {
        return idCarrera;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<EstudianteCarrera> getEstudiantes() {
        return estudiantes;
    }

    @Override
    public String toString() {
        return "Carrera{" +
                "idCarrera=" + idCarrera +
                ", nombre='" + nombre + '\'' +
//                ", estudiantes=" + estudiantes +
                '}';
    }
}

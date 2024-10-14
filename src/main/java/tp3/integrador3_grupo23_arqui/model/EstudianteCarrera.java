package tp3.integrador3_grupo23_arqui.model;

import jakarta.persistence.*;
import lombok.*;

import static jakarta.persistence.GenerationType.AUTO;

@Entity
@Table(name = "estudianteCarrera")
@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EstudianteCarrera {
    @Id @GeneratedValue(strategy = AUTO)
    private Integer idEstudianteCarrera;

    /*CarreraId*/
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "carrera_id", referencedColumnName = "idCarrera")
    private Carrera carrera;//Relacion a carrera

    /*EstudianteId*/
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "estudiante_id", referencedColumnName = "idEstudiante")
    private Estudiante estudiante; //Relacion a estudiante

    @Column(nullable = false)
    private int fechaComienzo;

    @Column(nullable = false)
    private boolean estaGraduado;

    @Column(nullable = true)
    @Temporal(TemporalType.DATE)
    private int fechaGraduacion;

    public Integer getIdEstudianteCarrera(){
        return this.idEstudianteCarrera;
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public int getFechaComienzo() {
        return fechaComienzo;
    }

    public boolean isEstaGraduado() {
        return estaGraduado;
    }

    public int getFechaGraduacion() {
        return fechaGraduacion;
    }
}
package tp3.integrador3_grupo23_arqui.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tp3.integrador3_grupo23_arqui.model.Carrera;
import tp3.integrador3_grupo23_arqui.model.Estudiante;
import tp3.integrador3_grupo23_arqui.model.EstudianteCarrera;

import java.util.Optional;

public interface EstudianteCarreraRepository extends JpaRepository<EstudianteCarrera, Integer> {
    //Matricular Estudiante (B)
    public void AltaEstudiante(Estudiante estudiante, Carrera carrera);

    //(H)recuperar los estudiantes de una determinada carrera, filtrado por ciudad de residencia.
    @Query("SELECT ec FROM EstudianteCarrera ec WHERE ec.carrera.nombre = :nombreCarrera AND ec.estudiante.ciudad = :ciudad")
    Iterable<EstudianteCarrera> findEstudiantesByCarreraAndCiudad(@Param("nombreCarrera") String nombre, @Param("ciudad") String ciudad);

    @Query("SELECT ec FROM EstudianteCarrera ec WHERE ec.carrera = :carrera AND ec.estudiante = :estudiante")
    Optional<EstudianteCarrera> findByCarreraAndEstudiante(@Param("carrera") Carrera carrera, @Param("estudiante") Estudiante estudiante);
}

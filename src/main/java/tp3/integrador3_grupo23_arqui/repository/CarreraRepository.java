package tp3.integrador3_grupo23_arqui.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tp3.integrador3_grupo23_arqui.model.Carrera;

import java.util.List;

public interface CarreraRepository extends JpaRepository<Carrera, Integer> {

    @Query("SELECT c FROM Carrera c JOIN EstudianteCarrera ec ON c.idCarrera = ec.carrera.idCarrera WHERE ec.estudiante.idEstudiante = :id")
    Iterable<Carrera> findCarrerasByIdEstudiante(@Param("id") int id);

    @Query("SELECT c FROM Carrera c WHERE c.idCarrera = :id")
    Iterable<Carrera> findById(@Param("id") int id);
    //f) recuperar las carreras con estudiantes inscriptos, y ordenar por cantidad de inscriptos.
    // Revisar la query
    @Query("SELECT count(ec.idEstudianteCarrera)FROM Carrera c JOIN EstudianteCarrera ec WHERE c.idCarrera = ec.carrera.idCarrera ")
    Iterable<Carrera>findCarrerasByEstudiantesOrdenada();
}

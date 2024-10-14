package tp3.integrador3_grupo23_arqui.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tp3.integrador3_grupo23_arqui.model.Carrera;

public interface CarreraRepository extends JpaRepository<Carrera, Integer> {

    @Query("SELECT c FROM Carrera c JOIN EstudianteCarrera ec ON c.idCarrera = ec.carrera.idCarrera WHERE ec.estudiante.idEstudiante = :id")
    Iterable<Carrera> findCarrerasByIdEstudiante(@Param("id") int id);

    @Query("SELECT c FROM Carrera c WHERE c.idCarrera = :id")
    Iterable<Carrera> findById(@Param("id") int id);
}

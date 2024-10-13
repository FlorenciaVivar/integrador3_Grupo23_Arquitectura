package tp3.integrador3_grupo23_arqui.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tp3.integrador3_grupo23_arqui.model.Carrera;
import tp3.integrador3_grupo23_arqui.model.Estudiante;
import tp3.integrador3_grupo23_arqui.model.EstudianteCarrera;

import java.util.List;
import java.util.Optional;

public interface EstudianteCarreraRepository extends JpaRepository<EstudianteCarrera, Integer> {

    @Query("SELECT ec FROM EstudianteCarrera ec WHERE ec.carrera.idCarrera = :idCarrera AND ec.estudiante.ciudad= :ciudad")
    Iterable<EstudianteCarrera> findEstudiantesByCarreraAndCiudad(@Param("idCarrera") int idCarrera, @Param("ciudad") String ciudad);

    @Query("SELECT ec FROM EstudianteCarrera ec WHERE ec.carrera = :carrera AND ec.estudiante = :estudiante")
    Optional<EstudianteCarrera> findByCarreraAndEstudiante(@Param("carrera") Carrera carrera, @Param("estudiante") Estudiante estudiante);

    @Query("SELECT c, COUNT(ec) AS cantidadEstudiantes " +
            "FROM Carrera c " +
            "JOIN c.estudiantes ec " +
            "GROUP BY c " +
            "HAVING COUNT(ec) > 0 " +
            "ORDER BY cantidadEstudiantes DESC")
    List<Object[]> buscarCarrerasPorNroInscriptos();

}

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

    @Query("SELECT ec FROM EstudianteCarrera ec WHERE ec.carrera.nombre = :nombreCarrera AND ec.estudiante.ciudad = :ciudad")
    Iterable<EstudianteCarrera> findEstudiantesByCarreraAndCiudad(@Param("nombreCarrera") String nombre, @Param("ciudad") String ciudad);

    @Query("SELECT ec FROM EstudianteCarrera ec WHERE ec.carrera = :carrera AND ec.estudiante = :estudiante")
    Optional<EstudianteCarrera> findByCarreraAndEstudiante(@Param("carrera") Carrera carrera, @Param("estudiante") Estudiante estudiante);

//    @Query("SELECT DISTINCT c FROM EstudianteCarrera ec JOIN Carrera c ON (ec.carrera.idCarrera=c.idCarrera) GROUP BY c.idCarrera ORDER BY COUNT(ec.carrera) DESC")
//    Iterable<Carrera> buscarCarrerasPorNroInscriptos();

    @Query("SELECT c.idCarrera, c.nombre, COUNT(ec.carrera.idCarrera) as cantidadEstudiantes " +
            "FROM EstudianteCarrera ec " +
            "JOIN Carrera c ON (ec.carrera.idCarrera=c.idCarrera)" +
            "GROUP BY c.idCarrera " +
            "ORDER BY COUNT(ec.carrera.idCarrera) DESC")
    List<Object[]> buscarCarrerasPorNroInscriptos();


}

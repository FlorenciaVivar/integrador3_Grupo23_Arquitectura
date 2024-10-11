package tp3.integrador3_grupo23_arqui.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tp3.integrador3_grupo23_arqui.model.Estudiante;

public interface EstudianteRepository extends JpaRepository<Estudiante,Integer > {
    //(C)
    @Query("SELECT e FROM Estudiante e WHERE e.nombre = :nombre ")
    Iterable<Estudiante> buscarEstudiantePorNombre(@Param(value = "nombre") String nombre);

    @Query("SELECT e FROM Estudiante e WHERE e.numLegajo = :libreta")
    Estudiante buscarEstudiantePorLibreta(@Param(value = "libreta") Long libreta);

    @Query("SELECT e FROM Estudiante e WHERE e.genero = :genero")
    Iterable<Estudiante>buscarEstudiantePorGenero(@Param(value = "genero") String genero);
}

package tp3.integrador3_grupo23_arqui.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tp3.integrador3_grupo23_arqui.model.Carrera;
import tp3.integrador3_grupo23_arqui.model.Estudiante;
import tp3.integrador3_grupo23_arqui.model.EstudianteCarrera;

public interface EstudianteCarreraRepository extends JpaRepository<EstudianteCarrera, Integer> {
//Matricular Estudiante (B)
    public void AltaEstudiante(Estudiante estudiante, Carrera carrera);
    //(H)recuperar los estudiantes de una determinada carrera, filtrado por ciudad de residencia.

}

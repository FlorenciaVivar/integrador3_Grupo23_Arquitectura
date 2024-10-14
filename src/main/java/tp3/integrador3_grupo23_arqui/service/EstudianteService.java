package tp3.integrador3_grupo23_arqui.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tp3.integrador3_grupo23_arqui.model.Estudiante;
import tp3.integrador3_grupo23_arqui.repository.EstudianteRepository;

@Service("EstudianteService")
public class EstudianteService {
    @Autowired
    private EstudianteRepository estudianteRepository;

    public Iterable<Estudiante> getEstudiantes(){
        return estudianteRepository.findAll();
    }

    //(A)dar de alta un estudiante
    public Estudiante agregarEstudiante(Estudiante estudiante){
        return estudianteRepository.save(estudiante);
    }

    //(C)recuperar todos los estudiantes, y especificar algún criterio de ordenamiento simple.
    public Iterable<Estudiante> buscarEstudiantePorNombre(String nombre){
        return estudianteRepository.buscarEstudiantePorNombre(nombre);
    }

    //(D)recuperar un estudiante, en base a su número de libreta universitaria.
    public Estudiante buscarEstudianteNumLibreta(Long libreta){
        return estudianteRepository.buscarEstudiantePorLibreta(libreta);
    }
    //(E) recuperar todos los estudiantes, en base a su género.
    public Iterable<Estudiante> buscarEstudiantesPorGenero(String genero){
        return estudianteRepository.buscarEstudiantesPorGenero(genero.toUpperCase());
    }
    //Extra: Modificar un estudiante
    public Estudiante actualizarEstudiante(Integer idEstudiante, Estudiante estudiante){
        estudiante.setIdEstudiante(idEstudiante);
        return estudianteRepository.save(estudiante);
    }

    //Extra: Eliminar un estudiante
    @Transactional
    public void eliminarEstudiante(Integer idEstudiante){
        estudianteRepository.deleteById(idEstudiante);
    }

}
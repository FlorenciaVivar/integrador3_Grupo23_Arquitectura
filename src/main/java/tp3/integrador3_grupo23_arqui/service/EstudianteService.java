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

    //todos los estudiantes
    public Iterable<Estudiante> getEstudiantes(){
        return estudianteRepository.findAll();
    }
    public Estudiante agregarEstudiante(Estudiante estudiante){
        return estudianteRepository.save(estudiante);
    }

    public Estudiante actualizarEstudiante(Integer idEstudiante, Estudiante estudiante){
        estudiante.setIdEstudiante(idEstudiante);
        return estudianteRepository.save(estudiante);
    }
    @Transactional
    public void eliminarEstudiante(Integer idEstudiante){
        estudianteRepository.deleteById(idEstudiante);
    }
}
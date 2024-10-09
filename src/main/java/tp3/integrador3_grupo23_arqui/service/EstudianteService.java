package tp3.integrador3_grupo23_arqui.service;

import org.springframework.stereotype.Service;
import tp3.integrador3_grupo23_arqui.model.Estudiante;
import tp3.integrador3_grupo23_arqui.repository.EstudianteRepository;
@Service
public class EstudianteService {

    private final EstudianteRepository estudianteRepository;

    public EstudianteService(EstudianteRepository estudianteRepository) {
        this.estudianteRepository = estudianteRepository;
    }

    public Iterable<Estudiante> obtenerTodosLosEstudiantes(){
        return estudianteRepository.findAll();
    }
}

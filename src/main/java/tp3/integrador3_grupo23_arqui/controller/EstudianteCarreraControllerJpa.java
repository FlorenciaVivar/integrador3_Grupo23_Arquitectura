package tp3.integrador3_grupo23_arqui.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tp3.integrador3_grupo23_arqui.model.Carrera;
import tp3.integrador3_grupo23_arqui.model.EstudianteCarrera;
import tp3.integrador3_grupo23_arqui.repository.EstudianteCarreraRepository;
import tp3.integrador3_grupo23_arqui.repository.EstudianteRepository;

@RestController
@RequestMapping("estudianteCarrera")
public class EstudianteCarreraControllerJpa {
    @Qualifier("estudianteCarreraRepository")

    private final EstudianteCarreraRepository repository;
    @Autowired
    public EstudianteCarreraControllerJpa(@Qualifier("estudianteCarreraRepository") EstudianteCarreraRepository repository) {
        this.repository = repository;
    }
    //GET todos los estudiantesCarrera
    @GetMapping("/")
    public Iterable<EstudianteCarrera> getEstudianteCarrera() {
        return repository.findAll();
    }
}

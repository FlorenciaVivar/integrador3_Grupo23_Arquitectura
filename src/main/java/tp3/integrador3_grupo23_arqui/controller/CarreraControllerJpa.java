package tp3.integrador3_grupo23_arqui.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tp3.integrador3_grupo23_arqui.model.Carrera;
import tp3.integrador3_grupo23_arqui.repository.CarreraRepository;
import tp3.integrador3_grupo23_arqui.repository.EstudianteCarreraRepository;

@RestController
@RequestMapping("carrera")
public class CarreraControllerJpa {
    @Qualifier("carreraRepository")

    private final CarreraRepository repository;
    @Autowired
    public CarreraControllerJpa(@Qualifier("carreraRepository") CarreraRepository repository) {
        this.repository = repository;
    }

    //GET todas las carreras
    @GetMapping("/")
    public Iterable<Carrera> getCarrera() {
        return repository.findAll();
    }

}

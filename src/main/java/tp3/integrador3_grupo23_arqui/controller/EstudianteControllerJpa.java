package tp3.integrador3_grupo23_arqui.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tp3.integrador3_grupo23_arqui.repository.EstudianteRepository;

@RestController
@RequestMapping("estudiante")
public class EstudianteControllerJpa {
    @Qualifier("estudianteRepository")

    private final EstudianteRepository repository;
    @Autowired
    public EstudianteControllerJpa(@Qualifier("estudianteRepository") EstudianteRepository repository) {
        this.repository = repository;
    }

}

package tp3.integrador3_grupo23_arqui.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tp3.integrador3_grupo23_arqui.model.Carrera;
import tp3.integrador3_grupo23_arqui.model.Estudiante;
import tp3.integrador3_grupo23_arqui.repository.EstudianteRepository;
import tp3.integrador3_grupo23_arqui.service.EstudianteService;

@RestController
@RequestMapping("estudiante")
public class EstudianteControllerJpa {

    private final EstudianteService estudianteService;

    @Autowired
    public EstudianteControllerJpa(EstudianteService estudianteService) {
        this.estudianteService = estudianteService;
    }

//    private final EstudianteRepository repository;
//    @Autowired
//    public EstudianteControllerJpa(@Qualifier("estudianteRepository") EstudianteRepository repository) {
//        this.repository = repository;
//    }
    //GEt todos los estudaintes
    @GetMapping("/")
    public Iterable<Estudiante> getEstudiantes() {
        return estudianteService.obtenerTodosLosEstudiantes();
    }


}

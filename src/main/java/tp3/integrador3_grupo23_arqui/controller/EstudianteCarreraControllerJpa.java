package tp3.integrador3_grupo23_arqui.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import tp3.integrador3_grupo23_arqui.dto.CarreraReporteDTO;
import tp3.integrador3_grupo23_arqui.dto.EstudianteCarreraRequestDTO;
import tp3.integrador3_grupo23_arqui.model.Carrera;
import tp3.integrador3_grupo23_arqui.model.EstudianteCarrera;
import tp3.integrador3_grupo23_arqui.service.EstudianteCarreraService;

@RestController
@RequestMapping("/estudianteCarrera")
public class EstudianteCarreraControllerJpa {
    @Autowired
    private EstudianteCarreraService estudianteCarreraService;

    //(b)matricular un estudiante en una carrera
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void matricularEstudianteCarrera(EstudianteCarreraRequestDTO ecDTO) {
        this.estudianteCarreraService.create(ecDTO);
    }

    //(c) recuperar todos los estudiantes, y especificar algún criterio de ordenamiento simple
    //GET todos los estudiantesCarrera
    @GetMapping()
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<EstudianteCarrera>> getEstudianteCarrera(@RequestParam(value = "sort", required = false) String sort) {
        List<EstudianteCarrera> estudiantesCarrera = this.estudianteCarreraService.findAll(sort);
        System.out.println(estudiantesCarrera);
        return ResponseEntity.ok(estudiantesCarrera);
    }

    @GetMapping("/reportes")
    public List<CarreraReporteDTO> getReportes(){
        return this.estudianteCarreraService.getReportes();
    }
}

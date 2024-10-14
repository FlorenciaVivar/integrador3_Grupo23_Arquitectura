package tp3.integrador3_grupo23_arqui.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tp3.integrador3_grupo23_arqui.dto.CarreraReporteDTO;
import tp3.integrador3_grupo23_arqui.dto.EstudianteCarreraRequestDTO;
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
    public void matricularEstudianteCarrera(@RequestBody EstudianteCarreraRequestDTO ecDTO) {
        this.estudianteCarreraService.create(ecDTO);
    }

    //(c) recuperar todos los estudiantes, y especificar algún criterio de ordenamiento simple
    @GetMapping()
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<EstudianteCarrera>> getEstudianteCarrera(@RequestParam(value = "sort", required = false) String sort) {
        List<EstudianteCarrera> estudiantesCarrera = this.estudianteCarreraService.findAll(sort);
        System.out.println(estudiantesCarrera);
        return ResponseEntity.ok(estudiantesCarrera);
    }

    //H) eporte de las carreras ordenado alfabéticamente, donde cada carrera incluye información de los inscriptos y egresados por año.
    @GetMapping("/reportes")
    public List<CarreraReporteDTO> getReportes(){
        return this.estudianteCarreraService.getReportes();
    }

}

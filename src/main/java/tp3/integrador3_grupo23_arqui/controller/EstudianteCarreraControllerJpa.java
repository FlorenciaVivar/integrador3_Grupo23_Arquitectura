package tp3.integrador3_grupo23_arqui.controller;

import java.util.List;

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

import tp3.integrador3_grupo23_arqui.dto.EstudianteCarreraRequestDTO;
import tp3.integrador3_grupo23_arqui.model.EstudianteCarrera;
import tp3.integrador3_grupo23_arqui.service.EstudianteCarreraService;

@RestController
@RequestMapping("estudianteCarrera")
public class EstudianteCarreraControllerJpa {

    private EstudianteCarreraService estudianteCarreraService;

    public EstudianteCarreraControllerJpa(EstudianteCarreraService estudianteCarreraService) {
        this.estudianteCarreraService = estudianteCarreraService;
    }

    //GET todos los estudiantesCarrera
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<EstudianteCarrera>> getEstudianteCarrera(@RequestParam(value = "sort") String sort) {
        return ResponseEntity.ok(this.estudianteCarreraService.findAll(sort));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void darDeAlta(EstudianteCarreraRequestDTO ecDTO) {
        this.estudianteCarreraService.create(ecDTO);
    }
}

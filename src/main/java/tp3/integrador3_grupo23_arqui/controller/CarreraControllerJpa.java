package tp3.integrador3_grupo23_arqui.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tp3.integrador3_grupo23_arqui.dto.CarreraCantEstudianteDTO;
import tp3.integrador3_grupo23_arqui.model.Carrera;
import tp3.integrador3_grupo23_arqui.model.Estudiante;
import tp3.integrador3_grupo23_arqui.model.EstudianteCarrera;
import tp3.integrador3_grupo23_arqui.repository.CarreraRepository;
import tp3.integrador3_grupo23_arqui.repository.EstudianteCarreraRepository;
import tp3.integrador3_grupo23_arqui.service.CarreraService;
import tp3.integrador3_grupo23_arqui.service.EstudianteCarreraService;
import tp3.integrador3_grupo23_arqui.service.EstudianteService;

import java.util.List;

@RestController
@RequestMapping("/carrera")
public class CarreraControllerJpa {
    @Autowired
    private CarreraService carreraService;
    @Autowired
    private EstudianteCarreraService estudianteCarreraService;

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Iterable<Carrera>> getCarreras() throws Exception {
        Iterable<Carrera> carreras = carreraService.ObtenerCarreras();
        return ResponseEntity.ok(carreras);
    }

    //(f) recuperar las carreras con estudiantes inscriptos, y ordenar por cantidad de inscriptos.
    @GetMapping("/orderBy/cantidad")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<CarreraCantEstudianteDTO>> getCarrerasByNroInscriptos() {
        List<CarreraCantEstudianteDTO> carreras = estudianteCarreraService.buscarCarrerasPorNroInscriptos();
        return ResponseEntity.ok(carreras);
    }


}

package tp3.integrador3_grupo23_arqui.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tp3.integrador3_grupo23_arqui.model.Estudiante;
import tp3.integrador3_grupo23_arqui.model.EstudianteCarrera;
import tp3.integrador3_grupo23_arqui.service.EstudianteService;

import java.util.List;

@RestController
@RequestMapping("/estudiante")
public class EstudianteControllerJpa {
    @Autowired
    private EstudianteService estudianteService;

    //GET todos los estudiantes
    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public Iterable<Estudiante> getEstudiantes() {
        return estudianteService.getEstudiantes();
    }

    //(A)dar de alta un estudiante
    @PostMapping("")
    public Estudiante agregarEstudiante(@RequestBody Estudiante estudiante) {
        return estudianteService.agregarEstudiante(estudiante);
    }

    //(d)recuperar un estudiante, en base a su número de libreta universitaria.
    @GetMapping("/LU/{LU}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Estudiante> getEstudianteByLU(@PathVariable long LU) {
        return ResponseEntity.ok(this.estudianteService.buscarEstudianteNumLibreta(LU));
    }

    //(e)recuperar todos los estudiantes, en base a su género.
    @GetMapping("/genero/{genero}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Iterable<Estudiante>> getEstudiantesByGenero(@PathVariable String genero) {
        return ResponseEntity.ok(this.estudianteService.buscarEstudiantesPorGenero(genero));
    }

    @GetMapping("/{nombre}")
    public Iterable<Estudiante> getEstudiantePorNombre(@PathVariable("nombre") String nombre){
        return estudianteService.buscarEstudiantePorNombre(nombre);
    }

    @PutMapping("/{id}")
    public Estudiante updateEstudiante(@PathVariable Integer id, @RequestBody Estudiante estudiante) {
        Estudiante estudianteActualizado = estudianteService.actualizarEstudiante(id,estudiante);
        return estudianteActualizado;
    }
    @DeleteMapping("/{id}")
    public void deleteEstudiante(@PathVariable("id") Integer idEstudiante) {
        estudianteService.eliminarEstudiante(idEstudiante);
    }

}
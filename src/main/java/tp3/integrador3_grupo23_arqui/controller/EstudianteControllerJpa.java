package tp3.integrador3_grupo23_arqui.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tp3.integrador3_grupo23_arqui.model.Estudiante;
import tp3.integrador3_grupo23_arqui.service.EstudianteService;


@RestController
@RequestMapping("estudiante")
public class EstudianteControllerJpa {
    @Autowired
    private EstudianteService estudianteService;


    //GEt todos los estudaintes
    @GetMapping("/")
    public Iterable<Estudiante> getEstudiantes() {
        return  estudianteService.getEstudiantes();
    }
    @PostMapping("/")
    public Estudiante agregarEstudiante(@RequestBody Estudiante estudiante) {
        return estudianteService.agregarEstudiante(estudiante);
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
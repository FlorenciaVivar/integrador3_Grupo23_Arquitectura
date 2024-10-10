package tp3.integrador3_grupo23_arqui.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import tp3.integrador3_grupo23_arqui.model.Carrera;
import tp3.integrador3_grupo23_arqui.repository.CarreraRepository;
import tp3.integrador3_grupo23_arqui.repository.EstudianteCarreraRepository;
import tp3.integrador3_grupo23_arqui.service.CarreraService;

@RestController
@RequestMapping("carrera")
public class CarreraControllerJpa {

    @Autowired
    private  CarreraService Servicio;




    //GET todas las carreras
    //  @GetMapping("/")
    //   public Iterable<Carrera> getCarrera() {
        //     return repository.findAll();
        // }
    //GET Carreras por id
    //  @GetMapping("/{id}")
    //   public Iterable<Carrera>  getCarreraByIid(@PathVariable int id) {
        //     return repository.findById(id);
    //   }

    // @GetMapping("/")
    // public Carrera newCarrera(@RequestBody Carrera carrera) {
        //     return  repository.save(carrera);

    // }
    // @PutMapping("/{id}")
    // public void replaceCarrera(@PathVariable int id, @RequestBody Carrera carrera) {
    //     repository.save(carrera);
    // }
    // @DeleteMapping(("/{id}"))
    // public void deleteCarrera(@PathVariable int id) {
    //     repository.deleteById(id);
    //  }
//

}

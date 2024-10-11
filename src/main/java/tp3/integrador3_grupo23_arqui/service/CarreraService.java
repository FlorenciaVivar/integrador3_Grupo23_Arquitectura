package tp3.integrador3_grupo23_arqui.service;


import aj.org.objectweb.asm.commons.TryCatchBlockSorter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tp3.integrador3_grupo23_arqui.model.Carrera;
import tp3.integrador3_grupo23_arqui.repository.CarreraRepository;

import java.util.List;

@Service("CarreraService")

public class CarreraService {
    @Autowired
    private CarreraRepository carreraRepository;

    public Iterable<Carrera> ObtenerCarreras() throws Exception {
        return carreraRepository.findAll();
    }

    public Integer CarreraPorId(Integer id) throws Exception {
        try {
            Carrera carreraAux = carreraRepository.getReferenceById(id);
            return carreraAux.getIdCarrera();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    //2 (F)
    public Iterable<Carrera> ObtenerCarrerasConEstudiantes() throws Exception {
        try {
            Iterable<Carrera> AuxCarrera = carreraRepository.findCarrerasByEstudiantesOrdenada();
            return AuxCarrera;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }


    public void eliminarCarrera(Integer id) {
        carreraRepository.deleteById(id);
    }
}

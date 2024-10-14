package tp3.integrador3_grupo23_arqui.service;

import tp3.integrador3_grupo23_arqui.dto.CarreraCantEstudianteDTO;
import tp3.integrador3_grupo23_arqui.dto.CarreraReporteDTO;
import tp3.integrador3_grupo23_arqui.dto.EstudianteCarreraRequestDTO;
import tp3.integrador3_grupo23_arqui.model.Carrera;
import tp3.integrador3_grupo23_arqui.model.EstudianteCarrera;

import java.util.List;

public interface EstudianteCarreraService {
    List<EstudianteCarrera> findAll(String sort);

    EstudianteCarrera findById(Integer ecId);

    void create(EstudianteCarreraRequestDTO ecDTO);

    void delete(EstudianteCarreraRequestDTO ecDTO);

    Iterable<EstudianteCarrera> findByCarreraAndCiudad(int idCarrera, String ciudad);

    List<CarreraCantEstudianteDTO> buscarCarrerasPorNroInscriptos();

    List<CarreraReporteDTO> getReportes();
}

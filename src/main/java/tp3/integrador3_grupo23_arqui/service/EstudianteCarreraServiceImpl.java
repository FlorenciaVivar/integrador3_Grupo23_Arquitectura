package tp3.integrador3_grupo23_arqui.service;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import tp3.integrador3_grupo23_arqui.dto.CarreraCantEstudianteDTO;
import tp3.integrador3_grupo23_arqui.dto.EstudianteCarreraRequestDTO;
import tp3.integrador3_grupo23_arqui.model.Carrera;
import tp3.integrador3_grupo23_arqui.model.Estudiante;
import tp3.integrador3_grupo23_arqui.model.EstudianteCarrera;
import tp3.integrador3_grupo23_arqui.repository.CarreraRepository;
import tp3.integrador3_grupo23_arqui.repository.EstudianteCarreraRepository;
import tp3.integrador3_grupo23_arqui.repository.EstudianteRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class EstudianteCarreraServiceImpl implements EstudianteCarreraService{

    private EstudianteCarreraRepository repository;

    private EstudianteRepository estudianteRepository;

    private CarreraRepository carreraRepository;

    public EstudianteCarreraServiceImpl(
            EstudianteCarreraRepository repository,
            EstudianteRepository estudianteRepository,
            CarreraRepository carreraRepository) {
        this.repository = repository;

        this.estudianteRepository = estudianteRepository;

        this.carreraRepository = carreraRepository;
    }

    @Override
    public List<EstudianteCarrera> findAll(String sort) {
        String field;

        switch (sort) {
            case "1" -> field = "estudiante.nombre";
            case "2" -> field = "estudiante.apellido";
            case "3" -> field = "fechaComienzo";
            default -> field = "idEstudianteCarrera";
        }

        return this.repository.findAll(Sort.by(field));
    }
    @Override
    public EstudianteCarrera findById(Integer ecId) {
        return this.repository.findById(ecId).orElseThrow(() -> new RuntimeException(""));
    }

    @Override
    public void create(EstudianteCarreraRequestDTO ecDTO) {
        Carrera carrera = this.carreraRepository.findById(ecDTO.getIdCarrera()).orElseThrow(() -> new RuntimeException(""));

        Estudiante estudiante = this.estudianteRepository.findById(ecDTO.getIdEstudiante()).orElseThrow(() -> new RuntimeException(""));

        EstudianteCarrera request = EstudianteCarrera
                .builder()
                .carrera(carrera)
                .estudiante(estudiante)
                .estaGraduado(false)
                .fechaComienzo(LocalDate.now().getYear())
                .fechaGraduacion(0)
                .build();

        this.repository.save(request);
    }

    @Override
    public void delete(EstudianteCarreraRequestDTO ecDTO) {
        Carrera carrera = this.carreraRepository.findById(ecDTO.getIdCarrera()).orElseThrow(() -> new RuntimeException("Carrera no encontrada"));

        Estudiante estudiante = this.estudianteRepository.findById(ecDTO.getIdEstudiante()).orElseThrow(() -> new RuntimeException("Estudiante no encontrado"));

        EstudianteCarrera ec = this.repository.findByCarreraAndEstudiante(carrera, estudiante).orElseThrow(() -> new RuntimeException("EstudianteCarrera no encontrada"));

        this.repository.delete(ec);
    }

    @Override
    public Iterable<EstudianteCarrera> findByCarrerAndCiudad(String nombreCarrera, String ciudad) {
        return this.repository.findEstudiantesByCarreraAndCiudad(nombreCarrera, ciudad);
    }

//    @Override
//    public Iterable<Carrera> buscarCarrerasPorNroInscriptos() {
//        return this.repository.buscarCarrerasPorNroInscriptos();
//    }

    @Override
    public List<CarreraCantEstudianteDTO> buscarCarrerasPorNroInscriptos() {
        System.out.println("Iniciando búsqueda de carreras por número de inscriptos...");

        List<Object[]> resultados = repository.buscarCarrerasPorNroInscriptos();

        System.out.println("Cantidad de resultados obtenidos: " + resultados.size());

        // Mapeo manual de Carrera a CarreraCantEstudianteDTO
        List<CarreraCantEstudianteDTO> carrerasDTO = new ArrayList<>();
        for (Object[] resultado : resultados) {
            Carrera carrera = (Carrera) resultado[0];  // Entidad Carrera
            Long cantidadEstudiantes = (Long) resultado[1];  // Conteo de estudiantes

            System.out.println("Carrera: " + carrera.getNombre() + ", Cantidad de estudiantes: " + cantidadEstudiantes);

            CarreraCantEstudianteDTO dto = new CarreraCantEstudianteDTO(
                    carrera.getIdCarrera(),
                    carrera.getNombre(),
                    cantidadEstudiantes
            );
            carrerasDTO.add(dto);
        }

        System.out.println("Cantidad de carreras mapeadas a DTO: " + carrerasDTO.size());

        return carrerasDTO;
    }

}

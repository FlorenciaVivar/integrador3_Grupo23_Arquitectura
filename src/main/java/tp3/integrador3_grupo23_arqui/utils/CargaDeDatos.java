package tp3.integrador3_grupo23_arqui.utils;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;
import tp3.integrador3_grupo23_arqui.model.Carrera;
import tp3.integrador3_grupo23_arqui.model.Estudiante;
import tp3.integrador3_grupo23_arqui.model.EstudianteCarrera;
import tp3.integrador3_grupo23_arqui.repository.CarreraRepository;
import tp3.integrador3_grupo23_arqui.repository.EstudianteCarreraRepository;
import tp3.integrador3_grupo23_arqui.repository.EstudianteRepository;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

@Component
public class CargaDeDatos {

    private final EstudianteRepository estudianteRepository;
    private final CarreraRepository carreraRepository;
    private final EstudianteCarreraRepository estudianteCarreraRepository;

    @Autowired
    public CargaDeDatos(EstudianteRepository estudianteRepository, CarreraRepository carreraRepository, EstudianteCarreraRepository estudianteCarreraRepository) {
        this.estudianteRepository = estudianteRepository;
        this.carreraRepository = carreraRepository;
        this.estudianteCarreraRepository = estudianteCarreraRepository;
    }

    public void cargarDatosDesdeCSV() throws IOException {
        cargarEstudiantesDesdeCSV();
        cargarCarrerasDesdeCSV();
         cargarInscripcionesDesdeCSV();
    }

    public void cargarEstudiantesDesdeCSV() throws IOException {
        File archivoCSV = ResourceUtils.getFile("src/main/java/tp3/integrador3_grupo23_arqui/csv/Estudiantes.csv");
        try (FileReader reader = new FileReader(archivoCSV);
             CSVParser csvParser = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(reader)) {

            for (CSVRecord csvRecord : csvParser) {
                Estudiante estudiante = new Estudiante();
                estudiante.setNombre(csvRecord.get("nombre"));
                estudiante.setApellido(csvRecord.get("apellido"));
                estudiante.setEdad(Integer.parseInt(csvRecord.get("edad")));
                estudiante.setGenero(csvRecord.get("genero"));
                estudiante.setDNI(Integer.parseInt(csvRecord.get("dni")));
                estudiante.setNumLegajo(Long.parseLong(csvRecord.get("numLegajo")));
                estudiante.setCiudad(csvRecord.get("ciudad"));
                estudiante.setAntiguedadEnCarrera(Integer.parseInt(csvRecord.get("antiguedadEnCarrera")));

                estudianteRepository.save(estudiante);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void cargarCarrerasDesdeCSV() throws IOException {
        File archivoCSV = ResourceUtils.getFile("src/main/java/tp3/integrador3_grupo23_arqui/csv/Carreras.csv");
        try (FileReader reader = new FileReader(archivoCSV);
             CSVParser csvParser = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(reader)) {

            for (CSVRecord csvRecord : csvParser) {
                Carrera carrera = new Carrera();
                carrera.setNombre(csvRecord.get("nombre"));

                carreraRepository.save(carrera);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void cargarInscripcionesDesdeCSV() throws IOException {
        File archivoCSV = ResourceUtils.getFile("src/main/java/tp3/integrador3_grupo23_arqui/csv/estudianteCarrera.csv");
        try (FileReader reader = new FileReader(archivoCSV);
             CSVParser csvParser = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(reader)) {

            for (CSVRecord csvRecord : csvParser) {
                EstudianteCarrera ec = new EstudianteCarrera();

                Integer idCarrera = Integer.parseInt(csvRecord.get("id_carrera"));
                Integer idEstudiante = Integer.parseInt(csvRecord.get("id_estudiante"));

                Carrera carrera = carreraRepository.findById(idCarrera).orElseThrow(() -> new RuntimeException("Carrera no encontrada"));
                Estudiante estudiante = estudianteRepository.findById(idEstudiante).orElseThrow(() -> new RuntimeException("Estudiante no encontrado"));

                ec.setCarrera(carrera);
                ec.setEstudiante(estudiante);

                ec.setFechaComienzo(Integer.parseInt(csvRecord.get("inscripcion")));  // Fecha de inscripción como int
                ec.setEstaGraduado(csvRecord.get("graduacion") != null);              // Si tiene fecha de graduación, está graduado
                ec.setFechaGraduacion(csvRecord.get("graduacion") != null ? Integer.parseInt(csvRecord.get("graduacion")) : 0);  // Si no hay fecha de graduación, asigna 0

                estudianteCarreraRepository.save(ec);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
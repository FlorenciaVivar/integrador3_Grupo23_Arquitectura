package tp3.integrador3_grupo23_arqui.utils;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;
import tp3.integrador3_grupo23_arqui.model.Carrera;
import tp3.integrador3_grupo23_arqui.model.Estudiante;
import tp3.integrador3_grupo23_arqui.repository.CarreraRepository;
import tp3.integrador3_grupo23_arqui.repository.EstudianteRepository;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
@Component
public class CargaDeDatos {

    private final EstudianteRepository estudianteRepository;
    private final CarreraRepository carreraRepository;

    @Autowired
    public CargaDeDatos(EstudianteRepository estudianteRepository, CarreraRepository carreraRepository) {
        this.estudianteRepository = estudianteRepository;
        this.carreraRepository = carreraRepository;
    }

    public void cargarDatosDesdeCSV() throws IOException {
        cargarEstudiantesDesdeCSV();
        cargarCarrerasDesdeCSV();
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
}
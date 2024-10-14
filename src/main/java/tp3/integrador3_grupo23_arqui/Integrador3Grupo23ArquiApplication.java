package tp3.integrador3_grupo23_arqui;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tp3.integrador3_grupo23_arqui.utils.CargaDeDatos;
import java.io.IOException;

@SpringBootApplication
public class Integrador3Grupo23ArquiApplication {

    @Autowired
    private CargaDeDatos cargaDeDatos;

    public static void main(String[] args) {
        SpringApplication.run(Integrador3Grupo23ArquiApplication.class, args);
    }

    @PostConstruct
    public void init() throws IOException {
        cargaDeDatos.cargarDatosDesdeCSV();
    }

}
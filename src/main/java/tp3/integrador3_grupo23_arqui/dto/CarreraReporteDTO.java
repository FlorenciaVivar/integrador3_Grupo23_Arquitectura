package tp3.integrador3_grupo23_arqui.dto;

import lombok.*;

@Data
@NoArgsConstructor
public class CarreraReporteDTO {
    private String nombreCarrera;
    private Integer graduacion;
    private Long registrados;
    private Long graduados;

    public CarreraReporteDTO(String nombreCarrera, Integer graduacion, Long registrados, Long graduados) {
        this.nombreCarrera = nombreCarrera;
        this.graduacion = graduacion;
        this.registrados = registrados;
        this.graduados = graduados;
    }

    @Override
    public String toString() {
        return "CarreraReporteDTO{" +
                "nombreCarrera='" + nombreCarrera + '\'' +
                ", graduacion=" + graduacion +
                ", registrados=" + registrados +
                ", graduados=" + graduados +
                '}';
    }
}

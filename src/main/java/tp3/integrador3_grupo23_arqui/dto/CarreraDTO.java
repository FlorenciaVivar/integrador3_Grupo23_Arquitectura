package tp3.integrador3_grupo23_arqui.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarreraDTO {
    private int id;

    private String nombreCarrera;

    private Long cantEstudiantes;

    private Long cantGraduados;

    @Override
    public String toString() {
        return "CarreraDTO{" +
                "id=" + id +
                ", nombreCarrera='" + nombreCarrera + '\'' +
                ", cantEstudiantes=" + cantEstudiantes +
                ", cantGraduados=" + cantGraduados +
                '}';
    }
}

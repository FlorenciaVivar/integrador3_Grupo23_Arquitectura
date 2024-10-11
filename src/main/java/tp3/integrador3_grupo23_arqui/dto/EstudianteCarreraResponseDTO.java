package tp3.integrador3_grupo23_arqui.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class EstudianteCarreraResponseDTO extends EstudianteCarreraRequestDTO{

    private String carreraNombre;
    private Long cantEstudiantes;

    @Override
    public String toString() {
        return "EstudianteCarreraDTO{" +
                "carreraNombre='" + carreraNombre + '\'' +
                ", cantEstudiantes=" + cantEstudiantes +
                '}';
    }
}

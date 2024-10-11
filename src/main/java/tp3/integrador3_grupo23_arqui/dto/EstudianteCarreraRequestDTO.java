package tp3.integrador3_grupo23_arqui.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EstudianteCarreraRequestDTO {

    private Integer idEstudiante;

    private Integer idCarrera;
}

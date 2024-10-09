package tp3.integrador3_grupo23_arqui.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EstudianteDTO {
    private int dni;

    private String nombre;

    private String apellido;

    private String genero;

    private int edad;

    private Long numLegajo;

    private String ciudad;

    @Override
    public String toString() {
        return "EstudianteDTO{" +
                "dni=" + dni +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", genero='" + genero + '\'' +
                ", edad=" + edad +
                ", numLegajo=" + numLegajo +
                ", ciudad='" + ciudad + '\'' +
                '}';
    }
}

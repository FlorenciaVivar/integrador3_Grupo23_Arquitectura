package tp3.integrador3_grupo23_arqui.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarreraCantEstudianteDTO {
    private int id;
    private String nombre;
    private long cantidad;

    @Override
    public String toString() {
        return "CarreraCantEstudianteDTO{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", cantidad=" + cantidad +
                '}';
    }
}

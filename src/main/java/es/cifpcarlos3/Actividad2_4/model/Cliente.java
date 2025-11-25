package es.cifpcarlos3.Actividad2_4.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Cliente {
    int id;
    String dni;
    String nombre;
    int telefono;
    String email;
}

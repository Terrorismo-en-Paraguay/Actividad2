package es.cifpcarlos3.Actividad2_3.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Pais {
    private int cod_continente;
    private int codigo;
    private String nombre;
    private String capital;
}

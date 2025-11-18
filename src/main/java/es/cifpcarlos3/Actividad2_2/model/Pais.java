package es.cifpcarlos3.Actividad2_2.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Pais {
    private int cod_continente;
    private int codigo;
    private String nombre;
    private String capital;

    @Override
    public String toString() {
        return
                "cod_continente=" + cod_continente +
                ", codigo=" + codigo +
                ", nombre='" + nombre + '\'' +
                ", capital='" + capital + '\'';
    }
}

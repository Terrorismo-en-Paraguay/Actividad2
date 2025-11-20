package es.cifpcarlos3.Actividad2_4.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class Cuenta {
    int id;
    String numeroCuenta;
    int idcliente;
    float saldo;
}

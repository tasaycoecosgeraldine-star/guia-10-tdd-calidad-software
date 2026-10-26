
package com.ejemplo;

public class ProcesadorPagos {

    private final ServicioBancoExternal servicioBanco;
    private final CalculadoraITF calculadoraITF;

    public ProcesadorPagos(
            ServicioBancoExternal servicioBanco,
            CalculadoraITF calculadoraITF) {

        this.servicioBanco = servicioBanco;
        this.calculadoraITF = calculadoraITF;
    }

    public String realizarPago(double monto) {

        if (monto <= 0) {
            throw new IllegalArgumentException(
                "El monto debe ser mayor que cero"
            );
        }

        double impuesto = calculadoraITF.calcularITF(monto);

        double total = monto + impuesto;

        return servicioBanco.procesarTransaccion(total);
    }
}


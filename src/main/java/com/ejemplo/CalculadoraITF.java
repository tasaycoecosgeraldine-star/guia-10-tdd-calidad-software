
package com.ejemplo;

public class CalculadoraITF {

    private static final double UMBRAL_TRANSACCION = 1000.0;
    private static final double TASA_ITF = 0.00005;

    public double calcularITF(double montoTransaccion) {

        if (montoTransaccion <= UMBRAL_TRANSACCION) {
            return 0.0;
        }

        return montoTransaccion * TASA_ITF;
    }
}

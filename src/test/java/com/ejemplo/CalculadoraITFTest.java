
package com.ejemplo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class CalculadoraITFTest {

    private final CalculadoraITF calculadora =
            new CalculadoraITF();

    @Test
    void noDebeAplicarITFSiEsMenorA1000() {
        assertEquals(0.0, calculadora.calcularITF(500.0), 0.000001);
    }

    @Test
    void noDebeAplicarITFSiEsIgualA1000() {
        assertEquals(0.0, calculadora.calcularITF(1000.0), 0.000001);
    }

    @Test
    void debeAplicarITFSiSupera1000() {
        assertEquals(0.05005, calculadora.calcularITF(1001.0), 0.000001);
    }

    @Test
    void debeCalcularITFPara2000() {
        assertEquals(0.10, calculadora.calcularITF(2000.0), 0.000001);
    }

    @Test
    void debeCalcularITFPara5000() {
        assertEquals(0.25, calculadora.calcularITF(5000.0), 0.000001);
    }
}

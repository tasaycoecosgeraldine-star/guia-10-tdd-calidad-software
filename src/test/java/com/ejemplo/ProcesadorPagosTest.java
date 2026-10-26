
package com.ejemplo;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;

public class ProcesadorPagosTest {

    @Test
    void debeProcesarTransaccionExitosa() {

        ServicioBancoExternal bancoMock =
                mock(ServicioBancoExternal.class);

        CalculadoraITF calculadora =
                new CalculadoraITF();

        ProcesadorPagos procesador =
                new ProcesadorPagos(bancoMock, calculadora);

        when(bancoMock.procesarTransaccion(2000.10))
                .thenReturn("Transacción Exitosa");

        String resultado = procesador.realizarPago(2000.0);

        assertEquals("Transacción Exitosa", resultado);

        verify(bancoMock, times(1))
                .procesarTransaccion(2000.10);
    }

    @Test
    void debeProcesarPagoSinITF() {

        ServicioBancoExternal bancoMock =
                mock(ServicioBancoExternal.class);

        ProcesadorPagos procesador =
                new ProcesadorPagos(
                    bancoMock, new CalculadoraITF()
                );

        when(bancoMock.procesarTransaccion(500.0))
                .thenReturn("Transacción Exitosa");

        String resultado = procesador.realizarPago(500.0);

        assertEquals("Transacción Exitosa", resultado);

        verify(bancoMock, times(1))
                .procesarTransaccion(500.0);
    }

    @Test
    void debeRechazarMontoInvalido() {

        ServicioBancoExternal bancoMock =
                mock(ServicioBancoExternal.class);

        ProcesadorPagos procesador =
                new ProcesadorPagos(
                    bancoMock, new CalculadoraITF()
                );

        assertThrows(
            IllegalArgumentException.class,
            () -> procesador.realizarPago(-100.0)
        );

        verifyNoInteractions(bancoMock);
    }
}

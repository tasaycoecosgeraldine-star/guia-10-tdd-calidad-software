package com.ejemplo;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
@ExtendWith(MockitoExtension.class) 
public class CalculadoraDescuentosTest {
@Mock
private ServicioClienteVip servicioMock; // Creamos el simulador
@InjectMocks
private CalculadoraDescuentos calculadora; // Inyecta el simulador en la calculadora
@Test
public void deberiaAplicarDiezPorCientoSiElClienteEsVip() {
// 1. Configurar el Mock (Simulamos que el cliente 500 SÍ es VIP)
when(servicioMock.esUsuarioVip(500)).thenReturn(true);
// 2. Ejecutar el código a probar
double precioFinal = calculadora.calcularPrecioFinal(100.0, 500);
// 3. Verificar (Monto 100 con 10% de descuento = 90.0)
assertEquals(90.0, precioFinal);
// Verificar que el método del mock se llamó exactamente una vez
verify(servicioMock, times(1)).esUsuarioVip(500);
}
@Test
public void deberiaDarCeroDescuentoSiElClienteNoEsVip() {
// 1. Configurar el Mock (Simulamos que el cliente 101 NO es VIP)
when(servicioMock.esUsuarioVip(101)).thenReturn(false);
// 2. Ejecutar
double precioFinal = calculadora.calcularPrecioFinal(100.0, 101);
// 3. Verificar (Monto 100 con 0% de descuento = 100.0)
assertEquals(100.0, precioFinal);
verify(servicioMock, times(1)).esUsuarioVip(101);
}
}
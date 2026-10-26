package com.ejemplo;  
  public class CalculadoraDescuentos {  
      private final ServicioClienteVip servicioClienteVip;    
    // El constructor recibe la dependencia (esto permite que Mockito le pase el simulador)     
     public CalculadoraDescuentos(ServicioClienteVip servicioClienteVip) {         
        this.servicioClienteVip = servicioClienteVip;  
    }   
    public double calcularPrecioFinal(double precioBase, int idCliente) {  
        // Consultamos al servicio simulado  
        boolean esVip = servicioClienteVip.esUsuarioVip(idCliente);                   
        if (esVip) {              
            return precioBase * 0.90; // Aplica el 10% de descuento  
        }           
        return precioBase; // Sin descuento      
        } 
    }  

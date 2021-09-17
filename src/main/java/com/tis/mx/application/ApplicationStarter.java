package com.tis.mx.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.tis.mx.application.dto.Producto;

@SpringBootApplication
public class ApplicationStarter {

	public static void main(String[] args) {
	  
	  SpringApplication.run(ApplicationStarter.class, args);
		
		/*Producto producto = new Producto("nombre producto", 2000.00, "Descripcion", 100);	
		Producto producto2 = new Producto();
				
		producto.getCantidadDisponible();
		
		System.out.println(producto);*/
	}
}

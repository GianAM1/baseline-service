package com.tis.mx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import com.tis.mx.application.dto.Producto;

@SpringBootApplication
@EnableDiscoveryClient
public class ApplicationStarter {

	public static void main(String[] args) {
	  
	  SpringApplication.run(ApplicationStarter.class, args);
		
		/*Producto producto = new Producto("nombre producto", 2000.00, "Descripcion", 100);	
		Producto producto2 = new Producto();
				
		producto.getCantidadDisponible();
		
		System.out.println(producto);*/
	}
}

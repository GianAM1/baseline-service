package com.tis.mx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import com.tis.mx.application.dto.Producto;

@SpringBootApplication
@EnableDiscoveryClient
@EnableHystrix
@EnableHystrixDashboard
public class ApplicationStarter {

	public static void main(String[] args) {
	  
	  SpringApplication.run(ApplicationStarter.class, args);
		
		/*Producto producto = new Producto("nombre producto", 2000.00, "Descripcion", 100);	
		Producto producto2 = new Producto();
				
		producto.getCantidadDisponible();
		
		System.out.println(producto);*/
	}
}

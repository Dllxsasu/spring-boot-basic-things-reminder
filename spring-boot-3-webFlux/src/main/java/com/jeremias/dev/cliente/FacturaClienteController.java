package com.jeremias.dev.cliente;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jeremias.dev.dominio.Factura;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@RestController
public class FacturaClienteController {

	private final ClienteFacturasService servicio;

	@GetMapping("/lista1")
	  public List<Factura> lista() {
		    
		    List<Factura> lista= new ArrayList<Factura>();
		    lista.addAll(servicio.buscarTodasv1());
		    lista.addAll(servicio.buscarTodasv1());
		    lista.addAll(servicio.buscarTodasv1());
		    
		  
		    return lista;
	}/*

	@GetMapping("/lista2")
	public List<Factura> lista2() {

		Mono<List<Factura>> mono  =servicio.buscarTodasv2().collectList();
		
		List<Factura> lista =mono.block();
				//servicio.buscarTodasv2().collectList().block();
		return lista;

	}
	*/
}

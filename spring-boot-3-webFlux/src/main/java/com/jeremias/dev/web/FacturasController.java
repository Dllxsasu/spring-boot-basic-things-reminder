package com.jeremias.dev.web;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jeremias.dev.dominio.Factura;

import reactor.core.publisher.Flux;

@RestController
public class FacturasController {
	@GetMapping("/facturasv1")
	  public List<Factura> buscarTodas() {
	    
	    
	    List<Factura> lista= new ArrayList<Factura>();
	    lista.add(new Factura(1,"ordenador",200));
	    lista.add(new Factura(2,"tablet",300));
	    try {
	      Thread.sleep(3000);
	    } catch (InterruptedException e) {
	      
	      e.printStackTrace();
	    }
	    return lista;
	    
	    
	  }
	
	@GetMapping("/facturasv2")
	  public Flux<Factura> buscarTodasv2() {
	    
	    
	Flux<Factura> lista= Flux.just(new Factura(1,"ordenador",200)
	,new Factura(2,"tablet",300)).delaySequence(Duration.ofSeconds(3));
	    
	    return lista;
	  }
}

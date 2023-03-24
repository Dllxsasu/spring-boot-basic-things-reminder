package com.jeremias.dev.cliente;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.jeremias.dev.dominio.Factura;

import reactor.core.publisher.Flux;

@Service
public class ClienteFacturasService {
	public List<Factura> buscarTodasv1() {
	    RestTemplate plantilla = new RestTemplate();
	    Factura[] facturas = plantilla.getForObject("http://localhost:8080/facturasv1", Factura[].class);
	    List<Factura> lista = Arrays.asList(facturas);
	    return lista;
	  }
	
	public Flux<Factura> buscarTodasv2() {
		 WebClient cliente = WebClient.create("http://localhost:8080/facturasv2");
		    Flux<Factura> facturas=cliente.get().retrieve().bodyToFlux(Factura.class);
		    Flux<Factura> facturas2=cliente.get().retrieve().bodyToFlux(Factura.class);
		    Flux<Factura> facturas3=cliente.get().retrieve().bodyToFlux(Factura.class);
		    Flux<Factura> todas=Flux.merge(facturas,facturas2,facturas3);
		    System.out.println(todas +" aqui todo okey");
		    return todas;
	  }
}


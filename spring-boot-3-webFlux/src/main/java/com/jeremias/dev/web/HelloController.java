package com.jeremias.dev.web;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jeremias.dev.cliente.ClienteFacturasService;
import com.jeremias.dev.dominio.Factura;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@RestController
public class HelloController {
	
	private final ClienteFacturasService servicio;
	@GetMapping("/hello")
    public Mono<String> hello() {
        return Mono.just("Welcome to reactive world ~");
    }
	
	@GetMapping("/lista22")
	public List<Factura> lista2() {

		Mono<List<Factura>> mono  =servicio.buscarTodasv2().collectList();
		
		List<Factura> lista =mono.block();
				//servicio.buscarTodasv2().collectList().block();
		return lista;

	}
}

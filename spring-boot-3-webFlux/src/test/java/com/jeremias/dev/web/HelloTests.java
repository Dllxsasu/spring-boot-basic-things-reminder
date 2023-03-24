package com.jeremias.dev.web;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@ExtendWith(MockitoExtension.class)
@WebFluxTest(controllers = HelloController.class)
public class HelloTests {
	@Autowired
    WebTestClient client;

    @Test
    public void getHello() {
        client.get().uri("/hello").exchange().expectStatus().isOk();
    }
}

package com.jeremias.dev.application;

import com.jeremias.dev.loki.LokiService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("prueba")
@RequiredArgsConstructor
public class PruebisController {
    private final LokiService lokiService;

    @GetMapping
    public String lokiMesage(){
        return lokiService.lokiFrase();
    }
}

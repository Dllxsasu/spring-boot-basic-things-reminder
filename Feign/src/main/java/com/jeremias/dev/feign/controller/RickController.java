package com.jeremias.dev.feign.controller;

import com.jeremias.dev.feign.core.Bodyx;
import com.jeremias.dev.feign.core.Movie;
import com.jeremias.dev.feign.core.MovieClient;
import com.jeremias.dev.feign.core.Service;
import com.jeremias.dev.feign.models.Character;
import com.jeremias.dev.feign.models.Episode;
import com.jeremias.dev.feign.services.RickService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("")
public class RickController {
    private final  RickService rickService;
    private final MovieClient movieClient;
    @GetMapping("/character/{id}")
    public Character getCharacterById(@PathVariable int id){
        return rickService.getCharacterById(id);
    }
    @GetMapping("/location/{id}")
    public Character.Location getLocationById(@PathVariable int id){
        return rickService.getLocationById(id);
    }
    @GetMapping("/episode/{id}")
    public Episode getEpisodeById(@PathVariable int id){
        return rickService.getEpisodeById(id);
    }
    @GetMapping("/prueba")
    public Movie prueba(){
        return movieClient.getMovieId(76341, "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJhZDY0MDI0NmRmYmYzZTA4NGY4MDNiMWExNjBmNmUwMCIsInN1YiI6IjY0MGQ3M2QzYTg5NGQ2MDBkN2FiYjVhMSIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.fCRy-3R7O06PrFWaSeTqUZaPWhTUXnkWeafbHcJwoTo");
    }
    @PostMapping("/prueba2")
    public Bodyx prueba(@RequestBody Bodyx s){
        return s;
    }
}

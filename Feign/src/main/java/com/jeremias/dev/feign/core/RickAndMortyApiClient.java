package com.jeremias.dev.feign.core;

import com.jeremias.dev.feign.models.Character;
import com.jeremias.dev.feign.models.Episode;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "rickAndMortyApi", url = "https://rickandmortyapi.com/api")
public interface RickAndMortyApiClient {
    @GetMapping("/character/{id}")
    Character getCharacterById(@PathVariable("id") int id);

    @GetMapping("/location/{id}")
    Character.Location getLocationById(@PathVariable("id") int id);

    @GetMapping("/episode/{id}")
    Episode getEpisodeById(@PathVariable("id") int id);
}

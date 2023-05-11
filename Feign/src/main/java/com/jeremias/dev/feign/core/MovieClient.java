package com.jeremias.dev.feign.core;

import com.jeremias.dev.feign.models.Character;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "movieApi", url = "https://api.themoviedb.org/3/movie")
public interface MovieClient {
    @GetMapping("/{id}")
    Movie getMovieId(@PathVariable("id") int id,@RequestHeader("Authorization") String token);
}

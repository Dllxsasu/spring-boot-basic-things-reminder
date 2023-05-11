package com.jeremias.dev.feign.services.impl;

import com.jeremias.dev.feign.models.Character;
import com.jeremias.dev.feign.models.Episode;
import com.jeremias.dev.feign.repository.RickRepository;
import com.jeremias.dev.feign.services.RickService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RickServiceImpl implements RickService {
    private final RickRepository repository;
    @Override
    public Character getCharacterById(int id) {
        return repository.getCharacterById(id);
    }

    @Override
    public Character.Location getLocationById(int id) {
        return repository.getLocationById(id);
    }

    @Override
    public Episode getEpisodeById(int id) {
        return repository.getEpisodeById(id);
    }
}

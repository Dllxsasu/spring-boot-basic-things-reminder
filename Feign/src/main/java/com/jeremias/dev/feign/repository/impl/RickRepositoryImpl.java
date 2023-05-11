package com.jeremias.dev.feign.repository.impl;

import com.jeremias.dev.feign.core.RickAndMortyApiClient;
import com.jeremias.dev.feign.models.Character;
import com.jeremias.dev.feign.models.Episode;
import com.jeremias.dev.feign.repository.RickRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RickRepositoryImpl implements RickRepository {
    private final RickAndMortyApiClient client;
    @Override
    public Character getCharacterById(int id) {
        return client.getCharacterById(id);
    }

    @Override
    public Character.Location getLocationById(int id) {
        return client.getLocationById(id);
    }

    @Override
    public Episode getEpisodeById(int id) {
        return client.getEpisodeById(id);
    }
}

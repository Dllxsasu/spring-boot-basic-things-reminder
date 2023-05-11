package com.jeremias.dev.feign.services;

import com.jeremias.dev.feign.models.Character;
import com.jeremias.dev.feign.models.Episode;

public interface RickService {
    public Character getCharacterById(int id);

    public Character.Location getLocationById(int id);

    public Episode getEpisodeById(int id);
}

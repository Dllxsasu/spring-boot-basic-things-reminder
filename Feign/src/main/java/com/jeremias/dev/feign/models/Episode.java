package com.jeremias.dev.feign.models;

import lombok.Data;

import java.util.List;
@Data
public class Episode {
    private int id;
    private String name;
    private String air_date;
    private String episode;
    private List<String> characters;
    private String url;
    private String created;
}

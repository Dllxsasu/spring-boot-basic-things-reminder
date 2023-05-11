package com.jeremias.dev.feign.core;

import lombok.Data;

import java.util.List;

@Data
public class Movie {
        private boolean adult;
        private String backdrop_path;
        private Object belongs_to_collection;
        private int budget;
        private List<Object> genres;
        private String homepage;
        private int id;
        private String imdb_id;
        private String original_language;
        private String original_title;
        private String overview;
        private double popularity;
        private String poster_path;
        private List<Object> production_companies;
        private List<Object> production_countries;
        private String release_date;
        private int revenue;
        private int runtime;
        private List<Object> spoken_languages;
        private String status;
        private String tagline;
        private String title;
        private boolean video;
        private double vote_average;
        private int vote_count;

        // Constructor, getters and setters here...

        // Constructor, getters and setters here...
}


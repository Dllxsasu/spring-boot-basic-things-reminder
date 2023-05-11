package com.jeremias.dev.feign.models;

import lombok.Data;

import java.util.List;

@Data
public class Page {
    PageInfo info;
    List<Character> results;
    public static class PageInfo {
        private int count;
        private int pages;
        private String next;
        private String prev;

        // Constructor, getters y setters aquí...

        // Constructor, getters y setters aquí...
    }

}

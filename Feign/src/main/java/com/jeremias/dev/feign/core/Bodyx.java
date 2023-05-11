package com.jeremias.dev.feign.core;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Bodyx {
    @JsonProperty("return")
    public tito returnx;

    @Data
    public static class tito {
        public String piedra;
    }

}

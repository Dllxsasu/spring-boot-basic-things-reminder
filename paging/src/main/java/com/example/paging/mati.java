package com.example.paging;

import java.util.List;

public class mati {

    public static double avg(List<Integer> numeros){
       return numeros.stream().mapToDouble(value -> value).average().orElse(Double.NaN);
    }

}

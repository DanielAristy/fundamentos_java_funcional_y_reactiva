package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
	// write your code here
        //Forma imperativa
        System.out.println(intersectionImperative(List.of(1,2,3),List.of(1,3,5)));

        //Forma Declarativa
        List<Integer> a = Arrays.asList(1,2,3);
        List<Integer> b = Arrays.asList(1,2,3);
        System.out.println(intersectionFuntional.apply(a,b));

    }

    /**
     * Programación imperativa
     * En este ejemplo se comparar los elementos de listas y retorna una lista ordenada
     * */
    public static List<Integer> intersectionImperative(List<Integer> a, List<Integer> b){
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < a.size() ; i++) {
            for (int j = 0; j < b.size() ; j++) {
                if (a.get(i).equals(b.get(j))){
                    result.add(a.get(i));
                    break;
                }
            }
        }
        Collections.sort(result);
        return result;
    }

    /**Programacion Descriptiva*/
    public static BiFunction<List<Integer>,List<Integer>,List<Integer>> intersectionFuntional = (a, b) -> a.stream()
            .filter(b::contains)//Método de referencia
            .collect(Collectors.toList());
}

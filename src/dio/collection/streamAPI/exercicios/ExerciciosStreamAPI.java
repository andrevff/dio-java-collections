package dio.collection.streamAPI.exercicios;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ExerciciosStreamAPI {
    public static void main(String[] args) {
        List<String> numeros = Arrays.asList("1", "0", "4", "1", "2", "3", "9", "9", "6", "5");

        System.out.println("---Imprima todos os elementos da lista: ");
        numeros.stream().forEach(new Consumer<String>() {
            @Override
            public void accept(String n) {
                System.out.println(n);
            }
            
        });

        System.out.println("Pegue os 5 primeiros numeros: ");
        numeros.stream().limit(5);

    }
}

package dio.collection.list.exercicios;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Exercicio2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<String> respostas = new ArrayList<>();

        System.out.println("Responda com S para sim, e N para nao");
        System.out.println("1. Telefonou para a vitima? ");
        respostas.add(scanner.next());

        System.out.println("2. Esteve no local do crime? ");
        respostas.add(scanner.next());

        System.out.println("3. Mora perto da vitima? ");
        respostas.add(scanner.next());

        System.out.println("4. Devia para a vitima? ");
        respostas.add(scanner.next());

        System.out.println("5. Ja trabalhou com a vitima? ");
        respostas.add(scanner.next());

        Iterator<String> iterator = respostas.iterator();
        int cont = 0;
        while(iterator.hasNext()) {
            String next = iterator.next();
            if(next.contains("s")) {
                cont++;
            }
        }

        System.out.println("Pontuacao: " + cont);

        if(cont == 2){
            System.out.println("Declarado(a) SUSPEITO(A)");
        } else {
            if(cont == 3 || cont == 4) {
                System.out.println("Declarado(a) CUMPLICE");
            } else {
                if(cont == 5) {
                    System.out.println("Declarado(a) ASSASSINO(A)");
                } else {
                    System.out.println("Declarado(a) INOCENTE");
                }
            }
        }
    }
}

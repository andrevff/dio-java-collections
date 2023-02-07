package dio.collection.set.exercicios;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Exercicio1 {
    public static void main(String[] args) {
        Set<String> cores = new HashSet<>(Arrays.asList("vermelho", "laranja", "amarelo", "verde", "azul", "anil", "violeta"));

        System.out.println("---Exiba todas as cores uma abaixo da outra: ");
        for (String cor : cores) {
            System.out.println(cor);
        }

        System.out.println("---Quantidade de cores do arco-iris: " + cores.size());

        System.out.println("---Exiba as cores em ordem alfabética: ");
        Set<String> cores2 = new TreeSet<>(cores);
        System.out.println(cores2);

        System.out.println("---Exiba as cores na ordem inversa da que foi informada: ");
        Set<String> cores3 = new LinkedHashSet<>(Arrays.asList("vermelho", "laranja", "amarelo", "verde", "azul", "anil", "violeta"));
        System.out.println(cores3);
        List<String> coresList = new ArrayList<>(cores3);
        Collections.reverse(coresList);
        System.out.println(coresList);

        System.out.println("---Exiba todas as cores que começam com a letra v:  ");
        for (String cor : cores) {
            if(cor.startsWith("v")) System.out.println(cor);
        }

        System.out.println("---Remova todas as cores que nao comecam com a letra v: ");
        Iterator<String> iterator = cores.iterator();
        while(iterator.hasNext()){
            if(!iterator.next().startsWith("v")) iterator.remove();
        }
        System.out.println(cores);

        System.out.println("---Limpe o conjunto: ");
        cores.clear();

        System.out.println("---Verifique se o conjunto esta vazio: " + cores.isEmpty());

    }
}

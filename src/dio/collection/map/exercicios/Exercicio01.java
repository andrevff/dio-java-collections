package dio.collection.map.exercicios;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class Exercicio01 {
    public static void main(String[] args) {
        System.out.println("---Crie um dicionario que relacione os estados e suas populacoes: ");
        Map<String, Integer> estados = new HashMap<>(){{
            put("PE", 9616621);
            put("AL", 3351543);
            put("CE", 9187103);
            put("RN", 3534265);
        }};
        System.out.println(estados.toString());

        System.out.println("---Substitua a populacao do estado do RN por 3.534.165: ");
        estados.put("RN", 3534165);
        System.out.println(estados.toString());

        System.out.println("---Confira se o estado PB esta no dicionario, caso nao, adicione PB = 4.039.277: ");
        if(estados.containsKey("PB") == false){
            estados.put("PB", 4039277);
        }
        System.out.println(estados.toString());

        System.out.println("---Exiba a populacao de PE: " + estados.get("PE"));

        System.out.println("---Exiba os estados na ordem que foram informados: ");
        Map<String, Integer> estados2 = new LinkedHashMap<>(){{
            put("PE", 9616621);
            put("AL", 3351543);
            put("CE", 9187103);
            put("RN", 3534165);
            put("PB", 4039277);
        }};
        System.out.println(estados2.toString());

        System.out.println("---Exiba os estados em ordem alfabetica: ");
        Map<String, Integer> estados3 = new TreeMap<>(estados2);
        System.out.println(estados3.toString());

        System.out.println("---Exiba o estado com menor populacao: ");
        Integer menorPopulacao = Collections.min(estados2.values());
        String estadoMenosPopuloso = "";
        for(Map.Entry<String, Integer> entry : estados2.entrySet()){
            if(entry.getValue().equals(menorPopulacao)) estadoMenosPopuloso = entry.getKey();
        }
        System.out.println(estadoMenosPopuloso + " - " + menorPopulacao);

        System.out.println("---Exiba o estado com maior populacao: ");
        Integer maiorPopulacao = Collections.max(estados2.values());
        String estadoMaisPopuloso = "";
        for(Map.Entry<String, Integer> entry : estados2.entrySet()){
            if(entry.getValue().equals(maiorPopulacao)) estadoMaisPopuloso = entry.getKey();
        }
        System.out.println(estadoMaisPopuloso + " - " + maiorPopulacao);

        System.out.println("---Exiba a soma da populacao desses estados: ");
        Iterator<Integer> iterator = estados2.values().iterator();
        Integer soma = 0;
        while(iterator.hasNext()){
            soma += iterator.next();
        }
        System.out.println(soma);

        System.out.println("---Exiba a media das populacoes: " + (soma/estados2.size()));

        System.out.println("---Remova os estados com populacao menor que 4.000.000: ");
        Iterator<Integer> iterator2 = estados2.values().iterator();
        while(iterator2.hasNext()){
            if(iterator2.next() < 4000000) iterator2.remove();
        }
        System.out.println(estados2.toString());

        System.out.println("---Apague o dicionario de estados: ");
        estados2.clear();

        System.out.println("---Verifique se o dicionario esta vazio: " + estados2.isEmpty());

    }
}

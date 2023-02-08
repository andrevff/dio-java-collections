package dio.collection.map;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class ExemploMap {
    public static void main(String[] args) {
        System.out.println("Crie um dicionario que relacione o modelo e seus respectivos consumos: ");
        Map<String, Double> carros = new HashMap<>(){{
            put("gol", 15.1);
            put("uno", 15.6);
            put("mobi", 16.1);
            put("hb20", 14.5);
            put("kwid", 15.6);
        }};
        System.out.println(carros.toString());

        System.out.println("---Substitua o consumo do gol por 15.2 km/l: ");
        carros.put("gol", 15.2);
        System.out.println(carros.toString());

        System.out.println("---Confira se o modelo tucson está no dicionário: " + carros.containsKey("tucson"));

        System.out.println("---Exiba o consumo do uno: " + carros.get("uno"));

        System.out.println("---Exiba os modelos: ");
        Set<String> modelos = carros.keySet();
        System.out.println(modelos);

        System.out.println("---Exiba os consumos dos carros: ");
        Collection<Double> consumos = carros.values();
        System.out.println(consumos);

        System.out.println("---Exiba o modelo mais economico e o seu consumo: ");
        Double consumoMaisEficiente = Collections.max(carros.values());
        Set<Map.Entry<String, Double>> entries = carros.entrySet();
        String modeloMaisEficiente = "";
        for(Map.Entry<String, Double> entry: entries){
            if(entry.getValue().equals(consumoMaisEficiente)) modeloMaisEficiente = entry.getKey();
        }
        System.out.println(modeloMaisEficiente + " - " + consumoMaisEficiente);

        System.out.println("---Exiba o modelo menos economico e seu consumo: ");
        Double consumoMenosEficiente = Collections.min(carros.values());
        String modeloMenosEficiente = "";
        for (Map.Entry<String,Double> entry : carros.entrySet()) {
            if(entry.getValue().equals(consumoMenosEficiente)) modeloMenosEficiente = entry.getKey();
        }
        System.out.println(modeloMenosEficiente + " - " + consumoMenosEficiente);

        System.out.println("---Exiba as somas dos consumos: ");
        Iterator<Double> iterator = carros.values().iterator();
        Double soma = 0d;
        while(iterator.hasNext()){
            soma += iterator.next();
        }
        System.out.println(soma);

        System.out.println("---Exiba a média dos consumos: " + (soma/carros.size()));

        System.out.println("---Remova os modelos com o consumo igual a 15,6km/l: ");
        Iterator<Double> iterator2 = carros.values().iterator();
        while(iterator2.hasNext()){
            if(iterator2.next().equals(15.6)){
                iterator2.remove();
            }
        }
        System.out.println(carros);

        System.out.println("---Exiba todos os carros na ordem que foram informados: ");
        Map<String, Double> carros2 = new LinkedHashMap<>(){{
            put("gol", 15.2);
            put("uno", 15.6);
            put("mobi", 16.1);
            put("hb20", 14.5);
            put("kwid", 15.6);
        }};
        System.out.println(carros2.toString());

        System.out.println("---Exiba o dicionário ordenado pelo modelo: ");
        Map<String, Double> carros3 = new TreeMap<>(carros2);
        System.out.println(carros3.toString());

        System.out.println("---Apague o dicionario de carros: ");
        carros.clear();

        System.out.println("---Confira se o dicionario esta vazio: " + carros.isEmpty());

    }
}

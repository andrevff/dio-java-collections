package dio.collection.list.exercicios;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Exercicio1 {
    public static void main(String[] args) {
        List<Temperaturas> temperaturas = new ArrayList<>(){{
            add(new Temperaturas("1-Janeiro", 30.0));
            add(new Temperaturas("2-Fevereiro", 32.2));
            add(new Temperaturas("3-Marco", 29.5));
            add(new Temperaturas("4-Abril", 27.2));
            add(new Temperaturas("5-Maio", 25.1));
            add(new Temperaturas("6-Junho", 21.3));
        }};
        System.out.println("---Médias mensais de temperatura---");
        System.out.println(temperaturas);

        Iterator<Temperaturas> iterator = temperaturas.iterator();
        double soma = 0.0;
        while(iterator.hasNext()){
            Double next = iterator.next().getTemperatura();
            soma += next;
        }
        double media = soma/temperaturas.size();

        System.out.println("---Média Semestral---");
        System.out.println("Média: " + media);

        System.out.println("---Temperaturas acima da média---");
        Iterator<Temperaturas> iterator2 = temperaturas.iterator();
        while(iterator2.hasNext()){
            Double next = iterator2.next().getTemperatura();
            if(next < media) iterator2.remove();
        }
        System.out.println(temperaturas);
    }
}

class Temperaturas {
    private String mes;
    private Double temperatura;

    public Temperaturas(String mes, Double temperatura) {
        this.mes = mes;
        this.temperatura = temperatura;
    }

    public String getMes() {
        return mes;
    }

    public Double getTemperatura() {
        return temperatura;
    }

    @Override
    public String toString() {
        return "[mes=" + mes + ", temperatura=" + temperatura + "]";
    }

}

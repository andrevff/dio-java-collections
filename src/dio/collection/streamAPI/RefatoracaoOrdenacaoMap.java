package dio.collection.streamAPI;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.TreeMap;
import java.util.TreeSet;

public class RefatoracaoOrdenacaoMap {
    public static void main(String[] args) {
        System.out.println("--- Ordem Aleatoria ---");
        Map<Integer, Contato> agenda = new HashMap<>(){{
            put(1, new Contato("Bob", 11111));
            put(4, new Contato("Jon", 55555));
            put(5, new Contato("Doe", 33333));
        }};
        System.out.println(agenda);
        for (Map.Entry<Integer, Contato> entry:  agenda.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue().getNome());
        }

        System.out.println("--- Ordem de Insercao ---");
        Map<Integer, Contato> agenda2 = new LinkedHashMap<>(){{
            put(1, new Contato("Bob", 11111));
            put(4, new Contato("Jon", 55555));
            put(5, new Contato("Doe", 33333));
        }};
        System.out.println(agenda2);
        for (Map.Entry<Integer, Contato> entry: agenda2.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue().getNome());
        }

        System.out.println("--- Ordem ID ---");
        Map<Integer, Contato> agenda3 = new TreeMap<>(agenda2);
        System.out.println(agenda3);
        for (Map.Entry<Integer, Contato> entry: agenda3.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue().getNome());
        }

        System.out.println("--- Ordem numero telefone ---");

        /*Classe anonima 
        Set<Map.Entry<Integer, Contato>> agenda4 = new TreeSet<>(new Comparator<Map.Entry<Integer, Contato>>() {

            @Override
            public int compare(Entry<Integer, Contato> c1, Entry<Integer, Contato> c2) {
                return Integer.compare(c1.getValue().getNumero(), c2.getValue().getNumero());
            }
            
        });*/

        /*Function
        Set<Map.Entry<Integer, Contato>> agenda4 = new TreeSet<>(Comparator.comparing(
            new Function<Map.Entry<Integer, Contato>, Integer>() {

                @Override
                public Integer apply(Entry<Integer, Contato> c) {
                    return c.getValue().getNumero();
                }
                
            }
        ));*/

        /*Lambda */
        Set<Map.Entry<Integer, Contato>> agenda4 = new TreeSet<>(Comparator.comparing(
            c -> c.getValue().getNumero()
        ));
        agenda4.addAll(agenda.entrySet());
        for (Map.Entry<Integer, Contato> entry: agenda4) {
            System.out.println(entry.getKey() + " - " + entry.getValue().getNome() + " - " + entry.getValue().getNumero());
        }

        /*Classe anonima
        System.out.println("--- Ordem nome contato ---");
        Set<Map.Entry<Integer, Contato>> agenda5 = new TreeSet<>(new Comparator<Map.Entry<Integer, Contato>>() {

            @Override
            public int compare(Entry<Integer, Contato> c1, Entry<Integer, Contato> c2) {
                return c1.getValue().getNome().compareTo(c2.getValue().getNome());
            }
            
        });*/

        /*Lambda*/
        Set<Map.Entry<Integer, Contato>> agenda5 = new TreeSet<>(Comparator.comparing(
            c -> c.getValue().getNumero()
        ));

        agenda5.addAll(agenda.entrySet());
        for (Map.Entry<Integer, Contato> entry: agenda5) {
            System.out.println(entry.getKey() + " - " + entry.getValue().getNome() + " - " +  entry.getValue().getNumero());
        }

    }
}

class Contato {
    private String nome;
    private Integer numero;
    
    public Contato(String nome, Integer numero) {
        this.nome = nome;
        this.numero = numero;
    }

    public String getNome() {
        return nome;
    }

    public Integer getNumero() {
        return numero;
    }

    @Override
    public String toString() {
        return "Contato [nome=" + nome + ", numero=" + numero + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        result = prime * result + ((numero == null) ? 0 : numero.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Contato other = (Contato) obj;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        if (numero == null) {
            if (other.numero != null)
                return false;
        } else if (!numero.equals(other.numero))
            return false;
        return true;
    }
    
}

/*class ComparatorNumeroTelefone implements Comparator<Map.Entry<Integer, Contato>> {

    @Override
    public int compare(Entry<Integer, Contato> c1, Entry<Integer, Contato> c2) {
        return c1.getValue().getNumero().compareTo(c2.getValue().getNumero());
    }
    
}*/

/*class ComparatorNome implements Comparator<Map.Entry<Integer, Contato>> {

    @Override
    public int compare(Entry<Integer, Contato> c1, Entry<Integer, Contato> c2) {
        return c1.getValue().getNome().compareToIgnoreCase(c2.getValue().getNome());
    }
    
}*/

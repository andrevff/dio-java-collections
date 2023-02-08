package dio.collection.map;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class ExemploOrdenacaoMap {
    public static void main(String[] args) {
        System.out.println("---Ordem aleatoria---");
        Map<String, Livro> meusLivros = new HashMap<>(){{
            put("Stephen Hawking", new Livro("Uma Breve Historia do Tempo", 256));
            put("Charles Duhigg", new Livro("O Poder do Habito", 408));
            put("JK Rowling", new Livro("Harry Potter e a Pedra Filosofal", 368));
        }};
        for(Map.Entry<String, Livro> livro : meusLivros.entrySet()){
            System.out.println(livro.getKey() + " - " + livro.getValue().getNome());
        }

        System.out.println("---Ordem de insercao---");
        Map<String, Livro> meusLivros2 = new LinkedHashMap<>(){{
            put("Stephen Hawking", new Livro("Uma Breve Historia do Tempo", 256));
            put("Charles Duhigg", new Livro("O Poder do Habtio", 408));
            put("JK Rowling", new Livro("Harry Potter e a Pedra Filosofal", 368));
        }};
        for(Map.Entry<String, Livro> livro : meusLivros2.entrySet()){
            System.out.println(livro.getKey() + " - " + livro.getValue().getNome());
        }

        System.out.println("---Ordem alfabetica autores---");
        Map<String, Livro> meuslivros3 = new TreeMap<>(meusLivros);
        for(Map.Entry<String, Livro> livros : meuslivros3.entrySet()){
            System.out.println(livros.getKey() + " - " + livros.getValue().getNome());
        }

        System.out.println("---Ordem alfabetica dos nomes dos livros---");
        Set<Map.Entry<String, Livro>> meusLivros4 = new TreeSet<>(new ComparatorNome());
        meusLivros4.addAll(meusLivros.entrySet());
        for(Map.Entry<String, Livro> livros : meusLivros4){
            System.out.println(livros.getKey() + " - " + livros.getValue().getNome());
        }

        System.out.println("---Ordem numero de paginas---");
        Set<Map.Entry<String, Livro>> meusLivros5 = new TreeSet<>(new ComparatorPaginas());
        meusLivros5.addAll(meusLivros.entrySet());
        for(Map.Entry<String, Livro> livros : meusLivros5){
            System.out.println(livros.getValue().getPaginas() + " - " + livros.getKey() + " - " + livros.getValue().getNome());
        }

    }
}

class Livro {
    private String nome;
    private Integer paginas;
    
    public Livro(String nome, Integer paginas) {
        this.nome = nome;
        this.paginas = paginas;
    }

    public String getNome() {
        return nome;
    }

    public Integer getPaginas() {
        return paginas;
    }

    @Override
    public String toString() {
        return "Livro [nome=" + nome + ", paginas=" + paginas + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        result = prime * result + ((paginas == null) ? 0 : paginas.hashCode());
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
        Livro other = (Livro) obj;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        if (paginas == null) {
            if (other.paginas != null)
                return false;
        } else if (!paginas.equals(other.paginas))
            return false;
        return true;
    }
    
}

class ComparatorNome implements Comparator<Map.Entry<String, Livro>> {

    @Override
    public int compare(Entry<String, Livro> l1, Entry<String, Livro> l2) {
        return l1.getValue().getNome().compareToIgnoreCase(l2.getValue().getNome());
    }

}

class ComparatorPaginas implements Comparator<Map.Entry<String, Livro>> {

    @Override
    public int compare(Entry<String, Livro> l1, Entry<String, Livro> l2) {
        return l1.getValue().getPaginas().compareTo(l2.getValue().getPaginas());
    }
    
}
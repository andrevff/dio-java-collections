package dio.collection.set;

import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class ExemploOrdenacaoSet {
    public static void main(String[] args) {

        System.out.println("---Ordem Ateatoria---");
        Set<Serie> minhasSeries = new HashSet<>(){{
            add(new Serie("Stranger Things", "Fantasia", 50));
            add(new Serie("Sandman", "Drama", 60));
            add(new Serie("Supernatural", "Misterio", 40));
        }};
        for (Serie serie : minhasSeries) {
            System.out.println(serie.getNome() + " - " + serie.getGenero() + " - " + serie.getDuracaoEpisodio());
        }

        System.out.println("---Ordem de Insercao---");
        Set<Serie> minhasSeries2 = new LinkedHashSet<>(){{
            add(new Serie("Stranger Things", "Fantasia", 50));
            add(new Serie("Sandman", "Drama", 60));
            add(new Serie("Supernatural", "Misterio", 40));
        }};
        for (Serie serie : minhasSeries2) {
            System.out.println(serie.getNome() + " - " + serie.getGenero() + " - " + serie.getDuracaoEpisodio());
        }

        System.out.println("---Ordem Natural (Duracao Episodio)---");
        Set<Serie> minhasSeries3 = new TreeSet<>(minhasSeries);
        for (Serie serie : minhasSeries3) {
            System.out.println(serie.getNome() + " - " + serie.getGenero() + " - " + serie.getDuracaoEpisodio());
        }

        System.out.println("---Ordem Nome/Genero/Duracao---");
        Set<Serie> minhasSeries4 = new TreeSet<>(new ComparatorNomeGeneroEpsodio());
        minhasSeries4.addAll(minhasSeries);
        for (Serie serie : minhasSeries4) {
            System.out.println(serie.getNome() + " - " + serie.getGenero() + " - " + serie.getDuracaoEpisodio());
        }

    }
}

class Serie implements Comparable<Serie> {
    private String nome;
    private String genero;
    private Integer duracaoEpisodio;
    
    public Serie(String nome, String genero, Integer duracaoEpisodio) {
        this.nome = nome;
        this.genero = genero;
        this.duracaoEpisodio = duracaoEpisodio;
    }

    public String getNome() {
        return nome;
    }

    public String getGenero() {
        return genero;
    }

    public Integer getDuracaoEpisodio() {
        return duracaoEpisodio;
    }

    @Override
    public String toString() {
        return "Serie [nome=" + nome + ", genero=" + genero + ", duracao do episodio=" + duracaoEpisodio + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        result = prime * result + ((genero == null) ? 0 : genero.hashCode());
        result = prime * result + ((duracaoEpisodio == null) ? 0 : duracaoEpisodio.hashCode());
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
        Serie other = (Serie) obj;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        if (genero == null) {
            if (other.genero != null)
                return false;
        } else if (!genero.equals(other.genero))
            return false;
        if (duracaoEpisodio == null) {
            if (other.duracaoEpisodio != null)
                return false;
        } else if (!duracaoEpisodio.equals(other.duracaoEpisodio))
            return false;
        return true;
    }

    @Override
    public int compareTo(Serie serie) {
        int duracaoEpisodio = Integer.compare(this.getDuracaoEpisodio(), serie.getDuracaoEpisodio());
        if(duracaoEpisodio != 0) return duracaoEpisodio;

        return this.getGenero().compareTo(serie.getGenero());
    }
    
}

class ComparatorNomeGeneroEpsodio implements Comparator<Serie> {

    @Override
    public int compare(Serie s1, Serie s2) {
        int nome = s1.getNome().compareTo(s2.getNome());
        if(nome != 0) return nome;

        int genero = s1.getGenero().compareTo(s2.getGenero());
        if(genero != 0) return genero;

        return Integer.compare(s1.getDuracaoEpisodio(), s2.getDuracaoEpisodio());
    }

}

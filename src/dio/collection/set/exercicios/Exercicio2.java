package dio.collection.set.exercicios;

import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class Exercicio2 {
    public static void main(String[] args) {
        Set<LinguagemFavorita> linguagem = new LinkedHashSet<>(){{
            add(new LinguagemFavorita("javascript", 1995, "vscode"));
            add(new LinguagemFavorita("java", 1991, "eclipse"));
            add(new LinguagemFavorita("python", 1991, "pycharm"));
        }};

        System.out.println("---Ordem de insercao: ");
        for (LinguagemFavorita linguagens : linguagem) {
            System.out.println(linguagens.getNome() + " - " + linguagens.getAnoCriacao() + " - " + linguagens.getIde());
        }

        System.out.println("---Ordem natural (nome): ");
        Set<LinguagemFavorita> linguagem2 = new TreeSet<>(linguagem);
        for (LinguagemFavorita linguagens : linguagem2) {
            System.out.println(linguagens.getNome() + " - " + linguagens.getAnoCriacao() + " - " + linguagens.getIde());
        }

        System.out.println("---Ordem (ide): ");
        Set<LinguagemFavorita> linguagem3 = new TreeSet<>(new ComparatorIde());
        linguagem3.addAll(linguagem);
        for (LinguagemFavorita linguagens : linguagem3) {
            System.out.println(linguagens.getNome() + " - " + linguagens.getAnoCriacao() + " - " + linguagens.getIde());
        }

        System.out.println("---Ordem (ano de criacao e nome)");
        Set<LinguagemFavorita> linguagem4 = new TreeSet<>(new ComparatorAnoCriacaoNome());
        linguagem4.addAll(linguagem);
        for (LinguagemFavorita linguagens : linguagem4) {
            System.out.println(linguagens.getNome() + " - " + linguagens.getAnoCriacao() + " - " + linguagens.getIde());
        }

        System.out.println("---Ordem (nome, ano e ide): ");
        Set<LinguagemFavorita> linguagem5 = new TreeSet<>(new ComparatorNomeAnoIde());
        linguagem5.addAll(linguagem);
        for (LinguagemFavorita linguagens : linguagem5) {
            System.out.println(linguagens.getNome() + " - " + linguagens.getAnoCriacao() + " - " + linguagens.getIde());
        }
    }
}

class LinguagemFavorita implements Comparable<LinguagemFavorita> {
    private String nome;
    private Integer anoCriacao;
    private String ide;
    
    public LinguagemFavorita(String nome, Integer anoCriacao, String ide) {
        this.nome = nome;
        this.anoCriacao = anoCriacao;
        this.ide = ide;
    }

    public String getNome() {
        return nome;
    }

    public Integer getAnoCriacao() {
        return anoCriacao;
    }

    public String getIde() {
        return ide;
    }

    @Override
    public String toString() {
        return "LinguagemFavorita [nome=" + nome + ", anoCriacao=" + anoCriacao + ", ide=" + ide + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        result = prime * result + ((anoCriacao == null) ? 0 : anoCriacao.hashCode());
        result = prime * result + ((ide == null) ? 0 : ide.hashCode());
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
        LinguagemFavorita other = (LinguagemFavorita) obj;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        if (anoCriacao == null) {
            if (other.anoCriacao != null)
                return false;
        } else if (!anoCriacao.equals(other.anoCriacao))
            return false;
        if (ide == null) {
            if (other.ide != null)
                return false;
        } else if (!ide.equals(other.ide))
            return false;
        return true;
    }

    @Override
    public int compareTo(LinguagemFavorita linguagem) {
        return this.getNome().compareTo(linguagem.getNome());
    }
    
}

class ComparatorIde implements Comparator<LinguagemFavorita> {

    @Override
    public int compare(LinguagemFavorita l1, LinguagemFavorita l2) {
        int ide = l1.getIde().compareTo(l2.getIde());
        return ide;
    }
    
}

class ComparatorAnoCriacaoNome implements Comparator<LinguagemFavorita> {

    @Override
    public int compare(LinguagemFavorita l1, LinguagemFavorita l2) {
        int anoCriacao = l1.getAnoCriacao().compareTo(l2.getAnoCriacao());
        if(anoCriacao != 0) return anoCriacao;
        
        int nome = l1.getNome().compareTo(l2.getNome());
        return nome;
    }
    
}

class ComparatorNomeAnoIde implements Comparator<LinguagemFavorita> {

    @Override
    public int compare(LinguagemFavorita l1, LinguagemFavorita l2) {
        int nome = l1.getNome().compareTo(l2.getNome());
        if(nome != 0) return nome;

        int anoCriacao = l1.getAnoCriacao().compareTo(l2.getAnoCriacao());
        if(anoCriacao != 0) return anoCriacao;

        int ide = l1.getIde().compareTo(l2.getIde());
        return ide;
    }
    
}

package Model;
import java.util.ArrayList;
import java.util.List;

public class Biblioteca 
{
    private List<Livro> livros;

    
    public Biblioteca() 
    {
        this.livros = new ArrayList<>();
    }

    
    public void adicionarLivro(Livro livro) 
    {
        livros.add(livro);
    }

    
    public List<Livro> pesquisarPorTitulo(String titulo) 
    {
        List<Livro> resultado = new ArrayList<>();
        for (Livro livro : livros) 
        {
            if (livro.getTitulo().toLowerCase().contains(titulo.toLowerCase())) 
            {
                resultado.add(livro);
            }
        }
        return resultado;
    }

    
    public List<Livro> pesquisarPorAutor(String autor) 
    {
        List<Livro> resultado = new ArrayList<>();
        for (Livro livro : livros) 
        {
            if (livro.getAutor().toLowerCase().contains(autor.toLowerCase())) 
            {
                resultado.add(livro);
            }
        }
        return resultado;
    }

    
    public boolean livroDisponivel(int idLivro) 
    {
        for (Livro livro : livros) 
        {
            if (livro.getIdLivro() == idLivro && livro.isDisponivel()) 
            {
                return true;
            }
        }
        return false;
    }

    
    public boolean emprestarLivro(int idLivro) 
    {
        for (Livro livro : livros) 
        {
            if (livro.getIdLivro() == idLivro && livro.isDisponivel()) 
            {
                livro.setDisponivel(false);
                return true;
            }
        }
        return false;
    }

    
    public boolean devolverLivro(int idLivro) 
    {
        for (Livro livro : livros) {
            if (livro.getIdLivro() == idLivro) 
            {
                livro.setDisponivel(true);
                return true;
            }
        }
        return false;
    }
}
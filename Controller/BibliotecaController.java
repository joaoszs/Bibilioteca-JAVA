package Controller;
import java.util.List;
import Model.Biblioteca;
import Model.Livro;

public class BibliotecaController 
{
    private Biblioteca biblioteca;

    public BibliotecaController() 
    {
        this.biblioteca = new Biblioteca();
    }

    
    public void adicionarLivro(String titulo, String autor, int idLivro) 
    {
        Livro livro = new Livro(titulo, autor, idLivro);
        biblioteca.adicionarLivro(livro);
    }

   
    public List<Livro> pesquisarPorTitulo(String titulo) 
    {
        return biblioteca.pesquisarPorTitulo(titulo);
    }

    
    public List<Livro> pesquisarPorAutor(String autor) 
    {
        return biblioteca.pesquisarPorAutor(autor);
    }

    
    public boolean livroDisponivel(int idLivro) 
    {
        return biblioteca.livroDisponivel(idLivro);
    }

    
    public boolean emprestarLivro(int idLivro) 
    {
        return biblioteca.emprestarLivro(idLivro);
    }


    public boolean devolverLivro(int idLivro) 
    {
        return biblioteca.devolverLivro(idLivro);
    }
}
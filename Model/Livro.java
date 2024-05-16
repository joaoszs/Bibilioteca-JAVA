package Model;

public class Livro 
{
    private String titulo;
    private String autor;
    private int idLivro;
    private boolean disponivel;

    public Livro(String titulo, String autor, int idLivro)
     {
        this.titulo = titulo;
        this.autor = autor;
        this.idLivro = idLivro;
        this.disponivel = true; 
    }

    
    public String getTitulo() 
    {
        return titulo;
    }

    public String getAutor() 
    {
        return autor;
    }

    public int getIdLivro() 
    {
        return idLivro;
    }

    public boolean isDisponivel() 
    {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) 
    {
        this.disponivel = disponivel;
    }
}

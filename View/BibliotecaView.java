package View;

import java.util.List;
import java.util.Scanner;
import Controller.BibliotecaController;
import Model.Livro;
public class BibliotecaView {
    private BibliotecaController controller;
    private Scanner scanner;

    // Construtor
    public BibliotecaView() {
        this.controller = new BibliotecaController();
        this.scanner = new Scanner(System.in);
    }

    // Método para exibir o menu principal
    public void exibirMenu() {
        System.out.println("Bem-vindo à Biblioteca!");
        System.out.println("1. Pesquisar livros pelo título");
        System.out.println("2. Pesquisar livros pelo autor");
        System.out.println("3. Solicitar empréstimo de livro");
        System.out.println("4. Devolver livro");
        System.out.println("5. Adicionar novo livro");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
    }

    // Método para iniciar a aplicação
    public void iniciar() {
        int escolha;
        do {
            exibirMenu();
            escolha = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            switch (escolha) {
                case 1:
                    pesquisarPorTitulo();
                    break;
                case 2:
                    pesquisarPorAutor();
                    break;
                case 3:
                    emprestarLivro();
                    break;
                case 4:
                    devolverLivro();
                    break;
                case 5:
                    adicionarLivro();
                    break;
                case 0:
                    System.out.println("Obrigado por utilizar a Biblioteca!");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (escolha != 0);
    }

    // Método para pesquisar livros pelo título
    private void pesquisarPorTitulo() {
        System.out.print("Digite o título do livro: ");
        String titulo = scanner.nextLine();
        List<Livro> resultado = controller.pesquisarPorTitulo(titulo);
        if (resultado.isEmpty()) {
            System.out.println("Nenhum livro encontrado com o título '" + titulo + "'.");
        } else {
            System.out.println("Livros encontrados com o título '" + titulo + "':");
            for (Livro livro : resultado) {
                System.out.println(livro.getTitulo() + " - " + livro.getAutor());
            }
        }
    }

    // Método para pesquisar livros pelo autor
    private void pesquisarPorAutor() {
        System.out.print("Digite o nome do autor: ");
        String autor = scanner.nextLine();
        List<Livro> resultado = controller.pesquisarPorAutor(autor);
        if (resultado.isEmpty()) {
            System.out.println("Nenhum livro encontrado do autor '" + autor + "'.");
        } else {
            System.out.println("Livros encontrados do autor '" + autor + "':");
            for (Livro livro : resultado) {
                System.out.println(livro.getTitulo() + " - " + livro.getAutor());
            }
        }
    }

    // Método para solicitar empréstimo de livro
    private void emprestarLivro() {
        System.out.print("Digite o número de registro do livro que deseja emprestar: ");
        int idLivro = scanner.nextInt();
        if (controller.livroDisponivel(idLivro)) {
            controller.emprestarLivro(idLivro);
            System.out.println("Livro emprestado com sucesso!");
        } else {
            System.out.println("Livro não disponível para empréstimo ou não encontrado.");
        }
    }

    // Método para devolver livro
    private void devolverLivro() {
        System.out.print("Digite o número de registro do livro que deseja devolver: ");
        int idLivro = scanner.nextInt();
        if (controller.devolverLivro(idLivro)) {
            System.out.println("Livro devolvido com sucesso!");
        } else {
            System.out.println("Livro não encontrado.");
        }
    }

    // Método para adicionar um novo livro à biblioteca
    private void adicionarLivro() {
        System.out.print("Digite o título do novo livro: ");
        String titulo = scanner.nextLine();
        System.out.print("Digite o autor do novo livro: ");
        String autor = scanner.nextLine();
        System.out.print("Digite o número de registro do novo livro: ");
        int idLivro = scanner.nextInt();
        controller.adicionarLivro(titulo, autor, idLivro);
        System.out.println("Novo livro adicionado com sucesso!");
    }
}
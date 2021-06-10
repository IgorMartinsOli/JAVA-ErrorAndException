/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programa;

import java.util.Scanner;

/**
 *
 * @author igor_
 */
public class Programa {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
Scanner scan = new Scanner(System.in);
        Biblioteca biblioteca = new Biblioteca("Teste", "Rua X"); //Cria o objeto Biblioteca, neste caso só terá uma
        while(true){
            System.out.println("Selecione uma das opções a seguir: ");
            System.out.println("1 - Cadastrar Usuário");
            System.out.println("2 - Cadastrar Publicação");
            System.out.println("3 - Realizar Empréstimo");
            System.out.println("4 - Renovar Empréstimo");
            System.out.println("5 - Devolver Empréstimo");
            System.out.println("0 - Sair");
            int opcao = scan.nextInt();
            scan.nextLine();
    
            switch(opcao){
                case 1:
                   Usuario user = cadastrarUsuario();
                   if(user != null){
                       biblioteca.addUsuario(user);
                       System.out.println("Usuário cadastrado com sucesso!");
                   }else{
                       System.out.println("Erro ao cadastrar usuário!");
                   }
                   break;
                case 2:
                   Publicacao publicacao = cadastrarPublicacao();
                   if(publicacao != null){
                       biblioteca.addPublicacao(publicacao);
                       System.out.println("Publicação cadastrada com sucesso!");
                   }else{
                       System.out.println("Erro ao cadastrar publicação!");
                   }
                   break;
                case 3:
                    System.out.println("Digite o nome do usuário: ");
                    String nomeUsuario = scan.nextLine();
                    Usuario usuarioEmprestimo = biblioteca.buscarUsuario(nomeUsuario);
                    if(usuarioEmprestimo == null){
                        System.out.println("Usuário não encontrado! Realize a operação.");
                        break;
                    }
                    
                    System.out.println("Digite o título da publicação: ");
                    String tituloPublicacao = scan.nextLine();
                    Publicacao publicacaoEmprestimo = biblioteca.buscarPublicacao(tituloPublicacao);
                    if(publicacaoEmprestimo == null){
                        System.out.println("Publicacao não encontrada! Realize a operação.");
                        break;
                    }

                    try{
                    Emprestimo emprestimo = new Emprestimo(usuarioEmprestimo, publicacaoEmprestimo);
                    if(emprestimo.getPublicacao() == null){
                        System.out.println("Erro ao realizar empréstimo. Tente novamente.");
                    }else{
                        System.out.println("Emprestimo realizado com sucesso! Emprestimo ID: "+emprestimo.getId());
                        biblioteca.addEmprestimo(emprestimo);
                    }
                    }catch(EmprestimoUsuarioException | PublicacaoDisponivelException ex){
                        System.out.println(ex.getMessage());
                    }
                    break;
                case 4:
                     System.out.print("ID do empréstimo: ");
                    int emprestimoId = scan.nextInt();
                    scan.nextLine();
                    
                    Emprestimo emprestimoRenovacao = biblioteca.buscarEmprestimo(emprestimoId);
                    if(emprestimoRenovacao == null){
                        System.out.println("Erro ao buscar Emprestimo. Tente novamente!");
                        break;
                    }else{
                    try{
                        emprestimoRenovacao.renovarEmprestimo();
                            System.out.println("Emprestimo renovado com sucesso!");
                            break;
                    } catch(RenovarEmprestimoException ex){
                        System.out.println(ex.getMessage());
                        break;
                    }
                    }
                    
                case 5:
                    System.out.print("ID do empréstimo: ");
                    int idEmprestimo = scan.nextInt();
                    scan.nextLine();

                    Emprestimo emprestimoDevolucao = biblioteca.buscarEmprestimo(idEmprestimo);
                    if(emprestimoDevolucao == null){
                        System.out.println("Erro ao buscar Emprestimo. Tente novamente!");
                        break;
                    }else{
                        if(emprestimoDevolucao.finalizarEmprestimo()){
                            biblioteca.removeEmprestimo(emprestimoDevolucao);
                            System.out.println("Emprestimo finalizado com sucesso!");
                            break;
                        }else{
                            System.out.println("Erro ao finalizar emprestimo...");
                            break;
                        }
                    }
                default:
                    System.out.println("Sistema finalizando...");
                    return;
            }
        }
       
    }

    public static Usuario cadastrarUsuario(){
        Scanner scan = new Scanner(System.in);

        System.out.println("Selecione o tipo de usuário:");
        System.out.println("1 - Usuário Comum");
        System.out.println("2 - Usuário Especial");
        int opcao = scan.nextInt();

        if(!(opcao == 1 || opcao == 2)){ //Se a opção seleciona não for 1 ou 2
            System.out.println("Opção inválida!");
            return null;
        }

        scan.nextLine(); //Adicionado para consumir o enter após o valor da opção

        //Solicita as informações do usuário
        System.out.println("Digite o nome do Usuário:");
        String nome = scan.nextLine();

        System.out.println("Digite o telefone do Usuário:");
        String telefone = scan.nextLine();

        System.out.println("Digite o e-mail do Usuário: ");
        String email = scan.nextLine();

        //Cria-se o objeto usuário de acordo com a opção selecionada
        //Utiliza-se o Polimorfismo no tipo de retorno
        if(opcao == 1){
            return new Comum(nome, telefone, email);
        }else{
            return new Especial(nome, telefone, email);
        }
    }

    public static Publicacao cadastrarPublicacao(){
        Scanner scan = new Scanner(System.in);

        System.out.println("Selecione o tipo da Publicação:");
        System.out.println("1 - Livro");
        System.out.println("2 - Artigo");
        System.out.println("3 - Tese");
        int opcao = scan.nextInt();
        scan.nextLine(); //Adicionado para consumir o enter após o valor da opção

        if(!(opcao == 1 || opcao == 2 || opcao == 3)){//Se a opção seleciona não for 1 ou 2 ou 3
            System.out.println("Opção inválida!");
            return null;
        }

         //Solicita as informações comuns para qualquer publicação (presentes na classe Publicação)
         System.out.println("Digite o título da publicação: ");
         String titulo = scan.nextLine();
 
         System.out.println("Digite a data de publicação: ");
         String dataPublicacao = scan.nextLine();
 
         System.out.println("Digite o valor da multa: ");
         Double multa = scan.nextDouble();
         scan.nextLine(); //Adicionado para consumir o enter após o valor da opção
        switch (opcao) {
            case 1:
                //Se for adicionar um Livro
                System.out.println("Digite a edição do livro: ");
                int edicao = scan.nextInt();
                scan.nextLine(); //Adicionado para consumir o enter após o valor da opção
                
                System.out.println("Digite a editora do livro: ");
                String editora = scan.nextLine();
                
                System.out.println("Digite o ISBN do livro: ");
                String isbn = scan.nextLine();
                
                return new Livro(titulo, dataPublicacao, edicao, editora, isbn, multa);
            case 2:
            {//Se for adicionar um artigo
                System.out.println("Digite o resumo do Artigo: ");
                String resumo = scan.nextLine();
                
                return new Artigo(titulo, dataPublicacao, resumo, multa);
            }
            default:
            {
                System.out.println("Digite o número de páginas da Tese: ");
                int nroPaginas = scan.nextInt();
                scan.nextLine(); //Adicionado para consumir o enter após o valor da opção
                
                System.out.println("Digite a resumo da Tese: ");
                String resumo = scan.nextLine();
                
                System.out.println("Digite a data da defesa da Tese: ");
                String dataDefesa = scan.nextLine();
                
                System.out.println("Digite a instituicao da Tese: ");
                String instituicao = scan.nextLine();
                
                Autor autor = cadastrarAutor();
                
                return new Tese(titulo, dataPublicacao, autor, nroPaginas, resumo, dataDefesa, instituicao, multa);
            }
        }
    }

    public static Autor cadastrarAutor(){
        Scanner scan = new Scanner(System.in);

        System.out.println("Digite o nome do Autor da Tese: ");
        String nome = scan.nextLine();

        System.out.println("Digite a titulaçao do Autor da Tese: ");
        String titulacao = scan.nextLine();

        return new Autor(nome, titulacao);
     }
}

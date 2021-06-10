package programa;

import java.util.ArrayList;

public class Biblioteca {
   private String nome;
   private String endereco;
   private ArrayList<Publicacao> publicacoes;
   private ArrayList<Usuario> usuarios;
   private ArrayList<Emprestimo> emprestimos;

   public Biblioteca(String nome, String endereco) {
      this.nome = nome;
      this.endereco = endereco;
      this.publicacoes = new ArrayList<Publicacao>();
      this.usuarios = new ArrayList<Usuario>();
      this.emprestimos = new ArrayList<Emprestimo>();
   }

   public String getNome() {
      return this.nome;
   }

   public void setNome(String nome) {
      this.nome = nome;
   }

   public String getEndereco() {
      return this.endereco;
   }

   public void setEndereco(String endereco) {
      this.endereco = endereco;
   }

   public boolean addPublicacao(Publicacao publicacao){
      this.publicacoes.add(publicacao);
      return true;
   }
   
   public boolean removePublicacao(Publicacao publicacao){
      this.publicacoes.remove(publicacao);
      return true;
   } 

   public Publicacao buscarPublicacao(String titulo){
      for(Publicacao publicacao: this.publicacoes){
         if(publicacao.getTitulo().equals(titulo)){
            return publicacao;
         }
      }
      return null;
   }

   public boolean addUsuario(Usuario usuario){
      this.usuarios.add(usuario);
      return true;
   }
   
   public boolean removeUsuario(Usuario usuario){
      this.usuarios.remove(usuario);
      return true;
   } 

   public Usuario buscarUsuario(String nome){
      for(Usuario usuario: this.usuarios){
         if(usuario.getNome().equals(nome)){
            return usuario;
         }
      }
      return null;
   }

   public boolean addEmprestimo(Emprestimo emprestimo){
      this.emprestimos.add(emprestimo);
      return true;
   }
   
   public boolean removeEmprestimo(Emprestimo emprestimo){
      this.emprestimos.remove(emprestimo);
      return true;
   }

   public Emprestimo buscarEmprestimo(int id){
      for(Emprestimo emprestimo: this.emprestimos){
         if(emprestimo.getId() == id){
            return emprestimo;
         }
      }
      return null;
   }

   
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programa;

public abstract class Usuario {
   private String nome;
   private String telefone;
   private String email;
   private int maxEmprestimos;
   private int maxRenovacao;
   private int qtdEmprestimos;

   public Usuario(String nome, String telefone, String email, int maxEmprestimos, int maxRenovacao) {
      this.nome = nome;
      this.telefone = telefone;
      this.email = email;
      this.maxEmprestimos = maxEmprestimos;
      this.maxRenovacao = maxRenovacao;
      this.qtdEmprestimos = 0;
   }

   public String getNome() {
      return this.nome;
   }

   public void setNome(String nome) {
      this.nome = nome;
   }

   public String getTelefone() {
      return this.telefone;
   }

   public void setTelefone(String telefone) {
      this.telefone = telefone;
   }

   public String getEmail() {
      return this.email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public boolean realizarEmprestimo(){
      if(this.qtdEmprestimos < this.maxEmprestimos || this.maxEmprestimos == -1){
         this.qtdEmprestimos++;
         return true;
      }else{
         return false;
      }
   }

   public boolean devolverEmprestimo(){
      this.qtdEmprestimos--;
      return true;
   }

   public int getMaxEmprestimos() {
      return this.maxEmprestimos;
   }

   public int getMaxRenovacao() {
      return this.maxRenovacao;
   }

}
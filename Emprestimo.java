/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programa;

public class Emprestimo {
   private static int contador = 0;
   private int id;
   private Usuario usuario;
   private Publicacao publicacao;
   private String dataEmprestimo;
   private String dataDevolucao;
   private double valorMulta;
   private int qtdRenovacoes;

   public Emprestimo(Usuario usuario, Publicacao publicacao) throws EmprestimoUsuarioException, PublicacaoDisponivelException {
      if (publicacao.isDisponivel()) {
         if (usuario.realizarEmprestimo()) {
            this.id = ++this.contador;//Criar um contador para gerar um número incrementado automaticamente
            this.usuario = usuario;
            this.publicacao = publicacao;
            this.publicacao.emprestar();
            this.dataEmprestimo = "29/06/2020"; // Data de Hoje
            this.dataDevolucao = "05/07/2020"; // Estimativa
            this.qtdRenovacoes = 0;
            this.valorMulta = 0;
         } else {
            throw new EmprestimoUsuarioException("Usuário não pode realizar novos emprestimos!");
         }
      } else {
         throw new PublicacaoDisponivelException("Publicação não disponível");
      }
   }
   

   public boolean finalizarEmprestimo() {
      this.dataDevolucao = "20/07/2020";
      this.publicacao.devolver();
      this.usuario.devolverEmprestimo();
      System.out.println("Emprestimo finalizado com sucesso!");
      this.calcularMulta();
      System.out.println("O valor da multa é R$" + this.valorMulta);
      return true;
   }

   //NO CASO TERIA QUE VERIFICAR SE É USUARIO ESPECIAL OU COMUM, NAO CONSEGUI FAZER ISSO POR ISSO COLOQUEI QUANTIDADE DE RENOVAÇÕES 5 PARA TODOS
   public void renovarEmprestimo() throws RenovarEmprestimoException {
      if(this.qtdRenovacoes <5){
            this.qtdRenovacoes++;
            this.dataDevolucao = "10/07/2020";
      } else {
          throw new RenovarEmprestimoException("Emprestimo ja foi renovado pela quantidade de vezes permitidas!");
      }
   }

   //Neste caso a multa será calculada apenas pela quantidade de renovação
   //Poderá ser realizado levando em consideração as datas. 
   public void calcularMulta() {
      this.valorMulta = (this.qtdRenovacoes - this.usuario.getMaxRenovacao()) * this.publicacao.getValorMulta();
   }


   public int getId(){
      return this.id;
   }

   public Usuario getUsuario() {
      return this.usuario;
   }

   public Publicacao getPublicacao() {
      return this.publicacao;
   }

   public String getDataEmprestimo() {
      return this.dataEmprestimo;
   }

   public String getDataDevolucao() {
      return this.dataDevolucao;
   }

   public void setDataDevolucao(String dataDevolucao) {
      this.dataDevolucao = dataDevolucao;
   }

   public double getValorMulta() {
      return this.valorMulta;
   }

   public int getQtdRenovacoes() {
      return this.qtdRenovacoes;
   }
}

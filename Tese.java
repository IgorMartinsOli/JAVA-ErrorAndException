/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programa;

public class Tese extends Publicacao {
   private int nroPaginas;
   private String resumo;
   private String dataDefesa;
   private String instituicao;

   public Tese(String titulo, String dataPublicacao, Autor autor, int nroPaginas, String resumo, String dataDefesa, String instituicao, double valorMulta) {
      super(titulo, dataPublicacao, valorMulta);
      this.nroPaginas = nroPaginas;
      this.resumo = resumo;
      this.dataDefesa = dataDefesa;
      this.instituicao = instituicao;
      super.addAutor(autor);
   }

   public int getNroPaginas() {
      return this.nroPaginas;
   }

   public void setNroPaginas(int nroPaginas) {
      this.nroPaginas = nroPaginas;
   }

   public String getResumo() {
      return this.resumo;
   }

   public void setResumo(String resumo) {
      this.resumo = resumo;
   }

   public String getDataDefesa() {
      return this.dataDefesa;
   }

   public void setDataDefesa(String dataDefesa) {
      this.dataDefesa = dataDefesa;
   }

   public String getInstituicao() {
      return this.instituicao;
   }

   public void setInstituicao(String instituicao) {
      this.instituicao = instituicao;
   }

   @Override
   public boolean addAutor(Autor autor){
      if(super.getAutores().size() == 1){
         return false;
      }
      else{
         super.addAutor(autor);
         return true;
      }  
   }


}

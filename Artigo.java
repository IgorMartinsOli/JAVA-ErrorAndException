package programa;

public class Artigo extends Publicacao {
   private String resumo;

   public Artigo(String titulo, String dataPublicacao, String resumo, double valorMulta) {
      super(titulo, dataPublicacao, valorMulta);
      this.resumo = resumo;
   }

   public String getResumo() {
      return this.resumo;
   }

   public void setResumo(String resumo) {
      this.resumo = resumo;
   }

   
}
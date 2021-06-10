/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programa;
import java.util.ArrayList;


public abstract class Publicacao {
   private String titulo;
   private String dataPublicacao;
   private ArrayList<Autor> autores;
   private ArrayList<Publicacao> referencias;
   private boolean disponivel;
   private double valorMulta;

   public Publicacao(String titulo, String dataPublicacao, double valorMulta) {
      this.titulo = titulo;
      this.dataPublicacao = dataPublicacao;
      this.autores = new ArrayList<Autor>();
      this.referencias = new ArrayList<Publicacao>();
      this.disponivel = true;
      this.valorMulta = valorMulta;
   }

   public String getTitulo() {
      return this.titulo;
   }

   public void setTitulo(String titulo) {
      this.titulo = titulo;
   }

   public String getDataPublicacao() {
      return this.dataPublicacao;
   }

   public void setDataPublicacao(String dataPublicacao) {
      this.dataPublicacao = dataPublicacao;
   }

   public boolean addReferencia(Publicacao publicacao){
      this.referencias.add(publicacao);
      return true;
   }

   public boolean removeReferencia(Publicacao publicacao){
      this.referencias.remove(publicacao);
      return true;
   }

   public ArrayList<Autor> getAutores() {
      return this.autores;
   }

   public void setAutores(ArrayList<Autor> autores) {
      this.autores = autores;
   }

   public boolean addAutor(Autor autor){
      this.autores.add(autor);
      return true;
   }

   public boolean removeAutor(Autor autor){
      this.autores.remove(autor);
      return true;
   }

   public boolean isDisponivel(){
      return this.disponivel;
   }

   public void emprestar(){
      this.disponivel = false;
   }

   public void devolver(){
      this.disponivel = true;
   }

   public double getValorMulta() {
      return this.valorMulta;
   }

   public void setValorMulta(double valorMulta) {
      this.valorMulta = valorMulta;
   }

 }

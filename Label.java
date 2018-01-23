import greenfoot.*;
import java.awt.Color;
import java.lang.String;

/**
 * Write a description of class Label here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Label extends Actor
{
    public String label;
    public int tamanhofonte;
    public Color cortexto;
    public Color corbackground;
    
     /**
     * Construtor do Label.
     * @param palavra String
     * @param tamanho int
     */
    public Label (String palavra, int tamanhof) {
        this.label = palavra;
        this.tamanhofonte = tamanhof;
        this.cortexto = Color.WHITE;
        //this.corbackground = Color.BLACK;
        this.corbackground = new Color (0, 0, 0, 0);
        

        
        AtualizarImagem(palavra, tamanhofonte);
    }
   
    /**
     * Este método atualiza a imagem de um objeto Label.
     */
    public void AtualizarImagem(String label, int tamanhofonte) {
        GreenfootImage img = new GreenfootImage(label, tamanhofonte, this.cortexto, this.corbackground);
        setImage(img);
        
    }
    
      /**
     * Este método atualiza o texto de um objeto Label
     * @param texto String
     * @param tamanhofonte int
     */
    public void setText(String texto, int tamanhofonte){
        AtualizarImagem(texto, tamanhofonte);
    }
    
}
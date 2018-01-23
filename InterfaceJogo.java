
import greenfoot.*;



/**
 * Write a description of class InterfaceJogo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class InterfaceJogo extends Actor
{
     /**
    * Construtor da InterfaceJogo.
    * @param img GreenfootImage.
    */
    public InterfaceJogo(GreenfootImage img)
    {    
      //AtualizarImagem(img);
        
    }
    
      /**
     * Este método atualiza as imagens dos objetos do tipo InterfaceJogo.
     * @param img GreenfootImage.
     */
    public void AtualizarImagem(GreenfootImage img) {
        setImage(img);
    
    }
    
     /**
    * Este método adiciona uma determinada imagem no objeto que representa a botão de letra.
    */
    public void DesenharBotaoLetra() {
        GreenfootImage botaoletra = new GreenfootImage("letras-do-alfabeto-b-e-c_318-43998.jpg");
        AtualizarImagem(botaoletra);
    
    }
    
    /**
     * Este método adiciona uma determinada imagem no objeto que representa a botão de palavra.
     */
    public void DesenharBotaoPalavra() {
        GreenfootImage botaopalavra = new GreenfootImage("ideia-lampada-linha-fina-ios-simbolo-7-de-interface_318-36194.jpg");
        AtualizarImagem(botaopalavra);
    }
    
     /**
     * Este método adiciona uma determinada imagem no objeto que representa a botão de dica.
     */
    public void DesenharBotaoDica() {
        GreenfootImage botaodica = new GreenfootImage("Question-mark-blackandwhite.png");
        AtualizarImagem(botaodica);
    }
    
     /**
     * Este método adiciona uma determinada imagem no objeto que representa a cabeca do boneco.
     */
    public void DesenharCabeca () 
    {
        GreenfootImage cabeca = new GreenfootImage("objetocabecafinal.png");
        
        AtualizarImagem(cabeca);
    }

     /**
     * Este método adiciona uma determinada imagem no objeto que representa o corpo do boneco.
     */
    public void DesenharCorpo() 
    {
        GreenfootImage corpo = new GreenfootImage("objetocorpofinal.png");
        
       AtualizarImagem(corpo);
    }

   /**
     * Este método adiciona uma determinada imagem no objeto que representa o braço direito do boneco.
     */
    public void DesenharBracoDireito()
    {
         GreenfootImage bracodireito = new GreenfootImage("objetobracodireitofinal.png");
       
        AtualizarImagem(bracodireito);
    }
    
     /**
     * Este método adiciona uma determinada imagem no objeto que representa o braço esquerdo do boneco.
     */
    public void DesenharBracoEsquerdo()
    {
      GreenfootImage bracoesquerdo = new GreenfootImage("objetobracoesquerdofinal.png");
       
        AtualizarImagem(bracoesquerdo);
    }

    /**
     * Este método adiciona uma determinada imagem no objeto que representa a perna direita do boneco.
     */
   public void DesenharPernaDireita()
    {
        GreenfootImage pernadireita = new GreenfootImage("ObjetoPernaDireitaFinal.png");
        AtualizarImagem(pernadireita);
    }
 
    /**
     * Este método adiciona uma determinada imagem no objeto que representa a pernaesquerda do boneco.
     */
    public void DesenharPernaEsquerda()
    {
        GreenfootImage pernaesquerda = new GreenfootImage("objetopernaesquerdafinal.png");
        AtualizarImagem(pernaesquerda);
    }
}


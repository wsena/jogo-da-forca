import javax.swing.JOptionPane;
import greenfoot.*;

public class JogadorHumano extends Jogador 
{  
   
   public int tentativas_restantes = 6;

   
   public void act() {
      //Greenfoot.setWorld(new Gerenciador());
    }
    /**
     * Implementação do método abstrato jogar(), presente na classe mãe Jogador.
     * 
     */
    @Override
    public void jogar(){
        RecebeNomeJogador();
    }
       
    /**
      * Este método recebe o nome do jogador.
      */
     public void RecebeNomeJogador() {
        this.nome_jogador = JOptionPane.showInputDialog("Insira o nome do Jogador: ");
     } 
        
        /**
         * Este método recebe a palavra que será adivinhada.
         */
     public void RecebePalavra() {
        this.palavra = JOptionPane.showInputDialog(nome_jogador + ", informe a palavra que o outro jogador tentará acertar:");
        }   
         /**
         * Este método recebe a dica da palavra que será adivinhada.
         */
     public void RecebeDica() {
          this.dica_palavra = JOptionPane.showInputDialog("Agora informe a dica: ");     
        }

       /**
       * Atualiza o número de tentativas restantes.
       */
    public void AtualizarTentativasRestantes(){
        this.tentativas_restantes = 6;
    }
    
     /**
     * Este método padroniza a palavra que será adivinhada.
     * @return String palavra - palavra em letras maiúsculas.
     */
     public String PadronizarPalavra(){
        this.palavra = this.palavra.toUpperCase();
        return this.palavra;
    }
  
}

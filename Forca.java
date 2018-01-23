import greenfoot.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Forca extends World{ 
    
    public String palavra_palpite;
    public boolean vitoria = false; 
    public String letra_s;
    public char letra_c;
    ArrayList<Character> ArrayPalavra;
    ArrayList<Character> ArrayLetrasPalpite = new ArrayList<Character>();
    int indiceArrayLetras = 0;
    
    /**
     * Construtor da classe Forca. Chama o construtor da classe mãe (World).
     */
     public Forca () {  
      super(1000, 500, 1);
      
    }  
   
    /**
     * Método que recebe uma letra como palpite.
     */
     public void ReceberLetraPalpite() {  
         this.letra_s = JOptionPane.showInputDialog("Informe a letra: ");
      }
   
    /**
     * Método que recebe uma palavra como palpite.
     */
    public void ReceberPalavraPalpite() {
        this.palavra_palpite = JOptionPane.showInputDialog("Informe a palavra: ");   
    }
    
    /**
     * Método que padroniza a letra informada como palpite para letra maiúscula.
     * @return letra_c char - letra informada em letra maiúscula.
     */
    public char PadronizarLetra(){
        this.letra_c = this.letra_s.charAt(0);
        this.letra_c = Character.toUpperCase(letra_c);
        return this.letra_c;
    }
    
    /**
     * Método que padroniza a palavra informada como palpite para letras maiúsculas.
     * @return palavra_palpite String - palavra informada em letras maiúsculas.
     */
    public String PadronizarPalavraPalpite(){
        this.palavra_palpite = this.palavra_palpite.toUpperCase();
        return this.palavra_palpite;
    }
    
    /**
     * Método que, a cada rodada, inicializa um ArrayList que armazena a quantidade de espaços da uma palavra a ser adivinhada. Estilo do ArrayList: [_ _ _ _ _ _]
     * @param jogadorpalavra Jogador
     * @return ArrayPalavra ArrayList<Character> - ArrayList que armazena a quantidade de letras da palavra a ser adivinhada.
     */
     public ArrayList<Character> InicializarArrayPalavra(Jogador jogadorpalavra){
            this.ArrayPalavra = new ArrayList<Character>(jogadorpalavra.palavra.length());
            for(int i = 0; i < jogadorpalavra.palavra.length(); i++){
                if(jogadorpalavra.palavra.charAt(i) == ' '){
                    this.ArrayPalavra.add(i, '\n');
                } else{
                    this.ArrayPalavra.add(i, '_');   
                }
            }
         
            return this.ArrayPalavra;
        }
 
    /**
     * Método que exibe a dica da palavra a ser adivinhada.
     * @param jogadorpalavra Jogador 
     */
    public void InformarDicaPalavra(Jogador jogadorpalavra){
         JOptionPane.showMessageDialog(null, "Dica da palavra: " + jogadorpalavra.dica_palavra);    
    }
    
    /**
     * Método que verifica se a letra informada como palpite está presente na palavra.
     * @param jogadorpalavra Jogador
     * @return boolean - valor booleano que informa se a letra dada como palpite está presente na palavra a ser adivinhada.
     */
    public boolean VerificarOcorrenciaLetra(Jogador jogadorpalavra){
        if(jogadorpalavra.palavra.indexOf(this.letra_c) != -1){
            return true;
        } else{
            return false;
        }
    }
    
    /**
     * Método que informa ao usuário se a letra informada está presente na palavra.
     * @param letracerta boolean 
     */
    public void InformarOcorrencia(boolean letracerta){
        if(letracerta){
            JOptionPane.showMessageDialog(null, "Parabéns! A letra está presente na palavra.");
        } else{
            JOptionPane.showMessageDialog(null, "Ops! A letra informada não está presente na palavra. :(");
        }
    }
    
    /**
     * Método que diminui a quantidade de tentativas do jogador, caso este erre um palpite.
     * @param jogadorpalpite JogadorHumano
     */
    public void AtualizarTentativasJogador(JogadorHumano jogadorpalpite){
        jogadorpalpite.tentativas_restantes -= 1;
    }

    /**
     * Método que atualiza o ArrayPalavra, caso o jogador acerte a palavra completa.
     * @param jogadorpalavra Jogador
     * @return ArrayPalavra ArrayList<Character> - ArrayList preenchido com todas as letras da palavra adivinhada. 
     */
    
    public ArrayList<Character> AtualizarArrayPalavraAcertou(Jogador jogadorpalavra){ 
        this.ArrayPalavra.clear();
        for(int i = 0; i < jogadorpalavra.palavra.length(); i++){
                this.ArrayPalavra.add(i, jogadorpalavra.palavra.charAt(i));
            } 
        return this.ArrayPalavra;
    }

    /**
     * Método que atualiza o ArrayLetrasPalpite com a letra que o jogador deu como palpite.
     * @return ArrayLetrasPalpite - ArrayList contendo todas as letras que o jogador já forneceu como palpite.
     */
  
    public ArrayList<Character> AtualizarArrayLetrasPalpite(){
        this.ArrayLetrasPalpite.add(this.indiceArrayLetras, this.letra_c);
        this.indiceArrayLetras += 1;
        
        return this.ArrayLetrasPalpite;
    }
    
    /**
     * Método que verifica se a letra dada como palpite já foi informada antes.
     * @return boolean - valor booleano que informa se a letra já foi informada previamente.
     */
    
    public boolean VerificarSeLetraInformada(){
        if(this.ArrayLetrasPalpite.contains(this.letra_c)){
                return true;
            } else{
                return false;
            }
        }
    
    /**
     * Método que informa ao usuário que a letra informada como palpite já foi informada anteriormente.
     */
    public void LetraInformada(){
         JOptionPane.showMessageDialog(null, "A letra informada já foi dita anteriormente! Por favor, informe uma nova letra.");
    }
       
    /**
     * Método que compara a palavra dada como palpite com a palavra a ser adivinhada, informando se estas são ou não iguais.
     * @param jogadorpalavra Jogador
     * @return todasletrasiguais boolean - valor booleano que informa se as palavras possuem todas as letras iguais.
     */
    
    public boolean CompararPalavras(Jogador jogadorpalavra){
        boolean todasletrasiguais = true;
        
        if(jogadorpalavra.palavra.length() == this.palavra_palpite.length()){
            for(int i = 0; i < jogadorpalavra.palavra.length(); i++){
                if(this.palavra_palpite.charAt(i) != jogadorpalavra.palavra.charAt(i)){
                    todasletrasiguais = false;
                    break;
                }
            }
        } else{
            todasletrasiguais = false;
        }
        if(todasletrasiguais){
            this.vitoria = true;
        }
        
        return todasletrasiguais;

    }
    
    /**
     * Método que retorna para o usuário se a palavra dada como palpite coincide com a palavra a ser adivinhada.
     * @param palavracerta boolean 
     */
    
    public void InformarIgualdadePalavra(boolean palavracerta){
        if(palavracerta == true){
           JOptionPane.showMessageDialog(null, "Parabéns! Você acertou a palavra.");
            this.vitoria = true;
        } else{
           JOptionPane.showMessageDialog(null, "Ops! A palavra informada está incorreta. :(");
        }
    }
  
   /**
    * Método que adiciona a letra dada como palpite (que está presente na palavra) ao ArrayList ArrayPalavra.
    * @param jogadorpalavra Jogador
    */
    public void AtualizarArrayPalavra(Jogador jogadorpalavra){
        for(int i = 0; i < jogadorpalavra.palavra.length(); i++){
            
            if(jogadorpalavra.palavra.charAt(i) == this.letra_c){
                this.ArrayPalavra.set(i, this.letra_c);
            }
        }
    }
    
    /**
     * Método que verifica se o ArrayList que armazena a palavra a ser adivinhada está todo preenchido por letras. 
     * Verifica se todas as letras da palavra já foram acertadas.
     */
    
    public void VerificarPreenchimentoPalavra(){
        if(ArrayPalavra.contains('_')){
            this.vitoria = false;
        } else{
            this.vitoria = true;
        }
    }
    
    /**Método que calcula a pontuação de cada jogador ao final da rodada.
     *Para cada tentativa que o jogadorpalpite perde, este perde 5 pontos e o jogadorpalavra ganha 5 pontos. 
     *Caso o jogadorpalpite acerte a palavra (vitoria == true), este ganha um bônus de 30 pontos além da pontuação relativa à quantidade de tentativas restantes.
     *Caso o jogadorpalpite erre a palavra, o jogadorpalavra ganha 30 pontos (6 tentativas * 5 pts = 30 pts).
     *@param jogadorpalpite JogadorHumano, jogadorpalavra Jogador
     **/
    
    public void CalcularPontuacaoRodada(JogadorHumano jogadorpalpite, Jogador jogadorpalavra){
        if(this.vitoria){
            
            jogadorpalpite.pontuacao_rodada = 30 + (jogadorpalpite.tentativas_restantes * 5);
            jogadorpalavra.pontuacao_rodada = (6 - jogadorpalpite.tentativas_restantes) * 5;
        } else {
            jogadorpalavra.pontuacao_rodada = 30;
        }
    }
    
    /**
     * Método que atualiza a pontuação total dos jogadores após o final da rodada.
     * @param jogadorpalpite, jogadorpalavra Jogador
     */
    public void AtualizarPontuacaoJogadores(Jogador jogadorpalpite, Jogador jogadorpalavra){
            jogadorpalpite.pontuacao_total = jogadorpalpite.pontuacao_total + jogadorpalpite.pontuacao_rodada;
            jogadorpalavra.pontuacao_total = jogadorpalavra.pontuacao_total + jogadorpalavra.pontuacao_rodada;
        }

    /**
     * Método que informa ao usuário o vencedor da rodada para partidas Jogador vs Jogador.
     * @param jogadorpalpite, jogadorpalavra Jogador
     */
    public void CompararPontuacaoRodada(Jogador jogadorpalpite, Jogador jogadorpalavra){
        if(jogadorpalpite.pontuacao_rodada > jogadorpalavra.pontuacao_rodada){
            JOptionPane.showMessageDialog(null, "Parabéns, " + jogadorpalpite.nome_jogador + "! Você ganhou essa rodada.\n"
                                                + "Número de pontos ganhos: " + jogadorpalpite.pontuacao_rodada);
        } else if(jogadorpalavra.pontuacao_rodada > jogadorpalpite.pontuacao_rodada){
            JOptionPane.showMessageDialog(null, "Parabéns, " + jogadorpalavra.nome_jogador + "! Você ganhou essa rodada.\n"
                                                + "Número de pontos ganhos: " + jogadorpalavra.pontuacao_rodada);
        } else if(jogadorpalavra.pontuacao_rodada == jogadorpalpite.pontuacao_rodada){
           JOptionPane.showMessageDialog(null, "Houve um empate nessa rodada!");
        }
    }
    
    /**
     * Método que informa ao usuário o vencedor da rodada para partidas Jogador vs Máquina.
     * @param jogadorpalpite Jogador, jogadormaquina JogadorMaquina
     */
    public void CompararPontuacaoRodada(Jogador jogadorpalpite, JogadorMaquina jogadormaquina){
        if(jogadorpalpite.pontuacao_rodada > jogadormaquina.pontuacao_rodada){
          JOptionPane.showMessageDialog(null, "Parabéns, " + jogadorpalpite.nome_jogador + "! Você ganhou essa rodada.\n"
                                                + "Numero de pontos ganhos: " + jogadorpalpite.pontuacao_rodada);
        } else if(jogadorpalpite.pontuacao_rodada > jogadormaquina.pontuacao_rodada){
         JOptionPane.showMessageDialog(null, "O computador ganhou esta rodada. :( Tente novamente."); 
        } else{
           JOptionPane.showMessageDialog(null, "Houve um empate nessa rodada!");
        }
    }    
    
    /**
     * Método que informa ao usuário quem foi o vencedor da partida.
     * @param jogador1, jogador2 JogadorHumano
     */
    public void FimJogo(JogadorHumano jogador1, JogadorHumano jogador2){
        if(jogador1.pontuacao_total > jogador2.pontuacao_total){
          JOptionPane.showMessageDialog(null, "Parabéns, " + jogador1.nome_jogador + "! Vocé é o/a vencedor/a!");
        } else if(jogador2.pontuacao_total > jogador1.pontuacao_total){
           JOptionPane.showMessageDialog(null, "Parabéns, " + jogador2.nome_jogador + "! Vocé é o/a vencedor/a!");
        } else{
           JOptionPane.showMessageDialog(null, "Houve um empate! Que tal jogarem mais uma partida para desempatar?");
        }
    } 
    
    /**
     * Método que atualiza ao final de cada rodada o boolean vitoria, responsável por informar se a palavra foi acertada.      
     */
    public void AtualizarVitoria(){
        this.vitoria = false;
    }
    
    /**
     * Método que, a cada rodada, limpa o ArrayList que armazena as letras que foram dadas como palpite.
     */  
    public void LimparArrayLetrasPalpite(){
        this.ArrayLetrasPalpite.clear();
    }

    /**
     * Método que, a cada rodada, zera o índice do ArrayList ArrayLetrasPalpite.
     */  
    public void ZerarIndiceArrayLetras(){
        this.indiceArrayLetras = 0;
    }
    
 }
   


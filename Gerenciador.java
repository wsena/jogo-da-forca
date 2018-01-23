import greenfoot.*; 
import javax.swing.JOptionPane;
import java.lang.String;

public class Gerenciador extends World {

    JogadorHumano jogador1 = new JogadorHumano();
    JogadorHumano jogador2 = new JogadorHumano();
    JogadorMaquina jogadormaquina = new JogadorMaquina();
    
    Forca forca = new Forca();
    
    InterfaceJogo botaoletra = new InterfaceJogo(null);
    InterfaceJogo botaopalavra = new InterfaceJogo(null);
    InterfaceJogo botaodica = new InterfaceJogo(null);
    
    public Label um = new Label ("(1)", 35);
    public Label dois = new Label ("(2)", 35);
    public Label tres = new Label ("(3)", 35);
    public Label escolhetipo = new Label ("Pressione: (1) Jogador vs Máquina / (2) Jogador vs Jogador", 20);
    
    public InterfaceJogo cabeca = new InterfaceJogo(null);
    public InterfaceJogo corpo = new InterfaceJogo(null);
    public InterfaceJogo bracodireito = new InterfaceJogo(null);
    public InterfaceJogo bracoesquerdo = new InterfaceJogo(null);
    public InterfaceJogo pernadireita = new InterfaceJogo(null);
    public InterfaceJogo pernaesquerda = new InterfaceJogo(null);
    
    /**
     * Cria um novo mundo com 1000x500 celulas e tamanho de pixel 1x1.
     */
    public Gerenciador () {
        super(1000, 500, 1);
    }
    
    /**
     * Este método será executado no momento em que o Jogo da Forca for inicializado.
     */
    public void act() {
       prepare();
       InicializarPartida();       
        
    }
    
     /**
     * Este método inicializa uma partida de acordo com a key, e cada key corresponde a um tipo de jogador que podem ser do tipo JogadorHumano ou do tipo JogadorMáquina.
     * 
     */
    public void InicializarPartida(){
       MensagemInicial();
       String key = Greenfoot.getKey();
       if("1".equals(key)) {
            //JOptionPane.showMessageDialog(null, "Opcao indisponivel no momento");
            jogador1.jogar();
            AtualizaMensagemInicial(escolhetipo);
            Greenfoot.delay(1);
            for(int i = 0; i <= 3; i++){
                InicializarRodadaJogadorMaquina(jogadormaquina, jogador1, forca);
                Rodada(jogadormaquina, jogador1, forca);
            }
            
            //forca.FimJogo(jogador1, jogador2);
       } else if("2".equals(key)){
               jogador1.jogar();
               jogador2.jogar();
               AtualizaMensagemInicial(escolhetipo);
               Greenfoot.delay(1);               
               for(int i = 0; i <= 1; i++){
                   InicializarRodadaJogadorHumano(jogador1, jogador2);
                   Rodada(jogador1, jogador2, forca);
                
                   InicializarRodadaJogadorHumano(jogador2, jogador1);
                   Rodada(jogador2, jogador1, forca);             
              }
              forca.FimJogo(jogador1, jogador2);
        }  

    }

    /**
     * Este método inicializa a rodada do JogadorHumano, realizando todas as operações necessárias para a rodada inciar.
     * @param jogadorpalavra JogadorHumano.
     * @param jogadorpalpite JogadorHumano.
     */
    public void InicializarRodadaJogadorHumano(JogadorHumano jogadorpalavra, JogadorHumano jogadorpalpite){
        forca.ZerarIndiceArrayLetras();
        forca.LimparArrayLetrasPalpite();
        forca.AtualizarVitoria();
        jogadorpalavra.ZerarPontuacaoRodada();
        jogadorpalpite.ZerarPontuacaoRodada();
        jogadorpalavra.AtualizarTentativasRestantes();
        jogadorpalpite.AtualizarTentativasRestantes();
        
        jogadorpalavra.RecebePalavra();
        jogadorpalavra.RecebeDica();
        jogadorpalavra.PadronizarPalavra();
        forca.InicializarArrayPalavra(jogadorpalavra);
    }
    
     /**
     * Este método representa uma rodada do jogo que verifica as entradas do JogadorHumano, possuindo uma resposta correspondente a cada entrada, até o numero de tentativas
     * do jogadorpalpite for igual a 0.
     * 
     * @param jogadorpalavra JogadorHumano.
     * @param jogadorpalpite JogadorHumano.
     * @param forca Forca.
     */
   public void Rodada(Jogador jogadorpalavra, JogadorHumano jogadorpalpite, Forca forca){
       Label letrasinformadas = new Label("Letras já informadas: " + forca.ArrayLetrasPalpite.toString(), 20);
       Label array = new Label(obterPalavraArray(forca), 50);
       Label labeljogadorpalpite = new Label ("Pontuação " + jogadorpalpite.nome_jogador + ": " + jogadorpalpite.pontuacao_total, 20);
       Label labeljogadorpalavra = new Label ("Pontuação " + jogadorpalavra.nome_jogador + ": " + jogadorpalavra.pontuacao_total, 20);
       Label tentativas = new Label ("Tentativas restantes: " + jogadorpalpite.tentativas_restantes, 20);
           
       ImprimirListaLetras(letrasinformadas);
       ImprimirPalavra(array);
       InformarPontuacaoTotal(labeljogadorpalavra, labeljogadorpalpite);
       ImprimirTentativasRestantes(tentativas);
       Greenfoot.delay(1);
       
       while(forca.vitoria == false && jogadorpalpite.tentativas_restantes > 0){
            String key = Greenfoot.getKey();

            //Recebendo uma letra como palpite.
            if("1".equals(key)){
                boolean letrainformada = false;
                boolean letracerta = false;

                //tela.MensagemReceberLetra();
                //forca.ReceberLetraPalpite();
                forca.ReceberLetraPalpite(); 
                forca.PadronizarLetra();
                letrainformada = forca.VerificarSeLetraInformada();

                //Se a letra do palpite j� foi informada antes.
                if(letrainformada){
                    forca.LetraInformada();
                }
                //Caso a letra ainda n�o tenha sido informada.
                else{
                    letracerta = forca.VerificarOcorrenciaLetra(jogadorpalavra);
                    forca.InformarOcorrencia(letracerta);
                    forca.AtualizarArrayLetrasPalpite();
                    
                    AtualizarListaLetras(letrasinformadas);
                    Greenfoot.delay(1);
                    //Caso o jogador erre a letra.
                    if(letracerta == false){
                        forca.AtualizarTentativasJogador(jogadorpalpite);
                        
                        AtualizarTentativasRestantes(tentativas, jogadorpalpite);
                        DesenhaBoneco(jogadorpalpite);
                        Greenfoot.delay(1);
                    } 
                    //Caso o jogador acerte a letra.
                    else{
                        forca.AtualizarArrayPalavra(jogadorpalavra);
                        forca.VerificarPreenchimentoPalavra();
                        
                        AtualizarPalavra(array, forca);
                        Greenfoot.delay(1);
                    }
                }
            } 
            //Caso o jogador tente acertar a palavra inteira.
            else if("2".equals(key)){
                boolean palavracerta = false;

                //tela.MensagemReceberPalavra();
                forca.ReceberPalavraPalpite();
                forca.PadronizarPalavraPalpite();

                palavracerta = forca.CompararPalavras(jogadorpalavra);  

                //Caso o jogador acerte a palavra.
                if(palavracerta == true){
                    forca.InformarIgualdadePalavra(palavracerta);
                    forca.AtualizarArrayPalavraAcertou(jogadorpalavra);
                    
                    AtualizarPalavra(array, forca);
                    Greenfoot.delay(1);
                } 
                //Caso o jogador erre a palavra.
                else{
                    forca.InformarIgualdadePalavra(palavracerta);
                    forca.AtualizarTentativasJogador(jogadorpalpite);
                    
                    AtualizarTentativasRestantes(tentativas, jogadorpalpite);
                    DesenhaBoneco(jogadorpalpite);
                    Greenfoot.delay(1);
                }

            } 
            //Informar dica da palavra.
            else if("3".equals(key)){
                forca.InformarDicaPalavra(jogadorpalavra);
            }       

        }

        //Final da rodada
            forca.CalcularPontuacaoRodada(jogadorpalpite, jogadorpalavra);
            forca.AtualizarPontuacaoJogadores(jogadorpalpite, jogadorpalavra);
            forca.CompararPontuacaoRodada(jogadorpalavra, jogadorpalpite);
            
            removeObject(letrasinformadas);
            removeObject(array);
            removeObject(labeljogadorpalpite);
            removeObject(labeljogadorpalavra);
            removeObject(tentativas);
            removerPartesBoneco();
    }
   
     /**
    * Este método inicializa a rodada do jogador máquina, realizando todas as operações necessárias para a rodada inciar.
    * @param jogadorpalpite JogadorHumano.
    * @param jogadormaquina JogadorMaquina.
    */
    public void InicializarRodadaJogadorMaquina(JogadorMaquina jogadormaquina, JogadorHumano jogadorpalpite, Forca forca){

        forca.ZerarIndiceArrayLetras();
        forca.LimparArrayLetrasPalpite();
        forca.AtualizarVitoria();
        jogadormaquina.ZerarPontuacaoRodada();
        jogadorpalpite.ZerarPontuacaoRodada();
        jogadorpalpite.AtualizarTentativasRestantes();
        
        jogadormaquina.jogar();
        forca.InicializarArrayPalavra(jogadormaquina);
    }
        
    
     /**
     * Este instancia objetos no mundo do tipo Label, que exibe as letras que o jogador erra ao tentar a palavra.
     * @param letrasinformadas Label.
     */
    public void ImprimirListaLetras(Label letrasinformadas){
        addObject(letrasinformadas, 240, 470);
    }
    
    /**
     * Este método atualiza as letras já informadas pelo jogador.
     * @param letrasinformadas Label.
     */
     public void AtualizarListaLetras(Label letrasinformadas){
        letrasinformadas.setText("Letras já informadas: " + forca.ArrayLetrasPalpite.toString(), 20); 
    }
    
    /**
     * Este método instancia objetos no mundo do tipo Label, que exibe as tentativas que o jogador que tenta acertar a palavra possui.
     * @param tentativas Label.
     */
    public void ImprimirTentativasRestantes(Label tentativas){
        addObject(tentativas, 843, 87);
    }
    
    /**
     * Este método atualiza as tentativas restantes do jogador que tenta acertar a palavra, que vai diminuindo a medida em que o ele vai errando.
     * @param tentativas Label.
     * @param jogadorpalpite JogadorHumano.
     */
    public void AtualizarTentativasRestantes(Label tentativas, JogadorHumano jogadorpalpite){
        tentativas.setText("Tentativas restantes: " + jogadorpalpite.tentativas_restantes, 20);
    }
    
    /**
     * Este método armazena em uma variável String os characters presentes em cada índice do ArrayList.
     * @return String palavra_array - String que possui o conteúdo do Arraylist.
     */
    public String obterPalavraArray(Forca forca){
        String palavra_array = "";
        for(int i = 0; i < forca.ArrayPalavra.size(); i++){
            palavra_array += forca.ArrayPalavra.get(i) + " ";
    }
        return palavra_array;
    }
    
    /**
     * Este método instancia objetos no mundo do tipo Label, que exibe na tela o ArrayList inicial, que será preenchido de acordo com as letras informadas pelo JogadorHumano.
     * @param array Label.
     */
    public void ImprimirPalavra(Label array) {
        addObject(array, 700, 310);
        
    }
    
     /**
     * Este método atualiza o ArrayList que está sendo exibido, de acordo com as letras informadas pelo Jogador Humano.
     * @param array Label.
     * @param forca Forca.
     */
     public void AtualizarPalavra(Label array, Forca forca) {
        array.setText(obterPalavraArray(forca), 50);
    }
    
    /**
     * Este método instancia objetos no mundo do tipo Label, que exibe a mensagem inicial de seleção do tipo de jogo.
     */
    public void MensagemInicial() {
        addObject(escolhetipo, 509, 20);
    }
    
     /**
     * Este método atualiza a mensagem inicial.
     * @param escolhetipo Label
     */
    public void AtualizaMensagemInicial(Label escolhetipo){
        escolhetipo.setText("", 20);
    }
    
    /**
     * Este método instancia objetos no mundo do tipo Label, que exibe as informações sobre a pontuação dos jogdores do tipo JogadorHumano.
     * @param jogadorpalpite Label.
     * @param jogadorpalavra Label.
     */
    public void InformarPontuacaoTotal(Label jogadorpalpite, Label jogadorpalavra){
        addObject(jogadorpalpite, 843, 22);
        addObject(jogadorpalavra, 843, 51);
    }
    
    /**
     * Prepara o mundo para o início do programa. Cria os objetos iniciais e os adiciona no mundo.
     */
   private void prepare(){
        DesenhaBotoes();
   }
   
     /**
    * Este método instancia objetos no mundo, que representam botões.
    */
   public void DesenhaBotoes(){
        
        botaoletra.DesenharBotaoLetra();
        addObject(botaoletra, 766, 435);
        addObject(um, 766, 479);
        
        botaopalavra.DesenharBotaoPalavra();
        addObject(botaopalavra, 839, 435);
        addObject(dois, 839, 479);
  
        botaodica.DesenharBotaoDica();
        addObject(botaodica, 912, 435);
        addObject(tres, 912, 479);
    }
    
    /**
     * Este método desenha partes de um boneco na tela quando o jogador erra um palpite.
     */
    public void DesenhaBoneco(JogadorHumano jogadorpalpite) {
         
         if (jogadorpalpite.tentativas_restantes == 5) {
            cabeca.DesenharCabeca();
            addObject(cabeca, 318, 126);
           } else if (jogadorpalpite.tentativas_restantes == 4) {
            corpo.DesenharCorpo();
            addObject(corpo, 319, 206);
           } else if (jogadorpalpite.tentativas_restantes == 3){
            bracodireito.DesenharBracoDireito();
            addObject(bracodireito, 332, 203);
           } else if (jogadorpalpite.tentativas_restantes == 2) {
            bracoesquerdo.DesenharBracoEsquerdo();
            addObject(bracoesquerdo, 304, 205);
           } else if (jogadorpalpite.tentativas_restantes == 1) {
            pernadireita.DesenharPernaDireita();
            addObject(pernadireita,  330, 261);
           } else if (jogadorpalpite.tentativas_restantes == 0){
            pernaesquerda.DesenharPernaEsquerda();
            addObject(pernaesquerda, 311, 263);
        }
    
    }
    
    /**
     * Este método Remove as partes de um boneco exibidas na tela após o fim de uma rodada.
     */
    public void removerPartesBoneco(){
            removeObject(cabeca);   
            removeObject(corpo);
            removeObject(bracodireito);
            removeObject(bracoesquerdo);
            removeObject(pernadireita);
            removeObject(pernaesquerda);
        }
    }
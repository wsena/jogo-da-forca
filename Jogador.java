import greenfoot.*; 

public abstract class Jogador extends Actor{
    public String nome_jogador;
	public String palavra;
    public String dica_palavra;
	public int pontuacao_rodada = 0;
	public int pontuacao_total = 0;
	
     /**
     * Método abstrato será implementado pelos Jogadores do tipo Máquina e do tipo Humano.
     * 
     */
	public abstract void jogar();
	
	/**
	 * Este método zera a pontuação dos jogadores ao final da partida.
	 */
    public void ZerarPontuacao() 
    {
    	this.pontuacao_total = 0;
    	
    }
    
     /**
     * Este método zera a pontuação dos jogadores ao final de cada rodada.
     */
    public void ZerarPontuacaoRodada()
    {
    	this.pontuacao_rodada = 0;
    }
    
}

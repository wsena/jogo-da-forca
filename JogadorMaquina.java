import greenfoot.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;

import javax.swing.JOptionPane;

/**
 * Write a description of class JogadorMaquina here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class JogadorMaquina extends Jogador{
    String nome_jogador = "Máquina";
    private Properties propriedades = new Properties();
    private Random sorteador = new Random();
    
    private String prefixo_palavra = "palavra_";
    private String prefixo_dica = "dica_";
    private String nomearquivo = "palavras_jogador_maquina.txt";
    private final int max_chave = 10;
    
    public JogadorMaquina(){
        iniciaPropriedades();
    }
    
    public void act(){
        // Add your action code here.
    }
    
    /**
     * Implementação do método abstrato jogar(), presente na classe mãe Jogador.
     */
    @Override
    public void jogar(){
        sorteiaPalavra();
    }
    
    /**
     * Método que associa um conjunto de chaves a palavras e dicas, fornando conjuntos do tipo <chave, valor>. 
     */
    private void iniciaPropriedades(){
        propriedades.setProperty(prefixo_palavra+"1", "CONSTRUTOR");
        propriedades.setProperty(prefixo_dica+"1", "Estratégia de montagem de um objeto.");
        
        propriedades.setProperty(prefixo_palavra+"2", "BYTECODE");
        propriedades.setProperty(prefixo_dica+"2", "Código interpretado pela Máquina Virtual Java.");
        
        propriedades.setProperty(prefixo_palavra+"3", "POLIMORFISMO");
        propriedades.setProperty(prefixo_dica+"3", "Capacidade de um objeto poder ser referenciado de várias formas.");
        
        propriedades.setProperty(prefixo_palavra+"4", "SOBRECARGA");
        propriedades.setProperty(prefixo_dica+"4", "Capacidade de um mesmo nome identificar coisas diferentes (para métodos e construtores).");
        
        propriedades.setProperty(prefixo_palavra+"5", "ATRIBUTOS");
        propriedades.setProperty(prefixo_dica+"5", "Dados que representam o estado de um objeto.");
        
        propriedades.setProperty(prefixo_palavra+"6", "ARRAYLIST");
        propriedades.setProperty(prefixo_dica+"6", "Classe que implementa um vetor redimensionável.");
        
        propriedades.setProperty(prefixo_palavra+"7", "HASHTABLE");
        propriedades.setProperty(prefixo_dica+"7", "Classe que mapeia uma chave a um valor.");
        
        propriedades.setProperty(prefixo_palavra+"8", "INTERFACE");
        propriedades.setProperty(prefixo_dica+"8", "Maneira através da qual conversamos com um objeto.");
        
        propriedades.setProperty(prefixo_palavra+"9", "HERANÇA");
        propriedades.setProperty(prefixo_dica+"9", "Permite a criação de novas classes com reutilização de código.");
        
            propriedades.setProperty(prefixo_palavra+"10", "ENCAPSULAMENTO");
        propriedades.setProperty(prefixo_dica+"10", "Forma de proteger os dados manipulados dentro de uma classe.");
    }
    
    /**
     * Método que realiza o sorteio aleatoriamente de uma palavra no conjunto <chave, valor>.
     */
    
    public void sorteiaPalavra(){
        int numero = sorteador.nextInt(max_chave);
        
        this.palavra = propriedades.getProperty(prefixo_palavra+numero);
        this.dica_palavra = propriedades.getProperty(prefixo_dica+numero);
        
    }
    
}
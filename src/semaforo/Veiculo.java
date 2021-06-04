/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semaforo;

import java.util.Random;

/**
 *
 * @author saruto
 */
public class Veiculo {
    
    private final int id;
    private int velocidade;
    private String cor;
    private Enum tamanho;

    public Veiculo() {
        this.id = new Random().nextInt(20*2);
        this.setCor("preto");
        this.setTamanho(Enum.PEQUENO);
        this.setVelocidade(60);
    }

    public Veiculo(int velocidade, String cor, Enum tamanho) {
        this.id = new Random().nextInt(20*2);
        this.velocidade = velocidade;
        this.cor = cor;
        this.tamanho = tamanho;
    }

    public int getId() {
        return id;
    }

    public int getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(int velocidade) {
        this.velocidade = velocidade;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getTamanho() {
        switch(this.tamanho){
            case PEQUENO:
                return "pequeno";
            case MEDIO:
                return "médio";
            case GRANDE:
                return "grande";
            case LONGO:
                return "longo";
            default:
                return "pequeno";
        }
    }

    public void setTamanho(Enum tamanho) {
        this.tamanho = tamanho;
    }

    @Override
    public String toString() {
        return String.valueOf(getId());
    }
    
}

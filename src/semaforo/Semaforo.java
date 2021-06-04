/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semaforo;

/**
 *
 * @author saruto
 */
public class Semaforo{
    
    private String nome;
    private Enum cor;

    public Semaforo() {
        this.cor = Enum.VERMELHO;
    }
    
    public Semaforo(String nome) {
        this.cor = Enum.VERMELHO;
        this.nome = nome;
    }

    public Enum getCor() {
        return cor;
    }
    
    public String getVcor() {
        switch(this.cor){
            case VERDE:
                return "verde";
            case VERMELHO:
                return "vermelho";
            default:
                return "vermelho";
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public void trocarCor(){
        switch(this.cor){
            case VERDE:
                this.cor = Enum.VERMELHO;
                break;
            case VERMELHO:
                this.cor = Enum.VERDE;
                break;
        }
    }
    
    public void apresentar(){
        System.out.println("            ["+this.getNome()+"]---<"+this.getVcor().toUpperCase()+">");
    }
    
}

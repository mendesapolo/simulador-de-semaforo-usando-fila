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
public class Carro extends Veiculo {
    
    private String modelo;
    private String matricula;

    public Carro() {
        super(160, "i10", Enum.PEQUENO);
    }
    
    public Carro(String modelo, String matricula) {
        super(160, "i10", Enum.PEQUENO);
        this.modelo = modelo;
        this.matricula = matricula;
    }

    public Carro(String modelo, String matricula, int velocidade, String cor, Enum tamanho) {
        super(velocidade, cor, tamanho);
        this.modelo = modelo;
        this.matricula = matricula;
    }
    
    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    @Override
    public String toString() {
        return super.getId()+"["+this.getModelo()+"]";
    }

}

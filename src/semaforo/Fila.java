
package semaforo;

/**
 *
 * @author António Apolo
 */
public class Fila {
    
    public static final int MAX = 200;
    private int inicio;
    private int fim;
    private Veiculo vetor[];
    
    private String nome;

    public Fila() {
        this.inicio = 0;
        this.fim = 0;
        this.vetor = new Veiculo[MAX];
    }
    
    public Fila(String nome) {
        this.nome = nome;
        this.inicio = 0;
        this.fim = 0;
        this.vetor = new Veiculo[MAX];
    }
    
    public int incremetar(int i){
        
        if(i == Fila.MAX-1){
            return 0;
        }else{
            return i+1;
        }
    }
    
    public boolean isVazio(Fila fila){
        return fila.inicio == fila.fim;
    }
    
    public boolean add(Fila fila, Veiculo valor){
        if(incremetar(fila.fim) == fila.inicio){
//            System.out.println(fila.getNome()+"]--[Engarrafamento!!, vai demorar para passar");
//            System.out.println("----------------------------------------");
            return false;
        }
        
        fila.vetor[fila.fim] = valor;
        fila.fim = incremetar(fila.fim);
        System.out.println("-["+((Carro) valor).getMatricula()+"]--------[Parou na "+fila.getNome()+"]");
        System.out.println("----------------------------------------");
        return true;
    }
    
    public Veiculo remover(Fila fila){
        if(isVazio(fila)){
//            System.out.println("Sem carro na pista --["+fila.getNome());
//            System.out.println("----------------------------------------");
            return null;
        }
        
        Veiculo valor = fila.vetor[fila.inicio];
        fila.inicio = incremetar(fila.inicio);
        System.out.println("-["+((Carro) valor).getMatricula()+"]--------[Saiu da "+fila.getNome());
        System.out.println("----------------------------------------");
        return valor;
    }
    
    public void imprimir(Fila fila){
        System.out.println("----------------------------------------");
        System.out.println("           "+fila.getNome());
        System.out.println("----------------------------------------");
        if(fila.vetor.length > 0){
        for(int i = fila.inicio; i != fila.fim; i++){
            System.out.println("P:["+i+"]--<>--[ V: <"+((Carro) fila.vetor[i]).getMatricula()+">]");
        }
        }else{
            System.out.println("      PISTA VAZÍA / LIVRE   ");
        }
        System.out.println("----------------------------------------");
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
}

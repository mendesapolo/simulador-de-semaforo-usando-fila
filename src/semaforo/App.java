/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semaforo;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author saruto
 */
public class App extends TimerTask { //implements Runnable{

    private final Fila pista1;
    private final Fila pista2;

    private Semaforo s1;
    private Semaforo s2;

    private int tempoExec;

    public App() {
        this.tempoExec = 0;

        this.pista1 = new Fila("PISTA-1");
        this.pista2 = new Fila("PISTA-2");
        s1 = new Semaforo("SEMAFORO-1");
        s2 = new Semaforo("SEMAFORO-2");
        s1.trocarCor();
    }

    int getTempoAdd() {
        int rand = new Random().nextInt(5000);
        if (rand >= 1000) {
            return rand;
        }
        return getTempoAdd();
    }

    boolean trocar(long time) {
        if (this.tempoExec >= 15000) {
            s1.trocarCor();
            s2.trocarCor();
            this.tempoExec = 0;
            return true;
        } else {
            this.tempoExec += time;
            return false;
        }
    }

    @Override
    public void run() {
        System.out.println("\n\n\n|----------------------------------------------|");
        s1.apresentar();
        s2.apresentar();
        System.out.println("|----------------------------------------------|");
        try {
            while (true) {
                if (s1.getCor() == Enum.VERDE) {
                    int tm = 3000;
                    if (this.pista1.remover(this.pista1) != null) {
                        Thread.sleep(tm);
                        if (trocar(tm)) {
                            break;
                        }
                    }

                    int rd = new Random().nextInt(10);
                    if (this.pista2.add(pista2, new Carro("mdl " + rd, new Random().nextInt(20) + "-" + rd + "-lda"))) {
                        tm = getTempoAdd();
                        Thread.sleep(tm);
                        if (trocar(tm)) {
                            break;
                        }
                    }

                } else {
                    int tm = 3000;
                    if (this.pista2.remover(this.pista2) != null) {
                        Thread.sleep(tm);
                        if (trocar(tm)) {
                            break;
                        }
                    }

                    int rd = new Random().nextInt(10);
                    if (this.pista1.add(pista1, new Carro("mdl " + rd, new Random().nextInt(40) + "-" + rd + "-lda"))) {
                        tm = getTempoAdd();
                        Thread.sleep(tm);
                        if (trocar(tm)) {
                            break;
                        }
                    }
                }
            }
            this.pista1.imprimir(pista1);
            System.out.println("\n");
            this.pista2.imprimir(pista2);
            System.out.println("\n");
        } catch (InterruptedException err) {
            System.out.println("Erro executar um sleep:: " + err.getMessage());
        }
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        App a = new App();
        Timer tempo = new Timer();
        tempo.schedule(a, 0, 16000);

    }

}

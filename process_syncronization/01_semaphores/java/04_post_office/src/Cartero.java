
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author daniel
 */
public class Cartero extends Thread {

    Estante estante;
    int numeroCartero;

    public Cartero(Estante estante, int numeroCartero) {
        this.estante = estante;
        this.numeroCartero = numeroCartero;
    }

    public void run() {

        while (true) {

            try {
                estante.tomarCarta();
            } catch (InterruptedException ex) {
                Logger.getLogger(Cartero.class.getName()).log(Level.SEVERE, null, ex);
            }

            int tiempoEntrega = (int) (Math.random() * 10);
            System.out.println("Cartero " + numeroCartero + " entrega 2 cartas por " + tiempoEntrega + " segundos");

            try {
                sleep(tiempoEntrega * 1000);
            } catch (InterruptedException e) {
            }

            System.out.println("Cartero " + numeroCartero + " regresa a la oficina");

        }
    }
}

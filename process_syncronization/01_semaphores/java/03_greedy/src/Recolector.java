
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
public class Recolector extends Thread {

    Mesa mesa;
    int numeroRecolector;

    public Recolector(Mesa mesa, int numeroRecolector) {
        this.mesa = mesa;
        this.numeroRecolector = numeroRecolector;
    }

    public void run() {

        while (true) {

            int tiempoRecogiendo = (int) (Math.random() * 10);
            System.out.println("Recolector " + numeroRecolector + " recogiendo dulce por " + tiempoRecogiendo + " segundos");

            try {
                sleep(tiempoRecogiendo * 1000);
            } catch (InterruptedException e) {
            }

            System.out.println("Recolector " + numeroRecolector + " pone dulce en la mesa");

            try {
                mesa.colocarDulce();
            } catch (InterruptedException ex) {
                Logger.getLogger(Recolector.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}


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

    Canasto canasto;
    int numeroRecolector;

    public Recolector(Canasto canasto, int numeroRecolector) {
        this.canasto = canasto;
        this.numeroRecolector = numeroRecolector;
    }

    public void run() {

        while (true) {

            int tiempoRecogiendo = (int) (Math.random() * 10);
            System.out.println("Recolector " + numeroRecolector + " recogiendo naranja por " + tiempoRecogiendo + " segundos");

            try {
                sleep(tiempoRecogiendo * 1000);
            } catch (InterruptedException e) {
            }

            System.out.println("Recolector " + numeroRecolector + " coloca naranja en canasto");
            try {
                canasto.bajarNaranja();
            } catch (InterruptedException ex) {
                Logger.getLogger(Recolector.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }
}

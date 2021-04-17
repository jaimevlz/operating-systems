
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
public class Comensal extends Thread {

    Canasto canasto;

    public Comensal(Canasto canasto) {
        this.canasto = canasto;
    }

    public void run() {

        while (true) {

            try {
                canasto.comerNaranja();
            } catch (InterruptedException ex) {
                Logger.getLogger(Comensal.class.getName()).log(Level.SEVERE, null, ex);
            }

            int tiempoComer = (int) (Math.random() * 10);
            System.out.println("Comensal comiendo naranja por " + tiempoComer + " segundos");

            try {
                sleep(tiempoComer * 1000);
            } catch (InterruptedException e) {
            }

            System.out.println("Comensal termina de comer");

        }

    }
}

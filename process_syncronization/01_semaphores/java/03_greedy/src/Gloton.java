
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
public class Gloton extends Thread {

    Mesa mesa;

    public Gloton(Mesa mesa) {
        this.mesa = mesa;
    }

    public void run() {

        while (true) {

            try {
                mesa.tomarDulce();
            } catch (InterruptedException ex) {
                Logger.getLogger(Gloton.class.getName()).log(Level.SEVERE, null, ex);
            }

            int tiempoComer = (int) (Math.random() * 10);
            System.out.println("Gloton comiendo dulce por " + tiempoComer + " segundos");

            try {
                sleep(tiempoComer * 1000);
            } catch (InterruptedException e) {
            }

            System.out.println("Gloton termina de comer");
        }
    }
}

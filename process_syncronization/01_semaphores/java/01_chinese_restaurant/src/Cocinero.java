
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
public class Cocinero extends Thread {

    Mesa mesa;

    public Cocinero(Mesa mesa) {
        this.mesa = mesa;
    }

    public void run() {

        while (true) {

            int tiempoCocinando = (int) (Math.random() * 10);
            System.out.println("Cocinero preparando comida por " + tiempoCocinando + " segundos");

            try {
                sleep(tiempoCocinando * 1000);
            } catch (InterruptedException e) {
            }

            System.out.println("Cocinero trae un nuevo pedido a la mesa");
            
            try {
                mesa.colocarPedido();
            } catch (InterruptedException ex) {
                Logger.getLogger(Cocinero.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
}

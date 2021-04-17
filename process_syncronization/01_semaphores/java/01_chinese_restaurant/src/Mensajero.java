
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
public class Mensajero extends Thread {

    Mesa mesa;
    int numeroMensajero;

    public Mensajero(Mesa mesa, int numeroMensajero){
        this.mesa = mesa;
        this.numeroMensajero = numeroMensajero;
    }

    public void run(){
        
        while(true){
            try {
                mesa.atenderPedido();
            } catch (InterruptedException ex) {
                Logger.getLogger(Mensajero.class.getName()).log(Level.SEVERE, null, ex);
            }

            int tiempoEntregando = (int) (Math.random() * 10);
            System.out.println("Mensajero " + numeroMensajero + " entregando comida por " + tiempoEntregando + " segundos");

            try {
                sleep(tiempoEntregando * 1000);
            } catch (InterruptedException e) {
            }

            System.out.println("Mensajero " + numeroMensajero + " ha atendido 2 pedidos");
        }

    }

}

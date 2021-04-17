
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
public class Administrador extends Thread {

    Estante estante;

    public Administrador(Estante estante) {
        this.estante = estante;
    }

    public void run() {

        while (true) {

            int tiempoRecibe = (int) (Math.random() * 10);
            System.out.println("Administrador espera cartas por " + tiempoRecibe + " segundos");

            try {
                sleep(tiempoRecibe * 1000);
            } catch (InterruptedException e) {
            }

            System.out.println("Administrador coloca 4 cartas en estante");

            try {
                estante.colocarCarta();
            } catch (InterruptedException ex) {
                Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }
}

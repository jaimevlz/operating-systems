
import java.util.concurrent.Semaphore;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author daniel
 */
public class Mesa {

    int cantidadDulces;
    Semaphore espaciosDisponibles;
    Semaphore dulcesDisponibles;
    Semaphore mutex;

    public Mesa() {
        cantidadDulces = 0;
        espaciosDisponibles = new Semaphore(10, true);
        dulcesDisponibles = new Semaphore(0, true);
        mutex = new Semaphore(1, true);
    }

    public void colocarDulce() throws InterruptedException {
        espaciosDisponibles.acquire();
        mutex.acquire();
        cantidadDulces = cantidadDulces + 1;
        mutex.release();
        dulcesDisponibles.release();
    }

    public void tomarDulce() throws InterruptedException {
        dulcesDisponibles.acquire();
        mutex.acquire();
        cantidadDulces = cantidadDulces - 1;
        mutex.release();
        espaciosDisponibles.release();
    }
}

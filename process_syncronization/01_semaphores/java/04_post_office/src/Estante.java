
import java.util.concurrent.Semaphore;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author daniel
 */
public class Estante {

    int cantidadCartas = 0;
    Semaphore espaciosDisponibles;
    Semaphore cartasDisponibles;
    Semaphore mutex;

    public Estante(){
        espaciosDisponibles = new Semaphore(50, true);
        cartasDisponibles = new Semaphore(0, true);
        mutex = new Semaphore(1, true);
    }

    public void colocarCarta() throws InterruptedException{
        espaciosDisponibles.acquire();
        espaciosDisponibles.acquire();
        espaciosDisponibles.acquire();
        espaciosDisponibles.acquire();
        mutex.acquire();
        cantidadCartas = cantidadCartas + 4;
        mutex.release();
        cartasDisponibles.release();
        cartasDisponibles.release();
        cartasDisponibles.release();
        cartasDisponibles.release();
    }

    public void tomarCarta() throws InterruptedException{
        cartasDisponibles.acquire();
        cartasDisponibles.acquire();
        mutex.acquire();
        cantidadCartas = cantidadCartas - 2;
        mutex.release();
        espaciosDisponibles.release();
        espaciosDisponibles.release();
    }

}

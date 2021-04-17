
import java.util.concurrent.Semaphore;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author daniel
 */
public class Canasto {

    int cantidadNaranjas;
    private Semaphore naranjasDisponibles;
    private Semaphore mutex;

    public Canasto(){
        cantidadNaranjas = 0;
        naranjasDisponibles = new Semaphore(0, true);
        mutex = new Semaphore(1, true);
    }

    public void bajarNaranja() throws InterruptedException{
        mutex.acquire();
        cantidadNaranjas = cantidadNaranjas + 1;
        mutex.release();
        naranjasDisponibles.release();
    }

    public void comerNaranja() throws InterruptedException{
        naranjasDisponibles.acquire();
        mutex.acquire();
        cantidadNaranjas = cantidadNaranjas - 1;
        mutex.release();
    }

}

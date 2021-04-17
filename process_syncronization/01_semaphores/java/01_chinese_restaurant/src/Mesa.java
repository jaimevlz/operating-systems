
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

    int cantidadPedidos;
    private Semaphore cajasDisponibles;
    private Semaphore mutex;

    public Mesa() {
        cantidadPedidos = 0;
        cajasDisponibles = new Semaphore(0,true);
        mutex = new Semaphore(1, true);
    }

    public void colocarPedido() throws InterruptedException {
        mutex.acquire();
        cantidadPedidos = cantidadPedidos + 1;
        mutex.release();
        cajasDisponibles.release();
    }

    public void atenderPedido() throws InterruptedException {
        cajasDisponibles.acquire();
        cajasDisponibles.acquire();
        mutex.acquire();
        cantidadPedidos = cantidadPedidos - 2;
        mutex.release();
    }
}

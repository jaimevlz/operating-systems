
import java.util.concurrent.Semaphore;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author daniel
 */
public class Database {

    int readerCount;
    Semaphore mutex;
    Semaphore db;

    public Database() {
        readerCount = 0;
        mutex = new Semaphore(1, true);
        db = new Semaphore(1, true);
    }

    public void startRead() throws InterruptedException {
        mutex.acquire();
        readerCount = readerCount + 1;
        if (readerCount == 1) {
            db.acquire();
        }
        mutex.release();
    }

    public void endRead() throws InterruptedException {
        mutex.acquire();
        readerCount = readerCount - 1;
        mutex.release();
        if (readerCount == 0) { // Si esta adentro de mutex se da mas importancia al escritor
            db.release();
        }
    }

    public void startWrite() throws InterruptedException {
        db.acquire();
    }

    public void endWrite() {
        db.release();
    }
}

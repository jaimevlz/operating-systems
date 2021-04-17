
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
public class Writer extends Thread {

    Database database;

    public Writer(Database database) {
        this.database = database;
    }

    public void run() {

        while (true) {

            try {
                database.startWrite();
            } catch (InterruptedException ex) {
                Logger.getLogger(Writer.class.getName()).log(Level.SEVERE, null, ex);
            }

            int tiempoEscribe = (int) (Math.random() * 10);
            System.out.println("Writer writes on database for " + tiempoEscribe + " seconds");

            try {
                sleep(tiempoEscribe);
            } catch (InterruptedException e) {
            }

            database.endWrite();

            System.out.println("Writer leaves database");
        }
    }
}

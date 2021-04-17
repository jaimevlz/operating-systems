
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
public class Reader extends Thread {

    Database database;
    int readerNumber;

    public Reader(Database database, int readerNumber) {
        this.database = database;
        this.readerNumber = readerNumber;
    }

    public void run() {

        while (true) {

            try {
                database.startRead();
            } catch (InterruptedException ex) {
                Logger.getLogger(Reader.class.getName()).log(Level.SEVERE, null, ex);
            }

            int tiempoLee = (int) (Math.random() * 10);
            System.out.println("Reader " + readerNumber + " reads on database for " + tiempoLee + " seconds");


            try {
                sleep(tiempoLee * 1000);
            } catch (InterruptedException e) {
            }

            try {
                database.endRead();
            } catch (InterruptedException ex) {
                Logger.getLogger(Reader.class.getName()).log(Level.SEVERE, null, ex);
            }

            System.out.println("Reader " + readerNumber + " leaves database");

        }

    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author daniel
 */
public class Test {

    public static void main(String args[]) {

        Database database = new Database();

        Writer writerProcess = new Writer(database);
        Reader readerProcess1 = new Reader(database, 1);
        Reader readerProcess2 = new Reader(database, 2);
        Reader readerProcess3 = new Reader(database, 3);

        writerProcess.start();
        readerProcess1.start();
        readerProcess2.start();
        readerProcess3.start();
    }
}

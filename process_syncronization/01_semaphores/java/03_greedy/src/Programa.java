/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author daniel
 */
public class Programa {

    public static void main(String args[]){

        Mesa mesa = new Mesa();

        Recolector procesoRecolector1 = new Recolector(mesa, 1);
        Recolector procesoRecolector2 = new Recolector(mesa, 2);
        Recolector procesoRecolector3 = new Recolector(mesa, 3);
        Gloton procesoGloton = new Gloton(mesa);

        procesoRecolector1.start();
        procesoRecolector2.start();
        procesoRecolector3.start();
        procesoGloton.start();

    }

}

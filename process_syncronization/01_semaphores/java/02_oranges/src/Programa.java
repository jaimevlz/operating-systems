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

        Canasto canasto = new Canasto();

        Recolector procesoRecolector1 = new Recolector(canasto, 1);
        Recolector procesoRecolector2 = new Recolector(canasto, 2);
        Recolector procesoRecolector3 = new Recolector(canasto, 3);
        Comensal procesoComensal = new Comensal(canasto);

        procesoRecolector1.start();
        procesoRecolector2.start();
        procesoRecolector3.start();
        procesoComensal.start();

    }

}

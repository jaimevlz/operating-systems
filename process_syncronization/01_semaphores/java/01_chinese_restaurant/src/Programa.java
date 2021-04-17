/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author daniel
 */
public class Programa {

    public static void main(String main[]) {

        Mesa mesa = new Mesa();

        Cocinero procesoCocinero = new Cocinero(mesa);
        Mensajero procesoMensajero1 = new Mensajero(mesa, 1);
        Mensajero procesoMensajero2 = new Mensajero(mesa, 2);
        Mensajero procesoMensajero3 = new Mensajero(mesa, 3);

        procesoCocinero.start();
        procesoMensajero1.start();
        procesoMensajero2.start();
        procesoMensajero3.start();

    }
}

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

        Estante estante = new Estante();

        Administrador procesoAdministrador = new Administrador(estante);
        Cartero procesoCartero1 = new Cartero(estante, 1);
        Cartero procesoCartero2 = new Cartero(estante, 2);
        Cartero procesoCartero3 = new Cartero(estante, 3);

        procesoAdministrador.start();
        procesoCartero1.start();
        procesoCartero2.start();
        procesoCartero3.start();

    }

}

package Classes;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author BUE
 */
public class Apartment extends Property{
    private boolean Parking;
    private boolean Duplex;

    public Apartment(boolean Parking, boolean Duplex, int PropertyId, String PropertyCategory, float PropertySize, String Description, float Price, String PropertyType, String Address, String City) {
        super(PropertyId, PropertyCategory, PropertySize, Description, Price, PropertyType, Address, City);
        this.Parking = Parking;
        this.Duplex = Duplex;
    }


    public boolean isParking() {
        return Parking;
    }

    public void setParking(boolean Parking) {
        this.Parking = Parking;
    }

    public boolean isDuplex() {
        return Duplex;
    }

    public void setDuplex(boolean Duplex) {
        this.Duplex = Duplex;
    }
}

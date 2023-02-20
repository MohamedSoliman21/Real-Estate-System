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
public class Villa extends Property{
    private boolean Pool;
    private boolean Garden;
    private int FloorNumbers;

    public Villa(boolean Pool, boolean Garden, int FloorNumbers, int PropertyId, String PropertyCategory, float PropertySize, String Description, float Price, String PropertyType, String Address, String City) {
        super(PropertyId, PropertyCategory, PropertySize, Description, Price, PropertyType, Address, City);
        this.Pool = Pool;
        this.Garden = Garden;
        this.FloorNumbers = FloorNumbers;
    }

    

    

    public boolean isPool() {
        return Pool;
    }

    public void setPool(boolean Pool) {
        this.Pool = Pool;
    }

    public boolean isGarden() {
        return Garden;
    }

    public void setGarden(boolean Garden) {
        this.Garden = Garden;
    }

    public int getFloorNumbers() {
        return FloorNumbers;
    }

    public void setFloorNumbers(int FloorNumbers) {
        this.FloorNumbers = FloorNumbers;
    }
    
}

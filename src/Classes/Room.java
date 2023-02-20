/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author BUE
 */
public class Room {
    private int Bedroom[];
    private int LivingRoom[];
    private int Bathroom[];

    public Room(int[] Bedroom, int[] LivingRoom, int[] Bathroom) {
        this.Bedroom = Bedroom;
        this.LivingRoom = LivingRoom;
        this.Bathroom = Bathroom;
    }

    public int[] getBedroom() {
        return Bedroom;
    }

    public void setBedroom(int[] Bedroom) {
        this.Bedroom = Bedroom;
    }

    public int[] getLivingRoom() {
        return LivingRoom;
    }

    public void setLivingRoom(int[] LivingRoom) {
        this.LivingRoom = LivingRoom;
    }

    public int[] getBathroom() {
        return Bathroom;
    }

    public void setBathroom(int[] Bathroom) {
        this.Bathroom = Bathroom;
    }    
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author Youssef Abdulaziz
 */
public class CashPayment implements PaymentMethod{
    public void payment (String amount){
            System.out.println("Seeker pays amount " + amount + "US as cash");
    }
}

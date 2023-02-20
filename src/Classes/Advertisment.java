package Classes;

import java.util.ArrayList;

public class Advertisment  implements Observable {
    private int Ad_Code;
    private String Availability;
    private ArrayList<Observer> observe = new ArrayList<Observer>();

    public Advertisment() {
    }

    public Advertisment(int Ad_Code, String Availability) {
        this.Ad_Code = Ad_Code;
        this.Availability = Availability;
    }

    public int getAd_Code() {
        return Ad_Code;
    }

    public void setAd_Code(int Ad_Code) {
        this.Ad_Code = Ad_Code;
    }

    public String getAvailability() {
        return Availability;
    }

    public void setAvailability(String Availability) {
        this.Availability = Availability;
     System.out.println("Availability changed from Not available to Available");
       notifyObservers();
    }

    public ArrayList<Observer> getObserve() {
        return observe;
    }

    public void setObserve(ArrayList<Observer> observe) {
        this.observe = observe;
    }
 
    
    
    
    
    
    
    
    
    
 @Override
 public void AddObserver( Observer observer )
 {
 observe.add(observer);

 }

 @Override
 public void removeObserver( Observer observer )
 {
 observe.remove(observer);

 }

 @Override
 public void notifyObservers()
 {
 System.out.println("Ad Code :" + this.getAd_Code() + ", Availability : " + this.getAvailability() + " is available now.So notifying all the users ");
 System.out.println();
 
    for( Observer observer : observe )
    {
    observer.update(this.Availability);
    }
 }
}

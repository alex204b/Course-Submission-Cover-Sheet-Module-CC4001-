

public class Mobile extends Gadget
{
     private int callingCredit; 
     
      public Mobile(String model, double price, int weight, String size, int callingCredit) 
    {
        super(model, price, weight, size);  
        this.callingCredit = callingCredit;
    }
    
    public int getCallingCredit() 
    {
        return callingCredit;
    }
     
    public void addCredit(int additionalCredit) {
        if (additionalCredit > 0) {
            callingCredit += additionalCredit;
            System.out.println("Added " + additionalCredit + " minutes of credit. Total credit: " + callingCredit);
        } else {
            System.out.println("Please enter a positive amount to add credit.");
        }
    }
    
    public void makeCall(String phoneNumber, int duration) {
        if (callingCredit >= duration) {
            callingCredit -= duration;
            System.out.println("Calling " + phoneNumber + " for " + duration + " minutes.");
        } else {
            System.out.println("Insufficient credit to make the call. Available credit:"  + callingCredit);
        }
    }
    
    public void display() {
        super.display(); 
        System.out.println("Calling Credit: " + callingCredit + " minutes remaining");
    }
    
}

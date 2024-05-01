

public class MP3 extends Gadget
{
    private int availableMemory;
    
    public MP3(String model, double price, int weight, String size, int availableMemory) {
        super(model, price, weight, size);  
        this.availableMemory = availableMemory;
    }
    
    public int getAvailableMemory() {
        return availableMemory;
    }
    
    public void downloadMusic(int memorySize) {
        if (availableMemory >= memorySize) {
            availableMemory -= memorySize;
            System.out.println("Music downloaded. Remaining memory: " + availableMemory + " MB");
        } else {
            System.out.println("Insufficient memory to download music.");
        }
    }
    
    public void deleteMusic(int memorySize) {
        availableMemory += memorySize;
        System.out.println("Music deleted. Available memory: " + availableMemory + " MB");
    }
    
    public void display() {
        super.display();  
        System.out.println("Available Memory: " + availableMemory + " MB");
    }
}

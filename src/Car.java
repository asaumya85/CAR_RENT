import java.util.*;
class Car {
    private String Id;
    private String brand;
    private String model;
    private double basePrice;
    private boolean isAvailable;

    public Car(String Id, String brand, String model, double basePrice){
        this.Id=Id;
        this.brand=brand;
        this.model=model;
        this.basePrice=basePrice;
        this.isAvailable=true;
    }
    public String getCarId(){
        return Id;
    }
    public String getBrand(){
        return brand;
    }
    public String getModel(){
        return model;
    }
    public double calculatePrice( int rentalDays){
        return basePrice*rentalDays;
    }
    public boolean isAvailable(){
        return isAvailable;
    }
    public void rent(){
        isAvailable=false;
    }
    public void returnCar(){
        isAvailable=true;
    }
}

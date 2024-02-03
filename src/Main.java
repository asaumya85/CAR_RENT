public class Main {
    public static void main(String[] args) {
        CarRentalSys rentalSystem= new CarRentalSys();
        Car car1=new Car("C001","Toyota","Camary",60.0);
        Car car2=new Car("C002","Honda","i10",100.0);
        Car car3=new Car("C003","Mahindra","Thar",120.0);
        Car car4=new Car("C004","Renault","Dustre",90.0);
        Car car5=new Car("C005","XUV","Mercedes",180.0);


        rentalSystem.addCar(car1);
        rentalSystem.addCar(car2);
        rentalSystem.addCar(car3);
        rentalSystem.addCar(car4);
        rentalSystem.addCar(car5);


        rentalSystem.menu();
    }
}
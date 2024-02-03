import java.util.*;
class CarRentalSys {
//    declaration
    private List<Car> cars;
    private List<Customer> customers;
    private List<Rental> rentals;
//    constructor
    public CarRentalSys(){
        cars=new ArrayList<>();
        customers= new ArrayList<>();
        rentals = new ArrayList<>();
    }
    public void addCar(Car car){
       cars.add(car);
    }
    public void addCustomer(Customer customer){
        customers.add(customer);
    }
    public void rentCar(Car car, Customer customer,int days){
        if(car.isAvailable()){
            car.rent();
            rentals.add(new Rental(car, customer,days));
        }
        else{
            System.out.println("car is not available for rent");
        }
    }
    public void returnCar(Car car){
        car.returnCar();
        Rental rentalToRemove=null;
        for(Rental rental: rentals){
            if (rental.getCar() == car) {
                rentalToRemove=rental;
                break;
            }
            if(rentalToRemove!=null){
                rentals.remove(rentalToRemove);
            }
            else{
                System.out.println("Car was not rented");
            }
        }
    }
    public void menu(){
        Scanner scanner= new Scanner(System.in);
        while(true){
            System.out.println("Wlcm to car rental System");
            System.out.println(" 1.Rent a car");
            System.out.println("return a car");
            System.out.println("exit");
            System.out.println("enter a choice");
            int choice= scanner.nextInt();
            scanner.nextLine();

            if(choice ==1){
                System.out.println("Rent a car here");
                System.out.println("Enter your name");
                String customerName=scanner.nextLine();

                System.out.println("Availablibity of car");
                for(Car car:cars){
                    if(car.isAvailable()){
                        System.out.println(car.getCarId()+" "+car.getBrand()+" "+car.getModel());
                    }
                }
                System.out.println("Enter the Car id you want to rent");
                String carId=scanner.nextLine();
                System.out.println("Number of Rental Days");
                int rentalDays=scanner.nextInt();
                scanner.nextLine();

                Customer newCustomer=new Customer("CUS" + (customers.size() + 1), customerName);
                addCustomer(newCustomer);

                Car selectedCar=null;
                for(Car car:cars){
                    if(car.getCarId().equals(carId) && car.isAvailable()){
                        selectedCar=car;
                        break;
                    }
                }
                if(selectedCar!=null){
                    double totalPrice=selectedCar.calculatePrice(rentalDays);
                    System.out.println("Rental Car Information ");
                    System.out.println("Customer_ID: "+newCustomer.getCustomerId());
                    System.out.println("Customer Name: "+newCustomer.getCustomerName());
                    System.out.println("Car :"+ selectedCar.getBrand()+" "+ selectedCar.getModel());
                    System.out.println("Rental days :"+rentalDays);
                    System.out.printf("Total Price : $%.2f%n",totalPrice);

                    System.out.println("Last Confirmation(Y/N)");
                    String confirm=scanner.nextLine();

                    if(confirm.equalsIgnoreCase("Y")){
                        rentCar(selectedCar,newCustomer,rentalDays);
                        System.out.println("Car is given for Rent");
                    }else{
                        System.out.println("Rented Cancellation");
                    }
                }else{
                    System.out.println("Invalid car Selection  or car is not available");
                }
            }else if(choice==2){
                System.out.println("Return a Car");
                System.out.println("Enter a CarID you want ot return");
                String carId=scanner.nextLine();

                Car carToReturn= null;
                for(Car car:cars) {
                    if (car.getCarId().equals(carId) && !car.isAvailable()){
                        carToReturn = car;
                    break;
                }
                }
                if(carToReturn !=null){
                    Customer customer =null;
                    for(Rental rental : rentals){
                        if(rental.getCar()==carToReturn){
                            customer=rental.getCustomer();
                            break;
                        }
                    }
                    if(customer != null ){
                        returnCar(carToReturn);
                        System.out.println("Car returned succesfully by "+customer.getCustomerName());
                    }else{
                        System.out.println("Car is not rented or rental information is missing");
                    }
                }else{
                    System.out.println("Invalid car ID or car is not rented");
                }
            }else if(choice==3) {
                break;
            }else{
                System.out.println("Invalid Choice.please Enter  a valid option");
            }
        }

        System.out.println("Thanx for using Car Rental System");
    }
}

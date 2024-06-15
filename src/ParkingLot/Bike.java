package ParkingLot;

public class Bike extends Vehicle{
    Bike(String Number){
        super(Number, 1);
    }

    @Override
    double getRate() {
        // TODO Auto-generated method stub
        return 1.0;
    }
    
}

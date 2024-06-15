package ParkingLot;

public class Car extends Vehicle{

    Car(String Number){
        super(Number, 1);
    }

    @Override
    double getRate() {
        // TODO Auto-generated method stub
        return 2.0;
    }
    
}

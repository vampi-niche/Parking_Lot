package ParkingLot;

public class Bus extends Vehicle{

    Bus(String Number){
        super(Number, 5);
    }

    @Override
    double getRate() {
        // TODO Auto-generated method stub
        return 5.0;
    }
    
}

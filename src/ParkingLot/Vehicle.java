package ParkingLot;

public abstract class Vehicle {
    int spotsNeeded;
    String Number;

    Vehicle(String Number, int spotsNeeded){
        this.Number = Number;
        this.spotsNeeded = spotsNeeded;
    }

    public int getSpotsNeeded() {
        return spotsNeeded;
    }

    public String getNumber() {
        return Number;
    }

    abstract double getRate();


}

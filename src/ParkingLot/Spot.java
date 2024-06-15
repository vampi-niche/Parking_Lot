package ParkingLot;

public class Spot {
    int spotID;
    
    private Vehicle vehicle;

    Spot(int spotID){
        this.spotID = spotID;
    }

    boolean isOccupied(){
        return vehicle !=null;
    }

    int park(Vehicle vehicle){
        this.vehicle = vehicle;
        return this.spotID;
    }

    void unPark(){
        this.vehicle = null;
    }

    public int getSpotID() {
        return spotID;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }
    
}

package ParkingLot;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;
import java.time.Duration;

public class Ticket {

    private Vehicle vehicle;
    private List<Spot> spots;

    private LocalDateTime entryTime;

    Ticket(Vehicle vehicle, LocalDateTime entryTime, List<Spot> spots){
        this.vehicle = vehicle;
        this.entryTime = entryTime;
        this.spots = new ArrayList<>(spots);

        
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public List<Spot> getSpots() {
        return spots;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public double calculateTariff() {
        Duration duration = Duration.between(entryTime, LocalDateTime.now());
        long hours = duration.toNanos()%24; // simulate hours
        return hours * vehicle.getRate();
    }
    public String getDetails() {
        return String.format("Vehicle: %s, License Plate: %s, Entry Time: %s, Spots: %d",
                vehicle.getClass().getSimpleName(),
                vehicle.getNumber(),
                entryTime,
                spots.size());
    }

    
}

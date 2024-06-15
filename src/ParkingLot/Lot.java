package ParkingLot;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lot {

    private static Lot instance;

    private List<Spot> spots;

    private Map <Vehicle, Ticket> currentParking;

    private double revenue;

    Lot(int n){
        this.spots = new ArrayList<>(n);
        for(int i=1;i<=n;i++){
            spots.add(new Spot(i));
        }
        this.currentParking = new HashMap<>();
        this.revenue = 0;

    }

    public static Lot getInstance(int n){

        if(instance == null){
            instance = new Lot(n);
        }

        return instance;
    }

    public synchronized Ticket parkVehicle(Vehicle vehicle){
        int requiredSpots = vehicle.getSpotsNeeded();
        List<Spot> availableSpots = findAvailableSpots(requiredSpots);
        if(availableSpots.size() < requiredSpots) {
            System.out.println("Parking full!!!");
        }
        for(Spot spot:availableSpots){
            spot.park(vehicle);
        }
        
        Ticket ticket = new Ticket(vehicle, LocalDateTime.now(), availableSpots);
        currentParking.put(vehicle, ticket);
        System.out.println("Parked following vehicle:");
        System.out.println(ticket.getDetails());
        System.out.println("Remaining free spots: " + getFreeSpots());

        return ticket;


    }

    public synchronized double exitVehicle(Vehicle vehicle){
        
        Ticket vehicleTicket = currentParking.remove(vehicle);

        if(vehicleTicket == null) return 0.0;

        for(Spot spot:vehicleTicket.getSpots()){
            spot.unPark();
        }

        double price = vehicleTicket.calculateTariff();

        revenue +=price;

        System.out.println("Exiting following Vehicle:");
        System.out.println(vehicleTicket.getDetails());
        System.out.println("Remaining free spots: " + getFreeSpots());

        

        return price;
    }

    public synchronized int getFreeSpots(){
        int freeSpots = 0;

        for(Spot spot: spots){
            if(!spot.isOccupied()) freeSpots++;
        }
        return freeSpots;


    }

    public  List<Vehicle> getParkedVehicles(){
        return new ArrayList<>(currentParking.keySet());


    }
    public synchronized double getRevenue() {
        return revenue;
    }

    private List<Spot> findAvailableSpots(int requiredSpots){

        List<Spot> availableSpots = new ArrayList<>();
        for(Spot spot: spots){
            if(!spot.isOccupied()){
                availableSpots.add(spot);
                if(availableSpots.size()==requiredSpots) break;
            }
        }
        return availableSpots;

    }




    
}

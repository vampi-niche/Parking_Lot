package ParkingLot;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        Lot myLot = Lot.getInstance(100);
        System.out.println("Lot Instace created with 100 spots");


        Vehicle bike = new Bike("BOSS");
        Vehicle bus = new Bus("SarVesh");
        Vehicle car = new Car("Speed");

        Ticket carTicket = myLot.parkVehicle(car);
        Ticket bikeTicket = myLot.parkVehicle(bike);
        Ticket busTicket = myLot.parkVehicle(bus);

        
        System.out.println("Bike exit tariff: " + myLot.exitVehicle(bike));
        System.out.println("Car exit tariff: " + myLot.exitVehicle(car));
        System.out.println("Bus exit tariff: " + myLot.exitVehicle(bus));

        System.out.println("Free spots after exits: " + myLot.getFreeSpots());
        System.out.println("Revenue after exit: " + myLot.getRevenue());


        // ================================================

        //  Lot myLot = Lot.getInstance(10); // small parking lot for testing

        // List<Thread> threads = new ArrayList<>();

        // // Create 10 threads to park vehicles
        // for (int i = 0; i < 10; i++) {
        //     int vehicleNumber = i;
        //     Thread thread = new Thread(() -> {
        //         Vehicle vehicle;
        //         if (vehicleNumber % 3 == 0) {
        //             vehicle = new Bike("Bike" + vehicleNumber);
        //         } else if (vehicleNumber % 3 == 1) {
        //             vehicle = new Car("Car" + vehicleNumber);
        //         } else {
        //             vehicle = new Bus("Bus" + vehicleNumber);
        //         }
        //         myLot.parkVehicle(vehicle);
        //         try {
        //             Thread.sleep((long) (Math.random() * 5000)); // Simulate parking duration
        //         } catch (InterruptedException e) {
        //             e.printStackTrace();
        //         }
        //         myLot.exitVehicle(vehicle);
        //     });
        //     threads.add(thread);
        // }

        // // Start all threads
        // for (Thread thread : threads) {
        //     thread.start();
        // }

        // // Wait for all threads to finish
        // for (Thread thread : threads) {
        //     thread.join();
        // }

        // // Print final revenue
        // System.out.println("Total Revenue: " + myLot.getRevenue());




    }
}

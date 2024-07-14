package com.prash.java.sample.java8;

import java.util.Arrays;
import java.util.function.Function;

public class MethodReferenceWithEnum {

    enum Vehicle {
        CAR(VehicleService::getCarPrice),
        TRUCK(VehicleService::getTruckPrice);
        public final Function<VehicleService, Integer> priceFunction;

        Vehicle(Function<VehicleService, Integer> priceFunction) {
            this.priceFunction = priceFunction;
        }
    }

    public static void main(String[] args) {
        VehicleService vehicleService = new VehicleService();
        Arrays.stream(Vehicle.values()).forEach(vehicle -> System.out.println(vehicleService.getPrice(vehicle)));
    }

    static class VehicleService {
        public int getCarPrice() {
            return 10;
        }

        public int getTruckPrice() {
            return 20;
        }

        public int getPrice(Vehicle vehicle) {
            return vehicle.priceFunction.apply(this);
        }
    }
}

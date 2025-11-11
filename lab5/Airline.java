package lab5;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Клас, що описує авіакомпанію, яка володіє парком літаків.
 */
public class Airline {
    private final List<Aircraft> fleet = new ArrayList<>();

    public void addAircraft(Aircraft aircraft) {
        if (aircraft == null) {
            throw new IllegalArgumentException("Літак не може бути null");
        }
        fleet.add(aircraft);
    }

    public double calculateTotalPayload() {
        return fleet.stream().mapToDouble(Aircraft::getPayload).sum();
    }

    public int calculateTotalCapacity() {
        return fleet.stream().mapToInt(Aircraft::getCapacity).sum();
    }

    public void sortByFlightRange() {
        fleet.sort(Comparator.comparingInt(Aircraft::getFlightRange));
    }

    public List<Aircraft> findAircraftByFuelRange(double min, double max) {
        if (min < 0 || max < 0 || min > max) {
            throw new IllegalArgumentException("Некоректний діапазон споживання пального.");
        }
        List<Aircraft> result = new ArrayList<>();
        for (Aircraft aircraft : fleet) {
            if (aircraft.getFuelConsumption() >= min && aircraft.getFuelConsumption() <= max) {
                result.add(aircraft);
            }
        }
        return result;
    }

    public void displayFleet() {
        for (Aircraft a : fleet) {
            a.displayInfo();
        }
    }
}

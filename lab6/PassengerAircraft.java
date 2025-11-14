package lab6;

/**
 * Клас, що представляє пасажирський літак.
 */
public class PassengerAircraft extends Aircraft {

    public PassengerAircraft(String model, int flightRange, double fuelConsumption, int capacity) {
        super(model, flightRange, fuelConsumption, capacity, 0);
    }

    @Override
    public void displayInfo() {
        System.out.println("Пасажирський літак -> " + this);
    }
}

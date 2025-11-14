package lab6;

/**
 * Клас, що представляє вантажний літак.
 */
public class CargoAircraft extends Aircraft {

    public CargoAircraft(String model, int flightRange, double fuelConsumption, double payload) {
        super(model, flightRange, fuelConsumption, 0, payload);
    }

    @Override
    public void displayInfo() {
        System.out.println("Вантажний літак -> " + this);
    }
}

package lab6;

/**
 * Клас, що описує загальні характеристики літака.
 */
public abstract class Aircraft {
    protected String model;
    protected int flightRange; // дальність польоту в км
    protected double fuelConsumption; // споживання пального
    protected int capacity; // пасажиромісткість
    protected double payload; // вантажопідйомність

    public Aircraft(String model, int flightRange, double fuelConsumption, int capacity, double payload) {
        this.model = model;
        this.flightRange = flightRange;
        this.fuelConsumption = fuelConsumption;
        this.capacity = capacity;
        this.payload = payload;
    }

    public String getModel() {
        return model;
    }

    public int getFlightRange() {
        return flightRange;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public int getCapacity() {
        return capacity;
    }

    public double getPayload() {
        return payload;
    }

    /**
     * Вивести інформацію про літак.
     */
    public abstract void displayInfo();

    @Override
    public String toString() {
        return String.format("%s: дальність=%dkm, пальне=%.1fл/100км, пасажири=%d, вантаж=%.1fт",
                model, flightRange, fuelConsumption, capacity, payload);
    }
}

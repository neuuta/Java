package lab5;
import java.util.List;
public class lab5 {
    public static void main(String[] args) {
        try {
            Airline airline = new Airline();
            airline.addAircraft(new PassengerAircraft("Passenger Aircraft1", 4800, 2600, 180));
            airline.addAircraft(new PassengerAircraft("Passenger Aircraft2", 6400, 2500, 170));
            airline.addAircraft(new CargoAircraft("Cargo Aircraft1", 4300, 7200, 120));
            airline.addAircraft(new CargoAircraft("Cargo Aircraft2", 7900, 6800, 130));

            System.out.println("Парк літаків компанії");
            airline.displayFleet();

            System.out.println("\nЗагальна пасажиромісткість: " + airline.calculateTotalCapacity());
            System.out.println("Загальна вантажопідйомність: " + airline.calculateTotalPayload() + " тонн");

            System.out.println("\nСортування за дальністю польоту");
            airline.sortByFlightRange();
            airline.displayFleet();

            System.out.println("\nПошук літаків за діапазоном споживання пального (5000–7000 л/100км)");
            List<Aircraft> found = airline.findAircraftByFuelRange(5000, 7000);
            for (Aircraft a : found) {
                System.out.println("Знайдено: " + a);
            }

        } catch (IllegalArgumentException e) {
            System.err.println("Помилка введення даних: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Невідома помилка: " + e.getMessage());
        }
    }
}
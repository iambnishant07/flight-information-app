import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class FlightTest {
    private ArrayList<Flight> flights;

    public FlightTest() {
        flights = new ArrayList<>();
    }

    public void addFlight(Flight flight) {
        flights.add(flight);
    }

    public ArrayList<Flight> getFlights() {
        return flights;
    }

    public void sortFlights() {
        Collections.sort(flights, Comparator.comparing(Flight::getFlightNumber));
    }

    public String exportFlightsToCSV() {
        StringBuilder csv = new StringBuilder("Airline Name,Flight Number,Origin,Destination,Airfare,Departure Time,Arrival Time,Duration\n");
        for (Flight flight : flights) {
            csv.append(flight.toCSVFormat()).append("\n");
        }
        return csv.toString();
    }
}

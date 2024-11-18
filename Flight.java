public class Flight {
    private String airlineName;
    private String flightNumber;
    private String flightOrigin;
    private String destinationCity;
    private double airfare;
    private String departureTime;
    private String arrivalTime;
    private double flightDuration;

    public Flight(String airlineName, String flightNumber, String flightOrigin, String destinationCity,
                  double airfare, String departureTime, String arrivalTime, double flightDuration) {
        this.airlineName = airlineName;
        this.flightNumber = flightNumber;
        this.flightOrigin = flightOrigin;
        this.destinationCity = destinationCity;
        this.airfare = airfare;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.flightDuration = flightDuration;
    }

    public String getAirlineName() { return airlineName; }
    public String getFlightNumber() { return flightNumber; }
    public String getFlightOrigin() { return flightOrigin; }
    public String getDestinationCity() { return destinationCity; }
    public double getAirfare() { return airfare; }
    public String getDepartureTime() { return departureTime; }
    public String getArrivalTime() { return arrivalTime; }
    public double getFlightDuration() { return flightDuration; }

    @Override
    public String toString() {
        return airlineName + ", " + flightNumber + ", " + flightOrigin + ", " + destinationCity + ", " 
               + airfare + ", " + departureTime + ", " + arrivalTime + ", " + flightDuration;
    }

    public Object[] toArray() {
        return new Object[]{airlineName, flightNumber, flightOrigin, destinationCity, airfare, 
                            departureTime, arrivalTime, flightDuration};
    }

    public String toCSVFormat() {
        return airlineName + "," + flightNumber + "," + flightOrigin + "," + destinationCity + "," + airfare + "," 
               + departureTime + "," + arrivalTime + "," + flightDuration;
    }
}

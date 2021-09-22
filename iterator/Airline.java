package designpatterns.iterator;

public class Airline {
    private String title;
    private Flight[] flights;
    private int size;

    public Airline(String title) {
        this.title = title;
        flights = new Flight[2];
        this.size = 0;
    }

    public void addFlight(String flightNum, String from, String to, int duration, int transfers) {
        Flight newFlight = new Flight(flightNum, from, to, duration, transfers);
        if(size < flights.length) {
            flights[size] = newFlight;
        }
        else {
            flights = growArray(flights);
            flights[size] = newFlight;
        }
        size++;
    }

    public String getTitle() {
        return this.title;
    }

    private Flight[] growArray(Flight[] flights) {
        Flight[] bigFlights = new Flight[size*2];
        for(int i = 0; i < flights.length; i++) {
            bigFlights[i] = flights[i];
        }
        return bigFlights;
    }

    public FlightIterator createIterator() {
        return new FlightIterator(flights);
    } 

}
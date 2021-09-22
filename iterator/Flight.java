package designpatterns.iterator;

public class Flight {
    private String flightNum;
    private String from;
    private String to;
    private int duration;
    private int transfers;

    public Flight(String flightNum, String from, String to, int duration, int transfers) {
        this.flightNum = flightNum;
        this.from = from;
        this.to = to;
        this.duration = duration;
        this.transfers = transfers;
    }

    public String getFrom() {
        return this.from;
    }

    public String getTo() {
        return this.to;
    }

    public int getDuration() {
        return this.duration;
    }

    public int getNumTransfers() {
        return this.transfers;
    }

    public String toString() {
        int hours = 0;
        int minutes = this.duration;
        while(minutes >= 60) {
            minutes -= 60;
            hours++;
        }

        String transferAmt;
        if(this.transfers == 0) {
            transferAmt = "Direct Flight\n";
        }
        else if(this.transfers == 1) {
            transferAmt = "1 Transfer\n";
        }
        else {
            transferAmt = this.transfers + " Transfers\n";
        }

        return "Flight Number: " + this.flightNum + "\n" +
            "From: " + this.from + "\n" +
            "To: " + this.to + "\n" +
            "Duration: " + hours + " hours " + minutes + " minutes\n" +
            transferAmt;
    }
}

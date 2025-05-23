package entity;

public class Ride {
    private Long id;
    private String date;
    private String route;
    private Long driverId;
    private Long clientId;

    private static Long counter = 0L;

    public Ride(String date, String route, Long driverId, Long clientId) {
        counter++;
        this.id = counter;
        this.date = date;
        this.route = route;
        this.driverId = driverId;
        this.clientId = clientId;
    }
}

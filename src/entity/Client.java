package entity;

public class Client {
    private Long id;
    private String name;

    private static Long counter = 0L;

    public Client(String name) {
        counter++;
        this.id = counter;
        this.name = name;
    }
}

package entity;

public class Clent {
    private Long id;
    private String name;

    private static Long counter = 0L;

    public Clent(String name) {
        counter++;
        this.id = counter;
        this.name = name;
    }
}

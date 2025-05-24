package entity;

import java.util.ArrayList;
import java.util.Scanner;

public class Car {
    private Long id;
    private String model;
    private String registrationNumber;
    private ArrayList<Driver> drivers;

    private static Long counter = 0L;

    public Car() {
        counter++;
        this.id = counter;
        this.model = "undefined";
        this.registrationNumber = "undefined";
    }

    public void create() {
        Scanner in = new Scanner(System.in);

        while (model.trim().isEmpty() || model.equals("undefined")) {
            System.out.print("Введите модель автомобиля: ");
            model = in.nextLine();
            if (model.trim().isEmpty()) {
                System.out.println("Ошибка. Модель не может быть пустой.");
                model = "undefined";
            }
        }

        while (registrationNumber.trim().isEmpty() || registrationNumber.equals("undefined")) {
            System.out.print("Введите регистрационный номер: ");
            registrationNumber = in.nextLine();
            if (registrationNumber.trim().isEmpty()) {
                System.out.println("Ошибка. Регистрационный номер не может быть пустым.");
                registrationNumber = "undefined";
            }
        }
    }

    public void display() {
        System.out.println(model + " " + "(" + registrationNumber + ")");
    }
}

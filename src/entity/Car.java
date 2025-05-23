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
        this.model = "";
        this.registrationNumber = "";
    }

    public void create() {
        Scanner in = new Scanner(System.in);

        while (model.trim().isEmpty()) {
            System.out.print("Введите модель автомобиля: ");
            model = in.nextLine();
            if (model.trim().isEmpty()) {
                System.out.println("Ошибка. Модель не может быть пустой.");
            }
        }

        while (registrationNumber.trim().isEmpty()) {
            System.out.print("Введите регистрационный номер: ");
            registrationNumber = in.nextLine();
            if (registrationNumber.trim().isEmpty()) {
                System.out.println("Ошибка. Регистрационный номер не может быть пустым.");
            }
        }
    }

    public void display() {
        System.out.println(id + ". " + model + " " + "(" + registrationNumber + ")");
    }
}

package entity;

import java.util.ArrayList;
import java.util.Scanner;

public class Driver {
    private Long id;
    private Long personnelNumber;
    private String firstName;
    private String lastName;
    private String middleName;
    private String birthDate;
    private Car car;
    private ArrayList<String> transportedClients;
    private Double rating;

    private static Long counter = 0L;

    public Driver() {
        counter++;
        this.id = counter;
        this.personnelNumber = null;
        this.firstName = "undefined";
        this.lastName = "undefined";
        this.middleName = "undefined";
        this.birthDate = "undefined";
        this.rating = 0.0;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public void create() {
        Scanner in = new Scanner(System.in);

        while (personnelNumber == null || personnelNumber.toString().trim().isEmpty()) {
            try {
                System.out.print("Введите табельный номер: ");
                String input = in.nextLine();
                personnelNumber = Long.parseLong(input);
            } catch (NumberFormatException e) {
                System.out.println("Ошибка. Введите числовое значение.");
            }
        }

        while (lastName.trim().isEmpty() || lastName.equals("undefined")) {
            System.out.print("Введите фамилию: ");
            lastName = in.nextLine();
            if (lastName.trim().isEmpty()) {
                System.out.println("Ошибка. Фамилия не может быть пустой.");
                lastName = "undefined";
            }
        }

        while (firstName.trim().isEmpty() || firstName.equals("undefined")) {
            System.out.print("Введите имя: ");
            firstName = in.nextLine();
            if (firstName.trim().isEmpty()) {
                System.out.println("Ошибка. Имя не может быть пустым.");
                firstName = "undefined";
            }
        }

        while (middleName.trim().isEmpty() || middleName.equals("undefined")) {
            System.out.print("Введите отчество: ");
            middleName = in.nextLine();
            if (middleName.trim().isEmpty()) {
                System.out.println("Ошибка. Отчество не может быть пустым.");
                middleName = "undefined";
            }
        }

        while (birthDate.trim().isEmpty() || birthDate.equals("undefined")) {
            System.out.print("Введите дату рождения: ");
            birthDate = in.nextLine();
            if (birthDate.trim().isEmpty()) {
                System.out.println("Ошибка. Дата рождения не может быть пустой.");
                birthDate = "undefined";
            }
        }
    }

    public void edit() {
        Scanner in = new Scanner(System.in);

        while (true) {
            System.out.print("Введите фамилию: ");
            lastName = in.nextLine().trim();
            if (!lastName.isEmpty()) {
                break;
            }
            System.out.println("Ошибка. Фамилия не может быть пустой.");
        }

        while (true) {
            System.out.print("Введите имя: ");
            firstName = in.nextLine().trim();
            if (!firstName.isEmpty()) {
                break;
            }
            System.out.println("Ошибка. Имя не может быть пустым.");
        }

        while (true) {
            System.out.print("Введите отчество: ");
            middleName = in.nextLine().trim();
            if (!middleName.isEmpty()) {
                break;
            }
            System.out.println("Ошибка. Отчество не может быть пустым.");
        }

        while (true) {
            System.out.print("Введите дату рождения: ");
            birthDate = in.nextLine().trim();
            if (!birthDate.isEmpty()) {
                break;
            }
            System.out.println("Ошибка. Дата рождения не может быть пустой.");
        }
    }

    public void shortDisplay() {
        System.out.println(lastName + " " + firstName.charAt(0) + "." + middleName.charAt(0) + ". (" + personnelNumber + ")");
    }

    public void fullDisplay() {
        System.out.println("Табельный номер: " + personnelNumber);
        System.out.println("ФИО: " + lastName + " " + firstName + " " + middleName);
        System.out.println("Дата рождения: " + birthDate);
        System.out.println("Рейтинг: " + rating);
        if (car != null) {
            System.out.println("Закрепленный автомобиль: " + car.getModel() + " (" + car.getRegistrationNumber() + ")");
        } else {
            System.out.println("Закрепленный автомобиль: нет");
        }
    }
}

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
        this.firstName = "";
        this.lastName = "";
        this.middleName = "";
        this.birthDate = "";
        this.rating = 0.0;
    }

    public void create() {
        Scanner in = new Scanner(System.in);

        while (personnelNumber == null) {
            try {
                System.out.print("Введите табельный номер: ");
                String input = in.nextLine();
                personnelNumber = Long.parseLong(input);
            } catch (NumberFormatException e) {
                System.out.println("Ошибка. Введите числовое значение.");
            }
        }

        while (lastName.trim().isEmpty()) {
            System.out.print("Введите фамилию: ");
            lastName = in.nextLine();
            if (lastName.trim().isEmpty()) {
                System.out.println("Ошибка. Фамилия не может быть пустой.");
            }
        }

        while (firstName.trim().isEmpty()) {
            System.out.print("Введите имя: ");
            firstName = in.nextLine();
            if (firstName.trim().isEmpty()) {
                System.out.println("Ошибка. Имя не может быть пустым.");
            }
        }

        while (middleName.trim().isEmpty()) {
            System.out.print("Введите отчество: ");
            middleName = in.nextLine();
            if (middleName.trim().isEmpty()) {
                System.out.println("Ошибка. Отчество не может быть пустым.");
            }
        }

        while (birthDate.trim().isEmpty()) {
            System.out.print("Введите дату рождения: ");
            birthDate = in.nextLine();
            if (birthDate.trim().isEmpty()) {
                System.out.println("Ошибка. Дата рождения не может быть пустой.");
            }
        }
    }

    public void display() {
        System.out.println(id + ". " + lastName + " " + firstName.charAt(0) + "." + middleName.charAt(0) + ". (" + personnelNumber + ")");
    }
}

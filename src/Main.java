import entity.Car;
import entity.Driver;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Driver> drivers = new ArrayList<Driver>();
        ArrayList<Car> cars = new ArrayList<Car>();

        char choice = 'a';

        while (true) {
            System.out.println();
            System.out.println("Выберите действие: ");
            System.out.println("1. Добавить новый автомобиль");
            System.out.println("2. Добавить нового водителя");
            System.out.println("3. Посмотреть список автомобилей");
            System.out.println("4. Посмотреть список водителей");
            System.out.println("5. Выйти из программы");

            choice = sc.next().charAt(0);
            sc.hasNextLine();

            switch (choice) {
                case '1':
                    printLine();
                    Car car = new Car();
                    car.create();
                    cars.add(car);
                    System.out.println("Автомобиль добавлен.");
                    printLine();
                    break;

                case '2':
                    printLine();
                    Driver driver = new Driver();
                    driver.create();
                    drivers.add(driver);
                    System.out.println("Водитель добавлен.");
                    printLine();
                    break;

                case '3':
                    printLine();
                    if (!cars.isEmpty()) {
                        System.out.println("Список автомобилей:\n");
                        for (Car c : cars) {
                            c.display();
                        }
                    } else {
                        System.out.println("Список автомобилей пуст.");
                    }
                    printLine();
                    break;

                case '4':
                    printLine();
                    if (!drivers.isEmpty()) {
                        System.out.println("Список водителей:\n");
                        for (Driver d : drivers) {
                            d.display();
                        }
                    } else {
                        System.out.println("Список водителей пуст.");
                    }
                    printLine();
                    break;

                case '5':
                    printLine();
                    System.out.println("Работа программы завершена.");
                    printLine();
                    System.exit(0);
                    break;

                default:
                    printLine();
                    System.out.println("Ошибка ввода. Выберите действие 1-5");
                    printLine();
            }
        }
    }

    static void printLine() {
        System.out.println("* * * * * * * * * * * * * * * * * * * *");
    }
}
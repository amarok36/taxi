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
            System.out.println("1) Добавить новый автомобиль");
            System.out.println("2) Добавить нового водителя");
            System.out.println("3) Работа с данными");
            System.out.println("4) Выход из программы");

            choice = sc.next().charAt(0);
            sc.nextLine();

            switch (choice) {
                case '1':
                    printLine();
                    Car car = new Car();
                    car.create();
                    cars.add(car);
                    printLine();
                    System.out.println("Автомобиль добавлен.");
                    printLine();
                    break;

                case '2':
                    printLine();
                    Driver driver = new Driver();
                    driver.create();
                    drivers.add(driver);
                    printLine();
                    System.out.println("Водитель добавлен.");
                    printLine();
                    break;

                case '3':
                    printLine();
                    operateData(drivers, cars);
                    printLine();
                    break;

                case '4':
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

    static void operateData(ArrayList<Driver> drivers, ArrayList<Car> cars) {
        Scanner sc = new Scanner(System.in);
        char choice = 'a';

        while (true) {
            System.out.println("Работа с данными:");
            System.out.println("1) Водители");
            System.out.println("2) Автомобили");
            System.out.println("3) Вернуться в главное меню");
            printLine();

            choice = sc.next().charAt(0);
            sc.nextLine();

            switch (choice) {
                case '1':
                    getDrivers(cars, drivers);
                    break;

                case '2':
                    getCars(cars);
                    break;

                case '3':
                    return;

                default:
                    printLine();
                    System.out.println("Ошибка ввода. Выберите действие 1-3");
                    printLine();
            }
        }
    }

    static void getDrivers(ArrayList<Car> cars, ArrayList<Driver> drivers) {
        while (true) {
            printLine();

            if (!drivers.isEmpty()) {
                System.out.println("Список водителей:\n");
                for (int i = 0; i < drivers.size(); i++) {
                    System.out.print((i + 1) + ". ");
                    drivers.get(i).shortDisplay();
                }

                System.out.println("Выберите водителя по порядковому номеру (0 - вернуться назад):");
                Scanner sc = new Scanner(System.in);
                char choice = sc.next().charAt(0);
                sc.nextLine();

                if (choice == '0') return;

                int num = Character.getNumericValue(choice);
                if (num < 1 || num > drivers.size()) {
                    printLine();
                    System.out.println("Неверный порядковый номер.");
                    continue;
                }

                Driver selectedDriver = drivers.get(num - 1);
                detailDrivers(cars, drivers, selectedDriver);
                break;

            } else {
                System.out.println("Список водителей пуст.");
                printLine();
                return;
            }
        }

        printLine();
    }

    static void detailDrivers(ArrayList<Car> cars, ArrayList<Driver> drivers, Driver driver) {

        Scanner sc = new Scanner(System.in);
        char choice = 'a';

        while (true) {
            printLine();
            System.out.println("Выберите действие: ");
            System.out.println("1) Просмотр");
            System.out.println("2) Редактировать");
            System.out.println("3) Удалить");
            System.out.println("4) Закрепить за автомобилем");
            System.out.println("5) Вернуться к списку");
            printLine();

            choice = sc.next().charAt(0);
            sc.nextLine();

            switch (choice) {
                case '1':
                    printLine();
                    if (drivers.contains(driver)) {
                        driver.fullDisplay();
                    } else
                        System.out.println("Водитель не существует.");
                    break;
                case '2':
                    printLine();
                    if (drivers.contains(driver)) {
                        driver.edit();
                        printLine();
                        System.out.println("Водитель обновлён.");
                    } else
                        System.out.println("Водитель не существует.");
                    break;

                case '3':
                    printLine();
                    if (drivers.contains(driver)) {
                        drivers.remove(driver);
                        printLine();
                        System.out.println("Водитель удалён.");
                    } else
                        System.out.println("Водитель не существует.");
                    break;

                case '4':
                    printLine();
                    if (drivers.contains(driver)) {
                        assignCar(cars, driver);
                        printLine();
                        System.out.println("Автомобиль закреплён.");
                    } else
                        System.out.println("Водитель не существует.");
                    break;

                case '5':
                    return;

                default:
                    printLine();
                    System.out.println("Ошибка ввода. Выберите действие 1-5");
                    printLine();
            }
        }
    }

    static void assignCar(ArrayList<Car> cars, Driver driver) {
        int num;

        if (!cars.isEmpty()) {
            System.out.println("Доступные автомобили:");
            for (int i = 0; i < cars.size(); i++) {
                System.out.print((i + 1) + ". ");
                cars.get(i).display();
            }

            System.out.println("Выберите автомобиль для закрепления (0 - не закреплять):");
            Scanner sc = new Scanner(System.in);
            char choice = 'a';
            choice = sc.next().charAt(0);
            sc.nextLine();

            if (choice == '0') return;

            num = Character.getNumericValue(choice);

            if (choice != '0') {
                driver.setCar(cars.get(num - 1));
            }
        } else {
            System.out.println("Нет доступных автомобилей для закрепления.");
        }
    }

    static void getCars(ArrayList<Car> cars) {
        while (true) {
            printLine();
            if (!cars.isEmpty()) {
                System.out.println("Список автомобилей:\n");
                for (int i = 0; i < cars.size(); i++) {
                    System.out.print((i + 1) + ". ");
                    cars.get(i).display();
                }

                System.out.println("Выберите автомобиль по порядковому номеру (0 - вернуться назад):");
                Scanner sc = new Scanner(System.in);
                char choice = 'a';
                choice = sc.next().charAt(0);
                sc.nextLine();

                if (choice == '0') return;

                int num = Character.getNumericValue(choice);
                if (num < 1 || num > cars.size()) {
                    printLine();
                    System.out.println("Неверный порядковый номер.");
                    continue;
                }

                Car selectedCar = cars.get(num - 1);
                detailCars(cars, selectedCar);
                break;

            } else {
                System.out.println("Список автомобилей пуст.");
                printLine();
                return;
            }
        }

        printLine();
    }

    static void detailCars(ArrayList<Car> cars, Car car) {
        Scanner sc = new Scanner(System.in);
        char choice = 'a';

        while (true) {
            printLine();
            System.out.println("Выберите действие: ");
            System.out.println("1) Просмотр");
            System.out.println("2) Редактировать");
            System.out.println("3) Удалить");
            System.out.println("4) Вернуться к списку");
            printLine();

            choice = sc.next().charAt(0);
            sc.nextLine();

            switch (choice) {
                case '1':
                    printLine();
                    if (cars.contains(car)) {
                        car.display();
                    } else
                        System.out.println("Автомобиль не существует.");
                    break;

                case '2':
                    printLine();
                    if (cars.contains(car)) {
                        car.edit();
                        printLine();
                        System.out.println("Автомобиль обновлён.");
                    } else
                        System.out.println("Автомобиль не существует.");
                    break;

                case '3':
                    printLine();
                    if (cars.contains(car)) {
                        cars.remove(car);
                        printLine();
                        System.out.println("Автомобиль удалён.");
                    } else
                        System.out.println("Автомобиль не существует.");
                    break;

                case '4':
                    return;

                default:
                    printLine();
                    System.out.println("Ошибка ввода. Выберите действие 1-4");
                    printLine();
            }
        }
    }

    static void printLine() {
        for (int i = 0; i < 25; i++) {
            System.out.print("* ");
        }
        System.out.println();
    }
}
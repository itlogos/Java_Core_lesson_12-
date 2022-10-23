package ua.lviv.lgs12;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    private String text;
    private static int length;

    public static void main(String[] args) throws WrongInputConsoleParametersException {

        while (true) {
            String text = "\nEnter values:\n 1-For all objects of this array, visit the same object of class Auto. "
                    + "\n 2-For Using the Enum homework," + "\n 3-For Using the ArrayList homework #3, \n";
            int choice = readText(text);
            switch (choice) {

            case 1:
                /*
                 * 1. Використовуючи Домашнє завдання до попереднього уроку (де ми створювали
                 * машину), замінити всі контейнери на ArrayList, та переписати програму таким
                 * чином щоб вона успішно з ним працювала.
                 */

                doFirstTask();
                break;
            case 2:
                /*
                 * 2.Використовуючи домашнє завдання по Enum, замінити всі контейнери на
                 * ArrayList, та переписати програму таким чином щоб вона успішно з ним
                 * працювала.
                 */

                outputMonthsAndSeasons();
                
                break;
            case 3:
                /*
                 * 3. Вивчивши будову ArrayList , створіть свій власний ArrayList , який буде
                 * динамічно розширятись і мати лише два методи.
                 */

                doThirdTask();
            }
        }

    }

    public static void doFirstTask() {
        List<Car> carList = new ArrayList<>();

        for (int i = 0; i < getRandomValue(5, 10); i++) {
            carList.add(new Car(getRandomValue(75, 115), getRandomValue(2000, 2022), getRandomValue(2, 8),
                    getRandomValue(200, 400), getRandomValue(1, 2)));
        }
        System.out.println("Size ArrayList = " + carList.size());

        for (Object o : carList) {
            System.out.println(o);
        }

    }

    public static void outputMonthsAndSeasons() throws WrongInputConsoleParametersException {
        /* reading the name of the month */

        // Перевірити чи є такий місяць (місяць вводимо з консолі, передбачити, щоб
        // регістр букв був не важливим)
        Month[] mas = Month.values();
        System.out.println("Enter month: ");
        Scanner sc = new Scanner(System.in);
        String month = sc.next().toUpperCase();
        Main exc = new Main();
        exc.isMonthPresent(month);

        /* outputs all months with the same season */

        // Вивести всі місяці з такою ж порою року.

        boolean flag = false;
        Collection<Month> monthCollection = new ArrayList<>();
        Month month2 = Month.valueOf(month);
        for (Month m : Month.values()) {
            if (m.getSeason().name().equals(month2.getSeason().toString())) {
                flag = true;
            }
        }
        System.out.println("\nMonths with the same season: ");
        if (flag) {
            monthCollection.clear();
            for (Month mon : Month.values()) {
                if (mon.getSeason().toString().equalsIgnoreCase(month2.getSeason().toString())) {
                    monthCollection.add(mon);

                }
            }

            for (Month mon : monthCollection) {
                System.out.println(mon + " in " + mon.getSeason().toString());

            }

        }

        if (!flag) {
            System.out.println("Month doesnt exit");
        }

        /* display all months that have the same number of days */

        // Вивести всі місяці які мають таку саму кількість днів.

        flag = false;

        for (Month m : Month.values()) {
            if (m.getDays() == month2.getDays()) {
                flag = true;
            }
        }
        System.out.println("\nMonths with the same number of days: ");
        if (flag) {
            monthCollection.clear();
            for (Month mon : Month.values()) {
                if (mon.getDays() == month2.getDays()) {
                    monthCollection.add(mon);
                }
            }
            for (Month mon : monthCollection) {
                System.out.println(mon + " - " + mon.getDays());
            }

        }

        if (!flag) {
            System.out.println("Month doesnt have same number of days");
        }

        /* display all months with a smaller number of days */

        // Вивести на екран всі місяці які мають меншу кількість днів.

        flag = false;
        for (Month m : Month.values()) {
            if (m.getDays() < month2.getDays()) {
                flag = true;
            }
        }
        System.out.println("\nMonths with a smaller number of days: ");
        if (flag) {
            monthCollection.clear();
            for (Month mon : Month.values()) {
                if (mon.getDays() < month2.getDays()) {
                    monthCollection.add(mon);
                }
            }
            for (Month mon : monthCollection) {
                System.out.println(mon + " - " + mon.getDays());
            }
        }

        if (!flag) {
            System.out.println("Month doesnt have smaller number of days");
        }

        /* display all months with a larger number of days */

        // Вивести на екран всі місяці які мають більшу кількість днів.

        flag = false;
        for (Month m : Month.values()) {

            if (m.getDays() > month2.getDays()) {
                flag = true;
            }
        }
        System.out.println("\nMonths with a larger number of days: ");
        if (flag) {
            monthCollection.clear();
            for (Month mon : Month.values()) {
                if (mon.getDays() > month2.getDays()) {
                    monthCollection.add(mon);
                }
            }

            for (Month mon : monthCollection) {
                System.out.println(mon + " - " + mon.getDays());
            }
        }

        if (!flag) {
            System.out.println("Month doesnt have larger number of days");
        }

        /* display the next season */

        // Вивести на екран наступну пору року.

        Season[] mass = Season.values();
        flag = true;
        int ordinalSeason = month2.getSeason().ordinal();

        System.out.println("\nNext season: ");
        if (flag) {
            if (ordinalSeason == (mass.length - 1)) {
                ordinalSeason = 0;
                System.out.println(mass[ordinalSeason]);
            } else {
                System.out.println(mass[ordinalSeason + 1]);
            }
        }

        /* display the previous season */

        // Вивести на екран попередню пору року.

        System.out.println("\nPrevious season: ");
        if (flag) {
            if (ordinalSeason == 0) {
                ordinalSeason = (mass.length - 1);
                System.out.println(mass[ordinalSeason]);
            } else {
                System.out.println(mass[ordinalSeason - 1]);
            }
        }

        /* display all months with an even number of days */

        // Вивести на екран всі місяці які мають парну кількість днів.

        flag = false;

        for (Month m : Month.values()) {
            if ((m.getDays()) % 2 == 0) {
                flag = true;
            }
        }
        System.out.println("\nMonths with even number of days: ");

        if (flag) {
            monthCollection.clear();
            for (Month mon : Month.values()) {
                if ((mon.getDays()) % 2 == 0) {
                    monthCollection.add(mon);
                }
            }
            for (Month mon : monthCollection) {
                System.out.println(mon + " - " + mon.getDays());
            }
        }

        if (!flag) {
            System.out.println("Month doesnt have even number of days");
        }

        /* display all months with an odd number of days */

        // Вивести на екран всі місяці які мають непарну кількість днів.

        flag = false;

        for (Month m : Month.values()) {
            if ((m.getDays()) % 2 != 0) {
                flag = true;
            }
        }
        System.out.println("\nMonths with odd number of days: ");
        if (flag) {
            monthCollection.clear();
            for (Month mon : Month.values()) {
                if ((mon.getDays()) % 2 != 0) {
                    monthCollection.add(mon);
                }
            }
            for (Month mon : monthCollection) {
                System.out.println(mon + " - " + mon.getDays());
            }
        }

        if (!flag) {
            System.out.println("Month doesnt have odd number of days");
        }

        /*
         * display whether the month entered from the console has an even number of days
         */

        // Вивести на екран чи введений з консолі місяць має парну кількість днів.

        System.out.println("\nDoes the month entered from the console have even number of days: ");

        if (month2.getDays() % 2 == 0) {
            System.out.println(month2 + " has even number of days - " + month2.getDays());
        } else if (month2.getDays() % 2 != 0) {
            System.out.println(month2 + " does not have even number of days - " + month2.getDays());
        }

    }

    public static void doThirdTask() {
        ArrayList<String> thirdList = new ArrayList<String>();
        thirdList.add("AB");
        thirdList.add("CD");
        thirdList.add("EF");
        thirdList.add("GH");
        thirdList.add("IJ");
        thirdList.add("KL");
        System.out.println("ArrayList before:");
        for (String var : thirdList) {
            System.out.println(var);
        }
        // add to the end of the list
        thirdList.add("MN");
        // add to the end of the list
        thirdList.add("MN");
        // Removing 1st element
        thirdList.remove(0);
        // Removing 3rd element from the remaining list
        thirdList.remove(2);
        // Removing 4th element from the remaining list
        thirdList.remove(2);
        System.out.println("ArrayList after add and remove:");
        for (String var2 : thirdList) {
            System.out.println(var2);
        }
    }

    public static int readText(String text) {
        Scanner scan = new Scanner(System.in);
        System.out.print(text);
        int input = scan.nextInt();
        return input;
    }

    public static int getRandomValue(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("min value must be smaller than max value");
        }

        Random r = new Random();
        return r.nextInt(max - min + 1) + min;
    }

    // Викидайте даний exception, коли користувач введе неправильні дані.
    public void isMonthPresent(String month) throws WrongInputConsoleParametersException {

        /* docs for boolean */
        boolean flag = false;

        /* Checking for the existence of a month */
        for (Month m : Month.values()) {
            if (m.name().equals(month)) {
                System.out.println("Month exist");
                flag = true;
            }
        }

        /* Throw new WrongInputConsoleParametersException */

        // Перевіряе чи є такий місяць, та викидає exception, коли користувач введе
        // неправильні дані.

        if (!flag) {
            System.out.println(month);
            String message = "Invalid value. Please enter a valid month name.";
            throw new WrongInputConsoleParametersException(message);
        }

    }

}
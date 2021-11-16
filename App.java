package cinema;
import java.util.Scanner;

public class App {
    private static final Scanner sc = new Scanner(System.in);
    private static CinemaHall hall;

    public static void runApp() {
        System.out.println("Enter the number of rows:");
        int rows = sc.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int seats = sc.nextInt();
        hall = new CinemaHall(rows, seats);
        printMenu();
    }

    private static void printMenu() {
        System.out.println("\n1. Show the seats\n2. Buy a ticket\n3. Statistics\n0. Exit");
        switch (sc.nextInt()) {
            case 1:
                hall.printSeats();
                printMenu();
                break;
            case 2:
                buyTicket();
                printMenu();
                break;
            case 3:
                showStatistics();
                printMenu();
                break;
            case 0:
                break;
        }
    }

    private static void buyTicket() {
        System.out.println("\nEnter a row number:");
        int row = sc.nextInt();
        System.out.println("Enter a seat number in that row:");
        int seat = sc.nextInt();

        try {
            if (hall.getSeat(row, seat).isAvailable()) {
                hall.setSeatBooked(row, seat);
                hall.printPrice(row, seat);
            } else {
                System.out.println("That ticket has already been purchased!");
                buyTicket();
            }
        } catch (Exception e) {
            System.out.println("Wrong input!");
            buyTicket();
        }
    }

    private static void showStatistics() {
        System.out.printf("\nNumber of purchased tickets: %d\n" +
                "Percentage: %.2f%%\n" +
                "Current income: $%d\n" +
                "Total income: $%d\n", hall.getTicketsCount(), hall.getPercentage(),
                hall.getCurrentIncome(), hall.getTotalIncome());
    }
}

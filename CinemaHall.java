package cinema;

public class CinemaHall {
    private static final int FRONT_HALF_PRICE = 10;
    private static final int BACK_HALF_PRICE = 8;
    private final Seat[][] cinemaHall;
    private static int ticketsCount = 0;
    private static int totalIncome;
    private static int income = 0;
    private static int totalSeats;

    CinemaHall(int rows, int seats) {
        totalSeats = rows * seats;
        this.cinemaHall = new Seat[rows + 1][seats + 1];
        for (int i = 0; i < cinemaHall.length; i++) {
            for (int j = 0; j < cinemaHall[i].length; j++) {
                cinemaHall[i][j] = rows * seats <= 60 ? new Seat(FRONT_HALF_PRICE)
                        : i <= rows / 2 ? new Seat(FRONT_HALF_PRICE)
                        : new Seat(BACK_HALF_PRICE);
                totalIncome += i > 0 && j > 0 ? cinemaHall[i][j].getPrice() : 0;
            }
        }
    }

    public Seat getSeat(int row, int seat) { return cinemaHall[row][seat]; }

    public int getTicketsCount() { return ticketsCount; }

    public double getPercentage() { return (double) ticketsCount / totalSeats * 100.0; }

    public int getCurrentIncome() { return income; }

    public int getTotalIncome() { return totalIncome; }

    public void printSeats() {
        System.out.println("\nCinema:");
        for (int i = 0; i < cinemaHall.length; i++) {
            for (int j = 0; j < cinemaHall[i].length; j++) {
                if (i == 0 && j == 0) {
                    System.out.print("  ");
                } else {
                    System.out.print(j == 0 ? i + " "
                            : i == 0 ? j + " "
                            : cinemaHall[i][j].getSeatStatus());
                }
            }
            System.out.println();
        }
    }

    public void setSeatBooked(int row, int seat) {
        ticketsCount++;
        income += cinemaHall[row][seat].getPrice();
        cinemaHall[row][seat].setBooked();
    }

    public void printPrice(int row, int seat) {
        System.out.println("Ticket price: $" + cinemaHall[row][seat].getPrice());
    }
}

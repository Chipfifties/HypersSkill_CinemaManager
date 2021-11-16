package cinema;

public class Seat {
    private boolean isAvailable;
    private final int price;

    Seat(int price) {
        this.isAvailable = true;
        this.price = price;
    }

    public boolean isAvailable() { return isAvailable; }

    public void setBooked() {
        isAvailable = false;
    }

    public int getPrice() {
        return price;
    }

    public String getSeatStatus() {
        return isAvailable ? "S " : "B ";
    }
}

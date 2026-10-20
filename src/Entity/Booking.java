package Entity;

public class Booking {
    private int booking_id;
    private int user_id;
    private int show_id;
    private boolean seats_booked;
    private double total_price;

    public Booking(int booking_id, int user_id, int show_id, boolean seats_booked, double total_price) {
        this.booking_id = booking_id;
        this.user_id = user_id;
        this.show_id = show_id;
        this.seats_booked = seats_booked;
        this.total_price = total_price;
    }

    public int getBooking_id() {
        return booking_id;
    }

    public void setBooking_id(int booking_id) {
        this.booking_id = booking_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getShow_id() {
        return show_id;
    }

    public void setShow_id(int show_id) {
        this.show_id = show_id;
    }

    public boolean isSeats_booked() {
        return seats_booked;
    }

    public void setSeats_booked(boolean seats_booked) {
        this.seats_booked = seats_booked;
    }

    public double getTotal_price() {
        return total_price;
    }

    public void setTotal_price(double total_price) {
        this.total_price = total_price;
    }
}

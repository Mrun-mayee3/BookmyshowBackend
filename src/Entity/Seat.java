package Entity;

public class Seat {
    private int seat_id;
    private int show_id;
    private String seat_number;
    boolean is_booked;

    public int getSeat_id() {
        return seat_id;
    }

    public void setSeat_id(int seat_id) {
        this.seat_id = seat_id;
    }

    public int getShow_id() {
        return show_id;
    }

    public void setShow_id(int show_id) {
        this.show_id = show_id;
    }

    public String getSeat_number() {
        return seat_number;
    }

    public void setSeat_number(String seat_number) {
        this.seat_number = seat_number;
    }

    public boolean isIs_booked() {
        return is_booked;
    }

    public void setIs_booked(boolean is_booked) {
        this.is_booked = is_booked;
    }

    public Seat(int seat_id, int show_id, String seat_number, boolean is_booked) {
        this.seat_id = seat_id;
        this.show_id = show_id;
        this.seat_number = seat_number;
        this.is_booked = is_booked;
    }
}

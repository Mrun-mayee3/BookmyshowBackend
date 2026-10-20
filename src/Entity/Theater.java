package Entity;

public class Theater {
    private int theaterID;
    private String name;
    private String city;

    public Theater(int theaterID, String name, String city) {
        this.theaterID = theaterID;
        this.name = name;
        this.city = city;
    }

    public int getTheaterID() {
        return theaterID;
    }

    public void setTheaterID(int theaterID) {
        this.theaterID = theaterID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}

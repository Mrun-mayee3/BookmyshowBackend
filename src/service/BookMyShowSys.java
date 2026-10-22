package service;

import config.DataBaseConfig;

import java.sql.*;
import java.util.List;
import java.util.Scanner;

public class BookMyShowSys {
    Scanner sc = new Scanner(System.in);

    // display movies
    public void displayMovies(){
        try{
            Connection con = DataBaseConfig.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM movies");
            System.out.println("____________Available Movies___________");
            while(rs.next()){
                System.out.println(rs.getInt("movie_id")
                        +". " + rs.getString("title")
                        +" ("+ rs.getString("genre") + ")");
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }

    // display theater in a city
    public void displayTheaters(String city){
        try{
            Connection con = DataBaseConfig.getConnection();
            PreparedStatement
                    st = con.prepareStatement("SELECT * FROM theater WHERE city = ?");
            st.setString(1, city);
            ResultSet rs = st.executeQuery();

            System.out.println("Theaters in "+ city+ ":");
            while(rs.next()){
                System.out.println(rs.getInt("theater_id")
                        + ". "+rs.getString("name"));
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    // display shows
    public void displayShows(int movieId, int TheaterId){
        try {
            Connection con = DataBaseConfig.getConnection();
            PreparedStatement st = con.prepareStatement("SELECT * FROM shows WHERE movie_id = ? AND theater_id = ?");
            st.setInt(1, movieId);
            st.setInt(2, TheaterId);
            ResultSet rs = st.executeQuery();

            System.out.println("Available Shows ------>");
            while(rs.next()){
                System.out.println(rs.getInt("show_id")
                        +". "+rs.getString("timing")
                +" | Seats Available: "+ rs.getString("available_seats"));
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    // book tickets
    public void bookTicket(int user_id, int show_id, List<String> Selected_seats){
        try{
            Connection con = DataBaseConfig.getConnection();
            con.setAutoCommit(false);

            // check if seats are available
            boolean already_booked = false;

            for(String seat : Selected_seats){
                PreparedStatement st= con.prepareStatement("select * from seat where seat_number = ? AND show_id = ?");
                st.setString(1, seat);
                st.setInt(2, show_id);
                ResultSet rs = st.executeQuery();

                if(rs.next() && rs.getBoolean("is_booked")){
                    // it is already true. not setting it
                    already_booked = true;
                    System.out.println("Seat "+seat+" is already booked");
                }
            }
            if(already_booked){
                System.out.println("Booking Failed");
                con.rollback();
                return;
            }
            for(String seat : Selected_seats){

                PreparedStatement st = con.prepareStatement("update seat set is_booked = TRUE where seat_number =? AND show_id = ?");
                st.setString(1, seat);
                st.setInt(2, show_id);
                st.executeUpdate();
            }

            double seatPrice = 250.0;
            double totalPrice = Selected_seats.size() * seatPrice;
            PreparedStatement st = con.prepareStatement("insert into bookings (user_id, show_id, seats_booked, total_price) values (?,?,?,?)");
            st.setInt(1, user_id);
            st.setInt(2, show_id);
            st.setString(3, String.join(",",Selected_seats));
            st.setDouble(4, totalPrice);
            st.executeUpdate();
            con.commit();
            System.out.println("Booking Successful for Seats: " + Selected_seats +" Total Price: "+totalPrice);
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
}

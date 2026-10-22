package service;

import javax.sound.midi.Soundbank;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BookMyShowApp {
    public static void main(String[] args) {
        BookMyShowSys bms = new BookMyShowSys();
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter city: ");
        String city = sc.next();
        bms.displayTheaters(city);

        System.out.println("Enter Theater Id and Movie Id: ");
        int theaterid = sc.nextInt();
        int movieid = sc.nextInt();
        bms.displayShows(movieid,theaterid);

        System.out.println("Enter show Id and Number of seats: ");
        int showid = sc.nextInt();
        List<String> ss= Arrays.asList(sc.nextLine().split(","));
        bms.bookTicket(1, showid, ss);
    }
}

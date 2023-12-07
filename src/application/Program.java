package application;

import model.entities.Reservation;
import model.exceptions.DomainException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;


public class Program {
    public static void main(String[] args) {
            Locale.setDefault(Locale.US);
            Scanner sc = new Scanner(System.in);

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

            try {
                System.out.println("Room number: ");
                int rommNumber = sc.nextInt();

                System.out.println("Check-in date (day/Month/Year): ");
                Date checkIn = simpleDateFormat.parse(sc.next());

                System.out.println("Check-out date (day/Month/Year): ");
                Date checkOut = simpleDateFormat.parse(sc.next());

                Reservation reservation = new Reservation(rommNumber, checkIn, checkOut);
                System.out.println("Reservation: " + reservation);

                System.out.println();
                System.out.println("Enter data to update the reservation: ");
                System.out.println("Check-in date (day/month/year): ");
                checkIn = simpleDateFormat.parse(sc.next());

                System.out.println("Check-out date (day/month/year): ");
                checkOut = simpleDateFormat.parse(sc.next());
                reservation.updateDates(checkIn, checkOut);

                System.out.println("reservation: " + reservation);

            }
            catch (ParseException error) {
                System.out.println("Invalid date format; " + error);
            }
            catch (DomainException error) {
                System.out.println("Error in reservation: " + error.getMessage());
            }
            catch (RuntimeException e) {
                System.out.println("Unexpected error");
            }
            sc.close();
    }

}

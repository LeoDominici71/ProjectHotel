package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Reserva;
import excecao.Exceptions;

public class Application {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		try {
			System.out.print("Room number: ");
			int number = sc.nextInt();
			System.out.print("Check-in date (dd/MM/yyyy): ");
			Date checkin = sdf.parse(sc.next());
			System.out.print("Check-out date (dd/MM/yyyy): ");
			Date checkout = sdf.parse(sc.next());

			System.out.println("Would you like to change or update any detail?");
			System.out.println("Press 'y' for yes or 'n' for no....");
			char ch = sc.next().charAt(0);

			Reserva reservas = new Reserva(number, checkin, checkout);

			if (ch == 'y') {

				System.out.println();
				System.out.println("Enter data to update the reservation: ");
				System.out.println("Check-in date (dd/MM/yyyy) ");
				checkin = sdf.parse(sc.next());
				System.out.println("Check-out date (dd/MM/yyyy) ");
				checkout = sdf.parse(sc.next());

				reservas.updateDates(checkin, checkout);

				System.out.println("Reservation" + reservas.toString());

			} else
				System.out.println("Reservation" + reservas.toString());
			System.out.println("Thanks for choosing Leo's hotel");

		} catch (ParseException e) {
			System.out.println("Invalid date format");

		} catch (Exceptions e) {
			System.out.println("Error in reservation: " + e.getMessage());
		}

		catch (RuntimeException e) {
			System.out.println("Unexpected error");

		}
		sc.close();
	}

}
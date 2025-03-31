package busTicketReservation;

import java.sql.SQLException;
import java.util.Scanner;

public class TicketReservation {
	
public static void main(String[] args) throws SQLException {
		
		BusDAO busdao = new BusDAO();
		try {
			busdao.displayBusInfo();

			int userOpt = 1;
			Scanner scan = new Scanner(System.in);

			while (userOpt == 1) {
				System.out.println("Enter 1 to book and 2 to exit");
				userOpt = scan.nextInt();
				if (userOpt == 1) {
					Booking booking = new Booking();
					if (booking.isAvailable()) {
						BookingDAO bookingdao = new BookingDAO();
						bookingdao.addBooking(booking);
						System.out.println("Your booking is confirmed ");
					} else
						System.out.println("Selected bus is full");
				}
			}
			scan.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

package busTicketReservation;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Booking {
	String passengerName;
	int busNo;
	Date date;
	
	Booking(){
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter your name : ");
		passengerName = scan.next();
		System.out.println("Enter Bus number : ");
		busNo = scan.nextInt();
		System.out.println("Enter travel date dd-mm-yyyy : ");
		String dateInput = scan.next();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		
		try {
			date = dateFormat.parse(dateInput);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	public boolean isAvailable() throws SQLException {
		
		BusDAO busdao = new BusDAO();
		BookingDAO bookingdao = new BookingDAO();
		
		int capacity = busdao.getCapacity(busNo) ;
		
		int booked = bookingdao.getBookedCount(busNo, date);
		
		return booked<capacity;
	}
}

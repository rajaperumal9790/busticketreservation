package busTicketReservation;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BusDAO {
	
	public void displayBusInfo() throws SQLException {
		String query = "Select * from bus";
		Connection con = DBConnection.getConnection();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);
		
		while(rs.next()) {
			System.out.println("Bus Number : " + rs.getInt(1));
			if(rs.getInt(2) == 0)
				System.out.println("AC : Non-AC");
			else
				System.out.println("AC : AC Bus");
			System.out.println("Capacity : " +rs.getInt(2));
		}
		System.out.println("-----------------------------------------------");
	}

	public int getCapacity(int id) throws SQLException {
		String query = "Select capacity from bus where id=" + id;
		Connection con = DBConnection.getConnection();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);
		rs.next();
		return rs.getInt(1);
	}

}

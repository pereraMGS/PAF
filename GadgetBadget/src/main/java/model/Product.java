package model;

import java.beans.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.DBConnection;
import com.sun.jdi.connect.spi.Connection;

public class Product {
	

	public DBConnection ob = new DBConnection();

	Connection con;

	public String insertProduct(String code, String name, String price, String description) {

		String output = "";

		try {

			con = (Connection) ob.Connect();

			if (con == null) {

				return "Error while connecting to the database";
			}

			// create a prepared statement
			String query = " insert into product ('ProductCode', 'ProducName', 'ProductPrice', 'ProductDescription')"+ " values (?, ?, ?, ?)";
			PreparedStatement preparedStmt = ((java.sql.Connection) con).prepareStatement(query);

			// binding values
			preparedStmt.setString(1, code);
			preparedStmt.setString(2, name);
			preparedStmt.setDouble(3, Double.parseDouble(price));
			preparedStmt.setString(4, description);

			// execute the statement
			preparedStmt.execute();
			con.close();
			output = "Inserted successfully";
		} catch (Exception e) {
			output = "Error while inserting";
			System.err.println(e.getMessage());
		}

		return output;
	}

	public String readProduct() {
		String output = "";
		
		try {

			con = (Connection) ob.Connect();

			if (con == null) {

				return "Error while connecting to the database";
			}

			// create a prepared statement
			String query = "select * from product";
			Statement stmt = (Statement) ((java.sql.Connection) con).createStatement();
			ResultSet rs = ((java.sql.Statement) stmt).executeQuery(query);
			
			while (rs.next()) {
				String productCode = rs.getString("productCode");
				String productName = rs.getString("productName");
				String productPrice = Double.toString(rs.getDouble("productPrice"));
				String productDesc = rs.getString("productDesc");
				
				// Add a row into the html table
				output += "<tr><td>" + productCode + "</td>";
				output += "<td>" + productName + "</td>";
				output += "<td>" + productPrice + "</td>";
				output += "<td>" + productDesc + "</td>";
				
				output += "<td><input name='btnUpdate' "
						+ " type='button' value='Update'></td>"
						+ "<td><form method='post' action='items.jsp'>"
						+ "<input name='btnRemove' "
						+ " type='submit' value='Remove'>"
						+ "<input name='itemID' type='hidden' ";		
			}
			
			con.close();
			// Complete the html table
			output += "</table>";
			
			
		} catch (Exception e) {
			output = "Error while inserting";
			System.err.println(e.getMessage());
		}

		return output;
	}
}

package edu.deakin.sit218.SQLinjectionattack.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



public class SQLInjectiontest {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter your question: ");
		String question = scanner.nextLine();
		scanner.close();
		
		String jdbcURL = "jdbc:mysql://localhost/questionanswerschema?user=lecturerdbadmin&password=lecturerdbadmin";

		try {
			System.out.println("Connecting to database");
			Connection conn = DriverManager.getConnection(jdbcURL);
			System.out.println("Connection successful");
			
			Statement statement = conn.createStatement();
			String query = "Select * FROM questions WHERE question = '"+ question +"'";
			System.out.println(query);
			ResultSet result = statement.executeQuery(query);
			
			while(result.next()) {
				int questionID = result.getInt("questionid");
				String answer = result.getString("answer");
				String area = result.getString("area");
				question = result.getString("question");
				
				System.out.println(questionID + ". " + question+ " A: " + answer + " area: " + area);
			}
			
		} catch (SQLException e) {
			System.out.println("SQL exception: " + e.getMessage());
			System.out.println("SQL state: " + e.getSQLState());
			System.out.println("Vendor Error: " + e.getErrorCode());
		}
		
	}
}

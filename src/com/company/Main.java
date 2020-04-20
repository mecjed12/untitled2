package com.company;

import java.sql.*;

public class Main {

    public static void main(String[] args) {
        Connection connection = null;
        String url = "jdbc:mysql://localhost:3306/cc_dev?user=root";


        try {
            connection = DriverManager.getConnection(url);
            System.out.println("Connected to the DB");
            String joinMessage = "Insert into note (id,messange,creationdate) Values (2,'Bye my world','23.07.2020')";
            Statement newStatment = connection.createStatement();
            newStatment.executeUpdate(joinMessage);
            String note = "Select * from note";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(note);

            while (rs.next()) {
                String messange = rs.getString("messange");
                String creationdate = rs.getString("creationdate");
                System.out.println("Messange: " + messange + "\n" + "Date: " + creationdate);

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}

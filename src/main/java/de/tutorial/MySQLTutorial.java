package de.tutorial;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLTutorial {
    // Datenbankverbindungsinformationen
    private static final String URL = "jdbc:mysql://localhost:3306/tutorial_db";
    private static final String USER = "your_username";
    private static final String PASSWORD = "your_password";

    public static void main(String[] args) {
        try {
            // 1. Verbindung zur Datenbank herstellen
            System.out.println("Verbindung zur Datenbank wird hergestellt...");
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Verbindung erfolgreich hergestellt!");

            // 2. Statement erstellen
            Statement statement = connection.createStatement();

            // 3. Tabelle erstellen
            String createTableSQL = "CREATE TABLE IF NOT EXISTS benutzer (" +
                    "id INT AUTO_INCREMENT PRIMARY KEY," +
                    "name VARCHAR(50) NOT NULL," +
                    "email VARCHAR(100) NOT NULL)";
            statement.execute(createTableSQL);
            System.out.println("Tabelle 'benutzer' wurde erstellt!");

            // 4. Daten einfügen
            String insertSQL = "INSERT INTO benutzer (name, email) VALUES " +
                    "('Max Mustermann', 'max@example.com')," +
                    "('Anna Schmidt', 'anna@example.com')";
            statement.execute(insertSQL);
            System.out.println("Daten wurden eingefügt!");

            // 5. Daten abfragen
            System.out.println("\nAlle Benutzer:");
            ResultSet resultSet = statement.executeQuery("SELECT * FROM benutzer");
            while (resultSet.next()) {
                System.out.printf("ID: %d, Name: %s, Email: %s%n",
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("email"));
            }

            // 6. Ressourcen freigeben
            resultSet.close();
            statement.close();
            connection.close();
            System.out.println("\nVerbindung wurde geschlossen!");

        } catch (SQLException e) {
            System.err.println("Fehler bei der Datenbankoperation:");
            e.printStackTrace();
        }
    }
} 
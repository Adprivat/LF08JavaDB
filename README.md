# MySQL Tutorial in Java

Hey! Willkommen zu diesem einfachen MySQL-Tutorial in Java. Hier lernst du, wie du eine Java-Anwendung mit einer MySQL-Datenbank verbindest und grundlegende Datenbankoperationen durchführst.

## Was lernst du hier?

In diesem Tutorial wirst du:
- Eine Java-Anwendung mit MySQL verbinden
- Eine Tabelle erstellen
- Daten einfügen
- Daten abfragen
- Die Verbindung ordnungsgemäß schließen

## Voraussetzungen

Bevor du startest, brauchst du:
- Java JDK 11 oder höher
- Maven (Build-Tool)
- MySQL Server (lokal installiert)

## Installation

### 1. Java installieren
- Lade das JDK von [Oracle](https://www.oracle.com/java/technologies/downloads/) herunter
- Installiere es und setze die JAVA_HOME Umgebungsvariable

### 2. Maven installieren
1. Lade Maven von [Apache Maven](https://maven.apache.org/download.cgi) herunter (apache-maven-3.9.6-bin.zip)
2. Erstelle einen Ordner, z.B. `C:\Program Files\Apache\maven`
3. Entpacke die ZIP-Datei in diesen Ordner
4. Füge Maven zu deiner PATH-Umgebungsvariable hinzu:
   - Öffne die Windows-Systemsteuerung
   - Gehe zu "System und Sicherheit" → "System"
   - Klicke auf "Erweiterte Systemeinstellungen"
   - Klicke auf "Umgebungsvariablen"
   - Unter "Systemvariablen" findest du "Path"
   - Klicke auf "Bearbeiten"
   - Füge den Pfad `C:\Program Files\Apache\maven\bin` hinzu
5. Überprüfe die Installation mit `mvn -version`

### 3. MySQL einrichten
1. Installiere MySQL Server von [MySQL](https://dev.mysql.com/downloads/mysql/)
2. Erstelle eine neue Datenbank:
   ```sql
   CREATE DATABASE tutorial_db;
   ```

## Projekt einrichten

1. Klone dieses Repository oder lade die Dateien herunter
2. Öffne die Datei `src/main/java/de/tutorial/MySQLTutorial.java`
3. Passe die Verbindungsinformationen an:
   ```java
   private static final String URL = "jdbc:mysql://localhost:3306/tutorial_db";
   private static final String USER = "dein_username";
   private static final String PASSWORD = "dein_passwort";
   ```

## Code-Erklärung

Der Code ist in mehrere wichtige Teile gegliedert:

### 1. Verbindung herstellen
```java
Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
```
Hier wird die Verbindung zur MySQL-Datenbank hergestellt. Die URL enthält den Datenbanknamen, USER und PASSWORD deine Anmeldedaten.

### 2. Statement erstellen
```java
Statement statement = connection.createStatement();
```
Ein Statement-Objekt wird erstellt, um SQL-Befehle auszuführen.

### 3. Tabelle erstellen
```java
String createTableSQL = "CREATE TABLE IF NOT EXISTS benutzer (" +
        "id INT AUTO_INCREMENT PRIMARY KEY," +
        "name VARCHAR(50) NOT NULL," +
        "email VARCHAR(100) NOT NULL)";
```
Erstellt eine Tabelle mit drei Spalten: id (automatisch erhöhend), name und email.

### 4. Daten einfügen
```java
String insertSQL = "INSERT INTO benutzer (name, email) VALUES " +
        "('Max Mustermann', 'max@example.com')," +
        "('Anna Schmidt', 'anna@example.com')";
```
Fügt Beispieldaten in die Tabelle ein.

### 5. Daten abfragen
```java
ResultSet resultSet = statement.executeQuery("SELECT * FROM benutzer");
while (resultSet.next()) {
    System.out.printf("ID: %d, Name: %s, Email: %s%n",
            resultSet.getInt("id"),
            resultSet.getString("name"),
            resultSet.getString("email"));
}
```
Führt eine SQL-Abfrage aus und gibt die Ergebnisse formatiert aus.

### 6. Ressourcen freigeben
```java
resultSet.close();
statement.close();
connection.close();
```
Schließt alle Ressourcen ordnungsgemäß.

## Projekt ausführen

1. Öffne eine Kommandozeile im Projektverzeichnis
2. Führe `mvn clean compile` aus, um das Projekt zu kompilieren
3. Führe `mvn exec:java` aus, um das Programm zu starten

## Fehlerbehebung

Falls du Fehler beim Verbinden zur Datenbank erhältst, überprüfe:
1. Ob MySQL läuft
2. Ob die Datenbank existiert
3. Ob deine Anmeldedaten korrekt sind
4. Ob Maven korrekt installiert ist (`mvn -version`)

## Nächste Schritte

Möchtest du mehr lernen? Hier sind einige Vorschläge:
- Füge weitere Tabellen hinzu
- Implementiere CRUD-Operationen (Create, Read, Update, Delete)
- Lerne PreparedStatements kennen
- Erstelle eine Benutzeroberfläche 
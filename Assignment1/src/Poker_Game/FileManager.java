/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Poker_Game;

/**
 *
 * @author user
 *
 * import java.io.*; import java.util.List;
 *
 * public class FileManager { public static void saveGameState(GameState
 * gameState, String filePath) { try (ObjectOutputStream oos = new
 * ObjectOutputStream(new FileOutputStream(filePath))) {
 * oos.writeObject(gameState); } catch (IOException e) { e.printStackTrace(); }
 * }
 *
 * public static GameState loadGameState(String filePath) { try
 * (ObjectInputStream ois = new ObjectInputStream(new
 * FileInputStream(filePath))) { return (GameState) ois.readObject(); } catch
 * (IOException | ClassNotFoundException e) { e.printStackTrace(); return null;
 * } } }
 */
import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class FileManager {

    public static void saveGame(PokerGame game, String userName) {
    Connection conn = null;
    Statement statement = null;
    ResultSet rs = null;
    try {
        conn = DBManager.getConnection();
        statement = conn.createStatement();

        // Check if user exists
        String checkUserQuery = "SELECT ID FROM \"USER\" WHERE USERNAME = '" + userName + "'";
        rs = statement.executeQuery(checkUserQuery);
        int userId = 0;

        if (rs.next()) {
            // User exists, update their chips
            userId = rs.getInt("ID");
            String updateUserQuery = "UPDATE \"USER\" SET CHIPS = " + game.getGameState().getPlayers().get(0).getChips() + " WHERE ID = " + userId;
            statement.executeUpdate(updateUserQuery);
        } else {
            // User does not exist, insert new user
            String insertUserQuery = "INSERT INTO \"USER\" (USERNAME, CHIPS) VALUES ('" + userName + "', " + game.getGameState().getPlayers().get(0).getChips() + ")";
            statement.executeUpdate(insertUserQuery, Statement.RETURN_GENERATED_KEYS);
            rs = statement.getGeneratedKeys();
            if (rs.next()) {
                userId = rs.getInt(1);
            }
        }

        // Assume similar logic for inserting game state information
        for (Player player : game.getGameState().getPlayers()) {
            if (player != game.getGameState().getPlayers().get(0)) { // Skip the user player to avoid duplicate handling
                String gameInsertQuery = "INSERT INTO \"GAME\" (USER_ID, USER_CHIPS, COMPUTER_PLAYER_NAME, COMPUTER_CHIPS) VALUES (" +
                                         userId + ", " + game.getGameState().getPlayers().get(0).getChips() + ", '" +
                                         player.getName().replace(" ", "_") + "', " + player.getChips() + ")";
                statement.executeUpdate(gameInsertQuery);
            }
        }

        System.out.println("Game and player states saved successfully.");
    } catch (SQLException e) {
        System.err.println("Error saving game and player states: " + e.getMessage());
    } finally {
        // Clean up resources
        try {
            if (rs != null) rs.close();
            if (statement != null) statement.close();
            if (conn != null) conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}

 // This method will load the game state from the database for a given user.
    public static PokerGame loadGame(String userName) {
        GameState gameState = null;
        PokerGame game = new PokerGame();
        List<Player> players = new ArrayList<>();
        List<Card> communityCards = new ArrayList<>();
        int pot = 0, currentBet = 0;

        // Adjusted query to join USER and GAME tables to fetch all relevant game details including username
    String query = "SELECT g.USER_CHIPS, g.COMPUTER_PLAYER_NAME, g.COMPUTER_CHIPS, g.GAME_INFO, u.USERNAME " +
                   "FROM POKER.GAME g " +
                   "JOIN POKER.\"USER\" u ON g.USER_ID = u.ID " +
                   "WHERE u.USERNAME = '" + userName + "'";

        try (Connection conn = DBManager.getConnection(); 
             Statement statement = conn.createStatement();
             ResultSet rs = statement.executeQuery(query)) {

             // Read all results and build player list
        boolean userAdded = false;
        while (rs.next()) {
            if (!userAdded) {
                players.add(new Player(rs.getString("USERNAME"), rs.getInt("USER_CHIPS"))); // Add user first
                userAdded = true;
            }
            players.add(new Player(rs.getString("COMPUTER_PLAYER_NAME"), rs.getInt("COMPUTER_CHIPS"))); // Add computer players
        }

        // Ensure there are exactly four players, adding default ones if necessary
        while (players.size() < 4) {
            players.add(new Player("Computer " + players.size(), 1000)); // Default computer player
        }

            gameState = new GameState(players, communityCards, pot, currentBet);
            game.setGameState(gameState);
            System.out.println("Game loaded successfully from the database.");
            return game;
    
        } catch (SQLException e) {
            System.err.println("Error loading game from database: " + e.getMessage());
        }
        return null;
    }
                
    // This method retrieves a list of saved users (by username) from the USER table.
    public static List<String> getSavedGameFiles() {
        List<String> savedGames = new ArrayList<>();
        String query = "SELECT \"USERNAME\" FROM \"POKER\".\"USER\"";

        try (Connection conn = DBManager.getConnection(); 
             Statement statement = conn.createStatement(); 
             ResultSet rs = statement.executeQuery(query)) {

            while (rs.next()) {
                savedGames.add(rs.getString("USERNAME"));
            }

            if (savedGames.isEmpty()) {
                System.out.println("There are no saved games.");
            }
        } catch (SQLException e) {
            System.err.println("Error retrieving saved games: " + e.getMessage());
        }

        return savedGames;
    }
    
     // This method creates a new user save file in the database.
    public static boolean createNewSaveFile(String userName) {
        String query = "INSERT INTO \"POKER\".\"USER\" (\"USERNAME\", \"CHIPS\", \"NUMBER_OF_WINS\") VALUES ('" + userName + "', 1000, 0)";

        try (Connection conn = DBManager.getConnection(); 
             Statement statement = conn.createStatement()) {

            statement.executeUpdate(query);
            System.out.println("New save file created for user: " + userName);
            return true;

        } catch (SQLException e) {
            System.err.println("Error creating new save file: " + e.getMessage());
            return false;
        }
    }
    
    /// This method inserts a log entry into the GameLog table.
    public static void appendToGameLog(String userName, String logEntry) {
        String query = "INSERT INTO GAMELOG (USER_ID, COMPUTER_PLAYER_NAME) VALUES " +
                "((SELECT ID FROM USER WHERE USERNAME = '" + userName + "'), '" + logEntry + "')";

        try (Connection conn = DBManager.getConnection(); 
             Statement statement = conn.createStatement()) {

            statement.executeUpdate(query);
            System.out.println("Log entry added for user: " + userName);

        } catch (SQLException e) {
            System.err.println("Error appending to game log: " + e.getMessage());
        }
    }

   // Reads all log entries from the GAMELOG table in the database for a specific user.
public static List<String> readGameLog(String userName) {
    List<String> logEntries = new ArrayList<>();
    String query = "SELECT COMPUTER_PLAYER_NAME FROM GAMELOG WHERE USER_ID = (SELECT ID FROM USER WHERE USERNAME = '" + userName + "')";

    try (Connection conn = DBManager.getConnection(); 
         Statement statement = conn.createStatement();
         ResultSet rs = statement.executeQuery(query)) {

        while (rs.next()) {
            logEntries.add(rs.getString("COMPUTER_PLAYER_NAME")); // Assuming the log entries are stored in the COMPUTER_PLAYER_NAME column
        }

        if (logEntries.isEmpty()) {
            System.out.println("There are no log entries for user: " + userName);
        } else {
            System.out.println("Log entries read from the database for user: " + userName);
        }
        
    } catch (SQLException e) {
        System.err.println("Error reading log entries from the database: " + e.getMessage());
    }

    return logEntries;
}

}

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
 * } }
}
 */
import java.io.*;
import java.util.*;

public class FileManager {

   private static final String SAVE_DIRECTORY = "saved_games/";

    static {
        // Ensure the save directory exists
        new File(SAVE_DIRECTORY).mkdirs();
    }
    
      public static void saveGameState(GameState gameState, String fileName) {
        String filePath = SAVE_DIRECTORY + fileName + ".txt";
        try ( PrintWriter writer = new PrintWriter(new FileWriter(filePath))) {
            // Assuming the first player is the main player (user)
            for(Player player: gameState.getPlayers()){
            
            writer.println("Player Name: " + player.getName());
            writer.println("Player Balance: " + player.getChips()); //Hi JC i'm not sure if this is meant to be get Chips?
            writer.println("Number of Win: " + player.getNumOfWin());
            writer.println("Current Bet: " + gameState.getCurrentBet());
            writer.println("");
            }
            System.out.println("Game saved successfully to " + filePath);
        } catch (IOException e) {
            System.err.println("Error saving game: " + e.getMessage());
        }
    }
      
    public static GameState loadGameState(String fileName) {
        String filePath = SAVE_DIRECTORY + fileName + ".txt";
        try ( BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            List<Player> players = new ArrayList<>();
            List<Card> communityCards = new ArrayList<>();
            int pot = 0, currentBet = 0;
            Player winner = null;
            
            String line;
            Player currentPlayer = null;
            
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("Player Name: ")) {
                    String playerName = line.substring("Player Name: ".length());
                    currentPlayer = new Player(playerName, 0);
                    players.add(currentPlayer); // Add with 0 balance for now
                } else if (line.startsWith("Player Balance: ")) {
                    int balance = Integer.parseInt(line.substring("Player Balance: ".length()));
                    if(currentPlayer != null) {
                        currentPlayer.addToChips(balance); // Set balance of the main player, i'm not sure if this is meant to be getChps()
                    }
                } else if (line.startsWith("Community Cards: ")) {
                    // Logic to parse and add community cards
                } else if (line.startsWith("Pot: ")) {
                    pot = Integer.parseInt(line.substring("Pot: ".length()));
                } else if (line.startsWith("Current Bet: ")) {
                    currentBet = Integer.parseInt(line.substring("Current Bet: ".length()));
                } else if (line.startsWith("Number Of Win: ")) {
                    int num = Integer.parseInt(line.substring("Number Of Win: ".length()));
                    currentPlayer.setNumOfWin(num); // Winner balance can be set later
                }
            }

            GameState gameState = new GameState(players, communityCards, pot, currentBet);
            if (winner != null) {
                gameState.setWinner(winner);
            }

            System.out.println("Game loaded successfully from " + filePath);
            return gameState;
        } catch (IOException e) {
            System.err.println("Error loading game: " + e.getMessage());
            return null;
        }
    }

    public static List<String> getSavedGameFiles() {
        File directory = new File(SAVE_DIRECTORY);
        File[] files = directory.listFiles((dir, name) -> name.endsWith(".txt"));
        List<String> fileNames = new ArrayList<>();
       if (files != null) {
        for (File file : files) {
            String fileName = file.getName().replace(".txt", "");
            if (!fileName.endsWith("_log")) { // Filter out filenames ending with "_log"
                fileNames.add(fileName);
            }
        }
    }
        
        return fileNames;
    }

    public static boolean createNewSaveFile(String fileName) {
        File file = new File(SAVE_DIRECTORY + fileName + ".txt");
        String filePath = SAVE_DIRECTORY + fileName + "_log.txt";
        try {
            PrintWriter writer = new PrintWriter(new FileWriter(filePath, true));
            System.out.println("Log is created " + filePath);
            return file.createNewFile();
        } catch (IOException e) {
            System.err.println("Error creating new save file: " + e.getMessage());
            return false; 
    }
    }

     public static void appendToGameLog(String fileName, String logEntry) {
        String filePath = SAVE_DIRECTORY + fileName + "_log.txt";
        try ( PrintWriter writer = new PrintWriter(new FileWriter(filePath, true))) { // 'true' for appending
            writer.println(logEntry);
            System.out.println("Log entry added to " + filePath);
        } catch (IOException e) {
            System.err.println("Error appending to log file: " + e.getMessage());
        }
    }

    public static List<String> readGameLog(String fileName) {
        String filePath = SAVE_DIRECTORY + fileName + "_log.txt";
        List<String> logEntries = new ArrayList<>();
        try ( BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                logEntries.add(line);
            }
            System.out.println("Log entries read from " + filePath);
        } catch (IOException e) {
            System.err.println("Error reading log file: " + e.getMessage());
        }
        return logEntries;
    }

}

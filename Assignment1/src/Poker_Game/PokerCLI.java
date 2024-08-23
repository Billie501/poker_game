package Poker_Game;

import Poker_Game.FileManager;
import static Poker_Game.FileManager.getSavedGameFiles;
import static Poker_Game.FileManager.loadGameState;
import static Poker_Game.FileManager.readGameLog;
import java.util.List;
import java.util.Scanner;

public class PokerCLI {
    
    //variables ate encapsulated to ensure modification is controlled
    private PokerGame game; // The poker game instance
    private Scanner scanner; // Scanner for user input
    private FileManager fileManager; // File manager for handling game files
    private GameState gameState; // The current state of the game
    
    public PokerCLI() {
        game = new PokerGame();
        scanner = new Scanner(System.in);
        fileManager = new FileManager();
        
    }

    // Starts the command-line interface for interacting with the poker game
    public void start() throws InterruptedException {
       Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Poker Game!");
        String choice = "";
        
        // Loop for the main menu until the user chooses to start the game
        while(!choice.equals("1")) {
            System.out.println("Enter 1: Start game, "
                                 + "\nEnter 2: Show list of usernames, "
                                 + "\nEnter 3: Show the gmae log of a username\n"
                                 + "Enter 4: Exit program.");
            choice = scanner.nextLine();
           switch (choice) {
               case "1":
                   break; //Proceed to game setup
               case "2":
                   //Show list of saved usernames
                   List<String> list = getSavedGameFiles();
                   System.out.println("List of usernames");
                   if(list == null) {
                       System.out.println("There is no user.\n");
                   } else {
                        for(String a : list) {
                           System.out.println(a);
                         } 
                   }
                   System.out.println("");;
                   break;
               case "3":
                   // Show game log for a specific username
                   System.out.println("Enter your username: ");
                   String user = scanner.nextLine();
                   List<String> gameLog = readGameLog(user);
                   if(gameLog == null) {
                       System.out.println("There is no log\n");
                   } else {
                        for(String a : gameLog)
                        {
                            System.out.println(a);
                        }
                   }
                   System.out.println("");
                   break;
               case "4":
                   //Exit the programme
                   System.out.println("Exit program");
                   System.exit(0);
                   break;
               default:
                   System.out.println("Invalid Input. Try again.");
                   break;
           }
        }
        // Prompt for username after choosing to start the game
        System.out.println("Enter your username: ");
      
        String username = scanner.nextLine();
        
        // Load game state for the user if available, otherwise set up a new game
        GameState record = loadGameState(username);
            if (record != null) {
                System.out.println("Welcome back, " + record.getPlayers().get(0).getName() + "!");
                game.addPlayer(record.getPlayers().get(0).getName(), record.getPlayers().get(0).getChips());
              
                game.setGameState(record);
                
            } else {
                System.out.println("Username not found. Starting a new game.");
                userSetupPlayers(username, 1000); // Set up the user as a player
                ComputerSetupPlayers(); // Set up computer players
            }
        game.startGame(username); //Start the game
    }

    // Adds the user as a player with the given balance
    private void userSetupPlayers(String name, int balance) throws InterruptedException {
        game.addPlayer(name, balance); // Add user with the provided balance
    }

    // Adds computer players to the game
    private void ComputerSetupPlayers() throws InterruptedException {
        for (int i = 1; i < 5; i++) {
            Thread.sleep(1000); //simulate a delay for adding players
            game.addPlayer("Computer" + " " + i, 1000); // Add computer players
        }
    }

    // Save the user's data when the game ends
    
}

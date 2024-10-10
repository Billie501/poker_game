package Poker_Game;

import Poker_Game.Database.FileManager;
import java.util.List;

public class PokerCLI {
    
    //variables ate encapsulated to ensure modification is controlled
    private PokerGame game; // The poker game instance
    private FileManager fileManager; // File manager for handling game files
    private GameState gameState; // The current state of the game

    
    public PokerCLI() {
        this.game = new PokerGame();
        this.fileManager = new FileManager();

        
    }
    
    //start() was partly generated by ChatGPT
    // Starts the command-line interface for interacting with the poker game
    // Start the game with the provided username
    
    // This method will be triggered after the user clicks to start the game in the GUI
   public void start(String username) {
        try {
            PokerGame loadedGame = FileManager.loadGame(username);

            // the loadGame can not find game information, the user player name will be computer 0.
            if (!loadedGame.getGameState().getPlayers().isEmpty()) {
                this.game = loadedGame;
                System.out.println("Welcome back, " + username + "!");
            } else {
                System.out.println("Username not found. Starting a new game.");
                userSetupPlayers(username, 1000);
                ComputerSetupPlayers();
            }

            // Assuming GameStage is a GUI class that needs the game object
            new GameStage(game).setVisible(true);

        } catch (Exception ex) {
            System.err.println("An error occurred: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    // Adds the user as a player with the given balance
    private void userSetupPlayers(String name, int balance) throws InterruptedException {
        getGame().addPlayer(name, balance); // Add user with the provided balance
    }

    // Adds computer players to the game
    private void ComputerSetupPlayers() throws InterruptedException {
        for (int i = 1; i < 4; i++) {
            Thread.sleep(1000); //simulate a delay for adding players
            getGame().addPlayer("Computer" + " " + i, 1000); // Add computer players
        }
    }

    // Save the user's data when the game ends

    /**
     * @return the game
     */
    public PokerGame getGame() {
        return game;
    }

    /**
     * @param game the game to set
     */
    public void setGame(PokerGame game) {
        this.game = game;
    }
    
}

package Poker_Game;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.border.Border;

public class GameStage extends JFrame implements GameListener {
    private PokerGame game;
    private PokerController controller;
    private JPanel mainPanel, buttonPanel;
    private JLabel[] playerChipLabels, playerCardLabels, playerNameLabels, announcementLabels;
    private JLabel communityCardsLabel, bettingPotLabel, RoundLabel;
    private JButton callButton, foldButton, raiseButton, checkButton, exitButton;
    private Border border;
    private CountDownLatch userInputLatch;  // Latch to pause the game flow
    
    public GameStage(PokerGame game) throws InterruptedException {
        this.game = game;
        this.game.addGameListener(this);
        setSize(950, 750);
        setTitle("Poker Game");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the window on the screen.s
        this.controller = new PokerController(game);
       
        border = BorderFactory.createLineBorder(Color.BLACK, 2); // Create a border object
        
        initializeComponents();
    }
    
    private void initializeComponents() throws InterruptedException {
        super.setBackground(Color.GREEN);
        mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(Color.GREEN); // A vibrant green background
        
        setupAnnouncementPanel(); // New method to handle announcements
        setupPlayerPanels();
        setupCenterPanel();
        setupControlButtons();
        
        getContentPane().add(mainPanel); // Add the panel to the JFrame
        
        //pack(); // Adjusts the frame size to fit the components
        setVisible(true);
        startGameInBackground();
        dispose();
    }
    
    @Override
    public void onGameStateUpdated() {
        SwingUtilities.invokeLater(this::updateUI); // Update UI on the EDT
    }
    
    private void setupUITimer() {
        int delay = 10; // milliseconds
        new Timer(delay, e -> updateUI()).start();
    }
    
    private void setupPlayerPanels() {
        
        playerChipLabels = new JLabel[4]; // Assuming four players
        playerCardLabels = new JLabel[4];
        playerNameLabels = new JLabel[4];
        
        for (int i = 0; i < 4; i++) {
            JPanel panel = new JPanel();
            panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
            panel.setBorder(border); // Apply the border to the panel
            
            playerNameLabels[i] = new JLabel(getGame().getGameState().getPlayers().get(i).getName());
            repaint();
            playerChipLabels[i] = new JLabel("Chips: " + getGame().getGameState().getPlayers().get(i).getChips());
            repaint();
            playerCardLabels[i] = new JLabel("Cards: " + getGame().getGameState().getPlayers().get(i).getHand().getCards().get(0).getImage() 
                                            + getGame().getGameState().getPlayers().get(i).getHand().getCards().get(1).getImage());
            repaint();
            
            panel.add(playerNameLabels[i]);
            panel.add(playerChipLabels[i]);
            panel.add(playerCardLabels[i]);
            
            switch (i) {
                case 0:
                    panel.setBounds(475, 475, 250, 150);
                    break;
                case 1:
                    panel.setBounds(325, 50, 250, 150);
                    break;
                case 2:
                    panel.setBounds(650, 200, 250, 150);
                    break;
                case 3:
                    panel.setBounds(10, 200, 250, 150);
                    break;
                default:
                    break;
            }
            
            mainPanel.add(panel);
            panel.setBackground(Color.GREEN); // A vibrant green background
        }
        
    }
    
    private void setupAnnouncementPanel() {
        announcementLabels = new JLabel[2];
        if(getGame().getRound() == null) {
            getGame().setRound(" ");
        }
        announcementLabels[0] = new JLabel(getGame().getRound());
        if(getGame().getAnnouncement() == null)
        {
            getGame().setAnnouncement(" ");
        }
        
        announcementLabels[1] = new JLabel(" ");
        
        JPanel announcementPanel = new JPanel();
        announcementPanel.setLayout(new BoxLayout(announcementPanel, BoxLayout.Y_AXIS));
        announcementPanel.setBorder(border); // Apply the defined border to the panel
        announcementPanel.setBounds(10, 425, 300, 200); // Correctly set the bounds
        announcementPanel.setBackground(Color.GREEN); // Set background color
        announcementPanel.add(announcementLabels[0]); // Ensure label fills panel
        announcementPanel.add(announcementLabels[1]);
        
        mainPanel.add(announcementPanel);
        
        repaint();
        
        
    }
    
    private void handleUserAction(String action) {
    Player player = game.getGameState().getPlayers().get(0);  // Assume player 0 is the user
    try {
        controller.performAction(action, player);  // Delegate the action to the controller
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    showButtons(false);  // Hide buttons after the action is performed
    userInputLatch.countDown();  // Signal that the user input is complete
}

    
    private void startGameInBackground() {
        SwingWorker<Void, String> gameWorker = new SwingWorker<>() {
            @Override
            protected Void doInBackground() throws Exception {
                getGame().startGame(getGame().getGameState().getPlayers().get(0).getName());
                dispose();
                return null;
            }
            
            @Override
            protected void done() {
                try {
                    
                    updateUI(); // Update the UI after game has started
                    
                    // When the game finishes, close the GameStage and open PlayAgainMenu
                if (getGame().isFinished()) {  // Assuming you have a method isGameFinished() in PokerGame
                    dispose();  // Close the GameStage window
                    new PlayAgainMenu(getGame()).setVisible(true);  // Show PlayAgainMenu
                }
                    
                } catch (Exception e) {
                    SwingUtilities.invokeLater(() -> announcementLabels[1].setText("Failed to start game: " + e.getMessage()));
                }
            }
        };
        gameWorker.execute();
    }
    
    
    
    private void setupCenterPanel() {
        JPanel centerUpPanel = new JPanel(new BorderLayout());
        JPanel centerDownPanel = new JPanel(new BorderLayout());
        
        bettingPotLabel = new JLabel("Betting Pot: " + getGame().getBettingSystem().getPot());
        communityCardsLabel = new JLabel("Community Cards: " + getGame().getGameState().getCommunityCardsImages());
        
        centerDownPanel.add(communityCardsLabel);
        centerUpPanel.add(bettingPotLabel);
        
        centerUpPanel.setBounds(300, 200, 300, 100);
        centerDownPanel.setBounds(300, 300, 300, 100);
        centerUpPanel.setBackground(Color.GREEN); // A vibrant green background
        centerDownPanel.setBackground(Color.GREEN); // A vibrant green background
        centerUpPanel.setBorder(border); // Apply the border to the panel
        centerDownPanel.setBorder(border); // Apply the border to the panel
        mainPanel.add(centerUpPanel);
        mainPanel.add(centerDownPanel);
        
    }
    
    private void setupControlButtons() {
        buttonPanel = new JPanel();
        // initialization of buttons as before
        callButton = new JButton("Call");
        foldButton = new JButton("Fold");
        raiseButton = new JButton("Raise");
        checkButton = new JButton("Check");
        exitButton = new JButton("Exit Game");
        
        
        
        buttonPanel.add(callButton);
        buttonPanel.add(foldButton);
        buttonPanel.add(raiseButton);
        buttonPanel.add(checkButton);
        buttonPanel.add(exitButton);
        
        // Add action listeners to handle game logic on button press
        callButton.addActionListener(e -> handleUserAction("Call"));
        foldButton.addActionListener(e -> handleUserAction("Fold"));
        raiseButton.addActionListener(e -> handleUserAction("Raise"));
        checkButton.addActionListener(e -> handleUserAction("Check"));
        exitButton.addActionListener(e -> System.exit(0)); // Close the application
        
        buttonPanel.setBounds(400, 425, 400, 50);
        
        buttonPanel.setBackground(Color.GREEN); // A vibrant green background
        buttonPanel.setVisible(false);  // Initially hidden
        mainPanel.add(buttonPanel);
    }
    
        
    @Override
    public void onPlayerTurn(Player player) {
    // Only show buttons if it's the first player's (user's) turn
    if (player.equals(game.getGameState().getPlayers().get(0))) {
        userInputLatch = new CountDownLatch(1);  // Create a new latch for this turn
        showButtons(true);  // Show the buttons for the human player
        try {
            userInputLatch.await();  // Wait for the user input
        } catch (InterruptedException ex) {
            Logger.getLogger(GameStage.class.getName()).log(Level.SEVERE, null, ex);
        }
   
    }
}

    
    public void showButtons(boolean visible) {
        buttonPanel.setVisible(visible);
        
        revalidate(); // Revalidates the layout to ensure proper rendering
        repaint();    // Repaints the component to reflect visibility changes
        
    }
    
    public void updateUI() {
        if (SwingUtilities.isEventDispatchThread()) {
            if (getGame() != null) {
                List<Player> players = getGame().getGameState().getPlayers();
                
                for (int i = 0; i < Math.min(players.size(), playerNameLabels.length); i++) {
                    if (playerNameLabels[i] != null && playerChipLabels[i] != null && playerCardLabels[i] != null) {
                        playerNameLabels[i].setText(players.get(i).getName());
                        playerChipLabels[i].setText("Chips: " + players.get(i).getChips());
                        playerCardLabels[i].setText("Cards: " + players.get(i).getHand().toString());
                    }
                }
                
                if (communityCardsLabel != null && getGame().getGameState().getCommunityCards() != null) {
                    communityCardsLabel.setText("Community Cards: " + getGame().getGameState().getCommunityCards().toString());
                }
                
                if (bettingPotLabel != null) {
                    bettingPotLabel.setText("Pot: " + getGame().getBettingSystem().getPot()
                            + "       Current Bet: " + getGame().getGameState().getCurrentBet());
                }
                
                if (announcementLabels[0] != null) {
                    announcementLabels[0].setText(getGame().getRound() != null ? getGame().getRound() : " ");
                }
                
                if (announcementLabels[1] != null) {
                    announcementLabels[1].setText(getGame().getAnnouncement() != null ? getGame().getAnnouncement() : " ");
                }
            }
        } else {
            SwingUtilities.invokeLater(this::updateUI);
        }
    }
    
    
    
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

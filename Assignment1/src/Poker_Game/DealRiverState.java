/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Poker_Game;

/**
 *
 * @author user
 */
public class DealRiverState implements GameStateAction {
    @Override
    public void play(PokerGame game) throws InterruptedException {
        
        // This method plays the river phase (round 3 - final round) of the game by dealing one community card
        // and introducing a delay to simulate real-time gameplay.
        game.getGameState().getCommunityCards().add(game.getDeck().getCard());
        game.notifyGameUpdated();
        Thread.sleep(1000); // Introduce delay
    }
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Poker_Game.Panel;

/**
 *
 * @author user
 */
import Poker_Game.Card;
import javax.swing.*;
import java.awt.*;
import java.util.List;

public class CommunityCardsPanel {
    private JPanel panel;
    private JLabel communityCardsLabel;

    // Set up the community cards which are under the betting pot
    public CommunityCardsPanel() {
        panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.GREEN); // Set background color

        communityCardsLabel = new JLabel("Community Cards", SwingConstants.CENTER);
        communityCardsLabel.setBackground(Color.GREEN);
        panel.add(communityCardsLabel, BorderLayout.NORTH);
        
        JPanel cardsPanel = new JPanel();
        cardsPanel.setBackground(Color.GREEN);
        panel.add(cardsPanel, BorderLayout.CENTER);
    }

    public JPanel getPanel() {
        return panel;
    }

    // Update community card every round
    public void updateCommunityCards(List<Card> communityCards) {
        JPanel cardsPanel = (JPanel) panel.getComponent(1);
        cardsPanel.removeAll();
        
        for (Card card : communityCards) {
            if (card != null && card.getFrontImageIcon() != null) {
                cardsPanel.add(new JLabel(card.getFrontImageIcon()));
            }
        }
        cardsPanel.revalidate();
        cardsPanel.repaint();
    }
}
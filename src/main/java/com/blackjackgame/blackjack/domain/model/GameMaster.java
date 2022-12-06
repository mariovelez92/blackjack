package com.blackjackgame.blackjack.domain.model;

import static com.blackjackgame.blackjack.domain.util.DomainConstants.INITIAL_POINTS;

public class GameMaster {

    private int playerPoints;
    private int croupierPoints;

    public GameMaster() {
        this.playerPoints = INITIAL_POINTS;
        this.croupierPoints = INITIAL_POINTS;
    }

    public int getPlayerPoints() {
        return playerPoints;
    }

    public int getCroupierPoints() {
        return croupierPoints;
    }

    public void addPoints(String caller, Card card) {
        if (caller.equals("player")) {
            playerPoints += card.getValue();
        }
        else {
            croupierPoints += card.getValue();
        }
    }

    public int getHandValue(String caller) {
        if (caller.equals("player")) {
            return getPlayerPoints();
        }
        return getCroupierPoints();
    }

    public String calculateResult() {
        if (croupierPoints > 21 || playerPoints > croupierPoints) {
            return "win";
        } else if (playerPoints == croupierPoints) {
            return "draw";
        } else {
            return "lose";
        }
    }

    public void resetGM() {
        playerPoints = 0;
        croupierPoints = 0;

    }
}

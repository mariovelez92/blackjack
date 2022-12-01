package com.blackjackgame.blackjack.domain.response;

import com.blackjackgame.blackjack.domain.model.Card;

import java.util.List;

public class StartGameResponse {

    private List<Card> playerHand;
    private List<Card> croupierHand;

    public List<Card> getPlayerHand() {
        return playerHand;
    }

    public void setPlayerHand(List<Card> playerHand) {
        this.playerHand = playerHand;
    }

    public List<Card> getCroupierHand() {
        return croupierHand;
    }

    public void setCroupierHand(List<Card> croupierHand) {
        this.croupierHand = croupierHand;
    }
}

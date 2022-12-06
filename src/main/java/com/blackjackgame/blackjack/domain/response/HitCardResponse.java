package com.blackjackgame.blackjack.domain.response;

import com.blackjackgame.blackjack.domain.model.Card;

public class HitCardResponse {

    private Card card;
    private int handValue;
    private String status;

    public HitCardResponse(Card card, int handValue) {
        this.card = card;
        this.handValue = handValue;
    }

    public Card getCard() {
        return card;
    }

    public int getHandValue() {
        return handValue;
    }
}

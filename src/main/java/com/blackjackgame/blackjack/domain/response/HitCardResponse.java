package com.blackjackgame.blackjack.domain.response;

import com.blackjackgame.blackjack.domain.model.Card;

public class HitCardResponse {

    private Card card;

    public HitCardResponse(Card card) {
        this.card = card;
    }

    public Card getCard() {
        return card;
    }
}

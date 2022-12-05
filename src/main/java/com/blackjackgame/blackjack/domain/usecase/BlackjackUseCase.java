package com.blackjackgame.blackjack.domain.usecase;

import com.blackjackgame.blackjack.domain.api.BlackjackServicePort;
import com.blackjackgame.blackjack.domain.model.Card;
import com.blackjackgame.blackjack.domain.response.HitCardResponse;
import com.blackjackgame.blackjack.domain.response.StartGameResponse;

import java.util.ArrayList;
import java.util.List;

import static com.blackjackgame.blackjack.domain.util.DomainConstants.HAND_INITIAL_CAPACITY;

public class BlackjackUseCase implements BlackjackServicePort {
    @Override
    public StartGameResponse startGame() {
        StartGameResponse startGameResponse = new StartGameResponse();
        List<Card> playerHand = createHand();
        List<Card> croupierHand = createHand();
        startGameResponse.setPlayerHand(playerHand);
        startGameResponse.setCroupierHand(croupierHand);
        return startGameResponse;
    }

    @Override
    public HitCardResponse hitCard() {
        return new HitCardResponse(new Card());
    }

    public List<Card> createHand() {
        List<Card> hand = new ArrayList<>();
        for (int i = 0; i < HAND_INITIAL_CAPACITY; i++) {
            hand.add(new Card());
        }
        return hand;
    }
}

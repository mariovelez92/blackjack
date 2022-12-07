package com.blackjackgame.blackjack.domain.usecase;

import com.blackjackgame.blackjack.domain.api.BlackjackServicePort;
import com.blackjackgame.blackjack.domain.exception.NoMoreCardsAllowedException;
import com.blackjackgame.blackjack.domain.model.Card;
import com.blackjackgame.blackjack.domain.model.GameMaster;
import com.blackjackgame.blackjack.domain.request.HitCardRequest;
import com.blackjackgame.blackjack.domain.response.FinishRoundResponse;
import com.blackjackgame.blackjack.domain.response.HitCardResponse;
import com.blackjackgame.blackjack.domain.response.StartGameResponse;

import java.util.ArrayList;
import java.util.List;

import static com.blackjackgame.blackjack.domain.util.DomainConstants.CROUPIER;
import static com.blackjackgame.blackjack.domain.util.DomainConstants.HAND_INITIAL_CAPACITY;
import static com.blackjackgame.blackjack.domain.util.DomainConstants.PLAYER;

public class BlackjackUseCase implements BlackjackServicePort {

    private final GameMaster gameMaster;

    public BlackjackUseCase(GameMaster gameMaster) {
        this.gameMaster = gameMaster;
    }

    @Override
    public StartGameResponse startGame() {
        resetRound();
        StartGameResponse startGameResponse = new StartGameResponse();
        List<Card> playerHand = createHand(PLAYER);
        List<Card> croupierHand = createHand(CROUPIER);
        startGameResponse.setPlayerHand(playerHand);
        startGameResponse.setCroupierHand(croupierHand);
        return startGameResponse;
    }

    @Override
    public HitCardResponse hitCard(HitCardRequest hitCardRequest) {
        if ((hitCardRequest.getCaller().equals("player") && gameMaster.getPlayerPoints() > 21) ||
                (hitCardRequest.getCaller().equals("croupier") && gameMaster.getCroupierPoints() > 17)) {
            throw new NoMoreCardsAllowedException();
        }
        Card card = new Card();
        gameMaster.addPoints(hitCardRequest.getCaller(), card);
        int handValue = gameMaster.getHandValue(hitCardRequest.getCaller());
        return new HitCardResponse(card, handValue);
    }

    @Override
    public FinishRoundResponse finishRound() {
        return new FinishRoundResponse(gameMaster.calculateResult());
    }

    @Override
    public void resetRound() {
        gameMaster.resetGM();
    }

    public List<Card> createHand(String caller) {
        List<Card> hand = new ArrayList<>();
        for (int i = 0; i < HAND_INITIAL_CAPACITY; i++) {
            Card card = new Card();
            gameMaster.addPoints(caller, card);
            hand.add(card);
        }
        return hand;
    }
}

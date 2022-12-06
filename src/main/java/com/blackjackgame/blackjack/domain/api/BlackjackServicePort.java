package com.blackjackgame.blackjack.domain.api;

import com.blackjackgame.blackjack.domain.request.HitCardRequest;
import com.blackjackgame.blackjack.domain.response.FinishRoundResponse;
import com.blackjackgame.blackjack.domain.response.HitCardResponse;
import com.blackjackgame.blackjack.domain.response.StartGameResponse;

public interface BlackjackServicePort {

    StartGameResponse startGame();

    HitCardResponse hitCard(HitCardRequest hitCardRequest);

    FinishRoundResponse finishRound();

    void resetRound();
}

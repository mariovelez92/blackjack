package com.blackjackgame.blackjack.domain.api;

import com.blackjackgame.blackjack.domain.response.StartGameResponse;

public interface BlackjackServicePort {

    StartGameResponse startGame();
}

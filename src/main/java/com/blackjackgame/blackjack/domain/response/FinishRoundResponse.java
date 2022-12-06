package com.blackjackgame.blackjack.domain.response;

public class FinishRoundResponse {

    private String result;

    public FinishRoundResponse(String result) {
        this.result = result;
    }

    public String getResult() {
        return result;
    }
}

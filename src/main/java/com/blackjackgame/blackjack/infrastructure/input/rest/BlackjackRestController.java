package com.blackjackgame.blackjack.infrastructure.input.rest;

import com.blackjackgame.blackjack.domain.api.BlackjackServicePort;
import com.blackjackgame.blackjack.domain.response.StartGameResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/blackjack/")
@RequiredArgsConstructor
public class BlackjackRestController {

    private final BlackjackServicePort blackjackServicePort;

    @GetMapping()
    public ResponseEntity<StartGameResponse> startBlackjackGame() {
        return ResponseEntity.ok(blackjackServicePort.startGame());
    }
}

package com.blackjackgame.blackjack.infrastructure.input.rest;

import com.blackjackgame.blackjack.domain.api.BlackjackServicePort;
import com.blackjackgame.blackjack.domain.request.HitCardRequest;
import com.blackjackgame.blackjack.domain.response.FinishRoundResponse;
import com.blackjackgame.blackjack.domain.response.HitCardResponse;
import com.blackjackgame.blackjack.domain.response.StartGameResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/blackjack")
@RequiredArgsConstructor
@CrossOrigin("*")
public class BlackjackRestController {

    private final BlackjackServicePort blackjackServicePort;

    @GetMapping()
    public ResponseEntity<StartGameResponse> startBlackjackGame() {
        return ResponseEntity.ok(blackjackServicePort.startGame());
    }

    @PostMapping("/hit")
    public ResponseEntity<HitCardResponse> hitCard(@RequestBody HitCardRequest hitCardRequest) {
        return ResponseEntity.ok(blackjackServicePort.hitCard(hitCardRequest));
    }

    @GetMapping("/finish")
    public ResponseEntity<FinishRoundResponse> finishRound() {
        return ResponseEntity.ok(blackjackServicePort.finishRound());
    }
}

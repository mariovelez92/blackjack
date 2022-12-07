package com.blackjackgame.blackjack.infrastructure.exceptionhandler;

import com.blackjackgame.blackjack.domain.exception.NoMoreCardsAllowedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerAdvisor {

    @ExceptionHandler(NoMoreCardsAllowedException.class)
    public ResponseEntity<Void> handleNoMoreCardsAllowedException(
            NoMoreCardsAllowedException noMoreCardsAllowedException) {
        return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
    }
}

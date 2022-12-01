package com.blackjackgame.blackjack.application.configuration;

import com.blackjackgame.blackjack.domain.api.BlackjackServicePort;
import com.blackjackgame.blackjack.domain.usecase.BlackjackUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {
    @Bean
    public BlackjackServicePort blackjackServicePort() {
        return new BlackjackUseCase();
    }
}

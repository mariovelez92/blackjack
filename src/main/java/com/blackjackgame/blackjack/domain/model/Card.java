package com.blackjackgame.blackjack.domain.model;

import java.util.Random;

public class Card {

    private Random random = new Random();

    private String name;
    private Integer value;

    public Card() {
        this.name = generateCard();
        this.value = generateValue(this.name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    private String generateCard() {
        StringBuilder card = new StringBuilder();
        String numberPool = "1234567890JQK";
        int randomPick = random.nextInt(numberPool.length());
        card.append(numberPool.charAt(randomPick));

        String suitPool = "SHCD";
        randomPick = random.nextInt(suitPool.length()+1);
        card.append(suitPool.charAt(randomPick));
        return card.toString();
    }

    private Integer generateValue(String signature) {
        String name = Character.toString(signature.charAt(0));
        Integer value;

        switch (name) {
            case "1":
                value = 1;
                break;
            case "2":
                value = 2;
                break;
            case "3":
                value = 3;
                break;
            case "4":
                value = 4;
                break;
            case "5":
                value = 5;
                break;
            case "6":
                value = 6;
                break;
            case "7":
                value = 7;
                break;
            case "8":
                value = 8;
                break;
            case "9":
                value = 9;
                break;
            default:
                value = 10;
                break;
        }
        return value;
    }
}

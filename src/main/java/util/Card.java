package util;

public class Card {
    private String cardName;
    private String cardDescription;

    public Card(String cardName, String cardDescription){
        this.cardName=cardName;
        this.cardDescription=cardDescription;
    }

    public String getCardName(){
        return this.cardName;
    }

    public String getCardDescription(){
        return this.cardDescription;
    }
}

package com.object.problem;


import java.util.Arrays;
import java.util.Random;
import java.util.stream.Stream;

public class DeckOfCards {
    private static final int NO_OF_PLAYERS = 4;
    public int totalCards = 52;
    public String [] player1;
    public String [] player2;
    public String [] player3;
    public String [] player4;
    public Object [] distributeCards;
    String [] clubs = {"2","3","4","5","6","7","8","9","10","Jack","Queen","King","Ace"};
    String [] diamonds = {"2","3","4","5","6","7","8","9","10","Jack","Queen","King","Ace"};
    String [] hearts = {"2","3","4","5","6","7","8","9","10","Jack","Queen","King","Ace"};
    String [] spades = {"2","3","4","5","6","7","8","9","10","Jack","Queen","King","Ace"};

    static <T> Object[] mergeArray(T[] clubs, T[] diamonds,T[] hearts,T[] spades)
    {

        return Stream.of(clubs, diamonds,hearts,spades).flatMap(Stream::of).toArray();

    }

    public  void shuffleCards() {
        Random rand = new Random();
        for(int i = 0;i < clubs.length; i++ ) {
            int randomIndexToSwap =	rand.nextInt(clubs.length);
            String temp = clubs[randomIndexToSwap];
            clubs[randomIndexToSwap] = clubs[i];
            clubs[i] = temp;

            String temp1 = diamonds[randomIndexToSwap];
            diamonds[randomIndexToSwap] = diamonds[i];
            diamonds[i] = temp1;

            String temp2 = hearts[randomIndexToSwap];
            hearts[randomIndexToSwap] = hearts[i];
            hearts[i] = temp2;

            String temp3 = spades[randomIndexToSwap];
            spades[randomIndexToSwap] = spades[i];
            spades[i] = temp3;
        }
        Object [] mergeCards = mergeArray(clubs,diamonds,hearts,spades);
        distributeCards =mergeCards;
        System.out.println("shuffle cards is :" +  Arrays.toString(distributeCards));
    }



    public  void distributeCards() {

        for(int i=0;i<distributeCards.length;i++) {
            if(i<=13) {
                String  tempplayer1 =  distributeCards[i].toString();
                //String [] player1 = tempplayer1;
                System.out.println("cards for player one is " + distributeCards[i]);
            }
            else if(i>13 && i<=26) {
                String player2 = distributeCards[i].toString();
                System.out.println("cards for player two  is " + distributeCards[i]);
            }
            else if(i>26 && i<=39) {
                String player3 = distributeCards[i].toString();
                System.out.println("cards for player three is " + distributeCards[i]);
            }
            else {
                String player4 = distributeCards[i].toString();
                System.out.println("cards for player four is " + distributeCards[i]);
            }
        }

    }

    public static void main(String [] args) {
        DeckOfCards d = new DeckOfCards();
        d.shuffleCards();
        d.distributeCards();
    }
}

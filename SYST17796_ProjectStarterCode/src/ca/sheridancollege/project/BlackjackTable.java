/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project;

import java.util.Scanner;

/**
 *
 * @author Timothy Quan
 */
public class BlackjackTable {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        System.out.println("****Welcome to Blackjack****");
        Scanner scanner = new Scanner(System.in);
        Blackjack blackjack = new Blackjack("Blackjack");
        String registerAgain;

        do {
            BlackjackPlayer player = new BlackjackPlayer();
            boolean uniqueID = false;
            do {
                System.out.println("Enter a unique player ID:");
                String id = scanner.nextLine();
                player.setPlayerID(id);

                boolean alreadyRegistered = blackjack.isAlreadyRegistered(player);
                if (alreadyRegistered == true) {
                    System.out.println("That player ID is already taken!");
                } else {
                    blackjack.registerPlayer(player);
                    uniqueID = true;
                }
            } while (uniqueID == false);
            do {
                System.out.println("Register another player? (Y/N)");
                registerAgain = scanner.nextLine();
            } while (!registerAgain.equalsIgnoreCase("y") && !registerAgain.equalsIgnoreCase("n"));
        } while (registerAgain.equalsIgnoreCase("y"));
        

        int numOfPlayers = blackjack.getPlayers().size();
        do {
            System.out.println("");
            for (int i = 0; i < blackjack.getPlayers().size(); i++) {
                blackjack.getPlayers().get(i).play();
                BlackjackPlayer player = (BlackjackPlayer) blackjack.getPlayers().get(i);
                int count = 0;
                int[] bets = new int[6];
                boolean valid = false;
                do {
                    try {
                        System.out.println("Bet how many $500 chips?");
                        scanner = new Scanner(System.in);
                        bets[count] = scanner.nextInt();
                        valid = true;
                    } catch (Exception ex) {
                        System.out.println("Enter a proper value!");
                    }
                } while (bets[count] > player.chipCount()[count] || bets[count] < 0 || valid == false);
                count++;
                valid = false;
                do {
                    try {
                        System.out.println("Bet how many $100 chips?");
                        scanner = new Scanner(System.in);
                        bets[count] = scanner.nextInt();
                        valid = true;
                    } catch (Exception ex) {
                        System.out.println("Enter a proper value!");
                    }
                } while (bets[count] > player.chipCount()[count] || bets[count] < 0 ||  valid == false);
                count++;
                valid = false;
                do {
                    try {
                        System.out.println("Bet how many $25 chips?");
                        scanner = new Scanner(System.in);
                        bets[count] = scanner.nextInt();
                        valid = true;
                    } catch (Exception ex) {
                        System.out.println("Enter a proper value!");
                    }
                } while (bets[count] > player.chipCount()[count] || bets[count] < 0 ||  valid == false);
                count++;
                valid = false;
                do {
                    try {
                        System.out.println("Bet how many $10 chips?");
                        scanner = new Scanner(System.in);
                        bets[count] = scanner.nextInt();
                        valid = true;
                    } catch (Exception ex) {
                        System.out.println("Enter a proper value!");
                    }
                } while (bets[count] > player.chipCount()[count] || bets[count] < 0 ||  valid == false);
                count++;
                valid = false;
                do {
                    try {
                        System.out.println("Bet how many $5 chips?");
                        scanner = new Scanner(System.in);
                        bets[count] = scanner.nextInt();
                        valid = true;
                    } catch (Exception ex) {
                        System.out.println("Enter a proper value!");
                    }
                } while (bets[count] > player.chipCount()[count] || bets[count] < 0 ||  valid == false);
                count++;
                valid = false;
                do {
                    try {
                        System.out.println("Bet how many $1 chips?");
                        scanner = new Scanner(System.in);
                        bets[count] = scanner.nextInt();
                        valid = true;
                    } catch (Exception ex) {
                        System.out.println("Enter a proper value!");
                    }
                } while (bets[count] > player.chipCount()[count] || bets[count] < 0 ||  valid == false);

                player.bet(bets[0], bets[1], bets[2], bets[3], bets[4], bets[5]);

                System.out.println("");
            }

            System.out.println("Dealer's Turn");
            System.out.println("(Dealer does whatever)"); //Placeholder for now
            System.out.println("");

            String playAgain;
            for (int i = 0; i < blackjack.getPlayers().size(); i++) {
                    BlackjackPlayer player = (BlackjackPlayer) blackjack.getPlayers().get(i);
                    player.declareWinner();
                    System.out.println("");
                    player.displayChips();
                    do {
                        System.out.println(blackjack.getPlayers().get(i).getPlayerID() + ": Play again? (Y/N)");
                        scanner = new Scanner(System.in);
                        playAgain = scanner.nextLine();
                    } while (!playAgain.equalsIgnoreCase("y") && !playAgain.equalsIgnoreCase("n"));
                    if (playAgain.equalsIgnoreCase("n")) {
                        System.out.println(blackjack.getPlayers().get(i).getPlayerID() + ", you won $" + player.cashOut() + "!");
                        System.out.println("");
                        blackjack.getPlayers().remove(i);
                        i--;
                        numOfPlayers--;
                    }
            } 
        } while (numOfPlayers > 0);
    }
}

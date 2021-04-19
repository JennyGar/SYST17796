/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project;

import ca.sheridancollege.ca.project.child.Blackjack;
import ca.sheridancollege.ca.project.child.BlackjackPlayer;
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

        System.out.println("**************************** Welcome to Blackjack ****************************");
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
                System.out.println("Register another player? (Enter Y or N)");
                registerAgain = scanner.nextLine();
            } while (!registerAgain.equalsIgnoreCase("y") && !registerAgain.equalsIgnoreCase("n"));
        } while (registerAgain.equalsIgnoreCase("y"));

        int numOfPlayers = blackjack.getPlayers().size();
        do {
            System.out.println("");
            for (int i = 0; i < blackjack.getPlayers().size(); i++) {
                System.out.println("****************************");
                blackjack.getPlayers().get(i).play();
                BlackjackPlayer player = (BlackjackPlayer) blackjack.getPlayers().get(i);
                int count = 0;
                int[] bets = new int[6];
                boolean valid = false;
                if (player.chipCount()[count] > 0) {
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
                }
                count++;
                valid = false;
                if (player.chipCount()[count] > 0) {
                    do {
                        try {
                            System.out.println("Bet how many $100 chips?");
                            scanner = new Scanner(System.in);
                            bets[count] = scanner.nextInt();
                            valid = true;
                        } catch (Exception ex) {
                            System.out.println("Enter a proper value!");
                        }
                    } while (bets[count] > player.chipCount()[count] || bets[count] < 0 || valid == false);
                }
                count++;
                valid = false;
                if (player.chipCount()[count] > 0) {
                    do {
                        try {
                            System.out.println("Bet how many $25 chips?");
                            scanner = new Scanner(System.in);
                            bets[count] = scanner.nextInt();
                            valid = true;
                        } catch (Exception ex) {
                            System.out.println("Enter a proper value!");
                        }
                    } while (bets[count] > player.chipCount()[count] || bets[count] < 0 || valid == false);
                }
                count++;
                valid = false;
                if (player.chipCount()[count] > 0) {
                    do {
                        try {
                            System.out.println("Bet how many $10 chips?");
                            scanner = new Scanner(System.in);
                            bets[count] = scanner.nextInt();
                            valid = true;
                        } catch (Exception ex) {
                            System.out.println("Enter a proper value!");
                        }
                    } while (bets[count] > player.chipCount()[count] || bets[count] < 0 || valid == false);
                }
                count++;
                valid = false;
                if (player.chipCount()[count] > 0) {
                    do {
                        try {
                            System.out.println("Bet how many $5 chips?");
                            scanner = new Scanner(System.in);
                            bets[count] = scanner.nextInt();
                            valid = true;
                        } catch (Exception ex) {
                            System.out.println("Enter a proper value!");
                        }
                    } while (bets[count] > player.chipCount()[count] || bets[count] < 0 || valid == false);
                }
                count++;
                valid = false;
                if (player.chipCount()[count] > 0) {
                    do {
                        try {
                            System.out.println("Bet how many $1 chips?");
                            scanner = new Scanner(System.in);
                            bets[count] = scanner.nextInt();
                            valid = true;
                        } catch (Exception ex) {
                            System.out.println("Enter a proper value!");
                        }
                    } while (bets[count] > player.chipCount()[count] || bets[count] < 0 || valid == false);
                }

                player.bet(bets[0], bets[1], bets[2], bets[3], bets[4], bets[5]);

                System.out.println("");
            }

            blackjack.play();
            System.out.println("****************************");
            System.out.println("Dealer has a: " + blackjack.getHand().toString());
            System.out.println("Card Score: " + blackjack.getHand().addCards());
            System.out.println("");

            String hitOrStand = null;
            for (int i = 0; i < blackjack.getPlayers().size(); i++) {
                System.out.println("****************************");
                BlackjackPlayer player = (BlackjackPlayer) blackjack.getPlayers().get(i);
                player.initializeHand();
                player.getHand().addCard(blackjack.getJavaDeck().rCard());
                player.getHand().addCard(blackjack.getJavaDeck().rCard());
                System.out.println(blackjack.getPlayers().get(i).getPlayerID() + ", you cards are: " + player.getHand().toString());
                System.out.println("Card Score: " + player.getHand().addCards());
                if (player.getHand().addCards() < 21) {
                    do {
                        System.out.println(blackjack.getPlayers().get(i).getPlayerID() + ": Hit or Stand? (Enter H or S)");
                        scanner = new Scanner(System.in);
                        hitOrStand = scanner.nextLine();
                    } while (!hitOrStand.equalsIgnoreCase("h") && !hitOrStand.equalsIgnoreCase("s"));
                    if (hitOrStand.equalsIgnoreCase("h")) {
                        do {
                            player.getHand().addCard(blackjack.getJavaDeck().rCard());
                            System.out.println("");
                            System.out.println(blackjack.getPlayers().get(i).getPlayerID() + ", you cards are: " + player.getHand().toString());
                            System.out.println("Card Score: " + player.getHand().addCards());
                            if (player.getHand().addCards() < 21) {
                                do {
                                    System.out.println(blackjack.getPlayers().get(i).getPlayerID() + ": Hit or Stand? (Enter H or S)");
                                    scanner = new Scanner(System.in);
                                    hitOrStand = scanner.nextLine();
                                } while (!hitOrStand.equalsIgnoreCase("h") && !hitOrStand.equalsIgnoreCase("s"));
                            } else {
                                break;
                            }
                        } while (hitOrStand.equalsIgnoreCase("h"));
                    }
                }

                if (player.getHand().addCards() == 21) {
                    System.out.println("Blackjack, your card score is 21!");
                } else if (player.getHand().addCards() > 21) {
                    System.out.println("Your card score is over 21!");
                } else {
                    System.out.println("Your card score is " + player.getHand().addCards() + "!");
                }
                System.out.println("");
                
            }

            System.out.println("****************************");
            System.out.println("Dealer's Turn");
            blackjack.addDealerCard();
            System.out.println("Dealer has: " + blackjack.getHand().toString());
            System.out.println("Card Score: " + blackjack.getHand().addCards());
            System.out.println("");

            blackjack.dealerTurn();
            if (blackjack.getHand().addCards() == 21) {
                System.out.println("Blackjack, Dealer card score is 21!");
            } else if (blackjack.getHand().addCards() > 21) {
                System.out.println("Dealer card score is over 21!");
            } else {
                System.out.println("Dealer card score is " + blackjack.getHand().addCards() + "!");
            }
            System.out.println("");
            

            String playAgain;
            for (int i = 0; i < blackjack.getPlayers().size(); i++) {
                System.out.println("****************************");
                BlackjackPlayer player = (BlackjackPlayer) blackjack.getPlayers().get(i);
                blackjack.declareWinner(i);
                System.out.println("");
                player.displayChips();
                if (player.cashOut() == 0) {
                    System.out.println(blackjack.getPlayers().get(i).getPlayerID() + ", you won $" + player.cashOut() + "!");
                    System.out.println("");
                    System.out.println("Game has ended for " + blackjack.getPlayers().get(i).getPlayerID() + "!");
                    System.out.println("");
                    blackjack.getPlayers().remove(i);
                    i--;
                    numOfPlayers--;
                } else {
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
                System.out.println("");
            }
        } while (numOfPlayers > 0);
    }
}

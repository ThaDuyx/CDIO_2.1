import java.util.Scanner;

public class Game {

    public static void main(String[] args) {

        Scanner use = new Scanner(System.in);

        System.out.println("Welcome - Velkommen");
        System.out.println("Press 1 for English");
        System.out.println("Tryk 2 for Dansk");

        int UkOrDk = use.nextInt();

        if (UkOrDk == 1) {

            System.out.println("Choose which dice you want to play with:");
            System.out.println("Press 1 for 6-sided dice");
            System.out.println("Press 2 for 4-sided dice");

            int chooseDice = use.nextInt();

            if (chooseDice == 1) {
                System.out.println("You chose the 6-sided dice");
            } else if (chooseDice == 2) {
                System.out.println("You chose the 4-sided dice");
            }

            boolean Gameturn = true;
            int finalpoint = 3000;

            System.out.println("Enter player 1");
            String player1 = use.next();


            System.out.println("Enter player 2");
            String player2 = use.next();

            Player p1 = new Player(player1);
            Player p2 = new Player(player2);

            System.out.println("Player 1: " + p1.getName());
            System.out.println("Player 2: " + p2.getName());

            Dice dice1 = new Dice();
            Dice dice2 = new Dice();

            while (p1.getPoint() < finalpoint && p2.getPoint() < finalpoint) {
                if (Gameturn == true) {
                    System.out.println("It's now " + p1.getName() + "'s turn to roll the dice. Write " + "\"play\" " + " to continue the game");

                } else if (Gameturn == false) {
                    System.out.println("It's now " + p2.getName() + "'s turn to roll the dice. Write " + "\"play\" " + " to continue the game");
                }

                String request = use.next();

                if (request.equalsIgnoreCase("play")) {

                    if (chooseDice == 1) {
                        dice1.roll();
                        dice2.roll();
                    } else if (chooseDice == 2) {
                        dice1.roll2();
                        dice2.roll2();
                    }


                    int sum = dice1.getFace() + dice2.getFace();

                    if (Gameturn == true) {
                        switch (sum) {
                            case 2:
                                System.out.println(p1.getName() + " rolled " + dice1.getFace() + " and " + dice2.getFace() + " and together " + sum + ". " + p1.getName() + " has landed on Tower which gives 250 points.");
                                p1.addPoint(250);
                                Gameturn = false;
                                break;

                            case 3:
                                System.out.println(p1.getName() + " rolled  " + dice1.getFace() + " and " + dice2.getFace() + " and together " + sum + ". " + p1.getName() + " has landed on Crater and looses 100 points.");
                                p1.addPoint(-100);
                                Gameturn = false;
                                break;

                            case 4:
                                System.out.println(p1.getName() + " rolled " + dice1.getFace() + " and  " + dice2.getFace() + " and together " + sum + ". " + p1.getName() + " has landed on Palace Gates which gives 100 points.");
                                p1.addPoint(100);
                                Gameturn = false;
                                break;

                            case 5:
                                System.out.println(p1.getName() + " rolled " + dice1.getFace() + " and " + dice2.getFace() + " and together " + sum + ". " + p1.getName() + " has landed on Cold Dessert and looses 20 points.");
                                p1.addPoint(-20);
                                Gameturn = false;
                                break;

                            case 6:
                                System.out.println(p1.getName() + " rolled " + dice1.getFace() + " and " + dice2.getFace() + " and together " + sum + ". " + p1.getName() + " has landed on Walled City which gives 180 points.");
                                p1.addPoint(180);
                                Gameturn = false;
                                break;

                            case 7:
                                System.out.println(p1.getName() + " rolled " + dice1.getFace() + " and " + dice2.getFace() + " and together " + sum + ". " + p1.getName() + " has landed on Monastery but doesn't give or take any points.");
                                p1.addPoint(0);
                                Gameturn = false;
                                break;

                            case 8:
                                System.out.println(p1.getName() + " rolled " + dice1.getFace() + " and " + dice2.getFace() + " and together " + sum + ". " + p1.getName() + " has landed on Black Cover and looses 70 points.");
                                p1.addPoint(-70);
                                Gameturn = false;
                                break;

                            case 9:
                                System.out.println(p1.getName() + " rolled " + dice1.getFace() + " and " + dice2.getFace() + " and together " + sum + ". " + p1.getName() + " has landed Huts in the Mountain which gives 60 points.");
                                p1.addPoint(60);
                                Gameturn = false;
                                break;

                            case 10:
                                System.out.println(p1.getName() + " rolled " + dice1.getFace() + " and " + dice2.getFace() + " and together " + sum + ". " + p1.getName() + " has landed on Werewall and looses 80 points but receives a new roll.");
                                p1.addPoint(-80);
                                Gameturn = true;
                                break;

                            case 11:
                                System.out.println(p1.getName() + " rolled " + dice1.getFace() + " and " + dice2.getFace() + " and together " + sum + ". " + p1.getName() + " has landed on The Pit and looses 50 points.");
                                p1.addPoint(-50);
                                Gameturn = false;
                                break;

                            case 12:
                                System.out.println(p1.getName() + " rolled " + dice1.getFace() + " and " + dice2.getFace() + " and together " + sum + ". " + p1.getName() + " has landed on Goldmine receives the jackpot! " + p1.getName() + " gets 650 points!");
                                p1.addPoint(650);
                                Gameturn = false;
                                break;

                            default:
                                System.out.println("Something went wrong");
                                break;
                        }
                    } else if (Gameturn == false) {
                        switch (sum) {
                            case 2:
                                System.out.println(p2.getName() + " rolled " + dice1.getFace() + " and " + dice2.getFace() + " and together " + sum + ". " + p1.getName() + " has landed on Tower which gives 250 points.");
                                p2.addPoint(250);
                                Gameturn = true;
                                break;

                            case 3:
                                System.out.println(p2.getName() + " rolled " + dice1.getFace() + " and " + dice2.getFace() + " and together " + sum + ". " + p2.getName() + " has landed on Crater and looses 100 points.");
                                p2.addPoint(-100);
                                Gameturn = true;
                                break;

                            case 4:
                                System.out.println(p2.getName() + " rolled " + dice1.getFace() + " and " + dice2.getFace() + " and together " + sum + ". " + p2.getName() + " has landed on Palace Gates which gives 100 points.");
                                p2.addPoint(100);
                                Gameturn = true;
                                break;

                            case 5:
                                System.out.println(p2.getName() + " rolled " + dice1.getFace() + " and " + dice2.getFace() + " and together " + sum + ". " + p2.getName() + " has landed on Cold Dessert and looses 20 points.");
                                p2.addPoint(-20);
                                Gameturn = true;
                                break;

                            case 6:
                                System.out.println(p2.getName() + " rolled " + dice1.getFace() + " and " + dice2.getFace() + " and together " + sum + ". " + p2.getName() + " has landed on Walled City which gives 180 points.");
                                p2.addPoint(180);
                                Gameturn = true;
                                break;

                            case 7:
                                System.out.println(p2.getName() + " rolled " + dice1.getFace() + " and " + dice2.getFace() + " and together " + sum + ". " + p2.getName() + " has landed on Monastery but doesn't give or take any points.");
                                p2.addPoint(0);
                                Gameturn = true;
                                break;

                            case 8:
                                System.out.println(p2.getName() + " rolled " + dice1.getFace() + " and " + dice2.getFace() + " and together " + sum + ". " + p2.getName() + " has landed on Black Cover and looses 70 points.");
                                p2.addPoint(-70);
                                Gameturn = true;
                                break;

                            case 9:
                                System.out.println(p2.getName() + " rolled " + dice1.getFace() + " and " + dice2.getFace() + " and together " + sum + ". " + p2.getName() + " has landed Huts in the Mountain which gives 60 points.");
                                p2.addPoint(60);
                                Gameturn = true;
                                break;

                            case 10:
                                System.out.println(p2.getName() + " rolled " + dice1.getFace() + " and " + dice2.getFace() + " and together " + sum + ". " + p2.getName() + " has landed on Werewall and looses 80 points but receives a new roll.");
                                p2.addPoint(-80);
                                Gameturn = false;
                                break;

                            case 11:
                                System.out.println(p2.getName() + " rolled " + dice1.getFace() + " and " + dice2.getFace() + " and together " + sum + ". " + p2.getName() + " has landed on The Pit and looses 50 points.");
                                p2.addPoint(-50);
                                Gameturn = true;
                                break;

                            case 12:
                                System.out.println(p2.getName() + " rolled " + dice1.getFace() + " and " + dice2.getFace() + " and together " + sum + ". " + p2.getName() + " has landed on Goldmine receives the jackpot! " + p2.getName() + " gets 650 points!");
                                p2.addPoint(650);
                                Gameturn = true;
                                break;
                            default:
                                System.out.println("Something went wrong");
                                break;
                        }
                    }
                    System.out.println("The standings are now " + p1.getPoint() + " points to " + p1.getName() + " and " + p2.getPoint() + " points to " + p2.getName());
                }
            }
            if (p1.getPoint() >= finalpoint) {
                System.out.println(p1.getName() + " has acquired a total score over 3000 points, hence won the game");
            } else if (p2.getPoint() >= finalpoint) {
                System.out.println(p2.getName() + " has acquired a total score over 3000 points, hence won the game");
            }

        } else if (UkOrDk == 2){

            System.out.println("Vælg hvilken terning i vil spille med.");
            System.out.println("Tryk 1 for en 6-sidet terning.");
            System.out.println("Tryk 2 for en 4-sidet terning.");

            int chooseDice = use.nextInt();

            if (chooseDice == 1) {
                System.out.println("I valgte den 6-sidet terning");
            } else if (chooseDice == 2) {
                System.out.println("I valgte den 4 sidet terning");
            }

            boolean Gameturn = true;
            int finalpoint = 3000;

            System.out.println("Indtast navn på spiller 1");
            String player1 = use.next();
            System.out.println("Indtast navn på spiller 2");
            String player2 = use.next();

            Player p1 = new Player(player1);
            Player p2 = new Player(player2);

            System.out.println("Spiller 1: " + p1.getName());
            System.out.println("Spiller 2: " + p2.getName());

            Dice dice1 = new Dice();
            Dice dice2 = new Dice();

            while (p1.getPoint() < finalpoint && p2.getPoint() < finalpoint) {

                //Laver funktionen der fortæller brugeren at de skal indtaste værdien "kast" for at fortsætte for enten den ene eller anden spiller
                if (Gameturn == true) {
                    System.out.println("Det er nu " + p1.getName() + "'s tur til at kaste terningen. Tast" + " \"play\" " + "for at fortsætte spillet.");

                } else if (Gameturn == false) {
                    System.out.println("Det nu " + p2.getName() + "'s tur til at kaste terningen. Tast" + " \"play\" " + "for at fortsætte spillet.");
                }

                //Sætter en scanner der skal læse næste linje skrevet af brugeren for at fortsætte
                String request = use.next();

                //Siger hvis den indtastede værdi var kast skal den køre de 2 terning objekter og beregne matematikken for at simulere en terning
                if (request.equalsIgnoreCase("play")) {

                    if(chooseDice == 1) {
                        dice1.roll();
                        dice2.roll();
                    } else if (chooseDice == 2){
                        dice1.roll2();
                        dice2.roll2();
                    }

                    //Lægger de 2 terning værdier sammen og henter dem fra vores Terning klasse
                    int sum = dice1.getFace() + dice2.getFace();

                    //Metoden for hvis en af spillerne slår 2 1'ere og de taber deres score
                    if (Gameturn == true) {
                        switch (sum) {
                            case 2:
                                System.out.println(p1.getName() + " slog en " + dice1.getFace() + "'er & en " + dice2.getFace() + "'er og tilsammenlagt " + sum + ". " + p1.getName() + " er landet på feltet Tower som giver 250 point.");
                                p1.addPoint(250);
                                Gameturn = false;
                                break;

                            case 3:
                                System.out.println(p1.getName() + " slog en " + dice1.getFace() + "'er & en " + dice2.getFace() + "'er og tilsammenlagt " + sum + ". " + p1.getName() + " er landet på feltet Crater og mister 100 point.");
                                p1.addPoint(-100);
                                Gameturn = false;
                                break;

                            case 4:
                                System.out.println(p1.getName() + " slog en " + dice1.getFace() + "'er & en " + dice2.getFace() + "'er og tilsammenlagt " + sum + ". " + p1.getName() + " er landet på feltet Palace Gates og som giver 100 point.");
                                p1.addPoint(100);
                                Gameturn = false;
                                break;

                            case 5:
                                System.out.println(p1.getName() + " slog en " + dice1.getFace() + "'er & en " + dice2.getFace() + "'er og tilsammenlagt " + sum + ". " + p1.getName() + " er landet på feltet Cold Dessert og mister 20 point.");
                                p1.addPoint(-20);
                                Gameturn = false;
                                break;

                            case 6:
                                System.out.println(p1.getName() + " slog en " + dice1.getFace() + "'er & en " + dice2.getFace() + "'er og tilsammenlagt " + sum + ". " + p1.getName() + " er landet på feltet Walled City som giver 180 point.");
                                p1.addPoint(180);
                                Gameturn = false;
                                break;

                            case 7:
                                System.out.println(p1.getName() + " slog en " + dice1.getFace() + "'er & en " + dice2.getFace() + "'er og tilsammenlagt " + sum + ". " + p1.getName() + " er landet på feltet Monastery og mister eller får ingen point.");
                                p1.addPoint(0);
                                Gameturn = false;
                                break;

                            case 8:
                                System.out.println(p1.getName() + " slog en " + dice1.getFace() + "'er & en " + dice2.getFace() + "'er og tilsammenlagt " + sum + ". " + p1.getName() + " er landet på feltet Black Cover og mister 70 point.");
                                p1.addPoint(-70);
                                Gameturn = false;
                                break;

                            case 9:
                                System.out.println(p1.getName() + " slog en " + dice1.getFace() + "'er & en " + dice2.getFace() + "'er og tilsammenlagt " + sum + ". " + p1.getName() + " Er landet på feltet Huts in the Mountain som giver 60 point.");
                                p1.addPoint(60);
                                Gameturn = false;
                                break;

                            case 10:
                                System.out.println(p1.getName() + " slog en " + dice1.getFace() + "'er & en " + dice2.getFace() + "'er og tilsammenlagt " + sum + ". " + p1.getName() + " Er landet på Werewall og mister 80 point men får et ekstra kast af terningerne.");
                                p1.addPoint(-80);
                                Gameturn = true;
                                break;

                            case 11:
                                System.out.println(p1.getName() + " slog en " + dice1.getFace() + "'er & en " + dice2.getFace() + "'er og tilsammenlagt " + sum + ". " + p1.getName() + " Er landet på feltet The Pit og mister 50 point.");
                                p1.addPoint(-50);
                                Gameturn = false;
                                break;

                            case 12:
                                System.out.println(p1.getName() + " slog en " + dice1.getFace() + "'er & en " + dice2.getFace() + "'er og tilsammenlagt " + sum + ". " + p1.getName() + " Er landet på feltet Goldmine og har ramt jackpotten! " + p1.getName() + " får hele 650 point!");
                                p1.addPoint(650);
                                Gameturn = false;
                                break;

                            default:
                                System.out.println("Noget gik galt");
                                break;
                        }
                    } else if (Gameturn == false) {
                        switch (sum) {
                            case 2:
                                System.out.println(p2.getName() + "slog en " + dice1.getFace() + "'er & en " + dice2.getFace() + "'er og tilsammenlagt " + sum + ". " + p1.getName() + " er landet på feltet Tower som giver 250 point.");
                                p2.addPoint(250);
                                Gameturn = true;
                                break;

                            case 3:
                                System.out.println(p2.getName() + " slog en " + dice1.getFace() + "'er & en " + dice2.getFace() + "'er og tilsammenlagt " + sum + ". " + p2.getName() + " er landet på feltet Crater og mister 100 point.");
                                p2.addPoint(-100);
                                Gameturn = true;
                                break;

                            case 4:
                                System.out.println(p2.getName() + " slog en " + dice1.getFace() + "'er & en " + dice2.getFace() + "'er og tilsammenlagt " + sum + ". " + p2.getName() + " er landet på feltet Palace Gates som giver 100 point.");
                                p2.addPoint(100);
                                Gameturn = true;
                                break;

                            case 5:
                                System.out.println(p2.getName() + " slog en " + dice1.getFace() + "'er & en " + dice2.getFace() + "'er og tilsammenlagt " + sum + ". " + p2.getName() + " er landet på feltet Cold Dessert og mister 20 point.");
                                p2.addPoint(-20);
                                Gameturn = true;
                                break;

                            case 6:
                                System.out.println(p2.getName() + " slog en " + dice1.getFace() + "'er & en " + dice2.getFace() + "'er og tilsammenlagt " + sum + ". " + p2.getName() + " er landet på feltet Walled City som giver 180 point.");
                                p2.addPoint(180);
                                Gameturn = true;
                                break;

                            case 7:
                                System.out.println(p2.getName() + " slog en " + dice1.getFace() + "'er & en " + dice2.getFace() + "'er og tilsammenlagt " + sum + ". " + p2.getName() + " er landet på feltet Monastery og mister eller får ingen point.");
                                p2.addPoint(0);
                                Gameturn = true;
                                break;

                            case 8:
                                System.out.println(p2.getName() + " slog en " + dice1.getFace() + "'er & en " + dice2.getFace() + "'er og tilsammenlagt " + sum + ". " + p2.getName() + " er landet på feltet Black Cover og mister 70 point.");
                                p2.addPoint(-70);
                                Gameturn = true;
                                break;

                            case 9:
                                System.out.println(p2.getName() + " slog en " + dice1.getFace() + "'er & en " + dice2.getFace() + "'er og tilsammenlagt " + sum + ". " + p2.getName() + " Er landet på feltet Huts in the Mountain som giver 60 point.");
                                p2.addPoint(60);
                                Gameturn = true;
                                break;

                            case 10:
                                System.out.println(p2.getName() + " slog en " + dice1.getFace() + "'er & en " + dice2.getFace() + "'er og tilsammenlagt " + sum + ". " + p2.getName() + " Er landet på Werewall og mister 80 point men får et ekstra kast af terningerne.");
                                p2.addPoint(-80);
                                Gameturn = false;
                                break;

                            case 11:
                                System.out.println(p2.getName() + " slog en " + dice1.getFace() + "'er & en " + dice2.getFace() + "'er og tilsammenlagt " + sum + ". " + p2.getName() + " Er landet på feltet The Pit og mister 50 point.");
                                p2.addPoint(-50);
                                Gameturn = true;
                                break;

                            case 12:
                                System.out.println(p2.getName() + " slog en " + dice1.getFace() + "'er & en " + dice2.getFace() + "'er og tilsammenlagt " + sum + ". " + p2.getName() + " Er landet på feltet Goldmine og har ramt jackpotten! " + p2.getName() + " får hele 650 point!");
                                p2.addPoint(650);
                                Gameturn = true;
                                break;
                            default:
                                System.out.println("Noget gik galt");
                                break;
                        }
                    }
                    //Fortæller stilling mellem de 2 spillere.
                    System.out.println("Det står nu " + p1.getPoint() + " point til " + p1.getName() + " & " + p2.getPoint() + " point til " + p2.getName());
                }
            }
            //Fortæller hvis en af spillerne har fået over 'finalpoint' vinder spilleren og spillet slutter
            if (p1.getPoint() >= finalpoint) {

                System.out.println(p1.getName() + " har fået en total score over 3000 point og har derfor vundet spillet");

            } else if (p2.getPoint() >= finalpoint) {

                System.out.println(p2.getName() + " har fået en total score over 3000 point og har derfor vundet spiller");
            }
        }
    }
}
//Programmet er lavet af gruppe 24 til CDIO-2 projektet.
//Gruppen består af: Christoffer Adrian Detlef (s185117), Simon Andersen(s185083), Asama Hayder(s185099), Thaer Mhd Refaat(s170727) & Jakup Viljam Dam(s185095)

import java.util.Scanner;

public class Game {

    public static void main(String[] args) {
        Scanner use = new Scanner(System.in);

        //Denne boolean bliver senere brugt til at skifte tur mellem de 2 spillere.
        //Hvis Spillertur = true -> Spiller 1 & Spillertur = false -> Spiller 2.
        boolean Gameturn = true;

        //Sætter de point som en af spillerne skal have for at vinde
        int finalpoint = 40;

        System.out.println("Indtast navn på spiller 1");
        String player1 = use.nextLine();

        System.out.println("Indtast navn på spiller 2");
        String player2 = use.nextLine();

        Player p1 = new Player(player1);
        Player p2 = new Player(player2);

        System.out.println("Spiller 1: " + p1.getName());
        System.out.println("Spiller 2: " + p2.getName());

        //Opretter 2 nye terning objekter vi bruger til vores "Terning.kast" klasse der laver matematikken
        Dice dice1 = new Dice();
        Dice dice2 = new Dice();

        //Starter et while loop der fortæller mens mindst en af spillernes samlede point er under "finalpoint" skal den køre dette loop
        while (p1.getPoint() < finalpoint && p2.getPoint() < finalpoint) {

            //Laver funktionen der fortæller brugeren at de skal indtaste værdien "kast" for at fortsætte for enten den ene eller anden spiller
            if (Gameturn == true) {
                System.out.println("Det er nu " + p1.getName() + "'s tur til at kaste terningen. Tast" + " \"kast\" " + "for at fortsætte spillet.");

            } else if (Gameturn == false) {
                System.out.println("Det nu " + p2.getName() + "'s tur til at kaste terningen. Tast" + " \"kast\" " + "for at fortsætte spillet.");
            }

            //Sætter en scanner der skal læse næste linje skrevet af brugeren for at fortsætte
            String request = use.next();

            //Siger hvis den indtastede værdi var kast skal den køre de 2 terning objekter og beregne matematikken for at simulere en terning
            if (request.equalsIgnoreCase("kast")) {
                dice1.roll();
                dice2.roll();

                //Lægger de 2 terning værdier sammen og henter dem fra vores Terning klasse
                int sum = dice1.getFace() + dice2.getFace();

                //Metoden for hvis en af spillerne slår 2 1'ere og de taber deres score
                if (dice1.getFace() == 1 && dice1.getFace() == dice2.getFace() && Gameturn == true) {
                    System.out.println(p1.getName() + " slog et par " + dice1.getFace() + "'ere & har nu tabt sin score men får en ny tur");
                    p1.resetPoint();

                } else if (dice1.getFace() == 1 && dice1.getFace() == dice2.getFace() && Gameturn == false) {
                    System.out.println(p2.getName() + " slog et par " + dice1.getFace() + "'ere & har nu tabt sin score men får en ny tur");
                    p2.resetPoint();

                } else {

                    //tilføjer de nye ternings point til spiller 1's score
                    if (Gameturn == true && dice1.getFace() != dice2.getFace()) {
                        System.out.println(p1.getName() + " slog en " + dice1.getFace() + "'er" + " & en " + dice2.getFace() + "'er og får den samlede sum " + sum);
                        p1.addPoint(sum);
                        Gameturn = false;

                        //Medtoden for hvis spiller 1 slår et par og giver ham en ekstra tur.
                    } else if (Gameturn == true && dice1.getFace() == dice2.getFace()) {
                        System.out.println(p1.getName() + " slog et par " + dice1.getFace() + "'ere & får den samlede sum " + sum + " og får en ny tur");
                        p1.addPoint(sum);
                        Gameturn = true;

                        //Tilføjer de nye ternings point til spiller 2's score
                    } else if (Gameturn == false && dice1.getFace() != dice2.getFace()) {
                        System.out.println(p2.getName() + " slog en " + dice1.getFace() + "'er" + " & en " + dice2.getFace() + "'er og får den samlede sum " + sum + " og får en ny tur");
                        p2.addPoint(sum);
                        Gameturn = true;

                        //Medtoden for hvis spiller 2 slår et par og giver ham en ekstra tur
                    } else if (Gameturn == false && dice1.getFace() == dice2.getFace()) {
                        System.out.println(p2.getName() + " slog et par " + dice1.getFace() + "'ere & får en samlede sum " + sum);
                        p2.addPoint(sum);
                        Gameturn = false;
                    }
                }
                //Fortæller stilling mellem de 2 spillere.
                System.out.println("Det står nu " + p1.getPoint() + " point til " + p1.getName() + " & " + p2.getPoint() + " point til " + p2.getName());
            }
        }
        //Fortæller hvis en af spillerne har fået over 'finalpoint' vinder spilleren og spillet slutter
        if (p1.getPoint() >= finalpoint) {

            System.out.println(p1.getName() + " har fået en total score over 40 point og har derfor vundet spillet");

        } else if (p2.getPoint() >= finalpoint) {

            System.out.println(p2.getName() + " har fået en total score over 40 point og har derfor vundet spiller");
        }
        use.close();
    }
}
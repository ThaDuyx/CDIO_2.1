import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Game {

    public static void main(String[] args) {

        Scanner use = new Scanner(System.in);
        System.out.println("Welcome - Velkommen");
        System.out.println("Press 1 for english, Tryk 2 for dansk");
        //opsætning af sprogkode starter her
        char language = use.next().charAt(0);

        Locale dkLocale = new Locale("da","DK");
        Locale enLocale = new Locale("en","US");

        ResourceBundle messages = ResourceBundle.getBundle("MessagesBundle", enLocale);

        while (language != '1' && language != '2') {
            System.out.println("prøv igen/try again");
            language = use.next().charAt(0);
        }

        if (language == '1') {
            messages = ResourceBundle.getBundle("MessagesBundle", enLocale);
        } else if (language == '2') {
            messages = ResourceBundle.getBundle("MessagesBundle", dkLocale);
        }

        System.out.println(messages.getString("terning1"));
            int chooseDice = use.nextInt();

            if (chooseDice == 1) {
                System.out.println(messages.getString("terning2"));
            } else if (chooseDice == 2) {
                System.out.println(messages.getString("terning3"));
            }

        boolean Gameturn = true;
        int finalpoint = 3000;

        System.out.println(messages.getString("navnspiller1"));
        String player1 = use.next();
        System.out.println(messages.getString("navnspiller2"));
        String player2 = use.next();

        Player p1 = new Player(player1);
        Player p2 = new Player(player2);

        System.out.println(messages.getString("spiller1") + p1.getName());
        System.out.println(messages.getString("spiller2") + p2.getName());

        Dice dice1 = new Dice();
        Dice dice2 = new Dice();

        while (p1.getPoint() < finalpoint && p2.getPoint() < finalpoint) {

            //Laver funktionen der fortæller brugeren at de skal indtaste værdien "kast" for at fortsætte for enten den ene eller anden spiller
            if (Gameturn == true) {
                System.out.println(messages.getString("deternu") + p1.getName() + messages.getString("tur") + " \"play\" " + messages.getString("fortsætspillet"));

            } else if (Gameturn == false) {
                System.out.println(messages.getString("deternu") + p2.getName() + messages.getString("tur") + " \"play\" " + messages.getString("fortsætspillet"));
            }

            //Sætter en scanner der skal læse næste linje skrevet af brugeren for at fortsætte
            String request = use.next();

            //Siger hvis den indtastede værdi var kast skal den køre de 2 terning objekter og beregne matematikken for at simulere en terning
            if (request.equalsIgnoreCase("play")) {
                dice1.roll();
                dice2.roll();


                //Lægger de 2 terning værdier sammen og henter dem fra vores Terning klasse
                int sum = dice1.getFace() + dice2.getFace();

                //Metoden for hvis en af spillerne slår 2 1'ere og de taber deres score
                if (Gameturn == true) {
                    switch (sum) {
                        case 2:
                            System.out.println(p1.getName() + messages.getString("slogen") + dice1.getFace() + messages.getString("resultat1") + dice2.getFace() + messages.getString("resultat2") + sum + messages.getString("punktum") + p1.getName() + messages.getString("feltTower"));
                            p1.addPoint(250);
                            Gameturn = false;
                            break;

                        case 3:
                            System.out.println(p1.getName() + messages.getString("slogen") + dice1.getFace() + messages.getString("resultat1") + dice2.getFace() + messages.getString("resultat2") + sum + messages.getString("punktum") + p1.getName() + messages.getString("feltCrater"));
                            p1.addPoint(-100);
                            Gameturn = false;
                            break;

                        case 4:
                            System.out.println(p1.getName() + messages.getString("slogen") + dice1.getFace() + messages.getString("resultat1") + dice2.getFace() + messages.getString("resultat2") + sum + messages.getString("punktum") + p1.getName() + messages.getString("feltPalace"));
                            p1.addPoint(100);
                            Gameturn = false;
                            break;

                        case 5:
                            System.out.println(p1.getName() + messages.getString("slogen") + dice1.getFace() + messages.getString("resultat1") + dice2.getFace() + messages.getString("resultat2") + sum + messages.getString("punktum") + p1.getName() + messages.getString("feltDessert"));
                            p1.addPoint(-20);
                            Gameturn = false;
                            break;

                        case 6:
                            System.out.println(p1.getName() + messages.getString("slogen") + dice1.getFace() + messages.getString("resultat1") + dice2.getFace() + messages.getString("resultat2") + sum + messages.getString("punktum") + p1.getName() + messages.getString("feltCity"));
                            p1.addPoint(180);
                            Gameturn = false;
                            break;

                        case 7:
                            System.out.println(p1.getName() + messages.getString("slogen") + dice1.getFace() + messages.getString("resultat1") + dice2.getFace() + messages.getString("resultat2") + sum + messages.getString("punktum") + p1.getName() + messages.getString("feltMonastery"));
                            p1.addPoint(0);
                            Gameturn = false;
                            break;

                        case 8:
                            System.out.println(p1.getName() + messages.getString("slogen") + dice1.getFace() + messages.getString("resultat1") + dice2.getFace() + messages.getString("resultat2") + sum + messages.getString("punktum") + p1.getName() + messages.getString("feltCover"));
                            p1.addPoint(-70);
                            Gameturn = false;
                            break;

                        case 9:
                            System.out.println(p1.getName() + messages.getString("slogen") + dice1.getFace() + messages.getString("resultat1") + dice2.getFace() + messages.getString("resultat2") + sum + messages.getString("punktum") + p1.getName() + messages.getString("feltMountain"));
                            p1.addPoint(60);
                            Gameturn = false;
                            break;

                        case 10:
                            System.out.println(p1.getName() + messages.getString("slogen") + dice1.getFace() + messages.getString("resultat1") + dice2.getFace() + messages.getString("resultat2") + sum + messages.getString("punktum") + p1.getName() + messages.getString("feltWerewall"));
                            p1.addPoint(-80);
                            Gameturn = true;
                            break;

                        case 11:
                            System.out.println(p1.getName() + messages.getString("slogen") + dice1.getFace() + messages.getString("resultat1") + dice2.getFace() + messages.getString("resultat2") + sum + messages.getString("punktum") + p1.getName() + messages.getString("feltPit"));
                            p1.addPoint(-50);
                            Gameturn = false;
                            break;

                        case 12:
                            System.out.println(p1.getName() + messages.getString("slogen") + dice1.getFace() + messages.getString("resultat1") + dice2.getFace() + messages.getString("resultat2") + sum + messages.getString("punktum") + p1.getName() +  messages.getString("feltJackpot1") + p1.getName() + messages.getString("feltJackpot2"));
                            p1.addPoint(650);
                            Gameturn = false;
                            break;

                        default:
                            System.out.println(messages.getString("nogetgikgalt"));
                            break;
                    }
                } else if (Gameturn == false) {
                    switch (sum) {
                        case 2:
                            System.out.println(p2.getName() + messages.getString("slogen") + dice1.getFace() + messages.getString("resultat1") + dice2.getFace() + messages.getString("resultat2") + sum + messages.getString("punktum") + p1.getName() + messages.getString("feltTower"));
                            p2.addPoint(250);
                            Gameturn = true;
                            break;

                        case 3:
                            System.out.println(p2.getName() + messages.getString("slogen") + dice1.getFace() + messages.getString("resultat1") + dice2.getFace() + messages.getString("resultat2") + sum + messages.getString("punktum") + p2.getName() + messages.getString("feltCrater"));
                            p2.addPoint(-100);
                            Gameturn = true;
                            break;

                        case 4:
                            System.out.println(p2.getName() + messages.getString("slogen") + dice1.getFace() + messages.getString("resultat1") + dice2.getFace() + messages.getString("resultat2") + sum + messages.getString("punktum") + p2.getName() + messages.getString("feltPalace"));
                            p2.addPoint(100);
                            Gameturn = true;
                            break;

                        case 5:
                            System.out.println(p2.getName() + messages.getString("slogen") + dice1.getFace() + messages.getString("resultat1") + dice2.getFace() + messages.getString("resultat2") + sum + messages.getString("punktum") + p2.getName() + messages.getString("feltDessert"));
                            p2.addPoint(-20);
                            Gameturn = true;
                            break;

                        case 6:
                            System.out.println(p2.getName() + messages.getString("slogen") + dice1.getFace() + messages.getString("resultat1") + dice2.getFace() + messages.getString("resultat2") + sum + messages.getString("punktum") + p2.getName() + messages.getString("feltCity"));
                            p2.addPoint(180);
                            Gameturn = true;
                            break;

                        case 7:
                            System.out.println(p2.getName() + messages.getString("slogen") + dice1.getFace() + messages.getString("resultat1") + dice2.getFace() + messages.getString("resultat2") + sum + messages.getString("punktum") + p2.getName() + messages.getString("feltMonastery"));
                            p2.addPoint(0);
                            Gameturn = true;
                            break;

                        case 8:
                            System.out.println(p2.getName() + messages.getString("slogen") + dice1.getFace() + messages.getString("resultat1") + dice2.getFace() + messages.getString("resultat2") + sum + messages.getString("punktum") + p2.getName() + messages.getString("feltCover"));
                            p2.addPoint(-70);
                            Gameturn = true;
                            break;

                        case 9:
                            System.out.println(p2.getName() + messages.getString("slogen") + dice1.getFace() + messages.getString("resultat1") + dice2.getFace() + messages.getString("resultat2") + sum + messages.getString("punktum") + p2.getName() + messages.getString("feltMountain"));
                            p2.addPoint(60);
                            Gameturn = true;
                            break;

                        case 10:
                            System.out.println(p2.getName() + messages.getString("slogen") + dice1.getFace() + messages.getString("resultat1") + dice2.getFace() + messages.getString("resultat2") + sum + messages.getString("punktum") + p2.getName() + messages.getString("feltWerewall"));
                            p2.addPoint(-80);
                            Gameturn = false;
                            break;

                        case 11:
                            System.out.println(p2.getName() + messages.getString("slogen") + dice1.getFace() + messages.getString("resultat1") + dice2.getFace() + messages.getString("resultat2") + sum + messages.getString("punktum") + p2.getName() + messages.getString("feltPit"));
                            p2.addPoint(-50);
                            Gameturn = true;
                            break;

                        case 12:
                            System.out.println(p2.getName() + messages.getString("slogen") + dice1.getFace() + messages.getString("resultat1") + dice2.getFace() + messages.getString("resultat2") + sum + messages.getString("punktum") + p2.getName() + messages.getString("feltJackpot1") + p2.getName() + messages.getString("feltJackpot2"));
                            p2.addPoint(650);
                            Gameturn = true;
                            break;
                        default:
                            System.out.println(messages.getString("nogetgikgalt"));
                            break;
                    }
                }
                //Fortæller stilling mellem de 2 spillere.
                System.out.println(messages.getString("detstårnu1") + p1.getPoint() + messages.getString("detstårnu2") + p1.getName() + messages.getString("og") + p2.getPoint() + messages.getString("detstårnu2") + p2.getName());
            }
        }
        //Fortæller hvis en af spillerne har fået over 'finalpoint' vinder spilleren og spillet slutter
        if (p1.getPoint() >= finalpoint) {

            System.out.println(p1.getName() + messages.getString("vundet"));

        } else if (p2.getPoint() >= finalpoint) {

            System.out.println(p2.getName() + messages.getString("vundet"));
        }
    }
}



//Programmet er lavet af gruppe 24 til CDIO-2 projektet.
//Gruppen består af: Christoffer Adrian Detlef (s185117), Simon Andersen(s185083), Asama Hayder(s185099), Thaer Mhd Refaat(s170727) & Jakup Viljam Dam(s185095)

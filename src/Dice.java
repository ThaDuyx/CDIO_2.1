public class Dice {
    //Opretter int 'øjne' på terningen
    private int face;

    //Sætter maximum mængde af 'int øjne' til 6
    private final int MAX = 6;

    private final int MAX2 = 4;

    //Laver terning
    public Dice() {
        face = 1;
    }

    //Beregner matematikken bag terningen ved at gange et tilfældigt tal 1-6 med terningen med 1 øje
    public void roll() {
        face = (int) (Math.random() * MAX) + 1;
    }

    public void roll2() {
        face = (int) (Math.random() * MAX2) + 1;
    }

    //Henter antallet af øjne
    public int getFace() {
        return face;
    }
}

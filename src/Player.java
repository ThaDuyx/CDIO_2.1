public class Player {

    //Opretter String
    private String name;

    //Opretter int
    private int point;

    public int getlastPoint;

    //Tilføjer spiller navnet
    public Player(String name) {
        this.name = name;
    }

    //Henter Strengen "navn"
    public String getName() {
        return this.name;
    }

    //Henter Strengen "point"
    public int getPoint() {
        return this.point;
    }

    //Plusser det nye antal point med det totale for den enkelte spiller
    public void addPoint(int totalpoint) {
        this.point = this.point + totalpoint;
    }

    public int resetPoint() {
        this.point = 0;
        return this.point;
    }
}
import java.util.Random;
public class GewinnModel {
    private int gesamtPunkte;
    private int spielerZahl;
    private int computerZahl;
    private int rundenErgebnis;
    private final Random random = new Random();

    public GewinnModel(){
        this.gesamtPunkte = 30;
    }
    public int getGesamtPunkte() {
        return gesamtPunkte ;
    }

    public int getSpielerZahl() {
        return spielerZahl;
    }

    public int getComputerZahl() {
        return computerZahl;
    }

    public int getRundenErgebnis() {
        return rundenErgebnis;
    }
    public boolean hatGewonnen(){
        return gesamtPunkte > 100;
    }

    public boolean hatVerloren(){
        return gesamtPunkte =<0;
    }
}

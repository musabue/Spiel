import javax.swing.*;
import java.awt.*;

public class GewinnView extends JFrame {
    private JLabel lblGesamtPunkte = new JLabel("Gesamtpunkte: 30");
    private JLabel lblRundenErgebnis = new JLabel("Rundenergebnis: -");
    private JTextField txtEingabe = new JTextField(10);
    private JTextField txtComputerZahl = new JTextField(10);
    private JButton btnNochEinmal = new JButton("Noch einmal!");

    public GewinnView() {
        setTitle("Zahlen-Gewinnspiel");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 2, 5, 5));

        // Labels styling (immer weißer Hintergrund laut Angabe)
        lblGesamtPunkte.setOpaque(true);
        lblGesamtPunkte.setBackground(Color.WHITE);
        lblRundenErgebnis.setOpaque(true);
        lblRundenErgebnis.setBackground(Color.WHITE);

        txtComputerZahl.setEditable(false);

        add(new JLabel("Gesamtpunkte:"));
        add(lblGesamtPunkte);
        add(new JLabel("Rundenergebnis:"));
        add(lblRundenErgebnis);
        add(new JLabel("Deine Zahl (1-9):"));
        add(txtEingabe);
        add(new JLabel("Computerzahl:"));
        add(txtComputerZahl);
        add(new JLabel(""));
        add(btnNochEinmal);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public JTextField getTxtEingabe() { return txtEingabe; }
    public JTextField getTxtComputerZahl() { return txtComputerZahl; }
    public JButton getBtnNochEinmal() { return btnNochEinmal; }
    public JLabel getLblGesamtPunkte() { return lblGesamtPunkte; }
    public JLabel getLblRundenErgebnis() { return lblRundenErgebnis; }
}
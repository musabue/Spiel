import javax.swing.*;
import java.awt.*;

public class GewinnView extends JFrame {
    private JLabel lblRundenErgebnisHeader;
    private JLabel lblGesamtPunkteHeader;
    private JLabel lblRundenErgebnis;
    private JLabel lblGesamtPunkte;

    private JLabel lblDeineZahl;
    private JLabel lblComputer;
    private JTextField txtEingabe;
    private JTextField txtComputerZahl;

    private JButton btnNochEinmal;

    public GewinnView() {
        setTitle("Zahlen-Gewinnspiel (v1.0)");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 300);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        // --- NORDEN: Ergebnisse & Punkte ---
        JPanel panelNord = new JPanel(new GridLayout(2, 2, 10, 5));

        lblRundenErgebnisHeader = new JLabel("Rundenergebnis:", SwingConstants.CENTER);
        lblGesamtPunkteHeader = new JLabel("Gesamtpunkte:", SwingConstants.CENTER);

        lblRundenErgebnis = new JLabel("Tippe eine Zahl von 1 bis 9", SwingConstants.CENTER);
        lblRundenErgebnis.setFont(new Font("SansSerif", Font.BOLD, 14));
        lblRundenErgebnis.setOpaque(true);

        lblGesamtPunkte = new JLabel("Gesamtpunkte: 30", SwingConstants.CENTER);
        lblGesamtPunkte.setFont(new Font("SansSerif", Font.BOLD, 14));
        lblGesamtPunkte.setOpaque(true);

        panelNord.add(lblRundenErgebnisHeader);
        panelNord.add(lblGesamtPunkteHeader);
        panelNord.add(lblRundenErgebnis);
        panelNord.add(lblGesamtPunkte);

        // --- MITTE: Eingabefelder für Spieler und Computer ---
        JPanel panelMitte = new JPanel(new GridLayout(2, 2, 10, 5));

        lblDeineZahl = new JLabel("Deine Zahl:", SwingConstants.CENTER);
        lblComputer = new JLabel("Computer:", SwingConstants.CENTER);

        txtEingabe = new JTextField();
        txtEingabe.setHorizontalAlignment(JTextField.CENTER);
        txtEingabe.setFont(new Font("SansSerif", Font.BOLD, 28));

        txtComputerZahl = new JTextField();
        txtComputerZahl.setHorizontalAlignment(JTextField.CENTER);
        txtComputerZahl.setFont(new Font("SansSerif", Font.BOLD, 28));
        txtComputerZahl.setEditable(false);
        txtComputerZahl.setBackground(Color.WHITE);

        panelMitte.add(lblDeineZahl);
        panelMitte.add(lblComputer);
        panelMitte.add(txtEingabe);
        panelMitte.add(txtComputerZahl);

        // --- SÜDEN: Button ---
        JPanel panelSued = new JPanel(new FlowLayout(FlowLayout.CENTER));
        btnNochEinmal = new JButton("Noch einmal!");
        panelSued.add(btnNochEinmal);

        // Alles zum Hauptfenster hinzufügen
        add(panelNord, BorderLayout.NORTH);
        add(panelMitte, BorderLayout.CENTER);
        add(panelSued, BorderLayout.SOUTH);

        setVisible(true);
    }

    // Getter-Methoden für den Controller
    public JTextField getTxtEingabe() { return txtEingabe; }
    public JTextField getTxtComputerZahl() { return txtComputerZahl; }
    public JLabel getLblGesamtPunkte() { return lblGesamtPunkte; }
    public JLabel getLblRundenErgebnis() { return lblRundenErgebnis; }
    public JButton getBtnNochEinmal() { return btnNochEinmal; }
}
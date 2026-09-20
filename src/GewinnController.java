import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GewinnController {
    private GewinnModel model;
    private GewinnView view;

    public GewinnController(GewinnModel model, GewinnView view) {
        this.model = model;
        this.view = view;

        this.view.getTxtEingabe().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                auswerten();
            }
        });

        this.view.getBtnNochEinmal().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                zuruecksetzen();
            }
        });
    }

    public void auswerten() {
        try {
            int zahl = Integer.parseInt(view.getTxtEingabe().getText().trim());
            if (zahl < 1 || zahl > 9) {
                JOptionPane.showMessageDialog(view, "Bitte eine Zahl von 1 bis 9 eingeben!");
                return;
            }

            model.berechneRunde(zahl);

            view.getTxtComputerZahl().setText(String.valueOf(model.getComputerZahl()));
            view.getLblGesamtPunkte().setText("Gesamtpunkte: " + model.getGesamtPunkte());
            view.getLblRundenErgebnis().setText("Rundenergebnis: " + model.getRundenErgebnis());

            // Färbung für version-2.0
            if (model.getRundenErgebnis() > 0) {
                view.getLblGesamtPunkte().setBackground(java.awt.Color.GREEN);
                view.getLblRundenErgebnis().setBackground(java.awt.Color.GREEN);
            } else if (model.getRundenErgebnis() < 0) {
                view.getLblGesamtPunkte().setBackground(java.awt.Color.RED);
                view.getLblRundenErgebnis().setBackground(java.awt.Color.RED);
            } else {
                view.getLblGesamtPunkte().setBackground(java.awt.Color.WHITE);
                view.getLblRundenErgebnis().setBackground(java.awt.Color.WHITE);
            }

            if (model.hatGewonnen()) {
                JOptionPane.showMessageDialog(view, "Gewonnen!");
            } else if (model.hatVerloren()) {
                JOptionPane.showMessageDialog(view, "Verloren!");
            }

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(view, "Ungueltige Eingabe! Bitte eine Zahl eingeben.");
        }
    }

    public void zuruecksetzen() {
        view.getTxtEingabe().setText("");
        view.getTxtComputerZahl().setText("");
        view.getLblRundenErgebnis().setText("Rundenergebnis: -");
    }
}
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GewinnController {
    private GewinnModel model;
    private GewinnView view;

    public GewinnController(GewinnModel model, GewinnView view) {
        this.model = model;
        this.view = view;

        // Enter im Textfeld
        this.view.getTxtEingabe().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                auswerten();
            }
        });

        // Klick auf "Noch einmal!"
        this.view.getBtnNochEinmal().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                zuruecksetzen();
            }
        });
        view.getBtnNochEinmal().setEnabled(false);
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

            if (model.hatGewonnen()) {
                JOptionPane.showMessageDialog(view, "Gewonnen!");
            } else if (model.hatVerloren()) {
                JOptionPane.showMessageDialog(view, "Verloren!");
            }

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(view, "Ungueltige Eingabe! Bitte eine Zahl eingeben.");
        }
        view.getTxtEingabe().setEnabled(false);
        view.getBtnNochEinmal().setEnabled(true);
    }

    public void zuruecksetzen() {
        view.getTxtEingabe().setText("");
        view.getTxtComputerZahl().setText("");
        view.getLblRundenErgebnis().setText("Rundenergebnis: -");
        view.getTxtEingabe().setEnabled(true);
        view.getBtnNochEinmal().setEnabled(false);
    }
}
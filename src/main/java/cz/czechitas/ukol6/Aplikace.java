package cz.czechitas.ukol6;


import com.formdev.flatlaf.FlatLightLaf;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Aplikace extends JFrame {

    private JLabel husyLabel;
    private JTextField husyField;
    private JLabel kraliciLabel;
    private JTextField kraliciField;
    private JLabel pocetHlavLabel;
    private JTextField pocetHlavField;
    private JLabel pocetNohLabel;
    private JTextField pocetNohField;

    private JButton vypocitatButton;

    public static void main(String[] args) {
        FlatLightLaf.setup();
        new Aplikace().start();
    }

    public Aplikace() throws HeadlessException {
        super("Farmářka 1.0");
        this.init();
    }

    public void start() {
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setIconImage(new ImageIcon(Aplikace.class.getResource("czechitas-icon.png")).getImage());
        setLayout(new MigLayout("wrap 2", "[right]rel[50:120:150,grow,fill]"));
        setMinimumSize(new Dimension(250, 200));


        husyField = new JTextField();
        husyLabel = new JLabel("Husy");
        husyLabel.setDisplayedMnemonic('H');
        husyLabel.setLabelFor(husyField);
        add(husyLabel);
        add(husyField, "span");

        kraliciField = new JTextField();
        kraliciLabel = new JLabel("Kralici");
        kraliciLabel.setDisplayedMnemonic('K');
        kraliciLabel.setLabelFor(kraliciField);
        add(kraliciLabel);
        add(kraliciField, "span");

        vypocitatButton=new JButton("Vypocitat");
        vypocitatButton.setMnemonic('V');
        add(vypocitatButton,"center, span");
        vypocitatButton.addActionListener(this::handleVypocitat);

        pocetHlavField = new JTextField();
        pocetHlavField.setEditable(false);
        pocetHlavLabel = new JLabel("Pocet Hlav");
        pocetHlavLabel.setLabelFor(pocetHlavField);
        add(pocetHlavLabel);
        add(pocetHlavField, "span");

        pocetNohField = new JTextField();
        pocetNohField.setEditable(false);
        pocetNohLabel = new JLabel("Pocet Noh");
        pocetNohLabel.setLabelFor(pocetNohField);
        add(pocetNohLabel);
        add(pocetNohField, "span");

        pack();
    }

    private void handleVypocitat(ActionEvent actionEvent) {
        System.out.println("Vypocitam:");
        System.out.printf("Husy: %s", husyField.getText()).println();
        System.out.printf("Kralici: %s", kraliciField.getText()).println();

        int husy=Integer.parseInt(husyField.getText());
        int kralici=Integer.parseInt(kraliciField.getText());

        pocetHlavField.setText(Integer.toString(husy + kralici));
        pocetNohField.setText(Integer.toString((husy * 2) + (kralici * 4)));

        System.out.printf("Pocet hlav: %s", pocetHlavField.getText()).println();
        System.out.printf("Pocet noh: %s", pocetNohField.getText()).println();

        }

}

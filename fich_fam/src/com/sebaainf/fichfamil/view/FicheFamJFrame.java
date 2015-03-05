package com.sebaainf.fichfamil.view;

import com.jgoodies.forms.layout.FormLayout;
import com.sebaainf.fichfamil.common.FicheFam;
import com.sebaainf.fichfamil.common.MyApp;
import com.sebaainf.fichfamil.presentation.CitoyenPresentation;

import javax.swing.*;
import java.awt.*;

/**
 * Created by ${sebaainf.com} on 23/02/2015.
 */
public class FicheFamJFrame extends JFrame {

    private static Dimension screenSize;
    private final FicheFam ficheFam;


    public FicheFamJFrame(FicheFam ficheFam) {
        // TODO
        this.ficheFam = ficheFam;
        this.setTitle("Fiche Familiale");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(this.createPanel());

        this.pack();
        this.setSize(new Dimension(8 * (int) screenSize.getWidth() / 10, 9 * (int) screenSize.getHeight() / 10));

        this.setLocationRelativeTo(null); //to center the frame in the middle of screen
    }

    private JComponent createPanel() {

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        screenSize = toolkit.getScreenSize();


        LayoutManager layout = new BorderLayout();

        JComponent panel = new JPanel(layout);

        panel.add(buildButtonBarPanel(), BorderLayout.WEST);
        panel.add(buildEpouxInfoPanel(), BorderLayout.CENTER);
        panel.add(buildEpouxDecesInfoPanel(), BorderLayout.EAST);
        panel.add(buildMariageInfoPanel(), BorderLayout.SOUTH);

        return panel;
    }

    private JComponent buildMariageInfoPanel() {

        //todo
        return new JPanel();
    }

    private JComponent buildEpouxDecesInfoPanel() {

        //todo
        return new JPanel();
    }

    private JComponent buildEpouxInfoPanel() {

        //todo
        ficheFam.getCitoyen().setSit_famil("v");
        CitoyenPresentation presenter = new CitoyenPresentation(ficheFam.getCitoyen());
        CitoyenManagerUI app = new CitoyenManagerUI(presenter);

        return app.getPanel();
    }

    private JComponent buildButtonBarPanel() {

        LayoutManager layout = new FormLayout("center:pref", "center:pref");
        JComponent panel = new JPanel(layout);


        JButton buttonApercu = new JButton("Aperçu");
        JButton buttonModifier = new JButton("Modifier Citoyen");
        JButton buttonQuitter = new JButton("Quitter");
        JButton buttonEnfants = new JButton("Enfants");
        JButton buttonModifierMariage = new JButton("Modifier Mariage");

        MyButtonStackBuilder builder = new MyButtonStackBuilder((JPanel) panel, screenSize);

        builder.setBackground(MyApp.theme.buttonBarColor); //todo color


        //builder.getPanel().setLayout(layout);

        builder.addGlue();
        builder.addButton(buttonApercu);
        builder.addUnrelatedGap();

        builder.addButton(buttonModifier);
        builder.addUnrelatedGap();

        builder.addButton(buttonQuitter);

        builder.addGlue();

        builder.addButton(buttonEnfants);
        builder.addUnrelatedGap();

        builder.addButton(buttonModifierMariage);
        builder.addUnrelatedGap();
        builder.addUnrelatedGap();

        // setting sizes of buttons

        return builder.getPanel();
    }

}

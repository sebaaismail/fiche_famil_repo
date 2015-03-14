package com.sebaainf.fichfamil.view;

import com.jgoodies.forms.layout.FormLayout;
import com.sebaainf.fichfamil.common.FicheFam;
import com.sebaainf.fichfamil.common.MyApp;
import com.sebaainf.fichfamil.presentation.CitoyenEditorModel;
import com.sebaainf.fichfamil.presentation.CitoyenPresentation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventObject;

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

        //todo Testing JComboBox binding
        //ficheFam.getCitoyen().setSit_famil("d");
        CitoyenPresentation presenter = new CitoyenPresentation(ficheFam.getCitoyen());
        // TODO set CitoyenManagerUI in place CitoyenManagerUI_Test
        //CitoyenManagerUI_Test app = new CitoyenManagerUI_Test(presenter);

        //return app.getPanel();
        CitoyenEditorModel model = new CitoyenEditorModel(ficheFam.getCitoyen());
        CitoyenEditorView view = new CitoyenEditorView(model);

        return view.showDialog(new EventObject(""));
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
        //todo for testing
        buttonApercu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 JOptionPane.showMessageDialog(null, "citoyen "+ ficheFam.getCitoyen().getNom_fr()
                 + " " + ficheFam.getCitoyen().getPrenom_fr()+ " est comme situation familiale : " +
                 ficheFam.getCitoyen().getSit_famil());
            }
        });
        buttonModifier.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ficheFam.getCitoyen().setSit_famil("c");
                JOptionPane.showMessageDialog(null, "citoyen : "
                        + ficheFam.getCitoyen().getNom_fr()
                + " ne le : " + ficheFam.getCitoyen().getDate_naiss());
            }
        });

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

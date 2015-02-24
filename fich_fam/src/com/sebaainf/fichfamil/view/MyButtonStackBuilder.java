package com.sebaainf.fichfamil.view;

import com.jgoodies.forms.builder.AbstractButtonPanelBuilder;
import com.jgoodies.forms.layout.*;
import com.jgoodies.looks.Fonts;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

import static com.jgoodies.common.base.Preconditions.checkNotNull;

/**
 * Created by ${sebaainf.com} on 24/02/2015.
 */
public final class MyButtonStackBuilder extends AbstractButtonPanelBuilder {

    private static Dimension screenSize;
    /**
     * Specifies the FormLayout's the single button stack column.
     */
    private static final ColumnSpec[] COL_SPECS =
            new ColumnSpec[] { FormSpecs.BUTTON_COLSPEC };

    /**
     * Specifies the rows of the initial FormLayout used in constructors.
     */
    private static final RowSpec[] ROW_SPECS =
            new RowSpec[]{};


    // Instance Creation ****************************************************

    /**
     * Constructs a ButtonStackBuilder  on a default JPanel
     * using a pre-configured FormLayout as layout manager.
     */
    public MyButtonStackBuilder() {
        this(new JPanel(null));
    }


    /**
     * Constructs a ButtonStackBuilder on the given panel
     * using a pre-configured FormLayout as layout manager.
     *
     * @param panel   the layout container
     */
    public MyButtonStackBuilder(JPanel panel) {
        super(new FormLayout(COL_SPECS, ROW_SPECS), panel);
    }

    public MyButtonStackBuilder(JPanel panel, Dimension dimention) {

        super(new FormLayout(COL_SPECS, ROW_SPECS), panel);
        screenSize = dimention;
    }


    /**
     * Creates and returns an empty ButtonStackBuilder.
     *
     * @return the created builder
     * @since 1.8
     */
    public static MyButtonStackBuilder create() {
        return new MyButtonStackBuilder();
    }


    // Adding Components ****************************************************

    /**
     * Adds a button component that has a minimum width
     * specified by the {@link com.jgoodies.forms.util.LayoutStyle#getDefaultButtonWidth()}.<p>
     *
     * Although a JButton is expected, any JComponent is accepted
     * to allow custom button component types.
     *
     * @param button  the component to add
     *
     * @return this builder
     *
     * @throws NullPointerException if {@code button} is {@code null}
     */
    @Override
    public MyButtonStackBuilder addButton(JComponent button) {
        checkNotNull(button, "The button must not be null.");
        getLayout().appendRow(FormSpecs.PREF_ROWSPEC);
        add(button);
        nextRow();


        // todo custmize settings

        button.setBackground(Color.decode("#EAF5D7"));
        button.setFont(Fonts.WINDOWS_VISTA_96DPI_LARGE);

        int newHeight = (int) screenSize.getHeight()/16;
        if (newHeight > (int) button.getPreferredSize().getHeight()) {
            button.setPreferredSize(new Dimension((int) button.getPreferredSize().getWidth(), newHeight));
        }

        return this;
    }


    @Override
    public MyButtonStackBuilder addButton(JComponent... buttons) {
        super.addButton(buttons);
        return this;
    }


    // Convenience Methods ***************************************************

    @Override
    public MyButtonStackBuilder addButton(Action... actions) {
        super.addButton(actions);
        return this;
    }


    /**
     * Adds a fixed size component.
     *
     * @param component  the component to add
     */
    public MyButtonStackBuilder addFixed(JComponent component) {
        getLayout().appendRow(FormSpecs.PREF_ROWSPEC);
        add(component);
        nextRow();
        return this;
    }


    // Spacing ****************************************************************

    /**
     * Adds a glue that will be given the extra space,
     * if this box is larger than its preferred size.
     */
    public MyButtonStackBuilder addGlue() {
        appendGlueRow();
        nextRow();
        return this;
    }


    @Override
    public MyButtonStackBuilder addRelatedGap() {
        appendRelatedComponentsGapRow();
        nextRow();
        return this;
    }


    @Override
    public MyButtonStackBuilder addUnrelatedGap() {
        appendUnrelatedComponentsGapRow();
        nextRow();
        return this;
    }


    /**
     * Adds a strut of a specified size.
     *
     * @param size  a constant that describes the gap
     */
    public MyButtonStackBuilder addStrut(ConstantSize size) {
        getLayout().appendRow(new RowSpec(RowSpec.TOP,
                size,
                FormSpec.NO_GROW));
        nextRow();
        return this;
    }


    // Configuration **********************************************************

    @Override
    public MyButtonStackBuilder background(Color background) {
        super.background(background);
        return this;
    }


    @Override
    public MyButtonStackBuilder border(Border border) {
        super.border(border);
        return this;
    }


    @Override
    public MyButtonStackBuilder opaque(boolean b) {
        super.opaque(b);
        return this;
    }


}
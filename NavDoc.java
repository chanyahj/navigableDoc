package view;

import javax.swing.*;

public class NavDoc {
    private JLabel docLabel;
    private JTextField docField;
    private JButton resetButton;
    private JButton addButton;
    private JButton containsButton;
    private JButton forwardButton;
    private JPanel myPanel;

    public JPanel getMyPanel() {
        return myPanel;
    }

    public JLabel getDocLabel() {
        return docLabel;
    }

    public JTextField getDocField() {
        return docField;
    }

    public JButton getResetButton() {
        return resetButton;
    }

    public JButton getAddButton() {
        return addButton;
    }

    public JButton getContainsButton() {
        return containsButton;
    }

    public JButton getForwardButton() {
        return forwardButton;
    }
}

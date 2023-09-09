package view;

import javax.swing.*;

public class NavDocView extends JFrame {
    public NavDoc form;

    public NavDocView(){
        this.form=new NavDoc();
        JPanel content=form.getMyPanel();
        this.setContentPane(content);
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public NavDoc getForm() {
        return form;
    }
}

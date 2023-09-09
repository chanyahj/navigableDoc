package controller;

import model.NavigableDocModel;
import model.Side;
import view.NavDoc;
import view.NavDocView;

import javax.swing.*;

public class NavDocController {
    private NavigableDocModel<Integer> navigableDoc;
    private NavDocView view;
    public NavDocController(NavigableDocModel<Integer> navDoc, NavDocView view){
        this.navigableDoc=navDoc;
        this.view=view;
        NavDoc form=view.getForm();

        //add button
        form.getAddButton().addActionListener(e -> {
            String number=form.getDocField().getText();
            if(!isValidField(number)){
                JOptionPane.showMessageDialog(view, "Field must be Integer");
                return;
            }
            else{
                navigableDoc.insertNewItemRt(Integer.parseInt(number));
                form.getDocLabel().setText(navigableDoc.toString());
            }

        });
        form.getForwardButton().addActionListener(e -> {
            navigableDoc.forward();
            form.getDocLabel().setText(navigableDoc.toString());
        });
        form.getResetButton().addActionListener(e -> {
            navigableDoc.reset();
            form.getDocLabel().setText(navigableDoc.toString());
        });
        form.getContainsButton().addActionListener(e -> {
            String item=form.getDocField().getText();
            if(!isValidField(item)){
                JOptionPane.showMessageDialog(view, "Field must be Integer");
                return;
            }
            else{
                navigableDoc.contains(Integer.parseInt(item));
                JOptionPane.showMessageDialog(view, "item "+item+" appears on the "+navigableDoc.contains(Integer.valueOf(item)));
            }

        });

        }
    public static boolean isValidField(String item) {
        try {
            int number= Integer.parseInt(item);
            return true;

        } catch (NumberFormatException nfe) {
            return false;
        }
    }
}

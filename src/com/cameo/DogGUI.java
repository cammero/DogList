package com.cameo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Cameo on 11/9/2015.
 */
public class DogGUI extends JFrame{
    private JPanel rootPanel;
    private JTextField dogNameTextField;
    private JTextField dogAgeTextField;
    private JCheckBox puppyCheckBox;
    private JButton addDogToListButton;
    private JLabel dogAgeLabel;
    private JLabel dogNameLabel;
    private JList<Dog> dogJList;
    private JButton deleteDogButton;

    DefaultListModel<Dog> dogListModel;

    public DogGUI (){
        super("List of Dogs");
        setContentPane(rootPanel);
        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(new Dimension(300, 500));

        dogListModel = new DefaultListModel<Dog>();
        dogJList.setModel(dogListModel);
        dogJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        addDogToListButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String dogName = dogNameTextField.getText();
                String dogAgeAsString = dogAgeTextField.getText();
                int dogAge;
                try {
                    dogAge = Integer.parseInt(dogAgeAsString);
                } catch (NumberFormatException nfe) {
                    JOptionPane.showMessageDialog(DogGUI.this, "Enter an integer number for dog's age.");
                    return;
                }
                boolean isPuppy = puppyCheckBox.isSelected();
                Dog newDog = new Dog(dogName, dogAge, isPuppy);
                DogGUI.this.dogListModel.addElement(newDog);
            }
        });
        deleteDogButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Dog toDelete = DogGUI.this.dogJList.getSelectedValue();
                DogGUI.this.dogListModel.removeElement(toDelete);
            }
        });
    }
}

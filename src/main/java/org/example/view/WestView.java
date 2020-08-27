package org.example.view;


import org.example.modal.repo.Crud;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class WestView {

    public static JLabel fName;
    public static JTextField fNameTF;

    public static JLabel lName;
    public static JTextField lNameTF;

    public static JLabel regNum;
    public static JTextField regNumTF;

    static {
        fName = new JLabel("First name");
        fNameTF = new JTextField();
        lName = new JLabel("Last name");
        lNameTF = new JTextField();
        regNum = new JLabel("Registration No.");
        regNumTF = new JTextField();
    }

    public static JPanel formPanel() {
        JPanel addressPanel = new JPanel();
        Border border = addressPanel.getBorder();
        Border margin = new EmptyBorder(10, 10, 10, 10);
        addressPanel.setBorder(new CompoundBorder(border, margin));

        GridBagLayout panelGridBagLayout = new GridBagLayout();
        panelGridBagLayout.columnWidths = new int[]{80};
        addressPanel.setLayout(panelGridBagLayout);

        // first name
        GridBagConstraints gridBagConstraintForLabel = new GridBagConstraints();
        gridBagConstraintForLabel.fill = GridBagConstraints.BOTH;
        gridBagConstraintForLabel.insets = new Insets(0, 0, 10, 0);
        gridBagConstraintForLabel.gridx = 0;
        gridBagConstraintForLabel.gridy = 0;
        addressPanel.add(fName, gridBagConstraintForLabel);


        GridBagConstraints gridBagConstraintForTextField = new GridBagConstraints();
        gridBagConstraintForTextField.fill = GridBagConstraints.BOTH;
        gridBagConstraintForTextField.insets = new Insets(0, 0, 10, 0);
        gridBagConstraintForTextField.gridx = 1;
        gridBagConstraintForTextField.gridy = 0;
        addressPanel.add(fNameTF, gridBagConstraintForTextField);
        fNameTF.setColumns(15);


        // last name
        gridBagConstraintForLabel.fill = GridBagConstraints.BOTH;
        gridBagConstraintForLabel.insets = new Insets(0, 0, 10, 0);
        gridBagConstraintForLabel.gridx = 0;
        gridBagConstraintForLabel.gridy = 1;
        addressPanel.add(lName, gridBagConstraintForLabel);

        gridBagConstraintForTextField.fill = GridBagConstraints.BOTH;
        gridBagConstraintForTextField.insets = new Insets(0, 0, 10, 0);
        gridBagConstraintForTextField.gridx = 1;
        gridBagConstraintForTextField.gridy = 1;
        addressPanel.add(lNameTF, gridBagConstraintForTextField);
        lNameTF.setColumns(15);


        // reg num
        gridBagConstraintForLabel.fill = GridBagConstraints.BOTH;
        gridBagConstraintForLabel.insets = new Insets(0, 0, 10, 0);
        gridBagConstraintForLabel.gridx = 0;
        gridBagConstraintForLabel.gridy = 2;
        addressPanel.add(regNum, gridBagConstraintForLabel);

        gridBagConstraintForTextField.fill = GridBagConstraints.BOTH;
        gridBagConstraintForTextField.insets = new Insets(0, 0, 10, 0);
        gridBagConstraintForTextField.gridx = 1;
        gridBagConstraintForTextField.gridy = 2;
        addressPanel.add(regNumTF, gridBagConstraintForTextField);
        regNumTF.setColumns(15);


        // buttons
        gridBagConstraintForLabel.fill = GridBagConstraints.BOTH;
        gridBagConstraintForLabel.insets = new Insets(0, 0, 10, 10);
        gridBagConstraintForLabel.gridx = 0;
        gridBagConstraintForLabel.gridy = 5;
        JButton update = new JButton("Update");
        addressPanel.add(update, gridBagConstraintForLabel);
        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Crud.update(fNameTF.getText().trim(), lNameTF.getText().trim(), regNumTF.getText().trim());
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        gridBagConstraintForLabel.fill = GridBagConstraints.BOTH;
        gridBagConstraintForLabel.insets = new Insets(0, 0, 10, 0);
        gridBagConstraintForLabel.gridx = 1;
        gridBagConstraintForLabel.gridy = 5;
        JButton jButton = new JButton("Insert");
        addressPanel.add(jButton, gridBagConstraintForLabel);
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Crud.insert(fNameTF.getText().trim(), lNameTF.getText().trim(), regNumTF.getText().trim());
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        gridBagConstraintForLabel.insets = new Insets(0, 0, 10, 0);
        gridBagConstraintForLabel.gridx = 0;
        gridBagConstraintForLabel.gridy = 6;
        gridBagConstraintForLabel.gridwidth = 2;
        gridBagConstraintForLabel.fill = GridBagConstraints.BOTH;
        JButton delete = new JButton("Delete");
        addressPanel.add(delete, gridBagConstraintForLabel);
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Crud.delete();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        return addressPanel;
    }


}

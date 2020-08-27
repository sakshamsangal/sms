package org.example;


import org.example.view.CenterView;
import org.example.view.NorthView;
import org.example.view.WestView;

import javax.swing.*;
import java.awt.*;

public class App {

    public static void main(String[] args) throws Exception {
        JFrame jFrame = new JFrame("Student Management System");
        jFrame.setLayout(new BorderLayout());
        addComponents(jFrame);
        jFrame.setMinimumSize(new Dimension(700, 650));
        jFrame.setLocationRelativeTo(null);
        // jFrame.setExtendedState(jFrame.getExtendedState() | JFrame.MAXIMIZED_BOTH);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private static void addComponents(JFrame jFrame) throws Exception {
        jFrame.add(NorthView.getMainPanel(), BorderLayout.NORTH);
        jFrame.add(CenterView.getJScrollPane(), BorderLayout.CENTER);
        JPanel jPanel = new JPanel(new FlowLayout());
        jPanel.setPreferredSize(new Dimension(300,-1));
        jPanel.add(WestView.formPanel());
        jFrame.add(jPanel, BorderLayout.WEST);
    }


}


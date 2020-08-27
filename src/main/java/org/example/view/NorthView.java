package org.example.view;

import javax.swing.*;
import java.awt.*;

public class NorthView {
    static JPanel mainPanel;
    static JPanel leftPanel;
    static JPanel rightPanel;

    public static JPanel getMainPanel() {
        mainPanel = new JPanel(new BorderLayout());
        mainPanel.setPreferredSize(new Dimension(160, 160));
        mainPanel.setBackground(Color.decode("#4285F4"));

        mainPanel.add(getLeftPanel(), BorderLayout.WEST);
        mainPanel.add(getRightPanel(), BorderLayout.CENTER);
        return mainPanel;
    }

    static JPanel getLeftPanel() {
        leftPanel = new JPanel(new GridBagLayout());
        leftPanel.setBackground(Color.decode("#4285F4"));

        leftPanel.setPreferredSize(new Dimension(180, 160));
        ImageIcon imageIcon = new ImageIcon(new ImageIcon("D:/Temporary/logo.png").getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT));
        JLabel picLabel = new JLabel(imageIcon);
        picLabel.setIcon(imageIcon);

        leftPanel.add(picLabel);
        return leftPanel;
    }
    static JPanel getRightPanel() {
        rightPanel = new JPanel(new GridBagLayout());
        rightPanel.setBackground(Color.decode("#4285F4"));

        JLabel jLabel = new JLabel("Student Management System");
        jLabel.setFont(new Font("Google Sans", Font.BOLD, 32));
        jLabel.setForeground(Color.WHITE);

        rightPanel.add(jLabel);
        return rightPanel;
    }

}

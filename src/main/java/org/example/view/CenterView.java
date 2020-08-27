package org.example.view;


import org.example.modal.repo.Crud;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.MouseInputAdapter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.MouseEvent;

public class CenterView {
    private static JTextField jtf;
    public static JTable jTable;
    public static JScrollPane jScrollPane;
    private static TableRowSorter<DefaultTableModel> sorter;
    public static DefaultTableModel model;

    public static JPanel getJScrollPane() throws Exception {
        JPanel jPanel = new JPanel(new BorderLayout());
        jtf = new JTextField(15);
        jTable = new JTable();
        jScrollPane = new JScrollPane();
        model = new DefaultTableModel(new Object[][]{}, new String[]{"First Name", "Last Name", "Registration Number(PK)"});
        jTable.addMouseListener(new MouseInputAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                jTableMouseClicked(e);

            }
        });
        Crud.makeModel();
        jTable.setModel(model);
        jScrollPane = new JScrollPane(jTable);
        sorter = new TableRowSorter<>(model);
        jTable.setRowSorter(sorter);

        jtf.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                search(jtf.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                search(jtf.getText());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                search(jtf.getText());
            }

            public void search(String str) {
                if (str.length() == 0) {
                    sorter.setRowFilter(null);
                } else {
                    sorter.setRowFilter(RowFilter.regexFilter(str));
                }
            }
        });

        jPanel.add(jtf, BorderLayout.NORTH);
        jPanel.add(jScrollPane, BorderLayout.CENTER);
        return jPanel;
    }

    private static void jTableMouseClicked(MouseEvent evt) {
        int i = jTable.getSelectedRow();
        WestView.fNameTF.setText(jTable.getValueAt(i, 0).toString());
        WestView.lNameTF.setText(jTable.getValueAt(i, 1).toString());
        WestView.regNumTF.setText(jTable.getValueAt(i, 2).toString());
    }
}

package org.example.modal.repo;


import org.example.modal.db.Database;
import org.example.modal.pojo.User;
import org.example.view.CenterView;
import org.example.view.WestView;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Crud {
    public static Statement statement;

    public static void delete() throws Exception {
        int i = CenterView.jTable.getSelectedRow();

        if (i >= 0) {

            int option = JOptionPane.showConfirmDialog(JOptionPane.getRootFrame(),
                    "Are you sure you want to Delete?", "Delete confirmation", JOptionPane.YES_NO_OPTION);
            if (option == 0) {
                TableModel model = CenterView.jTable.getModel();
                String id = model.getValueAt(i, 2).toString();
                if (CenterView.jTable.getSelectedRows().length == 1) {
                    String sql = "DELETE FROM `student` WHERE id_number='" + id + "'";
                    statement.execute(sql);
                    DefaultTableModel model1 = (DefaultTableModel) CenterView.jTable.getModel();
                    model1.setRowCount(0);
                    makeModel();
                    clear();
                    alert("Deleted successfully");
                }
            }
        } else {
            alert("Please select a row to delete");
        }

    }

    public static void insert(String fname, String lname, String id) throws SQLException {

        if (!fname.isEmpty() && !lname.isEmpty() && !id.isEmpty()) {
            String sql = "select * from student where id_number='" + id + "'";
            ResultSet rs = statement.executeQuery(sql);
            if (!rs.first()) {

                sql = "INSERT INTO `student`(`fname`, `lname`, `id_number`) VALUES ('" + fname + "', '" + lname + "', '" + id + "')";
                statement.executeUpdate(sql);

                DefaultTableModel model = (DefaultTableModel) CenterView.jTable.getModel();
                Object[] row = new Object[4];
                row[0] = fname;
                row[1] = lname;
                row[2] = id;
                model.addRow(row);
                alert("Inserted successfully");
                clear();
            } else {
                alert("Please provide a different id number", "Similar id found");
            }

        } else {
            alert("please fill in all the details");
        }

    }

    public static void update(String fname, String lname, String id) throws Exception {
        if (!fname.isEmpty() && !lname.isEmpty() && !id.isEmpty()) {
            String sql = "select * from student where id_number='" + id + "'";
            ResultSet rs = statement.executeQuery(sql);
            if (rs.first()) {
                sql = "UPDATE `student` SET fname='" + fname + "',lname='" + lname + "'WHERE id_number='" + id + "'";
                statement.execute(sql);
                DefaultTableModel model = (DefaultTableModel) CenterView.jTable.getModel();
                model.setRowCount(0);
                makeModel();
                alert("Update was successful");
                clear();
            } else {
                alert("There is no such student", "Update error");
            }
        } else {
            alert("There is nothing to update :(","No row selected");
        }
    }


    public static void makeModel() throws Exception {
        String sql = "SELECT * FROM student";
        ResultSet resultSet = statement.executeQuery(sql);

        List<User> students = new ArrayList<>();
        while (resultSet.next()) {
            User user = new User(resultSet.getString(2), resultSet.getString(3), resultSet.getString(4));
            students.add(user);
        }
        // CenterView.model = (DefaultTableModel) CenterView.jTable.getModel();

        for (User user : students) {

            Object[] row = new Object[4];
            row[0] = user.getFname();
            row[1] = user.getLname();
            row[2] = user.getId();
            CenterView.model.addRow(row);
        }

    }


    public static void alert(String msg, String title) {
        JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), msg, title, JOptionPane.ERROR_MESSAGE);
    }

    public static void alert(String msg) {
        JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), msg);
    }
    static void clear() {
        WestView.fNameTF.setText("");
        WestView.lNameTF.setText("");
        WestView.regNumTF.setText("");
    }
    static {
        try {
            Crud.statement = Database.getConnection().createStatement();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}

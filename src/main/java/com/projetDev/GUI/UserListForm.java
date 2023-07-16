package com.projetDev.GUI;

import com.projetDev.controller.UserControllerImpl;
import com.projetDev.database.DbConnection;
import com.projetDev.model.User;
import com.projetDev.model.UserTableModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.List;

public class UserListForm implements ActionListener {
    private JPanel rootPanel;
    private JTable table1;
    private JButton deleteButton;

    private static final Logger logger = LoggerFactory.getLogger(ActivityForm.class);

    public UserListForm() {

        SwingUtilities.invokeLater(
                new Runnable() {
                    @Override
                    public void run() {
                        AbstractTableModel model = getAbModel();
                        table1.setModel(model);
                        logger.info("User get all");
                    }
                }
        );
        deleteButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String commande = e.getActionCommand();
        if (commande.equals("Delete")) {
            try (DbConnection dbConnection = new DbConnection("feliciencourdesse", "yqJBSTE2qwDcemEh")) {
                UserControllerImpl userController = new UserControllerImpl(dbConnection.getUserRepository());
                userController.deleteUser(table1.getModel().getValueAt(table1.getSelectedRow(), 0).toString());
                table1.setModel(getAbModel());
            } catch (Exception exception) {
                logger.error("An error occurred during delete user ==> {}", exception.toString());
            }
        }
    }

    public JPanel getRootPanel() {
        return rootPanel;
    }

    public AbstractTableModel getAbModel() {
        List<User> users = Collections.emptyList();
        try (DbConnection dbConnection = new DbConnection("feliciencourdesse", "yqJBSTE2qwDcemEh")) {
            UserControllerImpl userController = new UserControllerImpl(dbConnection.getUserRepository());
            users = userController.getAll();
        } catch (Exception exception) {
            logger.error("An error occurred during getAll user ==> {}", exception.toString());
        }
        return new UserTableModel(users);
    }
}



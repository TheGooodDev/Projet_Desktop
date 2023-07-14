package com.projetDev.GUI;

import com.projetDev.controller.UserControllerImpl;
import com.projetDev.database.DbConnection;
import com.projetDev.model.User;
import com.projetDev.model.UserTableModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.List;

public class UserListForm implements ActionListener {
    private JPanel rootPanel;
    private JTable table1;

    private static final Logger logger = LoggerFactory.getLogger(ActivityForm.class);

    public UserListForm() {

        SwingUtilities.invokeLater(
                new Runnable() {
                    @Override
                    public void run() {
                        try (DbConnection dbConnection = new DbConnection("feliciencourdesse", "yqJBSTE2qwDcemEh")) {
                            UserControllerImpl userController = new UserControllerImpl(dbConnection.getUserRepository());
                            List<User> users = userController.getAll();
                            UserTableModel model = new UserTableModel(users);
                            table1.setModel(model);
                            logger.info("User saved");
                        } catch (Exception exception) {
                            logger.error("An error occurred during saving user ==> {}", exception.toString());
                        }
                    }
                }
        );


    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public JPanel getRootPanel() {
        return rootPanel;
    }


}

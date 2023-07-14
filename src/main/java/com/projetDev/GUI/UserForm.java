package com.projetDev.GUI;

import com.projetDev.controller.ActivityControllerImpl;
import com.projetDev.controller.UserControllerImpl;
import com.projetDev.database.DbConnection;
import com.projetDev.model.Activity;
import com.projetDev.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

public class UserForm implements ActionListener {
    private JPanel rootPanel;
    private JTextField FirstName;
    private JTextField name;
    private JTextField year;
    private JTextField month;
    private JTextField day;
    private JComboBox genreSelect;
    private JButton createUserButton;
    private static final Logger logger = LoggerFactory.getLogger(ActivityForm.class);

    public UserForm() {
        createUserButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String commande = e.getActionCommand();
        if (commande.equals("Save")) {
            try (DbConnection dbConnection = new DbConnection("feliciencourdesse", "yqJBSTE2qwDcemEh")) {
                User user = new User(
                        name.getText(),
                        FirstName.getText(),
                        new SimpleDateFormat("yyyy/MM/dd", java.util.Locale.ENGLISH).parse(year.getText() + "/" + month.getText() + "/" + day.getText()),
                        genreSelect.getSelectedItem().toString()
                );
                logger.info("User created");
                UserControllerImpl userController = new UserControllerImpl(dbConnection.getUserRepository());
                userController.saveUser(user);
                logger.info("User saved");
            } catch (Exception exception) {
                logger.error("An error occurred during saving user ==> {}", exception.toString());
            }
        } else if (commande.equals("Cancel")) {
            // action liée au bouton cancel
        }
    }

    public JPanel getRootPanel() {
        return rootPanel;
    }
}

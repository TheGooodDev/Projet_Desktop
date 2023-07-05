package com.projetDev.GUI;

import com.projetDev.controller.ActivityControllerImpl;
import com.projetDev.database.DbConnection;
import com.projetDev.model.Activity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class ActivityForm implements ActionListener {


    private JComboBox comboBox1;
    private JButton saveButton;
    private JPanel rootPanel;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField Month;
    private JTextField Day;
    private JTextField Year;
    private DbConnection dbConnection;

    public ActivityForm() {
        saveButton.addActionListener(this);

    }

    private static final Logger logger = LoggerFactory.getLogger(ActivityForm.class);

    @Override
    public void actionPerformed(ActionEvent e) {
        String commande = e.getActionCommand();
        if (commande.equals("Save")) {
            try (DbConnection dbConnection = new DbConnection("feliciencourdesse", "yqJBSTE2qwDcemEh")) {


                Activity activity = new Activity(
                        textField1.getText(),
                        Integer.parseInt(textField2.getText()),
                        Integer.parseInt(comboBox1.getSelectedItem().toString()),
                        new SimpleDateFormat("yyyy/MM/dd", java.util.Locale.ENGLISH).parse(Year.getText() + "/" + Month.getText() + "/" + Day.getText())
                        );
                logger.info("Activity created");
                ActivityControllerImpl activityController = new ActivityControllerImpl(dbConnection.getActivityRepository());
                activityController.saveActivity(activity);
                logger.info("Activity saved");
            } catch (Exception exception) {
                logger.error("An error occurred during saving activity ==> {}", exception.toString());
            }
        } else if (commande.equals("Cancel")) {
            // action liée au bouton cancel
        }
    }

    public JPanel getRootPanel() {
        return rootPanel;
    }
}

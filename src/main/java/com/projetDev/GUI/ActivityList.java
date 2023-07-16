package com.projetDev.GUI;

import com.projetDev.controller.ActivityControllerImpl;
import com.projetDev.database.DbConnection;
import com.projetDev.model.Activity;
import com.projetDev.model.ActivityTableModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ActivityList implements ActionListener {
    private JPanel rootPanel;
    private JTable table1;

    private static final Logger logger = LoggerFactory.getLogger(ActivityForm.class);

    public ActivityList() {

        SwingUtilities.invokeLater(
                new Runnable() {
                    @Override
                    public void run() {
                        try (DbConnection dbConnection = new DbConnection("feliciencourdesse", "yqJBSTE2qwDcemEh")) {
                            ActivityControllerImpl activityController = new ActivityControllerImpl(dbConnection.getActivityRepository());
                            List<Activity> activities = activityController.getAll();
                            ActivityTableModel model = new ActivityTableModel(activities);
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
    public void actionPerformed(ActionEvent e) {}

    public JPanel getRootPanel() {
        return rootPanel;
    }

}

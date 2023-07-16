package com.projetDev.GUI;

import com.projetDev.controller.ActivityControllerImpl;
import com.projetDev.database.DbConnection;
import com.projetDev.model.Activity;
import com.projetDev.model.StatisticsTableModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class StatisticListForm implements ActionListener {
    private JPanel rootPanel;
    private JTable table1;

    private static final Logger logger = LoggerFactory.getLogger(StatisticListForm.class);

    public StatisticListForm() {

        SwingUtilities.invokeLater(
                new Runnable() {
                    @Override
                    public void run() {
                        try (DbConnection dbConnection = new DbConnection("feliciencourdesse", "yqJBSTE2qwDcemEh")) {
                            ActivityControllerImpl activityController = new ActivityControllerImpl(dbConnection.getActivityRepository());
                            List<Activity> activities = activityController.getThisWeek();
                            List<Activity> allActivities = activityController.getAll();
                            StatisticsTableModel model = new StatisticsTableModel(activities, allActivities);
                            table1.setModel(model);
                            logger.info("Got statistics");
                        } catch (Exception exception) {
                            logger.error("An error occurred during fetching statistics ==> {}", exception.toString());
                        }
                    }
                }
        );

        table1.setDefaultRenderer(Object.class, new DefaultTableCellRenderer(){
            @Override
            public Component getTableCellRendererComponent(JTable table,
                                                           Object value, boolean isSelected, boolean hasFocus, int row, int col) {

                super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col);

                int chargeTotale = (int)table.getModel().getValueAt(row,0);
                String monotonie = (String)table.getModel().getValueAt(row, 1);
                String contrainte =(String)table.getModel().getValueAt(row,2);
                String fitness = (String)table.getModel().getValueAt(row,3);
                int rca = (int)table.getModel().getValueAt(row,4);

                monotonie = monotonie.replace(",",".");
                contrainte = contrainte.replace(",",".");
                fitness = fitness.replace(",",".");
                if (Double.parseDouble(monotonie)  < 2 && Double.parseDouble(contrainte) < 6000 && rca > 0.8 && rca < 1.3 ) {
                    setBackground(Color.GREEN);
                    setForeground(Color.BLACK);
                } else if (Double.parseDouble(monotonie) > 2 && Double.parseDouble(monotonie) < 2.5 || Double.parseDouble(contrainte) > 10000 && Double.parseDouble(contrainte) < 6000 ) {
                    setBackground(Color.ORANGE);
                    setForeground(Color.BLACK);
                } else if (Double.parseDouble(monotonie) > 2.5 || Double.parseDouble(contrainte) > 10000 || rca > 1.5 ) {
                    setBackground(Color.RED);
                    setForeground(Color.BLACK);
                } else {
                    setBackground(table.getBackground());
                    setForeground(table.getForeground());
                }
                return this;
            }
        });

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public JPanel getRootPanel() {
        return rootPanel;
    }


}

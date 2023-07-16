package com.projetDev;

import com.projetDev.GUI.ActivityForm;
import com.projetDev.GUI.StatisticListForm;
import com.projetDev.GUI.UserForm;
import com.projetDev.GUI.UserListForm;
import com.projetDev.database.DbConnection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window extends JFrame{
    private static final Logger logger = LoggerFactory.getLogger(Window.class);
    private static DbConnection dbConnection;
    public Window() {
        super("Projet Dev");
        Container cp = this.getContentPane();
        setBounds(0,0, 800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JMenuBar menuBar = new JMenuBar();
        JMenu user = new JMenu("User");
        JMenuItem addUser = new JMenuItem("Add User");
        user.add(addUser);
        addUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearContainer(cp);
                JPanel rootPanel = new UserForm().getRootPanel();
                cp.add(rootPanel);
            }
        });
        JMenuItem listUser = new JMenuItem("List User");
        user.add(listUser);
        listUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearContainer(cp);
                JPanel rootPanel = new UserListForm().getRootPanel();
                cp.add(rootPanel);
            }
        });
        JMenu activity = new JMenu("Activity");
        JMenuItem addActivity = new JMenuItem("Add Activity");
        activity.add(addActivity);
        addActivity.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearContainer(cp);
                JPanel rootPanel = new ActivityForm().getRootPanel();
                cp.add(rootPanel);
            }
        });
        JMenu statistics = new JMenu("Statistics");
        JMenuItem listStatistics = new JMenuItem("List Statistics");
        statistics.add(listStatistics);
        listStatistics.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearContainer(cp);
                JPanel rootPanel = new StatisticListForm().getRootPanel();
                cp.add(rootPanel);
            }
        });
        menuBar.add(user);
        menuBar.add(activity);
        menuBar.add(statistics);

        this.setJMenuBar(menuBar);
        setVisible(true);
    }

    class ButtonListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            String commande = e.getActionCommand();
            if (commande.equals("Save")) {
                // action liée au bouton save
            }
            else if (commande.equals("Cancel")) {
                // action liée au bouton cancel
            }
        }
    }

    public static void main(String[] args) {
        dbConnection = new DbConnection("feliciencourdesse", "yqJBSTE2qwDcemEh");
        JFrame frame = new Window();
    }

    public void clearContainer(Container cp) {
        cp.removeAll();
        cp.revalidate();
        cp.repaint();
    }
}


package com.projetDev.model;

import com.projetDev.controller.ActivityControllerImpl;

import javax.swing.table.AbstractTableModel;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.List;


import static java.lang.Math.round;

public class StatisticsTableModel extends AbstractTableModel {

    List<Activity> activityList;
    List<Activity> allActivityList;
    String headerList[] = new String[]{"CHARGE TOTALE", "MONOTONIE", "CONTRAINTE", "FITNESS", "RCA"};

    public StatisticsTableModel(List<Activity> list, List<Activity> allList) {
        activityList = list;
        allActivityList = allList;
    }

    @Override
    public int getColumnCount() {
        return 5;
    }


    @Override
    public int getRowCount() {
        return activityList.size();
    }

    // this method is called to set the value of each cell
    @Override
    public Object getValueAt(int row, int column) {
        int chargeTotale = 0;
        String monotonie = "";
        String contrainte = "";
        String fitness = "";
        int rca = 0;
        Activity entity = null;
        entity = activityList.get(row);
        DecimalFormat df = new DecimalFormat("0.00");

        switch (column) {
            case 0:
                for (Activity activity : activityList) {
                    chargeTotale += activity.getCharge();
                }
                return chargeTotale;
            case 1:
                monotonie = df.format(getSD(activityList));
                return monotonie;
            case 2:
                contrainte = df.format(entity.getCharge() *  getSD(activityList));
                return contrainte;
            case 3:
                fitness = df.format(entity.getCharge() - entity.getCharge() *  getSD(activityList));
                return fitness;
            case 4:
                rca = getRCA(activityList, allActivityList);
                return rca;
            default:
                return "";
        }
    }

    private int getRCA(List<Activity> activityList, List<Activity> allActivityList){
        int chargeAiguë=0;
        int chargeChronique=0;
        Calendar calendar = Calendar.getInstance();
        int weekNumber = calendar.get(Calendar.WEEK_OF_YEAR);
        int count=0;

        for (Activity activity : activityList) {
            chargeAiguë+=activity.getCharge();
        }


        for (Activity tempActivity : allActivityList) {
            Calendar tempCalendar = Calendar.getInstance();
            tempCalendar.setTime(tempActivity.getPublishedDate());
            for(int i=weekNumber-4;i<weekNumber;i++){
                if(tempCalendar.get(Calendar.WEEK_OF_YEAR)==i){
                    chargeChronique+=tempActivity.getCharge();
                    count++;
                }
            }
        }

        chargeChronique=chargeChronique/count;
        return chargeAiguë/chargeChronique;
    }

    private Double getSD(List<Activity> activityList){
        int moyenne = 0;
        double sd = 0;
        for (Activity activity : activityList) {
            moyenne += activity.getCharge();
        }
        if(activityList.size()!=0 && moyenne !=0) {
            moyenne = moyenne / activityList.size();
        }
        for (int i = 0; i < activityList.size(); i++) {
            sd = sd + Math.pow((activityList.get(i).getCharge() - moyenne), 2);
        }
        if(Math.sqrt(sd / activityList.size())!=0) {
            return (moyenne / Math.sqrt(sd / activityList.size()));
        } else {
            return 0.0;
        }
    };

    //This method will be used to display the name of columns
    public String getColumnName(int col) {
        return headerList[col];
    }
}

package com.projetDev.model;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class ActivityTableModel extends AbstractTableModel {

    List<Activity> activities;

    String[] headers = new String[]{"NAME", "DURATION", "RPE", "CHARGE", "DATE"};

    public ActivityTableModel(List<Activity> activities) {
        this.activities = activities;
    }

    @Override
    public int getRowCount() {
        return activities.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Activity entity = null;
        entity = activities.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return entity.getName();
            case 1:
                return entity.getDuration();
            case 2:
                return entity.getRpe();
            case 3:
                return entity.getCharge();
            case 4:
                return entity.getPublishedDate();
            default:
                return "";
        }
    }

    public String getColumnName(int col) {
        return headers[col];
    }
}

package com.projetDev.model;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class UserTableModel extends AbstractTableModel {

    List<User> wordsList;
    String headerList[] = new String[]{"NAME", "FIRSTNAME", "GENRE", "BIRTHDATE"};

    public UserTableModel(List<User> list) {
        wordsList = list;
    }

    @Override
    public int getColumnCount() {
        return 5;
    }


    @Override
    public int getRowCount() {
        return wordsList.size();
    }

    // this method is called to set the value of each cell
    @Override
    public Object getValueAt(int row, int column) {
        User entity = null;
        entity = wordsList.get(row);

        switch (column) {
            case 1:
                return entity.getName();
            case 2:
                return entity.getFirstName();
            case 3:
                return entity.getGenre();
            case 4:
                return entity.getBirthDate();
            default:
                return "";
        }
    }


    //This method will be used to display the name of columns
    public String getColumnName(int col) {
        return headerList[col];
    }
}

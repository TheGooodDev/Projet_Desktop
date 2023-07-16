package com.projetDev.model;

import com.projetDev.GUI.ActivityForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.xml.crypto.Data;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;


public class UserTableModel extends AbstractTableModel {
    private static final Logger logger = LoggerFactory.getLogger(ActivityForm.class);

    List<User> wordsList;
    String headerList[] = new String[]{"NAME", "FIRSTNAME", "GENRE", "AGE"};

    public UserTableModel(List<User> list) {
        wordsList = list;
    }

    @Override
    public int getColumnCount() {
        return 4;
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
            case 0:
                return entity.getName();
            case 1:
                return entity.getFirstName();
            case 2:
                return entity.getGenre();
            case 3:
                return calculateAge(convertToLocalDateViaInstant(entity.getBirthDate()),LocalDate.now());
            default:
                return "";
        }
    }


    //This method will be used to display the name of columns
    public String getColumnName(int col) {
        return headerList[col];
    }

    public int calculateAge(
            LocalDate birthDate,
            LocalDate currentDate) {
        // validate inputs ...
        return Period.between(birthDate, currentDate).getYears();
    }

    public LocalDate convertToLocalDateViaInstant(Date dateToConvert) {
        return dateToConvert.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
    }

}

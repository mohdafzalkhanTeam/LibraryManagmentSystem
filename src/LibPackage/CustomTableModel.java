/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LibPackage;

/**
 *
 * @author moham
 */
import javax.swing.table.AbstractTableModel;
import java.sql.*;
import java.text.SimpleDateFormat;

import javax.swing.table.AbstractTableModel;
import java.sql.*;
import java.text.SimpleDateFormat;

public class CustomTableModel extends AbstractTableModel {

    private ResultSet resultSet;
    private ResultSetMetaData metaData;
    private int rowCount;
    
    public CustomTableModel(ResultSet resultSet) throws SQLException {
        this.resultSet = resultSet;
        this.metaData = resultSet.getMetaData();
        this.resultSet.last(); // Move to the last row
        this.rowCount = resultSet.getRow(); // Get the row count
        resultSet.beforeFirst(); // Move back to the first row
    }
    
    @Override
    public int getRowCount() {
        return rowCount;
    }

    @Override
    public int getColumnCount() {
        try {
            return metaData.getColumnCount();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        try {
            resultSet.absolute(rowIndex + 1); // Move to the correct row
            Object value = resultSet.getObject(columnIndex + 1);
            
            // Format date columns
            if (value instanceof Date) {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                value = dateFormat.format((Date) value);
            } else if (value instanceof Timestamp) {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                value = dateFormat.format((Timestamp) value);
            }

            return value;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        try {
            return metaData.getColumnName(column + 1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return super.getColumnName(column);
    }
}

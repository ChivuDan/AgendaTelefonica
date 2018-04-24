/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication3.controller;

import javaapplication3.model.Abonat;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javaapplication3.util.Constants;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Chivu
 */
public class DeleteButtonEditor extends DefaultCellEditor {

    private DataAccess transmitor = new DataAccess();
    private int row;
    private int column;
    private JTable table;

    protected JButton button;

    private String label = "Delete";

    private boolean isPushed;

    public DeleteButtonEditor(JCheckBox checkBox) {
        super(checkBox);
        button = new JButton();
        button.setOpaque(true);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                fireEditingStopped();
            }
        });
    }

    public Component getTableCellEditorComponent(JTable table, Object value,
            boolean isSelected, int row, int column) {

        if (isSelected) {
            button.setForeground(table.getSelectionForeground());
            button.setBackground(table.getSelectionBackground());
        } else {
            button.setForeground(table.getForeground());
            button.setBackground(table.getBackground());
        }
        if (row == 0) {
            this.button.setText("Filter");
        } else {
            this.button.setText("Delete");
        }
        this.row = row;
        this.column = column;
        this.table = table;
        isPushed = true;
        return button;
    }

    private void delete() throws Exception {

        DefaultTableModel dt = ((DefaultTableModel) this.table.getModel());

        Integer.parseInt(dt.getValueAt(row, 0).toString());
        transmitor.deleteAbonat(Integer.parseInt(dt.getValueAt(row, 0).toString()));
        dt.removeRow(this.row);

        // JOptionPane.showMessageDialog(button, " am șters ceva");
    }

    private void filter() throws Exception {
        Abonat filtru = TabelAfisat.filtru;
        DefaultTableModel dt = ((DefaultTableModel) this.table.getModel());
        Object id = dt.getValueAt(row, 0);
        if (id != null && Constants.isNumeric(id.toString())) {
            filtru.setId(Integer.parseInt(dt.getValueAt(row, 0).toString()));
        }
        else {
            filtru.setId(null);
        }

        filtru.setNume((String) dt.getValueAt(row, 1));
        filtru.setPrenume((String) dt.getValueAt(row, 2));
        filtru.setNrTel((String) dt.getValueAt(row, 3));
        filtru.setTipNumar((String) dt.getValueAt(row, 4));
        filtru.setCNP((String) dt.getValueAt(row, 5));

        TabelAfisat.afiseaza(table, SortingListener.colOrd, SortingListener.isSortAsc);
    }

    public Object getCellEditorValue() {
        if (isPushed) {
            // 
            // 

            // System.out.println(label + ": Ouch!");
        }
        isPushed = false;
        return new String(label);
    }

    public boolean stopCellEditing() {

        return super.stopCellEditing();
    }

    protected void fireEditingStopped() {

        super.fireEditingStopped();
        if (this.row == 0) {
            try {
                this.filter();
            } catch (Exception ex) {
                Logger.getLogger(DeleteButtonEditor.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                this.delete();

            } catch (Exception ex) {
                Logger.getLogger(DeleteButtonEditor.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}

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
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class EditButtonEditor extends DefaultCellEditor {

    private int row;
    private int column;
    private JTable table;
    private DataAccess dataAccessVariable = new DataAccess();

    protected JButton button;

    private String label = "Edit";

    private boolean isPushed;

    public EditButtonEditor(JCheckBox checkBox) {
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
            this.button.setText("Add");
        } else {
            this.button.setText("Edit");
        }
        this.row = row;
        this.column = column;
        this.table = table;
        isPushed = true;
        return button;

    }

    private void add() throws Exception {
        Abonat transmitator = new Abonat();
        DefaultTableModel dt = ((DefaultTableModel) this.table.getModel());
        transmitator.setNume(dt.getValueAt(row, 1).toString());
        transmitator.setPrenume(dt.getValueAt(row, 2).toString());
        transmitator.setNrTel(dt.getValueAt(row, 3).toString());
        transmitator.setTipNumar(dt.getValueAt(row, 4).toString());
        transmitator.setCNP(dt.getValueAt(row, 5).toString());
        
        try {
            dataAccessVariable.insertAbonat(transmitator);
            
            TabelAfisat.afiseaza(table, SortingListener.colOrd, SortingListener.isSortAsc);
        } catch (Exception ex) {
            Logger.getLogger(EditButtonEditor.class.getName()).log(Level.SEVERE, null, ex);
        }

       JOptionPane.showMessageDialog(button, " am adaugat ceva");
    }

    private void edit() throws Exception {
        Abonat transmitator = new Abonat();
        DefaultTableModel dt = ((DefaultTableModel) this.table.getModel());
        transmitator.setId(Integer.parseInt(dt.getValueAt(row, 0).toString()));
        transmitator.setNume(dt.getValueAt(row, 1).toString());
        transmitator.setPrenume(dt.getValueAt(row, 2).toString());
        transmitator.setNrTel(dt.getValueAt(row, 3).toString());
        transmitator.setTipNumar(dt.getValueAt(row, 4).toString());
        transmitator.setCNP(dt.getValueAt(row, 5).toString());

        dataAccessVariable.updateAbonat(transmitator);
        TabelAfisat.afiseaza(table, SortingListener.colOrd, SortingListener.isSortAsc);
     
       // updateAbonat();

       // JOptionPane.showMessageDialog(button, " am modificat ceva");

    }

    public Object getCellEditorValue() {
        if (isPushed) {
            // 
            // 
            // System.out.println(label + ": Ouch!");
            //  Abonat intrare = new Abonat();
            // DefaultTableModel dt = ((DefaultTableModel)this.table.getModel());
            // intrare.setId((int) dt.getValueAt(row, 0).toString());
            //  intrare.setNume(dt.getValueAt(row , 1).toString());

            // JOptionPane.showMessageDialog(button, "Intrarea " +((DefaultTableModel)this.table.getModel()).getValueAt(row, 1) + " a fost modificata!");
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
                this.add();
            } catch (Exception ex) {
                Logger.getLogger(EditButtonEditor.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                this.edit();
            } catch (Exception ex) {
                Logger.getLogger(EditButtonEditor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println(((DefaultTableModel) this.table.getModel()).getValueAt(row, 0));

    }
}

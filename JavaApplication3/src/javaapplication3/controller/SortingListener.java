/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication3.controller;

import javaapplication3.controller.DataAccess;
import javaapplication3.model.Abonat;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author Chivu
 */
public class SortingListener extends MouseAdapter {

    protected JTable table;
    static public Boolean isSortAsc = true;
    static public String colOrd = "id";

    public SortingListener(JTable t) {
        table = t;
    }

    public void mouseClicked(MouseEvent e) {
        DataAccess deListat = new DataAccess();
        List<Abonat> lista;
        TableColumnModel colModel = table.getColumnModel();

        int columnModelIndex = colModel.getColumnIndexAtX(e.getX());

        int modelIndex = colModel.getColumn(columnModelIndex).getModelIndex();

        try {
            String colOrd = "id";
            switch (modelIndex) {
                case 0:
                    colOrd = "id";
                    break;
                case 1:
                    colOrd = "nume";
                    break;
                case 2:
                    colOrd = "prenume";
                    break;
                case 3:
                    colOrd = "\"nrTel\"";
                    break;
                //case 4: lista = deListat.selectAbonat("tipAbonat", true);
                //   break;
                case 5:
                    colOrd = "cnp";
                    break;
                default:
                    colOrd = "id";
                    break;
            }

            if (colOrd == this.colOrd) {
                isSortAsc = !isSortAsc;
            } else {
                isSortAsc = true;
            }
            this.colOrd = colOrd;
            String sql = null;

            TabelAfisat.afiseaza(table, colOrd, isSortAsc);
            
        } catch (Exception ex) {
            Logger.getLogger(SortingListener.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

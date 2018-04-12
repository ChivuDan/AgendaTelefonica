/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication3;

import java.util.List;
import java.util.Map;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Chivu
 */
public class TabelAfisat {

    public static void afiseaza(JTable table, String colOrd, boolean isSortAsc, Map <String, String> filter ) throws Exception {
        DataAccess deListat = new DataAccess();
        String sql = null;
        List<Abonat> lista = deListat.selectAbonat(colOrd, isSortAsc, filter);

        Object[][] tabel = new Object[lista.size() + 1][];
        if (lista.size() == 0) {
            tabel = new Object[1][];
        }
        tabel[0] = new Object[7];
        for (int i = 1; i <= lista.size(); i++) {
            Abonat row = lista.get(i - 1);
            tabel[i] = new Object[7];
            tabel[i][0] = String.valueOf(row.getId());
            tabel[i][1] = row.getNume();
            tabel[i][2] = row.getPrenume();
            tabel[i][3] = row.getNrTel();
            tabel[i][4] = row.getTipNumar();
            tabel[i][5] = row.getCNP();
        }

        DefaultTableModel dt = new javax.swing.table.DefaultTableModel(
                tabel,
                new String[]{
                    "ID", "Nume", "Prenume", "Numar Telefon", "Tip Abonat", "CNP", "x", "y"
                }
        );

        table.setModel(dt);
        table.getColumn("x").setCellRenderer(new DeleteButtonRenderer());
        table.getColumn("x").setCellEditor(new DeleteButtonEditor(new JCheckBox()));
        table.getColumn("y").setCellRenderer(new EditButtonRenderer());
        table.getColumn("y").setCellEditor(new EditButtonEditor(new JCheckBox()));

        table.getTableHeader().repaint();
        //  JOptionPane.showMessageDialog(this.table, "Intrarea " + modelIndex + this.isSortAsc + " a fost modificata!");

        table.repaint();
    }
}

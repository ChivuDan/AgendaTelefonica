/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication3;

import java.util.HashMap;
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

    static Abonat filtru = new Abonat();

    public static void afiseaza(JTable table, String colOrd, boolean isSortAsc) throws Exception {
        DataAccess deListat = new DataAccess();
        String sql = null;
        Map<String, String> filter = TabelAfisat.getFilter();
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

        tabel[0][0] = filtru.getId() != null ? String.valueOf(filtru.getId()) : null;
        tabel[0][1] = filtru.getNume();
        tabel[0][2] = filtru.getPrenume();
        tabel[0][3] = filtru.getNrTel();
        tabel[0][4] = filtru.getTipNumar();
        tabel[0][5] = filtru.getCNP();

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

    public static Map<String, String> getFilter() {
        Map<String, String> filter = new HashMap<>();

        if (filtru.getId() != null) {
            filter.put("id", String.valueOf(filtru.getId()));
        }

        if (filtru.getNume() != null) {
            filter.put("nume", filtru.getNume());
        }

        if (filtru.getPrenume() != null) {
            filter.put("prenume", filtru.getPrenume());
        }

        if (filtru.getCNP() != null) {
            filter.put("cnp", filtru.getCNP());
        }

        if (filtru.getNrTel() != null) {
            filter.put("\"nrTel\"", filtru.getNrTel());
        }

        return filter;
    }
}

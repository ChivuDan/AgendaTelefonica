/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication3.view;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javaapplication3.controller.SaveAction;
import javaapplication3.controller.SortingListener;
import javaapplication3.controller.TabelAfisat;
import javaapplication3.util.Constants;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.xml.ws.Action;

/**
 *
 * @author Chivu
 */
public class JFrame2 extends javax.swing.JFrame {

    private Component button;

    /**
     * Creates new form NewJFrame
     */
    public JFrame2() {
        try {
            initComponents();
        } catch (Exception ex) {
            Logger.getLogger(JFrame2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")

    private void initComponents() throws Exception {

        reclamaPanel = new javax.swing.JPanel();
        reclamaScrollPane = new javax.swing.JScrollPane();
        textAreaReclama = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        openMenuItem = new javax.swing.JMenuItem();
        saveMenuItem = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        exitMenuItem = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        inregistrareMenuItem = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        aboutMenuItem = new javax.swing.JMenuItem();
        jMenu1.setText("File");

        openMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        openMenuItem.setEnabled(false);
        openMenuItem.setText("Open");
        openMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openAction(evt);
            }
        });

        jMenu1.add(openMenuItem);

        saveMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        saveMenuItem.setEnabled(false);
        saveMenuItem.setText("Save");
        saveMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveAction(evt);
            }
        });
        jMenu1.add(saveMenuItem);
        jMenu1.add(jSeparator1);

        exitMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.ALT_MASK));
        exitMenuItem.setText("Exit");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitAction(evt);
            }
        });
        jMenu1.add(exitMenuItem);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Help");

        inregistrareMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.CTRL_MASK));
        inregistrareMenuItem.setText("Inregistrare");
        inregistrareMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerAction(evt);
            }
        });
        jMenu2.add(inregistrareMenuItem);
        jMenu2.add(jSeparator2);

        aboutMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.ALT_MASK));
        aboutMenuItem.setText("About");
        aboutMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutAction(evt);
            }
        });
        jMenu2.add(aboutMenuItem);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout reclamaPanelLayout = new javax.swing.GroupLayout(reclamaPanel);
        reclamaPanel.setLayout(reclamaPanelLayout);
        reclamaPanelLayout.setHorizontalGroup(
                reclamaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 766, Short.MAX_VALUE)
        );
        reclamaPanelLayout.setVerticalGroup(
                reclamaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 112, Short.MAX_VALUE)
        );

        TabelAfisat.afiseaza(jTable1, "id", true);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        JTableHeader header = jTable1.getTableHeader();
        header.setUpdateTableInRealTime(true);
        header.addMouseListener(new SortingListener(jTable1));
        header.setReorderingAllowed(true);

        jScrollPane1.setViewportView(jTable1);

        textAreaReclama.setColumns(20);
        textAreaReclama.setRows(5);
        textAreaReclama.setText("reclama\n");
        reclamaScrollPane.setViewportView(textAreaReclama);

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Help");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(reclamaScrollPane)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 804, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 439, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(reclamaScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        timerReclame();
        pack();
        // </editor-fold>                        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(JFrame2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new JFrame2().setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(JFrame2.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    private void timerReclame() {
        ArrayList<String> places = new ArrayList<String>();
        places.add("Buenos Aires");
        places.add("Córdoba");
        places.add("La Plata");
        Timer timer = new Timer();
        Random r = new Random();
        textAreaReclama.setText(places.get(0));
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                String inMana = textAreaReclama.getText();
                places.remove(places.indexOf(inMana));
                textAreaReclama.setText(places.get(r.nextInt(1)));
                places.add(inMana);
            }

        };
        timer.schedule(timerTask, 0, 5000);
    }

    private void registerAction(ActionEvent evt) {
        String codAcces = JOptionPane.showInputDialog(this, "Introdu codul de inregistrare");
        System.out.println(codAcces);
        if (Constants.KEYS.contains(codAcces)) {
            openMenuItem.setEnabled(true);
            saveMenuItem.setEnabled(true);
            JOptionPane.showMessageDialog(this, "Ai acces!");
        } else {
            JOptionPane.showMessageDialog(this, "Ai gresit codu', băiatu' meu!");
        }

        //primeste codul, activeaza butoanele save si open
    }

    private void aboutAction(ActionEvent evt) {
        JOptionPane.showMessageDialog(this, "te-am informat, fraere!");
    }

    private void exitAction(java.awt.event.ActionEvent evt) {
        Object[] options = {"Da, va rog!",
            "Nu, m-am razgandit!",};
        int n = JOptionPane.showOptionDialog(jTable1,
                "Vrei sa inchizi aplicatia "
                + "la care am trudit?",
                "Mesaj de confirmare",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[1]);
        if (n == 0) {
            System.exit(0);

        }
    }
    //System.exit(0);

    private void saveAction(java.awt.event.ActionEvent evt) {
        SaveAction export = new SaveAction();
        export.exportToCSV(jTable1, "C:\\CSV\\a.csv");
        //pastreaza modificarile facute si le trimite in baza de date--> save to file
    }

    private void openAction(java.awt.event.ActionEvent evt) {
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "JPG & GIF Images", "jpg", "gif");
        chooser.setFileFilter(filter);
        int returnVal = chooser.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            System.out.println("You chose to open this file: "
                    + chooser.getSelectedFile().getName());
            //sa incarce ce-i in fisier si sa duca in baza de date

        }
    }

    // Variables declaration - do not modify                     
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JMenuItem inregistrareMenuItem;
    private javax.swing.JMenuItem openMenuItem;
    private javax.swing.JMenuItem saveMenuItem;
    private javax.swing.JMenuItem aboutMenuItem;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPanel reclamaPanel;
    private javax.swing.JScrollPane reclamaScrollPane;
    private javax.swing.JTextArea textAreaReclama;
    // End of variables declaration                   
}

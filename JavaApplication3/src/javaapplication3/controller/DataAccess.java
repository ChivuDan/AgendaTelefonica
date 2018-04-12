/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication3.controller;

import javaapplication3.model.Abonat;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javaapplication3.model.TipNumar;

/**
 *
 * @author Chivu
 */
public class DataAccess {

    //   public void createNewPhoneBook(CarteDeTelefon cdt) throws Exception {
    //      insertDB("INSERT INTO public.\"CarteDeTelefon\"(\n"
    //             + "	  descriere)\n"
    //              + "	VALUES ( '" + cdt.getDescriere() + "')\n"
    //              + "    ");
    //  }
    public void insertAbonat(Abonat date) throws Exception {
        updateDB("INSERT INTO public.\"Abonat\"(\n"
                + "	 nume, prenume, \"nrTel\", cnp)\n"
                + "	VALUES ('" + date.getNume() + "','" + date.getPrenume() + "', '" + date.getNrTel() + "',"
                + " '" + date.getCNP() + "');");
    }

    public void deleteAbonat(Integer id) throws Exception {
        updateDB("DELETE FROM public.\"Abonat\"\n"
                + "	WHERE id='" + id.toString() + "';");
    }

    public void updateAbonat(Abonat date) throws Exception {

        updateDB("UPDATE public.\"Abonat\"\n"
                + "	SET  nume='" + date.getNume() + "', prenume='" + date.getPrenume() + "', \"nrTel\"='" + date.getNrTel() + "', cnp='" + date.getCNP() + "'\n"
                + "	WHERE id='" + date.getId() + "';");

    }
    public List<Abonat> selectAbonat1(String colOrd, boolean isAsc, Abonat aport) throws Exception {
       
        return null;
    }
    public List<Abonat> selectAbonat(String colOrd, boolean isAsc, Map<String, String> filter) throws Exception {
        // sql = null; --> daca primeste parametrii necesari sa ruleze celalalt string sql u WHERE 
        Connection con = null;
        Statement sta = null;
        ResultSet rs = null;

        try {
            String getQuery = "SELECT id, nume, prenume, \"nrTel\", cnp\n"
                    + "	FROM public.\"Abonat\"";
            
            
           
            
            con = getConnection();
            sta = con.createStatement();

            if (filter != null && filter.keySet().size() > 0) {
                getQuery = getQuery + " WHERE";
                Set set = filter.entrySet();
                Iterator iterator = set.iterator();
                while (iterator.hasNext()) {
                    Map.Entry mentry = (Map.Entry) iterator.next();
                    getQuery = getQuery + " " + " CAST (" + mentry.getKey().toString() + " AS TEXT) LIKE  '%" + mentry.getValue().toString() + "%' ";
                    if (iterator.hasNext()) {
                        getQuery = getQuery + " AND ";
                    }
                    
                    //  AND numeVariabila LIKE CAST( numeVariabila AS TEXT);
                }
            }
            if(colOrd != null && !colOrd.equals("")){
                getQuery += " ORDER BY " + colOrd + " "+
                        (isAsc? "ASC": "DESC");
            }
            rs = sta.executeQuery(getQuery);
//            if (sql != null) {
//               rs = sta.executeQuery(("SELECT id, nume, prenume, \"nrTel\", cnp\n"
//                     + "WHERE nume LIKE 'a%' AND prenume LIKE '%'" + "	FROM public.\"Abonat\"" + " ORDER BY " + colOrd + " " + new String(isAsc ? "ASC" : "DESC") + ";"));
//            } else {
//            rs = sta.executeQuery(("SELECT id, nume, prenume, \"nrTel\", cnp\n"
//                    + "	FROM public.\"Abonat\"" + " ORDER BY " + colOrd + " " + new String(isAsc ? "ASC" : "DESC") + ";"));
//        };

            List<Abonat> selectati = new ArrayList<Abonat>();

            while (rs.next()) {
                Abonat selectat = new Abonat();
                selectat.setId(rs.getInt("id"));
                selectat.setNume(rs.getString("nume"));
                selectat.setPrenume(rs.getString("prenume"));
                selectat.setNrTel(rs.getString("nrTel"));
                selectat.setCNP(rs.getString("cnp"));
                selectati.add(selectat);
            }

            return selectati;
        } catch (Exception e) {
            System.out.println("A crapat:" + e.getMessage());
            throw e;
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (con != null) {
                con.close();
            }
            if (sta != null) {
                sta.close();
            }

        }

    }

    public void updateDB(String sql) throws Exception {

        Connection con = null;
        Statement sta = null;
        try {
            con = getConnection();
            sta = con.createStatement();

            int rowsUpdated = sta.executeUpdate(sql);

            if (rowsUpdated > 0) {
                System.out.println("An existing user was updated successfully!");
            }
        } catch (Exception e) {
            System.out.println("A crapat:" + e.getMessage());
            throw e;
        } finally {
            if (con != null) {
                con.close();
            }
            if (sta != null) {
                sta.close();
            }

        }
    }

    private Connection getConnection() throws Exception {
        String username = "postgres";
        String parola = "adastra";
        String url = "jdbc:postgresql://127.0.0.1:5432/carteDeTelefon";
        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection(
                url, username, parola);
        return connection;
    }

    public List<TipNumar> getAllPhoneTypes() {
        return null;
        //code that will retrieve all phone number types
    }
}

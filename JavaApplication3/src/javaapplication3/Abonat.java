/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication3;

/**
 *
 * @author Chivu
 */
public class Abonat {
    private Integer id;
    private String nume;
    private String prenume;
    private String CNP;
    private String nrTel;
    private String tipNumar;
    private int carteDeTelefon;

    public String getTipNumar() {
        return tipNumar;
    }

    public void setTipNumar(String tipNumar) {
        this.tipNumar = tipNumar;
    }

    public int getCarteDeTelefon() {
        return carteDeTelefon;
    }

    public void setCarteDeTelefon(int carteDeTelefon) {
        this.carteDeTelefon = carteDeTelefon;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public String getCNP() {
        return CNP;
    }

    public void setCNP(String CNP) {
        this.CNP = CNP;
    }

    public String getNrTel() {
        return nrTel;
    }

    public void setNrTel(String nrTel) {
        this.nrTel = nrTel;
    }
    
    
}

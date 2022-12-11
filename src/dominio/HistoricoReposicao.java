/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

/**
 *
 * @author diego
 */
public class HistoricoReposicao {
    private /*@ spec_public nullable @*/ String data;
    private /*@ spec_public nullable @*/ int codProd;
    private /*@ spec_public nullable @*/ int qtd;

    //@ requires data.length() == 10;
    //@ requires data.contains("/") == true;
    //@ requires 0 <= codProd;
    //@ requires 0 < qtd;
    public HistoricoReposicao(String data, int codProd, int qtd) {
        this.data = data;
        this.codProd = codProd;
        this.qtd = qtd;
    }
    
    public HistoricoReposicao(){
        
    }
   
    public /*@ pure @*/ String getData() {
        return data;
    }
    
    /**
     *@ requires data.length() == 10;
     *@ requires data.contains("/") == true;
     *@ assignable this.data;
     *@ ensures this.data.equals(data) == true;
     */ 
    public void setData(String data) {
        this.data = data;
    }

    public /*@ pure @*/ int getCodProd() {
        return codProd;
    }

    /**
     *@ requires 0 <= codProd;
     *@ assignable this.codProd;
     *@ ensures this.codProd == codProd;
     */ 
    public void setCodProd(int codProd) {
        this.codProd = codProd;
    }

    public /*@ pure @*/ int getQtd() {
        return qtd;
    }
    
    /**
     *@ requires 0 < qtd;
     *@ assignable this.qtd;
     *@ ensures this.qtd == qtd;
     */ 
    public void setQtd(int qtd) {
        this.qtd = qtd;
    }
       
}
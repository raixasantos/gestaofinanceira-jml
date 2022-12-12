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
    private /*@ spec_public @*/ int codProd = 0;
    private /*@ spec_public nullable @*/ int qtd;
    
    /*@ public invariant 0 <= codProd;
    @*/
    
    //@ requires data.length() == 10;
    //@ requires data.contains("/") == true;
    //@ requires 0 <= codProd;
    //@ requires 0 < qtd;
    //@ ensures this.data == data && this.codProd == codProd && this.qtd == qtd;
    public HistoricoReposicao(String data, int codProd, int qtd) {
        this.data = data;
        this.codProd = codProd;
        this.qtd = qtd;
    }
    
    //@ requires data.length() == 10;
    //@ requires data.contains("/") == true;
    //@ requires 0 <= codProd;
    //@ ensures this.data == data && this.codProd == codProd;
    public HistoricoReposicao(String data, int codProd) {
        this.data = data;
        this.codProd = codProd;
    }
    
    public HistoricoReposicao(){
        
    }
   
    //@ public initially 0 <= codProd;
    
    public /*@ pure @*/ String getData() {
        return data;
    }
    
    //@ requires data.length() == 10;
    //@ requires data.contains("/") == true;
    //@ assignable this.data;
    //@ ensures this.data.equals(data) == true;
    public void setData(String data) {
        this.data = data;
    }

    public /*@ pure @*/ int getCodProd() {
        return codProd;
    }
    
    /*@ public normal_behavior
    @ 	requires 0 <= codProd;
    @ 	assignable this.codProd;
    @ 	ensures this.codProd == codProd;
    @ also
    @ public exceptional_behavior
    @ 	requires 0 > codProd;
    @ 	assignable this.codProd;
    @ 	signals_only Exception;
    @*/
    public void setCodProd(int codProd) throws Exception {
    	if(codProd < 0) {
    		throw new Exception();
    	}
        this.codProd = codProd;
    }

    public /*@ pure @*/ int getQtd() {
        return qtd;
    }
    
    /*@ public normal_behavior 
    @ 	requires 0 < qtd;
    @ 	assignable this.qtd;
    @ 	ensures this.qtd == qtd;
    @ also
    @ public exceptional_behavior
    @ 	requires 0 > qtd;
    @ 	assignable this.qtd;
    @ 	signals_only Exception;
    @*/
    public void setQtd(int qtd) throws Exception {
    	if(qtd < 0) {
    		throw new Exception();
    	}
        this.qtd = qtd;
    }
       
}
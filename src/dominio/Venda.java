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
public class Venda implements IVenda {
    private /*@ spec_public @*/ int _codVenda = 0; //@ in codVenda;
    private /*@ spec_public nullable @*/ String _CPF; 	//@ in CPF;
    private /*@ spec_public nullable @*/ String _data;	//@ in data;
    private /*@ spec_public nullable @*/ String _hora;	//@ in hora;
    
    /*@ public invariant 0 <= _codVenda;
    @*/
    
    /*@ protected represents
	@ 	codVenda <- _codVenda;
	@*/
    
    /*@ protected represents
	@ 	CPF <- _CPF;
	@*/
    
    /*@ protected represents
	@ 	data <- _data;
	@*/
    
    /*@ protected represents
	@ 	hora <- _hora;
	@*/
    
    //@ requires 0 <= codVend;
    //@ requires CPF_.length() == 14;
    //@ requires CPF_.contains(".") == true;
    //@ requires CPF_.contains("-") == true;
    //@ requires dat.length() == 10;
    //@ requires dat.contains("/") == true;
    //@ requires hor.length() == 5;
    //@ requires hor.contains(":") == true;
    public Venda(int codVend, String CPF_, String dat, String hor) {
        this._codVenda = codVend;
        this._CPF = CPF_;
        this._data = dat;
        this._hora = hor;
    }
    
    public Venda() {
      
    }
    
    //@ public initially 0 <= _codVenda;

    public /*@ pure @*/ int getCodVenda() {
        return _codVenda;
    }
    
    //@ also
    //@ 	requires 0 <= codVend;
    //@ 	assignable codVenda;
    //@ 	ensures codVenda == codVend;
    public void setCodVenda(int codVend) {
        this._codVenda = codVend;
    }

    public /*@ pure @*/ String getCPF() {
        return _CPF;
    }

    /*@ also
     @ 	requires CPF_.length() == 14;
     @ 	requires CPF_.contains(".") == true;
     @ 	requires CPF_.contains("-") == true;
     @ 	assignable CPF;
     @ 	ensures CPF.equals(CPF_);
     @*/    
    public void setCPF(String CPF_) {
        this._CPF = CPF_;
    }

    public /*@ pure @*/ String getData() {
        return _data;
    }

    /*@ also
     @ requires d.length() == 10;
     @ requires d.contains("/") == true;
     @ assignable data;
     @ ensures data.equals(d);
     @
     */ 
    public void setData(String d) {
        this._data = d;
    }

    public /*@ pure @*/ String getHora() {
        return _hora;
    }


    /*@ also
     @ 	requires h.length() == 5;
     @ 	requires h.contains(":") == true;
     @ 	assignable hora;
     @ 	ensures hora.equals(h);
     @*/ 
    public void setHora(String h) {
        this._hora = h;
    }
    
}

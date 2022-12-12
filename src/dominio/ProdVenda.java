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
public class ProdVenda {
    private /*@ spec_public @*/ int codProd = 0;
    private /*@ spec_public @*/ int codVenda = 0;
    private /*@ spec_public nullable @*/ int qtd;
    
    /*@ public invariant 0 <= codProd;
    @ public invariant 0 <= codVenda;
    @*/
    
    //@ requires 0 <= codProd;
    //@ requires 0 <= codVenda;
    //@ requires 0 < qtd;
    public ProdVenda(int codProd, int codVenda, int qtd) {
        this.codProd = codProd;
        this.codVenda = codVenda;
        this.qtd = qtd;
    }
    public ProdVenda(){
        
    }
    
    //@ public initially 0 <= codProd;
    //@ public initially 0 <= codVenda;

    public /*@ pure @*/ int getCodProd() {
        return codProd;
    }

    //@ requires 0 <= codProd;
    //@ assignable this.codProd;
    //@ ensures this.codProd == codProd;
    public void setCodProd(int codProd) {
        this.codProd = codProd;
    }

    public /*@ pure @*/ int getCodVenda() {
        return codVenda;
    }

    //@ requires 0 <= codVenda;
    //@ assignable this.codVenda;
    //@ ensures this.codVenda == codVenda;
    public void setCodVenda(int codVenda) {
        this.codVenda = codVenda;
    }

    public /*@ pure @*/ int getQtd() {
        return qtd;
    }

    //@ requires 0 < qtd;
    //@ assignable this.qtd;
    //@ ensures this.qtd == qtd;
    public void setQtd(int qtd) {
        this.qtd = qtd;
    }
    
    
    
}

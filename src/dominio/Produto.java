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
public class Produto {
    private /*@ spec_public nullable @*/ int codProd;
    private /*@ spec_public nullable @*/ float preco;
    private /*@ spec_public nullable @*/ String descricao;
    private /*@ spec_public nullable @*/ int qtd;
    private /*@ spec_public nullable @*/ float custoPart;
    
    //@ requires 0 <= codProd;
    //@ requires 0.0 < preco;
    //@ requires 0 <= qtd;
    //@ requires 0.0 <= custoPart;
    public Produto(int codProd, float preco, String descricao, int qtd, float custoPart) {
        this.codProd = codProd;
        this.preco = preco;
        this.descricao = descricao;
        this.qtd = qtd;
        this.custoPart = custoPart;
    }
    
    public Produto() {
    
    }

    public /*@ pure @*/ int getCodProd() {
        return codProd;
    }
    
    //@ requires 0 <= codProd;
    //@ assignable this.codProd;
    //@ ensures this.codProd == codProd;
    public void setCodProd(int codProd) {
        this.codProd = codProd;
    }

    public /*@ pure @*/ float getPreco() {
        return preco;
    }
    
    //@ requires 0.0 < preco;
    //@ assignable this.preco;
    //@ ensures this.preco == preco;
    public void setPreco(float preco) {
        this.preco = preco;
    }

    public /*@ pure @*/ String getDescricao() {
        return descricao;
    }
    
    //@ requires descricao.equals(null) == false;
    //@ assignable this.descricao;
    //@ ensures this.descricao.equals(descricao) == true;
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public /*@ pure @*/ int getQtd() {
        return qtd;
    }
    
    //@ requires 0 <= qtd;
    //@ assignable this.qtd;
    //@ ensures this.qtd == qtd;
    public void setQtd(int qtd) {
        this.qtd = qtd;
    }
    
    public /*@ pure @*/ float getCustoPart() {
        return custoPart;
    }
    
    //@ requires 0.0 <= custoPart;
    //@ assignable this.custoPart;
    //@ ensures this.custoPart == custoPart;
    public void setCustoPart(float custoPart) {
        this.custoPart = custoPart;
    }
    
    
}

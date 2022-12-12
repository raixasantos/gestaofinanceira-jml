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
    private /*@ spec_public @*/ int codProd = 0;
    private /*@ spec_public @*/ float preco;
    private /*@ spec_public nullable @*/ String descricao;
    private /*@ spec_public @*/ int qtd = 0;
    private /*@ spec_public @*/ float custoPart = 0.f;
    private /*@ spec_public @*/ String[] desconto = {"0%", "15%", "20%"};
    private /*@ spec_public @*/ int descontoGanho = 1;	
    
    //@ public initially descontoGanho == 1;
    
    /*@ public invariant 0 <= codProd;
    @ public invariant 0 <= qtd;
    @ public invariant 0.0 <= custoPart;
    @*/
    
    /*@ requires 0 <= codProd;
    @ requires 0.0 < preco;
    @ requires 0 <= qtd;
    @ requires 0.0 <= custoPart;
    @ ensures this.codProd == codProd && this.preco == preco && this.qtd == qtd;
    @ ensures this.descricao == descricao && this.custoPart == custoPart;
    @*/
    public Produto(int codProd, float preco, String descricao, int qtd, float custoPart) {
        this.codProd = codProd;
        this.preco = preco;
        this.descricao = descricao;
        this.qtd = qtd;
        this.custoPart = custoPart;
    }
    
    /*@ requires 0 <= codProd;
    @ requires 0.0 < preco;
    @ requires 0 <= qtd;
    @ requires 0.0 <= custoPart;
    @ requires 1 <= descontoGanho && 3 >= descontoGanho;
    @ ensures this.codProd == codProd && this.preco == preco && this.qtd == qtd;
    @ ensures this.descricao == descricao && this.custoPart == custoPart;
    @ ensures this.descontoGanho == descontoGanho;
    @*/
    public Produto(int codProd, float preco, String descricao, int qtd, float custoPart, int descontoGanho) {
        this.codProd = codProd;
        this.preco = preco;
        this.descricao = descricao;
        this.qtd = qtd;
        this.custoPart = custoPart;
        this.descontoGanho = descontoGanho;
    }
    
    public Produto() {
    
    }
    
    //@ public initially 0 <= codProd;
    //@ public initially 0 <= qtd;
    //@ public initially 0.0 <= custoPart;
    //@ public initially 1 <= descontoGanho && 3 >= descontoGanho;

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
    
    //@ ensures \result != null && \result.length == 3;
    //@ ensures (\forall int i; 0<= i && i < 3; \result[i] != null && !(\result[i].isEmpty()));
  	public String[] getDescontos() {
  		String[] desconto = {"0%", "15%", "20%"};
  		return desconto;
  	}
  	
  	//@ requires 1 <= indice && 3 >= indice;
  	//@ ensures !(\result.equals(null));
    //@ ensures (\exists int i; 1 <= i <= desconto.length; \result.equals(desconto[i]));
  	public String getDesconto(int indice) {
  		return desconto[indice];
  	}
  	
  	public /*@ pure @*/ int getDescontoGanho() {
		 return descontoGanho;
	 }
  	
  	//@ requires 1 <= desconto && 3 >= desconto;
    //@ ensures this.descontoGanho == desconto;
  	public void setDescontoGanho(int desconto) {
  		this.descontoGanho = desconto;
  	}
    
}

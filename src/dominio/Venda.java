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
public class Venda {
    private /*@ spec_public nullable @*/ int codVenda;
    private /*@ spec_public nullable @*/ String CPF;
    private /*@ spec_public nullable @*/ String data;
    private /*@ spec_public nullable @*/ String hora;
    
    //@ requires 0 <= codVenda;
    //@ requires CPF.length() == 14;
    //@ requires CPF.contains(".") == true;
    //@ requires CPF.contains("-") == true;
    //@ requires data.length() == 10;
    //@ requires data.contains("/") == true;
    //@ requires hora.length() == 5;
    //@ requires hora.contains(":") == true;
    public Venda(int codVenda, String CPF, String data, String hora) {
        this.codVenda = codVenda;
        this.CPF = CPF;
        this.data = data;
        this.hora = hora;
    }
    
    public Venda() {
      
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

    public /*@ pure @*/ String getCPF() {
        return CPF;
    }

    /**
     * @param CPF the CPF to set
     *
     *@ requires CPF.length() == 14;
     *@ requires CPF.contains(".") == true;
     *@ requires CPF.contains("-") == true;
     *@ assignable this.CPF;
     *@ ensures this.CPF.equals(CPF) == true;
     *@
     **/    
    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public /*@ pure @*/ String getData() {
        return data;
    }

    /**
     *@ requires data.length() == 10;
     *@ requires data.contains("/") == true;
     *@ assignable this.data;
     *@ ensures this.data.equals(data) == true;
     *@
     */ 
    public void setData(String data) {
        this.data = data;
    }

    public /*@ pure @*/ String getHora() {
        return hora;
    }


    /**
     *@ requires hora.length() == 5;
     *@ requires hora.contains(":") == true;
     *@ assignable this.hora;
     *@ ensures this.hora.equals(hora) == true;
     *@
     */ 
    public void setHora(String hora) {
        this.hora = hora;
    }
    
}

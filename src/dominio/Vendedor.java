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
public class Vendedor {
	
    private /*@ spec_public nullable @*/ String CPF;
    private /*@ spec_public nullable @*/ String nome;
    private /*@ spec_public nullable @*/ String telefone;
    private /*@ spec_public nullable @*/ String email;
    
    //@ requires CPF.length() == 14;
    //@ requires CPF.contains(".") == true;
    //@ requires CPF.contains("-") == true;
    //@ requires telefone.length() == 14;
    //@ requires telefone.contains("(") == true;
    //@ requires telefone.contains(")") == true;
    //@ requires telefone.contains("-") == true;
    //@ requires email.contains("@") == true;
    //@ requires email.contains(".") == true;
    public Vendedor(String CPF, String nome, String telefone, String email) {
        this.CPF = CPF;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
    }

    public Vendedor() {
  
    }
    
    /**
     * @return the CPF
     */
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
     */    
    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    /**
     * @return the nome
     */
    public /*@ pure @*/ String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     *
     *@ requires nome.equals(null) == false;
     *@ assignable this.nome;
     *@ ensures this.nome.equals(nome) == true;
     *@
     */ 
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the telefone
     */ 
    public /*@ pure @*/ String getTelefone() {
        return telefone;
    }

    /**
     * @param telefone the telefone to set
     *
     *@ requires telefone.equals(null) == false;
     *@ assignable this.telefone;
     *@ ensures this.telefone.equals(telefone) == true;
     *@
     */ 
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * @return the email
     */
    public /*@ pure @*/ String getEmail() {
        return email;
    }
    
    /**
     *@ @param email the email to set
     *@ requires email.equals(null) == false;
     *@ assignable this.email;
     *@ ensures this.email.equals(email) == true;
     *@
     */ 
    public void setEmail(String email) {
        this.email = email;
    }
    
    
    
}

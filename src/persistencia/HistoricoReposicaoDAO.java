/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import conexao.Conexao;
import dominio.HistoricoReposicao;

import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author diego
 */
public class HistoricoReposicaoDAO {
    
    private Conexao con = new Conexao("localhost", "5432", "Gestao Financeira", "postgres", "postgres");
    
    private final String BUSCAR = "SELECT * FROM \"HistoricoReposicao\" WHERE (\"codProd\"=? AND \"data\"=?)";
    private final String INSERIR = "INSERT INTO \"HistoricoReposicao\" (\"data\",\"codProd\",\"qtd\") VALUES (?,?,?) ";
    private final String ALTERARQTD = "UPDATE \"HistoricoReposicao\" SET \"qtd\"=? WHERE (\"codProd\"=? AND \"data\"=?)";
    private final String ALTERARCODPROD = "UPDATE \"HistoricoReposicao\" SET \"codProd\"=? WHERE (\"codProd\"=? AND \"data\"=?)";
    private final String ALTERARDATA = "UPDATE \"HistoricoReposicao\" SET \"data\"=? WHERE (\"codProd\"=? AND \"data\"=?)";
    private final String RELATORIO = "SELECT * FROM \"HistoricoReposicao\"";
    private final String EXCLUIR = "DELETE FROM \"HistoricoReposicao\" WHERE (\"codProd\"=? AND \"data\"=?)";
    
    
    //@ requires 0 <= codProd;
    //@ requires 10 == data.length();
    //@ requires data.contains("/") == true;
    //@ assignable \nothing;
    public /*@ pure @*/ HistoricoReposicao buscar(int codProd, String data){
        HistoricoReposicao hr = null;
        try { 
            con.conectar();
            PreparedStatement buscar = con.getConexao().prepareStatement(BUSCAR);
            buscar.setInt(1, codProd);
            buscar.setString(2, data);
            ResultSet rsBuscar = buscar.executeQuery();
            while(rsBuscar.next()){
                hr = new HistoricoReposicao(rsBuscar.getString("data"),
                        rsBuscar.getInt("codProd"), rsBuscar.getInt("qtd"));
            }
            con.desconectar();
        } catch (Exception e) {
            System.out.println("Erro ao buscar Reposi????????o no banco de dados! "+e.getMessage());
            e.printStackTrace();
        }
        return hr;
    }
    
    //@ requires hr.getData().length() == 10;
    //@ requires hr.getData().contains("/") == true;
    //@ requires 0 <= hr.getCodProd();
    //@ requires 0 < hr.getQtd();
    public void inserir(HistoricoReposicao hr){
        try {
            con.conectar();
            PreparedStatement inserir = con.getConexao().prepareStatement(INSERIR);
            inserir.setString(1, hr.getData());
            inserir.setInt(2, hr.getCodProd());
            inserir.setInt(3, hr.getQtd());
            inserir.execute();
            System.out.println("Reposi????????o inserida com sucesso!");
            con.desconectar();
        } catch (Exception e) {
            System.out.println("Erro ao inserir Reposi????????o no banco de dados! "+e.getMessage());
            e.printStackTrace();
        }
    }
    
    //@ requires 0 < qtd;
    //@ requires data.length() == 10;
    //@ requires data.contains("/") == true;
    //@ requires 0 <= codProd;
    public void alterarQtd(int qtd, String data, int codProd){
        try {
            con.conectar();
            PreparedStatement alterarQtd = con.getConexao().prepareStatement(ALTERARQTD);
            alterarQtd.setInt(1, qtd);
            alterarQtd.setInt(2, codProd);
            alterarQtd.setString(3, data);
            alterarQtd.execute();
            System.out.println("Quantidade alterada com sucesso!");
            con.desconectar();
        } catch (Exception e) {
            System.out.println("Erro ao alterar quantidade do produto reposto no banco de dados! "+e.getMessage());
            e.printStackTrace();
        }
    }
    
    //@ requires 0 <= novoCodProd;
    //@ requires data.length() == 10;
    //@ requires data.contains("/") == true;
    //@ requires 0 <= codProd;
    public void alterarCodProd(int novoCodProd, String data, int codProd){
        try {
            con.conectar();
            PreparedStatement alterarQtd = con.getConexao().prepareStatement(ALTERARCODPROD);
            alterarQtd.setInt(1, novoCodProd);
            alterarQtd.setInt(2, codProd);
            alterarQtd.setString(3, data);
            alterarQtd.execute();
            System.out.println("Codigo do produto alterado com sucesso!");
            con.desconectar();
        } catch (Exception e) {
            System.out.println("Erro ao alterar c????digo do produto reposto no banco de dados! "+e.getMessage());
            e.printStackTrace();
        }
    }
    
    //@ requires novaData.length() == 10;
    //@ requires novaData.contains("/") == true;
    //@ requires data.length() == 10;
    //@ requires data.contains("/") == true;
    //@ requires 0 <= codProd;
    public void alterarData(String novaData, String data, int codProd){
        try {
            con.conectar();
            PreparedStatement alterarQtd = con.getConexao().prepareStatement(ALTERARDATA);
            alterarQtd.setString(1, novaData);
            alterarQtd.setInt(2, codProd);
            alterarQtd.setString(3, data);
            alterarQtd.execute();
            System.out.println("Data alterada com sucesso!");
            con.desconectar();
        } catch (Exception e) {
            System.out.println("Erro ao alterar data da reposi????????o no banco de dados! "+e.getMessage());
            e.printStackTrace();
        }
    }
    
	public /*@ pure @*/ ArrayList<HistoricoReposicao> relatorio(){
        ArrayList relHist = new ArrayList();
        try {
            con.conectar();
            PreparedStatement relatorio = con.getConexao().prepareStatement(RELATORIO);
            ResultSet rsRelatorio = relatorio.executeQuery();
            while (rsRelatorio.next()) {
                HistoricoReposicao hr = new HistoricoReposicao(rsRelatorio.getString("data"),
                        rsRelatorio.getInt("codProd"), rsRelatorio.getInt("qtd"));
                relHist.add(hr);
            }
            con.desconectar();
        } catch (Exception e) {
            System.out.println("Erro ao emitir relat????rio de Reposi????????o: "+e.getMessage());
            e.printStackTrace();
        }
        return relHist;
    }
    
    //@ requires 0 <= codProd;
    //@ requires data.length() == 10;
    //@ requires data.contains("/") == true;
    public void excluir(int codProd, String data){
        try {
            con.conectar();
            PreparedStatement excluir = con.getConexao().prepareStatement(EXCLUIR);
            excluir.setInt(1, codProd);
            excluir.setString(2, data);
            excluir.execute();
            System.out.println("Reposi????????o excluida com sucesso!");
            con.desconectar();
        } catch (Exception e) {
            System.out.println("Erro ao excluir Reposi????????o no banco de dados: "+e.getMessage());
            e.printStackTrace();
        }
    }
    
}
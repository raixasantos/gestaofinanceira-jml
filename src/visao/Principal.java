/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import java.util.Scanner;
import java.util.ArrayList;

import dominio.*;
import persistencia.*;

/**
 *
 * @author diego
 */

public class Principal {
    public static void main(String[] args) throws Exception {
        
        VendedorDAO vDAO = new VendedorDAO();
        Vendedor v = null;
        Vendedor vendedor = new Vendedor();
        ArrayList <Vendedor> relVendedor = new ArrayList();
        
        VendaDAO veDAO = new VendaDAO();
        Venda ve = new Venda();
        Venda venda = new Venda();
        ArrayList <Venda> relVenda = new ArrayList();
        
        ProdutoDAO pDAO = new ProdutoDAO();
        Produto p = new Produto();
        Produto produto = new Produto();
        ArrayList <Produto> relProd = new ArrayList();
        
        HistoricoReposicao hr = new HistoricoReposicao();
        HistoricoReposicaoDAO hrDAO = new HistoricoReposicaoDAO();
        HistoricoReposicao hist = new HistoricoReposicao();
        ArrayList <HistoricoReposicao> relHist = new ArrayList();
                
        ProdVenda pv = new ProdVenda();
        ProdVenda pvAux;
        ProdVendaDAO pvDAO = new ProdVendaDAO();
        ArrayList <ProdVenda> relProdVenda = new ArrayList();

        Scanner scan = new Scanner(System.in);
        
        int op, op2, op3, op4, flag, flag2, flag3, flag4, codProd, qtd, novaQtd, codVenda, maior, desconto;
        String CPF, nome, email, telefone, descricao, data, hora;
        float preco, custoPart, total;
        boolean a;

        
        do{
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("              MENU              ");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("1 - Vendedor                    ");
            System.out.println("2 - Produto                     ");
            System.out.println("3 - Venda                       ");
            System.out.println("4 - Hist??rico de Reposi????o      ");
            System.out.println("5 - Relat??rios Especiais        ");
            System.out.println("6 - Sair                        ");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            op = scan.nextInt();

            switch(op){
                
                case 1:
                        
                    do{
                        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                        System.out.println("            VENDEDOR            ");
                        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                        System.out.println("1 - Cadastrar                   ");
                        System.out.println("2 - Alterar                     ");
                        System.out.println("3 - Buscar                      ");
                        System.out.println("4 - Relat??rio                   ");
                        System.out.println("5 - Excluir                     ");
                        System.out.println("6 - Voltar                      ");
                        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                        op2 = scan.nextInt();

                        switch(op2){
                            case 1: //INSERIR VENDEDOR
                                System.out.println("Digite o CPF do Vendedor: ");
                                scan.nextLine();
                                CPF = scan.nextLine();
                                v = vDAO.buscarCPF(CPF);
                                do{
                                    if(v==null){
                                        flag = 1;
                                        System.out.println("Digite o seu nome: ");
                                        nome = scan.nextLine();
                                        System.out.println("Digite seu telefone");
                                        telefone = scan.nextLine();
                                        System.out.println("Digite seu email");
                                        email = scan.nextLine();
                                        v = new Vendedor(CPF, nome, telefone, email);
                                        vDAO.inserir(v);
                                    }else{
                                        flag = 0;
                                        System.out.println("Este CPF j?? est?? atribu??do ao vendedor "+v.getNome());
                                        System.out.println("Digite o CPF novamente: ");
                                        CPF = scan.nextLine();
                                        v = vDAO.buscarCPF(CPF);
                                    }
                                }while(flag==0);
                                break;
                            case 2: //ALTERAR VENDEDOR
                                do{
                                    System.out.println("Digite o CPF do vendedor que deseja alterar: ");
                                    scan.nextLine();
                                    CPF = scan.nextLine();
                                    v = vDAO.buscarCPF(CPF);
                                    if(v!=null){
                                        flag2=1;
                                        System.out.println("Deseja alterar o CPF? (1-Sim, 2-N??o)");
                                        op3 = scan.nextInt();
                                        if(op3==1){ //ALTERAR CPF
                                            System.out.println("Digite o novo CPF: ");
                                            scan.nextLine();
                                            CPF = scan.nextLine();
                                            vendedor = vDAO.buscarCPF(CPF);
                                            while(vendedor!=null){
                                                 System.out.println("Digite um CPF v??lido: ");
                                                 CPF = scan.nextLine();
                                                 vendedor = vDAO.buscarCPF(CPF);
                                            }
                                            vDAO.alterarCPF(v.getCPF(), CPF);
                                            v.setCPF(CPF);
                                        }
                                        System.out.println("Deseja alterar o nome? (1-Sim, 2-N??o)");
                                        op3 = scan.nextInt();
                                        if(op3==1){
                                            System.out.println("Digite o novo nome: ");
                                            scan.nextLine();
                                            nome = scan.nextLine();
                                            do{
                                                if(nome.equals(v.getNome())){
                                                    flag = 0;
                                                    System.out.println("Digite um nome diferente do antigo: ");
                                                    scan.nextLine();
                                                    nome = scan.nextLine();
                                                }else{
                                                    flag = 1;
                                                    v.setNome(nome);
                                                    vDAO.alterarNome(v.getCPF(), nome);
                                                }
                                            }while(flag==0);
                                        }
                                        System.out.println("Deseja alterar o telefone? (1-Sim, 2-N??o)");
                                        op3 = scan.nextInt();
                                        if(op3==1){ //ALTERAR TELEFONE
                                            System.out.println("Digite o novo telefone: ");
                                            scan.nextLine();
                                            telefone = scan.nextLine();
                                            do{
                                                if(telefone.equals(v.getTelefone())){
                                                    flag = 0;
                                                    System.out.println("Digite um telefone diferente do antigo: ");
                                                    scan.nextLine();
                                                    telefone = scan.nextLine();
                                                }else{
                                                    flag = 1;
                                                    v.setTelefone(telefone);
                                                    vDAO.alterarTelefone(v.getCPF(), telefone);
                                                }
                                            }while(flag==0);
                                        }

                                        System.out.println("Deseja alterar o email? (1-Sim, 2-N??o)");                                        op3 = scan.nextInt();
                                        if(op3==1){ //ALTERAR EMAIL
                                            System.out.println("Digite o novo email: ");
                                            scan.nextLine();
                                            email = scan.nextLine();
                                            do{
                                                if(email.equals(v.getEmail())){
                                                    flag = 0;
                                                    System.out.println("Digite um email diferente do antigo: ");
                                                    scan.nextLine();
                                                    email = scan.nextLine();
                                                }else{
                                                    flag = 1;
                                                    v.setEmail(email);
                                                    vDAO.alterarEmail(v.getCPF(), email);
                                                }
                                            }while(flag==0);
                                        }
                                    }else{
                                        flag2=0;
                                        System.out.println("Vendedor n??o cadastrado!");
                                    }
                                }while(flag2==0);
                                break;

                            case 3: //BUSCAR VENDEDOR
                                System.out.println("Digite o CPF do vendedor que deseja consultar: ");
                                scan.nextLine();
                                CPF = scan.nextLine();
                                v = vDAO.buscarCPF(CPF);
                                if(v!=null){
                                    System.out.println("CPF: "+v.getCPF());
                                    System.out.println("Nome: "+v.getNome());
                                    System.out.println("Telefone: "+v.getTelefone());
                                    System.out.println("Email: "+v.getEmail());
                                    break;
                                }else{
                                    System.out.println("Vendedor n??o cadastrado!");
                                }
                                break;
                                
                            case 4: //RELATORIO DE VENDEDOR
                                relVendedor = vDAO.relatorio();
                                for(int i=0;i<relVendedor.size();i++){
                                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~");
                                    System.out.println("    VENDEDOR "+(i+1));
                                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~");
                                    System.out.println("CPF: "+relVendedor.get(i).getCPF());
                                    System.out.println("Nome: "+relVendedor.get(i).getNome());
                                    System.out.println("Telefone: "+relVendedor.get(i).getTelefone());
                                    System.out.println("Email: "+relVendedor.get(i).getEmail());
                                }
                                break;

                            case 5: //EXCLUIR VENDEDOR
                                System.out.println("Digite o CPF do usu??rio que deseja excluir: ");
                                scan.nextLine();
                                CPF = scan.nextLine();
                                v = vDAO.buscarCPF(CPF);
                                if(v!=null){ 
                                    System.out.println("Nome: "+v.getNome());
                                    System.out.println("Telefone: "+v.getTelefone());
                                    System.out.println("Email: "+v.getEmail());
                                    if(veDAO.buscarVendedor(CPF)==0){
                                        System.out.println("Confirmar exclus??o? 1-Sim, 2-N??o?");
                                        op3 = scan.nextInt();
                                        if(op3==1){
                                            vDAO.excluir(CPF);
                                        }
                                        else{
                                            System.out.println("Exclus??o cancelada!");
                                        }
                                    }else{
                                        System.out.println("Existem vendas associadas ?? esse vendedor, deseja exclu??-lo e atribuir suas vendas ao Vendedor Excluido? (1-Sim, 2-N??o)");
                                        op3 = scan.nextInt();
                                        if(op3==1){
                                            relVenda = veDAO.buscarVendedor2(CPF);
                                            for(int i=0;i<relVenda.size();i++){
                                                veDAO.alterarCPF("000.000.000-00", relVenda.get(i).getCodVenda());
                                                relVenda.get(i).setCPF("000.000.000-00");
                                            }
                                            vDAO.excluir(CPF);
                                        }else{
                                            System.out.println("Exclus??o cancelada!");
                                            
                                        }
                                    }
                                }else{
                                    System.out.println("Vendedor n??o cadastrado!");
                                }
                                break;
                        }
                        
                    }while(op2!=6);
                    break;
                 
                case 2:
                    
                    do{
                        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                        System.out.println("            PRODUTO             ");
                        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                        System.out.println("1 - Cadastrar                   ");
                        System.out.println("2 - Alterar                     ");
                        System.out.println("3 - Buscar                      ");
                        System.out.println("4 - Relat??rio                   ");
                        System.out.println("5 - Excluir                     ");
                        System.out.println("6 - Voltar                      ");
                        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                        op2 = scan.nextInt();

                        switch(op2){

                            case 1: //INSERIR PRODUTO
                                System.out.println("Digite o codigo do Produto: ");
                                codProd = scan.nextInt();
                                p = pDAO.buscar(codProd);
                                do{
                                    if(p==null){
                                        flag = 1;
                                        System.out.println("Digite a descri????o: ");
                                        scan.nextLine();
                                        descricao = scan.nextLine();
                                        System.out.println("Digite o pre??o: ");
                                        preco = scan.nextFloat();
                                        System.out.println("Digite a quantidade: ");
                                        qtd = scan.nextInt();
                                        System.out.println("Digite o custo particionado: ");
                                        custoPart = scan.nextFloat();
                                        System.out.println("Digite o desconto dispon??vel: ");
                                        desconto = scan.nextInt();
                                        p = new Produto(codProd, preco, descricao, qtd, custoPart, desconto);
                                        pDAO.inserir(p);
                                    }else{
                                        flag = 0;
                                        System.out.println("Este c??digo j?? est?? atribu??do ao produto "+p.getDescricao());
                                        System.out.println("Digite o c??digo novamente: ");
                                        codProd = scan.nextInt();
                                        p = pDAO.buscar(codProd);
                                    }
                                }while(flag==0);
                                break;
                                
                            case 2: //ALTERAR PRODUTO
                                do{
                                    System.out.println("Digite o c??digo do produto que deseja alterar: ");
                                    codProd = scan.nextInt();
                                    p = pDAO.buscar(codProd);
                                    if(p!=null){
                                        flag2=1;
                                        System.out.println("Deseja alterar o codigo? (1-Sim, 2-N??o)");
                                        op3 = scan.nextInt();
                                        if(op3==1){ //ALTERAR CODIGO
                                            System.out.println("Digite o novo codigo: ");
                                            codProd = scan.nextInt();
                                            produto = pDAO.buscar(codProd);
                                            while(produto!=null){
                                                 System.out.println("Digite um codigo v??lido: ");
                                                 codProd = scan.nextInt();
                                                 produto = pDAO.buscar(codProd);
                                            }
                                            pDAO.alterarCodProd(p.getCodProd(), codProd);
                                            p.setCodProd(codProd);
                                        }
                                 
                                        System.out.println("Deseja alterar o pre??o? (1-Sim, 2-N??o)");
                                        op3 = scan.nextInt();
                                        if(op3==1){
                                            System.out.println("Digite o novo pre??o: ");
                                            preco = scan.nextFloat();
                                            do{
                                                if(preco==p.getPreco()){
                                                    flag = 0;
                                                    System.out.println("Digite um preco diferente do antigo: ");
                                                    preco = scan.nextFloat();
                                                }else{
                                                    flag = 1;
                                                    p.setPreco(preco);
                                                    pDAO.alterarPreco(p.getCodProd(), preco);
                                                }
                                            }while(flag==0);
                                        }
                                        
                                        System.out.println("Deseja alterar o descri????o? (1-Sim, 2-N??o)");
                                        op3 = scan.nextInt();
                                        if(op3==1){ //ALTERAR DESCRI????O
                                            System.out.println("Digite a nova descri????o: ");
                                            scan.nextLine();
                                            descricao = scan.nextLine();
                                            do{
                                                if(descricao.equals(p.getDescricao())){
                                                    flag = 0;
                                                    System.out.println("Digite uma descri????o diferente do antigo: ");
                                                    scan.nextLine();
                                                    descricao = scan.nextLine();
                                                }else{
                                                    flag = 1;
                                                    p.setDescricao(descricao);
                                                    pDAO.alterarDesc(p.getCodProd(), descricao);
                                                }
                                            }while(flag==0);
                                        }

                                        System.out.println("Deseja alterar a quantidade? (1-Sim, 2-N??o)");
                                        op3 = scan.nextInt();
                                        if(op3==1){ //ALTERAR QUANTIDADE
                                            System.out.println("Digite a nova quantidade: ");
                                            qtd = scan.nextInt();
                                            do{
                                                if(qtd==p.getQtd()){
                                                    flag = 0;
                                                    System.out.println("Digite uma quantidade diferente da antiga: ");
                                                    qtd = scan.nextInt();
                                                }else{
                                                    flag = 1;
                                                    p.setQtd(qtd);
                                                    pDAO.alterarQtd(codProd, qtd);
                                                }
                                            }while(flag==0);
                                        }
                                        
                                        System.out.println("Deseja alterar o custo particionado? (1-Sim, 2-N??o)");
                                        op3 = scan.nextInt();
                                        if(op3==1){ //ALTERAR CUSTO PARTICIONADO
                                            System.out.println("Digite o novo custo particionado: ");
                                            custoPart = scan.nextFloat();
                                            do{
                                                if(custoPart==p.getCustoPart()){
                                                    flag = 0;
                                                    System.out.println("Digite um custo particionado diferente do antigo: ");
                                                    custoPart = scan.nextInt();
                                                }else{
                                                    flag = 1;
                                                    p.setCustoPart(custoPart);
                                                    pDAO.alterarCusto(codProd, custoPart);
                                                }
                                            }while(flag==0);
                                        }
                                    }else{
                                        flag2=0;
                                        System.out.println("Produto n??o cadastrado!");
                                    }
                                }while(flag2==0);
                                break;

                            case 3: //BUSCAR PRODUTO
                                System.out.println("Digite o codigo do produto que deseja consultar: ");
                                codProd = scan.nextInt();
                                p = pDAO.buscar(codProd);
                                if(p!=null){
                                    System.out.println("Descri????o: "+p.getDescricao());
                                    System.out.println("Pre??o: "+p.getPreco());
                                    System.out.println("Quantidade: "+p.getQtd());
                                    System.out.println("Custo Particionado: "+p.getCustoPart());
                                    System.out.println("Desconto dispon??vel: "+p.getDesconto(p.getDescontoGanho()));                                    
                                    break;
                                }else{
                                    System.out.println("Produto n??o cadastrado!");
                                }
                                break;
                                
                            case 4: //RELATORIO DE PRODUTO
                                relProd = pDAO.relatorio();
                                for(int i=0;i<relProd.size();i++){
                                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~");
                                    System.out.println("    PRODUTO "+(i+1));
                                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~");
                                    System.out.println("C??digo do Produto: "+relProd.get(i).getCodProd());
                                    System.out.println("Descri????o do Produto: "+relProd.get(i).getDescricao());
                                    System.out.println("Quantidade do Produto: "+relProd.get(i).getQtd());
                                    System.out.println("Pre??o do Produto: "+relProd.get(i).getPreco());
                                    System.out.println("Custo Particionado do Produto: "+relProd.get(i).getCustoPart());
                                }
                                break;

                            case 5: //EXCLUIR PRODUTO
                                System.out.println("Digite o c??digo do produto que deseja excluir: ");
                                codProd = scan.nextInt();
                                p = pDAO.buscar(codProd);
                                if(p!=null){ 
                                    System.out.println("Descri????o: "+p.getDescricao());
                                    System.out.println("Pre??o: "+p.getPreco());
                                    System.out.println("Quantidade: "+p.getQtd());
                                    System.out.println("Custo Particionado: "+p.getCustoPart());
                                    if(pvDAO.buscarProduto(codProd)==0){
                                        System.out.println("Confirmar exclus??o? 1-Sim, 2-N??o?");
                                        op3 = scan.nextInt();
                                        if(op3==1){
                                            pDAO.excluir(codProd);
                                        }
                                        else{
                                            System.out.println("Exclus??o cancelada!");
                                        }
                                    }else{
                                        System.out.println("N??o ?? poss??vel excluir um produto j?? associado a uma venda");
                                    }
                                }else{
                                    System.out.println("Produto n??o cadastrado!");
                                }
                                break;
                        }

                    }while(op2!=6);
                    break;
     
                case 3: 
                    
                    do{
                        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                        System.out.println("             VENDA              ");
                        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                        System.out.println("1 - Cadastrar                   ");
                        System.out.println("2 - Alterar                     ");
                        System.out.println("3 - Buscar                      ");
                        System.out.println("4 - Relat??rio                   ");
                        System.out.println("5 - Excluir                     ");
                        System.out.println("6 - Voltar                      ");
                        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                        op2 = scan.nextInt();

                        switch(op2){

                            case 1: //INSERIR VENDA
                                
                                System.out.println("Digite o c??digo da venda: ");
                                codVenda = scan.nextInt();
                                ve = veDAO.buscarCodVenda(codVenda);
                                do{    
                                    if(ve==null){
                                        venda.setCodVenda(codVenda);
                                        do{
                                            System.out.println("Digite o CPF do vendedor:");
                                            scan.nextLine();
                                            CPF = scan.nextLine();
                                            v = vDAO.buscarCPF(CPF);
                                            if(v!=null){
                                                venda.setCPF(CPF);
                                                System.out.println("Digite a data da venda: ");
                                                data = scan.nextLine();
                                                venda.setData(data);
                                                
                                                System.out.println("Digite a hora da venda: ");
                                                hora = scan.nextLine();
                                                venda.setHora(hora);
                                                
                                                System.out.println("Digite o c??digo do produto vendido:");
                                                codProd = scan.nextInt();
                                                p = pDAO.buscar(codProd);
                                                do{
                                                    if(p!=null){
                                                        System.out.println("Digite a quantidade de vendida de "+p.getDescricao());
                                                        qtd = scan.nextInt();
                                                        do{
                                                            if(qtd<=p.getQtd()){
                                                                veDAO.inserir(venda);
                                                                pv.setCodVenda(venda.getCodVenda());
                                                                pv.setCodProd(p.getCodProd());
                                                                pv.setQtd(qtd);
                                                                pDAO.alterarQtd(p.getCodProd(), (p.getQtd()-qtd));
                                                                pvDAO.inserir(pv);
                                                                flag4 = 1;
                                                            }else{
                                                                System.out.println("N??o ?? poss??vel vender uma quantidade maior que a do estoque!");
                                                                System.out.println("1 - Continuar com a venda alterando a quantidade vendida");
                                                                System.out.println("2 - Cancelar venda");
                                                                op4 = scan.nextInt();
                                                                if(op4==1){
                                                                    System.out.println("Digite novamente a quantidade de vendida de "+p.getDescricao());
                                                                    qtd = scan.nextInt();
                                                                    flag4 = 0;
                                                                }else{
                                                                    System.out.println("Cadastro de venda cancelado!");
                                                                    flag4 = 1;
                                                                }
                                                            }
                                                        }while(flag4==0);
                                                        flag3 = 1;
                                                    }else{
                                                        System.out.println("Esse produto n??o existe!");
                                                        System.out.println("Digite o c??digo do produto vendido novamente:");
                                                        codProd = scan.nextInt();
                                                        p = pDAO.buscar(codProd);
                                                        flag3 = 0;
                                                    }
                                                }while(flag3==0);
                                                
                                                flag2 = 1;
                                            }else{
                                                System.out.println("Esse vendedor n??o existe!");
                                                flag2 = 0;
                                            }
                                        }while(flag2==0);
                                        flag = 1;
                                    }else{
                                        System.out.println("Esse c??digo j?? est?? cadastrado!");
                                        System.out.println("Digite o c??digo da venda novamente: ");
                                        codVenda = scan.nextInt();
                                        ve = veDAO.buscarCodVenda(codVenda);
                                        flag = 0;
                                    }
                                }while(flag==0);
                                break;
                                
                            case 2: //ALTERAR VENDA
                                
                                System.out.println("Digite o c??digo da venda que deseja alterar:");
                                codVenda = scan.nextInt();
                                ve = veDAO.buscarCodVenda(codVenda);
                                do{
                                    if(ve!=null){
                                        System.out.println("Deseja alterar o CPF do vendedor? (1-Sim 2-N??o)");
                                        op3 = scan.nextInt();
                                        if(op3==1){
                                            System.out.println("Digite o novo CPF:");
                                            scan.nextLine();
                                            CPF = scan.nextLine();
                                            v = vDAO.buscarCPF(CPF);
                                            do{
                                                if(v!=null){
                                                    veDAO.alterarCPF(v.getCPF(), ve.getCodVenda());
                                                    ve.setCPF(v.getCPF());
                                                    flag2 = 1;
                                                }else{
                                                    System.out.println("Esse vendedor n??o existe!");
                                                    System.out.println("Digite o novo CPF:");
                                                    scan.nextLine();
                                                    CPF = scan.nextLine();
                                                    v = vDAO.buscarCPF(CPF);
                                                    flag2 = 0;
                                                }
                                            }while(flag2==0);
                                        }
                                        
                                        System.out.println("Deseja alterar a data da venda? (1-Sim 2-N??o)");
                                        op3 = scan.nextInt();
                                        if(op3==1){
                                            System.out.println("Digite a nova data:");
                                            scan.nextLine();
                                            data = scan.nextLine();
                                            veDAO.alterarData(data, ve.getCodVenda());
                                            ve.setData(data);
                                        }
                                        
                                        System.out.println("Deseja alterar a hora da venda? (1-Sim 2-N??o)");
                                        op3 = scan.nextInt();
                                        if(op3==1){
                                            System.out.println("Digite a nova hora:");
                                            scan.nextLine();
                                            hora = scan.nextLine();
                                            veDAO.alterarHora(hora, ve.getCodVenda());
                                            ve.setHora(hora);
                                        }
                                        
                                        System.out.println("Deseja alterar o c??digo da venda? (1-Sim 2-N??o)");
                                        op3 = scan.nextInt();
                                        if(op3==1){
                                            System.out.println("Digite o novo c??digo:");
                                            codVenda = scan.nextInt();
                                            venda = veDAO.buscarCodVenda(codVenda);
                                            do{
                                                if(venda==null){
                                                    pv = pvDAO.buscarCodVenda(ve.getCodVenda());
                                                    pvAux = new ProdVenda(pv.getCodProd(), codVenda, pv.getQtd());
                                                    pvDAO.excluir(pv);
                                                    veDAO.alterarCodVenda(codVenda, ve.getCodVenda());
                                                    ve.setCodVenda(codVenda);
                                                    pvDAO.inserir(pvAux);
                                                    flag2 = 1;
                                                }else{
                                                    System.out.println("Essa venda j?? foi cadastrada!");
                                                    System.out.println("Digite o c??digo novamente:");
                                                    codVenda = scan.nextInt();
                                                    venda = veDAO.buscarCodVenda(codVenda);
                                                    flag2 = 0;
                                                }
                                            }while(flag2==0);
                                        }
 /*                                       
                                        System.out.println("Deseja alterar codVenda da tabela ProdVenda? (1-Sim 2-N??o)");
                                        op3 = scan.nextInt();
                                        if(op3==1){
                                            System.out.println("Digite o novo codVenda:");
                                            codVenda = scan.nextInt();
                                            venda = veDAO.buscarCodVenda(codVenda);
                                            pv = pvDAO.buscarCodVenda(codVenda);
                                            do{
                                                if(venda!=null && pv==null){
                                                  //  pvDAO.alterarCodVenda(codVenda, pv.getCodVenda());
                                                    
                                                    flag2 = 1;
                                                }else{
                                                    System.out.println("Esse codVenda n??o existe em outra Venda ou j?? existe em outro codProd!");
                                                    System.out.println("Digite o novo codVenda:");
                                                    codVenda = scan.nextInt();
                                                    venda = veDAO.buscarCodVenda(codVenda);
                                                    pv = pvDAO.buscarCodVenda(codVenda);
                                                    flag2 = 0;
                                                }
                                            }while(flag2==0);
                                        }
                                        
 */                                      
                                        
                                        flag = 1;
                                    
                                    }else{
                                        System.out.println("Essa venda n??o existe!");
                                        System.out.println("Digite o c??digo da venda que deseja alterar:");
                                        codVenda = scan.nextInt();
                                        ve = veDAO.buscarCodVenda(codVenda);
                                        flag = 0;
                                    }
                                }while(flag==0);
                                break;

                            case 3: //BUSCAR VENDA
                                
                                System.out.println("Digite o codigo da venda que deseja consultar: ");
                                codVenda = scan.nextInt();
                                ve = veDAO.buscarCodVenda(codVenda);
                                if(ve!=null){
                                    System.out.println("C??digo da venda: "+ve.getCodVenda());
                                    pv = pvDAO.buscarCodVenda(ve.getCodVenda());
                                    p = pDAO.buscar(pv.getCodProd());
                                    System.out.println("Produto vendido: "+p.getDescricao());
                                    System.out.println("C??digo do produto: "+pv.getCodProd());
                                    System.out.println("Quantidade vendida "+pv.getQtd());
                                    v = vDAO.buscarCPF(ve.getCPF());
                                    System.out.println("Vendedor: "+v.getNome());
                                    System.out.println("CPF do vendedor: "+ve.getCPF());
                                    System.out.println("Data da venda: "+ve.getData());
                                    System.out.println("Hora da venda: "+ve.getHora());
                                    break;
                                }else{
                                    System.out.println("Venda n??o cadastrada n??o cadastrado!");
                                }

                                break;
                                
                            case 4: //RELATORIO DE VENDA
                                relVenda = veDAO.relatorio();
                                for(int i=0;i<relVenda.size();i++){
                                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~");
                                    System.out.println("    VENDA "+(i+1));
                                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~");
                                    System.out.println("C??digo da venda: "+relVenda.get(i).getCodVenda());
                                    pv = pvDAO.buscarCodVenda(relVenda.get(i).getCodVenda());
                                    p = pDAO.buscar(pv.getCodProd());
                                    System.out.println("Produto vendido: "+p.getDescricao());
                                    System.out.println("C??digo do produto: "+pv.getCodProd());
                                    System.out.println("Quantidade vendida "+pv.getQtd());
                                    // MOSTRAR INFO DO PRODUTO
                                    v = vDAO.buscarCPF(relVenda.get(i).getCPF());
                                    System.out.println("Vendedor: "+v.getNome());
                                    System.out.println("CPF do vendedor: "+v.getCPF());
                                    System.out.println("Data da venda: "+relVenda.get(i).getData());
                                    System.out.println("Hora da venda: "+relVenda.get(i).getHora()+"\n");
                                }
                                break;

                            case 5: //EXCLUIR VENDA
                                
                                System.out.println("Digite o c??digo da venda que deseja excluir:");
                                codVenda = scan.nextInt();
                                ve = veDAO.buscarCodVenda(codVenda);
                                do{
                                    if(ve!=null){
                                        System.out.println("C??digo da venda: "+ve.getCodVenda());
                                        pv = pvDAO.buscarCodVenda(ve.getCodVenda());
                                        p = pDAO.buscar(pv.getCodProd());
                                        System.out.println("Produto vendido: "+p.getDescricao());
                                        System.out.println("C??digo do produto: "+pv.getCodProd());
                                        System.out.println("Quantidade vendida "+pv.getQtd());
                                        v = vDAO.buscarCPF(ve.getCPF());
                                        System.out.println("Vendedor: "+v.getNome());
                                        System.out.println("CPF do vendedor: "+ve.getCPF());
                                        System.out.println("Data da venda: "+ve.getData());
                                        System.out.println("Hora da venda: "+ve.getHora());
                                        System.out.println("Deseja excluir a venda? (1-Sim 2-N??o)");
                                        op3 = scan.nextInt();
                                        if(op3==1){
                                            pDAO.alterarQtd(p.getCodProd(), (p.getQtd()+pv.getQtd()));
                                            p.setQtd((p.getQtd()+pv.getQtd()));
                                            pvDAO.excluir(pv);
                                            veDAO.excluir(ve);
                                            flag = 1;
                                        }else{
                                            System.out.println("Exclus??o cancelada!");
                                            flag = 1;
                                        }
                                    }else{
                                        System.out.println("Venda n??o cadastrada!");
                                        System.out.println("Digite o c??digo da venda que deseja excluir:");
                                        codVenda = scan.nextInt();
                                        ve = veDAO.buscarCodVenda(codVenda);
                                        flag = 0;
                                    }
                                }while(flag==0);

                                break;
                        }

                    }while(op2!=6);
                    break;
                    
                case 4:
                    
                    do{
                        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                        System.out.println("     HIST??RICO DE REPOSI????O     ");
                        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                        System.out.println("1 - Cadastrar                   ");
                        System.out.println("2 - Alterar                     ");
                        System.out.println("3 - Buscar                      ");
                        System.out.println("4 - Visualizar Hist??rico        ");
                        System.out.println("5 - Excluir                     ");
                        System.out.println("6 - Voltar                      ");
                        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                        op2 = scan.nextInt();

                        switch(op2){

                            case 1: //INSERIR HIST??RICO
                                do{
                                    System.out.println("Digite o codigo do produto da reposi????o");
                                    codProd = scan.nextInt();
                                    produto = pDAO.buscar(codProd);
                                    if(produto==null){
                                        System.out.println("Esse produto n??o existe!");
                                        flag3 = 0;
                                    }else{
                                        flag3 = 1;
                                    }
                                }while(flag3==0);
                                System.out.println("Digite a data da reposi????o:");
                                scan.nextLine();
                                data = scan.nextLine();
                                hr = hrDAO.buscar(codProd, data);
                                do{
                                    if(hr==null){
                                        flag = 1;
                                        System.out.println("Digite a quantidade reposta:");
                                        qtd = scan.nextInt();
                                        hr = new HistoricoReposicao(data, codProd, qtd);
                                        hrDAO.inserir(hr);
                                        pDAO.alterarQtd(codProd, (produto.getQtd() + qtd));
                                    }else{
                                        flag = 0;
                                        System.out.println("Reposi????o j?? cadastrada! Tente novamente!");
                                        System.out.println("Digite o codigo do produto da reposi????o");
                                        codProd = scan.nextInt();
                                        System.out.println("Digite a data da reposi????o:");
                                        scan.nextLine();
                                        data = scan.nextLine();
                                        hr = hrDAO.buscar(codProd, data);                                    
                                    }
                                }while(flag==0);
                                break;
                                
                            case 2: //ALTERAR HIST??RICO
                                do{
                                    System.out.println("Digite o codigo do produto reposto");
                                    codProd = scan.nextInt();
                                    p = pDAO.buscar(codProd);
                                    if(p!=null){
                                        flag=1;
                                    }else{
                                        System.out.println("Esse produto n??o existe!");
                                        flag=0;
                                    }
                                }while(flag==0);
                                
                                System.out.println("Digite a data da reposi????o:");
                                scan.nextLine();
                                data = scan.nextLine();
                                hr = hrDAO.buscar(codProd, data);
                                do{
                                    if(hr!=null){
                                        flag=1;
                                        System.out.println("Deseja alterar a data de reposi????o? (1-Sim 2-N??o");
                                        op3 = scan.nextInt();
                                        if(op3==1){
                                            System.out.println("Digite a nova data:");
                                            scan.nextLine();
                                            data = scan.nextLine();
                                            hist = hrDAO.buscar(hr.getCodProd(), data);
                                            do{
                                                if(hist==null){
                                                    hrDAO.alterarData(data, hr.getData(), hr.getCodProd());
                                                    hr.setData(data);
                                                    flag=1;
                                                }else{
                                                    flag = 0;
                                                    System.out.println("O produto j?? possui uma reposi????o nesta data, escolha outra:");
                                                    scan.nextLine();
                                                    data = scan.nextLine();
                                                    hist = hrDAO.buscar(hr.getCodProd(), data);
                                                }
                                            }while(flag==0);
                                        }
                                        
                                        System.out.println("Deseja alterar o c??digo do produto reposto? (1-Sim 2-N??o");
                                        op3 = scan.nextInt();
                                        if(op3==1){
                                            System.out.println("Digite o novo c??digo:");
                                            codProd = scan.nextInt();
                                            produto = pDAO.buscar(codProd);
                                            if(produto!=null){
                                                hist = hrDAO.buscar(produto.getCodProd(), hr.getData());
                                                do{
                                                    if(hist==null){
                                                        pDAO.alterarQtd(p.getCodProd(), (p.getQtd()-hr.getQtd()));
                                                        pDAO.alterarQtd(produto.getCodProd(), produto.getQtd()+hr.getQtd());
                                                        hrDAO.alterarCodProd(codProd, hr.getData(), hr.getCodProd());
                                                        hr.setCodProd(codProd);
                                                        p = pDAO.buscar(codProd);
                                                        flag=1;
                                                    }else{
                                                        flag = 0;
                                                        System.out.println("J?? existe uma reposi????o nesta data deste produto, escolha outro:");
                                                        codProd = scan.nextInt();
                                                        hist = hrDAO.buscar(codProd, hr.getData());
                                                    }
                                                }while(flag==0);
                                            }else{
                                                System.out.println("Produto n??o cadastrado!");
                                            }
                                        }
                                        
                                        System.out.println("Deseja alterar a quantidade? (1-Sim 2-N??o)");
                                        op3 = scan.nextInt();
                                        if(op3==1){ // ALTERAR QUANTIDADE
                                            System.out.println("Digite a nova quantidade:");
                                            qtd = scan.nextInt();
                                            do{
                                                if(hr.getQtd()==qtd){
                                                    System.out.println("Digite uma nova quantidade:");
                                                    qtd = scan.nextInt();
                                                    flag=0;
                                                }else{
                                                    hr.setQtd(qtd);
                                                    hrDAO.alterarQtd(qtd, hr.getData(), hr.getCodProd());
                                                    pDAO.alterarQtd(p.getCodProd(), qtd);
                                                    flag=1;
                                                }
                                            }while(flag==0);
                                        }
                                        
                                    }else{
                                        flag=0;
                                        System.out.println("N??o existe cadastro de uma reposi????o com essa data e c??digo de produto!");
                                        System.out.println("Digite novamente:");
                                        do{ 
                                            System.out.println("Digite o codigo do produto da reposi????o");
                                            codProd = scan.nextInt();
                                            p = pDAO.buscar(codProd);
                                            if(p!=null){
                                                flag2=1;
                                            }else{
                                                flag2=0;
                                            }
                                        }while(flag2==0);
                                        System.out.println("Digite a data da reposi????o:");
                                        scan.nextLine();
                                        data = scan.nextLine();
                                        hr = hrDAO.buscar(codProd, data);
                                    }
                                }while(flag==0);

                                break;

                            case 3: //BUSCAR HIST??RICO
                                
                                System.out.println("Digite o codigo do produto da reposi????o");
                                codProd = scan.nextInt();
                                System.out.println("Digite a data da reposi????o:");
                                scan.nextLine();
                                data = scan.nextLine();
                                hr = hrDAO.buscar(codProd, data);
                                if(hr!=null){
                                    System.out.println("Data de reposi????o: "+hr.getData());
                                    Produto prod = pDAO.buscar(hr.getCodProd());
                                    System.out.println("Produto reposto: "+prod.getDescricao());
                                    System.out.println("Nome do produto reposto: "+hr.getCodProd());
                                    System.out.println("Quantidade: "+hr.getQtd()); 
                                    break;
                                }else{
                                    System.out.println("N??o existe cadastro de uma reposi????o com essa data e c??digo de produto!");
                                }
                                break;
                                
                            case 4: //RELATORIO DE HIST??RICO
                                relHist = hrDAO.relatorio();
                                for(int i=0;i<relHist.size();i++){
                                    System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~");
                                    System.out.println("    REPOSI????O "+(i+1));
                                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~");
                                    System.out.println("Data de reposi????o: "+relHist.get(i).getData());
                                    Produto prod = pDAO.buscar(relHist.get(i).getCodProd());
                                    System.out.println("Produto reposto: "+prod.getDescricao());
                                    System.out.println("C??digo do produto reposto: "+relHist.get(i).getCodProd());
                                    System.out.println("Quantidade: "+relHist.get(i).getQtd()); 
                                }
                                break;

                            case 5: //EXCLUIR HIST??RICO
                                
                                System.out.println("Digite o codigo do produto da reposi????o");
                                codProd = scan.nextInt();
                                System.out.println("Digite a data da reposi????o:");
                                scan.nextLine();
                                data = scan.nextLine();
                                hr = hrDAO.buscar(codProd, data);
                                if(hr!=null){
                                    System.out.println("Data de reposi????o: "+hr.getData());
                                    Produto prod = pDAO.buscar(hr.getCodProd());
                                    System.out.println("Produto reposto: "+prod.getDescricao());
                                    System.out.println("Nome do produto reposto: "+hr.getCodProd());
                                    System.out.println("Quantidade: "+hr.getQtd()); 
                                    System.out.println("Deseja mesmo excluir essa reposi????o? (1-Sim 2-N??o)");
                                    op3 = scan.nextInt();
                                    if(op3==1){
                                        hrDAO.excluir(hr.getCodProd(), hr.getData());
                                        novaQtd = (prod.getQtd()-hr.getQtd());
                                        pDAO.alterarQtd(codProd, novaQtd);
                                    } 
                                }else
                                    System.out.println("N??o existe cadastro de uma reposi????o com essa data e c??digo de produto!");
                                break;
                        }
                        
                    }while(op2!=6);
                    break;
                    
                case 5:
                    do{
                        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                        System.out.println("      RELAT??RIOS ESPECIAIS      ");
                        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                        System.out.println("1 - Melhor Vendedor             ");
                        System.out.println("2 - Produto mais vendido - feito");
                        System.out.println("3 - Apurado (Lucro)             ");
                        System.out.println("4 - Dinheiro restante           ");
                        System.out.println("5 - Sair                        ");
                        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                        op2 = scan.nextInt();

                        switch(op2){

                            case 1: //MELHOR VENDEDOR
                                System.out.println("MELHOR VENDEDOR");
                                break;
                                
                            case 2: //PRODUTO MAIS VENDIDO
                                relProdVenda = pvDAO.relatorio();
                                maior = 0;
                                for(int i=0; i<relProdVenda.size(); i++){
                                    qtd = pvDAO.soma(relProdVenda.get(i).getCodProd());
                                    if(qtd>maior){
                                        maior = qtd;
                                        p = pDAO.buscar(relProdVenda.get(i).getCodProd());
                                    }
                                }
                                
                                System.out.println("Produto: "+p.getDescricao());
                                System.out.println("Quantidade: "+maior);
                                break;

                            case 3: //APURADO (LUCRO)
                                System.out.println("APURADO (LUCRO)");

                                relProd = pDAO.relatorio();
                                relProdVenda = pvDAO.relatorio();
                                total = 0;
                                for(int i=0;i<relProd.size();i++){
                                    total = total + (pvDAO.qtdProd(relProd.get(i).getCodProd())*relProd.get(i).getPreco());
                                }
                                System.out.println("LUCRO: "+total);

                                break;
                                
                            case 4: //DINHEIRO RESTANTE AT?? A META
                                System.out.println("DINHEIRO RESTANTE AT?? A META");
                                break;
                        }
                        
                    }while(op2!=5);
                    break;
            }
        }while(op!=6);  
    }
}
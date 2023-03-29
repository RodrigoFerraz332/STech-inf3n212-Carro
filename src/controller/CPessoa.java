/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;
import model.Pessoa;

/**
 *
 * @author 182120050
 */
/**
 * Método addPessoa adiciona Pessoa no ArrayList Pessoas
 * @author 182120050
 */
public class CPessoa {
    ArrayList <Pessoa> pessoas =new ArrayList<>();
    int idPessoa =1;
    public int geraID(){
        return this.idPessoa++;
    }//cria um auto incremente
    
    public void addPessoa(Pessoa p){
        this.pessoas.add(p);
    }//fim do void add Pessoa
    /**
     * Método removepessoa remove Pessoa do ArrayList pessoas
     * @param p 
     */
    public void removePessoa(Pessoa p){
        this.pessoas.remove(p);
        }
    public ArrayList<Pessoa> getPessoas(){
        return this.pessoas;
    }//fim do getPessoas
    public Pessoa GetPessoaCPF(String CPF){
        Pessoa p = null;
        for(Pessoa pes:pessoas){
        if (pes.getCpf().equals(CPF)) {
            p=pes;
            break;
            
        }
    }//fim do for
        return p;
    }//fim do getPessoaCPF
    
    
    
    public void mockPessoas(){
        Pessoa p1 = new Pessoa();
        p1.setIdPessoa(geraID());
        p1.setCpf("87474625075");
        p1.setNome("Juvenal das Condongas");
        p1.setTelefone("5199999999");
        p1.setEndereco("Rua das Margaridas");
        addPessoa(p1);
        Pessoa p2 = new Pessoa();
        p2.setIdPessoa(geraID());
        p2.setCpf("30303423013");
        p2.setNome("Madara da Silva");
        p2.setTelefone("51980478965");
        p2.setEndereco("Rua da Varsea");
        addPessoa(p2);
        
    }//fim do mock
}//fim da classe controller

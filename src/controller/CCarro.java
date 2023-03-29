/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import static inf3n212.carro.Inf3n212Carro.cadPessoa;
import java.util.ArrayList;
import model.Carro;

/**
 *
 * @author 182120050
 */
public class CCarro {

    ArrayList<Carro> carros = new ArrayList();

    public void addCarro(Carro c) {
        this.carros.add(c);
    }//Fim do add carros

    public void removeCarro(Carro c) {
        this.carros.remove(c);
    }//fim do remove

    public ArrayList<Carro> getCarros() {
        return this.carros;
    }//fim do arryList getCarros

    public Carro GetCarroplaca(String placa) {
        Carro c = null;
        for (Carro carro : carros) {
            if (carro.getPlaca().equals(placa)) {
                c = carro;
                break;

            }
        }//fim do for
        return c;
    }//fim do geCarroCPF
    public void mockCarros(){
        Carro c1 = new Carro();
        c1.setPlaca("IAZ6C52");
        c1.setAnoFab(2023);
        c1.setAnoMod(2023);
        c1.setMarca("Fiat");
        c1.setModelo("Palio");
        c1.setTpCambio("Manual");
        c1.setCombustivel("Flex");
        c1.setCor("Bege");
        c1.setProprietario(cadPessoa.GetPessoaCPF("30303423013"));
        addCarro(c1);
         Carro c2 = new Carro();
        c2.setPlaca("CHF4D41");
        c2.setAnoFab(2023);
        c2.setAnoMod(2023);
        c2.setMarca("Fiat");
        c2.setModelo("Marea");
        c2.setTpCambio("Manual");
        c2.setCombustivel("Flex");
        c2.setCor("Vermelho");
        c2.setProprietario(cadPessoa.GetPessoaCPF("87474625075"));
        addCarro(c2);
        
        
        
    }

}//fim da classe carros 

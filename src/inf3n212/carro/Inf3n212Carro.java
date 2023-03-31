/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package inf3n212.carro;

import controller.CCarro;
import controller.CPessoa;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author 182120050
 */
public class Inf3n212Carro {

    public static CPessoa cadPessoa = new CPessoa();
    public static CCarro cadCarro = new CCarro();
    static Scanner leia = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        cadPessoa.mockPessoas();
        cadCarro.mockCarros();
        int opM = 99;
        int opSM = 99;
        do {
            System.out.println("--Sistema de Cadastro--");
            menuP();
            opM = leiaNumint();
            switch (opM) {
                case 1:
                case 2:
                    do {
                        subMenu(opM);
                        opSM = leiaNumint();
                        switch (opSM) {
                            case 1:
                                System.out.println("Cadastra");
                                if (opM == 1) {
                                    cadastrarPessoa();
                                } else {
                                    cadastrarCarro();
                                }
                                break;
                            case 2:
                                System.out.println("Edita");
                                if (opM == 1) {
                                    editarPessoa();
                                } else {
                                    editarCarro();
                                }
                                break;
                            case 3:
                                System.out.println("Lista");
                                if (opM == 1) {
                                    listarPessoa();
                                } else {
                                    listarCarro();
                                }
                                break;
                            case 4:
                                System.out.println("Deleta");
                                if (opM == 1) {
                                    deletarPessoa();
                                } else {
                                    deletarCarro();
                                }
                                break;
                            case 0:
                                System.out.println("Volta");
                                break;

                            default:
                                System.out.println("Opção inválida,tente novamente");
                        }
                    } while (opSM != 0);

                    break;
                case 0:
                    System.out.println("Aplicação encerrada pelo usuário!");
                    break;
                default:
                    System.out.println("Opção inválida, tente novamente!");

                    throw new AssertionError();
            }//fim do Switch

        } while (opM != 0);

    }//fim do método main

    public static int leiaNumint() {
        Scanner leiaNum = new Scanner(System.in);
        try {
            return leiaNum.nextInt();
        } catch (InputMismatchException i) {
            System.out.println("Erro:" + i.getMessage() + "\nTente novamente!");
            leiaNumint();
        }
        return 99;
    }

    public static void menuP() {
        System.out.println("--Menu Principal--");
        System.out.println("1 - Ger.Pessoa");
        System.out.println("2 - Ger.Carro");
        System.out.println("0 - Sair");
        System.out.println("Digite aqui:");
    }//Fim do menu Principal

    public static void subMenu(int opM) {
        String subM = null;
        if (opM == 1) {
            subM = "Pessoa";
        }
        if (opM == 2) {
            subM = "Carro";
        }
        System.out.println("--Ger" + subM + "--");
        System.out.println("1-Cadastrar" + subM);
        System.out.println("2-Editar" + subM);
        System.out.println("3-Listar" + subM + "s");
        System.out.println("4-Deletar" + subM);
        System.out.println("0-Voltar");
        System.out.println("DIgite aqui:");
    }

    private static void cadastrarPessoa() {
        System.out.println("Pessoa");
    }

    private static void cadastrarCarro() {
        System.out.println("Carro");
    }

    private static void editarPessoa() {
        System.out.println("Pessoa");
    }

    private static void editarCarro() {
        System.out.println("Carro");
    }

    private static void listarPessoa() {
        System.out.println("Pessoa");
    }

    private static void listarCarro() {
        System.out.println("Carro");
    }

    private static void deletarPessoa() {
        System.out.println("Pessoa");
    }

    private static void deletarCarro() {
        System.out.println("Carro");
    }
}//fim da classe main

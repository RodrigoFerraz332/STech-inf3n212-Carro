/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package inf3n212.carro;

import controller.CCarro;
import controller.CPessoa;
import java.util.InputMismatchException;
import java.util.Scanner;
import model.Carro;
import model.Pessoa;
import util.Validadores;

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
        System.out.println("--Cadastro de Pessoa--");
        int idPessoa;
        String nome;
        String cpf;
        String endereco;
        String telefone;
        boolean tcpf = true;
        do {
            System.out.println("--Informe o CPF--");
            cpf = leia.nextLine();
            tcpf = Validadores.isCPF(cpf);
            if (tcpf) {
                if (cadPessoa.GetPessoaCPF(cpf) != null) {
                    System.out.println("--CPF já cadastrado!--");
                    System.out.println("1- Tentar novamente");
                    System.out.println("2- Cancelar cadastro");
                    System.out.println("Digite aqui:");
                    int op = leiaNumint();
                    if (op == 2) {
                        return;
                    }
                } else {
                    tcpf = false;
                }
            } else {
                System.out.println("CPF inválido");
                System.out.println("1- Tentar novamente");
                System.out.println("2- Cancelar cadastro");
                System.out.println("Digite aqui:");
                int op = leiaNumint();
                if (op == 2) {
                    return;
                }

                tcpf = true;

            }
        } while (tcpf);
        System.out.println("Passou CPF!");
        System.out.println("Informe o nome");
        nome = leia.nextLine();
        System.out.println("Informe o endereço");
        endereco = leia.nextLine();
        System.out.println("Informe o telefone");
        telefone = leia.nextLine();
        idPessoa = cadPessoa.geraID();
        Pessoa p = new Pessoa(idPessoa, nome, cpf, endereco, telefone);
        cadPessoa.addPessoa(p);
        System.out.println(p.getNome() + "cadastrado com sucesso!");

    }//fim do cadPessoa

    private static void cadastrarCarro() {
        System.out.println("--Cadastro Carro--");
        String placa;
        String marca;
        String modelo;
        int anoFab;
        int anoMod;
        String cor;
        String tpCambio;
        String combustivel;
        Pessoa proprietario;
        boolean pCarro = true;
        do {
            System.out.println("informe a Placa");
            placa = leia.nextLine();
            placa = placa.toUpperCase();
            pCarro = Validadores.verificaPlacaMercosul(placa);
            if (pCarro) {
                Carro carro = cadCarro.GetCarroplaca(placa);
                if (carro == null) {
                    System.out.println("Informe a marca:");
                    marca = leia.nextLine();
                    System.out.println("Informe o modelo");
                    modelo = leia.nextLine();
                    do {
                        System.out.println("Informe o ano fab.:");
                        anoFab = leiaNumint();
                        System.out.println("informe o ano modelo:");
                        anoMod = leiaNumint();
                        if (!Validadores.validarAnoCarro(anoFab, anoMod)) {
                            System.out.println("Ano inválido,tente novamente!");
                        }
                    } while (!Validadores.validarAnoCarro(anoFab, anoMod));
                    System.out.println("Informe a cor:");
                    cor = leia.nextLine();
                    System.out.println("informe o tipo de câmbio:");
                    tpCambio = leia.nextLine();
                    System.out.println("informe o combustivel:");
                    combustivel = leia.nextLine();
                    do {
                        System.out.println("informe o CPF do proprietário:");
                        String cpf = leia.nextLine();
                        proprietario = cadPessoa.GetPessoaCPF(cpf);
                        if (proprietario == null) {
                            System.out.println("CPF não cadastrado," + "tente novamente!");
                        } else {
                            System.out.println("Pessoa selecionada:" + proprietario.getNome());
                            System.out.println("Este é o proproetário?");
                            System.out.println("1-SIm|2-não");
                            System.out.println("Digite aqui:");
                            int op = leiaNumint();
                            if (op == 2) {
                                proprietario = null;
                            } else {
                                System.out.println("Tente outro CPF. ");
                            }
                        }
                    } while (proprietario == null);
                    pCarro = false;
                    Carro c = new Carro(placa, marca, modelo, anoFab, anoMod, cor, tpCambio, combustivel, proprietario);
                    cadCarro.addCarro(c);
                    System.out.println("Carro cadastrado com sucesso!");
                } else {
                    System.out.println("Placa ja cadastrada.");
                    pCarro = false;
                }
            } else {
                System.out.println("Placa inváida! Tente novamente");
                pCarro = true;
            }

        } while (pCarro);
    }//fim do cadastrar carro

    private static void editarPessoa() {
        System.out.println("--Editar Pessoa--");
        boolean isCPF;
        do {//faça
            System.out.println("Informe o CPF da Pessoa a ser editado");
            String cpf = leia.nextLine();
            isCPF = Validadores.isCPF(cpf);
            if (isCPF) {
                Pessoa p = cadPessoa.GetPessoaCPF(cpf);
                if (p != null) {
                    do {
                        System.out.println("Quais dados de " + p.getNome() + "deseja alterar?");
                        System.out.println("1-Nome");
                        System.out.println("2-Endereço");
                        System.out.println("3-Telefone");
                        System.out.println("4-Todos");
                        System.out.println("0-Voltar");
                        System.out.println("Digite a opção");
                        int op = leiaNumint();
                        if (op == 1 || op == 4) {
                            System.out.println("Informe o novo nome:");
                            p.setNome(leia.nextLine());

                        }
                        if (op == 1 || op == 4) {
                            System.out.println("Informe o novo Endereço:");
                            p.setEndereco(leia.nextLine());

                        }
                        if (op == 1 || op == 4) {
                            System.out.println("Informe o novo Telefone:");
                            p.setTelefone(leia.nextLine());

                        }
                        if (op == 0) {
                            System.out.println("Operação cancelada pelo usuário!");
                            isCPF = false;
                            if (op < 0 || op > 4) {
                                System.out.println("Opção invalida,tente novamente!");

                            }
                        }
                    } while (isCPF);
                } else {
                    System.out.println("Cpf não cadastrado!");
                    isCPF = false;
                }

            } else {
                System.out.println("CPF inválido!");
                System.out.println("Deseja tentar novamente?\n 1-Sim| 2-Não:");
                int op = leiaNumint();
                if (op == 1) {
                    isCPF = true;

                } else {
                    isCPF = false;
                }
            }
        } while (isCPF);//enquanto
    }//Fim do Editar

    private static void editarCarro() {
        System.out.println("--Editar Carro--");
        boolean isPlaca;
        do {
            System.out.println("Informe a placa");
            String placa = leia.nextLine();
            placa = placa.toUpperCase();
            isPlaca = Validadores.verificaPlacaMercosul(placa);
            if (isPlaca) {
                Carro c;
                c = cadCarro.GetCarroplaca(placa);
                if (c != null) {
                    System.out.println(c.toString());
                    System.out.println("O que deseja alterar?");
                    System.out.println("1-Cor");
                    System.out.println("2-Tipo de Câmbio");
                    System.out.println("3-Tipo de combustivel");
                    System.out.println("4-Proprietário");
                    System.out.println("5-Todos");
                    System.out.println("0-Cancelar");
                    System.out.println("0-Cancelar");
                    System.out.println("Digite sua escolha aqui:");
                    int op = leiaNumint();
                    if (op == 1 || op == 5) {
                        System.out.println("Informe a nova cor:");
                        c.setCor(leia.nextLine().toUpperCase());
                    }
                    if (op == 2 || op == 5) {
                        System.out.println("Informe o novo Câmbio:");
                        c.setTpCambio(leia.nextLine().toUpperCase());
                    }
                    if (op == 3 || op == 5) {
                        System.out.println("Informe o novo combustível:");
                        c.setCombustivel(leia.nextLine().toUpperCase());
                    }
                    if (op == 4 || op == 5) {
                        boolean isCPF;
                        do {
                            System.out.println("Informe o novo proprietário");
                            String cpf = leia.nextLine();
                            isCPF = Validadores.isCPF(cpf);
                            if (isCPF) {
                                Pessoa p = cadPessoa.GetPessoaCPF(cpf);
                                if (p != null) {
                                    System.out.println("Pessoa selecionada:" + p.getNome());
                                    System.out.println("Está correto");
                                    System.out.println("1-Sim|2-Não");
                                    System.out.println("Digite aqui:");
                                    op = leiaNumint();
                                    if (op == 1) {
                                        isCPF = false;
                                        c.setProprietario(p);
                                    }

                                } else {
                                    System.out.println("CPF não cadastrado!");
                                    System.out.println("1- Cadastrar?");
                                    System.out.println("2-Tentar novamente?");
                                    System.out.println("Digite aqui sua opção:");
                                    int op2 = leiaNumint();
                                    if (op2 == 1) {
                                        cadastrarPessoa();
                                    }
                                }
                            }else{
                                System.out.println("CPF inválido, tente novamente!");
                                isCPF=true;
                            }
                        } while (isCPF);
                        System.out.println("Informe o novo proprietário");

                    }
                    if (op == 0) {
                        System.out.println("Edição do carro cancelada pelo usuário!");
                        isPlaca = false;
                    }
                    if (op < 0 || op > 5) {
                        System.out.println("Opção inválida");
                    }
                } else {
                    System.out.println("Placa não cadastrada");
                    isPlaca = true;
                }

            } else {
                System.out.println("Placa informada Inválida");
                System.out.println("Deseja tentar novamente?");
                System.out.println("1-Sim|2-Não-cancelar");
                System.out.println("digite aqui:");
                int op = leiaNumint();
                if ((op == 1)) {
                    isPlaca = true;
                }

            }
        } while (isPlaca);
    }//fim do editar

    private static void listarPessoa() {
        System.out.println("--Lista de Pessoas--");
        for (Pessoa pessoa : cadPessoa.getPessoas()) {
            System.out.println(pessoa.toString());
        }
    }//fim do lista Pessoa

    private static void listarCarro() {
        System.out.println("--Lista de Carros--");
        for (Carro carro : cadCarro.getCarros()) {
            System.out.println(carro.toString());
        }
    }//fim do listar carro

    private static void deletarPessoa() {
        System.out.println("--Deletar Pessoa--");
        boolean delCPF;
        do {
            System.out.println("Informe o CPF da Pessoa a ser deletada:");
            String cpf = leia.nextLine();
            delCPF = Validadores.isCPF(cpf);
            if (delCPF) {
                Pessoa p = cadPessoa.GetPessoaCPF(cpf);
                if (p != null) {
                    System.out.println("Deseja realmente deletar" + p.getNome() + "?");
                    System.out.println("1 - Sim | 2 - Não");
                    int op = leiaNumint();
                    if (op == 1) {
                        cadPessoa.removePessoa(p);
                        System.out.println("Pessoa deletada com sucesso!");
                        delCPF = false;

                    } else {
                        System.out.println("Operação cancelada pelo usuário");
                        delCPF = false;
                    }
                } else {
                    System.out.println("CPF não cadastrado!");
                    System.out.println("Deseja tentar novamente?");
                    System.out.println("1-Sim | 2-Não:");
                    int op = leiaNumint();
                    if (op == 1) {
                        delCPF = true;
                    } else {
                        delCPF = false;
                    }

                }

            } else {
                System.out.println("CPF inválido!" + "\nTente novamente.");
                delCPF = true;
            }
        } while (delCPF);

    }//fim do deletar pessoa

    private static void deletarCarro() {
        System.out.println("--Deletar Carro--");
        boolean delCarro;
        do {
            System.out.println("Informe a palca do carro a ser deletada:");
            String placa = leia.nextLine();
            placa = placa.toUpperCase();
            delCarro = Validadores.verificaPlacaMercosul(placa);
            if (delCarro) {
                Carro c = cadCarro.GetCarroplaca(placa);
                if (c != null) {
                    System.out.println("Deseja realmente deletar esse carro " + c.getPlaca() + "?");
                    System.out.println("1 - Sim | 2 - Não");
                    int op = leiaNumint();
                    if (op == 1) {
                        cadCarro.removeCarro(c);
                        System.out.println("Carro deletada com sucesso!");
                        delCarro = false;
                    } else {
                        System.out.println("Operação cancelada pelo usuário");
                        delCarro = false;
                    }
                }
            }
        } while (delCarro);
    }//fim do deletar carro 
}//fim da classe main

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.time.LocalDate;
import java.util.InputMismatchException;

/**
 *
 * @author 182120050
 */
public class Validadores {

    public static boolean isCPF(String CPF) {
        // considera-se erro CPF's formados por uma sequencia de numeros iguais
        if (CPF.equals("00000000000")
                || CPF.equals("11111111111")
                || CPF.equals("22222222222") || CPF.equals("33333333333")
                || CPF.equals("44444444444") || CPF.equals("55555555555")
                || CPF.equals("66666666666") || CPF.equals("77777777777")
                || CPF.equals("88888888888") || CPF.equals("99999999999")
                || (CPF.length() != 11)) {
            return (false);
        }

        char dig10, dig11;
        int sm, i, r, num, peso;

        // "try" - protege o codigo para eventuais erros de conversao de tipo (int)
        try {
            // Calculo do 1o. Digito Verificador
            sm = 0;
            peso = 10;
            for (i = 0; i < 9; i++) {
                // converte o i-esimo caractere do CPF em um numero:
                // por exemplo, transforma o caractere '0' no inteiro 0
                // (48 eh a posicao de '0' na tabela ASCII)
                num = (int) (CPF.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11)) {
                dig10 = '0';
            } else {
                dig10 = (char) (r + 48); // converte no respectivo caractere numerico
            }
            // Calculo do 2o. Digito Verificador
            sm = 0;
            peso = 11;
            for (i = 0; i < 10; i++) {
                num = (int) (CPF.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11)) {
                dig11 = '0';
            } else {
                dig11 = (char) (r + 48);
            }

            // Verifica se os digitos calculados conferem com os digitos informados.
            if ((dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10))) {
                return (true);
            } else {
                return (false);
            }
        } catch (InputMismatchException erro) {
            return (false);
        }
    }

    public static String imprimeCPF(String CPF) {
        return (CPF.substring(0, 3) + "." + CPF.substring(3, 6) + "."
                + CPF.substring(6, 9) + "-" + CPF.substring(9, 11));
    }

    public static boolean verificaPlacaMercosul(String placa) {
        // Expressão regular para verificar se a placa é válida
        String regex = ("[A-Z]{3}[0-9]{1}[A-Z]{1}[0-9]{2}|[A-Z]{3}[0-9]{4}");

        // Verifica se a placa corresponde à expressão regular
        return placa.matches(regex);
    }

    public static boolean validarRenavam(String renavam) {
        int[] pesos = {3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
        int soma = 0;

        // Verifica se o Renavam possui 11 dígitos
        if (renavam == null || renavam.length() != 11) {
            return false;
        }

        // Calcula a soma dos produtos dos dígitos do Renavam pelos pesos correspondentes
        for (int i = 0; i < 10; i++) {
            soma += Integer.parseInt(String.valueOf(renavam.charAt(i))) * pesos[i];
        }

        // Calcula o dígito verificador
        int dv = soma % 11;
        if (dv == 10) {
            dv = 0;
        }

        // Verifica se o dígito verificador é igual ao último dígito do Renavam
        return dv == Integer.parseInt(String.valueOf(renavam.charAt(10)));

    }

    public static boolean validarAnoCarro(int anoFab, int anoMod) {
        boolean anoOK = true;
        int anoAtual = LocalDate.now().getYear();
        if (anoMod < anoFab) {
            anoOK = false;
        }
        if (anoMod - anoFab >= 2) {
            anoOK = false;
            if (anoFab > anoAtual ||anoMod> anoAtual + 1) {
                anoOK = false;
            }

        }
        return anoOK;
    }
}//fim da classe

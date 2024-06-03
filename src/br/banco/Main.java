package br.banco;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null,"Bem vindo ao seu banco digital");
        Cliente cliente1 = new Cliente();
        cliente1.setNome(JOptionPane.showInputDialog("Nome do cliente: "));
        cliente1.setCpf(Integer.valueOf(JOptionPane.showInputDialog("Digite o cpf: ")));

        Conta contaCC = new ContaCorrente(cliente1);
        Conta contaPP = new ContaPoupanca(cliente1);

//        Testando todas as funçoes
        contaCC.depositar(50);
        contaCC.sacar(25);
        contaCC.transferir(10, contaPP);

        contaCC.imprimirExtrato();
        contaPP.imprimirExtrato();
    }
}

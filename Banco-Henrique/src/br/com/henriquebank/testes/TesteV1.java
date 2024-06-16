package br.com.henriquebank.testes;


import java.util.Random;

import javax.swing.JOptionPane;
import br.com.henriquebank.contas.*;

public class TesteV1 {

	public static void main(String[] args) {
		Random random = new Random();
		String[] opcoesConta = {"Conta Corrente", "Conta Poupança"};
		int escolhaConta = JOptionPane.showOptionDialog(null, "Escolha o tipo de conta", "Tipo de Conta",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoesConta, opcoesConta[0]);
		Conta conta;
		if (escolhaConta==0) {
			JOptionPane.showMessageDialog(null, "Você escolheu Conta Corrente!\nSiga os passos a seguir"); 
			
			String[] opcoesNumAgencia = {"3812", "4109", "5221"};
			int escolhaNumAgenciaStr = JOptionPane.showOptionDialog(null, "Escolha o número da Agência", "Agências:",
	                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoesNumAgencia, opcoesNumAgencia[0]);
				if(escolhaNumAgenciaStr==0) {
					JOptionPane.showMessageDialog(null, "A agência escolhida foi: 3812");
				}else if(escolhaNumAgenciaStr==1) {
					JOptionPane.showMessageDialog(null, "A agência escolhida foi: 4109");
				}else if(escolhaNumAgenciaStr==2) {
					JOptionPane.showMessageDialog(null, "A agência escolhida foi: 5221");
				}
				
			 int numConta = random.nextInt(9000)+1000;
			 
			 String titular = JOptionPane.showInputDialog("Digite o nome do Titular: ");
			 
			 double limite = 200.0;
			 conta = new ContaCorrente(escolhaNumAgenciaStr, numConta, titular, limite);
		}else if(escolhaConta==1) {
			JOptionPane.showMessageDialog(null, "Você escolheu Conta Poupança!\nSiga os passos a seguir"); 
			
			String[] opcoesNumAgencia = {"3812", "4109", "5221"};
			int escolhaNumAgenciaStr = JOptionPane.showOptionDialog(null, "Escolha o número da Agência", "Agências:",
	                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoesNumAgencia, opcoesNumAgencia[0]);
				if(escolhaNumAgenciaStr==0) {
					JOptionPane.showMessageDialog(null, "A agência escolhida foi: 3812");
				}else if(escolhaNumAgenciaStr==1) {
					JOptionPane.showMessageDialog(null, "A agência escolhida foi: 4109");
				}else if(escolhaNumAgenciaStr==2) {
					JOptionPane.showMessageDialog(null, "A agência escolhida foi: 5221");
				}
				
			 int numConta = random.nextInt(9000)+1000;
			 
			 String titular = JOptionPane.showInputDialog("Digite o nome do Titular: ");
			 
			 int limiteChequeEspecialpoup = 80;
			 JOptionPane.showMessageDialog(null, "Você recebeu um Cheque Especial de R$80,00!");
			 
			 conta = new ContaPoupanca(escolhaNumAgenciaStr, numConta, titular, limiteChequeEspecialpoup);
		}else {
			JOptionPane.showMessageDialog(null, "Opção inválida!");
			return;
		}
		JOptionPane.showMessageDialog(null, "A sua conta é: \nAgência ==> "+conta.getNumAgencia()+"\nConta ==> "+conta.getNumConta()+
				"\nTitular ==> "+conta.getTitular()+"\nSaldo ==> "+conta.getSaldo()+"\nTipo ==> "+escolhaConta);
		
		boolean executando = true;
		
		while(executando) {
			String[] opcoesOperacao = {"Depositar", "Sacar", "Mostrar Saldo", "Sair"};
            int escolhaOperacao = JOptionPane.showOptionDialog(null, "Escolha uma operação", "Operações",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoesOperacao, opcoesOperacao[0]);
            if(escolhaOperacao==0) {
            	String valorDepositoStr =JOptionPane.showInputDialog("Digite o valor a ser depositado: \nOBS.:Haverá um adicional de R$2,00\npara contas poupança.");
            	double valorDeposito = Double.parseDouble(valorDepositoStr);
            	if (valorDeposito >0) {
            		conta.deposito(valorDeposito);
            		JOptionPane.showMessageDialog(null, "Valor de R$"+valorDeposito+" foi depositado!");
            	}else if (valorDeposito <0){
            		JOptionPane.showMessageDialog(null, "Valor Incorreto! Digite um número positivo");
            	}	
            }else if(escolhaOperacao==1) {
            	String valorSaqueStr =JOptionPane.showInputDialog("Digite o valor a ser sacado:  \nOBS.:Taxa de R$1,00 para Contas Correntes");
            	double valorSaque = Double.parseDouble(valorSaqueStr);
            	if(valorSaque <= conta.getSaldo()) {
            		conta.sacar(valorSaque);
            		JOptionPane.showMessageDialog(null, "Valor de R$"+valorSaque+" foi sacado!");
            	}else if (valorSaque < 0){
            		JOptionPane.showMessageDialog(null, "Valor Inválido!");
            	}else if(valorSaque > conta.getSaldo()) {
            		JOptionPane.showMessageDialog(null, "Valor ultrapassa o saldo!");
            	}
            }else if(escolhaOperacao==2) {
            	JOptionPane.showMessageDialog(null, "Seu saldo é de \n ==> R$"+conta.getSaldo());
            }else if(escolhaOperacao==3) {
            	executando=false;
            }
            
		}
		
	}
}

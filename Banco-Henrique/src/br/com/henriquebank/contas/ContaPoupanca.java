package br.com.henriquebank.contas;

import javax.swing.JOptionPane;

public class ContaPoupanca extends Conta{

	public static final double TAXA_DEPOSITO_JUROS_CONTA_POUPANCA = 0.02*100;
	private int limiteChequeEspecial;

	public ContaPoupanca(int numAgencia, int numConta, String titular, int limiteChequeEspecial) {
		super(numAgencia, numConta, titular);
		this.limiteChequeEspecial = limiteChequeEspecial;
	}

	public ContaPoupanca(int numAgencia, int numConta, String titular, double saldo, int limiteChequeEspecial) {
		super(numAgencia, numConta, titular, saldo);
		this.limiteChequeEspecial = limiteChequeEspecial;
	}

	public int getLimiteChequeEspecial() {
		return limiteChequeEspecial;
	}

	public void setLimiteChequeEspecial(int limiteChequeEspecial) {
		this.limiteChequeEspecial = limiteChequeEspecial;
	}
	
	
	public void deposito(double valor) {
		double depositoLimite = getSaldo()+TAXA_DEPOSITO_JUROS_CONTA_POUPANCA; 
		if(valor>0 && valor<=depositoLimite) {
		valor = valor+TAXA_DEPOSITO_JUROS_CONTA_POUPANCA;
		super.deposito(valor);
		}else {
			JOptionPane.showMessageDialog(null, "Valor inválido!");
		}
	}
	
	public void sacar(double valor) {
		double limiteSaque=getSaldo()+limiteChequeEspecial;
		if(valor>0 && valor<=limiteSaque) {
			super.sacar(valor);
			}else {
				JOptionPane.showMessageDialog(null, "Você não tem fundos!");
			}
		}
}

package br.com.henriquebank.contas;

import javax.swing.JOptionPane;

public class ContaCorrente extends Conta{

	public static final double TAXA_SAQUE_CONTA_CORRENTE = 1;
	private double limiteChequeEspecial=200.0;

	public ContaCorrente(int numAgencia, int numConta, String titular, double limiteChequeEspecial) {
		super(numAgencia, numConta, titular);
		this.limiteChequeEspecial = limiteChequeEspecial;
	}

	public ContaCorrente(int numAgencia, int numConta, String titular, double saldo, double limiteChequeEspecial) {
		super(numAgencia, numConta, titular, saldo);
		this.limiteChequeEspecial = limiteChequeEspecial;
	}

	public double getLimiteChequeEspecial() {
		return limiteChequeEspecial;
	}

	public void setLimiteChequeEspecial(double limiteChequeEspecial) {
		this.limiteChequeEspecial = limiteChequeEspecial;
	}
	public void deposito(double valor) {
		if(valor>0) {
		super.deposito(valor);
		}else {
			JOptionPane.showMessageDialog(null, "Valor inválido!");
		}
	}
	public void sacar(double valor) {
		double limiteSaque=getSaldo()+limiteChequeEspecial;
		if(valor>0 && valor<=limiteSaque) {
		valor = valor+TAXA_SAQUE_CONTA_CORRENTE;
		super.sacar(valor);
		}else {
			JOptionPane.showMessageDialog(null, "Você não tem fundos!");
		}
	}
	
}

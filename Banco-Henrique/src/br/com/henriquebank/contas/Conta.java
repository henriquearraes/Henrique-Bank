package br.com.henriquebank.contas;

import java.util.Objects;


public class Conta {

	private int numAgencia;
	private int numConta;
	private String titular;
	private double saldo=0.0;
	
	public Conta(int numAgencia, int numConta, String titular) {
		this.numAgencia = numAgencia;
		this.numConta = numConta;
		this.titular = titular;
	}
	/**
	 * @param numAgencia numero da agencia
	 * @param numConta numero da conta
	 * @param titular nome do titular da conta
	 * @param saldo saldo do titular
	 */
	public Conta(int numAgencia, int numConta, String titular, double saldo) {
		this.numAgencia = numAgencia;
		this.numConta = numConta;
		this.titular = titular;
		this.saldo = saldo;
	}
	/**
	 * 
	 * @param valor valor a ser colocado pelo usuario (deposito ou saque)
	 * @return
	 */
	public void sacar (double valor) {
		saldo-=valor;
	}

	public void deposito (double valor) {
		  saldo+=valor;
	}
	
	public int getNumAgencia() {
		return numAgencia;
	}
	public void setNumAgencia(int numAgencia) {
		this.numAgencia = numAgencia;
	}
	public int getNumConta() {
		return numConta;
	}
	public void setNumConta(int numConta) {
		this.numConta = numConta;
	}
	public String getTitular() {
		return titular;
	}
	public void setTitular(String titular) {
		this.titular = titular;
	}
	public double getSaldo() {
		return saldo;
	}
	@Override
	public int hashCode() {
		return Objects.hash(numAgencia, numConta);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Conta other = (Conta) obj;
		return numAgencia == other.numAgencia && numConta == other.numConta;
	}
}

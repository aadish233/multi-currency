package com.aadish.tdd.mcurrency;

public class Money implements Expression {
	protected int amount;
	protected String currency;
	
	public Money(int amount, String currency) {
		this.amount = amount;
		this.currency = currency;
	}

	protected String currency() {
		return this.currency;
	}
	
	public static Money dollar(int amount) {
		return new Money(amount, "USD");
	}
	
	public static Money franc(int amount) {
		return new Money(amount, "CHF");
	}
	
	@Override
	public Expression times(int multiplier) {
		return new Money(this.amount * multiplier, this.currency);
	}
	
	@Override
	public Money reduce(Bank bank, String to) {
		return new Money(this.amount / bank.rate(this.currency, to), to);
	}
	
	public boolean equals(Object other) {
		Money money = (Money) other;
		return this.amount == money.amount 
				&& this.currency == money.currency;
	}

	@Override
	public String toString() {
		return "Money [amount=" + amount + ", currency=" + currency + "]";
	}
	
	@Override
	public Expression plus(Expression addend) {
		return new Sum(this, addend);
	}
}

package com.aadish.tdd.mcurrency;

public class Money {
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
	
	public Money times(int multiplier) {
		return new Money(this.amount * multiplier, this.currency);
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
}

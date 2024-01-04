package com.aadish.tdd.mcurrency;

public class Sum implements Expression {
	
	Expression augend;
	Expression addend;

	public Sum(Expression augend, Expression addend) {
		this.addend = addend;
		this.augend = augend;
	}
	
	@Override
	public Money reduce(Bank bank, String to) {
		int amount = this.augend.reduce(bank, to).amount + this.addend.reduce(bank, to).amount;
		return new Money(amount, to);
	}
	
	@Override
	public Expression plus(Expression addend) {
		return new Sum(this, addend);
	}
	
	@Override
	public Expression times(int i) {
		return new Sum(this.augend.times(i), this.addend.times(i));
	}

}

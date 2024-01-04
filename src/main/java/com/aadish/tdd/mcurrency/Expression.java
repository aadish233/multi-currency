package com.aadish.tdd.mcurrency;

public interface Expression {
	public Money reduce(Bank bank, String to);
	Expression plus(Expression addend);
	Expression times(int multiplier);
}

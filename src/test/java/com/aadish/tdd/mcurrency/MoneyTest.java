package com.aadish.tdd.mcurrency;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

public class MoneyTest {
	
	@Test
	void testMultiplication() {
		Money five = Money.dollar(5);
		assertEquals(Money.dollar(10), five.times(2));
		assertEquals(Money.dollar(15), five.times(3));
		
		Money fiveF = Money.franc(5);
		assertEquals(Money.franc(10), fiveF.times(2));
	}
	
	@Test
	void testEqualityDollar() {
		assertEquals(Money.dollar(5), Money.dollar(5));
		assertNotEquals(Money.dollar(5),Money.dollar(8));
		assertNotEquals(Money.dollar(5),Money.franc(5));
		assertEquals(Money.franc(5), Money.franc(5));
		assertNotEquals(Money.franc(5),Money.franc(8));
	}
	
	@Test
	void testCurrency() {
		assertEquals("CHF", Money.franc(1).currency());
		assertEquals("USD", Money.dollar(1).currency());
	}
	
	@Test
	void testSimpleAddition() {
		Money five = Money.dollar(5);
		Expression expression = five.plus(five);
		Bank bank = new Bank();
		Money money = bank.reduce(expression, "USD");
		assertEquals(Money.dollar(10), money);
	}
}

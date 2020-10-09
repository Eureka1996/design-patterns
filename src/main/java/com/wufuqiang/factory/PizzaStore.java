package com.wufuqiang.factory;

import com.wufuqiang.factory.order.OrderPizza;

public class PizzaStore {
	public static void main(String[] args) {
		//new OrderPizza();
		new OrderPizza(new SimpleFactory());
	}
}

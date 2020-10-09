package com.wufuqiang.factory.order;

import com.wufuqiang.factory.CheesePizza;
import com.wufuqiang.factory.GreekPizza;
import com.wufuqiang.factory.Pizza;
import com.wufuqiang.factory.SimpleFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OrderPizza {

	SimpleFactory simpleFactory ;

	public OrderPizza() {
		/*Pizza pizza = null;
		String orderType;
		do{
			orderType = getType();
			if(orderType.equals("greek")){
				pizza = new GreekPizza();
				pizza.setName("希腊披萨");
			}else if(orderType.equals("cheese")){
				pizza = new CheesePizza();
				pizza.setName("奶酪披萨");
			}else{
				break;
			}
			pizza.prepare();
			pizza.bake();
			pizza.cut();
			pizza.box();
		}while(true);*/
	}

	public OrderPizza(SimpleFactory simpleFactory) {
//		this.simpleFactory = simpleFactory;
		setFactory(simpleFactory);
	}

	public void setFactory(SimpleFactory simpleFactory){
		this.simpleFactory = simpleFactory;
		String orderType;
		Pizza pizza = null;
		do{
			orderType = getType();
			pizza = this.simpleFactory.createPizza(orderType);
			if(pizza != null){
				pizza.prepare();
				pizza.bake();
				pizza.cut();
				pizza.box();
			}else{
				System.out.println("订购披萨失败，无此类型的披萨。");
			}

		}while(true);
	}

	private String getType(){
		try{
			BufferedReader strin = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("input pizza type:");
			String str = strin.readLine();
			return str;
		}catch (IOException e) {
			e.printStackTrace();
		}

		return "";
	}
}

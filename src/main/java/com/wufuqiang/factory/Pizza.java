package com.wufuqiang.factory;


import lombok.Data;

@Data
public abstract class Pizza {
	private String name;

	public abstract void prepare();

	public void bake(){
		System.out.println(this.name + "baking");
	}

	public void cut(){
		System.out.println(this.name+"cutting");
	}

	public void box(){
		System.out.println(this.name+"boxing");
	}
}

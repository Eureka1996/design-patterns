package com.wufuqiang.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkFuDao implements InvocationHandler {

    private IPerson target ;

    public IPerson getInstance(IPerson target){
        this.target = target;
        Class<? extends IPerson> clazz = target.getClass();
        // 生成代理对象
        // ClassLoader loader:当前目标对象使用的类加载器，获取类加载器的方法是固定的
        // Class<?>[] interfaces:目标对象实现的接口类型，使用泛型方法确认类型
        // InvocationHandler h：事件处理，执行目标对象的方法时，
        //                      会触发事件处理器方法，会把当前执行的目标对象方法作为参数传入
        System.out.println("类加载器："+clazz.getClassLoader());
        for (Class<?> anInterface : clazz.getInterfaces()) {
            System.out.println(anInterface.getName());
        }
        System.out.println("interfaces："+clazz.getInterfaces().length);
        return (IPerson)Proxy.newProxyInstance(clazz.getClassLoader(),
                clazz.getInterfaces(),this);
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        method.invoke(this.target,args);
        after();
        return null;
    }

    public void before(){
        System.out.println("代理对象在准备中...........");
    }

    public void after(){
        System.out.println("已经完成代理工作，正在进行收尾。");
    }
}

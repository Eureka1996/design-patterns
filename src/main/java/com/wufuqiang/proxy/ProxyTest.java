package com.wufuqiang.proxy;

public class ProxyTest {
    public static void main(String[] args) {
        Proxy proxy = new Proxy();
        proxy.request();
    }
}

// 抽象主题
interface Subject{
    void request();
}

// 真实主题
class RealSubject implements Subject{

    public void request() {
        System.out.println("真实主题：在做实际的操作。");
    }
}

// 代理类
class Proxy implements Subject{

    private RealSubject realSubject;

    public void preRequest(){
        System.out.println("访问真实主题之前的操作");
    }

    public void request() {
        if(realSubject == null){
            realSubject = new RealSubject();
        }
        preRequest();
        realSubject.request();
        postRequest();
    }

    public void postRequest(){
        System.out.println("访问真实主题之后的操作。");
    }
}


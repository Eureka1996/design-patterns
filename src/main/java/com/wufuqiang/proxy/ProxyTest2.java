package com.wufuqiang.proxy;

import java.lang.reflect.Method;

public class ProxyTest2 {
    public static void main(String[] args) {
        JdkFuDao jdkFuDao = new JdkFuDao();
        IPerson wufuqiang = jdkFuDao.getInstance(new WuFuqiang());

        for (Method method : wufuqiang.getClass().getMethods()) {
            System.out.println("-----:"+method.getName());
        }
        System.out.println("wufuqiang:"+wufuqiang);
        System.out.println(wufuqiang.getClass().getName());
        wufuqiang.findTeacher();
        System.out.println("-------########---------------");
        wufuqiang.eat();
    }
}

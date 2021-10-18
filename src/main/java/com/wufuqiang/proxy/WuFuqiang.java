package com.wufuqiang.proxy;

import java.io.Serializable;

public class WuFuqiang implements IPerson, Serializable {
    public void findTeacher() {
        System.out.println("吴福强小朋友需要一个辅导老师。");
    }

    public void eat(){
        System.out.println("吴福强开始吃饭了");
    }
}

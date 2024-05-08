package com.autonavi.base.amap.mapcore;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class LinkInfo {
    private int state = 0;
    private int time = 0;
    private int length = 0;

    public int getLength() {
        return this.length;
    }

    public int getState() {
        return this.state;
    }

    public int getTime() {
        return this.time;
    }

    public void setLength(int i10) {
        this.length = i10;
    }

    public void setState(int i10) {
        this.state = i10;
    }

    public void setTime(int i10) {
        this.time = i10;
    }

    public String toString() {
        return "状态：" + this.state + "|时间：" + this.time + "|长度：" + this.length;
    }
}

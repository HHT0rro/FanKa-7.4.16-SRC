package com.alibaba.security.realidentity;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public enum RPEnv {
    ONLINE(0, "线上"),
    PRE(1, "预发"),
    DAILY(2, "日常");

    public int code;
    public String label;

    RPEnv(int i10, String str) {
        this.code = i10;
        this.label = str;
    }
}

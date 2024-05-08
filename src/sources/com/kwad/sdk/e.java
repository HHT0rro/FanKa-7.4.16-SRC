package com.kwad.sdk;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class e {
    public static final e akC = new e(10000, "其他异常");
    public static final e akD = new e(10001, "初始化参数异常");
    public int code;
    public String msg;

    public e(int i10, String str) {
        this.code = i10;
        this.msg = str;
    }
}

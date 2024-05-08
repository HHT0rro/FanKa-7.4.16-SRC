package com.baidu.mobads.sdk.internal;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public enum bo {
    INTERFACE_USE_PROBLEM(1010001, "接口使用问题"),
    SHOW_STANDARD_UNFIT(3040001, "容器大小不达标");


    /* renamed from: c, reason: collision with root package name */
    public static final String f9922c = "msg";

    /* renamed from: d, reason: collision with root package name */
    private int f9924d;

    /* renamed from: e, reason: collision with root package name */
    private String f9925e;

    bo(int i10, String str) {
        this.f9924d = i10;
        this.f9925e = str;
    }

    public int b() {
        return this.f9924d;
    }

    public String c() {
        return this.f9925e;
    }
}

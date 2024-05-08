package com.mobile.auth.m;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private int f37500a;

    /* renamed from: b, reason: collision with root package name */
    private String f37501b;

    private a(int i10, String str) {
        this.f37500a = i10;
        this.f37501b = str;
    }

    public static a a(int i10) {
        switch (i10) {
            case 102102:
                return new a(102102, "网络异常");
            case 102223:
                return new a(102223, "数据解析异常");
            case 102508:
                return new a(102508, "数据网络切换失败");
            case 200025:
                return new a(200025, "登录超时");
            case 200039:
                return new a(200039, "电信取号接口失败");
            case 200050:
                return new a(200050, "EOF异常");
            default:
                return new a(i10, "网络异常");
        }
    }

    public int a() {
        return this.f37500a;
    }

    public String b() {
        return this.f37501b;
    }
}

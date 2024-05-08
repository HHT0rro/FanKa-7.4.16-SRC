package com.huawei.hms.scankit.p;

/* compiled from: AIScanException.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class a extends Exception {

    /* renamed from: a, reason: collision with root package name */
    public static final boolean f30674a;

    /* renamed from: b, reason: collision with root package name */
    public static final StackTraceElement[] f30675b;

    /* renamed from: c, reason: collision with root package name */
    private static final a f30676c;

    static {
        f30674a = System.getProperty("surefire.test.class.path") != null;
        StackTraceElement[] stackTraceElementArr = new StackTraceElement[0];
        f30675b = stackTraceElementArr;
        a aVar = new a();
        f30676c = aVar;
        aVar.setStackTrace(stackTraceElementArr);
    }

    private a() {
    }

    public static a a() {
        return f30674a ? new a() : f30676c;
    }

    private a(String str) {
        super(str);
    }

    public static a a(String str) {
        return new a(str);
    }
}

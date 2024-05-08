package com.baidu.mobads.sdk.internal;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static volatile c f10006a;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public interface a {

        /* renamed from: a, reason: collision with root package name */
        public static final String f10007a = "remote_adserv";

        /* renamed from: b, reason: collision with root package name */
        public static final String f10008b = "remote_novel";
    }

    private c() {
    }

    public static c a() {
        if (f10006a == null) {
            synchronized (c.class) {
                if (f10006a == null) {
                    f10006a = new c();
                }
            }
        }
        return f10006a;
    }

    public ap a(String str) {
        return new ap(str);
    }
}

package com.vivo.push.g;

import java.util.ArrayList;

/* compiled from: TestManager.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private static String[] f46228a = {"com.vivo.pushservice", "com.vivo.pushdemo.test", "com.vivo.sdk.test"};

    /* renamed from: b, reason: collision with root package name */
    private ArrayList<String> f46229b;

    /* compiled from: TestManager.java */
    /* renamed from: com.vivo.push.g.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class C0657a {

        /* renamed from: a, reason: collision with root package name */
        private static a f46230a = new a(0);
    }

    public /* synthetic */ a(byte b4) {
        this();
    }

    public static a a() {
        return C0657a.f46230a;
    }

    public final boolean b() {
        ArrayList<String> arrayList = this.f46229b;
        return (arrayList == null || arrayList.size() == 0) ? false : true;
    }

    private a() {
        this.f46229b = null;
        this.f46229b = new ArrayList<>();
    }
}

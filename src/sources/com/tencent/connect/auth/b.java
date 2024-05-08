package com.tencent.connect.auth;

import com.tencent.tauth.IUiListener;
import java.util.HashMap;

/* compiled from: ProGuard */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public static b f42488a = null;

    /* renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ boolean f42489d = true;

    /* renamed from: e, reason: collision with root package name */
    private static int f42490e;

    /* renamed from: b, reason: collision with root package name */
    public HashMap<String, a> f42491b = new HashMap<>();

    /* renamed from: c, reason: collision with root package name */
    public final String f42492c = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    /* compiled from: ProGuard */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public IUiListener f42493a;

        /* renamed from: b, reason: collision with root package name */
        public com.tencent.connect.auth.a f42494b;

        /* renamed from: c, reason: collision with root package name */
        public String f42495c;
    }

    public static b a() {
        if (f42488a == null) {
            f42488a = new b();
        }
        return f42488a;
    }

    public static int b() {
        int i10 = f42490e + 1;
        f42490e = i10;
        return i10;
    }

    public String c() {
        int ceil = (int) Math.ceil((Math.random() * 20.0d) + 3.0d);
        char[] charArray = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
        int length = charArray.length;
        StringBuffer stringBuffer = new StringBuffer();
        for (int i10 = 0; i10 < ceil; i10++) {
            stringBuffer.append(charArray[(int) (Math.random() * length)]);
        }
        return stringBuffer.toString();
    }

    public String a(a aVar) {
        int b4 = b();
        try {
            this.f42491b.put("" + b4, aVar);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return "" + b4;
    }
}

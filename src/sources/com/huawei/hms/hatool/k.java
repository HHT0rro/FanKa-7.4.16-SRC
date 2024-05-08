package com.huawei.hms.hatool;

import android.util.Pair;
import java.util.List;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class k extends u0 {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f30151a;

        static {
            int[] iArr = new int[d0.values().length];
            f30151a = iArr;
            try {
                iArr[d0.SN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f30151a[d0.IMEI.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f30151a[d0.UDID.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public static f0 a(String str, String str2, String str3, String str4) {
        f0 a10 = u0.a(str, str2, str3, str4);
        String a11 = j.a().a(a1.c(str2, str3));
        long currentTimeMillis = System.currentTimeMillis();
        String b4 = ta.b.b(q0.f() + a11 + currentTimeMillis);
        a10.f(String.valueOf(currentTimeMillis));
        a10.g(b4);
        return a10;
    }

    public static h1 a(List<b1> list, String str, String str2, String str3, String str4) {
        v.c("hmsSdk", "generate UploadData");
        h1 b4 = u0.b(str, str2);
        if (b4 == null) {
            return null;
        }
        b4.a(a(m1.d().a(), str, str2, str3));
        b4.a(a(str, str2));
        b4.a(a(str2, str, str4));
        b4.a(a1.g(str, str2));
        b4.a(list);
        return b4;
    }

    public static l a(String str, String str2) {
        l a10 = u0.a(str, str2);
        i c4 = j.a().c(str, str2);
        a10.g(j.a().a(a1.c(str, str2)));
        a10.f(a1.o(str, str2));
        a10.c(j.a().f(str, str2));
        int i10 = a.f30151a[c4.a().ordinal()];
        if (i10 == 1) {
            a10.d(c4.b());
        } else if (i10 == 2) {
            a10.b(c4.b());
        } else if (i10 == 3) {
            a10.e(c4.b());
        }
        return a10;
    }

    public static y0 a(String str, String str2, String str3) {
        y0 a10 = u0.a(str, str2, str3);
        Pair<String, String> e2 = j.a().e(str2, str);
        a10.f((String) e2.first);
        a10.g((String) e2.second);
        a10.h(o.b());
        a10.d(j.a().d(str2, str));
        return a10;
    }

    public static Map<String, String> b(String str, String str2, String str3) {
        Map<String, String> c4 = u0.c(str, str3);
        Map<String, String> i10 = a1.i(str, str2);
        if (i10 == null) {
            return c4;
        }
        c4.putAll(i10);
        return c4;
    }
}

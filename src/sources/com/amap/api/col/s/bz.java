package com.amap.api.col.s;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.cert.CertificateException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/* compiled from: ClientInfo.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class bz {

    /* compiled from: ClientInfo.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class a {
        public String A;

        /* renamed from: a, reason: collision with root package name */
        public String f7388a;

        /* renamed from: b, reason: collision with root package name */
        public String f7389b;

        /* renamed from: c, reason: collision with root package name */
        public String f7390c;

        /* renamed from: d, reason: collision with root package name */
        public String f7391d;

        /* renamed from: e, reason: collision with root package name */
        public String f7392e;

        /* renamed from: f, reason: collision with root package name */
        public String f7393f;

        /* renamed from: g, reason: collision with root package name */
        public String f7394g;

        /* renamed from: h, reason: collision with root package name */
        public String f7395h;

        /* renamed from: i, reason: collision with root package name */
        public String f7396i;

        /* renamed from: j, reason: collision with root package name */
        public String f7397j;

        /* renamed from: k, reason: collision with root package name */
        public String f7398k;

        /* renamed from: l, reason: collision with root package name */
        public String f7399l;

        /* renamed from: m, reason: collision with root package name */
        public String f7400m;

        /* renamed from: n, reason: collision with root package name */
        public String f7401n;

        /* renamed from: o, reason: collision with root package name */
        public String f7402o;

        /* renamed from: p, reason: collision with root package name */
        public String f7403p;

        /* renamed from: q, reason: collision with root package name */
        public String f7404q;

        /* renamed from: r, reason: collision with root package name */
        public String f7405r;

        /* renamed from: s, reason: collision with root package name */
        public String f7406s;

        /* renamed from: t, reason: collision with root package name */
        public String f7407t;

        /* renamed from: u, reason: collision with root package name */
        public String f7408u;

        /* renamed from: v, reason: collision with root package name */
        public String f7409v;

        /* renamed from: w, reason: collision with root package name */
        public String f7410w;

        /* renamed from: x, reason: collision with root package name */
        public String f7411x;

        /* renamed from: y, reason: collision with root package name */
        public String f7412y;

        /* renamed from: z, reason: collision with root package name */
        public String f7413z;

        private a() {
        }

        public /* synthetic */ a(byte b4) {
            this();
        }
    }

    public static String a(Context context, String str, String str2) {
        try {
            return ce.a(bw.e(context) + com.huawei.openalliance.ad.constant.u.bD + str.substring(0, str.length() - 3) + com.huawei.openalliance.ad.constant.u.bD + str2);
        } catch (Throwable th) {
            dc.a(th, "CI", "Sco");
            return null;
        }
    }

    private static String b(Context context) {
        try {
            return a(b(context, false));
        } catch (Throwable th) {
            dc.a(th, "CI", "gCXi");
            return null;
        }
    }

    private static byte[] b(byte[] bArr) throws CertificateException, InvalidKeySpecException, NoSuchAlgorithmException, NullPointerException, IOException, InvalidKeyException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
        PublicKey d10 = ci.d();
        if (bArr.length > 117) {
            byte[] bArr2 = new byte[117];
            System.arraycopy((Object) bArr, 0, (Object) bArr2, 0, 117);
            byte[] a10 = cb.a(bArr2, d10);
            byte[] bArr3 = new byte[(bArr.length + 128) - 117];
            System.arraycopy((Object) a10, 0, (Object) bArr3, 0, 128);
            System.arraycopy((Object) bArr, 117, (Object) bArr3, 128, bArr.length - 117);
            return bArr3;
        }
        return cb.a(bArr, d10);
    }

    public static String a() {
        try {
            String valueOf = String.valueOf(System.currentTimeMillis());
            String str = bw.a() ? "1" : "0";
            int length = valueOf.length();
            return valueOf.substring(0, length - 2) + str + valueOf.substring(length - 1);
        } catch (Throwable th) {
            dc.a(th, "CI", "TS");
            return null;
        }
    }

    public static byte[] a(byte[] bArr) throws CertificateException, InvalidKeySpecException, NoSuchAlgorithmException, NullPointerException, IOException, InvalidKeyException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
        return cb.a(bArr);
    }

    public static byte[] a(Context context, boolean z10) {
        try {
            return b(b(context, z10));
        } catch (Throwable th) {
            dc.a(th, "CI", "gz");
            return null;
        }
    }

    private static byte[] b(a aVar) {
        ByteArrayOutputStream byteArrayOutputStream;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
        } catch (Throwable th) {
            th = th;
            byteArrayOutputStream = null;
        }
        try {
            a(byteArrayOutputStream, aVar.f7388a);
            a(byteArrayOutputStream, aVar.f7389b);
            a(byteArrayOutputStream, aVar.f7390c);
            a(byteArrayOutputStream, aVar.f7391d);
            a(byteArrayOutputStream, aVar.f7392e);
            a(byteArrayOutputStream, aVar.f7393f);
            a(byteArrayOutputStream, aVar.f7394g);
            a(byteArrayOutputStream, aVar.f7395h);
            a(byteArrayOutputStream, aVar.f7396i);
            a(byteArrayOutputStream, aVar.f7397j);
            a(byteArrayOutputStream, aVar.f7398k);
            a(byteArrayOutputStream, aVar.f7399l);
            a(byteArrayOutputStream, aVar.f7400m);
            a(byteArrayOutputStream, aVar.f7401n);
            a(byteArrayOutputStream, aVar.f7402o);
            a(byteArrayOutputStream, aVar.f7403p);
            a(byteArrayOutputStream, aVar.f7404q);
            a(byteArrayOutputStream, aVar.f7405r);
            a(byteArrayOutputStream, aVar.f7406s);
            a(byteArrayOutputStream, aVar.f7407t);
            a(byteArrayOutputStream, aVar.f7408u);
            a(byteArrayOutputStream, aVar.f7409v);
            a(byteArrayOutputStream, aVar.f7410w);
            a(byteArrayOutputStream, aVar.f7411x);
            a(byteArrayOutputStream, aVar.f7412y);
            a(byteArrayOutputStream, aVar.f7413z);
            a(byteArrayOutputStream, aVar.A);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            new String(byteArray);
            byte[] b4 = b(ci.b(byteArray));
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
            return b4;
        } catch (Throwable th3) {
            th = th3;
            try {
                dc.a(th, "CI", "gzx");
                return null;
            } finally {
                if (byteArrayOutputStream != null) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (Throwable th4) {
                        th4.printStackTrace();
                    }
                }
            }
        }
    }

    public static String a(Context context) {
        return b(context);
    }

    private static String a(a aVar) {
        return cb.b(b(aVar));
    }

    private static void a(ByteArrayOutputStream byteArrayOutputStream, String str) {
        if (!TextUtils.isEmpty(str)) {
            ci.a(byteArrayOutputStream, str.getBytes().length > 255 ? (byte) -1 : (byte) str.getBytes().length, ci.a(str));
        } else {
            ci.a(byteArrayOutputStream, (byte) 0, new byte[0]);
        }
    }

    private static a b(Context context, boolean z10) {
        a aVar = new a((byte) 0);
        aVar.f7388a = ca.k();
        aVar.f7389b = ca.h();
        String f10 = ca.f(context);
        if (f10 == null) {
            f10 = "";
        }
        aVar.f7390c = f10;
        aVar.f7391d = bw.c(context);
        aVar.f7392e = Build.MODEL;
        aVar.f7393f = Build.MANUFACTURER;
        aVar.f7394g = Build.DEVICE;
        aVar.f7395h = bw.b(context);
        aVar.f7396i = bw.d(context);
        aVar.f7397j = String.valueOf(Build.VERSION.SDK_INT);
        aVar.f7398k = ca.m();
        aVar.f7399l = ca.j(context);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(ca.i(context));
        aVar.f7400m = sb2.toString();
        StringBuilder sb3 = new StringBuilder();
        sb3.append(ca.h(context));
        aVar.f7401n = sb3.toString();
        aVar.f7402o = ca.n(context);
        aVar.f7403p = ca.g(context);
        aVar.f7404q = "";
        aVar.f7405r = "";
        String[] i10 = ca.i();
        aVar.f7406s = i10[0];
        aVar.f7407t = i10[1];
        aVar.f7410w = ca.a();
        String a10 = ca.a(context);
        if (!TextUtils.isEmpty(a10)) {
            aVar.f7411x = a10;
        } else {
            aVar.f7411x = "";
        }
        aVar.f7412y = "aid=" + ca.g();
        if ((z10 && cr.f7580d) || cr.f7581e) {
            String e2 = ca.e(context);
            if (!TextUtils.isEmpty(e2)) {
                aVar.f7412y += "|oaid=" + e2;
            }
        }
        String j10 = ca.j();
        if (!TextUtils.isEmpty(j10)) {
            aVar.f7412y += "|multiImeis=" + j10;
        }
        String l10 = ca.l();
        if (!TextUtils.isEmpty(l10)) {
            aVar.f7412y += "|meid=" + l10;
        }
        aVar.f7412y += "|serial=" + ca.f();
        String b4 = ca.b();
        if (!TextUtils.isEmpty(b4)) {
            aVar.f7412y += "|adiuExtras=" + b4;
        }
        aVar.f7412y += "|storage=" + ca.n() + "|ram=" + ca.m(context) + "|arch=" + ca.o();
        String b10 = db.a().b();
        if (!TextUtils.isEmpty(b10)) {
            aVar.f7413z = b10;
        } else {
            aVar.f7413z = "";
        }
        return aVar;
    }
}

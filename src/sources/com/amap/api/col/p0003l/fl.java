package com.amap.api.col.p0003l;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.huawei.openalliance.ad.constant.u;
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
public final class fl {

    /* compiled from: ClientInfo.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class a {
        public String A;

        /* renamed from: a, reason: collision with root package name */
        public String f5833a;

        /* renamed from: b, reason: collision with root package name */
        public String f5834b;

        /* renamed from: c, reason: collision with root package name */
        public String f5835c;

        /* renamed from: d, reason: collision with root package name */
        public String f5836d;

        /* renamed from: e, reason: collision with root package name */
        public String f5837e;

        /* renamed from: f, reason: collision with root package name */
        public String f5838f;

        /* renamed from: g, reason: collision with root package name */
        public String f5839g;

        /* renamed from: h, reason: collision with root package name */
        public String f5840h;

        /* renamed from: i, reason: collision with root package name */
        public String f5841i;

        /* renamed from: j, reason: collision with root package name */
        public String f5842j;

        /* renamed from: k, reason: collision with root package name */
        public String f5843k;

        /* renamed from: l, reason: collision with root package name */
        public String f5844l;

        /* renamed from: m, reason: collision with root package name */
        public String f5845m;

        /* renamed from: n, reason: collision with root package name */
        public String f5846n;

        /* renamed from: o, reason: collision with root package name */
        public String f5847o;

        /* renamed from: p, reason: collision with root package name */
        public String f5848p;

        /* renamed from: q, reason: collision with root package name */
        public String f5849q;

        /* renamed from: r, reason: collision with root package name */
        public String f5850r;

        /* renamed from: s, reason: collision with root package name */
        public String f5851s;

        /* renamed from: t, reason: collision with root package name */
        public String f5852t;

        /* renamed from: u, reason: collision with root package name */
        public String f5853u;

        /* renamed from: v, reason: collision with root package name */
        public String f5854v;

        /* renamed from: w, reason: collision with root package name */
        public String f5855w;

        /* renamed from: x, reason: collision with root package name */
        public String f5856x;

        /* renamed from: y, reason: collision with root package name */
        public String f5857y;

        /* renamed from: z, reason: collision with root package name */
        public String f5858z;

        private a() {
        }

        public /* synthetic */ a(byte b4) {
            this();
        }
    }

    public static String a(Context context, String str, String str2) {
        try {
            return fq.b(fj.e(context) + u.bD + str.substring(0, str.length() - 3) + u.bD + str2);
        } catch (Throwable th) {
            gv.a(th, "CI", "Sco");
            return null;
        }
    }

    public static String b(Context context) {
        return c(context);
    }

    private static String c(Context context) {
        try {
            return a(b(context, false, false));
        } catch (Throwable th) {
            gv.a(th, "CI", "gCXi");
            return null;
        }
    }

    private static byte[] b(byte[] bArr) throws CertificateException, InvalidKeySpecException, NoSuchAlgorithmException, NullPointerException, IOException, InvalidKeyException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
        PublicKey d10 = fv.d();
        if (bArr.length > 117) {
            byte[] bArr2 = new byte[117];
            System.arraycopy((Object) bArr, 0, (Object) bArr2, 0, 117);
            byte[] a10 = fn.a(bArr2, d10);
            byte[] bArr3 = new byte[(bArr.length + 128) - 117];
            System.arraycopy((Object) a10, 0, (Object) bArr3, 0, 128);
            System.arraycopy((Object) bArr, 117, (Object) bArr3, 128, bArr.length - 117);
            return bArr3;
        }
        return fn.a(bArr, d10);
    }

    public static String a() {
        try {
            String valueOf = String.valueOf(System.currentTimeMillis());
            String str = fj.a() ? "1" : "0";
            int length = valueOf.length();
            return valueOf.substring(0, length - 2) + str + valueOf.substring(length - 1);
        } catch (Throwable th) {
            gv.a(th, "CI", "TS");
            return null;
        }
    }

    public static String a(Context context) {
        try {
            a aVar = new a((byte) 0);
            aVar.f5836d = fj.c(context);
            aVar.f5841i = fj.d(context);
            return a(aVar);
        } catch (Throwable th) {
            gv.a(th, "CI", "IX");
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
            a(byteArrayOutputStream, aVar.f5833a);
            a(byteArrayOutputStream, aVar.f5834b);
            a(byteArrayOutputStream, aVar.f5835c);
            a(byteArrayOutputStream, aVar.f5836d);
            a(byteArrayOutputStream, aVar.f5837e);
            a(byteArrayOutputStream, aVar.f5838f);
            a(byteArrayOutputStream, aVar.f5839g);
            a(byteArrayOutputStream, aVar.f5840h);
            a(byteArrayOutputStream, aVar.f5841i);
            a(byteArrayOutputStream, aVar.f5842j);
            a(byteArrayOutputStream, aVar.f5843k);
            a(byteArrayOutputStream, aVar.f5844l);
            a(byteArrayOutputStream, aVar.f5845m);
            a(byteArrayOutputStream, aVar.f5846n);
            a(byteArrayOutputStream, aVar.f5847o);
            a(byteArrayOutputStream, aVar.f5848p);
            a(byteArrayOutputStream, aVar.f5849q);
            a(byteArrayOutputStream, aVar.f5850r);
            a(byteArrayOutputStream, aVar.f5851s);
            a(byteArrayOutputStream, aVar.f5852t);
            a(byteArrayOutputStream, aVar.f5853u);
            a(byteArrayOutputStream, aVar.f5854v);
            a(byteArrayOutputStream, aVar.f5855w);
            a(byteArrayOutputStream, aVar.f5856x);
            a(byteArrayOutputStream, aVar.f5857y);
            a(byteArrayOutputStream, aVar.f5858z);
            a(byteArrayOutputStream, aVar.A);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            new String(byteArray);
            byte[] b4 = b(fv.b(byteArray));
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
            return b4;
        } catch (Throwable th3) {
            th = th3;
            try {
                gv.a(th, "CI", "gzx");
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

    public static byte[] a(byte[] bArr) throws CertificateException, InvalidKeySpecException, NoSuchAlgorithmException, NullPointerException, IOException, InvalidKeyException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
        return fn.a(bArr);
    }

    public static byte[] a(Context context, boolean z10, boolean z11) {
        try {
            return b(b(context, z10, z11));
        } catch (Throwable th) {
            gv.a(th, "CI", "gz");
            return null;
        }
    }

    private static String a(a aVar) {
        return fn.b(b(aVar));
    }

    private static void a(ByteArrayOutputStream byteArrayOutputStream, String str) {
        if (!TextUtils.isEmpty(str)) {
            fv.a(byteArrayOutputStream, str.getBytes().length > 255 ? (byte) -1 : (byte) str.getBytes().length, fv.a(str));
        } else {
            fv.a(byteArrayOutputStream, (byte) 0, new byte[0]);
        }
    }

    private static a b(Context context, boolean z10, boolean z11) {
        a aVar = new a((byte) 0);
        aVar.f5833a = fm.k();
        aVar.f5834b = fm.h();
        String f10 = fm.f(context);
        if (f10 == null) {
            f10 = "";
        }
        aVar.f5835c = f10;
        aVar.f5836d = fj.c(context);
        aVar.f5837e = Build.MODEL;
        aVar.f5838f = Build.MANUFACTURER;
        aVar.f5839g = Build.DEVICE;
        aVar.f5840h = fj.b(context);
        aVar.f5841i = fj.d(context);
        aVar.f5842j = String.valueOf(Build.VERSION.SDK_INT);
        aVar.f5843k = fm.n();
        aVar.f5844l = fm.m(context);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(fm.j(context));
        aVar.f5845m = sb2.toString();
        StringBuilder sb3 = new StringBuilder();
        sb3.append(fm.i(context));
        aVar.f5846n = sb3.toString();
        aVar.f5847o = fm.s(context);
        aVar.f5848p = fm.h(context);
        aVar.f5849q = "";
        aVar.f5850r = "";
        if (z10) {
            aVar.f5851s = "";
            aVar.f5852t = "";
        } else {
            String[] i10 = fm.i();
            aVar.f5851s = i10[0];
            aVar.f5852t = i10[1];
        }
        aVar.f5855w = fm.a();
        String a10 = fm.a(context);
        if (!TextUtils.isEmpty(a10)) {
            aVar.f5856x = a10;
        } else {
            aVar.f5856x = "";
        }
        aVar.f5857y = "aid=" + fm.g();
        if ((z11 && gj.f6092d) || gj.f6093e) {
            String e2 = fm.e(context);
            if (!TextUtils.isEmpty(e2)) {
                aVar.f5857y += "|oaid=" + e2;
            }
        }
        String j10 = fm.j();
        if (!TextUtils.isEmpty(j10)) {
            aVar.f5857y += "|multiImeis=" + j10;
        }
        String m10 = fm.m();
        if (!TextUtils.isEmpty(m10)) {
            aVar.f5857y += "|meid=" + m10;
        }
        aVar.f5857y += "|serial=" + fm.f();
        String b4 = fm.b();
        if (!TextUtils.isEmpty(b4)) {
            aVar.f5857y += "|adiuExtras=" + b4;
        }
        aVar.f5857y += "|storage=" + fm.o() + "|ram=" + fm.r(context) + "|arch=" + fm.p();
        String b10 = gu.a().b();
        if (!TextUtils.isEmpty(b10)) {
            aVar.f5858z = b10;
        } else {
            aVar.f5858z = "";
        }
        if (z10) {
            String a11 = ga.a(context).a();
            if (!TextUtils.isEmpty(a11)) {
                aVar.A = a11;
            }
        }
        return aVar;
    }
}

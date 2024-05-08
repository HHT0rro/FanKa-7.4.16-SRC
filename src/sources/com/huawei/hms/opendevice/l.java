package com.huawei.hms.opendevice;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.huawei.android.hms.openid.R;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.IOUtils;
import com.kuaishou.weapon.p0.t;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

/* compiled from: SecretUtil.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public abstract class l {

    /* renamed from: a, reason: collision with root package name */
    private static final String f30343a = "l";

    /* renamed from: b, reason: collision with root package name */
    private static Map<String, String> f30344b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    private static final Object f30345c = new Object();

    private static String a() {
        return "2A57086C86EF54970C1E6EB37BFC72B1";
    }

    private static byte[] a(String str, String str2, String str3, String str4) {
        if (Build.VERSION.SDK_INT >= 26) {
            return va.a.e(str, str2, str3, str4, 32, true);
        }
        return va.a.e(str, str2, str3, str4, 32, false);
    }

    private static byte[] b() {
        return a(d(), e(), c(), g());
    }

    public static void c(Context context) {
        synchronized (f30345c) {
            d(context.getApplicationContext());
            if (i()) {
                HMSLog.i(f30343a, "The local secret is already in separate file mode.");
                return;
            }
            File file = new File(e.c(context.getApplicationContext()) + "/shared_prefs/LocalAvengers.xml");
            if (file.exists()) {
                com.huawei.secure.android.common.util.a.d(file);
                HMSLog.i(f30343a, "destroy C, delete file LocalAvengers.xml.");
            }
            byte[] c4 = va.b.c(32);
            byte[] c10 = va.b.c(32);
            byte[] c11 = va.b.c(32);
            byte[] c12 = va.b.c(32);
            String a10 = d.a(c4);
            String a11 = d.a(c10);
            String a12 = d.a(c11);
            String a13 = d.a(c12);
            a(a10, a11, a12, a13, va.e.c(d.a(va.b.c(32)), a(a10, a11, a12, a13)), context);
            HMSLog.i(f30343a, "generate D.");
        }
    }

    private static void d(Context context) {
        if (i()) {
            HMSLog.i(f30343a, "secretKeyCache not empty.");
            return;
        }
        f30344b.clear();
        String c4 = e.c(context);
        if (TextUtils.isEmpty(c4)) {
            return;
        }
        String a10 = m.a(c4 + "/files/math/m");
        String a11 = m.a(c4 + "/files/panda/p");
        String a12 = m.a(c4 + "/files/panda/d");
        String a13 = m.a(c4 + "/files/math/t");
        String a14 = m.a(c4 + "/files/s");
        if (n.a(a10, a11, a12, a13, a14)) {
            f30344b.put("m", a10);
            f30344b.put(t.f36217b, a11);
            f30344b.put("d", a12);
            f30344b.put("t", a13);
            f30344b.put(t.f36222g, a14);
        }
    }

    private static synchronized String e(Context context) {
        synchronized (l.class) {
            String b4 = va.e.b(f(), b());
            if (n.a(b4)) {
                HMSLog.i(f30343a, "keyS has been upgraded, no require operate again.");
                return b4;
            }
            String a10 = va.e.a(f(), h());
            if (n.a(a10)) {
                HMSLog.i(f30343a, "keyS is encrypt by RootKeyUtil, upgrade encrypt mode.");
                a(va.e.c(a10, b()), context);
                return a10;
            }
            String b10 = va.e.b(f(), va.a.e(d(), e(), c(), g(), 32, false));
            if (n.a(b10)) {
                HMSLog.i(f30343a, "keyS is encrypt by ExportRootKey with sha1, upgrade encrypt mode to sha256.");
                a(va.e.c(b10, b()), context);
                return b10;
            }
            HMSLog.e(f30343a, "all mode unable to decrypt root key.");
            return "";
        }
    }

    private static String f() {
        return a(t.f36222g);
    }

    private static String g() {
        return a("t");
    }

    private static va.d h() {
        return va.d.d(d(), e(), c(), g());
    }

    private static boolean i() {
        return !TextUtils.isEmpty(f());
    }

    public static String b(Context context) {
        if (!i()) {
            HMSLog.i(f30343a, "work key is empty, execute init.");
            c(context);
        }
        String b4 = va.e.b(f(), b());
        return n.a(b4) ? b4 : e(context);
    }

    public static byte[] a(Context context) {
        byte[] a10 = d.a(context.getString(R.string.push_cat_head));
        byte[] a11 = d.a(context.getString(R.string.push_cat_body));
        return a(a(a(a10, a11), d.a(a())));
    }

    private static byte[] a(byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr2 == null || bArr.length == 0 || bArr2.length == 0) {
            return new byte[0];
        }
        int length = bArr.length;
        if (length != bArr2.length) {
            return new byte[0];
        }
        byte[] bArr3 = new byte[length];
        for (int i10 = 0; i10 < length; i10++) {
            bArr3[i10] = (byte) (bArr[i10] ^ bArr2[i10]);
        }
        return bArr3;
    }

    private static byte[] a(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return new byte[0];
        }
        for (int i10 = 0; i10 < bArr.length; i10++) {
            bArr[i10] = (byte) (bArr[i10] >> 2);
        }
        return bArr;
    }

    private static void a(String str, String str2, String str3, String str4, String str5, Context context) {
        String c4 = e.c(context.getApplicationContext());
        if (TextUtils.isEmpty(c4)) {
            return;
        }
        try {
            a("m", str, c4 + "/files/math/m");
            a(t.f36217b, str2, c4 + "/files/panda/p");
            a("d", str3, c4 + "/files/panda/d");
            a("t", str4, c4 + "/files/math/t");
            a(t.f36222g, str5, c4 + "/files/s");
        } catch (IOException unused) {
            HMSLog.e(f30343a, "save key IOException.");
        }
    }

    private static String d() {
        return a("m");
    }

    private static String e() {
        return a(t.f36217b);
    }

    private static String c() {
        return a("d");
    }

    private static void a(String str, Context context) {
        String c4 = e.c(context.getApplicationContext());
        if (TextUtils.isEmpty(c4)) {
            return;
        }
        try {
            a(t.f36222g, str, c4 + "/files/s");
        } catch (IOException unused) {
            HMSLog.e(f30343a, "save keyS IOException.");
        }
    }

    private static void a(String str, String str2, String str3) throws IOException {
        OutputStreamWriter outputStreamWriter;
        BufferedWriter bufferedWriter;
        HMSLog.i(f30343a, "save local secret key.");
        BufferedWriter bufferedWriter2 = null;
        try {
            File file = new File(str3);
            m.a(file);
            outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file), "UTF-8");
            try {
                bufferedWriter = new BufferedWriter(outputStreamWriter);
            } catch (Throwable th) {
                th = th;
            }
        } catch (Throwable th2) {
            th = th2;
            outputStreamWriter = null;
        }
        try {
            bufferedWriter.write(str2);
            bufferedWriter.flush();
            f30344b.put(str, str2);
            IOUtils.closeQuietly((Writer) outputStreamWriter);
            IOUtils.closeQuietly((Writer) bufferedWriter);
        } catch (Throwable th3) {
            th = th3;
            bufferedWriter2 = bufferedWriter;
            IOUtils.closeQuietly((Writer) outputStreamWriter);
            IOUtils.closeQuietly((Writer) bufferedWriter2);
            throw th;
        }
    }

    private static String a(String str) {
        String str2 = f30344b.get(str);
        return TextUtils.isEmpty(str2) ? "" : str2;
    }
}

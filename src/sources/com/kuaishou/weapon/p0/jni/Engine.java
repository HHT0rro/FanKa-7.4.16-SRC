package com.kuaishou.weapon.p0.jni;

import android.content.Context;
import android.text.TextUtils;
import com.kuaishou.weapon.p0.bh;
import com.kuaishou.weapon.p0.bp;
import com.kuaishou.weapon.p0.bq;
import com.kuaishou.weapon.p0.ck;
import com.kuaishou.weapon.p0.df;
import com.kuaishou.weapon.p0.h;
import com.kuaishou.weapon.p0.t;
import java.lang.reflect.Member;
import java.util.HashMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class Engine {
    private static volatile Engine instance;
    public static volatile int loadSoCount;
    public static volatile boolean loadSuccess;
    public static volatile String soPath;
    public static volatile String soVersion;

    public static native String abc();

    public static native String bcd();

    public static Engine getInstance(Context context) {
        if (!TextUtils.isEmpty(soVersion) && !loadSuccess && instance == null) {
            synchronized (Engine.class) {
                if (instance == null) {
                    instance = new Engine();
                }
                h a10 = h.a(context, "re_po_rt");
                try {
                } catch (Throwable th) {
                    loadSuccess = false;
                    try {
                        HashMap hashMap = new HashMap();
                        hashMap.put("e", th.getMessage());
                        hashMap.put(t.f36218c, soVersion);
                        hashMap.put("l", ck.f35943m);
                        bh.a(context, ck.f35931a, hashMap);
                    } catch (Exception unused) {
                    }
                }
                if (!bp.a(context, bq.f35866d + soVersion.replace(".", "") + ".so")) {
                    loadSuccess = false;
                    return instance;
                }
                String b4 = a10.b(df.f36067f, "");
                if (TextUtils.isEmpty(b4)) {
                    b4 = soVersion;
                    a10.c(df.f36067f, b4, false);
                }
                loadSoCount = a10.c(df.bg);
                if (!TextUtils.equals(b4, soVersion)) {
                    String str = soVersion;
                    loadSoCount = 0;
                    a10.c(df.f36067f, str, false);
                }
                if (loadSoCount + 1 < 10) {
                    loadSoCount++;
                    a10.d(df.bg, loadSoCount);
                    System.loadLibrary(bq.f35866d + soVersion.replace(".", ""));
                    bcd();
                    loadSoCount = 0;
                    loadSuccess = true;
                }
                a10.d(df.bg, loadSoCount);
            }
        }
        return instance;
    }

    public static native int mmo(Member member, int i10, int i11);

    public static native int mqc(Member member, int i10);

    public static native int off();

    public static native String tao(int i10, long j10, Object obj);

    public native byte[] ac(byte[] bArr, byte[] bArr2);

    public native byte[] ar(byte[] bArr, byte[] bArr2);

    public native String cde();

    public native byte[] dc(byte[] bArr, byte[] bArr2);

    public native String def();

    public native byte[] dr(byte[] bArr, byte[] bArr2);

    public native String efg();

    public native String eopq(int i10, int i11, int i12, String str);

    public native String fgh();

    public native String ghi();

    public native String hij();

    public native String klm(int i10, String str);

    public native String nop();

    public native String pqr(int i10, int i11, int i12, String str);

    public native String qrs();

    public native String stu(int i10, int i11, int i12, int i13, String str);
}

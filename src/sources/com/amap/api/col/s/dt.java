package com.amap.api.col.s;

import android.os.SystemClock;
import android.text.TextUtils;
import com.amap.api.col.s.dz;
import com.amap.api.maps.AMapException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;

/* compiled from: BaseNetManager.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class dt {

    /* renamed from: a, reason: collision with root package name */
    public static int f7741a = 0;

    /* renamed from: b, reason: collision with root package name */
    public static String f7742b = "";

    /* renamed from: c, reason: collision with root package name */
    public static HashMap<String, String> f7743c;

    /* renamed from: d, reason: collision with root package name */
    public static HashMap<String, String> f7744d;

    /* renamed from: e, reason: collision with root package name */
    public static HashMap<String, String> f7745e;

    /* renamed from: f, reason: collision with root package name */
    private static dt f7746f;

    /* compiled from: BaseNetManager.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public interface a {
        URLConnection a();
    }

    public dt() {
        bx.d();
    }

    public static dt a() {
        if (f7746f == null) {
            f7746f = new dt();
        }
        return f7746f;
    }

    public static dz.b b(dz dzVar, boolean z10) {
        return dzVar.o() == dz.a.FIX ? z10 ? dz.b.FIX_DEGRADE_BYERROR : dz.b.FIX_DEGRADE_ONLY : z10 ? dz.b.DEGRADE_BYERROR : dz.b.DEGRADE_ONLY;
    }

    public static boolean c(dz dzVar) throws bv {
        d(dzVar);
        if (!b(dzVar)) {
            return true;
        }
        if (dzVar.b().equals(dzVar.a()) || dzVar.o() == dz.a.SINGLE) {
            return false;
        }
        return bx.f7329h;
    }

    @Deprecated
    private static ea d(dz dzVar, boolean z10) throws bv {
        byte[] bArr;
        d(dzVar);
        dzVar.a(z10 ? dz.c.HTTPS : dz.c.HTTP);
        ea eaVar = null;
        long j10 = 0;
        boolean z11 = false;
        if (b(dzVar)) {
            boolean c4 = c(dzVar);
            try {
                j10 = SystemClock.elapsedRealtime();
                eaVar = a(dzVar, a(dzVar, c4), c(dzVar, c4));
            } catch (bv e2) {
                if (e2.f() == 21 && dzVar.o() == dz.a.INTERRUPT_IO) {
                    throw e2;
                }
                if (!c4) {
                    throw e2;
                }
                z11 = true;
            }
        }
        if (eaVar != null && (bArr = eaVar.f7866a) != null && bArr.length > 0) {
            return eaVar;
        }
        try {
            return a(dzVar, b(dzVar, z11), a(dzVar, j10));
        } catch (bv e10) {
            throw e10;
        }
    }

    public static ea a(dz dzVar) throws bv {
        return d(dzVar, dzVar.r());
    }

    public static boolean b(dz dzVar) throws bv {
        d(dzVar);
        try {
            String a10 = dzVar.a();
            if (TextUtils.isEmpty(a10)) {
                return false;
            }
            String host = new URL(a10).getHost();
            if (!TextUtils.isEmpty(dzVar.i())) {
                host = dzVar.i();
            }
            return bx.g(host);
        } catch (Throwable unused) {
            return true;
        }
    }

    private static ea a(dz dzVar, dz.b bVar, int i10) throws bv {
        try {
            d(dzVar);
            dzVar.a(bVar);
            dzVar.c(i10);
            return new dw().b(dzVar);
        } catch (bv e2) {
            throw e2;
        } catch (Throwable th) {
            th.printStackTrace();
            throw new bv(AMapException.ERROR_UNKNOWN);
        }
    }

    public static int c(dz dzVar, boolean z10) {
        try {
            d(dzVar);
            int m10 = dzVar.m();
            int i10 = bx.f7326e;
            if (dzVar.o() != dz.a.FIX) {
                if (dzVar.o() != dz.a.SINGLE && m10 >= i10 && z10) {
                    return i10;
                }
            }
            return m10;
        } catch (Throwable unused) {
            return 5000;
        }
    }

    public static dz.b a(dz dzVar, boolean z10) {
        if (dzVar.o() == dz.a.FIX) {
            return dz.b.FIX_NONDEGRADE;
        }
        if (dzVar.o() == dz.a.SINGLE) {
            return dz.b.NEVER_GRADE;
        }
        return z10 ? dz.b.FIRST_NONDEGRADE : dz.b.NEVER_GRADE;
    }

    public static void d(dz dzVar) throws bv {
        if (dzVar != null) {
            if (dzVar.b() == null || "".equals(dzVar.b())) {
                throw new bv("request url is empty");
            }
            return;
        }
        throw new bv("requeust is null");
    }

    public static int a(dz dzVar, long j10) {
        try {
            d(dzVar);
            long j11 = 0;
            if (j10 != 0) {
                j11 = SystemClock.elapsedRealtime() - j10;
            }
            int m10 = dzVar.m();
            if (dzVar.o() != dz.a.FIX && dzVar.o() != dz.a.SINGLE) {
                long j12 = m10;
                if (j11 < j12) {
                    long j13 = j12 - j11;
                    if (j13 >= 1000) {
                        return (int) j13;
                    }
                }
                return Math.min(1000, dzVar.m());
            }
            return m10;
        } catch (Throwable unused) {
            return 5000;
        }
    }
}

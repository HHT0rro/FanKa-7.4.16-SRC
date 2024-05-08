package com.amap.api.col.p0003l;

import android.os.SystemClock;
import android.text.TextUtils;
import com.amap.api.col.p0003l.id;
import com.amap.api.maps.AMapException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;

/* compiled from: BaseNetManager.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class hw {

    /* renamed from: a, reason: collision with root package name */
    public static int f6309a = 0;

    /* renamed from: b, reason: collision with root package name */
    public static String f6310b = "";

    /* renamed from: c, reason: collision with root package name */
    public static HashMap<String, String> f6311c;

    /* renamed from: d, reason: collision with root package name */
    public static HashMap<String, String> f6312d;

    /* renamed from: e, reason: collision with root package name */
    public static HashMap<String, String> f6313e;

    /* renamed from: f, reason: collision with root package name */
    private static hw f6314f;

    /* compiled from: BaseNetManager.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public interface a {
        URLConnection a();
    }

    public hw() {
        fk.e();
    }

    public static hw a() {
        if (f6314f == null) {
            f6314f = new hw();
        }
        return f6314f;
    }

    public static id.b b(id idVar, boolean z10) {
        return idVar.getDegradeAbility() == id.a.FIX ? z10 ? id.b.FIX_DEGRADE_BYERROR : id.b.FIX_DEGRADE_ONLY : z10 ? id.b.DEGRADE_BYERROR : id.b.DEGRADE_ONLY;
    }

    public static boolean c(id idVar) throws fi {
        d(idVar);
        if (!b(idVar)) {
            return true;
        }
        if (idVar.getURL().equals(idVar.getIPV6URL()) || idVar.getDegradeAbility() == id.a.SINGLE) {
            return false;
        }
        return fk.f5778h;
    }

    @Deprecated
    private static ie d(id idVar, boolean z10) throws fi {
        byte[] bArr;
        d(idVar);
        idVar.setHttpProtocol(z10 ? id.c.HTTPS : id.c.HTTP);
        ie ieVar = null;
        long j10 = 0;
        boolean z11 = false;
        if (b(idVar)) {
            boolean c4 = c(idVar);
            try {
                j10 = SystemClock.elapsedRealtime();
                ieVar = a(idVar, a(idVar, c4), c(idVar, c4));
            } catch (fi e2) {
                if (e2.f() == 21 && idVar.getDegradeAbility() == id.a.INTERRUPT_IO) {
                    throw e2;
                }
                if (!c4) {
                    throw e2;
                }
                z11 = true;
            }
        }
        if (ieVar != null && (bArr = ieVar.f6444a) != null && bArr.length > 0) {
            return ieVar;
        }
        try {
            return a(idVar, b(idVar, z11), a(idVar, j10));
        } catch (fi e10) {
            throw e10;
        }
    }

    public static ie a(id idVar) throws fi {
        return d(idVar, idVar.isHttps());
    }

    public static boolean b(id idVar) throws fi {
        d(idVar);
        try {
            String ipv6url = idVar.getIPV6URL();
            if (TextUtils.isEmpty(ipv6url)) {
                return false;
            }
            String host = new URL(ipv6url).getHost();
            if (!TextUtils.isEmpty(idVar.getIPDNSName())) {
                host = idVar.getIPDNSName();
            }
            return fk.g(host);
        } catch (Throwable unused) {
            return true;
        }
    }

    private static ie a(id idVar, id.b bVar, int i10) throws fi {
        try {
            d(idVar);
            idVar.setDegradeType(bVar);
            idVar.setReal_max_timeout(i10);
            return new ia().c(idVar);
        } catch (fi e2) {
            throw e2;
        } catch (Throwable th) {
            th.printStackTrace();
            throw new fi(AMapException.ERROR_UNKNOWN);
        }
    }

    public static int c(id idVar, boolean z10) {
        try {
            d(idVar);
            int conntectionTimeout = idVar.getConntectionTimeout();
            int i10 = fk.f5775e;
            if (idVar.getDegradeAbility() != id.a.FIX) {
                if (idVar.getDegradeAbility() != id.a.SINGLE && conntectionTimeout >= i10 && z10) {
                    return i10;
                }
            }
            return conntectionTimeout;
        } catch (Throwable unused) {
            return 5000;
        }
    }

    public static id.b a(id idVar, boolean z10) {
        if (idVar.getDegradeAbility() == id.a.FIX) {
            return id.b.FIX_NONDEGRADE;
        }
        if (idVar.getDegradeAbility() == id.a.SINGLE) {
            return id.b.NEVER_GRADE;
        }
        return z10 ? id.b.FIRST_NONDEGRADE : id.b.NEVER_GRADE;
    }

    public static void d(id idVar) throws fi {
        if (idVar != null) {
            if (idVar.getURL() == null || "".equals(idVar.getURL())) {
                throw new fi("request url is empty");
            }
            return;
        }
        throw new fi("requeust is null");
    }

    public static int a(id idVar, long j10) {
        try {
            d(idVar);
            long j11 = 0;
            if (j10 != 0) {
                j11 = SystemClock.elapsedRealtime() - j10;
            }
            int conntectionTimeout = idVar.getConntectionTimeout();
            if (idVar.getDegradeAbility() != id.a.FIX && idVar.getDegradeAbility() != id.a.SINGLE) {
                long j12 = conntectionTimeout;
                if (j11 < j12) {
                    long j13 = j12 - j11;
                    if (j13 >= 1000) {
                        return (int) j13;
                    }
                }
                return Math.min(1000, idVar.getConntectionTimeout());
            }
            return conntectionTimeout;
        } catch (Throwable unused) {
            return 5000;
        }
    }
}

package com.amap.api.col.p0003l;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.amap.api.col.p0003l.id;
import com.amap.api.col.p0003l.jc;
import com.amap.api.maps.AMapException;
import java.util.Map;

/* compiled from: NetManger.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class ic extends hw {

    /* renamed from: f, reason: collision with root package name */
    private static ic f6409f;

    /* renamed from: g, reason: collision with root package name */
    private jd f6410g;

    /* renamed from: h, reason: collision with root package name */
    private Handler f6411h;

    /* compiled from: NetManger.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class a extends Handler {
        public /* synthetic */ a(Looper looper, byte b4) {
            this(looper);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            try {
                int i10 = message.what;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        private a(Looper looper) {
            super(looper);
        }

        public a() {
        }
    }

    private ic(boolean z10) {
        if (z10) {
            try {
                this.f6410g = jd.a(new jc.a().a("amap-netmanger-threadpool-%d").b());
            } catch (Throwable th) {
                gy.b(th, "NetManger", "NetManger1");
                th.printStackTrace();
                return;
            }
        }
        if (Looper.myLooper() == null) {
            this.f6411h = new a(Looper.getMainLooper(), (byte) 0);
        } else {
            this.f6411h = new a();
        }
    }

    private static synchronized ic a(boolean z10) {
        ic icVar;
        synchronized (ic.class) {
            try {
                ic icVar2 = f6409f;
                if (icVar2 == null) {
                    f6409f = new ic(z10);
                } else if (z10 && icVar2.f6410g == null) {
                    icVar2.f6410g = jd.a(new jc.a().a("amap-netmanger-threadpool-%d").b());
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            icVar = f6409f;
        }
        return icVar;
    }

    public static ic b() {
        return a(true);
    }

    public static ic c() {
        return a(false);
    }

    @Deprecated
    public static Map<String, String> d(id idVar, boolean z10) throws fi {
        hw.d(idVar);
        idVar.setHttpProtocol(z10 ? id.c.HTTPS : id.c.HTTP);
        Map<String, String> map = null;
        long j10 = 0;
        boolean z11 = false;
        if (hw.b(idVar)) {
            boolean c4 = hw.c(idVar);
            try {
                j10 = SystemClock.elapsedRealtime();
                map = a(idVar, hw.a(idVar, c4), hw.c(idVar, c4));
            } catch (fi e2) {
                if (!c4) {
                    throw e2;
                }
                z11 = true;
            }
        }
        if (map != null) {
            return map;
        }
        try {
            return a(idVar, hw.b(idVar, z11), hw.a(idVar, j10));
        } catch (fi e10) {
            throw e10;
        }
    }

    @Deprecated
    private static ie e(id idVar, boolean z10) throws fi {
        byte[] bArr;
        hw.d(idVar);
        idVar.setHttpProtocol(z10 ? id.c.HTTPS : id.c.HTTP);
        ie ieVar = null;
        long j10 = 0;
        boolean z11 = false;
        if (hw.b(idVar)) {
            boolean c4 = hw.c(idVar);
            try {
                j10 = SystemClock.elapsedRealtime();
                ieVar = b(idVar, hw.a(idVar, c4), hw.c(idVar, c4));
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
            return b(idVar, hw.b(idVar, z11), hw.a(idVar, j10));
        } catch (fi e10) {
            throw e10;
        }
    }

    private static ie b(id idVar, id.b bVar, int i10) throws fi {
        try {
            hw.d(idVar);
            idVar.setDegradeType(bVar);
            idVar.setReal_max_timeout(i10);
            return new ia().b(idVar);
        } catch (fi e2) {
            throw e2;
        } catch (Throwable th) {
            th.printStackTrace();
            throw new fi(AMapException.ERROR_UNKNOWN);
        }
    }

    private static Map<String, String> a(id idVar, id.b bVar, int i10) throws fi {
        try {
            hw.d(idVar);
            idVar.setDegradeType(bVar);
            idVar.setReal_max_timeout(i10);
            return new ia().a(idVar);
        } catch (fi e2) {
            throw e2;
        } catch (Throwable th) {
            th.printStackTrace();
            throw new fi(AMapException.ERROR_UNKNOWN);
        }
    }

    public static ie e(id idVar) throws fi {
        return e(idVar, idVar.isHttps());
    }
}

package com.amap.api.col.s;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.amap.api.col.s.dz;
import com.amap.api.maps.AMapException;

/* compiled from: NetManger.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class dy extends dt {

    /* renamed from: f, reason: collision with root package name */
    private static dy f7825f;

    /* renamed from: g, reason: collision with root package name */
    private Handler f7826g;

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

    private dy() {
        try {
            if (Looper.myLooper() == null) {
                this.f7826g = new a(Looper.getMainLooper(), (byte) 0);
            } else {
                this.f7826g = new a();
            }
        } catch (Throwable th) {
            df.c(th, "NetManger", "NetManger1");
            th.printStackTrace();
        }
    }

    private static ea a(dz dzVar, dz.b bVar, int i10) throws bv {
        try {
            dt.d(dzVar);
            dzVar.a(bVar);
            dzVar.c(i10);
            return new dw().a(dzVar);
        } catch (bv e2) {
            throw e2;
        } catch (Throwable th) {
            th.printStackTrace();
            throw new bv(AMapException.ERROR_UNKNOWN);
        }
    }

    public static dy b() {
        return c();
    }

    private static synchronized dy c() {
        synchronized (dy.class) {
            try {
                if (f7825f == null) {
                    f7825f = new dy();
                }
            } finally {
                return f7825f;
            }
        }
        return f7825f;
    }

    @Deprecated
    private static ea d(dz dzVar, boolean z10) throws bv {
        byte[] bArr;
        dt.d(dzVar);
        dzVar.a(z10 ? dz.c.HTTPS : dz.c.HTTP);
        ea eaVar = null;
        long j10 = 0;
        boolean z11 = false;
        if (dt.b(dzVar)) {
            boolean c4 = dt.c(dzVar);
            try {
                j10 = SystemClock.elapsedRealtime();
                eaVar = a(dzVar, dt.a(dzVar, c4), dt.c(dzVar, c4));
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
            return a(dzVar, dt.b(dzVar, z11), dt.a(dzVar, j10));
        } catch (bv e10) {
            throw e10;
        }
    }

    public static ea e(dz dzVar) throws bv {
        return d(dzVar, dzVar.r());
    }
}

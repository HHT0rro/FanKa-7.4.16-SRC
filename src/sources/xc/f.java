package xc;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import com.tanx.onlyid.api.OAIDException;
import dexb.dexb.dexb.dexc.dexa.dexa.dexa.dexa.dexa.dexa.dexa;
import xc.m;

/* compiled from: GmsImpl.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class f implements wc.d {

    /* renamed from: a, reason: collision with root package name */
    public final Context f54634a;

    /* compiled from: GmsImpl.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public class a implements m.a {
        public a() {
        }

        @Override // xc.m.a
        public String callRemoteInterface(IBinder iBinder) throws OAIDException, RemoteException {
            dexa dexa = dexa.dexb.dexa(iBinder);
            if (dexa.isLimitAdTrackingEnabled(true)) {
                wc.f.a("User has disabled advertising identifier");
            }
            return dexa.getId();
        }
    }

    public f(Context context) {
        this.f54634a = context;
    }

    @Override // wc.d
    public void a(wc.c cVar) {
        if (this.f54634a == null || cVar == null) {
            return;
        }
        Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
        intent.setPackage("com.google.android.gms");
        m.a(this.f54634a, intent, cVar, new a());
    }

    @Override // wc.d
    public boolean supported() {
        Context context = this.f54634a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo("com.android.vending", 0) != null;
        } catch (Exception e2) {
            wc.f.a(e2);
            return false;
        }
    }
}

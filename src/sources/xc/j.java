package xc;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.os.RemoteException;
import com.bun.miitmdid.content.StringValues;
import com.tanx.onlyid.api.OAIDException;
import com.tanx.onlyid.core.bun.lib.MsaIdInterface;
import xc.m;

/* compiled from: MsaImpl.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class j implements wc.d {

    /* renamed from: a, reason: collision with root package name */
    public final Context f54642a;

    /* compiled from: MsaImpl.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public class a implements m.a {
        public a() {
        }

        @Override // xc.m.a
        public String callRemoteInterface(IBinder iBinder) throws OAIDException, RemoteException {
            MsaIdInterface asInterface = MsaIdInterface.Stub.asInterface(iBinder);
            if (asInterface != null) {
                if (asInterface.isSupported()) {
                    return asInterface.getOAID();
                }
                throw new OAIDException("MsaIdInterface#isSupported return false");
            }
            throw new OAIDException("MsaIdInterface is null");
        }
    }

    public j(Context context) {
        this.f54642a = context;
    }

    @Override // wc.d
    public void a(wc.c cVar) {
        if (this.f54642a == null || cVar == null) {
            return;
        }
        b();
        Intent intent = new Intent(StringValues.ACTION_BINDTO_MSASERVICE);
        intent.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaIdService");
        intent.putExtra(StringValues.PARAM_BIND_PKGNAME, this.f54642a.getPackageName());
        m.a(this.f54642a, intent, cVar, new a());
    }

    public final void b() {
        try {
            Intent intent = new Intent(StringValues.ACTION_START_MSASERVICE);
            intent.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaKlService");
            intent.putExtra(StringValues.PARAM_BIND_PKGNAME, this.f54642a.getPackageName());
            if (Build.VERSION.SDK_INT < 26) {
                this.f54642a.startService(intent);
            } else {
                this.f54642a.startForegroundService(intent);
            }
        } catch (Exception e2) {
            wc.f.a(e2);
        }
    }

    @Override // wc.d
    public boolean supported() {
        Context context = this.f54642a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo("com.mdid.msa", 0) != null;
        } catch (Exception e2) {
            wc.f.a(e2);
            return false;
        }
    }
}

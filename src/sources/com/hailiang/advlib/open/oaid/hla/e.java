package com.hailiang.advlib.open.oaid.hla;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.os.RemoteException;
import com.bun.miitmdid.content.StringValues;
import com.hailiang.advlib.open.oaid.OAIDException;
import com.hailiang.advlib.open.oaid.hl.hl.hl.a;
import com.hailiang.advlib.open.oaid.hla.g;

/* compiled from: MsaImpl.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class e implements com.hailiang.advlib.open.oaid.b {

    /* renamed from: a, reason: collision with root package name */
    public final Context f27184a;

    /* compiled from: MsaImpl.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class a implements g.a {
        public a() {
        }

        @Override // com.hailiang.advlib.open.oaid.hla.g.a
        public String a(IBinder iBinder) throws OAIDException, RemoteException {
            com.hailiang.advlib.open.oaid.hl.hl.hl.a a10 = a.b.a(iBinder);
            if (a10 != null) {
                if (a10.f()) {
                    return a10.a();
                }
                throw new OAIDException("MsaIdInterface#isSupported return false");
            }
            throw new OAIDException("MsaIdInterface is null");
        }
    }

    public e(Context context) {
        this.f27184a = context;
    }

    private void b() {
        try {
            Intent intent = new Intent(StringValues.ACTION_START_MSASERVICE);
            intent.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaKlService");
            intent.putExtra(StringValues.PARAM_BIND_PKGNAME, this.f27184a.getPackageName());
            if (Build.VERSION.SDK_INT < 26) {
                this.f27184a.startService(intent);
            } else {
                this.f27184a.startForegroundService(intent);
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.hailiang.advlib.open.oaid.b
    public boolean a() {
        Context context = this.f27184a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo("com.mdid.msa", 0) != null;
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // com.hailiang.advlib.open.oaid.b
    public void a(com.hailiang.advlib.open.oaid.a aVar) {
        if (this.f27184a == null || aVar == null) {
            return;
        }
        b();
        Intent intent = new Intent(StringValues.ACTION_BINDTO_MSASERVICE);
        intent.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaIdService");
        intent.putExtra(StringValues.PARAM_BIND_PKGNAME, this.f27184a.getPackageName());
        g.a(this.f27184a, intent, aVar, new a());
    }
}

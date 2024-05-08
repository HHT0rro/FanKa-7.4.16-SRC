package com.hailiang.advlib.open.oaid.hla;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import com.hailiang.advlib.open.oaid.OAIDException;
import com.hailiang.advlib.open.oaid.hl.hlc.hl.hl.a;
import com.hailiang.advlib.open.oaid.hla.g;

/* compiled from: SamsungImpl.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class i implements com.hailiang.advlib.open.oaid.b {

    /* renamed from: a, reason: collision with root package name */
    public final Context f27193a;

    /* compiled from: SamsungImpl.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class a implements g.a {
        public a() {
        }

        @Override // com.hailiang.advlib.open.oaid.hla.g.a
        public String a(IBinder iBinder) throws OAIDException, RemoteException {
            com.hailiang.advlib.open.oaid.hl.hlc.hl.hl.a a10 = a.b.a(iBinder);
            if (a10 != null) {
                return a10.a();
            }
            throw new OAIDException("IDeviceIdService is null");
        }
    }

    public i(Context context) {
        this.f27193a = context;
    }

    @Override // com.hailiang.advlib.open.oaid.b
    public boolean a() {
        Context context = this.f27193a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo("com.samsung.android.deviceidservice", 0) != null;
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // com.hailiang.advlib.open.oaid.b
    public void a(com.hailiang.advlib.open.oaid.a aVar) {
        if (this.f27193a == null || aVar == null) {
            return;
        }
        Intent intent = new Intent();
        intent.setClassName("com.samsung.android.deviceidservice", "com.samsung.android.deviceidservice.DeviceIdService");
        g.a(this.f27193a, intent, aVar, new a());
    }
}

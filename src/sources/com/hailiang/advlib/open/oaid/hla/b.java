package com.hailiang.advlib.open.oaid.hla;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import com.hailiang.advlib.open.oaid.OAIDException;
import com.hailiang.advlib.open.oaid.hl.hla.hl.hl.hl.hl.hl.a;
import com.hailiang.advlib.open.oaid.hla.g;

/* compiled from: GmsImpl.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class b implements com.hailiang.advlib.open.oaid.b {

    /* renamed from: a, reason: collision with root package name */
    public final Context f27178a;

    /* compiled from: GmsImpl.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class a implements g.a {
        public a() {
        }

        @Override // com.hailiang.advlib.open.oaid.hla.g.a
        public String a(IBinder iBinder) throws OAIDException, RemoteException {
            com.hailiang.advlib.open.oaid.hl.hla.hl.hl.hl.hl.hl.a a10 = a.b.a(iBinder);
            a10.a(true);
            return a10.c();
        }
    }

    public b(Context context) {
        this.f27178a = context;
    }

    @Override // com.hailiang.advlib.open.oaid.b
    public boolean a() {
        Context context = this.f27178a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo("com.android.vending", 0) != null;
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // com.hailiang.advlib.open.oaid.b
    public void a(com.hailiang.advlib.open.oaid.a aVar) {
        if (this.f27178a == null || aVar == null) {
            return;
        }
        Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
        intent.setPackage("com.google.android.gms");
        g.a(this.f27178a, intent, aVar, new a());
    }
}

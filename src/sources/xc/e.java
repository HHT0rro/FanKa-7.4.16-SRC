package xc;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import com.tanx.onlyid.api.OAIDException;
import com.tanx.onlyid.core.android.creator.IdsSupplier;
import xc.m;

/* compiled from: FreemeImpl.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class e implements wc.d {

    /* renamed from: a, reason: collision with root package name */
    public final Context f54632a;

    /* compiled from: FreemeImpl.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public class a implements m.a {
        public a() {
        }

        @Override // xc.m.a
        public String callRemoteInterface(IBinder iBinder) throws OAIDException, RemoteException {
            IdsSupplier asInterface = IdsSupplier.Stub.asInterface(iBinder);
            if (asInterface != null) {
                return asInterface.getOAID();
            }
            throw new OAIDException("IdsSupplier is null");
        }
    }

    public e(Context context) {
        this.f54632a = context;
    }

    @Override // wc.d
    public void a(wc.c cVar) {
        if (this.f54632a == null || cVar == null) {
            return;
        }
        Intent intent = new Intent("android.service.action.msa");
        intent.setPackage("com.android.creator");
        m.a(this.f54632a, intent, cVar, new a());
    }

    @Override // wc.d
    public boolean supported() {
        Context context = this.f54632a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo("com.android.creator", 0) != null;
        } catch (Exception e2) {
            wc.f.a(e2);
            return false;
        }
    }
}

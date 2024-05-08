package xc;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import com.tanx.onlyid.api.OAIDException;
import com.tanx.onlyid.core.asus.msa.SupplementaryDID.IDidAidlInterface;
import xc.m;

/* compiled from: AsusImpl.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class a implements wc.d {

    /* renamed from: a, reason: collision with root package name */
    public final Context f54626a;

    /* compiled from: AsusImpl.java */
    /* renamed from: xc.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public class C0842a implements m.a {
        public C0842a() {
        }

        @Override // xc.m.a
        public String callRemoteInterface(IBinder iBinder) throws OAIDException, RemoteException {
            IDidAidlInterface asInterface = IDidAidlInterface.Stub.asInterface(iBinder);
            if (asInterface != null) {
                if (asInterface.isSupport()) {
                    return asInterface.getOAID();
                }
                throw new OAIDException("IDidAidlInterface#isSupport return false");
            }
            throw new OAIDException("IDidAidlInterface is null");
        }
    }

    public a(Context context) {
        this.f54626a = context;
    }

    @Override // wc.d
    public void a(wc.c cVar) {
        if (this.f54626a == null || cVar == null) {
            return;
        }
        Intent intent = new Intent("com.asus.msa.action.ACCESS_DID");
        intent.setComponent(new ComponentName("com.asus.msa.SupplementaryDID", "com.asus.msa.SupplementaryDID.SupplementaryDIDService"));
        m.a(this.f54626a, intent, cVar, new C0842a());
    }

    @Override // wc.d
    public boolean supported() {
        Context context = this.f54626a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo("com.asus.msa.SupplementaryDID", 0) != null;
        } catch (Exception e2) {
            wc.f.a(e2);
            return false;
        }
    }
}

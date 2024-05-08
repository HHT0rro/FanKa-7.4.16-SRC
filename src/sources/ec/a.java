package ec;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.weibo.ssosdk.oaid.OAIDException;
import com.weibo.ssosdk.oaid.repeackage.ext.SupplementaryDID.IDidAidlInterface;
import ec.g;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class a implements cc.c {

    /* renamed from: a, reason: collision with root package name */
    public final Context f48999a;

    /* renamed from: ec.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public class C0728a implements g.a {
        public C0728a() {
        }

        @Override // ec.g.a
        public String callRemoteInterface(IBinder iBinder) {
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
        this.f48999a = context;
    }

    @Override // cc.c
    public void a(cc.b bVar) {
        Intent intent = new Intent("com.asus.msa.action.ACCESS_DID");
        intent.setComponent(new ComponentName("com.asus.msa.SupplementaryDID", "com.asus.msa.SupplementaryDID.SupplementaryDIDService"));
        g.a(this.f48999a, intent, bVar, new C0728a());
    }

    @Override // cc.c
    public boolean supported() {
        try {
            return this.f48999a.getPackageManager().getPackageInfo("com.asus.msa.SupplementaryDID", 0) != null;
        } catch (Exception unused) {
            return false;
        }
    }
}

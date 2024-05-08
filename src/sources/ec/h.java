package ec;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import com.weibo.ssosdk.oaid.OAIDException;
import com.weibo.ssosdk.oaid.repeackage.ext.openid.IOpenID;
import ec.g;
import java.security.MessageDigest;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class h implements cc.c {

    /* renamed from: a, reason: collision with root package name */
    public final Context f49012a;

    /* renamed from: b, reason: collision with root package name */
    public String f49013b;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public class a implements g.a {
        public a() {
        }

        @Override // ec.g.a
        public String callRemoteInterface(IBinder iBinder) {
            try {
                return h.this.d(iBinder);
            } catch (RemoteException e2) {
                throw e2;
            } catch (OAIDException e10) {
                throw e10;
            } catch (Exception e11) {
                throw new OAIDException(e11);
            }
        }
    }

    public h(Context context) {
        if (context instanceof Application) {
            this.f49012a = context;
        } else {
            this.f49012a = context.getApplicationContext();
        }
    }

    @Override // cc.c
    public void a(cc.b bVar) {
        Intent intent = new Intent("action.com.heytap.openid.OPEN_ID_SERVICE");
        intent.setComponent(new ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
        g.a(this.f49012a, intent, bVar, new a());
    }

    public final String c(IBinder iBinder, String str, String str2) {
        IOpenID asInterface = IOpenID.Stub.asInterface(iBinder);
        if (asInterface != null) {
            return asInterface.getSerID(str, str2, "OUID");
        }
        throw new OAIDException("IOpenID is null");
    }

    public final String d(IBinder iBinder) {
        String packageName = this.f49012a.getPackageName();
        String str = this.f49013b;
        if (str == null) {
            byte[] digest = MessageDigest.getInstance("SHA1").digest(this.f49012a.getPackageManager().getPackageInfo(packageName, 64).signatures[0].toByteArray());
            StringBuilder sb2 = new StringBuilder();
            for (byte b4 : digest) {
                sb2.append(Integer.toHexString((b4 & 255) | 256).substring(1, 3));
            }
            String sb3 = sb2.toString();
            this.f49013b = sb3;
            return c(iBinder, packageName, sb3);
        }
        return c(iBinder, packageName, str);
    }

    @Override // cc.c
    public boolean supported() {
        try {
            return this.f49012a.getPackageManager().getPackageInfo("com.heytap.openid", 0) != null;
        } catch (Exception unused) {
            return false;
        }
    }
}

package xc;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.os.RemoteException;
import com.tanx.onlyid.api.OAIDException;
import com.tanx.onlyid.core.heytap.openid.IOpenID;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import xc.m;

/* compiled from: OppoImpl.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class n implements wc.d {

    /* renamed from: a, reason: collision with root package name */
    public final Context f54649a;

    /* renamed from: b, reason: collision with root package name */
    public String f54650b;

    /* compiled from: OppoImpl.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public class a implements m.a {
        public a() {
        }

        @Override // xc.m.a
        public String callRemoteInterface(IBinder iBinder) throws OAIDException, RemoteException {
            try {
                return n.this.b(iBinder);
            } catch (RemoteException e2) {
                throw e2;
            } catch (OAIDException e10) {
                throw e10;
            } catch (Exception e11) {
                throw new OAIDException(e11);
            }
        }
    }

    public n(Context context) {
        if (context instanceof Application) {
            this.f54649a = context;
        } else {
            this.f54649a = context.getApplicationContext();
        }
    }

    @Override // wc.d
    public void a(wc.c cVar) {
        if (this.f54649a == null || cVar == null) {
            return;
        }
        Intent intent = new Intent("action.com.heytap.openid.OPEN_ID_SERVICE");
        intent.setComponent(new ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
        m.a(this.f54649a, intent, cVar, new a());
    }

    public final String b(IBinder iBinder) throws PackageManager.NameNotFoundException, NoSuchAlgorithmException, RemoteException, OAIDException {
        String packageName = this.f54649a.getPackageName();
        String str = this.f54650b;
        if (str == null) {
            byte[] digest = MessageDigest.getInstance("SHA1").digest(this.f54649a.getPackageManager().getPackageInfo(packageName, 64).signatures[0].toByteArray());
            StringBuilder sb2 = new StringBuilder();
            for (byte b4 : digest) {
                sb2.append(Integer.toHexString((b4 & 255) | 256).substring(1, 3));
            }
            String sb3 = sb2.toString();
            this.f54650b = sb3;
            return c(iBinder, packageName, sb3);
        }
        return c(iBinder, packageName, str);
    }

    public final String c(IBinder iBinder, String str, String str2) throws RemoteException, OAIDException {
        IOpenID asInterface = IOpenID.Stub.asInterface(iBinder);
        if (asInterface != null) {
            return asInterface.getSerID(str, str2, "OUID");
        }
        throw new OAIDException("IOpenID is null");
    }

    @Override // wc.d
    public boolean supported() {
        Context context = this.f54649a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo("com.heytap.openid", 0) != null;
        } catch (Exception e2) {
            wc.f.a(e2);
            return false;
        }
    }
}

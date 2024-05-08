package com.hailiang.advlib.open.oaid.hla;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.os.RemoteException;
import com.hailiang.advlib.open.oaid.OAIDException;
import com.hailiang.advlib.open.oaid.hl.hlb.hl.a;
import com.hailiang.advlib.open.oaid.hla.g;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* compiled from: OppoImpl.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class h implements com.hailiang.advlib.open.oaid.b {

    /* renamed from: a, reason: collision with root package name */
    public final Context f27190a;

    /* renamed from: b, reason: collision with root package name */
    public String f27191b;

    /* compiled from: OppoImpl.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class a implements g.a {
        public a() {
        }

        @Override // com.hailiang.advlib.open.oaid.hla.g.a
        public String a(IBinder iBinder) throws OAIDException, RemoteException {
            try {
                return h.this.a(iBinder);
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
            this.f27190a = context;
        } else {
            this.f27190a = context.getApplicationContext();
        }
    }

    @Override // com.hailiang.advlib.open.oaid.b
    public boolean a() {
        Context context = this.f27190a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo("com.heytap.openid", 0) != null;
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // com.hailiang.advlib.open.oaid.b
    public void a(com.hailiang.advlib.open.oaid.a aVar) {
        if (this.f27190a == null || aVar == null) {
            return;
        }
        Intent intent = new Intent("action.com.heytap.openid.OPEN_ID_SERVICE");
        intent.setComponent(new ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
        g.a(this.f27190a, intent, aVar, new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(IBinder iBinder) throws PackageManager.NameNotFoundException, NoSuchAlgorithmException, RemoteException, OAIDException {
        String packageName = this.f27190a.getPackageName();
        String str = this.f27191b;
        if (str == null) {
            byte[] digest = MessageDigest.getInstance("SHA1").digest(this.f27190a.getPackageManager().getPackageInfo(packageName, 64).signatures[0].toByteArray());
            StringBuilder sb2 = new StringBuilder();
            for (byte b4 : digest) {
                sb2.append(Integer.toHexString((b4 & 255) | 256).substring(1, 3));
            }
            String sb3 = sb2.toString();
            this.f27191b = sb3;
            return a(iBinder, packageName, sb3);
        }
        return a(iBinder, packageName, str);
    }

    private String a(IBinder iBinder, String str, String str2) throws RemoteException, OAIDException {
        com.hailiang.advlib.open.oaid.hl.hlb.hl.a a10 = a.b.a(iBinder);
        if (a10 != null) {
            return a10.a(str, str2, "OUID");
        }
        throw new OAIDException("IOpenID is null");
    }
}

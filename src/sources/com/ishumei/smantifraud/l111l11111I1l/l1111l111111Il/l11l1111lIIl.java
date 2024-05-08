package com.ishumei.smantifraud.l111l11111I1l.l1111l111111Il;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.Signature;
import android.os.IBinder;
import android.os.Parcel;
import java.security.MessageDigest;
import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class l11l1111lIIl extends l111l1111lI1l {
    private final LinkedBlockingQueue<IBinder> l1111l111111Il = new LinkedBlockingQueue<>(1);
    private ServiceConnection l111l11111I1l = new ServiceConnection() { // from class: com.ishumei.smantifraud.l111l11111I1l.l1111l111111Il.l11l1111lIIl.1
        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                l11l1111lIIl.this.l1111l111111Il.put(iBinder);
            } catch (Throwable unused) {
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
        }
    };
    private Context l111l11111lIl;

    public l11l1111lIIl(Context context) {
        this.l111l11111lIl = context;
    }

    private static String l1111l111111Il(Context context, String str) {
        try {
            Signature[] signatureArr = context.getPackageManager().getPackageInfo(str, 64).signatures;
            if (signatureArr == null || signatureArr.length <= 0) {
                return "";
            }
            byte[] byteArray = signatureArr[0].toByteArray();
            MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
            if (messageDigest == null) {
                return "";
            }
            byte[] digest = messageDigest.digest(byteArray);
            StringBuilder sb2 = new StringBuilder();
            for (byte b4 : digest) {
                sb2.append(Integer.toHexString((b4 & 255) | 256).substring(1, 3));
            }
            return sb2.toString();
        } catch (Exception unused) {
            return "";
        }
    }

    private String l1111l111111Il(IBinder iBinder) {
        String packageName = this.l111l11111lIl.getPackageName();
        String l1111l111111Il = l1111l111111Il(this.l111l11111lIl, packageName);
        try {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.heytap.openid.IOpenID");
                obtain.writeString(packageName);
                obtain.writeString(l1111l111111Il);
                obtain.writeString("OUID");
                iBinder.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                String readString = obtain2.readString();
                try {
                    return readString;
                } catch (Exception unused) {
                    return readString;
                }
            } finally {
                obtain.recycle();
                obtain2.recycle();
            }
        } catch (Exception unused2) {
            return "";
        }
    }

    @Override // com.ishumei.smantifraud.l111l11111I1l.l1111l111111Il.l111l1111lI1l
    public final String l1111l111111Il() {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
        intent.setAction("action.com.heytap.openid.OPEN_ID_SERVICE");
        String str = "";
        if (!this.l111l11111lIl.bindService(intent, this.l111l11111I1l, 1)) {
            return "";
        }
        try {
            str = l1111l111111Il(this.l1111l111111Il.take());
            this.l111l11111lIl.unbindService(this.l111l11111I1l);
            return str;
        } catch (Throwable unused) {
            return str;
        }
    }
}

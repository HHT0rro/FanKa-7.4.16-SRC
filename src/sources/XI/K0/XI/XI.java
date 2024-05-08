package XI.K0.XI;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.text.TextUtils;
import com.huawei.openalliance.ad.ipc.c;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public interface XI extends IInterface {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public class K0 {

        /* renamed from: XI, reason: collision with root package name */
        public XI f642XI = null;
        public String K0 = null;
        public String kM = null;
        public final Object xo = new Object();
        public ServiceConnection CA = new ServiceConnectionC0001XI();

        /* renamed from: XI.K0.XI.XI$K0$K0, reason: collision with other inner class name */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
        public static class C0000K0 {

            /* renamed from: XI, reason: collision with root package name */
            public static final K0 f643XI = new K0();
        }

        /* renamed from: XI.K0.XI.XI$K0$XI, reason: collision with other inner class name */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
        public class ServiceConnectionC0001XI implements ServiceConnection {
            public ServiceConnectionC0001XI() {
            }

            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                K0.this.f642XI = AbstractBinderC0002XI.XI(iBinder);
                synchronized (K0.this.xo) {
                    K0.this.xo.notify();
                }
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName componentName) {
                K0.this.f642XI = null;
            }
        }

        public final String K0(Context context, String str) {
            Signature[] signatureArr;
            if (TextUtils.isEmpty(this.K0)) {
                this.K0 = context.getPackageName();
            }
            if (TextUtils.isEmpty(this.kM)) {
                String str2 = null;
                try {
                    signatureArr = context.getPackageManager().getPackageInfo(this.K0, 64).signatures;
                } catch (PackageManager.NameNotFoundException e2) {
                    e2.printStackTrace();
                    signatureArr = null;
                }
                if (signatureArr != null && signatureArr.length > 0) {
                    byte[] byteArray = signatureArr[0].toByteArray();
                    try {
                        MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
                        if (messageDigest != null) {
                            byte[] digest = messageDigest.digest(byteArray);
                            StringBuilder sb2 = new StringBuilder();
                            for (byte b4 : digest) {
                                sb2.append(Integer.toHexString((b4 & 255) | 256).substring(1, 3));
                            }
                            str2 = sb2.toString();
                        }
                    } catch (NoSuchAlgorithmException e10) {
                        e10.printStackTrace();
                    }
                }
                this.kM = str2;
            }
            XI xi = this.f642XI;
            if (xi == null) {
                context.getPackageName();
                return "";
            }
            String str3 = this.K0;
            String str4 = this.kM;
            AbstractBinderC0002XI.C0003XI c0003xi = (AbstractBinderC0002XI.C0003XI) xi;
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.heytap.openid.IOpenID");
                obtain.writeString(str3);
                obtain.writeString(str4);
                obtain.writeString(str);
                c0003xi.f645XI.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                String readString = obtain2.readString();
                obtain2.recycle();
                obtain.recycle();
                return TextUtils.isEmpty(readString) ? "" : readString;
            } catch (Throwable th) {
                obtain2.recycle();
                obtain.recycle();
                throw th;
            }
        }

        public synchronized String XI(Context context, String str) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                return "";
            }
            if (this.f642XI != null) {
                try {
                    return K0(context, str);
                } catch (RemoteException unused) {
                    return "";
                }
            }
            XI(context);
            if (this.f642XI == null) {
                return "";
            }
            try {
                return K0(context, str);
            } catch (RemoteException unused2) {
                return "";
            }
        }

        public final void XI(Context context) {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
            intent.setAction("action.com.heytap.openid.OPEN_ID_SERVICE");
            if (context.bindService(intent, this.CA, 1)) {
                synchronized (this.xo) {
                    try {
                        this.xo.wait(c.Code);
                    } catch (InterruptedException unused) {
                    }
                }
            }
        }
    }

    /* renamed from: XI.K0.XI.XI$XI, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static abstract class AbstractBinderC0002XI extends Binder implements XI {

        /* renamed from: XI.K0.XI.XI$XI$XI, reason: collision with other inner class name */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
        public static class C0003XI implements XI {

            /* renamed from: XI, reason: collision with root package name */
            public IBinder f645XI;

            public C0003XI(IBinder iBinder) {
                this.f645XI = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f645XI;
            }
        }

        public static XI XI(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.heytap.openid.IOpenID");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof XI)) ? new C0003XI(iBinder) : (XI) queryLocalInterface;
        }
    }
}

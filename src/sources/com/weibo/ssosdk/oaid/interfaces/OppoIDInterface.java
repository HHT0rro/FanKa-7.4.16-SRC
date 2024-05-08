package com.weibo.ssosdk.oaid.interfaces;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public interface OppoIDInterface extends IInterface {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static abstract class up extends Binder implements OppoIDInterface {

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
        public static class down implements OppoIDInterface {
            public IBinder iBinder;

            public down(IBinder iBinder) {
                this.iBinder = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.iBinder;
            }

            public String getSerID(String str, String str2, String str3) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    try {
                        obtain.writeInterfaceToken("com.heytap.openid.IOpenID");
                        obtain.writeString(str);
                        obtain.writeString(str2);
                        obtain.writeString(str3);
                        this.iBinder.transact(1, obtain, obtain2, 0);
                        obtain2.readException();
                        return obtain2.readString();
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        obtain.recycle();
                        obtain2.recycle();
                        return null;
                    }
                } finally {
                    obtain.recycle();
                    obtain2.recycle();
                }
            }
        }

        public static OppoIDInterface genInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.heytap.openid.IOpenID");
            if (queryLocalInterface != null && (queryLocalInterface instanceof OppoIDInterface)) {
                return (OppoIDInterface) queryLocalInterface;
            }
            return new down(iBinder);
        }
    }
}

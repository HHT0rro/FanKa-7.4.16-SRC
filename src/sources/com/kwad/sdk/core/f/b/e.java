package com.kwad.sdk.core.f.b;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public interface e extends IInterface {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class a implements e {
        private IBinder axj;

        public a(IBinder iBinder) {
            this.axj = iBinder;
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return this.axj;
        }

        public final String getID() {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.samsung.android.deviceidservice.IDeviceIdService");
                this.axj.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                String readString = obtain2.readString();
                obtain2.recycle();
                obtain.recycle();
                return readString;
            } catch (Exception unused) {
                obtain2.recycle();
                obtain.recycle();
                return null;
            } catch (Throwable th) {
                obtain2.recycle();
                obtain.recycle();
                throw th;
            }
        }
    }
}

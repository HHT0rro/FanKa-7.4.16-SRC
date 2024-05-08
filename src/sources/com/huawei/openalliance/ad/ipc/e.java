package com.huawei.openalliance.ad.ipc;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.huawei.hms.ads.gl;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public interface e extends IInterface {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static abstract class a extends Binder implements e {
        public static final int Code = 1;
        private static final String I = "com.huawei.android.hms.ppskit.IPPSResultCallback";
        private static final String V = "IPPSResultCallback";

        /* renamed from: com.huawei.openalliance.ad.ipc.e$a$a, reason: collision with other inner class name */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
        public static class C0336a implements e {
            private IBinder Code;

            public C0336a(IBinder iBinder) {
                this.Code = iBinder;
            }

            public String Code() {
                return a.I;
            }

            @Override // com.huawei.openalliance.ad.ipc.e
            public void Code(String str, int i10, String str2) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.I);
                    obtain.writeString(str);
                    obtain.writeInt(i10);
                    obtain.writeString(str2);
                    this.Code.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.Code;
            }
        }

        public a() {
            attachInterface(this, I);
        }

        public static e Code(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            try {
                IInterface queryLocalInterface = iBinder.queryLocalInterface(I);
                return (queryLocalInterface == null || !(queryLocalInterface instanceof e)) ? new C0336a(iBinder) : (e) queryLocalInterface;
            } catch (Throwable th) {
                gl.I(V, "IPPSResultCallback err: " + th.getClass().getSimpleName());
                return null;
            }
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) {
            if (i10 != 1) {
                if (i10 != 1598968902) {
                    return super.onTransact(i10, parcel, parcel2, i11);
                }
                parcel2.writeString(I);
                return true;
            }
            parcel.enforceInterface(I);
            Code(parcel.readString(), parcel.readInt(), parcel.readString());
            parcel2.writeNoException();
            return true;
        }
    }

    void Code(String str, int i10, String str2);
}

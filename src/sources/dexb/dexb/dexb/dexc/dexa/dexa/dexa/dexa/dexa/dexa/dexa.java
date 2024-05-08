package dexb.dexb.dexb.dexc.dexa.dexa.dexa.dexa.dexa.dexa;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: IAdvertisingIdService.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public interface dexa extends IInterface {

    /* compiled from: IAdvertisingIdService.java */
    /* renamed from: dexb.dexb.dexb.dexc.dexa.dexa.dexa.dexa.dexa.dexa.dexa$dexa, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class C0723dexa implements dexa {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // dexb.dexb.dexb.dexc.dexa.dexa.dexa.dexa.dexa.dexa.dexa
        public String getId() throws RemoteException {
            return null;
        }

        @Override // dexb.dexb.dexb.dexc.dexa.dexa.dexa.dexa.dexa.dexa.dexa
        public boolean isLimitAdTrackingEnabled(boolean z10) throws RemoteException {
            return false;
        }
    }

    String getId() throws RemoteException;

    boolean isLimitAdTrackingEnabled(boolean z10) throws RemoteException;

    /* compiled from: IAdvertisingIdService.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static abstract class dexb extends Binder implements dexa {
        public static final String dexa = "com.google.android.gms.ads.identifier.internal.IAdvertisingIdService";

        /* renamed from: dexb, reason: collision with root package name */
        public static final int f48700dexb = 1;
        public static final int dexc = 2;

        /* compiled from: IAdvertisingIdService.java */
        /* renamed from: dexb.dexb.dexb.dexc.dexa.dexa.dexa.dexa.dexa.dexa.dexa$dexb$dexa, reason: collision with other inner class name */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
        public static class C0724dexa implements dexa {

            /* renamed from: dexb, reason: collision with root package name */
            public static dexa f48701dexb;
            public IBinder dexa;

            public C0724dexa(IBinder iBinder) {
                this.dexa = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.dexa;
            }

            public String dexa() {
                return "com.google.android.gms.ads.identifier.internal.IAdvertisingIdService";
            }

            @Override // dexb.dexb.dexb.dexc.dexa.dexa.dexa.dexa.dexa.dexa.dexa
            public String getId() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                    if (!this.dexa.transact(1, obtain, obtain2, 0) && dexb.dexa() != null) {
                        return dexb.dexa().getId();
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // dexb.dexb.dexb.dexc.dexa.dexa.dexa.dexa.dexa.dexa.dexa
            public boolean isLimitAdTrackingEnabled(boolean z10) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                    obtain.writeInt(z10 ? 1 : 0);
                    if (!this.dexa.transact(2, obtain, obtain2, 0) && dexb.dexa() != null) {
                        return dexb.dexa().isLimitAdTrackingEnabled(z10);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public dexb() {
            attachInterface(this, "com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
        }

        public static dexa dexa(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
            if (queryLocalInterface != null && (queryLocalInterface instanceof dexa)) {
                return (dexa) queryLocalInterface;
            }
            return new C0724dexa(iBinder);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            if (i10 == 1) {
                parcel.enforceInterface("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                String id2 = getId();
                parcel2.writeNoException();
                parcel2.writeString(id2);
                return true;
            }
            if (i10 != 2) {
                if (i10 != 1598968902) {
                    return super.onTransact(i10, parcel, parcel2, i11);
                }
                parcel2.writeString("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                return true;
            }
            parcel.enforceInterface("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
            boolean isLimitAdTrackingEnabled = isLimitAdTrackingEnabled(parcel.readInt() != 0);
            parcel2.writeNoException();
            parcel2.writeInt(isLimitAdTrackingEnabled ? 1 : 0);
            return true;
        }

        public static boolean dexa(dexa dexaVar) {
            if (C0724dexa.f48701dexb != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (dexaVar == null) {
                return false;
            }
            C0724dexa.f48701dexb = dexaVar;
            return true;
        }

        public static dexa dexa() {
            return C0724dexa.f48701dexb;
        }
    }
}

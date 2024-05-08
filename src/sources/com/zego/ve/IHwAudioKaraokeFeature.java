package com.zego.ve;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HwAudioKit.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public interface IHwAudioKaraokeFeature extends IInterface {

    /* compiled from: HwAudioKit.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static abstract class Stub extends Binder implements IHwAudioKaraokeFeature {
        private static final String DESCRIPTOR = "com.huawei.multimedia.audioengine.IHwAudioKaraokeFeature";
        public static final int TRANSACTION_enableKaraokeFeature = 2;
        public static final int TRANSACTION_getKaraokeLatency = 3;
        public static final int TRANSACTION_init = 5;
        public static final int TRANSACTION_isKaraokeFeatureSupport = 1;
        public static final int TRANSACTION_setParameter = 4;

        /* compiled from: HwAudioKit.java */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
        public static class Proxy implements IHwAudioKaraokeFeature {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.zego.ve.IHwAudioKaraokeFeature
            public int enableKaraokeFeature(boolean z10) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(z10 ? 1 : 0);
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.zego.ve.IHwAudioKaraokeFeature
            public int getKaraokeLatency() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.zego.ve.IHwAudioKaraokeFeature
            public void init(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    this.mRemote.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.zego.ve.IHwAudioKaraokeFeature
            public boolean isKaraokeFeatureSupport() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.zego.ve.IHwAudioKaraokeFeature
            public int setParameter(String str, int i10) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeInt(i10);
                    this.mRemote.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IHwAudioKaraokeFeature asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IHwAudioKaraokeFeature)) ? new Proxy(iBinder) : (IHwAudioKaraokeFeature) queryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            if (i10 == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                boolean isKaraokeFeatureSupport = isKaraokeFeatureSupport();
                parcel2.writeNoException();
                parcel2.writeInt(isKaraokeFeatureSupport ? 1 : 0);
                return true;
            }
            if (i10 == 2) {
                parcel.enforceInterface(DESCRIPTOR);
                int enableKaraokeFeature = enableKaraokeFeature(parcel.readInt() != 0);
                parcel2.writeNoException();
                parcel2.writeInt(enableKaraokeFeature);
                return true;
            }
            if (i10 == 3) {
                parcel.enforceInterface(DESCRIPTOR);
                int karaokeLatency = getKaraokeLatency();
                parcel2.writeNoException();
                parcel2.writeInt(karaokeLatency);
                return true;
            }
            if (i10 == 4) {
                parcel.enforceInterface(DESCRIPTOR);
                int parameter = setParameter(parcel.readString(), parcel.readInt());
                parcel2.writeNoException();
                parcel2.writeInt(parameter);
                return true;
            }
            if (i10 != 5) {
                if (i10 != 1598968902) {
                    return super.onTransact(i10, parcel, parcel2, i11);
                }
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
            parcel.enforceInterface(DESCRIPTOR);
            init(parcel.readString());
            parcel2.writeNoException();
            return true;
        }
    }

    int enableKaraokeFeature(boolean z10) throws RemoteException;

    int getKaraokeLatency() throws RemoteException;

    void init(String str) throws RemoteException;

    boolean isKaraokeFeatureSupport() throws RemoteException;

    int setParameter(String str, int i10) throws RemoteException;
}

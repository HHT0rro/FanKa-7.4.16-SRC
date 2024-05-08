package com.zego.ve;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HwAudioKit.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public interface IHwAudioEngine extends IInterface {

    /* compiled from: HwAudioKit.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static abstract class Stub extends Binder implements IHwAudioEngine {
        public static final int TRANSACTION_getSupportedFeatures = 1;
        public static final int TRANSACTION_init = 3;
        public static final int TRANSACTION_isFeatureSupported = 2;

        /* compiled from: HwAudioKit.java */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
        public static class Proxy implements IHwAudioEngine {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.zego.ve.IHwAudioEngine
            public List getSupportedFeatures() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.huawei.multimedia.audioengine.IHwAudioEngine");
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readArrayList(getClass().getClassLoader());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.zego.ve.IHwAudioEngine
            public void init(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.huawei.multimedia.audioengine.IHwAudioEngine");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.mRemote.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.zego.ve.IHwAudioEngine
            public boolean isFeatureSupported(int i10) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.huawei.multimedia.audioengine.IHwAudioEngine");
                    obtain.writeInt(i10);
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, "com.huawei.multimedia.audioengine.IHwAudioEngine");
        }

        public static IHwAudioEngine asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.huawei.multimedia.audioengine.IHwAudioEngine");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IHwAudioEngine)) ? new Proxy(iBinder) : (IHwAudioEngine) queryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            if (i10 == 1) {
                parcel.enforceInterface("com.huawei.multimedia.audioengine.IHwAudioEngine");
                List supportedFeatures = getSupportedFeatures();
                parcel2.writeNoException();
                parcel2.writeList(supportedFeatures);
                return true;
            }
            if (i10 == 2) {
                parcel.enforceInterface("com.huawei.multimedia.audioengine.IHwAudioEngine");
                boolean isFeatureSupported = isFeatureSupported(parcel.readInt());
                parcel2.writeNoException();
                parcel2.writeInt(isFeatureSupported ? 1 : 0);
                return true;
            }
            if (i10 != 3) {
                if (i10 != 1598968902) {
                    return super.onTransact(i10, parcel, parcel2, i11);
                }
                parcel2.writeString("com.huawei.multimedia.audioengine.IHwAudioEngine");
                return true;
            }
            parcel.enforceInterface("com.huawei.multimedia.audioengine.IHwAudioEngine");
            init(parcel.readString(), parcel.readString());
            parcel2.writeNoException();
            return true;
        }
    }

    List getSupportedFeatures() throws RemoteException;

    void init(String str, String str2) throws RemoteException;

    boolean isFeatureSupported(int i10) throws RemoteException;
}

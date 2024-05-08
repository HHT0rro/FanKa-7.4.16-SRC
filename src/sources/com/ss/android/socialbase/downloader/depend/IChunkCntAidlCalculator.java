package com.ss.android.socialbase.downloader.depend;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public interface IChunkCntAidlCalculator extends IInterface {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class Default implements IChunkCntAidlCalculator {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.depend.IChunkCntAidlCalculator
        public int calculateChunkCount(long j10) throws RemoteException {
            return 0;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static abstract class Stub extends Binder implements IChunkCntAidlCalculator {
        private static final String DESCRIPTOR = "com.ss.android.socialbase.downloader.depend.IChunkCntAidlCalculator";
        public static final int TRANSACTION_calculateChunkCount = 1;

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
        public static class Proxy implements IChunkCntAidlCalculator {
            public static IChunkCntAidlCalculator sDefaultImpl;
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.ss.android.socialbase.downloader.depend.IChunkCntAidlCalculator
            public int calculateChunkCount(long j10) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeLong(j10);
                    if (!this.mRemote.transact(1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().calculateChunkCount(j10);
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IChunkCntAidlCalculator asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof IChunkCntAidlCalculator)) {
                return (IChunkCntAidlCalculator) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        public static IChunkCntAidlCalculator getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IChunkCntAidlCalculator iChunkCntAidlCalculator) {
            if (Proxy.sDefaultImpl != null || iChunkCntAidlCalculator == null) {
                return false;
            }
            Proxy.sDefaultImpl = iChunkCntAidlCalculator;
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            if (i10 != 1) {
                if (i10 != 1598968902) {
                    return super.onTransact(i10, parcel, parcel2, i11);
                }
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
            parcel.enforceInterface(DESCRIPTOR);
            int calculateChunkCount = calculateChunkCount(parcel.readLong());
            parcel2.writeNoException();
            parcel2.writeInt(calculateChunkCount);
            return true;
        }
    }

    int calculateChunkCount(long j10) throws RemoteException;
}

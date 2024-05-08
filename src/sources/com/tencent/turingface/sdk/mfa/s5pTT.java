package com.tencent.turingface.sdk.mfa;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public interface s5pTT extends IInterface {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static abstract class spXPg extends Binder implements s5pTT {

        /* renamed from: a, reason: collision with root package name */
        public static final String f45938a = kC0XR.a(kC0XR.M0);

        /* renamed from: com.tencent.turingface.sdk.mfa.s5pTT$spXPg$spXPg, reason: collision with other inner class name */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
        public static class C0656spXPg implements s5pTT {

            /* renamed from: a, reason: collision with root package name */
            public IBinder f45939a;

            public C0656spXPg(IBinder iBinder) {
                this.f45939a = iBinder;
            }

            @Override // com.tencent.turingface.sdk.mfa.s5pTT
            public final boolean a() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(spXPg.f45938a);
                    obtain.writeInt(2000);
                    this.f45939a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.f45939a;
            }

            @Override // com.tencent.turingface.sdk.mfa.s5pTT
            public final int b() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(spXPg.f45938a);
                    this.f45939a.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.tencent.turingface.sdk.mfa.s5pTT
            public final int c() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(spXPg.f45938a);
                    obtain.writeInt(2000);
                    this.f45939a.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.tencent.turingface.sdk.mfa.s5pTT
            public final SWw7W d() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(spXPg.f45938a);
                    obtain.writeInt(2000);
                    this.f45939a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? new SWw7W(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.tencent.turingface.sdk.mfa.s5pTT
            public final int e() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(spXPg.f45938a);
                    obtain.writeInt(2000);
                    this.f45939a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }

    boolean a() throws RemoteException;

    int b() throws RemoteException;

    int c() throws RemoteException;

    SWw7W d() throws RemoteException;

    int e() throws RemoteException;
}

package com.liteav.audio2.earmonitor.a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public interface b extends IInterface {
    int a(String str, int i10) throws RemoteException;

    int a(boolean z10) throws RemoteException;

    void a(String str) throws RemoteException;

    boolean a() throws RemoteException;

    int b() throws RemoteException;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static abstract class a extends Binder implements b {
        public static b a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.huawei.multimedia.audioengine.IHwAudioKaraokeFeature");
            if (queryLocalInterface != null && (queryLocalInterface instanceof b)) {
                return (b) queryLocalInterface;
            }
            return new C0554a(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            if (i10 == 1) {
                parcel.enforceInterface("com.huawei.multimedia.audioengine.IHwAudioKaraokeFeature");
                boolean a10 = a();
                parcel2.writeNoException();
                parcel2.writeInt(a10 ? 1 : 0);
                return true;
            }
            if (i10 == 2) {
                parcel.enforceInterface("com.huawei.multimedia.audioengine.IHwAudioKaraokeFeature");
                int a11 = a(parcel.readInt() != 0);
                parcel2.writeNoException();
                parcel2.writeInt(a11);
                return true;
            }
            if (i10 == 3) {
                parcel.enforceInterface("com.huawei.multimedia.audioengine.IHwAudioKaraokeFeature");
                int b4 = b();
                parcel2.writeNoException();
                parcel2.writeInt(b4);
                return true;
            }
            if (i10 == 4) {
                parcel.enforceInterface("com.huawei.multimedia.audioengine.IHwAudioKaraokeFeature");
                int a12 = a(parcel.readString(), parcel.readInt());
                parcel2.writeNoException();
                parcel2.writeInt(a12);
                return true;
            }
            if (i10 != 5) {
                if (i10 != 1598968902) {
                    return super.onTransact(i10, parcel, parcel2, i11);
                }
                parcel2.writeString("com.huawei.multimedia.audioengine.IHwAudioKaraokeFeature");
                return true;
            }
            parcel.enforceInterface("com.huawei.multimedia.audioengine.IHwAudioKaraokeFeature");
            a(parcel.readString());
            parcel2.writeNoException();
            return true;
        }

        /* renamed from: com.liteav.audio2.earmonitor.a.b$a$a, reason: collision with other inner class name */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
        public static class C0554a implements b {

            /* renamed from: a, reason: collision with root package name */
            private IBinder f36656a;

            public C0554a(IBinder iBinder) {
                this.f36656a = iBinder;
            }

            @Override // com.liteav.audio2.earmonitor.a.b
            public final boolean a() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.huawei.multimedia.audioengine.IHwAudioKaraokeFeature");
                    this.f36656a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.f36656a;
            }

            @Override // com.liteav.audio2.earmonitor.a.b
            public final int b() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.huawei.multimedia.audioengine.IHwAudioKaraokeFeature");
                    this.f36656a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.liteav.audio2.earmonitor.a.b
            public final int a(boolean z10) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.huawei.multimedia.audioengine.IHwAudioKaraokeFeature");
                    obtain.writeInt(z10 ? 1 : 0);
                    this.f36656a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.liteav.audio2.earmonitor.a.b
            public final int a(String str, int i10) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.huawei.multimedia.audioengine.IHwAudioKaraokeFeature");
                    obtain.writeString(str);
                    obtain.writeInt(i10);
                    this.f36656a.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.liteav.audio2.earmonitor.a.b
            public final void a(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.huawei.multimedia.audioengine.IHwAudioKaraokeFeature");
                    obtain.writeString(str);
                    this.f36656a.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}

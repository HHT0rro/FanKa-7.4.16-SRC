package com.ss.android.downloadlib.m.m;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.text.TextUtils;
import com.kuaishou.weapon.p0.t;
import com.ss.android.downloadlib.addownload.c;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public interface l extends IInterface {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static abstract class m extends Binder implements l {

        /* renamed from: m, reason: collision with root package name */
        private static String f38804m = "";

        /* renamed from: com.ss.android.downloadlib.m.m.l$m$m, reason: collision with other inner class name */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
        public static class C0584m implements l {

            /* renamed from: m, reason: collision with root package name */
            private IBinder f38805m;

            public C0584m(IBinder iBinder) {
                if (TextUtils.isEmpty(m.f38804m)) {
                    JSONObject w3 = c.w();
                    String unused = m.f38804m = com.ss.android.socialbase.appdownloader.n.ej.m(w3.optString("t"), w3.optString(t.f36222g));
                }
                this.f38805m = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f38805m;
            }

            @Override // com.ss.android.downloadlib.m.m.l
            public void m(dk dkVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(m.f38804m);
                    if (dkVar != null) {
                        obtain.writeInt(1);
                        dkVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f38805m.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            if (i10 == 1) {
                parcel.enforceInterface(f38804m);
                m(parcel.readInt() != 0 ? dk.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                return true;
            }
            if (i10 != 1598968902) {
                return super.onTransact(i10, parcel, parcel2, i11);
            }
            parcel2.writeString(f38804m);
            return true;
        }

        public static l m(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(f38804m);
            if (queryLocalInterface != null && (queryLocalInterface instanceof l)) {
                return (l) queryLocalInterface;
            }
            return new C0584m(iBinder);
        }
    }

    void m(dk dkVar) throws RemoteException;
}

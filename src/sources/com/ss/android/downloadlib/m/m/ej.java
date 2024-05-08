package com.ss.android.downloadlib.m.m;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.text.TextUtils;
import com.kuaishou.weapon.p0.t;
import com.ss.android.downloadlib.addownload.c;
import com.ss.android.downloadlib.m.m.l;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public interface ej extends IInterface {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static abstract class m extends Binder implements ej {

        /* renamed from: m, reason: collision with root package name */
        private static String f38802m = "";

        /* renamed from: com.ss.android.downloadlib.m.m.ej$m$m, reason: collision with other inner class name */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
        public static class C0583m implements ej {

            /* renamed from: m, reason: collision with root package name */
            private IBinder f38803m;

            public C0583m(IBinder iBinder) {
                if (TextUtils.isEmpty(m.f38802m)) {
                    JSONObject w3 = c.w();
                    String unused = m.f38802m = com.ss.android.socialbase.appdownloader.n.ej.m(w3.optString(t.f36226k), w3.optString(t.f36222g));
                }
                this.f38803m = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f38803m;
            }

            @Override // com.ss.android.downloadlib.m.m.ej
            public void m(dk dkVar, l lVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(m.f38802m);
                    if (dkVar != null) {
                        obtain.writeInt(1);
                        dkVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(lVar != null ? lVar.asBinder() : null);
                    this.f38803m.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            if (i10 == 1598968902) {
                parcel2.writeString(f38802m);
                return true;
            }
            if (i10 != 1) {
                return super.onTransact(i10, parcel, parcel2, i11);
            }
            parcel.enforceInterface(f38802m);
            m(parcel.readInt() != 0 ? dk.CREATOR.createFromParcel(parcel) : null, l.m.m(parcel.readStrongBinder()));
            parcel2.writeNoException();
            return true;
        }

        public static ej m(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(f38802m);
            if (queryLocalInterface != null && (queryLocalInterface instanceof ej)) {
                return (ej) queryLocalInterface;
            }
            return new C0583m(iBinder);
        }
    }

    void m(dk dkVar, l lVar) throws RemoteException;
}

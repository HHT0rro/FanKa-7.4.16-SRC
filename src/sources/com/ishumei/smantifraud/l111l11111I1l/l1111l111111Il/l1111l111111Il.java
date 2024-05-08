package com.ishumei.smantifraud.l111l11111I1l.l1111l111111Il;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Parcel;
import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class l1111l111111Il extends l111l1111lI1l {
    private final LinkedBlockingQueue<IBinder> l1111l111111Il = new LinkedBlockingQueue<>(1);
    private ServiceConnection l111l11111I1l = new ServiceConnection() { // from class: com.ishumei.smantifraud.l111l11111I1l.l1111l111111Il.l1111l111111Il.1
        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                l1111l111111Il.this.l1111l111111Il.put(iBinder);
            } catch (Exception unused) {
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
        }
    };
    private Context l111l11111lIl;

    public l1111l111111Il(Context context) {
        this.l111l11111lIl = context;
    }

    @Override // com.ishumei.smantifraud.l111l11111I1l.l1111l111111Il.l111l1111lI1l
    public final String l1111l111111Il() {
        Intent intent = new Intent();
        intent.setAction("com.asus.msa.action.ACCESS_DID");
        intent.setComponent(new ComponentName("com.asus.msa.SupplementaryDID", "com.asus.msa.SupplementaryDID.SupplementaryDIDService"));
        String str = "";
        if (this.l111l11111lIl.bindService(intent, this.l111l11111I1l, 1)) {
            try {
                IBinder take = this.l1111l111111Il.take();
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.asus.msa.SupplementaryDID.IDidAidlInterface");
                    take.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    str = obtain2.readString();
                    this.l111l11111lIl.unbindService(this.l111l11111I1l);
                } catch (Throwable unused) {
                }
                obtain.recycle();
                obtain2.recycle();
            } catch (Exception unused2) {
            }
        }
        return str;
    }
}

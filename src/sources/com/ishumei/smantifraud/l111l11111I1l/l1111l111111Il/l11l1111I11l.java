package com.ishumei.smantifraud.l111l11111I1l.l1111l111111Il;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Parcel;
import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class l11l1111I11l extends l111l1111lI1l {
    public final LinkedBlockingQueue<IBinder> l1111l111111Il = new LinkedBlockingQueue<>(1);
    private ServiceConnection l111l11111I1l = new ServiceConnection() { // from class: com.ishumei.smantifraud.l111l11111I1l.l1111l111111Il.l11l1111I11l.1
        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                l11l1111I11l.this.l1111l111111Il.put(iBinder);
            } catch (InterruptedException unused) {
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
        }
    };
    private Context l111l11111lIl;

    public l11l1111I11l(Context context) {
        this.l111l11111lIl = context;
    }

    @Override // com.ishumei.smantifraud.l111l11111I1l.l1111l111111Il.l111l1111lI1l
    public final String l1111l111111Il() {
        Context context;
        Intent intent = new Intent();
        intent.setClassName("com.samsung.android.deviceidservice", "com.samsung.android.deviceidservice.DeviceIdService");
        String str = "";
        if (!this.l111l11111lIl.bindService(intent, this.l111l11111I1l, 1)) {
            return "";
        }
        try {
            IBinder take = this.l1111l111111Il.take();
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.samsung.android.deviceidservice.IDeviceIdService");
                take.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                str = obtain2.readString();
                obtain2.recycle();
                obtain.recycle();
                context = this.l111l11111lIl;
            } catch (Throwable unused) {
                obtain2.recycle();
                obtain.recycle();
                context = this.l111l11111lIl;
            }
            context.unbindService(this.l111l11111I1l);
        } catch (InterruptedException unused2) {
        }
        return str;
    }
}

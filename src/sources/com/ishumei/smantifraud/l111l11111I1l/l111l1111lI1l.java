package com.ishumei.smantifraud.l111l11111I1l;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.ishumei.smantifraud.IService;
import com.ishumei.smantifraud.IServiceImp;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class l111l1111lI1l {
    private static boolean l1111l111111Il;
    private static boolean l111l11111I1l;
    private static boolean l111l11111Il;
    private static boolean l111l11111lIl;

    public static void l1111l111111Il(final Context context) {
        l1111l111111Il = false;
        try {
            l111l11111Il = context.bindService(new Intent(context, (Class<?>) IServiceImp.class), new ServiceConnection() { // from class: com.ishumei.smantifraud.l111l11111I1l.l111l1111lI1l.1
                @Override // android.content.ServiceConnection
                public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                    IService l1111l111111Il2 = IService.l1111l111111Il.l1111l111111Il(iBinder);
                    try {
                        boolean unused = l111l1111lI1l.l111l11111lIl = l1111l111111Il2.hasF();
                        boolean unused2 = l111l1111lI1l.l111l11111I1l = l1111l111111Il2.hasBI();
                        boolean unused3 = l111l1111lI1l.l1111l111111Il = l1111l111111Il2.hasMagiskMount();
                    } catch (Exception unused4) {
                    }
                    context.unbindService(this);
                }

                @Override // android.content.ServiceConnection
                public final void onServiceDisconnected(ComponentName componentName) {
                }
            }, 1);
        } catch (Throwable unused) {
            l111l11111Il = false;
        }
    }

    public static boolean l1111l111111Il() {
        return l1111l111111Il;
    }

    public static boolean l111l11111I1l() {
        return l111l11111I1l;
    }

    public static boolean l111l11111Il() {
        return l111l11111Il;
    }

    public static boolean l111l11111lIl() {
        return l111l11111lIl;
    }
}

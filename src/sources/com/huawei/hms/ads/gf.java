package com.huawei.hms.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.huawei.openalliance.ad.msgnotify.NotifyCallback;
import com.huawei.openalliance.ad.msgnotify.b;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class gf {
    private static final String Code = "LinkedAdStatusHandler";
    private static final int I = 0;
    private static final byte[] V = new byte[0];
    private static gf Z;
    private Context B;
    private BroadcastReceiver C;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class a extends BroadcastReceiver {
        private a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            try {
                if (gg.Code.equals(intent.getAction())) {
                    boolean booleanExtra = intent.getBooleanExtra(gg.I, false);
                    int intExtra = intent.getIntExtra(gg.Z, 0);
                    gl.V(gf.Code, "LinkedAdBroadcastReceiver playProgress " + intExtra);
                    gd gdVar = new gd();
                    gdVar.V(booleanExtra);
                    gdVar.Code(intExtra);
                    ge.Code(gdVar);
                }
            } catch (Throwable th) {
                gl.I(gf.Code, "LinkedAdBroadcastReceiver error: %s", th.getClass().getSimpleName());
            }
        }
    }

    private gf(Context context) {
        if (context != null) {
            this.B = context.getApplicationContext();
        }
    }

    public static gf Code(Context context) {
        return V(context);
    }

    private static synchronized gf V(Context context) {
        gf gfVar;
        synchronized (gf.class) {
            synchronized (V) {
                if (Z == null) {
                    Z = new gf(context);
                }
                gfVar = Z;
            }
        }
        return gfVar;
    }

    public void Code() {
        Code(new a());
    }

    public void Code(final BroadcastReceiver broadcastReceiver) {
        gl.Code(Code, "registerPpsReceiver ");
        if (this.C != null) {
            V();
        }
        com.huawei.openalliance.ad.utils.ba.Code(new Runnable() { // from class: com.huawei.hms.ads.gf.1
            @Override // java.lang.Runnable
            public void run() {
                IntentFilter intentFilter = new IntentFilter(gg.Code);
                intentFilter.addAction(gg.V);
                gf.this.C = broadcastReceiver;
                if (com.huawei.openalliance.ad.utils.v.B(gf.this.B)) {
                    gf.this.B.registerReceiver(gf.this.C, intentFilter, "com.huawei.permission.app.DOWNLOAD", null);
                } else {
                    b.Code(gf.this.B, com.huawei.openalliance.ad.constant.bf.I, new NotifyCallback() { // from class: com.huawei.hms.ads.gf.1.1
                        @Override // com.huawei.openalliance.ad.msgnotify.NotifyCallback
                        public void onMessageNotify(String str, Intent intent) {
                            if (gf.this.C != null) {
                                gf.this.C.onReceive(gf.this.B, intent);
                            }
                        }
                    });
                }
                gl.V(gf.Code, "registerPpsReceiver");
            }
        });
    }

    public void V() {
        if (this.C != null) {
            com.huawei.openalliance.ad.utils.ba.Code(new Runnable() { // from class: com.huawei.hms.ads.gf.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        gl.V(gf.Code, "unregisterPpsReceiver");
                        gf.this.B.unregisterReceiver(gf.this.C);
                    } finally {
                        try {
                        } finally {
                        }
                    }
                }
            });
        }
        b.Code(this.B, com.huawei.openalliance.ad.constant.bf.I);
    }
}

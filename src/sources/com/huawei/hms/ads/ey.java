package com.huawei.hms.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.huawei.openalliance.ad.msgnotify.NotifyCallback;
import com.huawei.openalliance.ad.msgnotify.b;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class ey {
    private static ey I;
    private static final byte[] V = new byte[0];
    private BroadcastReceiver B;
    private Context Z;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class a extends BroadcastReceiver {
        private a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            try {
                if ("com.huawei.hms.pps.action.PPS_SPLASH_INTERACT_CLOSE_CONFIG_CHANGED".equals(intent.getAction())) {
                    fr.Code(context).B(intent.getStringExtra("splash_interact_close_expiretime"));
                }
            } catch (Throwable th) {
                gl.I("SplashAdInteractConfigHandler", "SplashAdBroadcastReceiver error: %s", th.getClass().getSimpleName());
            }
            ey.I.V();
        }
    }

    private ey(Context context) {
        if (context != null) {
            this.Z = context.getApplicationContext();
        }
    }

    public static ey Code(Context context) {
        return V(context);
    }

    private static synchronized ey V(Context context) {
        ey eyVar;
        synchronized (ey.class) {
            synchronized (V) {
                if (I == null) {
                    I = new ey(context);
                }
                eyVar = I;
            }
        }
        return eyVar;
    }

    public void Code() {
        Code(new a());
    }

    public void Code(final BroadcastReceiver broadcastReceiver) {
        gl.Code("SplashAdInteractConfigHandler", "registerPpsReceiver ");
        if (this.B != null) {
            V();
        }
        com.huawei.openalliance.ad.utils.ba.Code(new Runnable() { // from class: com.huawei.hms.ads.ey.1
            @Override // java.lang.Runnable
            public void run() {
                IntentFilter intentFilter = new IntentFilter("com.huawei.hms.pps.action.PPS_SPLASH_INTERACT_CLOSE_CONFIG_CHANGED");
                ey.this.B = broadcastReceiver;
                if (com.huawei.openalliance.ad.utils.v.B(ey.this.Z)) {
                    ey.this.Z.registerReceiver(ey.this.B, intentFilter, "com.huawei.permission.app.DOWNLOAD", null);
                } else {
                    b.Code(ey.this.Z, com.huawei.openalliance.ad.constant.bf.Z, new NotifyCallback() { // from class: com.huawei.hms.ads.ey.1.1
                        @Override // com.huawei.openalliance.ad.msgnotify.NotifyCallback
                        public void onMessageNotify(String str, Intent intent) {
                            if (ey.this.B != null) {
                                ey.this.B.onReceive(ey.this.Z, intent);
                            }
                        }
                    });
                }
                gl.V("SplashAdInteractConfigHandler", "registerPpsReceiver");
            }
        });
    }

    public void V() {
        if (this.B != null) {
            com.huawei.openalliance.ad.utils.ba.Code(new Runnable() { // from class: com.huawei.hms.ads.ey.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        gl.V("SplashAdInteractConfigHandler", "unregisterPpsReceiver");
                        ey.this.Z.unregisterReceiver(ey.this.B);
                    } finally {
                        try {
                        } finally {
                        }
                    }
                }
            });
        }
    }
}

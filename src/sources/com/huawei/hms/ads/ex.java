package com.huawei.hms.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.msgnotify.NotifyCallback;
import com.huawei.openalliance.ad.msgnotify.b;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class ex {
    private static ex V;
    private static final byte[] Z = new byte[0];
    private BroadcastReceiver B;
    private Context I;

    /* renamed from: com.huawei.hms.ads.ex$1, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public class AnonymousClass1 implements Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            IntentFilter intentFilter = new IntentFilter("com.huawei.hms.pps.action.PPS_REWARD_STATUS_CHANGED");
            ex.this.B = new a(null);
            if (com.huawei.openalliance.ad.utils.v.B(ex.this.I)) {
                ex.this.I.registerReceiver(ex.this.B, intentFilter, "com.huawei.permission.app.DOWNLOAD", null);
            } else {
                b.Code(ex.this.I, com.huawei.openalliance.ad.constant.bf.Code, new NotifyCallback() { // from class: com.huawei.hms.ads.ex.1.1
                    @Override // com.huawei.openalliance.ad.msgnotify.NotifyCallback
                    public void onMessageNotify(String str, final Intent intent) {
                        com.huawei.openalliance.ad.utils.ba.Code(new Runnable() { // from class: com.huawei.hms.ads.ex.1.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (ex.this.B != null) {
                                    ex.this.B.onReceive(ex.this.I, intent);
                                }
                            }
                        });
                    }
                });
            }
            gl.V("RewardAdStatusHandler", "registerPPSReceiver");
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class a extends BroadcastReceiver {
        private a() {
        }

        public /* synthetic */ a(AnonymousClass1 anonymousClass1) {
            this();
        }

        private boolean Code(int i10, com.huawei.openalliance.ad.inter.listeners.g gVar) {
            if (gVar == null) {
                return false;
            }
            if (8 == i10) {
                gVar.S();
                return true;
            }
            if (9 != i10) {
                return false;
            }
            gVar.C();
            return true;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            StringBuilder sb2;
            gl.V("RewardAdStatusHandler", "onReceive:" + intent.getAction());
            if ("com.huawei.hms.pps.action.PPS_REWARD_STATUS_CHANGED".equals(intent.getAction())) {
                try {
                    com.huawei.openalliance.ad.inter.data.i Code = ev.Code();
                    if (Code != null && (Code instanceof com.huawei.openalliance.ad.inter.data.s)) {
                        com.huawei.openalliance.ad.inter.data.s sVar = (com.huawei.openalliance.ad.inter.data.s) Code;
                        com.huawei.openalliance.ad.inter.listeners.f Q = sVar.Q();
                        com.huawei.openalliance.ad.inter.listeners.g I = sVar.I();
                        int intExtra = intent.getIntExtra("reward_ad_status", -1);
                        String stringExtra = intent.getStringExtra(com.huawei.openalliance.ad.constant.ax.f32262e);
                        gl.V("RewardAdStatusHandler", "status:" + intExtra);
                        if (Code(intExtra, I)) {
                            return;
                        }
                        if (Q == null) {
                            gl.I("RewardAdStatusHandler", "there is no status listener");
                            return;
                        }
                        switch (intExtra) {
                            case 1:
                                Q.Code();
                                sVar.V(true);
                                return;
                            case 2:
                                Q.V();
                                return;
                            case 3:
                                Q.I();
                                return;
                            case 4:
                                Q.Z();
                                return;
                            case 5:
                                if (sVar.C()) {
                                    return;
                                }
                                Q.B();
                                sVar.Code(true);
                                AdContentData l10 = sVar.l();
                                l10.V(stringExtra);
                                kv.Code(context, l10, sVar.E(), sVar.G(), "");
                                return;
                            case 6:
                                Q.Code(intent.getIntExtra("reward_ad_error", -1), intent.getIntExtra("reward_ad_extra", -1));
                                return;
                            case 7:
                                if (ex.V != null) {
                                    ex.V.V();
                                    return;
                                }
                                return;
                            default:
                                return;
                        }
                    }
                    gl.I("RewardAdStatusHandler", "can not get reward");
                } catch (Exception e2) {
                    e = e2;
                    sb2 = new StringBuilder();
                    sb2.append("handler reward status changed error,");
                    sb2.append(e.getClass().getSimpleName());
                    gl.Z("RewardAdStatusHandler", sb2.toString());
                } catch (Throwable th) {
                    e = th;
                    sb2 = new StringBuilder();
                    sb2.append("handler reward status changed error,");
                    sb2.append(e.getClass().getSimpleName());
                    gl.Z("RewardAdStatusHandler", sb2.toString());
                }
            }
        }
    }

    private ex(Context context) {
        this.I = context.getApplicationContext();
    }

    public static ex Code(Context context) {
        return V(context);
    }

    private static ex V(Context context) {
        ex exVar;
        synchronized (Z) {
            if (V == null) {
                V = new ex(context);
            }
            exVar = V;
        }
        return exVar;
    }

    public void Code() {
        if (this.B != null) {
            V();
        }
        com.huawei.openalliance.ad.utils.ba.Code(new AnonymousClass1());
    }

    public void V() {
        if (this.B != null) {
            com.huawei.openalliance.ad.utils.ba.Code(new Runnable() { // from class: com.huawei.hms.ads.ex.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        gl.V("RewardAdStatusHandler", "unregisterPPSReceiver");
                        ex.this.I.unregisterReceiver(ex.this.B);
                    } finally {
                        try {
                        } finally {
                        }
                    }
                }
            });
        }
        b.Code(this.I, com.huawei.openalliance.ad.constant.bf.Code);
    }
}

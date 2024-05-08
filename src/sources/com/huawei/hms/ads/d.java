package com.huawei.hms.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.huawei.hms.ads.inter.data.IInterstitialAd;
import com.huawei.hms.ads.inter.listeners.IInterstitialAdStatusListener;
import com.huawei.hms.ads.reward.RewardAdListener;
import com.huawei.openalliance.ad.msgnotify.NotifyCallback;
import com.huawei.openalliance.ad.msgnotify.b;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class d {
    private static final byte[] V = new byte[0];
    private static d Z;
    private Context B;
    private BroadcastReceiver C;

    /* renamed from: com.huawei.hms.ads.d$1, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public class AnonymousClass1 implements Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            IntentFilter intentFilter = new IntentFilter("com.huawei.hms.pps.action.PPS_INTERSTITIAL_STATUS_CHANGED");
            d.this.C = new a(null);
            if (com.huawei.openalliance.ad.utils.v.B(d.this.B)) {
                d.this.B.registerReceiver(d.this.C, intentFilter, "com.huawei.permission.app.DOWNLOAD", null);
            } else {
                b.Code(d.this.B, com.huawei.openalliance.ad.constant.bf.V, new NotifyCallback() { // from class: com.huawei.hms.ads.d.1.1
                    @Override // com.huawei.openalliance.ad.msgnotify.NotifyCallback
                    public void onMessageNotify(String str, final Intent intent) {
                        com.huawei.openalliance.ad.utils.ba.Code(new Runnable() { // from class: com.huawei.hms.ads.d.1.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (d.this.C != null) {
                                    d.this.C.onReceive(d.this.B, intent);
                                }
                            }
                        });
                    }
                });
            }
            gl.V("InterstitialAdStatusHandler", "registerPpsReceiver");
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class a extends BroadcastReceiver {
        private a() {
        }

        public /* synthetic */ a(AnonymousClass1 anonymousClass1) {
            this();
        }

        private boolean Code(int i10, RewardAdListener rewardAdListener) {
            if (rewardAdListener == null) {
                return false;
            }
            if (i10 == 8) {
                rewardAdListener.onRewardAdLeftApp();
                return false;
            }
            if (i10 != 9) {
                return false;
            }
            rewardAdListener.onRewardAdStarted();
            return true;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            StringBuilder sb2;
            gl.V("InterstitialAdStatusHandler", "onReceive:" + intent.getAction());
            if ("com.huawei.hms.pps.action.PPS_INTERSTITIAL_STATUS_CHANGED".equals(intent.getAction())) {
                try {
                    IInterstitialAd Code = e.Code();
                    if (!(Code instanceof com.huawei.hms.ads.inter.data.a)) {
                        gl.I("InterstitialAdStatusHandler", "can not get interstitial ad.");
                        return;
                    }
                    com.huawei.hms.ads.inter.data.a aVar = (com.huawei.hms.ads.inter.data.a) Code;
                    IInterstitialAdStatusListener I = aVar.I();
                    RewardAdListener Code2 = aVar.Code();
                    int intExtra = intent.getIntExtra("interstitial_ad_status", -1);
                    gl.V("InterstitialAdStatusHandler", "status:" + intExtra);
                    if (Code(intExtra, Code2)) {
                        return;
                    }
                    if (I == null) {
                        gl.I("InterstitialAdStatusHandler", "there is no status listener");
                        return;
                    }
                    switch (intExtra) {
                        case 1:
                            I.onAdShown();
                            aVar.V(true);
                            return;
                        case 2:
                            I.onAdClicked();
                            return;
                        case 3:
                            I.onAdCompleted();
                            return;
                        case 4:
                            I.onAdClosed();
                            return;
                        case 5:
                            if (aVar.C()) {
                                return;
                            }
                            I.onRewarded();
                            aVar.Code(true);
                            kv.Code(context, aVar.l(), aVar.E(), aVar.G(), "");
                            return;
                        case 6:
                            I.onAdError(intent.getIntExtra("interstitial_ad_error", -1), intent.getIntExtra("interstitial_ad_extra", -1));
                            return;
                        case 7:
                            if (d.Z != null) {
                                d.Z.I();
                                return;
                            }
                            return;
                        case 8:
                            I.onLeftApp();
                            return;
                        default:
                            return;
                    }
                } catch (Exception e2) {
                    e = e2;
                    sb2 = new StringBuilder();
                    sb2.append("handler interstitial status changed error,");
                    sb2.append(e.getClass().getSimpleName());
                    gl.Z("InterstitialAdStatusHandler", sb2.toString());
                } catch (Throwable th) {
                    e = th;
                    sb2 = new StringBuilder();
                    sb2.append("handler interstitial status changed error,");
                    sb2.append(e.getClass().getSimpleName());
                    gl.Z("InterstitialAdStatusHandler", sb2.toString());
                }
            }
        }
    }

    private d(Context context) {
        if (context != null) {
            this.B = context.getApplicationContext();
        }
    }

    public static d Code(Context context) {
        return V(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I() {
        if (this.C != null) {
            com.huawei.openalliance.ad.utils.ba.Code(new Runnable() { // from class: com.huawei.hms.ads.d.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        gl.V("InterstitialAdStatusHandler", "unregisterPpsReceiver");
                        d.this.B.unregisterReceiver(d.this.C);
                    } finally {
                        try {
                        } finally {
                        }
                    }
                }
            });
        }
        b.Code(this.B, com.huawei.openalliance.ad.constant.bf.V);
    }

    private static synchronized d V(Context context) {
        d dVar;
        synchronized (d.class) {
            synchronized (V) {
                if (Z == null) {
                    Z = new d(context);
                }
                dVar = Z;
            }
        }
        return dVar;
    }

    public void Code() {
        if (this.C != null) {
            I();
        }
        com.huawei.openalliance.ad.utils.ba.Code(new AnonymousClass1());
    }
}

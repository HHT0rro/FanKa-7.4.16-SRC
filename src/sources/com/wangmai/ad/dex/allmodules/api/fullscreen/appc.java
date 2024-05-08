package com.wangmai.ad.dex.allmodules.api.fullscreen;

import android.content.Context;
import android.content.Intent;
import appa.appa.appf.appd;
import com.wangmai.ad.dex.allmodules.appf.appe;
import com.wangmai.ad.dex.allmodules.bean.ApiBean;
import com.wangmai.appsdkdex.WMDexAdHelper;
import com.wangmai.appsdkdex.WMLandscapeActivity;
import com.wangmai.appsdkdex.WMPortraitActivity;
import com.wangmai.common.Ilistener.XAdFullScreenVideoListener;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
/* compiled from: WMApiFullScreenVideoNew.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
public class appc {

    /* renamed from: appa, reason: collision with root package name */
    private com.wangmai.ad.dex.allmodules.api.fullscreen.appb f46592appa;
    private com.wangmai.ad.dex.allmodules.api.fullscreen.appb appb;
    private WMFullScreenViewGroup appc;
    private boolean appd = true;
    private int appe;
    private int appf;
    private int appg;
    private int apph;
    private Context appi;

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* compiled from: WMApiFullScreenVideoNew.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    class appa implements com.wangmai.ad.dex.allmodules.appf.appc {

        /* renamed from: appa, reason: collision with root package name */
        final /* synthetic */ XAdFullScreenVideoListener f46593appa;
        final /* synthetic */ int appb;
        final /* synthetic */ int appc;
        final /* synthetic */ int appd;

        appa(XAdFullScreenVideoListener xAdFullScreenVideoListener, int i10, int i11, int i12) {
            this.f46593appa = xAdFullScreenVideoListener;
            this.appb = i10;
            this.appc = i11;
            this.appd = i12;
        }

        @Override // com.wangmai.ad.dex.allmodules.appf.appc
        public void appa(Context context, int i10, int i11) {
            Class cls;
            try {
                appc.this.appe = i10;
                appc.this.appf = i11;
                if (appc.this.appd) {
                    appc.this.appd = false;
                    if (appc.this.appc != null) {
                        try {
                            appd.appa("WMApiFullScreenVideoNew", "Api fullScreen Activity: orientation" + appc.this.appe + "--" + appc.this.appf);
                            Intent intent = new Intent();
                            if (appc.this.appe == 2 && appc.this.appf == 2) {
                                cls = WMPortraitActivity.class;
                            } else {
                                appd.appa("WMApiFullScreenVideoNew", "Api fullScreen 横屏: ");
                                cls = WMLandscapeActivity.class;
                            }
                            WMDexAdHelper.startActivty(appc.this.appi, "wmFullViewGroup", appc.this.appc, cls, intent);
                        } catch (Throwable th) {
                            appd.appe("WMApiFullScreenVideoNew", th.toString());
                            appc.this.f46592appa = new com.wangmai.ad.dex.allmodules.api.fullscreen.appb(context, appc.this.appc, false, this.f46593appa);
                            appc.this.f46592appa.setCancelable(false);
                            appc.this.f46592appa.setCanceledOnTouchOutside(false);
                            if (appc.this.f46592appa != null) {
                                appc.this.f46592appa.show();
                            }
                        }
                    }
                    appd.appa("WMApiFullScreenVideoNew", "Api fullScreen onAdShow");
                    this.f46593appa.onExposure();
                }
            } catch (Throwable th2) {
                appd.appb("WMApiFullScreenVideoNew", "Api fullScreen onAdShow:" + th2.toString());
                this.f46593appa.onNoAd("广告展示失败，请重新加载广告");
            }
        }

        @Override // com.wangmai.ad.dex.allmodules.appf.appc
        public void appb(String str) {
            appd.appa("WMApiFullScreenVideoNew", "Api fullScreen onRewardVertify");
        }

        @Override // com.wangmai.ad.dex.allmodules.appf.appc
        public void onAdClose() {
            appd.appa("WMApiFullScreenVideoNew", "Api fullScreen onAdClose");
            if (appc.this.f46592appa != null) {
                appc.this.f46592appa.dismiss();
            }
            appc.this.appa("wmFullViewGroup");
            this.f46593appa.onAdClose();
        }

        @Override // com.wangmai.ad.dex.allmodules.appf.appc
        public void onAdLoad() {
            appd.appa("WMApiFullScreenVideoNew", "Api fullScreen onAdLoad");
            appc appcVar = appc.this;
            appcVar.appa(appcVar.appc.getDspBidPrice());
            appc appcVar2 = appc.this;
            appcVar2.appb(appcVar2.appc.getMediaBidPrice());
            this.f46593appa.onAdRequest();
            this.f46593appa.onAdLoad();
        }

        @Override // com.wangmai.ad.dex.allmodules.appf.appc
        public void appb(String str, String str2, String str3, String str4, String str5, ApiBean apiBean) {
            appd.appa("WMApiFullScreenVideoNew", "Api fullScreen onSkippedVideo");
            this.f46593appa.onSkippedVideo();
            if (appc.this.f46592appa != null) {
                appc.this.f46592appa.dismiss();
            }
            appc.this.appa("wmFullViewGroup");
            appc.this.appa(str, str2, str3, str4, str5, apiBean, this.appb, this.appc, this.f46593appa, this.appd, true);
        }

        @Override // com.wangmai.ad.dex.allmodules.appf.appc
        public void appa() {
            appd.appa("WMApiFullScreenVideoNew", "Api fullScreen onAdBarClick");
            this.f46593appa.onClick();
        }

        @Override // com.wangmai.ad.dex.allmodules.appf.appc
        public void appa(String str, String str2, String str3, String str4, String str5, ApiBean apiBean) {
            appd.appa("WMApiFullScreenVideoNew", "Api fullScreen onVideoCompleted");
            this.f46593appa.onVideoComplete();
            if (appc.this.f46592appa != null) {
                appc.this.f46592appa.dismiss();
            }
            appc.this.appa("wmFullViewGroup");
            appc.this.appa(str, str2, str3, str4, str5, apiBean, this.appb, this.appc, this.f46593appa, this.appd, false);
        }

        @Override // com.wangmai.ad.dex.allmodules.appf.appc
        public void appa(String str) {
            appd.appb("WMApiFullScreenVideoNew", "Api fullScreen onAdError：" + str);
            if (appc.this.f46592appa != null) {
                appc.this.f46592appa.dismiss();
            }
            appc.this.appa("wmFullViewGroup");
            this.f46593appa.onNoAd("onAdError:" + str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* compiled from: WMApiFullScreenVideoNew.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public class appb implements appe {
        appb() {
        }

        @Override // com.wangmai.ad.dex.allmodules.appf.appe
        public void appa() {
            if (appc.this.appb != null) {
                appc.this.appb.dismiss();
            }
            appc.this.appa("WMApiLoadingRewardVideo");
        }
    }

    public appc(Context context, String str, String str2, int i10, int i11, int i12, XAdFullScreenVideoListener xAdFullScreenVideoListener) {
        this.appc = null;
        this.appi = context;
        this.appc = new WMFullScreenViewGroup(this.appi, str, str2, i11, i12, xAdFullScreenVideoListener, new appa(xAdFullScreenVideoListener, i11, i12, i10));
    }

    public int appb() {
        return this.apph;
    }

    public void appb(int i10) {
        this.apph = i10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void appa(String str, String str2, String str3, String str4, String str5, ApiBean apiBean, int i10, int i11, XAdFullScreenVideoListener xAdFullScreenVideoListener, int i12, boolean z10) {
        WMFullSceenLadingViewGroup wMFullSceenLadingViewGroup;
        try {
            WMFullSceenLadingViewGroup wMFullSceenLadingViewGroup2 = new WMFullSceenLadingViewGroup(this.appi, str, str2, str3, str4, str5, apiBean, xAdFullScreenVideoListener, i12, i10, i11, new appb(), z10);
            try {
                appd.appa("WMApiFullScreenVideoNew", "Api fullScreen start FullScreenActivity");
                wMFullSceenLadingViewGroup = wMFullSceenLadingViewGroup2;
            } catch (Throwable th) {
                th = th;
                wMFullSceenLadingViewGroup = wMFullSceenLadingViewGroup2;
            }
            try {
                WMDexAdHelper.startActivty(this.appi, "WMApiLoadingRewardVideo", wMFullSceenLadingViewGroup, WMPortraitActivity.class, new Intent());
            } catch (Throwable th2) {
                th = th2;
                appd.appe("WMApiFullScreenVideoNew", th.toString());
                this.appb = new com.wangmai.ad.dex.allmodules.api.fullscreen.appb(this.appi, wMFullSceenLadingViewGroup, true, xAdFullScreenVideoListener);
                this.f46592appa.setCancelable(true);
                this.f46592appa.setCanceledOnTouchOutside(true);
                if (this.appb != null) {
                    this.appb.show();
                }
            }
        } catch (Throwable th3) {
            appd.appe("WMApiFullScreenVideoNew", "Api fullScreen startFullScreenLoadingAct:" + th3.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void appa(String str) {
        try {
            if (WMDexAdHelper.getActivity(str) != null) {
                WMDexAdHelper.getActivity(str).finish();
            }
        } catch (Throwable th) {
            appd.appe("WMApiFullScreenVideoNew", "Api fullScreen finishRewardFullAct:" + th.toString());
        }
    }

    public void appa(Context context) {
        this.appc.appa(context);
    }

    public int appa() {
        return this.appg;
    }

    public void appa(int i10) {
        this.appg = i10;
    }
}

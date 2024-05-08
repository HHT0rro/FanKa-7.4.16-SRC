package com.wangmai.ad.dex.allmodules.api.reward;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import appa.appa.appd.appf;
import com.wangmai.ad.dex.allmodules.appf.appe;
import com.wangmai.ad.dex.allmodules.bean.ApiBean;
import com.wangmai.ad.dex.allmodules.utils.appa;
import com.wangmai.ad.dex.allmodules.utils.apps;
import com.wangmai.ad.dex.allmodules.utils.appu;
import com.wangmai.ad.dex.allmodules.utils.appv;
import com.wangmai.appsdkdex.WMDexAdHelper;
import com.wangmai.appsdkdex.WMLandscapeActivity;
import com.wangmai.appsdkdex.WMPortraitActivity;
import com.wangmai.common.Ilistener.XAdRewardVideoListener;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
/* compiled from: WMApiRewardVideoNew.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
public class appb {

    /* renamed from: appa, reason: collision with root package name */
    private com.wangmai.ad.dex.allmodules.api.reward.appc f46643appa;
    private WMRewardViewGroup appb;
    private appf appc;
    private boolean appd = true;
    private ApiBean appe;
    private int appf;
    private int appg;
    private apps apph;
    private apps appi;
    private int appj;
    private int appk;
    private int appl;
    private long appm;
    private List<String> appn;
    private String appo;
    private int appp;
    private String appq;
    private Context appr;
    private String apps;
    private appu appt;
    private appv appu;
    private appa.appc appv;
    private appa.appc appw;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* compiled from: WMApiRewardVideoNew.java */
    /* renamed from: com.wangmai.ad.dex.allmodules.api.reward.appb$appb, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public class C0668appb implements appe {
        C0668appb() {
        }

        @Override // com.wangmai.ad.dex.allmodules.appf.appe
        public void appa() {
            if (appb.this.appi != null) {
                appb.this.appi.dismiss();
            }
            appb.this.appc("WMApiLoadingRewardVideo");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* compiled from: WMApiRewardVideoNew.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public class appc implements appa.appc {
        appc() {
        }

        @Override // com.wangmai.ad.dex.allmodules.utils.appa.appc
        public void appa(int i10, float f10, float f11, float f12, float f13) {
            try {
                if (appb.this.appb != null && !appb.this.appb.f46629k) {
                    appb.this.appb.getLocationOnScreen(new int[2]);
                    appb.this.appb.appb = r8[0] + (appb.this.appb.getWidth() / 2);
                    appb.this.appb.appc = r8[1] + (appb.this.appb.getHeight() / 2);
                    appb.this.appb.appd = appb.this.appb.appb;
                    appb.this.appb.appe = appb.this.appb.appc;
                    appb.this.appt.appf();
                    appb.this.appb.appa(true, com.wangmai.ad.dex.allmodules.utils.appf.appm);
                } else {
                    appa.appa.appf.appd.appe("WMApiRewardVideoNew", "未触发模拟点击逻辑（已点击限制）");
                }
            } catch (Throwable th) {
                appa.appa.appf.appd.appe("WMApiRewardVideoNew", "Api RewardVideo 模拟点击失败：" + ((Object) th));
                com.wangmai.ad.dex.allmodules.utils.appf.appa(appb.this.appr, appb.this.apps, "Api RewardVideo 模拟点击失败：" + Log.getStackTraceString(th));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* compiled from: WMApiRewardVideoNew.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public class appd implements appa.appc {
        appd() {
        }

        @Override // com.wangmai.ad.dex.allmodules.utils.appa.appc
        public void appa(int i10, float f10, float f11, float f12, float f13) {
            try {
                if (appb.this.appb != null && !appb.this.appb.f46629k) {
                    appb.this.appb.appb = f10;
                    appb.this.appb.appc = f11;
                    appb.this.appb.appd = f12;
                    appb.this.appb.appe = f13;
                    appb.this.appu.apph();
                    appb.this.appb.appa(true, com.wangmai.ad.dex.allmodules.utils.appf.appn);
                } else {
                    appa.appa.appf.appd.appe("WMApiRewardVideoNew", "未触发滑动点击逻辑（已点击限制）");
                }
            } catch (Throwable th) {
                appa.appa.appf.appd.appe("WMApiRewardVideoNew", "Api RewardVideo 滑动点击失败：" + ((Object) th));
                com.wangmai.ad.dex.allmodules.utils.appf.appa(appb.this.appr, appb.this.apps, "Api RewardVideo 滑动点击失败：" + Log.getStackTraceString(th));
            }
        }
    }

    public appb(Context context, String str, String str2, String str3, int i10, int i11, int i12, appf appfVar) {
        this.appr = context;
        this.apps = str;
        this.appc = appfVar;
        this.f46643appa = new com.wangmai.ad.dex.allmodules.api.reward.appc(this.appr, str2, str3, new appa(appfVar, i11, i12, i10));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void appc(String str) {
        try {
            if (WMDexAdHelper.getActivity(str) != null) {
                WMDexAdHelper.getActivity(str).finish();
            }
            if (this.appt != null) {
                this.appt.appa(this.appv);
                this.appt = null;
            }
            if (this.appu != null) {
                this.appu.appa(this.appw);
                this.appu = null;
            }
        } catch (Throwable th) {
            appa.appa.appf.appd.appe("WMApiRewardVideoNew", "Api Reward finishRewardAct:" + th.toString());
        }
    }

    public int appd() {
        return this.appj;
    }

    public List<String> appe() {
        return this.appn;
    }

    public int appf() {
        return this.appk;
    }

    public int appg() {
        return this.appp;
    }

    public String apph() {
        return this.appq;
    }

    public void appb(int i10) {
        this.appj = i10;
    }

    public void appd(int i10) {
        this.appp = i10;
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* compiled from: WMApiRewardVideoNew.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    class appa implements com.wangmai.ad.dex.allmodules.appf.appf {

        /* renamed from: appa, reason: collision with root package name */
        final /* synthetic */ appf f46644appa;
        final /* synthetic */ int appb;
        final /* synthetic */ int appc;
        final /* synthetic */ int appd;

        appa(appf appfVar, int i10, int i11, int i12) {
            this.f46644appa = appfVar;
            this.appb = i10;
            this.appc = i11;
            this.appd = i12;
        }

        @Override // com.wangmai.ad.dex.allmodules.appf.appf
        public void appa(ApiBean apiBean) {
            appb.this.appe = apiBean;
            if (this.f46644appa != null) {
                appb appbVar = appb.this;
                appbVar.appb(appbVar.f46643appa.appd());
                appb appbVar2 = appb.this;
                appbVar2.appc(appbVar2.f46643appa.appf());
                appb appbVar3 = appb.this;
                appbVar3.appa(appbVar3.f46643appa.appa());
                appb appbVar4 = appb.this;
                appbVar4.appa(appbVar4.f46643appa.appb());
                appb appbVar5 = appb.this;
                appbVar5.appa(appbVar5.f46643appa.appc());
                appb appbVar6 = appb.this;
                appbVar6.appa(appbVar6.f46643appa.appe());
                appb appbVar7 = appb.this;
                appbVar7.appd(appbVar7.f46643appa.appg());
                appb appbVar8 = appb.this;
                appbVar8.appb(appbVar8.f46643appa.apph());
                this.f46644appa.onAdRequest();
                this.f46644appa.onAdLoad();
            }
        }

        @Override // com.wangmai.ad.dex.allmodules.appf.appf
        public void appb() {
            if (appb.this.apph != null) {
                appb.this.apph.dismiss();
            }
            appf appfVar = this.f46644appa;
            if (appfVar != null) {
                appfVar.onNoAd("广告加载失败");
            }
            appb.this.appc("WMApiRewardVideoNew");
        }

        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
        /* compiled from: WMApiRewardVideoNew.java */
        /* renamed from: com.wangmai.ad.dex.allmodules.api.reward.appb$appa$appa, reason: collision with other inner class name */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
        class C0667appa implements com.wangmai.ad.dex.allmodules.appf.appd {
            C0667appa() {
            }

            @Override // com.wangmai.ad.dex.allmodules.appf.appd
            public void appa(Context context) {
                appa.appa.appf.appd.appa("WMApiRewardVideoNew", "Api Reward p onAdShow WMRewardViewGroup onAdShow");
                appa appaVar = appa.this;
                if (appaVar.f46644appa != null) {
                    appb appbVar = appb.this;
                    appbVar.appa(appbVar.appe.getOptimization());
                    appa.this.f46644appa.onExposure();
                    appa.this.f46644appa.appa();
                }
            }

            @Override // com.wangmai.ad.dex.allmodules.appf.appd
            public void appb() {
                appa.appa.appf.appd.appe("WMApiRewardVideoNew", "Api Reward p onAdShow requestNext");
                if (appb.this.apph != null) {
                    appb.this.apph.dismiss();
                }
                appb.this.appc("WMApiRewardVideoNew");
            }

            @Override // com.wangmai.ad.dex.allmodules.appf.appd
            public void onAdClose() {
                appa.appa.appf.appd.appa("WMApiRewardVideoNew", "Api Reward p onAdShow WMRewardViewGroup onAdClose");
                if (appb.this.apph != null) {
                    appb.this.apph.dismiss();
                }
                appb.this.appc("WMApiRewardVideoNew");
                appf appfVar = appa.this.f46644appa;
                if (appfVar != null) {
                    appfVar.onAdClose();
                }
            }

            @Override // com.wangmai.ad.dex.allmodules.appf.appd
            public void appa() {
                appa.appa.appf.appd.appa("WMApiRewardVideoNew", "Api Reward p onAdShow WMRewardViewGroup onAdBarClick");
                appf appfVar = appa.this.f46644appa;
                if (appfVar != null) {
                    appfVar.onClick();
                }
            }

            @Override // com.wangmai.ad.dex.allmodules.appf.appd
            public void appa(String str, String str2, String str3, String str4, String str5, ApiBean apiBean) {
                appa.appa.appf.appd.appa("WMApiRewardVideoNew", "Api Reward ponAdShow  WMRewardViewGroup onVideoCompleted");
                appf appfVar = appa.this.f46644appa;
                if (appfVar != null) {
                    appfVar.onVideoComplete();
                }
                if (appb.this.apph != null) {
                    appb.this.apph.dismiss();
                }
                appb.this.appc("WMApiRewardVideoNew");
                appa appaVar = appa.this;
                appb.this.appa(str, str2, str3, str4, str5, appaVar.appb, appaVar.appc, apiBean, appaVar.f46644appa, appaVar.appd);
            }

            @Override // com.wangmai.ad.dex.allmodules.appf.appd
            public void appa(boolean z10, Bundle bundle) {
                appa.appa.appf.appd.appa("WMApiRewardVideoNew", "Api Reward p onAdShow WMRewardViewGroup onRewardVertify");
                appf appfVar = appa.this.f46644appa;
                if (appfVar != null) {
                    appfVar.onRewarded(z10, bundle);
                }
            }

            @Override // com.wangmai.ad.dex.allmodules.appf.appd
            public void appa(String str) {
                appa.appa.appf.appd.appb("WMApiRewardVideoNew", "Api Reward p onAdShow error:" + str);
                if (appb.this.apph != null) {
                    appb.this.apph.dismiss();
                }
                appb.this.appc("WMApiRewardVideoNew");
            }
        }

        @Override // com.wangmai.ad.dex.allmodules.appf.appf
        public void appa(Context context, int i10, int i11) {
            Class cls;
            appb.this.appf = i10;
            appb.this.appg = i11;
            appb appbVar = appb.this;
            appbVar.appb = new WMRewardViewGroup(appbVar.appr, appb.this.appe, this.appb, this.appc, new C0667appa());
            try {
                if (appb.this.appd) {
                    appb.this.appd = false;
                    if (appb.this.appb != null) {
                        try {
                            if (appb.this.appf == 2 && appb.this.appg == 2) {
                                appa.appa.appf.appd.appa("WMApiRewardVideoNew", "Api Reward p onAdShow 竖屏");
                                cls = WMPortraitActivity.class;
                            } else {
                                appa.appa.appf.appd.appa("WMApiRewardVideoNew", "Api Reward p onAdShow 横屏: ");
                                cls = WMLandscapeActivity.class;
                            }
                            WMDexAdHelper.startActivty(context, "WMApiRewardVideoNew", appb.this.appb, cls, new Intent());
                        } catch (Throwable th) {
                            appa.appa.appf.appd.appe("WMApiRewardVideoNew", "Api Reward p onAdShow:" + th.toString());
                            appb.this.apph = new apps(context, appb.this.appb, false, this.f46644appa);
                            appb.this.apph.setCancelable(false);
                            appb.this.apph.setCanceledOnTouchOutside(false);
                            if (appb.this.apph != null) {
                                appb.this.apph.show();
                            }
                        }
                    }
                }
            } catch (Throwable th2) {
                appa.appa.appf.appd.appe("WMApiRewardVideoNew", "Api Reward p onAdShow error:" + th2.toString());
                appf appfVar = this.f46644appa;
                if (appfVar != null) {
                    appfVar.appa("展示失败:" + th2.toString());
                }
            }
        }
    }

    public long appb() {
        return this.appm;
    }

    public void appb(String str) {
        this.appq = str;
    }

    public void appa(Context context) {
        try {
            if (this.f46643appa != null) {
                if (this.appc != null) {
                    this.appc.appa(appa.appa.appb.appa.READY);
                }
                this.f46643appa.appa(context);
            } else if (this.appc != null) {
                this.appc.appa(appa.appa.appb.appa.NOT_READY);
                this.appc.appa("展示失败(RewardViewHelper为空)");
            }
        } catch (Throwable th) {
            appa.appa.appf.appd.appb("WMApiRewardVideoNew", "Api Reward show error:" + th.toString());
            appf appfVar = this.appc;
            if (appfVar != null) {
                appfVar.appa("展示失败:" + th.toString());
            }
        }
    }

    public void appc(int i10) {
        this.appk = i10;
    }

    public String appc() {
        return this.appo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void appa(String str, String str2, String str3, String str4, String str5, int i10, int i11, ApiBean apiBean, XAdRewardVideoListener xAdRewardVideoListener, int i12) {
        try {
            WMRewardLadingViewGroup wMRewardLadingViewGroup = new WMRewardLadingViewGroup(this.appr, str, str2, str3, str4, str5, apiBean, i10, i11, xAdRewardVideoListener, i12, new C0668appb());
            try {
                WMDexAdHelper.startActivty(this.appr, "WMApiLoadingRewardVideo", wMRewardLadingViewGroup, WMPortraitActivity.class, new Intent());
            } catch (Throwable th) {
                appa.appa.appf.appd.appe("WMApiRewardVideoNew", "Api Reward startRewardLoadingAct build intent:" + th.toString());
                this.appi = new apps(this.appr, wMRewardLadingViewGroup, true, xAdRewardVideoListener);
                if (this.apph != null) {
                    this.apph.setCancelable(true);
                    this.apph.setCanceledOnTouchOutside(true);
                }
                if (this.appi != null) {
                    this.appi.show();
                }
            }
        } catch (Throwable th2) {
            appa.appa.appf.appd.appe("WMApiRewardVideoNew", "Api Reward startRewardLoadingAct:" + th2.toString());
        }
    }

    void appa(ApiBean.Optimization optimization) {
        try {
            if (optimization != null) {
                this.appt = new appu(this.appr, this.apps, optimization, false);
                this.appv = new appc();
                this.appt.appb(this.appv);
                this.appu = new appv(this.appr, this.apps, optimization, false);
                this.appw = new appd();
                this.appu.appa(this.appb, this.appw);
            } else {
                appa.appa.appf.appd.appe("WMApiRewardVideoNew", "模电误点未开启【优化配置为空或广告已开启互动】");
            }
        } catch (Throwable th) {
            appa.appa.appf.appd.appe("WMApiRewardVideoNew", "registerVirtualClick error:" + th.toString());
        }
    }

    public int appa() {
        return this.appl;
    }

    public void appa(int i10) {
        this.appl = i10;
    }

    public void appa(long j10) {
        this.appm = j10;
    }

    public void appa(List<String> list) {
        this.appn = list;
    }

    public void appa(String str) {
        this.appo = str;
    }
}

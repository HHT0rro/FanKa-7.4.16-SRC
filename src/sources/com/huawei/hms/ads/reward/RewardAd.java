package com.huawei.hms.ads.reward;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.ads.AdParam;
import com.huawei.hms.ads.annotation.GlobalApi;
import com.huawei.hms.ads.by;
import com.huawei.hms.ads.dx;
import com.huawei.hms.ads.dy;
import com.huawei.hms.ads.j;
import com.huawei.openalliance.ad.inter.HiAd;
import com.huawei.openalliance.ad.inter.data.RewardItem;
import com.huawei.openalliance.ad.inter.data.i;
import com.huawei.openalliance.ad.inter.data.s;
import com.huawei.openalliance.ad.inter.listeners.f;
import com.huawei.openalliance.ad.inter.listeners.g;
import com.huawei.openalliance.ad.inter.listeners.o;
import com.huawei.openalliance.ad.inter.p;
import com.huawei.openalliance.ad.utils.aa;
import com.huawei.openalliance.ad.utils.l;
import java.util.List;
import java.util.Map;

@GlobalApi
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class RewardAd {
    private Reward B;
    private RewardVerifyConfig C;
    private OnMetadataChangedListener Code;
    private p F;
    private RewardAdListener L;
    private s S;
    private Context V;
    private String Z;

    /* renamed from: a, reason: collision with root package name */
    private String f29379a;

    /* renamed from: b, reason: collision with root package name */
    private String f29380b;

    /* renamed from: d, reason: collision with root package name */
    private int f29382d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f29383e;
    private boolean I = false;
    private Bundle D = new Bundle();

    /* renamed from: c, reason: collision with root package name */
    private boolean f29381c = false;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public class a implements o {
        private RewardAdListener I;
        private RewardAdLoadListener V;

        public a(RewardAdLoadListener rewardAdLoadListener, RewardAdListener rewardAdListener) {
            this.V = rewardAdLoadListener;
            this.I = rewardAdListener;
        }

        @Override // com.huawei.openalliance.ad.inter.listeners.o
        public void Code(int i10) {
            RewardAd.this.I = false;
            RewardAdLoadListener rewardAdLoadListener = this.V;
            if (rewardAdLoadListener != null) {
                rewardAdLoadListener.onRewardAdFailedToLoad(dx.Code(i10));
            }
            RewardAdListener rewardAdListener = this.I;
            if (rewardAdListener != null) {
                rewardAdListener.onRewardAdFailedToLoad(dx.Code(i10));
            }
        }

        @Override // com.huawei.openalliance.ad.inter.listeners.o
        public void Code(Map<String, List<i>> map) {
            RewardAdListener rewardAdListener;
            RewardAd.this.I = true;
            List<i> list = map.get(RewardAd.this.Z);
            if (aa.Code(list)) {
                RewardAdLoadListener rewardAdLoadListener = this.V;
                if (rewardAdLoadListener != null) {
                    rewardAdLoadListener.onRewardAdFailedToLoad(3);
                }
                rewardAdListener = this.I;
                if (rewardAdListener == null) {
                    return;
                }
            } else {
                i iVar = list.get(0);
                if (iVar instanceof s) {
                    RewardAd.this.S = (s) iVar;
                    RewardAd.this.S.Z(RewardAd.this.f29383e);
                    RewardAd rewardAd = RewardAd.this;
                    rewardAd.B = new by(rewardAd.S.B());
                    RewardAdLoadListener rewardAdLoadListener2 = this.V;
                    if (rewardAdLoadListener2 != null) {
                        rewardAdLoadListener2.onRewardedLoaded();
                    }
                    RewardAdListener rewardAdListener2 = this.I;
                    if (rewardAdListener2 != null) {
                        rewardAdListener2.onRewardAdLoaded();
                    }
                    if (RewardAd.this.Code != null) {
                        RewardAd.this.Code.onMetadataChanged();
                        return;
                    }
                    return;
                }
                RewardAdLoadListener rewardAdLoadListener3 = this.V;
                if (rewardAdLoadListener3 != null) {
                    rewardAdLoadListener3.onRewardAdFailedToLoad(3);
                }
                rewardAdListener = this.I;
                if (rewardAdListener == null) {
                    return;
                }
            }
            rewardAdListener.onRewardAdFailedToLoad(3);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public class b implements f, g {
        private RewardAdListener I;
        private RewardAdStatusListener V;

        public b(RewardAdStatusListener rewardAdStatusListener, RewardAdListener rewardAdListener) {
            this.V = rewardAdStatusListener;
            this.I = rewardAdListener;
        }

        @Override // com.huawei.openalliance.ad.inter.listeners.f
        public void B() {
            RewardItem B = RewardAd.this.S.B();
            RewardAdStatusListener rewardAdStatusListener = this.V;
            if (rewardAdStatusListener != null) {
                rewardAdStatusListener.onRewarded(B != null ? new by(B) : Reward.DEFAULT);
            }
            RewardAdListener rewardAdListener = this.I;
            if (rewardAdListener != null) {
                rewardAdListener.onRewarded(new by(B));
            }
        }

        @Override // com.huawei.openalliance.ad.inter.listeners.g
        public void C() {
            RewardAdListener rewardAdListener = this.I;
            if (rewardAdListener != null) {
                rewardAdListener.onRewardAdStarted();
            }
        }

        @Override // com.huawei.openalliance.ad.inter.listeners.f
        public void Code() {
            RewardAdStatusListener rewardAdStatusListener = this.V;
            if (rewardAdStatusListener != null) {
                rewardAdStatusListener.onRewardAdOpened();
            }
            RewardAdListener rewardAdListener = this.I;
            if (rewardAdListener != null) {
                rewardAdListener.onRewardAdOpened();
            }
        }

        @Override // com.huawei.openalliance.ad.inter.listeners.f
        public void Code(int i10, int i11) {
            RewardAdStatusListener rewardAdStatusListener = this.V;
            if (rewardAdStatusListener != null) {
                rewardAdStatusListener.onRewardAdFailedToShow(0);
            }
        }

        @Override // com.huawei.openalliance.ad.inter.listeners.f
        public void I() {
            RewardAdListener rewardAdListener = this.I;
            if (rewardAdListener != null) {
                rewardAdListener.onRewardAdCompleted();
            }
        }

        @Override // com.huawei.openalliance.ad.inter.listeners.g
        public void S() {
            RewardAdListener rewardAdListener = this.I;
            if (rewardAdListener != null) {
                rewardAdListener.onRewardAdLeftApp();
            }
        }

        @Override // com.huawei.openalliance.ad.inter.listeners.f
        public void V() {
        }

        @Override // com.huawei.openalliance.ad.inter.listeners.f
        public void Z() {
            RewardAdStatusListener rewardAdStatusListener = this.V;
            if (rewardAdStatusListener != null) {
                rewardAdStatusListener.onRewardAdClosed();
            }
            RewardAdListener rewardAdListener = this.I;
            if (rewardAdListener != null) {
                rewardAdListener.onRewardAdClosed();
            }
        }
    }

    private RewardAd(Context context) {
        if (context != null) {
            this.V = context.getApplicationContext();
        }
    }

    @GlobalApi
    public RewardAd(Context context, String str) {
        this.Z = str;
        this.V = context.getApplicationContext();
        this.F = new p(context, TextUtils.isEmpty(str) ? null : new String[]{str});
        this.f29382d = l.I(context);
    }

    private void Code() {
        this.I = false;
        this.S = null;
    }

    private void Code(Context context) {
        s sVar;
        if (!this.I || (sVar = this.S) == null) {
            return;
        }
        sVar.V(this.f29380b);
        this.S.Code(this.f29379a);
        b bVar = new b(null, this.L);
        this.S.Code((g) bVar);
        this.S.Code(context, bVar);
    }

    private void Code(AdParam adParam) {
        if (adParam == null || this.F == null) {
            return;
        }
        this.F.Code(dy.Code(adParam.V()));
        this.F.Code(adParam.getKeywords());
        this.F.Code(adParam.getGender());
        this.F.V(adParam.getTargetingContentUrl());
        this.F.I(adParam.I());
        this.F.Code(adParam.C());
        this.F.Code(adParam.Code());
        HiAd.getInstance(this.V).setCountryCode(adParam.Z());
    }

    private void Code(RewardAdStatusListener rewardAdStatusListener, int i10) {
        if (rewardAdStatusListener != null) {
            rewardAdStatusListener.onRewardAdFailedToShow(i10);
        }
    }

    @GlobalApi
    public static RewardAd createRewardAdInstance(Context context) {
        return new RewardAd(context);
    }

    @GlobalApi
    public void destroy() {
    }

    @GlobalApi
    public void destroy(Context context) {
    }

    @GlobalApi
    public String getData() {
        return this.f29379a;
    }

    @GlobalApi
    public Bundle getMetadata() {
        return this.D;
    }

    @GlobalApi
    public Reward getReward() {
        return this.B;
    }

    @GlobalApi
    public RewardAdListener getRewardAdListener() {
        return this.L;
    }

    @GlobalApi
    public String getUserId() {
        return this.f29380b;
    }

    @GlobalApi
    public boolean isLoaded() {
        return this.I;
    }

    @GlobalApi
    public void loadAd(AdParam adParam, RewardAdLoadListener rewardAdLoadListener) {
        j.Code().Code(this.V);
        Code();
        Code(adParam);
        this.F.Code(new a(rewardAdLoadListener, null));
        this.F.Code(this.f29382d, false);
    }

    @GlobalApi
    public void loadAd(String str, AdParam adParam) {
        this.Z = str;
        j.Code().Code(this.V);
        Code();
        p pVar = new p(this.V, TextUtils.isEmpty(str) ? null : new String[]{str});
        this.F = pVar;
        pVar.Code(new a(null, this.L));
        Code(adParam);
        this.F.Code(this.f29382d, false);
    }

    @GlobalApi
    public void pause() {
    }

    @GlobalApi
    public void pause(Context context) {
    }

    @GlobalApi
    public void resume() {
    }

    @GlobalApi
    public void resume(Context context) {
    }

    @GlobalApi
    public void setData(String str) {
        this.f29379a = str;
    }

    @GlobalApi
    public void setImmersive(boolean z10) {
        this.f29381c = z10;
    }

    @GlobalApi
    public void setMobileDataAlertSwitch(boolean z10) {
        this.f29383e = z10;
    }

    @GlobalApi
    public void setOnMetadataChangedListener(OnMetadataChangedListener onMetadataChangedListener) {
        this.Code = onMetadataChangedListener;
    }

    @GlobalApi
    public void setRewardAdListener(RewardAdListener rewardAdListener) {
        this.L = rewardAdListener;
    }

    @GlobalApi
    public void setRewardVerifyConfig(RewardVerifyConfig rewardVerifyConfig) {
        this.C = rewardVerifyConfig;
    }

    @GlobalApi
    public void setUserId(String str) {
        this.f29380b = str;
    }

    @GlobalApi
    @Deprecated
    public void show() {
        Code(this.V);
    }

    @GlobalApi
    public void show(Activity activity) {
        Code(activity);
    }

    @GlobalApi
    public void show(Activity activity, RewardAdStatusListener rewardAdStatusListener) {
        show(activity, rewardAdStatusListener, true);
    }

    @GlobalApi
    public void show(Activity activity, RewardAdStatusListener rewardAdStatusListener, boolean z10) {
        int i10;
        s sVar = this.S;
        if (sVar == null) {
            i10 = 2;
        } else {
            if (!sVar.Z()) {
                RewardVerifyConfig rewardVerifyConfig = this.C;
                if (rewardVerifyConfig != null) {
                    this.S.Code(rewardVerifyConfig);
                    this.S.V(this.C.getUserId());
                    this.S.Code(this.C.getData());
                }
                b bVar = new b(rewardAdStatusListener, null);
                this.S.Code((g) bVar);
                this.S.Code(activity, (f) bVar);
                return;
            }
            i10 = 1;
        }
        Code(rewardAdStatusListener, i10);
    }
}

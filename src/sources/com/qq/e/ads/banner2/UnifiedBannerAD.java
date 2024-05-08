package com.qq.e.ads.banner2;

import android.app.Activity;
import android.content.Context;
import com.alimm.tanx.core.utils.LandingPageUtHelper;
import com.qq.e.ads.LiteAbstractAD;
import com.qq.e.ads.cfg.DownAPPConfirmPolicy;
import com.qq.e.ads.rewardvideo.ServerSideVerificationOptions;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.listeners.ADRewardListener;
import com.qq.e.comm.listeners.NegativeFeedbackListener;
import com.qq.e.comm.pi.IReward;
import com.qq.e.comm.pi.NFBI;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.pi.UBVI;
import com.qq.e.comm.util.AdErrorConvertor;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class UnifiedBannerAD extends LiteAbstractAD<UBVI> implements NFBI, IReward {

    /* renamed from: g, reason: collision with root package name */
    private UnifiedBannerADListener f38108g;

    /* renamed from: h, reason: collision with root package name */
    private DownAPPConfirmPolicy f38109h;

    /* renamed from: i, reason: collision with root package name */
    private AtomicInteger f38110i;

    /* renamed from: j, reason: collision with root package name */
    private int f38111j;

    /* renamed from: k, reason: collision with root package name */
    private LoadAdParams f38112k;

    /* renamed from: l, reason: collision with root package name */
    private UnifiedBannerView f38113l;

    /* renamed from: m, reason: collision with root package name */
    private final ADListenerAdapter f38114m;

    /* renamed from: n, reason: collision with root package name */
    private volatile ServerSideVerificationOptions f38115n;

    public UnifiedBannerAD(Activity activity, UnifiedBannerView unifiedBannerView, String str, UnifiedBannerADListener unifiedBannerADListener) {
        this(unifiedBannerView, unifiedBannerADListener);
        a(activity, str);
    }

    public UnifiedBannerAD(Activity activity, UnifiedBannerView unifiedBannerView, String str, String str2, UnifiedBannerADListener unifiedBannerADListener) {
        this(unifiedBannerView, unifiedBannerADListener);
        a(activity, str, str2);
    }

    private UnifiedBannerAD(UnifiedBannerView unifiedBannerView, UnifiedBannerADListener unifiedBannerADListener) {
        this.f38110i = new AtomicInteger(0);
        this.f38111j = 30;
        this.f38112k = null;
        this.f38108g = unifiedBannerADListener;
        this.f38113l = unifiedBannerView;
        this.f38114m = new ADListenerAdapter(unifiedBannerADListener);
    }

    @Override // com.qq.e.ads.AbstractAD
    public Object a(Context context, POFactory pOFactory, String str, String str2, String str3) {
        return pOFactory.getUnifiedBannerViewDelegate(this.f38113l, (Activity) context, str, str2, str3, this.f38114m);
    }

    public void a(DownAPPConfirmPolicy downAPPConfirmPolicy) {
        T t2;
        this.f38109h = downAPPConfirmPolicy;
        if (downAPPConfirmPolicy == null || (t2 = this.f38089a) == 0) {
            return;
        }
        ((UBVI) t2).setDownAPPConfirmPolicy(downAPPConfirmPolicy);
    }

    @Override // com.qq.e.ads.AbstractAD
    public void b(int i10) {
        UnifiedBannerADListener unifiedBannerADListener = this.f38108g;
        if (unifiedBannerADListener != null) {
            unifiedBannerADListener.onNoAD(AdErrorConvertor.formatErrorCode(i10));
        }
    }

    public void c(int i10) {
        this.f38111j = i10;
        T t2 = this.f38089a;
        if (t2 != 0) {
            ((UBVI) t2).setRefresh(i10);
        }
    }

    public void destroy() {
        T t2 = this.f38089a;
        if (t2 != 0) {
            ((UBVI) t2).destroy();
        } else {
            a(LandingPageUtHelper.XAD_UT_LP_DESTROY);
        }
    }

    public String getAdNetWorkName() {
        T t2 = this.f38089a;
        if (t2 != 0) {
            return ((UBVI) t2).getAdNetWorkName();
        }
        a("getAdNetWorkName");
        return null;
    }

    public void loadAD() {
        if (a()) {
            if (!b()) {
                this.f38110i.incrementAndGet();
                return;
            }
            T t2 = this.f38089a;
            if (t2 != 0) {
                ((UBVI) t2).fetchAd();
            } else {
                a("loadAD");
            }
        }
    }

    public void onWindowFocusChanged(boolean z10) {
        T t2 = this.f38089a;
        if (t2 != 0) {
            ((UBVI) t2).onWindowFocusChanged(z10);
        }
    }

    public void setLoadAdParams(LoadAdParams loadAdParams) {
        this.f38112k = loadAdParams;
        T t2 = this.f38089a;
        if (t2 != 0) {
            ((UBVI) t2).setLoadAdParams(loadAdParams);
        }
    }

    @Override // com.qq.e.comm.pi.NFBI
    public void setNegativeFeedbackListener(NegativeFeedbackListener negativeFeedbackListener) {
        this.f38114m.setNegativeFeedbackListener(negativeFeedbackListener);
    }

    @Override // com.qq.e.comm.pi.IReward
    public void setRewardListener(ADRewardListener aDRewardListener) {
        this.f38114m.setAdRewardListener(aDRewardListener);
    }

    @Override // com.qq.e.comm.pi.IReward
    public void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions) {
        this.f38115n = serverSideVerificationOptions;
        T t2 = this.f38089a;
        if (t2 != 0) {
            ((UBVI) t2).setServerSideVerificationOptions(serverSideVerificationOptions);
        }
    }

    @Override // com.qq.e.ads.AbstractAD
    public void a(Object obj) {
        UBVI ubvi = (UBVI) obj;
        DownAPPConfirmPolicy downAPPConfirmPolicy = this.f38109h;
        if (downAPPConfirmPolicy != null) {
            this.f38109h = downAPPConfirmPolicy;
            T t2 = this.f38089a;
            if (t2 != 0) {
                ((UBVI) t2).setDownAPPConfirmPolicy(downAPPConfirmPolicy);
            }
        }
        int i10 = this.f38111j;
        this.f38111j = i10;
        T t10 = this.f38089a;
        if (t10 != 0) {
            ((UBVI) t10).setRefresh(i10);
        }
        LoadAdParams loadAdParams = this.f38112k;
        this.f38112k = loadAdParams;
        T t11 = this.f38089a;
        if (t11 != 0) {
            ((UBVI) t11).setLoadAdParams(loadAdParams);
        }
        ubvi.setServerSideVerificationOptions(this.f38115n);
        while (this.f38110i.getAndDecrement() > 0) {
            loadAD();
        }
    }
}

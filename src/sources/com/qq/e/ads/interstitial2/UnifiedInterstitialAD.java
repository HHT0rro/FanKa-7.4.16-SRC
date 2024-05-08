package com.qq.e.ads.interstitial2;

import android.app.Activity;
import android.content.Context;
import com.alimm.tanx.core.utils.LandingPageUtHelper;
import com.qq.e.ads.LiteAbstractAD;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.rewardvideo.ServerSideVerificationOptions;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.listeners.NegativeFeedbackListener;
import com.qq.e.comm.pi.IReward;
import com.qq.e.comm.pi.NFBI;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.pi.UIADI;
import com.qq.e.comm.util.AdErrorConvertor;
import com.qq.e.comm.util.GDTLogger;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class UnifiedInterstitialAD extends LiteAbstractAD<UIADI> implements NFBI, IReward {

    /* renamed from: g, reason: collision with root package name */
    private AtomicInteger f38168g;

    /* renamed from: h, reason: collision with root package name */
    private AtomicInteger f38169h;

    /* renamed from: i, reason: collision with root package name */
    private volatile VideoOption f38170i;

    /* renamed from: j, reason: collision with root package name */
    private volatile int f38171j;

    /* renamed from: k, reason: collision with root package name */
    private volatile int f38172k;

    /* renamed from: l, reason: collision with root package name */
    private volatile LoadAdParams f38173l;

    /* renamed from: m, reason: collision with root package name */
    private UnifiedInterstitialADListener f38174m;

    /* renamed from: n, reason: collision with root package name */
    private ServerSideVerificationOptions f38175n;

    /* renamed from: o, reason: collision with root package name */
    private final ADListenerAdapter f38176o;

    public UnifiedInterstitialAD(Activity activity, String str, UnifiedInterstitialADListener unifiedInterstitialADListener) {
        this(activity, str, unifiedInterstitialADListener, null);
    }

    public UnifiedInterstitialAD(Activity activity, String str, UnifiedInterstitialADListener unifiedInterstitialADListener, Map map) {
        this.f38168g = new AtomicInteger(0);
        this.f38169h = new AtomicInteger(0);
        this.f38174m = unifiedInterstitialADListener;
        this.f38176o = new ADListenerAdapter(unifiedInterstitialADListener);
        a(activity, str);
    }

    public UnifiedInterstitialAD(Activity activity, String str, UnifiedInterstitialADListener unifiedInterstitialADListener, Map map, String str2) {
        this.f38168g = new AtomicInteger(0);
        this.f38169h = new AtomicInteger(0);
        this.f38174m = unifiedInterstitialADListener;
        this.f38176o = new ADListenerAdapter(unifiedInterstitialADListener);
        a(activity, str, str2);
    }

    @Override // com.qq.e.ads.AbstractAD
    public Object a(Context context, POFactory pOFactory, String str, String str2, String str3) {
        return pOFactory.getUnifiedInterstitialADDelegate((Activity) context, str, str2, str3, this.f38176o);
    }

    @Override // com.qq.e.ads.AbstractAD
    public /* bridge */ /* synthetic */ void a(Object obj) {
        c();
    }

    @Override // com.qq.e.ads.AbstractAD
    public void b(int i10) {
        UnifiedInterstitialADListener unifiedInterstitialADListener = this.f38174m;
        if (unifiedInterstitialADListener != null) {
            unifiedInterstitialADListener.onNoAD(AdErrorConvertor.formatErrorCode(i10));
        }
    }

    public void c() {
        setVideoOption(this.f38170i);
        setMinVideoDuration(this.f38171j);
        setMaxVideoDuration(this.f38172k);
        setLoadAdParams(this.f38173l);
        setServerSideVerificationOptions(this.f38175n);
        while (this.f38168g.getAndDecrement() > 0) {
            loadAD();
        }
        while (this.f38169h.getAndDecrement() > 0) {
            loadFullScreenAD();
        }
    }

    public void close() {
        T t2 = this.f38089a;
        if (t2 != 0) {
            ((UIADI) t2).close();
        }
    }

    public void destroy() {
        T t2 = this.f38089a;
        if (t2 != 0) {
            ((UIADI) t2).destroy();
        } else {
            a(LandingPageUtHelper.XAD_UT_LP_DESTROY);
        }
    }

    public String getAdNetWorkName() {
        T t2 = this.f38089a;
        if (t2 != 0) {
            return ((UIADI) t2).getAdNetWorkName();
        }
        a("getAdNetWorkName");
        return null;
    }

    public int getAdPatternType() {
        T t2 = this.f38089a;
        if (t2 != 0) {
            return ((UIADI) t2).getAdPatternType();
        }
        a("getAdPatternType");
        return 0;
    }

    public int getVideoDuration() {
        T t2 = this.f38089a;
        if (t2 != 0) {
            return ((UIADI) t2).getVideoDuration();
        }
        a("getVideoDuration");
        return 0;
    }

    public void loadAD() {
        if (a()) {
            if (!b()) {
                this.f38168g.incrementAndGet();
                return;
            }
            T t2 = this.f38089a;
            if (t2 != 0) {
                ((UIADI) t2).loadAd();
            } else {
                a("loadAD");
            }
        }
    }

    public void loadFullScreenAD() {
        if (a()) {
            if (!b()) {
                this.f38169h.incrementAndGet();
                return;
            }
            T t2 = this.f38089a;
            if (t2 != 0) {
                ((UIADI) t2).loadFullScreenAD();
            } else {
                a("loadFullScreenAD");
            }
        }
    }

    public void setLoadAdParams(LoadAdParams loadAdParams) {
        this.f38173l = loadAdParams;
        T t2 = this.f38089a;
        if (t2 != 0) {
            ((UIADI) t2).setLoadAdParams(this.f38173l);
        }
    }

    public void setMaxVideoDuration(int i10) {
        this.f38172k = i10;
        if (this.f38172k > 0 && this.f38171j > this.f38172k) {
            GDTLogger.e("maxVideoDuration 设置值非法，不得小于minVideoDuration");
        }
        T t2 = this.f38089a;
        if (t2 != 0) {
            ((UIADI) t2).setMaxVideoDuration(i10);
        }
    }

    public void setMediaListener(UnifiedInterstitialMediaListener unifiedInterstitialMediaListener) {
        this.f38176o.setMediaListener(unifiedInterstitialMediaListener);
    }

    public void setMinVideoDuration(int i10) {
        this.f38171j = i10;
        if (this.f38172k > 0 && this.f38171j > this.f38172k) {
            GDTLogger.e("minVideoDuration 设置值非法，不得大于maxVideoDuration");
        }
        T t2 = this.f38089a;
        if (t2 != 0) {
            ((UIADI) t2).setMinVideoDuration(i10);
        }
    }

    @Override // com.qq.e.comm.pi.NFBI
    public void setNegativeFeedbackListener(NegativeFeedbackListener negativeFeedbackListener) {
        this.f38176o.setNegativeFeedbackListener(negativeFeedbackListener);
    }

    @Override // com.qq.e.comm.pi.IReward
    public void setRewardListener(com.qq.e.comm.listeners.ADRewardListener aDRewardListener) {
        this.f38176o.setAdRewardListener(aDRewardListener);
    }

    @Override // com.qq.e.comm.pi.IReward
    public void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions) {
        this.f38175n = serverSideVerificationOptions;
        T t2 = this.f38089a;
        if (t2 != 0) {
            ((UIADI) t2).setServerSideVerificationOptions(serverSideVerificationOptions);
        }
    }

    public void setVideoOption(VideoOption videoOption) {
        this.f38170i = videoOption;
        T t2 = this.f38089a;
        if (t2 != 0) {
            ((UIADI) t2).setVideoOption(videoOption);
        }
    }

    public void show() {
        T t2 = this.f38089a;
        if (t2 != 0) {
            ((UIADI) t2).show();
        } else {
            a("show");
        }
    }

    public void show(Activity activity) {
        T t2 = this.f38089a;
        if (t2 != 0) {
            ((UIADI) t2).show(activity);
        } else {
            a("show");
        }
    }

    @Deprecated
    public void showAsPopupWindow() {
        T t2 = this.f38089a;
        if (t2 != 0) {
            ((UIADI) t2).showAsPopupWindow();
        } else {
            a("showAsPopupWindow");
        }
    }

    @Deprecated
    public void showAsPopupWindow(Activity activity) {
        T t2 = this.f38089a;
        if (t2 != 0) {
            ((UIADI) t2).showAsPopupWindow(activity);
        } else {
            a("showAsPopupWindow");
        }
    }

    public void showFullScreenAD(Activity activity) {
        T t2 = this.f38089a;
        if (t2 != 0) {
            ((UIADI) t2).showFullScreenAD(activity);
        } else {
            a("showFullScreenAD");
        }
    }
}

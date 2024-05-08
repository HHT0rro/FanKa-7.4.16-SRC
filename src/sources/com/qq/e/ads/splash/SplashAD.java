package com.qq.e.ads.splash;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import com.qq.e.ads.LiteAbstractAD;
import com.qq.e.ads.rewardvideo.ServerSideVerificationOptions;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.listeners.ADRewardListener;
import com.qq.e.comm.pi.IReward;
import com.qq.e.comm.pi.NSPVI;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.util.AdErrorConvertor;
import com.qq.e.comm.util.GDTLogger;
import java.util.HashMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class SplashAD extends LiteAbstractAD<NSPVI> implements IReward {

    /* renamed from: g, reason: collision with root package name */
    private volatile ViewGroup f38230g;

    /* renamed from: h, reason: collision with root package name */
    private volatile SplashADListener f38231h;

    /* renamed from: i, reason: collision with root package name */
    private volatile ADRewardListener f38232i;

    /* renamed from: j, reason: collision with root package name */
    private volatile LoadAdParams f38233j;

    /* renamed from: k, reason: collision with root package name */
    private volatile boolean f38234k;

    /* renamed from: l, reason: collision with root package name */
    private volatile boolean f38235l;

    /* renamed from: m, reason: collision with root package name */
    private volatile boolean f38236m;

    /* renamed from: n, reason: collision with root package name */
    private volatile int f38237n;

    /* renamed from: o, reason: collision with root package name */
    private volatile byte[] f38238o;

    /* renamed from: p, reason: collision with root package name */
    private volatile ServerSideVerificationOptions f38239p;

    /* renamed from: q, reason: collision with root package name */
    private int f38240q;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public class ADListenerAdapter implements ADListener {
        private ADListenerAdapter() {
        }

        @Override // com.qq.e.comm.adevent.ADListener
        public void onADEvent(ADEvent aDEvent) {
            String str;
            if (SplashAD.this.f38231h == null) {
                GDTLogger.d("SplashADListener == null");
                return;
            }
            int type = aDEvent.getType();
            if (type == 112) {
                Long l10 = (Long) aDEvent.getParam(Long.class);
                if (l10 != null) {
                    SplashAD.this.f38231h.onADTick(l10.longValue());
                    return;
                }
                return;
            }
            switch (type) {
                case 100:
                    Long l11 = (Long) aDEvent.getParam(Long.class);
                    if (l11 != null) {
                        SplashAD.this.f38231h.onADLoaded(l11.longValue());
                        return;
                    }
                    return;
                case 101:
                    Integer num = (Integer) aDEvent.getParam(Integer.class);
                    if (num != null) {
                        SplashAD.this.f38231h.onNoAD(AdErrorConvertor.formatErrorCode(num.intValue()));
                        return;
                    }
                    return;
                case 102:
                    SplashAD.this.f38231h.onADPresent();
                    return;
                case 103:
                    SplashAD.this.f38231h.onADExposure();
                    return;
                case 104:
                    if (SplashAD.this.f38232i == null || (str = (String) aDEvent.getParam(String.class)) == null) {
                        return;
                    }
                    HashMap hashMap = new HashMap();
                    hashMap.put("transId", str);
                    SplashAD.this.f38232i.onReward(hashMap);
                    return;
                case 105:
                    SplashAD.this.f38231h.onADClicked();
                    return;
                case 106:
                    SplashAD.this.f38231h.onADDismissed();
                    return;
                default:
                    return;
            }
        }
    }

    public SplashAD(Context context, String str, SplashADListener splashADListener) {
        this(context, str, splashADListener, 0);
    }

    public SplashAD(Context context, String str, SplashADListener splashADListener, int i10) {
        this.f38234k = false;
        this.f38231h = splashADListener;
        this.f38240q = i10;
        a(context, str);
    }

    public SplashAD(Context context, String str, SplashADListener splashADListener, int i10, String str2) {
        this.f38234k = false;
        this.f38231h = splashADListener;
        this.f38240q = i10;
        a(context, str, str2);
    }

    private void a(ViewGroup viewGroup, boolean z10) {
        if (viewGroup == null) {
            GDTLogger.e("传入参数有误：传入container参数为空");
            a(4001);
            return;
        }
        T t2 = this.f38089a;
        if (t2 == 0) {
            this.f38236m = z10;
            this.f38230g = viewGroup;
            return;
        }
        NSPVI nspvi = (NSPVI) t2;
        if (z10) {
            nspvi.fetchFullScreenAndShowIn(viewGroup);
        } else {
            nspvi.fetchAndShowIn(viewGroup);
        }
    }

    private void a(boolean z10) {
        if (a()) {
            if (!b()) {
                this.f38236m = z10;
                this.f38235l = true;
                return;
            }
            T t2 = this.f38089a;
            if (t2 == 0) {
                a("fetchAdInner");
                return;
            }
            NSPVI nspvi = (NSPVI) t2;
            if (z10) {
                nspvi.fetchFullScreenAdOnly();
            } else {
                nspvi.fetchAdOnly();
            }
        }
    }

    private void b(ViewGroup viewGroup, boolean z10) {
        if (viewGroup == null) {
            GDTLogger.e("传入参数错误，container参数为空");
            a(4001);
            return;
        }
        T t2 = this.f38089a;
        if (t2 == 0) {
            this.f38230g = viewGroup;
            return;
        }
        NSPVI nspvi = (NSPVI) t2;
        if (z10) {
            nspvi.showFullScreenAd(viewGroup);
        } else {
            nspvi.showAd(viewGroup);
        }
    }

    @Override // com.qq.e.ads.AbstractAD
    public Object a(Context context, POFactory pOFactory, String str, String str2, String str3) {
        return pOFactory.getNativeSplashAdView(context, str, str2, str3);
    }

    @Override // com.qq.e.ads.AbstractAD
    public void b(int i10) {
        if (this.f38231h != null) {
            this.f38231h.onNoAD(AdErrorConvertor.formatErrorCode(i10));
        }
    }

    public void fetchAdOnly() {
        a(false);
    }

    public void fetchAndShowIn(ViewGroup viewGroup) {
        a(viewGroup, false);
    }

    public void fetchFullScreenAdOnly() {
        a(true);
    }

    public void fetchFullScreenAndShowIn(ViewGroup viewGroup) {
        a(viewGroup, true);
    }

    public String getAdNetWorkName() {
        T t2 = this.f38089a;
        if (t2 != 0) {
            return ((NSPVI) t2).getAdNetWorkName();
        }
        a("getAdNetWorkName");
        return null;
    }

    @Deprecated
    public Bitmap getZoomOutBitmap() {
        GDTLogger.e("注意！开屏V+功能已废弃，调用不生效");
        return null;
    }

    public void preLoad() {
        if (a()) {
            if (!b()) {
                this.f38234k = true;
                return;
            }
            T t2 = this.f38089a;
            if (t2 != 0) {
                ((NSPVI) t2).preload();
            } else {
                a("preLoad");
            }
        }
    }

    @Deprecated
    public void setAdLogoMargin(int i10, int i11) {
    }

    public void setDeveloperLogo(int i10) {
        T t2 = this.f38089a;
        if (t2 == 0) {
            this.f38237n = i10;
        } else {
            ((NSPVI) t2).setDeveloperLogo(i10);
        }
    }

    public void setDeveloperLogo(byte[] bArr) {
        T t2 = this.f38089a;
        if (t2 == 0) {
            this.f38238o = bArr;
        } else {
            ((NSPVI) t2).setDeveloperLogo(bArr);
        }
    }

    public void setLoadAdParams(LoadAdParams loadAdParams) {
        T t2 = this.f38089a;
        if (t2 != 0) {
            ((NSPVI) t2).setLoadAdParams(loadAdParams);
        } else {
            this.f38233j = loadAdParams;
        }
    }

    @Deprecated
    public void setPreloadView(View view) {
    }

    @Override // com.qq.e.comm.pi.IReward
    public void setRewardListener(ADRewardListener aDRewardListener) {
        this.f38232i = aDRewardListener;
    }

    @Override // com.qq.e.comm.pi.IReward
    public void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions) {
        this.f38239p = serverSideVerificationOptions;
        T t2 = this.f38089a;
        if (t2 != 0) {
            ((NSPVI) t2).setServerSideVerificationOptions(serverSideVerificationOptions);
        }
    }

    public void showAd(ViewGroup viewGroup) {
        b(viewGroup, false);
    }

    public void showFullScreenAd(ViewGroup viewGroup) {
        b(viewGroup, true);
    }

    @Deprecated
    public void zoomOutAnimationFinish() {
        GDTLogger.e("注意！开屏V+功能已废弃，调用不生效");
    }

    @Override // com.qq.e.ads.AbstractAD
    public void a(Object obj) {
        NSPVI nspvi = (NSPVI) obj;
        if (this.f38233j != null) {
            nspvi.setLoadAdParams(this.f38233j);
        }
        if (this.f38237n != 0) {
            nspvi.setDeveloperLogo(this.f38237n);
        }
        if (this.f38238o != null) {
            nspvi.setDeveloperLogo(this.f38238o);
        }
        nspvi.setFetchDelay(this.f38240q);
        nspvi.setAdListener(new ADListenerAdapter());
        nspvi.setServerSideVerificationOptions(this.f38239p);
        if (this.f38230g != null) {
            if (this.f38236m) {
                fetchFullScreenAndShowIn(this.f38230g);
            } else {
                fetchAndShowIn(this.f38230g);
            }
        }
        if (this.f38234k) {
            nspvi.preload();
            this.f38234k = false;
        }
        if (this.f38235l) {
            if (this.f38236m) {
                nspvi.fetchFullScreenAdOnly();
            } else {
                nspvi.fetchAdOnly();
            }
            this.f38235l = false;
        }
    }
}

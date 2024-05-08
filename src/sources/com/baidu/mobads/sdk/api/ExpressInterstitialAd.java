package com.baidu.mobads.sdk.api;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.KeyEvent;
import com.baidu.mobads.sdk.internal.a;
import com.baidu.mobads.sdk.internal.aw;
import com.baidu.mobads.sdk.internal.cq;
import com.baidu.mobads.sdk.internal.dh;
import java.util.HashMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class ExpressInterstitialAd {
    private InterstitialAdDislikeListener mAdDislikeListener;
    private String mAdPlaceId;
    private String mAppsid;
    private int mBidFloor;
    private Context mContext;
    private ExpressInterstitialListener mExpressInterstitialListener;
    private int mHeight;
    private InterAdDownloadWindowListener mInterAdDownloadWindowListener;
    private dh mNativeInterstitialAdProd;
    private RequestParameters mRequestParameters;
    private boolean mUseDialogContainer;
    private boolean mUseDialogFrame;
    private int mWidth;
    private boolean onlyFetchAd;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public interface InterAdDownloadWindowListener {
        void adDownloadWindowClose();

        void adDownloadWindowShow();

        void onADPermissionClose();

        void onADPermissionShow();

        void onADPrivacyClick();

        void onADPrivacyClose();
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public interface InterstitialAdDislikeListener {
        void interstitialAdDislikeClick();
    }

    public ExpressInterstitialAd(Context context, String str) {
        this(context, str, 500, 600);
    }

    private void initNativeInterstitialAdProd() {
        cq cqVar = new cq(this.mContext);
        cqVar.a(new cq.a() { // from class: com.baidu.mobads.sdk.api.ExpressInterstitialAd.1
            @Override // com.baidu.mobads.sdk.internal.cq.a
            public void onAttachedToWindow() {
            }

            @Override // com.baidu.mobads.sdk.internal.cq.a
            public void onDetachedFromWindow() {
                if (ExpressInterstitialAd.this.mNativeInterstitialAdProd != null) {
                    ExpressInterstitialAd.this.mNativeInterstitialAdProd.p();
                }
            }

            @Override // com.baidu.mobads.sdk.internal.cq.a
            public boolean onKeyDown(int i10, KeyEvent keyEvent) {
                return i10 == 4;
            }

            @Override // com.baidu.mobads.sdk.internal.cq.a
            public void onLayoutComplete(int i10, int i11) {
            }

            @Override // com.baidu.mobads.sdk.internal.cq.a
            public void onWindowFocusChanged(boolean z10) {
            }

            @Override // com.baidu.mobads.sdk.internal.cq.a
            public void onWindowVisibilityChanged(int i10) {
            }
        });
        this.mNativeInterstitialAdProd = new dh(this.mContext, cqVar, this.mAdPlaceId);
        if (!TextUtils.isEmpty(this.mAppsid)) {
            this.mNativeInterstitialAdProd.f9885o = this.mAppsid;
        }
        dh dhVar = this.mNativeInterstitialAdProd;
        dhVar.f9886p = this.mBidFloor;
        dhVar.f10159q = this.onlyFetchAd;
        dhVar.a(this.mExpressInterstitialListener);
        this.mNativeInterstitialAdProd.a(this.mInterAdDownloadWindowListener);
        this.mNativeInterstitialAdProd.a(this.mAdDislikeListener);
        this.mNativeInterstitialAdProd.c(this.mUseDialogFrame);
        this.mNativeInterstitialAdProd.d(this.mUseDialogContainer);
        RequestParameters requestParameters = this.mRequestParameters;
        if (requestParameters != null) {
            this.mNativeInterstitialAdProd.a(requestParameters);
        }
    }

    private void reallyLoad() {
        initNativeInterstitialAdProd();
        this.mNativeInterstitialAdProd.a();
    }

    public void biddingFail(String str) {
        biddingFail(str, null);
    }

    public void biddingSuccess(String str) {
        dh dhVar = this.mNativeInterstitialAdProd;
        if (dhVar != null) {
            dhVar.a(true, str);
        }
    }

    public void destroy() {
        dh dhVar = this.mNativeInterstitialAdProd;
        if (dhVar == null) {
            return;
        }
        dhVar.e();
    }

    public Object getAdDataForKey(String str) {
        dh dhVar = this.mNativeInterstitialAdProd;
        if (dhVar != null) {
            return dhVar.a(str);
        }
        return null;
    }

    public String getBiddingToken() {
        this.onlyFetchAd = true;
        initNativeInterstitialAdProd();
        return this.mNativeInterstitialAdProd.m();
    }

    public String getECPMLevel() {
        a x10;
        dh dhVar = this.mNativeInterstitialAdProd;
        return (dhVar == null || (x10 = dhVar.x()) == null) ? "" : x10.z();
    }

    public boolean isReady() {
        IAdInterListener iAdInterListener;
        dh dhVar = this.mNativeInterstitialAdProd;
        if (dhVar == null || (iAdInterListener = dhVar.f9881k) == null) {
            return false;
        }
        return iAdInterListener.isAdReady();
    }

    public void load() {
        if (this.mContext == null) {
            aw.c().e("ExpressInterstitialAd", "请传一个非空的context再进行load");
        } else {
            this.onlyFetchAd = true;
            reallyLoad();
        }
    }

    public void loadBiddingAd(String str) {
        dh dhVar = this.mNativeInterstitialAdProd;
        if (dhVar != null) {
            dhVar.c(str);
        }
    }

    public void setAdDislikeListener(InterstitialAdDislikeListener interstitialAdDislikeListener) {
        this.mAdDislikeListener = interstitialAdDislikeListener;
    }

    public void setAppSid(String str) {
        this.mAppsid = str;
    }

    public void setBidFloor(int i10) {
        this.mBidFloor = i10;
    }

    @Deprecated
    public void setBiddingData(String str) {
        dh dhVar = this.mNativeInterstitialAdProd;
        if (dhVar != null) {
            dhVar.b(str);
        }
    }

    public void setDialogFrame(boolean z10) {
        this.mUseDialogFrame = z10;
    }

    public void setDownloadListener(InterAdDownloadWindowListener interAdDownloadWindowListener) {
        this.mInterAdDownloadWindowListener = interAdDownloadWindowListener;
    }

    public void setLoadListener(ExpressInterstitialListener expressInterstitialListener) {
        this.mExpressInterstitialListener = expressInterstitialListener;
    }

    public void setRequestParameters(RequestParameters requestParameters) {
        this.mRequestParameters = requestParameters;
    }

    public void show() {
        dh dhVar = this.mNativeInterstitialAdProd;
        if (dhVar == null) {
            return;
        }
        if (dhVar.g()) {
            this.mNativeInterstitialAdProd.h();
        } else {
            this.mNativeInterstitialAdProd.f((IOAdEvent) null);
        }
    }

    public void useUseDialogContainer(boolean z10) {
        this.mUseDialogContainer = z10;
    }

    public ExpressInterstitialAd(Context context, String str, int i10, int i11) {
        this.mUseDialogFrame = false;
        this.mBidFloor = -1;
        this.mUseDialogContainer = false;
        this.mContext = context;
        this.mAdPlaceId = str;
        this.mWidth = i10;
        this.mHeight = i11;
    }

    public void biddingFail(String str, HashMap<String, Object> hashMap) {
        dh dhVar = this.mNativeInterstitialAdProd;
        if (dhVar != null) {
            dhVar.a(false, str, hashMap);
        }
    }

    public void show(Activity activity) {
        dh dhVar = this.mNativeInterstitialAdProd;
        if (dhVar == null) {
            return;
        }
        dhVar.a(activity);
        show();
    }
}

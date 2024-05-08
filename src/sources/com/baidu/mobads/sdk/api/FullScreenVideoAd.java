package com.baidu.mobads.sdk.api;

import android.content.Context;
import com.baidu.mobads.sdk.internal.dk;
import com.baidu.mobads.sdk.internal.ds;
import java.util.HashMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class FullScreenVideoAd {
    private static final String TAG = "FullScreenVideoAd";
    private ds mAdProd;
    private final Context mContext;
    private RequestParameters mRequestParameters;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public interface FullScreenVideoAdListener extends ScreenVideoAdListener {
        @Override // com.baidu.mobads.sdk.api.ScreenVideoAdListener
        void onAdClick();

        @Override // com.baidu.mobads.sdk.api.ScreenVideoAdListener
        void onAdClose(float f10);

        @Override // com.baidu.mobads.sdk.api.ScreenVideoAdListener
        void onAdFailed(String str);

        @Override // com.baidu.mobads.sdk.api.ScreenVideoAdListener
        void onAdShow();

        @Override // com.baidu.mobads.sdk.api.ScreenVideoAdListener
        void onAdSkip(float f10);

        @Override // com.baidu.mobads.sdk.api.ScreenVideoAdListener
        void onVideoDownloadFailed();

        @Override // com.baidu.mobads.sdk.api.ScreenVideoAdListener
        void onVideoDownloadSuccess();

        @Override // com.baidu.mobads.sdk.api.ScreenVideoAdListener
        void playCompletion();
    }

    public FullScreenVideoAd(Context context, String str, FullScreenVideoAdListener fullScreenVideoAdListener) {
        this(context, str, fullScreenVideoAdListener, false);
    }

    public void biddingFail(String str) {
        biddingFail(str, null);
    }

    public void biddingSuccess(String str) {
        ds dsVar = this.mAdProd;
        if (dsVar != null) {
            dsVar.a(true, str);
        }
    }

    public String getBiddingToken() {
        ds dsVar = this.mAdProd;
        if (dsVar != null) {
            return dsVar.m();
        }
        return null;
    }

    public String getECPMLevel() {
        ds dsVar = this.mAdProd;
        return dsVar != null ? dsVar.h() : "";
    }

    public boolean isReady() {
        ds dsVar = this.mAdProd;
        if (dsVar != null) {
            return dsVar.g();
        }
        return false;
    }

    public synchronized void load() {
        ds dsVar = this.mAdProd;
        if (dsVar != null) {
            dsVar.a();
        }
    }

    public void loadBiddingAd(String str) {
        ds dsVar = this.mAdProd;
        if (dsVar != null) {
            dsVar.c(str);
        }
    }

    public void setAppSid(String str) {
        ds dsVar = this.mAdProd;
        if (dsVar != null) {
            dsVar.h(str);
        }
    }

    public void setBidFloor(int i10) {
        ds dsVar = this.mAdProd;
        if (dsVar != null) {
            dsVar.f9886p = i10;
        }
    }

    @Deprecated
    public void setBiddingData(String str) {
        ds dsVar = this.mAdProd;
        if (dsVar != null) {
            dsVar.b(str);
        }
    }

    public void setRequestParameters(RequestParameters requestParameters) {
        ds dsVar;
        this.mRequestParameters = requestParameters;
        if (requestParameters == null || (dsVar = this.mAdProd) == null) {
            return;
        }
        dsVar.a(requestParameters);
    }

    public synchronized void show() {
        ds dsVar = this.mAdProd;
        if (dsVar != null) {
            dsVar.f();
        }
    }

    public FullScreenVideoAd(Context context, String str, FullScreenVideoAdListener fullScreenVideoAdListener, boolean z10) {
        this.mContext = context;
        dk dkVar = new dk(context, str, z10);
        this.mAdProd = dkVar;
        dkVar.a(fullScreenVideoAdListener);
    }

    public void biddingFail(String str, HashMap<String, Object> hashMap) {
        ds dsVar = this.mAdProd;
        if (dsVar != null) {
            dsVar.a(false, str, hashMap);
        }
    }

    public synchronized void show(Context context) {
        ds dsVar = this.mAdProd;
        if (dsVar != null) {
            dsVar.a(context);
        }
    }
}

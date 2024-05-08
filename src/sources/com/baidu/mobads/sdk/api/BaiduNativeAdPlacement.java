package com.baidu.mobads.sdk.api;

import com.baidu.mobads.sdk.internal.a;
import java.lang.ref.WeakReference;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class BaiduNativeAdPlacement {
    private String apid;
    private String mAppsid;
    private boolean mClicked;
    private boolean mWinSended;
    public a mAdElementInfo = null;
    private boolean mRequestStarted = false;
    private WeakReference<BaiduNativeH5AdView> mWeakAdView = null;
    private int feedSessionId = 0;
    private int feedPositionId = 1;
    private int feedSequenceId = 1;

    public BaiduNativeH5AdView getAdView() {
        WeakReference<BaiduNativeH5AdView> weakReference = this.mWeakAdView;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public String getApId() {
        return this.apid;
    }

    public int getPosistionId() {
        return this.feedPositionId;
    }

    public boolean getRequestStarted() {
        return this.mRequestStarted;
    }

    public a getResponse() {
        return this.mAdElementInfo;
    }

    public int getSequenceId() {
        return this.feedSequenceId;
    }

    public int getSessionId() {
        return this.feedSessionId;
    }

    public boolean hasValidResponse() {
        return this.mAdElementInfo != null && isAdAvailable();
    }

    public boolean isAdAvailable() {
        return (this.mAdElementInfo != null && ((System.currentTimeMillis() - this.mAdElementInfo.y()) > 1800000L ? 1 : ((System.currentTimeMillis() - this.mAdElementInfo.y()) == 1800000L ? 0 : -1)) <= 0) && !this.mClicked;
    }

    public boolean isAdDataLoaded() {
        BaiduNativeH5AdView adView = getAdView();
        if (adView != null) {
            return adView.isAdDataLoaded();
        }
        return false;
    }

    public boolean isWinSended() {
        return this.mWinSended;
    }

    public void setAdResponse(a aVar) {
        this.mWinSended = false;
        this.mAdElementInfo = aVar;
    }

    public void setAdView(BaiduNativeH5AdView baiduNativeH5AdView) {
        this.mWeakAdView = new WeakReference<>(baiduNativeH5AdView);
    }

    public void setApId(String str) {
        this.apid = str;
    }

    public void setAppSid(String str) {
        this.mAppsid = str;
    }

    public void setClicked(boolean z10) {
        this.mClicked = z10;
    }

    public void setPositionId(int i10) {
        if (i10 < 1) {
            return;
        }
        this.feedPositionId = i10;
    }

    public void setRequestStarted(boolean z10) {
        this.mRequestStarted = z10;
    }

    public void setSessionId(int i10) {
        if (i10 < 1) {
            return;
        }
        this.feedSessionId = i10;
        this.feedSequenceId = BaiduNativeFeedSession.getInstance().getSequenceId(i10);
    }

    public void setWinSended(boolean z10) {
        this.mWinSended = z10;
    }
}

package com.baidu.mobads.sdk.api;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.api.RequestParameters;
import com.baidu.mobads.sdk.internal.as;
import com.baidu.mobads.sdk.internal.di;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class BaiduNativeH5AdView extends RelativeLayout {
    private BaiduNativeAdPlacement mAdPlacement;
    private di mAdProd;
    private BaiduNativeH5EventListner mAdViewListener;
    private RequestParameters mRequestParameters;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public interface BaiduNativeH5EventListner {
        void onAdClick();

        void onAdDataLoaded();

        void onAdFail(String str);

        void onAdShow();
    }

    public BaiduNativeH5AdView(Context context, int i10) {
        super(context);
        this.mAdViewListener = null;
        initView(context, i10);
    }

    private void cancel() {
    }

    private void initView(Context context, int i10) {
        if (i10 != 0) {
            setBackgroundResource(i10);
        }
    }

    private void onDetach() {
        cancel();
        di diVar = this.mAdProd;
        if (diVar != null) {
            diVar.e();
        }
    }

    public BaiduNativeAdPlacement getAdPlacement() {
        return this.mAdPlacement;
    }

    public boolean isAdDataLoaded() {
        di diVar = this.mAdProd;
        if (diVar != null) {
            return diVar.g();
        }
        return false;
    }

    public void makeRequest(RequestParameters requestParameters) {
        if (requestParameters == null) {
            requestParameters = new RequestParameters.Builder().build();
        }
        this.mRequestParameters = requestParameters;
        if (this.mAdProd != null) {
            onDetach();
        }
        di diVar = new di(getContext(), IAdInterListener.AdProdType.PRODUCT_FEEDS, this);
        this.mAdProd = diVar;
        diVar.a(requestParameters);
        this.mAdProd.a(this.mAdPlacement);
        this.mAdProd.a(this.mAdPlacement.getSessionId());
        this.mAdProd.c(this.mAdPlacement.getPosistionId());
        this.mAdProd.d(this.mAdPlacement.getSequenceId());
        BaiduNativeH5EventListner baiduNativeH5EventListner = this.mAdViewListener;
        if (baiduNativeH5EventListner != null) {
            this.mAdProd.a(baiduNativeH5EventListner);
        }
        BaiduNativeAdPlacement baiduNativeAdPlacement = this.mAdPlacement;
        if (baiduNativeAdPlacement != null) {
            if (baiduNativeAdPlacement.hasValidResponse()) {
                if (this.mAdProd.f()) {
                    return;
                }
            } else {
                this.mAdProd.c(false);
                if (this.mAdPlacement.getRequestStarted()) {
                    return;
                } else {
                    this.mAdPlacement.setRequestStarted(true);
                }
            }
        }
        this.mAdProd.a();
    }

    public void recordImpression() {
        BaiduNativeAdPlacement baiduNativeAdPlacement = this.mAdPlacement;
        if (baiduNativeAdPlacement == null || baiduNativeAdPlacement.getResponse() == null || this.mAdPlacement.isWinSended()) {
            return;
        }
        this.mAdProd.a(this, this.mAdPlacement.getResponse().T());
    }

    public void setAdPlacement(BaiduNativeAdPlacement baiduNativeAdPlacement) {
        this.mAdPlacement = baiduNativeAdPlacement;
    }

    public void setAdPlacementData(Object obj) {
        BaiduNativeAdPlacement baiduNativeAdPlacement = new BaiduNativeAdPlacement();
        baiduNativeAdPlacement.setApId((String) as.a(obj, "getApId", (Class<?>[]) new Class[0], new Object[0]));
        this.mAdPlacement = baiduNativeAdPlacement;
    }

    public void setEventListener(BaiduNativeH5EventListner baiduNativeH5EventListner) {
        this.mAdViewListener = baiduNativeH5EventListner;
    }

    public BaiduNativeH5AdView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mAdViewListener = null;
        initView(context, 0);
    }

    public BaiduNativeH5AdView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.mAdViewListener = null;
        initView(context, 0);
    }
}

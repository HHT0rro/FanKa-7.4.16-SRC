package com.baidu.mobads.sdk.api;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobads.sdk.internal.ae;
import com.baidu.mobads.sdk.internal.bo;
import com.baidu.mobads.sdk.internal.bs;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class NativeCPUManager {
    private static final String TAG = "NativeCPUManager";
    private CPUAdListener mCPUAdListener;
    private ae mCPUAdProd;
    private Context mContext;
    private int mPageSize = 10;
    private HashMap<String, Object> mParams = new HashMap<>();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public interface CPUAdListener {
        void onAdError(String str, int i10);

        void onAdLoaded(List<IBasicCPUData> list);

        void onDisLikeAdClick(int i10, String str);

        void onExitLp();

        void onLpCustomEventCallBack(HashMap<String, Object> hashMap, DataPostBackListener dataPostBackListener);

        void onVideoDownloadFailed();

        void onVideoDownloadSuccess();
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public interface DataPostBackListener {
        void postback(JSONObject jSONObject);
    }

    public NativeCPUManager(Context context, String str, CPUAdListener cPUAdListener) {
        this.mCPUAdProd = null;
        if (context != null && !TextUtils.isEmpty(str)) {
            this.mCPUAdListener = cPUAdListener;
            this.mContext = context;
            ae aeVar = new ae(context, str, this);
            this.mCPUAdProd = aeVar;
            aeVar.a(cPUAdListener);
            return;
        }
        bs.a().c(TAG, "Init params error!");
        if (cPUAdListener != null) {
            cPUAdListener.onAdError("Input params error.", bo.INTERFACE_USE_PROBLEM.b());
        }
    }

    public void loadAd(int i10, int i11, boolean z10) {
        loadAd(i10, new int[]{i11}, z10);
    }

    public void openAppActivity(String str) {
        ae aeVar = this.mCPUAdProd;
        if (aeVar != null) {
            aeVar.a(str);
            this.mCPUAdProd.a();
        }
    }

    public void setPageSize(int i10) {
        if (i10 > 0 && i10 <= 20) {
            this.mPageSize = i10;
        } else {
            bs.a().c(TAG, "Input page size is wrong which should be in (0,20]!");
        }
    }

    public void setRequestParameter(CPUAdRequest cPUAdRequest) {
        if (cPUAdRequest == null || cPUAdRequest.getExtras() == null) {
            return;
        }
        this.mParams = cPUAdRequest.getExtras();
    }

    public void setRequestTimeoutMillis(int i10) {
        ae aeVar = this.mCPUAdProd;
        if (aeVar != null) {
            aeVar.a(i10);
        }
    }

    private void loadAd(int i10, int[] iArr, boolean z10) {
        if (i10 > 0 && iArr != null) {
            ae aeVar = this.mCPUAdProd;
            if (aeVar != null) {
                aeVar.a(i10, this.mPageSize, iArr, z10, this.mParams);
                this.mCPUAdProd.f();
                this.mCPUAdProd.a();
                return;
            }
            return;
        }
        bs.a().c(TAG, "LoadAd with terrible params!");
    }
}

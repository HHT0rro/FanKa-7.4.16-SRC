package com.baidu.mobads.sdk.api;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobads.sdk.internal.ak;
import com.baidu.mobads.sdk.internal.bo;
import com.baidu.mobads.sdk.internal.bs;
import java.util.HashMap;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class CPUAggregationManager {
    private static final String TAG = "CPUAggregationManager";
    private CPUAggregationListener mCPUListener;
    private Context mContext;
    private ak mNativeCpuAggregation;
    private int mPageSize = 3;
    private HashMap<String, Object> mParams = new HashMap<>();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public interface CPUAggregationListener {
        void onExitLp();

        void onHotContentError(String str, int i10);

        void onHotContentLoaded(List<IBasicCPUAggregation> list);
    }

    public CPUAggregationManager(Context context, String str, CPUAggregationListener cPUAggregationListener) {
        this.mNativeCpuAggregation = null;
        if (context != null && !TextUtils.isEmpty(str)) {
            this.mCPUListener = cPUAggregationListener;
            this.mContext = context;
            ak akVar = new ak(context, str);
            this.mNativeCpuAggregation = akVar;
            akVar.a(cPUAggregationListener);
            return;
        }
        bs.a().c(TAG, "Init params error!");
        if (cPUAggregationListener != null) {
            cPUAggregationListener.onHotContentError("Input params error.", bo.INTERFACE_USE_PROBLEM.b());
        }
    }

    public void loadAd(int i10) {
        if (i10 > 0) {
            ak akVar = this.mNativeCpuAggregation;
            if (akVar != null) {
                akVar.a(i10, this.mPageSize, this.mParams);
                this.mNativeCpuAggregation.a();
                return;
            }
            return;
        }
        bs.a().c(TAG, "Load with terrible params!");
    }

    public void setPageSize(int i10) {
        if (i10 > 0 && i10 <= 10) {
            this.mPageSize = i10;
        } else {
            bs.a().c(TAG, "Input page size is wrong which should be in (0,10]!");
        }
    }

    public void setRequestParameter(CPUAggregationRequest cPUAggregationRequest) {
        if (cPUAggregationRequest == null || cPUAggregationRequest.getExtras() == null) {
            return;
        }
        this.mParams = cPUAggregationRequest.getExtras();
    }

    public void setRequestTimeoutMillis(int i10) {
        ak akVar = this.mNativeCpuAggregation;
        if (akVar != null) {
            akVar.a(i10);
        }
    }
}

package com.baidu.mobads.sdk.api;

import android.content.Context;
import com.baidu.mobads.sdk.internal.cx;
import com.baidu.mobads.sdk.internal.cy;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class CPUManager {
    private final Context mContext;
    private CPUDramaListener mDramaListener;

    public CPUManager(Context context) {
        this.mContext = context;
    }

    public CPUComponent loadDramaContent(CPUDramaRequestParams cPUDramaRequestParams, CPUDramaListener cPUDramaListener) {
        if (cPUDramaRequestParams != null) {
            cy cyVar = new cy(this.mContext, cPUDramaRequestParams, cPUDramaListener);
            cyVar.a();
            return new cx(cyVar);
        }
        if (cPUDramaListener == null) {
            return null;
        }
        cPUDramaListener.onContentFailed(-2, "请求失败，请检查请求参数是否为空");
        return null;
    }

    public void showDramaDetailActivity(CPUDramaRequestParams cPUDramaRequestParams, CPUDramaResponse cPUDramaResponse, CPUDramaListener cPUDramaListener) {
        if (cPUDramaRequestParams != null) {
            new cy(this.mContext, cPUDramaRequestParams, cPUDramaResponse, cPUDramaListener).a();
        } else if (cPUDramaListener != null) {
            cPUDramaListener.onContentFailed(-2, "请求失败，请检查请求参数是否为空");
        }
    }
}

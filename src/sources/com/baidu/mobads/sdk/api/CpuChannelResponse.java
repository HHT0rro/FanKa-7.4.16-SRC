package com.baidu.mobads.sdk.api;

import com.baidu.mobads.sdk.internal.l;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class CpuChannelResponse {
    private l mCpuChannelInfo;

    public CpuChannelResponse(l lVar) {
        this.mCpuChannelInfo = lVar;
    }

    public int getChannelId() {
        l lVar = this.mCpuChannelInfo;
        if (lVar != null) {
            return lVar.a();
        }
        return -1;
    }

    public String getChannelName() {
        l lVar = this.mCpuChannelInfo;
        return lVar != null ? lVar.b() : "";
    }
}

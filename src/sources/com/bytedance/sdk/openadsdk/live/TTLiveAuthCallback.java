package com.bytedance.sdk.openadsdk.live;

import java.io.Serializable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public interface TTLiveAuthCallback extends Serializable {
    void onAuth(TTLiveToken tTLiveToken);

    void onFailed(Throwable th);
}

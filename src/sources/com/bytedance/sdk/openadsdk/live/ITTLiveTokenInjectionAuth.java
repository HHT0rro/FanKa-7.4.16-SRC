package com.bytedance.sdk.openadsdk.live;

import android.app.Activity;
import java.io.Serializable;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public interface ITTLiveTokenInjectionAuth extends Serializable {
    TTLiveToken getTokenInfo();

    boolean isLogin();

    void onTokenInvalid(TTLiveToken tTLiveToken, TTLiveAuthCallback tTLiveAuthCallback, Activity activity, Map<String, String> map);
}

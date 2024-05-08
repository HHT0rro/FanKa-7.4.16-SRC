package com.bytedance.sdk.openadsdk.live;

import android.os.Bundle;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public interface ILiveAdCustomConfig {
    String convertToEnterFromMerge(int i10);

    String convertToEnterMethod(int i10, boolean z10);

    Object invoke(int i10, Bundle bundle);

    void onEventV3(String str, JSONObject jSONObject);

    int openLR(String str);
}

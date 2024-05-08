package com.bytedance.sdk.openadsdk.live.core;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.android.live.base.api.ILiveHostActionParam;
import java.util.Map;
import o0.a;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class m implements ILiveHostActionParam {

    /* renamed from: m, reason: collision with root package name */
    private Bridge f11218m;

    public m(Bridge bridge) {
        this.f11218m = bridge;
    }

    @Override // com.bytedance.android.live.base.api.ILiveHostActionParam
    public void logEvent(boolean z10, String str, String str2, Map<String, String> map) {
        Bridge bridge = this.f11218m;
        if (bridge != null) {
            bridge.call(1, a.b().j(0, z10).i(1, str).i(2, str2).h(3, map).a(), null);
        }
    }
}

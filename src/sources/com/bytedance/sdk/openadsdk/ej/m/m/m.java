package com.bytedance.sdk.openadsdk.ej.m.m;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.CSJAdError;
import o0.a;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class m extends CSJAdError {

    /* renamed from: m, reason: collision with root package name */
    private final Bridge f11190m;

    public m(Bridge bridge) {
        this.f11190m = bridge == null ? a.f52239c : bridge;
    }

    @Override // com.bytedance.sdk.openadsdk.CSJAdError
    public int getCode() {
        return this.f11190m.values().intValue(263001);
    }

    @Override // com.bytedance.sdk.openadsdk.CSJAdError
    public String getMsg() {
        return (String) this.f11190m.values().objectValue(263002, String.class);
    }
}

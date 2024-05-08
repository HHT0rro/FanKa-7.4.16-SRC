package com.bytedance.sdk.openadsdk.ej.m.m;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.PersonalizationPrompt;
import o0.a;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class hc implements PersonalizationPrompt {

    /* renamed from: m, reason: collision with root package name */
    private final Bridge f11186m;

    public hc(Bridge bridge) {
        this.f11186m = bridge == null ? a.f52239c : bridge;
    }

    @Override // com.bytedance.sdk.openadsdk.PersonalizationPrompt
    public String getName() {
        return (String) this.f11186m.values().objectValue(242002, String.class);
    }

    @Override // com.bytedance.sdk.openadsdk.PersonalizationPrompt
    public String getUrl() {
        return (String) this.f11186m.values().objectValue(242001, String.class);
    }
}

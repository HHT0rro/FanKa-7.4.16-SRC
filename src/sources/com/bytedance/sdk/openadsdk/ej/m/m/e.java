package com.bytedance.sdk.openadsdk.ej.m.m;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import o0.a;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class e implements TTAdDislike {

    /* renamed from: m, reason: collision with root package name */
    private final Bridge f11184m;

    public e(Bridge bridge) {
        this.f11184m = bridge == null ? a.f52239c : bridge;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdDislike
    public boolean isShow() {
        return ((Boolean) this.f11184m.call(240105, a.c(0).a(), Boolean.TYPE)).booleanValue();
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdDislike
    public void resetDislikeStatus() {
        this.f11184m.call(240104, a.c(0).a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdDislike
    public void setDislikeInteractionCallback(TTAdDislike.DislikeInteractionCallback dislikeInteractionCallback) {
        a c4 = a.c(1);
        c4.h(0, new com.bytedance.sdk.openadsdk.n.m.m.m.m(dislikeInteractionCallback));
        this.f11184m.call(240102, c4.a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdDislike
    public void setDislikeSource(String str) {
        a c4 = a.c(1);
        c4.i(0, str);
        this.f11184m.call(240103, c4.a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdDislike
    public void showDislikeDialog() {
        this.f11184m.call(240101, a.c(0).a(), Void.class);
    }
}

package com.bytedance.sdk.openadsdk.w.m.m.m;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.TTFeedAd;
import o0.a;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class m implements TTFeedAd.CustomizeVideo {

    /* renamed from: m, reason: collision with root package name */
    private final Bridge f11418m;

    public m(Bridge bridge) {
        this.f11418m = bridge == null ? a.f52239c : bridge;
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd.CustomizeVideo
    public String getVideoUrl() {
        return (String) this.f11418m.call(162101, a.c(0).a(), String.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd.CustomizeVideo
    public void reportVideoAutoStart() {
        this.f11418m.call(162107, a.c(0).a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd.CustomizeVideo
    public void reportVideoBreak(long j10) {
        a c4 = a.c(1);
        c4.g(0, j10);
        this.f11418m.call(162106, c4.a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd.CustomizeVideo
    public void reportVideoContinue(long j10) {
        a c4 = a.c(1);
        c4.g(0, j10);
        this.f11418m.call(162104, c4.a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd.CustomizeVideo
    public void reportVideoError(long j10, int i10, int i11) {
        a c4 = a.c(3);
        c4.g(0, j10);
        c4.f(1, i10);
        c4.f(2, i11);
        this.f11418m.call(162109, c4.a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd.CustomizeVideo
    public void reportVideoFinish() {
        this.f11418m.call(162105, a.c(0).a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd.CustomizeVideo
    public void reportVideoPause(long j10) {
        a c4 = a.c(1);
        c4.g(0, j10);
        this.f11418m.call(162103, c4.a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd.CustomizeVideo
    public void reportVideoStart() {
        this.f11418m.call(162102, a.c(0).a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd.CustomizeVideo
    public void reportVideoStartError(int i10, int i11) {
        a c4 = a.c(2);
        c4.f(0, i10);
        c4.f(1, i11);
        this.f11418m.call(162108, c4.a(), Void.class);
    }
}

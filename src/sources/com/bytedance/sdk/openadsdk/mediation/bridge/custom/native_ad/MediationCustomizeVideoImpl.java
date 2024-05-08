package com.bytedance.sdk.openadsdk.mediation.bridge.custom.native_ad;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTFeedAd;
import com.bytedance.sdk.openadsdk.mediation.bridge.IMediationCustomizeVideo;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class MediationCustomizeVideoImpl implements Bridge, IMediationCustomizeVideo {

    /* renamed from: m, reason: collision with root package name */
    private TTFeedAd.CustomizeVideo f11315m;

    public MediationCustomizeVideoImpl(TTFeedAd.CustomizeVideo customizeVideo) {
        this.f11315m = customizeVideo;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i10, ValueSet valueSet, Class<T> cls) {
        if (i10 == 8165) {
            reportVideoStart();
            return null;
        }
        if (i10 == 8168) {
            reportVideoFinish();
            return null;
        }
        if (i10 == 8166) {
            reportVideoPause(valueSet.longValue(8074));
            return null;
        }
        if (i10 == 8167) {
            reportVideoContinue(valueSet.longValue(8074));
            return null;
        }
        if (i10 == 8169) {
            reportVideoBreak(valueSet.longValue(8074));
            return null;
        }
        if (i10 == 8170) {
            reportVideoAutoStart();
            return null;
        }
        if (i10 == 8171) {
            reportVideoStartError(valueSet.intValue(8014), valueSet.intValue(8075));
            return null;
        }
        if (i10 != 8172) {
            return null;
        }
        reportVideoError(valueSet.longValue(8074), valueSet.intValue(8014), valueSet.intValue(8075));
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.IMediationCustomizeVideo
    public String getVideoUrl() {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.IMediationCustomizeVideo
    public void reportVideoAutoStart() {
        TTFeedAd.CustomizeVideo customizeVideo = this.f11315m;
        if (customizeVideo != null) {
            customizeVideo.reportVideoAutoStart();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.IMediationCustomizeVideo
    public void reportVideoBreak(long j10) {
        TTFeedAd.CustomizeVideo customizeVideo = this.f11315m;
        if (customizeVideo != null) {
            customizeVideo.reportVideoBreak(j10);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.IMediationCustomizeVideo
    public void reportVideoContinue(long j10) {
        TTFeedAd.CustomizeVideo customizeVideo = this.f11315m;
        if (customizeVideo != null) {
            customizeVideo.reportVideoContinue(j10);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.IMediationCustomizeVideo
    public void reportVideoError(long j10, int i10, int i11) {
        TTFeedAd.CustomizeVideo customizeVideo = this.f11315m;
        if (customizeVideo != null) {
            customizeVideo.reportVideoError(j10, i10, i11);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.IMediationCustomizeVideo
    public void reportVideoFinish() {
        TTFeedAd.CustomizeVideo customizeVideo = this.f11315m;
        if (customizeVideo != null) {
            customizeVideo.reportVideoFinish();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.IMediationCustomizeVideo
    public void reportVideoPause(long j10) {
        TTFeedAd.CustomizeVideo customizeVideo = this.f11315m;
        if (customizeVideo != null) {
            customizeVideo.reportVideoPause(j10);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.IMediationCustomizeVideo
    public void reportVideoStart() {
        TTFeedAd.CustomizeVideo customizeVideo = this.f11315m;
        if (customizeVideo != null) {
            customizeVideo.reportVideoStart();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.IMediationCustomizeVideo
    public void reportVideoStartError(int i10, int i11) {
        TTFeedAd.CustomizeVideo customizeVideo = this.f11315m;
        if (customizeVideo != null) {
            customizeVideo.reportVideoStartError(i10, i11);
        }
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return null;
    }
}

package com.bytedance.sdk.openadsdk.w.m.m.dk;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTFeedAd;
import com.bytedance.sdk.openadsdk.ej.m.m.c;
import o0.a;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class m implements Bridge {
    private final TTFeedAd.VideoAdListener dk;

    /* renamed from: m, reason: collision with root package name */
    private ValueSet f11417m = a.f52238b;

    public m(TTFeedAd.VideoAdListener videoAdListener) {
        this.dk = videoAdListener;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i10, ValueSet valueSet, Class<T> cls) {
        if (this.dk == null) {
            return null;
        }
        switch (i10) {
            case 161101:
                this.dk.onVideoLoad(new c((Bridge) valueSet.objectValue(0, Bridge.class)));
                break;
            case 161102:
                this.dk.onVideoError(valueSet.intValue(0), valueSet.intValue(1));
                break;
            case 161103:
                this.dk.onVideoAdPaused(new c((Bridge) valueSet.objectValue(0, Bridge.class)));
                break;
            case 161104:
                this.dk.onVideoAdStartPlay(new c((Bridge) valueSet.objectValue(0, Bridge.class)));
                break;
            case 161105:
                this.dk.onVideoAdContinuePlay(new c((Bridge) valueSet.objectValue(0, Bridge.class)));
                break;
            case 161106:
                this.dk.onProgressUpdate(valueSet.longValue(0), valueSet.longValue(1));
                break;
            case 161107:
                this.dk.onVideoAdComplete(new c((Bridge) valueSet.objectValue(0, Bridge.class)));
                break;
        }
        m(i10, valueSet, cls);
        return null;
    }

    public void m(int i10, ValueSet valueSet, Class cls) {
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return this.f11417m;
    }
}

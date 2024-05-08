package com.bytedance.sdk.openadsdk.c.m.m.m;

import android.view.View;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import com.bytedance.sdk.openadsdk.ej.m.m.r;
import o0.a;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class m implements Bridge {
    private final TTNativeAd.AdInteractionListener dk;

    /* renamed from: m, reason: collision with root package name */
    private ValueSet f11137m = a.f52238b;

    public m(TTNativeAd.AdInteractionListener adInteractionListener) {
        this.dk = adInteractionListener;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i10, ValueSet valueSet, Class<T> cls) {
        if (this.dk == null) {
            return null;
        }
        switch (i10) {
            case 141101:
                this.dk.onAdClicked((View) valueSet.objectValue(0, View.class), new r((Bridge) valueSet.objectValue(1, Bridge.class)));
                break;
            case 141102:
                this.dk.onAdCreativeClick((View) valueSet.objectValue(0, View.class), new r((Bridge) valueSet.objectValue(1, Bridge.class)));
                break;
            case 141103:
                this.dk.onAdShow(new r((Bridge) valueSet.objectValue(0, Bridge.class)));
                break;
        }
        m(i10, valueSet, cls);
        return null;
    }

    public void m(int i10, ValueSet valueSet, Class cls) {
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return this.f11137m;
    }
}

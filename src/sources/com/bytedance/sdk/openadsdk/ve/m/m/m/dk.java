package com.bytedance.sdk.openadsdk.ve.m.m.m;

import android.view.View;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import o0.a;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class dk implements Bridge {
    private final TTNativeExpressAd.ExpressAdInteractionListener dk;

    /* renamed from: m, reason: collision with root package name */
    private ValueSet f11413m = a.f52238b;

    public dk(TTNativeExpressAd.ExpressAdInteractionListener expressAdInteractionListener) {
        this.dk = expressAdInteractionListener;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i10, ValueSet valueSet, Class<T> cls) {
        if (this.dk == null) {
            return null;
        }
        switch (i10) {
            case 151101:
                this.dk.onAdClicked((View) valueSet.objectValue(0, View.class), valueSet.intValue(1));
                break;
            case 151102:
                this.dk.onAdShow((View) valueSet.objectValue(0, View.class), valueSet.intValue(1));
                break;
            case 151103:
                this.dk.onRenderFail((View) valueSet.objectValue(0, View.class), (String) valueSet.objectValue(1, String.class), valueSet.intValue(2));
                break;
            case 151104:
                this.dk.onRenderSuccess((View) valueSet.objectValue(0, View.class), valueSet.floatValue(1), valueSet.floatValue(2));
                break;
        }
        m(i10, valueSet, cls);
        return null;
    }

    public void m(int i10, ValueSet valueSet, Class cls) {
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return this.f11413m;
    }
}

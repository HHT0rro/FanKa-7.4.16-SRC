package com.bytedance.sdk.openadsdk.mediation.ad.m.m.dk;

import android.view.View;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.ad.MediationExpressRenderListener;
import o0.a;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class n implements Bridge {
    private final MediationExpressRenderListener dk;

    /* renamed from: m, reason: collision with root package name */
    private ValueSet f11286m = a.f52238b;

    public n(MediationExpressRenderListener mediationExpressRenderListener) {
        this.dk = mediationExpressRenderListener;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i10, ValueSet valueSet, Class<T> cls) {
        MediationExpressRenderListener mediationExpressRenderListener = this.dk;
        if (mediationExpressRenderListener == null) {
            return null;
        }
        switch (i10) {
            case 142101:
                this.dk.onRenderSuccess((View) valueSet.objectValue(0, View.class), valueSet.floatValue(1), valueSet.floatValue(2), valueSet.booleanValue(3));
                break;
            case 142102:
                this.dk.onRenderFail((View) valueSet.objectValue(0, View.class), (String) valueSet.objectValue(1, String.class), valueSet.intValue(2));
                break;
            case 142103:
                mediationExpressRenderListener.onAdClick();
                break;
            case 142104:
                mediationExpressRenderListener.onAdShow();
                break;
        }
        m(i10, valueSet, cls);
        return null;
    }

    public void m(int i10, ValueSet valueSet, Class cls) {
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return this.f11286m;
    }
}

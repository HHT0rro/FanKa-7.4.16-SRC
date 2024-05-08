package com.bytedance.sdk.openadsdk.mediation;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.ad.IMediationDislikeCallback;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class MediationDislikeCallbackImpl implements Bridge, IMediationDislikeCallback {

    /* renamed from: m, reason: collision with root package name */
    private IMediationDislikeCallback f11233m;

    public MediationDislikeCallbackImpl(IMediationDislikeCallback iMediationDislikeCallback) {
        this.f11233m = iMediationDislikeCallback;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i10, ValueSet valueSet, Class<T> cls) {
        if (i10 == 8188) {
            onSelected(valueSet.intValue(8038), valueSet.stringValue(8039));
            return null;
        }
        if (i10 == 8189) {
            onCancel();
            return null;
        }
        if (i10 != 8190) {
            return null;
        }
        onShow();
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationDislikeCallback
    public void onCancel() {
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationDislikeCallback
    public void onSelected(int i10, String str) {
        IMediationDislikeCallback iMediationDislikeCallback = this.f11233m;
        if (iMediationDislikeCallback != null) {
            iMediationDislikeCallback.onSelected(i10, str);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationDislikeCallback
    public void onShow() {
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return null;
    }
}

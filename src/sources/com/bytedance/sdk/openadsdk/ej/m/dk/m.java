package com.bytedance.sdk.openadsdk.ej.m.dk;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import o0.a;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class m implements Bridge {
    private final TTAppDownloadListener dk;

    /* renamed from: m, reason: collision with root package name */
    private ValueSet f11164m = a.f52238b;

    public m(TTAppDownloadListener tTAppDownloadListener) {
        this.dk = tTAppDownloadListener;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i10, ValueSet valueSet, Class<T> cls) {
        TTAppDownloadListener tTAppDownloadListener = this.dk;
        if (tTAppDownloadListener == null) {
            return null;
        }
        switch (i10) {
            case 221101:
                tTAppDownloadListener.onIdle();
                break;
            case 221102:
                this.dk.onDownloadActive(valueSet.longValue(0), valueSet.longValue(1), (String) valueSet.objectValue(2, String.class), (String) valueSet.objectValue(3, String.class));
                break;
            case 221103:
                this.dk.onDownloadPaused(valueSet.longValue(0), valueSet.longValue(1), (String) valueSet.objectValue(2, String.class), (String) valueSet.objectValue(3, String.class));
                break;
            case 221104:
                this.dk.onDownloadFailed(valueSet.longValue(0), valueSet.longValue(1), (String) valueSet.objectValue(2, String.class), (String) valueSet.objectValue(3, String.class));
                break;
            case 221105:
                this.dk.onDownloadFinished(valueSet.longValue(0), (String) valueSet.objectValue(1, String.class), (String) valueSet.objectValue(2, String.class));
                break;
            case 221106:
                this.dk.onInstalled((String) valueSet.objectValue(0, String.class), (String) valueSet.objectValue(1, String.class));
                break;
        }
        m(i10, valueSet, cls);
        return null;
    }

    public void m(int i10, ValueSet valueSet, Class cls) {
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return this.f11164m;
    }
}

package com.bytedance.sdk.openadsdk.api;

import com.bykv.vk.openvk.api.proto.EventListener;
import com.bykv.vk.openvk.api.proto.Result;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class dk {

    /* renamed from: m, reason: collision with root package name */
    public EventListener f11074m;

    public void m(int i10, Result result) {
        if (m()) {
            return;
        }
        this.f11074m.onEvent(i10, result);
    }

    public void m(int i10) {
        m(i10, null);
    }

    public boolean m() {
        return this.f11074m == null;
    }
}

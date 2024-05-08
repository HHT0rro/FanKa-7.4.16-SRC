package com.bytedance.sdk.openadsdk.mediation;

import android.os.Bundle;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.TTAdManager;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.mediation.m.m.hc;
import com.bytedance.sdk.openadsdk.mediation.m.m.m.dk;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class MediationManagerVisitor {
    private static volatile Bridge dk;

    /* renamed from: m, reason: collision with root package name */
    private static volatile MediationManagerVisitor f11235m;
    private dk ej;

    private MediationManagerVisitor() {
        if (dk == null) {
            Bundle bundle = new Bundle();
            bundle.putString("mediation_manager", "mediation_manager");
            TTAdManager adManager = TTAdSdk.getAdManager();
            if (adManager != null) {
                dk = (Bridge) adManager.getExtra(null, bundle);
            }
        }
    }

    public static MediationManagerVisitor getInstance() {
        if (f11235m == null) {
            synchronized (MediationManagerVisitor.class) {
                if (f11235m == null) {
                    f11235m = new MediationManagerVisitor();
                }
            }
        }
        return f11235m;
    }

    public IMediationManager getMediationManager() {
        if (dk == null) {
            return null;
        }
        if (this.ej == null) {
            this.ej = new hc(dk);
        }
        return this.ej;
    }
}

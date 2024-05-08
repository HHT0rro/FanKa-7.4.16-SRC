package com.bytedance.sdk.openadsdk.mediation.m.m;

import android.app.Activity;
import android.content.Context;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTCustomController;
import com.bytedance.sdk.openadsdk.mediation.IMediationDrawAdTokenCallback;
import com.bytedance.sdk.openadsdk.mediation.IMediationNativeAdTokenCallback;
import com.bytedance.sdk.openadsdk.mediation.IMediationPreloadRequestInfo;
import com.bytedance.sdk.openadsdk.mediation.bridge.MediationAdClassLoader;
import com.bytedance.sdk.openadsdk.mediation.init.MediationConfigUserInfoForSegment;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import o0.a;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class hc extends com.bytedance.sdk.openadsdk.mediation.m.m.m.dk {

    /* renamed from: m, reason: collision with root package name */
    private Bridge f11378m;

    public hc(Bridge bridge) {
        super(bridge);
        this.f11378m = bridge;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.m.m.m.dk, com.bytedance.sdk.openadsdk.mediation.IMediationManager
    public void loadDrawToken(Context context, AdSlot adSlot, IMediationDrawAdTokenCallback iMediationDrawAdTokenCallback) {
        if (this.f11378m != null) {
            a c4 = a.c(3);
            c4.h(0, context);
            c4.h(1, com.bytedance.sdk.openadsdk.ej.m.ej.dk.dk(adSlot));
            c4.h(2, new com.bytedance.sdk.openadsdk.mediation.m.m.dk.m(iMediationDrawAdTokenCallback));
            c4.h(3, MediationAdClassLoader.getInstance());
            this.f11378m.call(270022, c4.a(), Void.class);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.m.m.m.dk, com.bytedance.sdk.openadsdk.mediation.IMediationManager
    public void loadNativeToken(Context context, AdSlot adSlot, IMediationNativeAdTokenCallback iMediationNativeAdTokenCallback) {
        if (this.f11378m != null) {
            a c4 = a.c(3);
            c4.h(0, context);
            c4.h(1, com.bytedance.sdk.openadsdk.ej.m.ej.dk.dk(adSlot));
            c4.h(2, new com.bytedance.sdk.openadsdk.mediation.m.m.dk.ej(iMediationNativeAdTokenCallback));
            c4.h(3, MediationAdClassLoader.getInstance());
            this.f11378m.call(270021, c4.a(), Void.class);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.m.m.m.dk, com.bytedance.sdk.openadsdk.mediation.IMediationManager
    public void preload(Activity activity, List<IMediationPreloadRequestInfo> list, int i10, int i11) {
        if (this.f11378m != null) {
            a c4 = a.c(4);
            c4.h(0, activity);
            if (list != null) {
                LinkedList linkedList = new LinkedList();
                Iterator<IMediationPreloadRequestInfo> iterator2 = list.iterator2();
                while (iterator2.hasNext()) {
                    linkedList.add(new e(iterator2.next()));
                }
                c4.h(1, linkedList);
            }
            c4.f(2, i10);
            c4.f(3, i11);
            c4.h(4, MediationAdClassLoader.getInstance());
            this.f11378m.call(270013, c4.a(), Void.class);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.m.m.m.dk, com.bytedance.sdk.openadsdk.mediation.IMediationManager
    public void setUserInfoForSegment(MediationConfigUserInfoForSegment mediationConfigUserInfoForSegment) {
        if (this.f11378m != null) {
            a c4 = a.c(1);
            c4.h(0, com.bytedance.sdk.openadsdk.mediation.init.m.m.m.ej.m(mediationConfigUserInfoForSegment));
            this.f11378m.call(270014, c4.a(), Void.class);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.m.m.m.dk, com.bytedance.sdk.openadsdk.mediation.IMediationManager
    public void updatePrivacyConfig(TTCustomController tTCustomController) {
        if (this.f11378m != null) {
            a c4 = a.c(1);
            c4.h(0, com.bytedance.sdk.openadsdk.ej.m.ej.l.m(tTCustomController));
            this.f11378m.call(270016, c4.a(), Void.class);
        }
    }
}

package com.bytedance.sdk.openadsdk.mediation.manager.m.m.m;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.mediation.ad.MediationShakeViewListener;
import com.bytedance.sdk.openadsdk.mediation.ad.m.m.dk.hc;
import com.bytedance.sdk.openadsdk.mediation.manager.MediationAdEcpmInfo;
import com.bytedance.sdk.openadsdk.mediation.manager.MediationAdLoadInfo;
import com.bytedance.sdk.openadsdk.mediation.manager.MediationNativeManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import o0.a;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class l implements MediationNativeManager {

    /* renamed from: m, reason: collision with root package name */
    private final Bridge f11401m;

    public l(Bridge bridge) {
        this.f11401m = bridge == null ? a.f52239c : bridge;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationBaseManager
    public List<MediationAdLoadInfo> getAdLoadInfo() {
        Iterable iterable = (List) this.f11401m.call(270002, a.c(0).a(), List.class);
        if (iterable == null) {
            iterable = new ArrayList(0);
        }
        ArrayList arrayList = new ArrayList();
        Iterator iterator2 = iterable.iterator2();
        while (iterator2.hasNext()) {
            arrayList.add(new dk((Bridge) iterator2.next()));
        }
        return arrayList;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationBaseManager
    public MediationAdEcpmInfo getBestEcpm() {
        return new m((Bridge) this.f11401m.call(270004, a.c(0).a(), Bridge.class));
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationBaseManager
    public List<MediationAdEcpmInfo> getCacheList() {
        Iterable iterable = (List) this.f11401m.call(270005, a.c(0).a(), List.class);
        if (iterable == null) {
            iterable = new ArrayList(0);
        }
        ArrayList arrayList = new ArrayList();
        Iterator iterator2 = iterable.iterator2();
        while (iterator2.hasNext()) {
            arrayList.add(new m((Bridge) iterator2.next()));
        }
        return arrayList;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationBaseManager
    public List<MediationAdEcpmInfo> getMultiBiddingEcpm() {
        Iterable iterable = (List) this.f11401m.call(270003, a.c(0).a(), List.class);
        if (iterable == null) {
            iterable = new ArrayList(0);
        }
        ArrayList arrayList = new ArrayList();
        Iterator iterator2 = iterable.iterator2();
        while (iterator2.hasNext()) {
            arrayList.add(new m((Bridge) iterator2.next()));
        }
        return arrayList;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationBaseManager
    public MediationAdEcpmInfo getShowEcpm() {
        return new m((Bridge) this.f11401m.call(270006, a.c(0).a(), Bridge.class));
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationNativeManager
    public boolean hasDislike() {
        return this.f11401m.values().booleanValue(270008);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationNativeManager
    public boolean isExpress() {
        return this.f11401m.values().booleanValue(270011);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationBaseManager
    public boolean isReady() {
        return ((Boolean) this.f11401m.call(270001, a.c(0).a(), Boolean.TYPE)).booleanValue();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationNativeManager
    public void setShakeViewListener(MediationShakeViewListener mediationShakeViewListener) {
        a c4 = a.c(1);
        c4.h(0, new hc(mediationShakeViewListener));
        this.f11401m.call(270010, c4.a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationNativeManager
    public void setUseCustomVideo(boolean z10) {
        a c4 = a.c(1);
        c4.j(0, z10);
        this.f11401m.call(270009, c4.a(), Void.class);
    }
}

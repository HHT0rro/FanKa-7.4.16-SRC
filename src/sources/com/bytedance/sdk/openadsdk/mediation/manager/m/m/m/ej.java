package com.bytedance.sdk.openadsdk.mediation.manager.m.m.m;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.mediation.manager.MediationAdEcpmInfo;
import com.bytedance.sdk.openadsdk.mediation.manager.MediationAdLoadInfo;
import com.bytedance.sdk.openadsdk.mediation.manager.MediationFullScreenManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import o0.a;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class ej implements MediationFullScreenManager {

    /* renamed from: m, reason: collision with root package name */
    private final Bridge f11400m;

    public ej(Bridge bridge) {
        this.f11400m = bridge == null ? a.f52239c : bridge;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationFullScreenManager
    public void destroy() {
        this.f11400m.call(270007, a.c(0).a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationBaseManager
    public List<MediationAdLoadInfo> getAdLoadInfo() {
        Iterable iterable = (List) this.f11400m.call(270002, a.c(0).a(), List.class);
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
        return new m((Bridge) this.f11400m.call(270004, a.c(0).a(), Bridge.class));
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationBaseManager
    public List<MediationAdEcpmInfo> getCacheList() {
        Iterable iterable = (List) this.f11400m.call(270005, a.c(0).a(), List.class);
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
        Iterable iterable = (List) this.f11400m.call(270003, a.c(0).a(), List.class);
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
        return new m((Bridge) this.f11400m.call(270006, a.c(0).a(), Bridge.class));
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationBaseManager
    public boolean isReady() {
        return ((Boolean) this.f11400m.call(270001, a.c(0).a(), Boolean.TYPE)).booleanValue();
    }
}

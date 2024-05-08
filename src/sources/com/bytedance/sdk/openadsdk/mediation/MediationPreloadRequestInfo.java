package com.bytedance.sdk.openadsdk.mediation;

import com.bytedance.sdk.openadsdk.AdSlot;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class MediationPreloadRequestInfo implements IMediationPreloadRequestInfo {
    private AdSlot dk;
    private List<String> ej;

    /* renamed from: m, reason: collision with root package name */
    private int f11236m;

    public MediationPreloadRequestInfo(int i10, AdSlot adSlot, List<String> list) {
        this.f11236m = i10;
        this.dk = adSlot;
        this.ej = list;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.IMediationPreloadRequestInfo
    public AdSlot getAdSlot() {
        return this.dk;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.IMediationPreloadRequestInfo
    public int getAdType() {
        return this.f11236m;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.IMediationPreloadRequestInfo
    public List<String> getPrimeRitList() {
        return this.ej;
    }
}

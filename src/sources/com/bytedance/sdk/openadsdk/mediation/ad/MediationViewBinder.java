package com.bytedance.sdk.openadsdk.mediation.ad;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class MediationViewBinder implements IMediationViewBinder {
    public final int callToActionId;
    public final int decriptionTextId;
    public final Map<String, Integer> extras;
    public final int groupImage1Id;
    public final int groupImage2Id;
    public final int groupImage3Id;
    public final int iconImageId;
    public final int layoutId;
    public final int logoLayoutId;
    public final int mainImageId;
    public final int mediaViewId;
    public final int shakeViewContainerId;
    public final int sourceId;
    public final int titleId;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static class Builder {

        /* renamed from: c, reason: collision with root package name */
        public int f11272c;
        public int dk;

        /* renamed from: e, reason: collision with root package name */
        public int f11273e;
        public int ej;

        /* renamed from: hc, reason: collision with root package name */
        public int f11274hc;

        /* renamed from: l, reason: collision with root package name */
        public int f11275l;

        /* renamed from: m, reason: collision with root package name */
        public int f11276m;

        /* renamed from: n, reason: collision with root package name */
        public int f11277n;
        public int np;

        /* renamed from: oa, reason: collision with root package name */
        public int f11278oa;

        /* renamed from: r, reason: collision with root package name */
        public Map<String, Integer> f11279r;
        public int sy;
        public int ve;

        /* renamed from: w, reason: collision with root package name */
        public int f11280w;

        public Builder(int i10) {
            this.f11279r = Collections.emptyMap();
            this.f11276m = i10;
            this.f11279r = new HashMap();
        }

        public Builder addExtra(String str, int i10) {
            this.f11279r.put(str, Integer.valueOf(i10));
            return this;
        }

        public Builder addExtras(Map<String, Integer> map) {
            this.f11279r = new HashMap(map);
            return this;
        }

        public MediationViewBinder build() {
            return new MediationViewBinder(this);
        }

        public Builder callToActionId(int i10) {
            this.f11275l = i10;
            return this;
        }

        public Builder descriptionTextId(int i10) {
            this.ej = i10;
            return this;
        }

        public Builder groupImage1Id(int i10) {
            this.f11278oa = i10;
            return this;
        }

        public Builder groupImage2Id(int i10) {
            this.f11272c = i10;
            return this;
        }

        public Builder groupImage3Id(int i10) {
            this.ve = i10;
            return this;
        }

        public Builder iconImageId(int i10) {
            this.np = i10;
            return this;
        }

        public Builder logoLayoutId(int i10) {
            this.f11280w = i10;
            return this;
        }

        public Builder mainImageId(int i10) {
            this.f11277n = i10;
            return this;
        }

        public Builder mediaViewIdId(int i10) {
            this.f11274hc = i10;
            return this;
        }

        public Builder shakeViewContainerId(int i10) {
            this.sy = i10;
            return this;
        }

        public Builder sourceId(int i10) {
            this.f11273e = i10;
            return this;
        }

        public Builder titleId(int i10) {
            this.dk = i10;
            return this;
        }
    }

    public MediationViewBinder(Builder builder) {
        this.layoutId = builder.f11276m;
        this.titleId = builder.dk;
        this.decriptionTextId = builder.ej;
        this.callToActionId = builder.f11275l;
        this.iconImageId = builder.np;
        this.mainImageId = builder.f11277n;
        this.mediaViewId = builder.f11274hc;
        this.sourceId = builder.f11273e;
        this.extras = builder.f11279r;
        this.groupImage1Id = builder.f11278oa;
        this.groupImage2Id = builder.f11272c;
        this.groupImage3Id = builder.ve;
        this.logoLayoutId = builder.f11280w;
        this.shakeViewContainerId = builder.sy;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinder
    public int getCallToActionId() {
        return this.callToActionId;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinder
    public int getDecriptionTextId() {
        return this.decriptionTextId;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinder
    public Map<String, Integer> getExtras() {
        return this.extras;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinder
    public int getGroupImage1Id() {
        return this.groupImage1Id;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinder
    public int getGroupImage2Id() {
        return this.groupImage2Id;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinder
    public int getGroupImage3Id() {
        return this.groupImage3Id;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinder
    public int getIconImageId() {
        return this.iconImageId;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinder
    public int getLayoutId() {
        return this.layoutId;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinder
    public int getLogoLayoutId() {
        return this.logoLayoutId;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinder
    public int getMainImageId() {
        return this.mainImageId;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinder
    public int getMediaViewId() {
        return this.mediaViewId;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinder
    public int getShakeViewContainerId() {
        return this.shakeViewContainerId;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinder
    public int getSourceId() {
        return this.sourceId;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinder
    public int getTitleId() {
        return this.titleId;
    }
}

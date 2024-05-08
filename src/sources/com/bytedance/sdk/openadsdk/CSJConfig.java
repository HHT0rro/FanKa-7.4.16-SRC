package com.bytedance.sdk.openadsdk;

import com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig;
import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class CSJConfig implements AdConfig {

    /* renamed from: c, reason: collision with root package name */
    private boolean f11038c;
    private String dk;

    /* renamed from: e, reason: collision with root package name */
    private boolean f11039e;
    private boolean ej;

    /* renamed from: f, reason: collision with root package name */
    private IMediationConfig f11040f;

    /* renamed from: hc, reason: collision with root package name */
    private boolean f11041hc;

    /* renamed from: k, reason: collision with root package name */
    private int f11042k;

    /* renamed from: l, reason: collision with root package name */
    private String f11043l;

    /* renamed from: m, reason: collision with root package name */
    private String f11044m;

    /* renamed from: n, reason: collision with root package name */
    private int f11045n;
    private String np;

    /* renamed from: oa, reason: collision with root package name */
    private boolean f11046oa;

    /* renamed from: q, reason: collision with root package name */
    private int f11047q;

    /* renamed from: r, reason: collision with root package name */
    private int f11048r;
    private TTCustomController sy;

    /* renamed from: t, reason: collision with root package name */
    private boolean f11049t;
    private Map<String, Object> ve = new HashMap();

    /* renamed from: w, reason: collision with root package name */
    private int[] f11050w;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static class m {
        private String dk;

        /* renamed from: k, reason: collision with root package name */
        private boolean f11054k;

        /* renamed from: l, reason: collision with root package name */
        private String f11055l;

        /* renamed from: m, reason: collision with root package name */
        private String f11056m;
        private String np;
        private int sy;

        /* renamed from: t, reason: collision with root package name */
        private IMediationConfig f11061t;
        private TTCustomController ve;

        /* renamed from: w, reason: collision with root package name */
        private int[] f11062w;
        private boolean ej = false;

        /* renamed from: n, reason: collision with root package name */
        private int f11057n = 0;

        /* renamed from: hc, reason: collision with root package name */
        private boolean f11053hc = true;

        /* renamed from: e, reason: collision with root package name */
        private boolean f11052e = false;

        /* renamed from: oa, reason: collision with root package name */
        private boolean f11058oa = true;

        /* renamed from: c, reason: collision with root package name */
        private boolean f11051c = false;

        /* renamed from: r, reason: collision with root package name */
        private int f11060r = 2;

        /* renamed from: q, reason: collision with root package name */
        private int f11059q = 0;

        public m dk(String str) {
            this.dk = str;
            return this;
        }

        public m ej(String str) {
            this.f11055l = str;
            return this;
        }

        public m l(String str) {
            this.np = str;
            return this;
        }

        public m m(String str) {
            this.f11056m = str;
            return this;
        }

        public m n(boolean z10) {
            this.f11054k = z10;
            return this;
        }

        public m np(boolean z10) {
            this.f11051c = z10;
            return this;
        }

        public m dk(boolean z10) {
            this.f11053hc = z10;
            return this;
        }

        public m ej(boolean z10) {
            this.f11052e = z10;
            return this;
        }

        public m l(boolean z10) {
            this.f11058oa = z10;
            return this;
        }

        public m m(boolean z10) {
            this.ej = z10;
            return this;
        }

        public m dk(int i10) {
            this.sy = i10;
            return this;
        }

        public m ej(int i10) {
            this.f11060r = i10;
            return this;
        }

        public m l(int i10) {
            this.f11059q = i10;
            return this;
        }

        public m m(int i10) {
            this.f11057n = i10;
            return this;
        }

        public m m(int... iArr) {
            this.f11062w = iArr;
            return this;
        }

        public m m(TTCustomController tTCustomController) {
            this.ve = tTCustomController;
            return this;
        }

        public m m(IMediationConfig iMediationConfig) {
            this.f11061t = iMediationConfig;
            return this;
        }
    }

    public CSJConfig(m mVar) {
        this.ej = false;
        this.f11045n = 0;
        this.f11041hc = true;
        this.f11039e = false;
        this.f11046oa = true;
        this.f11038c = false;
        this.f11044m = mVar.f11056m;
        this.dk = mVar.dk;
        this.ej = mVar.ej;
        this.f11043l = mVar.f11055l;
        this.np = mVar.np;
        this.f11045n = mVar.f11057n;
        this.f11041hc = mVar.f11053hc;
        this.f11039e = mVar.f11052e;
        this.f11050w = mVar.f11062w;
        this.f11046oa = mVar.f11058oa;
        this.f11038c = mVar.f11051c;
        this.sy = mVar.ve;
        this.f11048r = mVar.sy;
        this.f11042k = mVar.f11059q;
        this.f11047q = mVar.f11060r;
        this.f11049t = mVar.f11054k;
        this.f11040f = mVar.f11061t;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public int getAgeGroup() {
        return this.f11042k;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public String getAppId() {
        return this.f11044m;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public String getAppName() {
        return this.dk;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public TTCustomController getCustomController() {
        return this.sy;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public String getData() {
        return this.np;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public int[] getDirectDownloadNetworkType() {
        return this.f11050w;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    @Deprecated
    public Object getExtra(String str) {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public String getKeywords() {
        return this.f11043l;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public IMediationConfig getMediationConfig() {
        return this.f11040f;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public int getPluginUpdateConfig() {
        return this.f11047q;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public int getThemeStatus() {
        return this.f11048r;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public int getTitleBarTheme() {
        return this.f11045n;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public boolean isAllowShowNotify() {
        return this.f11041hc;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public boolean isDebug() {
        return this.f11039e;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public boolean isPaid() {
        return this.ej;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public boolean isSupportMultiProcess() {
        return this.f11038c;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public boolean isUseMediation() {
        return this.f11049t;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public boolean isUseTextureView() {
        return this.f11046oa;
    }

    public void setAgeGroup(int i10) {
        this.f11042k = i10;
    }

    public void setAllowShowNotify(boolean z10) {
        this.f11041hc = z10;
    }

    public void setAppId(String str) {
        this.f11044m = str;
    }

    public void setAppName(String str) {
        this.dk = str;
    }

    public void setCustomController(TTCustomController tTCustomController) {
        this.sy = tTCustomController;
    }

    public void setData(String str) {
        this.np = str;
    }

    public void setDebug(boolean z10) {
        this.f11039e = z10;
    }

    public void setDirectDownloadNetworkType(int... iArr) {
        this.f11050w = iArr;
    }

    public void setKeywords(String str) {
        this.f11043l = str;
    }

    public void setPaid(boolean z10) {
        this.ej = z10;
    }

    public void setSupportMultiProcess(boolean z10) {
        this.f11038c = z10;
    }

    public void setThemeStatus(int i10) {
        this.f11048r = i10;
    }

    public void setTitleBarTheme(int i10) {
        this.f11045n = i10;
    }

    public void setUseTextureView(boolean z10) {
        this.f11046oa = z10;
    }
}

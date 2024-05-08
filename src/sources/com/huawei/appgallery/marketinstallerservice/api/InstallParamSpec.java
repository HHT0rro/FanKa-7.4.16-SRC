package com.huawei.appgallery.marketinstallerservice.api;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class InstallParamSpec extends BaseParamSpec {
    public static final int FAIL_RESULT_DIALOG = 2;
    public static final int FAIL_RESULT_NOTHING = 1;
    public static final int FAIL_RESULT_TOAST = 0;

    /* renamed from: e, reason: collision with root package name */
    public MarketInfo f27613e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f27614f = false;

    /* renamed from: g, reason: collision with root package name */
    public int f27615g = 0;

    public int getFailResultPromptType() {
        return this.f27615g;
    }

    public MarketInfo getMarketInfo() {
        return this.f27613e;
    }

    public boolean isSilentDownload() {
        return this.f27614f;
    }

    public void setFailResultPromptType(int i10) {
        this.f27615g = i10;
    }

    public void setMarketInfo(MarketInfo marketInfo) {
        this.f27613e = marketInfo;
    }

    public void setSilentDownload(boolean z10) {
        this.f27614f = z10;
    }
}

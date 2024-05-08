package com.qq.e.ads.nativ;

import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class NativeUnifiedADAppInfoImpl implements NativeUnifiedADAppMiitInfo {

    /* renamed from: a, reason: collision with root package name */
    private final String f38201a;

    /* renamed from: b, reason: collision with root package name */
    private final String f38202b;

    /* renamed from: c, reason: collision with root package name */
    private final long f38203c;

    /* renamed from: d, reason: collision with root package name */
    private final String f38204d;

    /* renamed from: e, reason: collision with root package name */
    private final String f38205e;

    /* renamed from: f, reason: collision with root package name */
    private final String f38206f;

    /* renamed from: g, reason: collision with root package name */
    private final String f38207g;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface Keys {
        public static final String APP_NAME = "app_name";
        public static final String AUTHOR_NAME = "author_name";
        public static final String DESCRIPTION_URL = "description_url";
        public static final String PACKAGE_SIZE = "package_size";
        public static final String PERMISSION_URL = "permission_url";
        public static final String PRIVACY_AGREEMENT = "privacy_agreement";
        public static final String VERSION_NAME = "version_name";
    }

    public NativeUnifiedADAppInfoImpl(JSONObject jSONObject) {
        this.f38201a = jSONObject.optString("app_name");
        this.f38202b = jSONObject.optString(Keys.AUTHOR_NAME);
        this.f38203c = jSONObject.optLong(Keys.PACKAGE_SIZE);
        this.f38204d = jSONObject.optString(Keys.PERMISSION_URL);
        this.f38205e = jSONObject.optString(Keys.PRIVACY_AGREEMENT);
        this.f38206f = jSONObject.optString(Keys.VERSION_NAME);
        this.f38207g = jSONObject.optString(Keys.DESCRIPTION_URL);
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADAppMiitInfo
    public String getAppName() {
        return this.f38201a;
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADAppMiitInfo
    public String getAuthorName() {
        return this.f38202b;
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADAppMiitInfo
    public String getDescriptionUrl() {
        return this.f38207g;
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADAppMiitInfo
    public long getPackageSizeBytes() {
        return this.f38203c;
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADAppMiitInfo
    public String getPermissionsUrl() {
        return this.f38204d;
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADAppMiitInfo
    public String getPrivacyAgreement() {
        return this.f38205e;
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADAppMiitInfo
    public String getVersionName() {
        return this.f38206f;
    }
}

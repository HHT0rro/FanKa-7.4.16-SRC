package com.huawei.hms.ads;

import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.ads.annotation.AllApi;
import com.huawei.hms.ads.data.SearchInfo;
import com.huawei.openalliance.ad.annotations.DataKeep;
import com.huawei.openalliance.ad.annotations.c;
import com.huawei.openalliance.ad.beans.metadata.ImpEX;
import com.huawei.openalliance.ad.beans.metadata.ImpEXs;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@DataKeep
@AllApi
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class RequestOptions {
    private static final String TAG = "RequestOptions";

    @c(Code = "gACString")
    private String acString;
    private String adContentClassification;
    private App app;
    private String appCountry;
    private String appLang;
    private String consent;

    @com.huawei.openalliance.ad.annotations.d
    private Map<String, Bundle> extras;
    private String hwACString;
    private Integer hwNonPersonalizedAd;
    private Map<String, ImpEXs> impEXs;
    private Integer nonPersonalizedAd;
    private Boolean requestLocation;
    private SearchInfo searchInfo;
    private String searchTerm;
    private Boolean supportFa;
    private Integer tagForChildProtection;
    private Integer tagForUnderAgeOfPromise;
    private Integer thirdNonPersonalizedAd;

    @AllApi
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class Builder {
        private Integer Code;
        private App D;
        private String F;
        private String I;
        private Boolean L;
        private String S;
        private Integer V;

        /* renamed from: a, reason: collision with root package name */
        private String f29016a;

        /* renamed from: b, reason: collision with root package name */
        private Map<String, Bundle> f29017b;

        /* renamed from: c, reason: collision with root package name */
        private String f29018c;

        /* renamed from: d, reason: collision with root package name */
        private SearchInfo f29019d;

        /* renamed from: e, reason: collision with root package name */
        private String f29020e;

        /* renamed from: f, reason: collision with root package name */
        private String f29021f;

        /* renamed from: g, reason: collision with root package name */
        private Boolean f29022g;
        private Integer Z = null;
        private Integer B = null;
        private Integer C = null;

        @AllApi
        public Builder() {
        }

        public Builder Code(String str) {
            this.f29020e = str;
            return this;
        }

        public Builder V(String str) {
            this.f29021f = str;
            return this;
        }

        @AllApi
        public RequestOptions build() {
            return new RequestOptions(this);
        }

        @AllApi
        public Builder setAdContentClassification(String str) {
            if (str == null || "".equals(str)) {
                str = null;
            } else if (!"W".equals(str) && !ContentClassification.AD_CONTENT_CLASSIFICATION_PI.equals(str) && !ContentClassification.AD_CONTENT_CLASSIFICATION_J.equals(str) && !"A".equals(str)) {
                gl.Code(RequestOptions.TAG, "Invalid value for setAdContentClassification: %s", str);
                return this;
            }
            this.I = str;
            return this;
        }

        @AllApi
        public Builder setApp(App app) {
            if (app == null) {
                gl.V(RequestOptions.TAG, "Invalid appInfo");
            } else {
                this.D = app;
            }
            return this;
        }

        @AllApi
        public Builder setAppCountry(String str) {
            if (TextUtils.isEmpty(str)) {
                gl.V(RequestOptions.TAG, "Invalid value passed to setAppCountry");
            } else {
                this.F = str;
            }
            return this;
        }

        @AllApi
        public Builder setAppLang(String str) {
            if (TextUtils.isEmpty(str)) {
                gl.V(RequestOptions.TAG, "Invalid value passed to setAppLang");
            } else {
                this.S = str;
            }
            return this;
        }

        @AllApi
        public Builder setConsent(String str) {
            this.f29018c = str;
            return this;
        }

        @AllApi
        public Builder setExtras(Map<String, Bundle> map) {
            this.f29017b = map;
            return this;
        }

        @AllApi
        public Builder setHwNonPersonalizedAd(Integer num) {
            if (num == null || 1 == num.intValue() || num.intValue() == 0) {
                this.B = num;
            } else {
                gl.Z(RequestOptions.TAG, "Invalid value passed to setHwNonPersonalizedAd: " + ((Object) num));
            }
            return this;
        }

        @AllApi
        public Builder setNonPersonalizedAd(Integer num) {
            if (num == null || 1 == num.intValue() || num.intValue() == 0) {
                this.Z = num;
            } else {
                gl.Z(RequestOptions.TAG, "Invalid value passed to setNonPersonalizedAd: " + ((Object) num));
            }
            return this;
        }

        @AllApi
        public Builder setRequestLocation(Boolean bool) {
            this.L = bool;
            return this;
        }

        @AllApi
        public Builder setSearchInfo(SearchInfo searchInfo) {
            this.f29019d = searchInfo;
            return this;
        }

        @AllApi
        public Builder setSearchTerm(String str) {
            if (TextUtils.isEmpty(str)) {
                gl.V(RequestOptions.TAG, "Invalid value setSearchTerm");
            } else {
                this.f29016a = str;
            }
            return this;
        }

        @AllApi
        public Builder setSupportFa(Boolean bool) {
            this.f29022g = bool;
            return this;
        }

        @AllApi
        public Builder setTagForChildProtection(Integer num) {
            if (num == null || num.intValue() == -1 || num.intValue() == 0 || num.intValue() == 1) {
                this.Code = num;
            } else {
                gl.Code(RequestOptions.TAG, "Invalid value passed to setTagForChildProtection: %s", num);
            }
            return this;
        }

        @AllApi
        public Builder setTagForUnderAgeOfPromise(Integer num) {
            if (num == null || num.intValue() == -1 || num.intValue() == 0 || num.intValue() == 1) {
                this.V = num;
            } else {
                gl.Code(RequestOptions.TAG, "Invalid value passed to setTagForUnderAgeOfPromise: %s", num);
            }
            return this;
        }

        @AllApi
        public Builder setThirdNonPersonalizedAd(Integer num) {
            if (num == null || 1 == num.intValue() || num.intValue() == 0) {
                this.C = num;
            } else {
                gl.Z(RequestOptions.TAG, "Invalid value passed to setThirdNonPersonalizedAd: " + ((Object) num));
            }
            return this;
        }
    }

    public RequestOptions() {
        this.nonPersonalizedAd = null;
        this.hwNonPersonalizedAd = null;
        this.thirdNonPersonalizedAd = null;
    }

    private RequestOptions(Builder builder) {
        this.nonPersonalizedAd = null;
        this.hwNonPersonalizedAd = null;
        this.thirdNonPersonalizedAd = null;
        this.tagForChildProtection = builder.Code;
        this.tagForUnderAgeOfPromise = builder.V;
        this.adContentClassification = builder.I;
        this.nonPersonalizedAd = builder.Z;
        this.hwNonPersonalizedAd = builder.B;
        this.thirdNonPersonalizedAd = builder.C;
        this.appLang = builder.S;
        this.appCountry = builder.F;
        this.app = builder.D;
        this.requestLocation = builder.L;
        this.searchTerm = builder.f29016a;
        Map<String, Bundle> map = builder.f29017b;
        this.extras = map;
        this.impEXs = Code(map);
        this.consent = builder.f29018c;
        this.searchInfo = builder.f29019d;
        this.acString = builder.f29020e;
        this.hwACString = builder.f29021f;
        this.supportFa = builder.f29022g;
    }

    private Map<String, ImpEXs> Code(Map<String, Bundle> map) {
        if (map == null || map.isEmpty()) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, Bundle> entry : map.entrySet()) {
            String key = entry.getKey();
            Bundle value = entry.getValue();
            if (value != null) {
                ArrayList arrayList = new ArrayList();
                for (String str : value.keySet()) {
                    arrayList.add(new ImpEX(str, com.huawei.openalliance.ad.utils.au.S(value.getString(str))));
                }
                hashMap.put(key, new ImpEXs(arrayList));
            }
        }
        return hashMap;
    }

    public String B() {
        return this.searchTerm;
    }

    public SearchInfo C() {
        return this.searchInfo;
    }

    public Integer Code() {
        return this.hwNonPersonalizedAd;
    }

    public void Code(Boolean bool) {
        this.supportFa = bool;
    }

    public void Code(String str) {
        this.consent = str;
    }

    public Boolean D() {
        return this.supportFa;
    }

    public String F() {
        return this.hwACString;
    }

    public Boolean I() {
        return this.requestLocation;
    }

    public void I(String str) {
        this.hwACString = str;
    }

    public String S() {
        return this.acString;
    }

    public Integer V() {
        return this.thirdNonPersonalizedAd;
    }

    public void V(String str) {
        this.acString = str;
    }

    public String Z() {
        return this.adContentClassification;
    }

    @AllApi
    public String getAdContentClassification() {
        String str = this.adContentClassification;
        return str == null ? "" : str;
    }

    @AllApi
    public App getApp() {
        return this.app;
    }

    @AllApi
    public String getAppCountry() {
        return this.appCountry;
    }

    @AllApi
    public String getAppLang() {
        return this.appLang;
    }

    @AllApi
    public String getConsent() {
        return this.consent;
    }

    @AllApi
    public Map<String, Bundle> getExtras() {
        return this.extras;
    }

    @AllApi
    public Integer getNonPersonalizedAd() {
        return this.nonPersonalizedAd;
    }

    @AllApi
    public Integer getTagForChildProtection() {
        return this.tagForChildProtection;
    }

    @AllApi
    public Integer getTagForUnderAgeOfPromise() {
        return this.tagForUnderAgeOfPromise;
    }

    @AllApi
    public boolean isRequestLocation() {
        Boolean bool = this.requestLocation;
        if (bool == null) {
            return true;
        }
        return bool.booleanValue();
    }

    @AllApi
    public Builder toBuilder() {
        return new Builder().setTagForChildProtection(this.tagForChildProtection).setTagForUnderAgeOfPromise(this.tagForUnderAgeOfPromise).setAdContentClassification(this.adContentClassification).setNonPersonalizedAd(this.nonPersonalizedAd).setHwNonPersonalizedAd(this.hwNonPersonalizedAd).setThirdNonPersonalizedAd(this.thirdNonPersonalizedAd).setAppLang(this.appLang).setApp(this.app).setAppCountry(this.appCountry).setRequestLocation(this.requestLocation).setSearchTerm(this.searchTerm).setExtras(this.extras).setConsent(this.consent).setSearchInfo(this.searchInfo).Code(this.acString).V(this.hwACString).setSupportFa(this.supportFa);
    }
}

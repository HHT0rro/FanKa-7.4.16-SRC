package com.huawei.hms.ads;

import android.content.Context;
import android.location.Location;
import android.text.TextUtils;
import com.huawei.hms.ads.RequestOptions;
import com.huawei.hms.ads.data.SearchInfo;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class i implements p {
    private static final String Code = "AdRequestMediator";
    private String B;
    private String C;
    private String D;
    private String F;
    private int I;
    private App L;
    private boolean S;
    private final HashSet<String> V = new HashSet<>();
    private Location Z;

    /* renamed from: a, reason: collision with root package name */
    private RequestOptions.Builder f29299a;

    /* renamed from: b, reason: collision with root package name */
    private List<Integer> f29300b;

    /* renamed from: c, reason: collision with root package name */
    private String f29301c;

    /* renamed from: d, reason: collision with root package name */
    private SearchInfo f29302d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f29303e;

    @Override // com.huawei.hms.ads.p
    public Location B() {
        return this.Z;
    }

    @Override // com.huawei.hms.ads.p
    public void B(Integer num) {
        if (num == null || num.intValue() == -1 || num.intValue() == 0 || num.intValue() == 1) {
            if (this.f29299a == null) {
                this.f29299a = new RequestOptions.Builder();
            }
            this.f29299a.setTagForUnderAgeOfPromise(num);
        } else {
            gl.V(Code, "Invalid value setTagForUnderAgeOfPromise: " + ((Object) num));
        }
    }

    @Override // com.huawei.hms.ads.p
    public void B(String str) {
        if (TextUtils.isEmpty(str)) {
            gl.V(Code, "Invalid value passed to setAppLang");
            return;
        }
        if (this.f29299a == null) {
            this.f29299a = new RequestOptions.Builder();
        }
        this.f29299a.setAppLang(str);
    }

    @Override // com.huawei.hms.ads.p
    public RequestOptions C() {
        RequestOptions.Builder builder = this.f29299a;
        if (builder != null) {
            return builder.build();
        }
        return null;
    }

    @Override // com.huawei.hms.ads.p
    public void C(Integer num) {
        if (num != null && num.intValue() != 0 && 1 != num.intValue()) {
            gl.Z(Code, "Invalid value passed to setSupportFa: " + ((Object) num));
            return;
        }
        if (this.f29299a == null) {
            this.f29299a = new RequestOptions.Builder();
        }
        if (num == null) {
            this.f29299a.setSupportFa(null);
        } else {
            this.f29299a.setSupportFa(Boolean.valueOf(num.intValue() == 1));
        }
    }

    @Override // com.huawei.hms.ads.p
    public void C(String str) {
        if (TextUtils.isEmpty(str)) {
            gl.V(Code, "Invalid value passed to setAppCountry");
            return;
        }
        if (this.f29299a == null) {
            this.f29299a = new RequestOptions.Builder();
        }
        this.f29299a.setAppCountry(str);
    }

    @Override // com.huawei.hms.ads.p
    public String Code() {
        return this.B;
    }

    @Override // com.huawei.hms.ads.p
    public void Code(int i10) {
        this.I = i10;
    }

    @Override // com.huawei.hms.ads.p
    public void Code(Location location) {
        this.Z = location;
    }

    @Override // com.huawei.hms.ads.p
    public void Code(App app) {
        if (app == null) {
            gl.V(Code, "Invalid appInfo");
            return;
        }
        if (this.f29299a == null) {
            this.f29299a = new RequestOptions.Builder();
        }
        this.f29299a.setApp(app);
    }

    @Override // com.huawei.hms.ads.p
    public void Code(SearchInfo searchInfo) {
        if (this.f29299a == null) {
            this.f29299a = new RequestOptions.Builder();
        }
        this.f29299a.setSearchInfo(searchInfo);
    }

    @Override // com.huawei.hms.ads.p
    public void Code(Integer num) {
        if (num == null || num.intValue() == -1 || num.intValue() == 0 || num.intValue() == 1) {
            if (this.f29299a == null) {
                this.f29299a = new RequestOptions.Builder();
            }
            this.f29299a.setTagForChildProtection(num);
        } else {
            gl.V(Code, "Invalid value setTagForChildProtection: " + ((Object) num));
        }
    }

    @Override // com.huawei.hms.ads.p
    public void Code(String str) {
        this.V.add(str);
    }

    @Override // com.huawei.hms.ads.p
    public void Code(List<Integer> list) {
        this.f29300b = list;
    }

    @Override // com.huawei.hms.ads.p
    public void Code(boolean z10) {
        this.S = z10;
    }

    @Override // com.huawei.hms.ads.p
    public boolean Code(Context context) {
        return false;
    }

    @Override // com.huawei.hms.ads.p
    public String D() {
        return this.D;
    }

    @Override // com.huawei.hms.ads.p
    public void D(String str) {
        if (this.f29299a == null) {
            this.f29299a = new RequestOptions.Builder();
        }
        this.f29299a.setSearchTerm(str);
    }

    @Override // com.huawei.hms.ads.p
    public String F() {
        return this.F;
    }

    @Override // com.huawei.hms.ads.p
    public void F(String str) {
        this.F = str;
    }

    @Override // com.huawei.hms.ads.p
    public int I() {
        return this.I;
    }

    @Override // com.huawei.hms.ads.p
    public void I(Integer num) {
        if (num == null || 1 == num.intValue() || num.intValue() == 0) {
            if (this.f29299a == null) {
                this.f29299a = new RequestOptions.Builder();
            }
            this.f29299a.setHwNonPersonalizedAd(num);
        } else {
            gl.Z(Code, "Invalid value passed to setHwNonPersonalizedAd: " + ((Object) num));
        }
    }

    @Override // com.huawei.hms.ads.p
    public void I(String str) {
        this.B = str;
    }

    @Override // com.huawei.hms.ads.p
    public void I(boolean z10) {
        this.f29303e = z10;
    }

    @Override // com.huawei.hms.ads.p
    public List<Integer> L() {
        return this.f29300b;
    }

    @Override // com.huawei.hms.ads.p
    public void L(String str) {
        if (this.f29299a == null) {
            this.f29299a = new RequestOptions.Builder();
        }
        this.f29299a.setConsent(str);
    }

    @Override // com.huawei.hms.ads.p
    public void S(String str) {
        if (str == null || "".equals(str)) {
            return;
        }
        if ("W".equals(str) || ContentClassification.AD_CONTENT_CLASSIFICATION_PI.equals(str) || ContentClassification.AD_CONTENT_CLASSIFICATION_J.equals(str) || "A".equals(str)) {
            if (this.f29299a == null) {
                this.f29299a = new RequestOptions.Builder();
            }
            this.f29299a.setAdContentClassification(str);
        } else {
            gl.V(Code, "Invalid value  setAdContentClassification: " + str);
        }
    }

    @Override // com.huawei.hms.ads.p
    public boolean S() {
        return this.S;
    }

    @Override // com.huawei.hms.ads.p
    public String V() {
        return this.C;
    }

    @Override // com.huawei.hms.ads.p
    public void V(Integer num) {
        if (num == null || 1 == num.intValue() || num.intValue() == 0) {
            if (this.f29299a == null) {
                this.f29299a = new RequestOptions.Builder();
            }
            this.f29299a.setNonPersonalizedAd(num);
        } else {
            gl.Z(Code, "Invalid value passed to setNonPersonalizedAd: " + ((Object) num));
        }
    }

    @Override // com.huawei.hms.ads.p
    public void V(String str) {
        this.D = str;
    }

    @Override // com.huawei.hms.ads.p
    public void V(boolean z10) {
        if (this.f29299a == null) {
            this.f29299a = new RequestOptions.Builder();
        }
        this.f29299a.setRequestLocation(Boolean.valueOf(z10));
    }

    @Override // com.huawei.hms.ads.p
    public Set<String> Z() {
        return this.V;
    }

    @Override // com.huawei.hms.ads.p
    public void Z(Integer num) {
        if (num == null || 1 == num.intValue() || num.intValue() == 0) {
            if (this.f29299a == null) {
                this.f29299a = new RequestOptions.Builder();
            }
            this.f29299a.setThirdNonPersonalizedAd(num);
        } else {
            gl.Z(Code, "Invalid value passed to setThirdNonPersonalizedAd: " + ((Object) num));
        }
    }

    @Override // com.huawei.hms.ads.p
    public void Z(String str) {
        this.C = str;
    }

    @Override // com.huawei.hms.ads.p
    public String a() {
        return this.f29301c;
    }

    @Override // com.huawei.hms.ads.p
    public void a(String str) {
        this.f29301c = str;
    }

    @Override // com.huawei.hms.ads.p
    public boolean b() {
        return this.f29303e;
    }
}

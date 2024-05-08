package b9;

import android.text.TextUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public final String f1432a;

    /* renamed from: b, reason: collision with root package name */
    public final String f1433b;

    /* renamed from: c, reason: collision with root package name */
    public final String f1434c;

    /* renamed from: d, reason: collision with root package name */
    public final String f1435d;

    /* renamed from: e, reason: collision with root package name */
    public final String f1436e;

    /* renamed from: f, reason: collision with root package name */
    public final int f1437f;

    /* renamed from: g, reason: collision with root package name */
    public int f1438g;

    public e(String str, String str2, String str3, String str4, String str5, int i10) {
        this.f1438g = 0;
        this.f1432a = str;
        this.f1433b = str2;
        this.f1434c = str3;
        this.f1435d = str4;
        this.f1436e = str5;
        this.f1437f = i10;
        if (str != null) {
            this.f1438g = str.length() / 2;
        }
    }

    public boolean a() {
        return (TextUtils.isEmpty(this.f1432a) || TextUtils.isEmpty(this.f1433b) || TextUtils.isEmpty(this.f1434c) || TextUtils.isEmpty(this.f1435d) || this.f1432a.length() != this.f1433b.length() || this.f1433b.length() != this.f1434c.length() || this.f1434c.length() != this.f1438g * 2 || this.f1437f < 0 || TextUtils.isEmpty(this.f1436e)) ? false : true;
    }

    public String b() {
        return this.f1432a;
    }

    public String c() {
        return this.f1433b;
    }

    public String d() {
        return this.f1434c;
    }

    public String e() {
        return this.f1435d;
    }

    public String f() {
        return this.f1436e;
    }

    public int g() {
        return this.f1437f;
    }

    public int h() {
        return this.f1438g;
    }
}

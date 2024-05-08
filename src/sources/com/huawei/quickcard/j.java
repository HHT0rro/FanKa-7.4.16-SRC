package com.huawei.quickcard;

import com.tencent.cloud.huiyansdkface.facelight.api.WbCloudFaceContant;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    private String f34052a;

    /* renamed from: b, reason: collision with root package name */
    private String f34053b;

    /* renamed from: c, reason: collision with root package name */
    private String f34054c;

    /* renamed from: d, reason: collision with root package name */
    private String f34055d;

    /* renamed from: e, reason: collision with root package name */
    private String f34056e = WbCloudFaceContant.BLACK;

    public void a(String str) {
        this.f34056e = str;
    }

    public void b(String str) {
        this.f34055d = str;
    }

    public void c(String str) {
        this.f34052a = str;
    }

    public String d() {
        return this.f34052a;
    }

    public void e(String str) {
        this.f34053b = str;
    }

    public String f() {
        return this.f34053b;
    }

    public boolean a() {
        String str = this.f34052a;
        return str != null && str.equals(this.f34054c) && this.f34054c.equals(this.f34053b) && this.f34053b.equals(this.f34055d);
    }

    public String b() {
        return this.f34056e;
    }

    public String c() {
        return this.f34055d;
    }

    public void d(String str) {
        this.f34054c = str;
    }

    public String e() {
        return this.f34054c;
    }
}

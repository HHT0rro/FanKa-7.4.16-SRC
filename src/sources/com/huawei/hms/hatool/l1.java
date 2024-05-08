package com.huawei.hms.hatool;

import com.huawei.hianalytics.framework.constant.FrameworkConstant;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class l1 {

    /* renamed from: a, reason: collision with root package name */
    private s0 f30169a;

    /* renamed from: b, reason: collision with root package name */
    private s0 f30170b;

    /* renamed from: c, reason: collision with root package name */
    private s0 f30171c;

    /* renamed from: d, reason: collision with root package name */
    private s0 f30172d;

    public l1(String str) {
    }

    public s0 a() {
        return this.f30171c;
    }

    public s0 a(String str) {
        if (str.equals(FrameworkConstant.DataType.STRING_OPER)) {
            return c();
        }
        if (str.equals(FrameworkConstant.DataType.STRING_MAINT)) {
            return b();
        }
        if (str.equals(FrameworkConstant.DataType.STRING_DIFFPRIVACY)) {
            return a();
        }
        if (str.equals(FrameworkConstant.DataType.STRING_PREINS)) {
            return d();
        }
        v.f("hmsSdk", "HiAnalyticsInstData.getConfig(type): wrong type: " + str);
        return null;
    }

    public void a(s0 s0Var) {
        this.f30169a = s0Var;
    }

    public s0 b() {
        return this.f30169a;
    }

    public void b(s0 s0Var) {
        this.f30170b = s0Var;
    }

    public s0 c() {
        return this.f30170b;
    }

    public s0 d() {
        return this.f30172d;
    }
}

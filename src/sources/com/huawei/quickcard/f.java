package com.huawei.quickcard;

import com.huawei.quickcard.framework.unit.LengthUnit;
import com.huawei.quickcard.framework.unit.LengthValue;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private String f33661a = "100%";

    /* renamed from: b, reason: collision with root package name */
    private String f33662b = "100%";

    /* renamed from: c, reason: collision with root package name */
    private int f33663c = -1;

    /* renamed from: d, reason: collision with root package name */
    private LengthValue f33664d;

    /* renamed from: e, reason: collision with root package name */
    private int f33665e;

    /* renamed from: f, reason: collision with root package name */
    private LengthValue f33666f;

    /* renamed from: g, reason: collision with root package name */
    private String f33667g;

    public f() {
        LengthUnit lengthUnit = LengthUnit.DP;
        this.f33664d = new LengthValue(0.0f, lengthUnit);
        this.f33665e = -1;
        this.f33666f = new LengthValue(0.0f, lengthUnit);
        this.f33667g = "repeat";
    }

    public String a() {
        return this.f33662b;
    }

    public int b() {
        return this.f33663c;
    }

    public void c(String str) {
        this.f33661a = str;
    }

    public int d() {
        return this.f33665e;
    }

    public LengthValue e() {
        return this.f33666f;
    }

    public String f() {
        return this.f33667g;
    }

    public String g() {
        return this.f33661a;
    }

    public void a(String str) {
        this.f33662b = str;
    }

    public void b(int i10) {
        this.f33665e = i10;
    }

    public LengthValue c() {
        return this.f33664d;
    }

    public void a(int i10) {
        this.f33663c = i10;
    }

    public void b(LengthValue lengthValue) {
        this.f33666f = lengthValue;
    }

    public void a(LengthValue lengthValue) {
        this.f33664d = lengthValue;
    }

    public void b(String str) {
        this.f33667g = str;
    }
}

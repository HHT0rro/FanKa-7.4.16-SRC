package com.alibaba.security.realidentity.build;

import java.util.ArrayList;
import java.util.List;

/* compiled from: ListPartsResult.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class fo extends ft {

    /* renamed from: a, reason: collision with root package name */
    public String f3657a;

    /* renamed from: b, reason: collision with root package name */
    public String f3658b;

    /* renamed from: c, reason: collision with root package name */
    public String f3659c;

    /* renamed from: f, reason: collision with root package name */
    public String f3662f;

    /* renamed from: d, reason: collision with root package name */
    public int f3660d = 0;

    /* renamed from: e, reason: collision with root package name */
    public int f3661e = 0;

    /* renamed from: g, reason: collision with root package name */
    public boolean f3663g = false;

    /* renamed from: h, reason: collision with root package name */
    public int f3664h = 0;

    /* renamed from: i, reason: collision with root package name */
    public List<fw> f3665i = new ArrayList();

    private void a(String str) {
        this.f3657a = str;
    }

    private String b() {
        return this.f3657a;
    }

    private String c() {
        return this.f3658b;
    }

    private String d() {
        return this.f3659c;
    }

    private String e() {
        return this.f3662f;
    }

    private int f() {
        return this.f3661e;
    }

    private int g() {
        return this.f3664h;
    }

    private int h() {
        return this.f3660d;
    }

    private boolean i() {
        return this.f3663g;
    }

    private List<fw> j() {
        return this.f3665i;
    }

    private void a(int i10) {
        this.f3661e = i10;
    }

    private void b(String str) {
        this.f3658b = str;
    }

    private void c(String str) {
        this.f3659c = str;
    }

    private void d(String str) {
        this.f3662f = str;
    }

    private void a(boolean z10) {
        this.f3663g = z10;
    }

    private void b(int i10) {
        this.f3664h = i10;
    }

    private void c(int i10) {
        this.f3660d = i10;
    }

    private void a(List<fw> list) {
        this.f3665i.clear();
        if (list.isEmpty()) {
            return;
        }
        this.f3665i.addAll(list);
    }
}

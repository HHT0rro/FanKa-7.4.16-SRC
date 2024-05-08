package com.alibaba.security.realidentity.build;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: ClientConfiguration.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class bt {

    /* renamed from: l, reason: collision with root package name */
    private static final int f3204l = 2;

    /* renamed from: g, reason: collision with root package name */
    public String f3211g;

    /* renamed from: h, reason: collision with root package name */
    public int f3212h;

    /* renamed from: i, reason: collision with root package name */
    public String f3213i;

    /* renamed from: a, reason: collision with root package name */
    public int f3205a = 5;

    /* renamed from: b, reason: collision with root package name */
    public int f3206b = 60000;

    /* renamed from: c, reason: collision with root package name */
    public int f3207c = 60000;

    /* renamed from: d, reason: collision with root package name */
    public long f3208d = 5242880;

    /* renamed from: e, reason: collision with root package name */
    public int f3209e = 2;

    /* renamed from: f, reason: collision with root package name */
    public List<String> f3210f = new ArrayList();

    /* renamed from: j, reason: collision with root package name */
    public boolean f3214j = true;

    /* renamed from: k, reason: collision with root package name */
    public boolean f3215k = false;

    private static bt a() {
        return new bt();
    }

    private int b() {
        return this.f3205a;
    }

    private void c() {
        this.f3205a = 5;
    }

    private int d() {
        return this.f3206b;
    }

    private void e() {
        this.f3206b = 15000;
    }

    private int f() {
        return this.f3207c;
    }

    private void g() {
        this.f3207c = 15000;
    }

    private long h() {
        return this.f3208d;
    }

    private int i() {
        return this.f3209e;
    }

    private void j() {
        this.f3209e = 2;
    }

    private List<String> k() {
        return Collections.unmodifiableList(this.f3210f);
    }

    private String l() {
        return this.f3211g;
    }

    private int m() {
        return this.f3212h;
    }

    private String n() {
        return this.f3213i;
    }

    private boolean o() {
        return this.f3214j;
    }

    private boolean p() {
        return this.f3215k;
    }

    private void a(long j10) {
        this.f3208d = j10;
    }

    private void b(String str) {
        this.f3213i = str;
    }

    private void a(List<String> list) {
        if (list != null && list.size() != 0) {
            this.f3210f.clear();
            for (String str : list) {
                if (str.contains("://")) {
                    this.f3210f.add(str.substring(str.indexOf("://") + 3));
                } else {
                    this.f3210f.add(str);
                }
            }
            return;
        }
        throw new IllegalArgumentException("cname exclude list should not be null.");
    }

    private void b(boolean z10) {
        this.f3215k = z10;
    }

    private void a(String str) {
        this.f3211g = str;
    }

    private void a(int i10) {
        this.f3212h = i10;
    }

    private void a(boolean z10) {
        this.f3214j = z10;
    }
}

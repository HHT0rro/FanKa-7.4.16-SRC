package com.huawei.hms.hatool;

import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class s0 {

    /* renamed from: a, reason: collision with root package name */
    private boolean f30210a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f30211b;

    /* renamed from: c, reason: collision with root package name */
    private String f30212c;

    /* renamed from: d, reason: collision with root package name */
    private String f30213d;

    /* renamed from: e, reason: collision with root package name */
    private String f30214e;

    /* renamed from: f, reason: collision with root package name */
    private String f30215f;

    /* renamed from: g, reason: collision with root package name */
    private j0 f30216g;

    /* renamed from: h, reason: collision with root package name */
    private String f30217h;

    /* renamed from: i, reason: collision with root package name */
    private Map<String, String> f30218i;

    /* renamed from: j, reason: collision with root package name */
    private String f30219j;

    /* renamed from: k, reason: collision with root package name */
    private int f30220k;

    /* renamed from: l, reason: collision with root package name */
    private int f30221l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f30222m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f30223n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f30224o;

    /* renamed from: p, reason: collision with root package name */
    private String f30225p;

    /* renamed from: q, reason: collision with root package name */
    private long f30226q;

    public s0() {
        this.f30214e = "";
        this.f30215f = "";
        this.f30216g = new j0();
        this.f30217h = "";
        this.f30219j = "";
        this.f30220k = 10;
        this.f30221l = 7;
        this.f30222m = true;
        this.f30223n = true;
        this.f30224o = false;
        this.f30226q = 0L;
    }

    public s0(s0 s0Var) {
        this.f30214e = "";
        this.f30215f = "";
        this.f30216g = new j0();
        this.f30217h = "";
        this.f30219j = "";
        this.f30220k = 10;
        this.f30221l = 7;
        this.f30222m = true;
        this.f30223n = true;
        this.f30224o = false;
        this.f30226q = 0L;
        this.f30216g = s0Var.f30216g;
        b(s0Var.f30210a);
        a(s0Var.f30212c);
        b(s0Var.f30213d);
        e(s0Var.f30214e);
        g(s0Var.f30215f);
        d(s0Var.f30217h);
        f(s0Var.f30219j);
        c(s0Var.f30211b);
        a(s0Var.f30220k);
        b(s0Var.f30221l);
        d(s0Var.f30222m);
        a(s0Var.f30223n);
        e(s0Var.f30224o);
        a(s0Var.f30218i);
        c(s0Var.f30225p);
        a(s0Var.f30226q);
    }

    public void a(int i10) {
        this.f30220k = i10;
    }

    public void a(long j10) {
        this.f30226q = j10;
    }

    public void a(String str) {
        this.f30212c = str;
    }

    public void a(Map<String, String> map) {
        this.f30218i = map;
    }

    public void a(boolean z10) {
        this.f30223n = z10;
    }

    public boolean a() {
        return this.f30223n;
    }

    public int b() {
        return this.f30220k;
    }

    public void b(int i10) {
        this.f30221l = i10;
    }

    public void b(String str) {
        this.f30213d = str;
    }

    public void b(boolean z10) {
        this.f30210a = z10;
    }

    public void c(String str) {
        this.f30225p = str;
    }

    public void c(boolean z10) {
        this.f30211b = z10;
    }

    public boolean c() {
        return this.f30210a;
    }

    public int d() {
        return this.f30221l;
    }

    public void d(String str) {
        this.f30217h = str;
    }

    public void d(boolean z10) {
        this.f30222m = z10;
    }

    public void e(String str) {
        this.f30214e = str;
    }

    public void e(boolean z10) {
        this.f30224o = z10;
    }

    public boolean e() {
        return this.f30211b;
    }

    public String f() {
        return this.f30212c;
    }

    public void f(String str) {
        this.f30219j = str;
    }

    public void g(String str) {
        this.f30215f = str;
    }

    public boolean g() {
        return this.f30222m;
    }

    public String h() {
        return this.f30213d;
    }

    public boolean i() {
        return this.f30224o;
    }

    public j0 j() {
        return this.f30216g;
    }

    public Map<String, String> k() {
        return this.f30218i;
    }

    public long l() {
        return this.f30226q;
    }

    public String m() {
        return this.f30225p;
    }

    public String n() {
        return this.f30217h;
    }

    public String o() {
        return this.f30214e;
    }

    public String p() {
        return this.f30219j;
    }

    public String q() {
        return this.f30215f;
    }
}

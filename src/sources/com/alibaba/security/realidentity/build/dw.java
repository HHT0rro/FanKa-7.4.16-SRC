package com.alibaba.security.realidentity.build;

import com.alibaba.security.realidentity.oss.model.OSSRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* compiled from: CopyObjectRequest.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class dw extends OSSRequest {

    /* renamed from: a, reason: collision with root package name */
    public String f3522a;

    /* renamed from: b, reason: collision with root package name */
    public String f3523b;

    /* renamed from: c, reason: collision with root package name */
    public String f3524c;

    /* renamed from: d, reason: collision with root package name */
    public String f3525d;

    /* renamed from: e, reason: collision with root package name */
    public String f3526e;

    /* renamed from: f, reason: collision with root package name */
    public fu f3527f;

    /* renamed from: g, reason: collision with root package name */
    public List<String> f3528g = new ArrayList();

    /* renamed from: h, reason: collision with root package name */
    public List<String> f3529h = new ArrayList();

    /* renamed from: i, reason: collision with root package name */
    public Date f3530i;

    /* renamed from: j, reason: collision with root package name */
    public Date f3531j;

    private dw(String str, String str2, String str3, String str4) {
        this.f3522a = str;
        this.f3523b = str2;
        this.f3524c = str3;
        this.f3525d = str4;
    }

    private String a() {
        return this.f3522a;
    }

    private String b() {
        return this.f3523b;
    }

    private String c() {
        return this.f3524c;
    }

    private String d() {
        return this.f3525d;
    }

    private fu e() {
        return this.f3527f;
    }

    private List<String> f() {
        return this.f3528g;
    }

    private void g() {
        this.f3528g.clear();
    }

    private List<String> h() {
        return this.f3529h;
    }

    private void i() {
        this.f3529h.clear();
    }

    private Date j() {
        return this.f3530i;
    }

    private Date k() {
        return this.f3531j;
    }

    private String l() {
        return this.f3526e;
    }

    private void a(String str) {
        this.f3522a = str;
    }

    private void b(String str) {
        this.f3523b = str;
    }

    private void c(String str) {
        this.f3524c = str;
    }

    private void d(String str) {
        this.f3525d = str;
    }

    private void e(String str) {
        this.f3526e = str;
    }

    private void a(fu fuVar) {
        this.f3527f = fuVar;
    }

    private void b(List<String> list) {
        this.f3529h.clear();
        if (list == null || list.isEmpty()) {
            return;
        }
        this.f3529h.addAll(list);
    }

    private void a(List<String> list) {
        this.f3528g.clear();
        if (list == null || list.isEmpty()) {
            return;
        }
        this.f3528g.addAll(list);
    }

    private void b(Date date) {
        this.f3531j = date;
    }

    private void a(Date date) {
        this.f3530i = date;
    }
}

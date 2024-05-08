package com.alibaba.security.realidentity.build;

import com.alibaba.security.realidentity.oss.model.OSSRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: CompleteMultipartUploadRequest.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class du extends OSSRequest {

    /* renamed from: a, reason: collision with root package name */
    public String f3510a;

    /* renamed from: b, reason: collision with root package name */
    public String f3511b;

    /* renamed from: c, reason: collision with root package name */
    public String f3512c;

    /* renamed from: d, reason: collision with root package name */
    public List<fv> f3513d;

    /* renamed from: e, reason: collision with root package name */
    public Map<String, String> f3514e;

    /* renamed from: f, reason: collision with root package name */
    public Map<String, String> f3515f;

    /* renamed from: g, reason: collision with root package name */
    public fu f3516g;

    public du(String str, String str2, String str3, List<fv> list) {
        new ArrayList();
        this.f3510a = str;
        this.f3511b = str2;
        this.f3512c = str3;
        this.f3513d = list;
    }

    private String a() {
        return this.f3510a;
    }

    private String b() {
        return this.f3511b;
    }

    private String c() {
        return this.f3512c;
    }

    private List<fv> d() {
        return this.f3513d;
    }

    private Map<String, String> e() {
        return this.f3514e;
    }

    private Map<String, String> f() {
        return this.f3515f;
    }

    private fu g() {
        return this.f3516g;
    }

    private void a(String str) {
        this.f3510a = str;
    }

    private void b(String str) {
        this.f3511b = str;
    }

    private void c(String str) {
        this.f3512c = str;
    }

    private void a(List<fv> list) {
        this.f3513d = list;
    }

    private void b(Map<String, String> map) {
        this.f3515f = map;
    }

    private void a(Map<String, String> map) {
        this.f3514e = map;
    }

    private void a(fu fuVar) {
        this.f3516g = fuVar;
    }
}

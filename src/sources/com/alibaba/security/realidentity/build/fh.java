package com.alibaba.security.realidentity.build;

import com.alibaba.security.realidentity.oss.model.OSSRequest;

/* compiled from: ListBucketsRequest.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class fh extends OSSRequest {

    /* renamed from: d, reason: collision with root package name */
    private static final int f3605d = 1000;

    /* renamed from: a, reason: collision with root package name */
    public String f3606a;

    /* renamed from: b, reason: collision with root package name */
    public String f3607b;

    /* renamed from: c, reason: collision with root package name */
    public Integer f3608c;

    public fh() {
    }

    private String a() {
        return this.f3606a;
    }

    private String b() {
        return this.f3607b;
    }

    private Integer c() {
        return this.f3608c;
    }

    private fh(String str) {
        this(str, (byte) 0);
    }

    private void a(String str) {
        this.f3606a = str;
    }

    private void b(String str) {
        this.f3607b = str;
    }

    private fh(String str, byte b4) {
        this(str, (Integer) 100);
    }

    private void a(Integer num) {
        this.f3608c = num;
    }

    private fh(String str, Integer num) {
        this.f3606a = str;
        this.f3607b = null;
        this.f3608c = num;
    }
}

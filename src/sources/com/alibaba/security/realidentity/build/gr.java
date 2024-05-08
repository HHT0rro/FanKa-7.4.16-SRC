package com.alibaba.security.realidentity.build;

import android.content.Context;
import com.alibaba.security.common.http.ok.RPHttpClient;
import com.alibaba.security.realidentity.build.ft;
import com.alibaba.security.realidentity.oss.model.OSSRequest;

/* compiled from: ExecutionContext.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class gr<Request extends OSSRequest, Result extends ft> {

    /* renamed from: a, reason: collision with root package name */
    public Request f3756a;

    /* renamed from: b, reason: collision with root package name */
    public RPHttpClient f3757b;

    /* renamed from: c, reason: collision with root package name */
    public gq f3758c;

    /* renamed from: d, reason: collision with root package name */
    public Context f3759d;

    /* renamed from: e, reason: collision with root package name */
    public bx f3760e;

    /* renamed from: f, reason: collision with root package name */
    public by f3761f;

    /* renamed from: g, reason: collision with root package name */
    public bz f3762g;

    private gr(RPHttpClient rPHttpClient, Request request) {
        this(rPHttpClient, request, null);
    }

    private Context a() {
        return this.f3759d;
    }

    private Request b() {
        return this.f3756a;
    }

    private RPHttpClient c() {
        return this.f3757b;
    }

    private gq d() {
        return this.f3758c;
    }

    private bx<Request, Result> e() {
        return this.f3760e;
    }

    private by f() {
        return this.f3761f;
    }

    private bz g() {
        return this.f3762g;
    }

    public gr(RPHttpClient rPHttpClient, Request request, Context context) {
        this.f3758c = new gq();
        this.f3757b = rPHttpClient;
        this.f3756a = request;
        this.f3759d = context;
    }

    private void a(Request request) {
        this.f3756a = request;
    }

    private void a(RPHttpClient rPHttpClient) {
        this.f3757b = rPHttpClient;
    }

    private void a(bx<Request, Result> bxVar) {
        this.f3760e = bxVar;
    }

    private void a(by byVar) {
        this.f3761f = byVar;
    }

    private void a(bz bzVar) {
        this.f3762g = bzVar;
    }
}

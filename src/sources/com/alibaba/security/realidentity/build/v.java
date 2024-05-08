package com.alibaba.security.realidentity.build;

import com.alibaba.security.realidentity.business.base.chain.BusinessHeadParams;
import com.alibaba.security.realidentity.business.base.chain.BusinessType;
import java.util.ArrayList;
import java.util.List;

/* compiled from: BusinessChain.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class v {

    /* renamed from: a, reason: collision with root package name */
    private x f3984a;

    /* renamed from: b, reason: collision with root package name */
    private x f3985b;

    /* renamed from: c, reason: collision with root package name */
    private final List<BusinessType> f3986c = new ArrayList();

    /* renamed from: d, reason: collision with root package name */
    private r f3987d;

    /* renamed from: e, reason: collision with root package name */
    private final String f3988e;

    public v(String str) {
        this.f3988e = str;
    }

    private String b() {
        return this.f3988e;
    }

    private boolean c() {
        return this.f3984a == null;
    }

    public final v a(t tVar, q qVar) throws IllegalAccessException {
        if (c()) {
            tVar.f3980c = this.f3988e;
            x xVar = new x(tVar, qVar);
            a(tVar.h());
            a(xVar);
            return this;
        }
        throw new IllegalAccessException("Please addBeginBusinessWorker First");
    }

    public final v a(t tVar) {
        tVar.f3980c = this.f3988e;
        x xVar = new x(tVar);
        a(tVar.h());
        a(xVar);
        return this;
    }

    private void a(BusinessType businessType) {
        this.f3986c.add(businessType);
    }

    private v a(x xVar) {
        if (c()) {
            xVar.f3991a = 0;
            this.f3985b = xVar;
            this.f3984a = xVar;
            return this;
        }
        x xVar2 = this.f3984a;
        xVar.f3992b = xVar2;
        xVar.f3991a = xVar2.f3991a + 1;
        xVar2.f3993c = xVar;
        this.f3984a = xVar;
        return this;
    }

    public final void a(BusinessHeadParams businessHeadParams) {
        if (this.f3985b != null) {
            r rVar = new r(businessHeadParams);
            this.f3987d = rVar;
            rVar.a(this.f3986c, this.f3988e);
            this.f3987d.a();
            this.f3985b.a(this.f3987d);
        }
    }

    public final void a() {
        r rVar = this.f3987d;
        if (rVar != null) {
            rVar.c();
        }
    }
}

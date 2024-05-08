package com.alibaba.security.realidentity.build;

import com.alibaba.security.realidentity.business.base.chain.BusinessType;
import com.alibaba.security.realidentity.business.bucket.BucketParams;

/* compiled from: BusinessNode.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class x {

    /* renamed from: d, reason: collision with root package name */
    private static final String f3990d = "BusinessNode";

    /* renamed from: a, reason: collision with root package name */
    public int f3991a;

    /* renamed from: b, reason: collision with root package name */
    public x f3992b;

    /* renamed from: c, reason: collision with root package name */
    public x f3993c;

    /* renamed from: e, reason: collision with root package name */
    private q f3994e;

    /* renamed from: f, reason: collision with root package name */
    private final t f3995f;

    public x(t tVar) {
        this.f3995f = tVar;
    }

    private void b(x xVar) {
        this.f3992b = xVar;
    }

    private void b(r rVar, BucketParams bucketParams, boolean z10) {
        t tVar = this.f3995f;
        if (tVar != null) {
            tVar.a(rVar);
        }
        a(rVar, bucketParams, z10);
    }

    public x(t tVar, q qVar) {
        this.f3995f = tVar;
        this.f3994e = qVar;
    }

    private void a(int i10) {
        this.f3991a = i10;
    }

    private int a() {
        return this.f3991a;
    }

    private void b(BusinessType businessType, r rVar, BucketParams bucketParams, boolean z10) {
        t tVar = this.f3995f;
        if (tVar != null) {
            tVar.a(rVar, bucketParams);
        }
        a(businessType, rVar, bucketParams, z10);
    }

    private void a(x xVar) {
        this.f3993c = xVar;
    }

    public final void a(final r rVar) {
        this.f3995f.a(rVar, new u() { // from class: com.alibaba.security.realidentity.build.x.1
            @Override // com.alibaba.security.realidentity.build.u
            public final void a(BucketParams bucketParams, boolean z10) {
                x xVar = x.this;
                if (xVar.f3993c != null) {
                    if (rVar.a()) {
                        x.this.f3993c.a(rVar);
                        return;
                    }
                    return;
                }
                xVar.a(rVar, bucketParams, z10);
            }

            @Override // com.alibaba.security.realidentity.build.u
            public final void a(BusinessType businessType, BucketParams bucketParams, boolean z10) {
                x.this.a(businessType, rVar, bucketParams, z10);
            }

            @Override // com.alibaba.security.realidentity.build.u
            public final void a(BusinessType businessType, BucketParams bucketParams, String str, boolean z10) {
                x.this.a(businessType, rVar, bucketParams, str, z10);
            }
        });
    }

    private void b(BusinessType businessType, r rVar, BucketParams bucketParams, String str, boolean z10) {
        t tVar = this.f3995f;
        if (tVar != null) {
            tVar.b(rVar, bucketParams);
        }
        a(businessType, rVar, bucketParams, str, z10);
    }

    public final void a(r rVar, BucketParams bucketParams, boolean z10) {
        x xVar = this.f3992b;
        if (xVar != null) {
            xVar.b(rVar, bucketParams, z10);
            return;
        }
        q qVar = this.f3994e;
        if (qVar == null || !z10) {
            return;
        }
        qVar.a();
    }

    public final void a(BusinessType businessType, r rVar, BucketParams bucketParams, boolean z10) {
        x xVar = this.f3992b;
        if (xVar != null) {
            xVar.b(businessType, rVar, bucketParams, z10);
            return;
        }
        q qVar = this.f3994e;
        if (qVar == null || !z10) {
            return;
        }
        qVar.a(businessType, rVar);
    }

    public final void a(BusinessType businessType, r rVar, BucketParams bucketParams, String str, boolean z10) {
        x xVar = this.f3992b;
        if (xVar != null) {
            xVar.b(businessType, rVar, bucketParams, str, z10);
            return;
        }
        q qVar = this.f3994e;
        if (qVar == null || !z10) {
            return;
        }
        qVar.a(str);
    }
}

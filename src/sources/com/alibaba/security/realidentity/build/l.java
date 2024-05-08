package com.alibaba.security.realidentity.build;

import android.content.Context;
import com.alibaba.security.realidentity.business.bucket.BucketParams;
import com.alibaba.security.realidentity.http.AbsHttpInvoker;
import com.alibaba.security.realidentity.http.IHttpInvoker;

/* compiled from: RealIdentityAdapterWrapper.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class l implements g {

    /* renamed from: b */
    private static final String f3946b = "RealIdentityAdapterWrapper";

    /* renamed from: a */
    public g f3947a;

    /* compiled from: RealIdentityAdapterWrapper.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static final class a {

        /* renamed from: a */
        private static final l f3948a = new l();

        private a() {
        }
    }

    private void a(g gVar) {
        this.f3947a = gVar;
        b();
    }

    private static l f() {
        return a.f3948a;
    }

    @Override // com.alibaba.security.realidentity.build.g
    public final Class<? extends aq>[] b() {
        if (this.f3947a == null) {
            return null;
        }
        ax.a();
        Class<? extends aq>[] b4 = this.f3947a.b();
        ax.a((Class<? extends aq>[]) new Class[]{bn.class, bq.class, br.class, bs.class, bo.class, bc.class});
        ax.a(b4);
        return b4;
    }

    @Override // com.alibaba.security.realidentity.build.g
    public final Class<? extends BucketParams>[] c() {
        g gVar = this.f3947a;
        if (gVar != null) {
            return gVar.c();
        }
        return null;
    }

    @Override // com.alibaba.security.realidentity.build.g
    public final d d() {
        g gVar = this.f3947a;
        if (gVar != null) {
            return gVar.d();
        }
        return null;
    }

    public final IHttpInvoker e() {
        AbsHttpInvoker a10 = a();
        if (a10 == null) {
            return null;
        }
        return a10.getHttpInvoker();
    }

    @Override // com.alibaba.security.realidentity.build.g
    public final AbsHttpInvoker a() {
        g gVar = this.f3947a;
        if (gVar == null) {
            return null;
        }
        return gVar.a();
    }

    @Override // com.alibaba.security.realidentity.build.g
    public final f a(Context context) {
        g gVar = this.f3947a;
        if (gVar != null) {
            return gVar.a(context);
        }
        return null;
    }
}

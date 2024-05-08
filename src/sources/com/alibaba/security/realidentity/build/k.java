package com.alibaba.security.realidentity.build;

import android.content.Context;
import com.alibaba.security.realidentity.build.j;
import com.alibaba.security.realidentity.business.biometrics.BiometricsBucketParams;
import com.alibaba.security.realidentity.business.bucket.BucketParams;
import com.alibaba.security.realidentity.business.start.StartHttpParams;
import com.alibaba.security.realidentity.business.submit.SubmitHttpParams;
import com.alibaba.security.realidentity.business.upload.UploadFileParams;
import com.alibaba.security.realidentity.business.upload.UploadResultParams;
import com.alibaba.security.realidentity.http.AbsHttpInvoker;
import com.alibaba.security.realidentity.http.RPHttpInvoker;

/* compiled from: RealIdentityAdapter.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class k implements g {

    /* renamed from: a, reason: collision with root package name */
    private static final String f3945a = "k";

    @Override // com.alibaba.security.realidentity.build.g
    public final AbsHttpInvoker a() {
        return new RPHttpInvoker();
    }

    @Override // com.alibaba.security.realidentity.build.g
    public final Class<? extends aq>[] b() {
        return new Class[]{ar.class, as.class, at.class, au.class, av.class, az.class, ba.class, br.class, bs.class, be.class, bp.class};
    }

    @Override // com.alibaba.security.realidentity.build.g
    public final Class<? extends BucketParams>[] c() {
        return new Class[]{StartHttpParams.class, BiometricsBucketParams.class, UploadFileParams.class, UploadResultParams.class, SubmitHttpParams.class};
    }

    @Override // com.alibaba.security.realidentity.build.g
    public final d d() {
        return new i();
    }

    @Override // com.alibaba.security.realidentity.build.g
    public final f a(Context context) {
        if (j.a.f3944a.e()) {
            return new n().a(context);
        }
        return new m().a(context);
    }
}

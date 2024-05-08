package com.alibaba.security.realidentity.build;

import com.alibaba.security.common.http.ok.Interceptor;
import com.alibaba.security.common.http.ok.RPHttpClient;
import com.alibaba.security.common.http.ok.Response;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: NetworkProgressHelper.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class gs {

    /* compiled from: NetworkProgressHelper.java */
    /* renamed from: com.alibaba.security.realidentity.build.gs$1, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class AnonymousClass1 implements Interceptor {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ gr f3763a;

        public AnonymousClass1(gr grVar) {
            this.f3763a = grVar;
        }

        @Override // com.alibaba.security.common.http.ok.Interceptor
        public final Response intercept(Interceptor.Chain chain) throws IOException {
            Response proceed = chain.proceed(chain.request());
            return proceed.newBuilder().body(new gv(proceed.body(), this.f3763a)).build();
        }
    }

    private static RPHttpClient a(RPHttpClient rPHttpClient, gr grVar) {
        return rPHttpClient.newBuilder().addNetworkInterceptor(new AnonymousClass1(grVar)).build();
    }

    private static gu a(InputStream inputStream, long j10, String str, gr grVar) {
        return new gu(inputStream, j10, str, grVar);
    }
}

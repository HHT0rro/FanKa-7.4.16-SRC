package com.kwad.sdk.k;

import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.Response;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class a implements Interceptor {
    @Override // okhttp3.Interceptor
    public final Response intercept(Interceptor.Chain chain) {
        try {
            return chain.proceed(chain.request());
        } catch (Exception e2) {
            if (e2 instanceof IOException) {
                throw e2;
            }
            throw new IOException(e2);
        }
    }
}

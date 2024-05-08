package com.alimm.tanx.core.net.okhttp.tanxc_if;

import com.wangmai.okhttp.model.HttpHeaders;
import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.Response;

/* compiled from: NetCacheInterceptor.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class tanxc_if implements Interceptor {
    public static tanxc_if tanxc_do;
    public int tanxc_if;

    public static tanxc_if tanxc_do() {
        if (tanxc_do == null) {
            synchronized (tanxc_if.class) {
                if (tanxc_do == null) {
                    tanxc_do = new tanxc_if();
                }
            }
        }
        return tanxc_do;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Response proceed = chain.proceed(chain.request().newBuilder().build());
        int i10 = this.tanxc_if;
        if (i10 != 0) {
            Response build = proceed.newBuilder().header("Cache-Control", "public, max-age=" + i10).removeHeader(HttpHeaders.HEAD_KEY_PRAGMA).build();
            this.tanxc_if = 0;
            return build;
        }
        return proceed.newBuilder().header("Cache-Control", "no-cache").removeHeader(HttpHeaders.HEAD_KEY_PRAGMA).build();
    }

    public void tanxc_do(int i10) {
        this.tanxc_if = i10;
    }
}

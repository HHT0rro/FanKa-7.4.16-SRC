package com.alibaba.security.common.http.ok;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public interface Interceptor {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public interface Chain {
        RPCall call();

        int connectTimeoutMillis();

        Connection connection();

        Response proceed(RPRequest rPRequest) throws IOException;

        int readTimeoutMillis();

        RPRequest request();

        Chain withConnectTimeout(int i10, TimeUnit timeUnit);

        Chain withReadTimeout(int i10, TimeUnit timeUnit);

        Chain withWriteTimeout(int i10, TimeUnit timeUnit);

        int writeTimeoutMillis();
    }

    Response intercept(Chain chain) throws IOException;
}

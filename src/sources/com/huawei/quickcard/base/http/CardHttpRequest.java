package com.huawei.quickcard.base.http;

import androidx.annotation.NonNull;
import com.huawei.quickcard.base.annotation.DoNotShrink;
import java.util.Map;

@DoNotShrink
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public interface CardHttpRequest {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public enum RequestMethod {
        OPTIONS("OPTIONS"),
        GET("GET"),
        HEAD("HEAD"),
        POST("POST"),
        PUT("PUT"),
        DELETE("DELETE"),
        TRACE("TRACE"),
        CONNECT("CONNECT");


        /* renamed from: a, reason: collision with root package name */
        private final String f33359a;

        RequestMethod(String str) {
            this.f33359a = str;
        }

        public String getType() {
            return this.f33359a;
        }
    }

    @NonNull
    byte[] body();

    @NonNull
    String contentType();

    @NonNull
    Map<String, String> headers();

    @NonNull
    RequestMethod method();

    @NonNull
    String url();
}

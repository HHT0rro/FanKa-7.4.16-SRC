package com.cupidapp.live.base.network;

import java.net.URL;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.s;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;

/* compiled from: NetworkClient.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class NetworkClient$interceptor$2 extends Lambda implements Function0<Interceptor> {
    public static final NetworkClient$interceptor$2 INSTANCE = new NetworkClient$interceptor$2();

    public NetworkClient$interceptor$2() {
        super(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Response invoke$lambda$1(Interceptor.Chain chain) {
        s.i(chain, "chain");
        Request request = chain.request();
        NetworkClient networkClient = NetworkClient.f11868a;
        String host = new URL(networkClient.k()).getHost();
        s.h(host, "URL(ENDPOINT).host");
        String lowerCase = host.toLowerCase();
        s.h(lowerCase, "this as java.lang.String).toLowerCase()");
        String host2 = request.url().url().getHost();
        s.h(host2, "request.url.toUrl().host");
        String lowerCase2 = host2.toLowerCase();
        s.h(lowerCase2, "this as java.lang.String).toLowerCase()");
        if (s.d(lowerCase, lowerCase2)) {
            Map<String, String> o10 = networkClient.o();
            Request.Builder b4 = l1.b.f51580a.b(chain.request(), o10);
            for (Map.Entry<String, String> entry : o10.entrySet()) {
                b4.addHeader(entry.getKey(), entry.getValue());
            }
            String k10 = a.f11902a.k();
            if (!(k10 == null || k10.length() == 0)) {
                b4.removeHeader("User-Agent");
                b4.addHeader("User-Agent", k10);
            }
            request = b4.build();
        }
        return chain.proceed(request);
    }

    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final Interceptor invoke() {
        return new Interceptor() { // from class: com.cupidapp.live.base.network.c
            @Override // okhttp3.Interceptor
            public final Response intercept(Interceptor.Chain chain) {
                Response invoke$lambda$1;
                invoke$lambda$1 = NetworkClient$interceptor$2.invoke$lambda$1(chain);
                return invoke$lambda$1;
            }
        };
    }
}

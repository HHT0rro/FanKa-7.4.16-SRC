package com.hifive.sdk.utils;

import java.security.cert.X509Certificate;
import javax.net.ssl.X509TrustManager;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: TrustAllCerts.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class TrustAllCerts implements X509TrustManager {
    @Override // javax.net.ssl.X509TrustManager
    public void checkClientTrusted(@NotNull X509Certificate[] chain, @NotNull String authType) {
        s.j(chain, "chain");
        s.j(authType, "authType");
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkServerTrusted(@NotNull X509Certificate[] chain, @NotNull String authType) {
        s.j(chain, "chain");
        s.j(authType, "authType");
    }

    @Override // javax.net.ssl.X509TrustManager
    @NotNull
    public X509Certificate[] getAcceptedIssuers() {
        return new X509Certificate[0];
    }
}

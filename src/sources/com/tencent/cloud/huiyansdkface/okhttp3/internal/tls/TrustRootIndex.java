package com.tencent.cloud.huiyansdkface.okhttp3.internal.tls;

import java.security.cert.X509Certificate;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public interface TrustRootIndex {
    X509Certificate findByIssuerAndSignature(X509Certificate x509Certificate);
}

package com.alibaba.security.common.http.ok.internal.tls;

import java.security.cert.X509Certificate;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public interface TrustRootIndex {
    X509Certificate findByIssuerAndSignature(X509Certificate x509Certificate);
}

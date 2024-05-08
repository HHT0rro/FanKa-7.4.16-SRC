package com.bytedance.pangle.g;

import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import java.util.Arrays;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
final class p extends r {

    /* renamed from: a, reason: collision with root package name */
    private final byte[] f10812a;

    /* renamed from: b, reason: collision with root package name */
    private int f10813b;

    public p(X509Certificate x509Certificate, byte[] bArr) {
        super(x509Certificate);
        this.f10813b = -1;
        this.f10812a = bArr;
    }

    @Override // java.security.cert.Certificate
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof p)) {
            return false;
        }
        try {
            return Arrays.equals(getEncoded(), ((p) obj).getEncoded());
        } catch (CertificateEncodingException unused) {
            return false;
        }
    }

    @Override // com.bytedance.pangle.g.r, java.security.cert.Certificate
    public final byte[] getEncoded() {
        return this.f10812a;
    }

    @Override // java.security.cert.Certificate
    public final int hashCode() {
        if (this.f10813b == -1) {
            try {
                this.f10813b = Arrays.hashCode(getEncoded());
            } catch (CertificateEncodingException unused) {
                this.f10813b = 0;
            }
        }
        return this.f10813b;
    }
}
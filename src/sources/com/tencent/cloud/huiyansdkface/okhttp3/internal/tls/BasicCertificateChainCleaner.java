package com.tencent.cloud.huiyansdkface.okhttp3.internal.tls;

import java.security.GeneralSecurityException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class BasicCertificateChainCleaner extends CertificateChainCleaner {

    /* renamed from: a, reason: collision with root package name */
    private final TrustRootIndex f42013a;

    public BasicCertificateChainCleaner(TrustRootIndex trustRootIndex) {
        this.f42013a = trustRootIndex;
    }

    private boolean a(X509Certificate x509Certificate, X509Certificate x509Certificate2) {
        if (!x509Certificate.getIssuerDN().equals(x509Certificate2.getSubjectDN())) {
            return false;
        }
        try {
            x509Certificate.verify(x509Certificate2.getPublicKey());
            return true;
        } catch (GeneralSecurityException unused) {
            return false;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.cloud.huiyansdkface.okhttp3.internal.tls.CertificateChainCleaner
    public List<Certificate> clean(List<Certificate> list, String str) throws SSLPeerUnverifiedException {
        ArrayDeque arrayDeque = new ArrayDeque(list);
        ArrayList arrayList = new ArrayList();
        arrayList.add(arrayDeque.removeFirst());
        boolean z10 = false;
        for (int i10 = 0; i10 < 9; i10++) {
            X509Certificate x509Certificate = (X509Certificate) arrayList.get(arrayList.size() - 1);
            X509Certificate findByIssuerAndSignature = this.f42013a.findByIssuerAndSignature(x509Certificate);
            if (findByIssuerAndSignature == null) {
                Iterator<E> iterator2 = arrayDeque.iterator2();
                while (iterator2.hasNext()) {
                    X509Certificate x509Certificate2 = (X509Certificate) iterator2.next();
                    if (a(x509Certificate, x509Certificate2)) {
                        iterator2.remove();
                        arrayList.add(x509Certificate2);
                    }
                }
                if (z10) {
                    return arrayList;
                }
                throw new SSLPeerUnverifiedException("Failed to find a trusted cert that signed " + ((Object) x509Certificate));
            }
            if (arrayList.size() > 1 || !x509Certificate.equals(findByIssuerAndSignature)) {
                arrayList.add(findByIssuerAndSignature);
            }
            if (a(findByIssuerAndSignature, findByIssuerAndSignature)) {
                return arrayList;
            }
            z10 = true;
        }
        throw new SSLPeerUnverifiedException("Certificate chain too long: " + ((Object) arrayList));
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof BasicCertificateChainCleaner) && ((BasicCertificateChainCleaner) obj).f42013a.equals(this.f42013a);
    }

    public int hashCode() {
        return this.f42013a.hashCode();
    }
}

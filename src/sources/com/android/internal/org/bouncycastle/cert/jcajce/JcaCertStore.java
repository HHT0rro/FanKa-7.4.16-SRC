package com.android.internal.org.bouncycastle.cert.jcajce;

import com.android.internal.org.bouncycastle.cert.X509CertificateHolder;
import com.android.internal.org.bouncycastle.util.CollectionStore;
import java.io.IOException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class JcaCertStore extends CollectionStore {
    public JcaCertStore(Collection collection) throws CertificateEncodingException {
        super(convertCerts(collection));
    }

    private static Collection convertCerts(Collection collection) throws CertificateEncodingException {
        List list = new ArrayList(collection.size());
        for (Object o10 : collection) {
            if (o10 instanceof X509Certificate) {
                X509Certificate cert = (X509Certificate) o10;
                try {
                    list.add(new X509CertificateHolder(cert.getEncoded()));
                } catch (IOException e2) {
                    throw new CertificateEncodingException("unable to read encoding: " + e2.getMessage());
                }
            } else {
                list.add((X509CertificateHolder) o10);
            }
        }
        return list;
    }
}

package com.android.internal.org.bouncycastle.jce.provider;

import com.android.internal.org.bouncycastle.jcajce.PKIXCRLStoreSelector;
import java.security.cert.CertStore;
import java.security.cert.CertStoreException;
import java.security.cert.X509CRL;
import java.security.cert.X509Certificate;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
abstract class PKIXCRLUtil {
    PKIXCRLUtil() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Set findCRLs(PKIXCRLStoreSelector crlselect, Date validityDate, List certStores, List pkixCrlStores) throws AnnotatedException {
        X509Certificate cert;
        HashSet initialSet = new HashSet();
        try {
            findCRLs(initialSet, crlselect, pkixCrlStores);
            findCRLs(initialSet, crlselect, certStores);
            Set finalSet = new HashSet();
            Iterator it = initialSet.iterator2();
            while (it.hasNext()) {
                X509CRL crl = (X509CRL) it.next();
                if (crl.getNextUpdate().after(validityDate) && ((cert = crlselect.getCertificateChecking()) == null || crl.getThisUpdate().before(cert.getNotAfter()))) {
                    finalSet.add(crl);
                }
            }
            return finalSet;
        } catch (AnnotatedException e2) {
            throw new AnnotatedException("Exception obtaining complete CRLs.", e2);
        }
    }

    private static void findCRLs(HashSet crls, PKIXCRLStoreSelector crlSelect, List crlStores) throws AnnotatedException {
        AnnotatedException lastException = null;
        boolean foundValidStore = false;
        for (Object obj : crlStores) {
            CertStore store = (CertStore) obj;
            try {
                crls.addAll(PKIXCRLStoreSelector.getCRLs(crlSelect, store));
                foundValidStore = true;
            } catch (CertStoreException e2) {
                lastException = new AnnotatedException("Exception searching in X.509 CRL store.", e2);
            }
        }
        if (!foundValidStore && lastException != null) {
            throw lastException;
        }
    }
}

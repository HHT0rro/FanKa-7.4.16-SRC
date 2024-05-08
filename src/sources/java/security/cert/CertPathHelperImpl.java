package java.security.cert;

import java.util.Date;
import java.util.Set;
import sun.security.provider.certpath.CertPathHelper;
import sun.security.x509.GeneralNameInterface;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
class CertPathHelperImpl extends CertPathHelper {
    private CertPathHelperImpl() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized void initialize() {
        synchronized (CertPathHelperImpl.class) {
            if (CertPathHelper.instance == null) {
                CertPathHelper.instance = new CertPathHelperImpl();
            }
        }
    }

    @Override // sun.security.provider.certpath.CertPathHelper
    protected void implSetPathToNames(X509CertSelector sel, Set<GeneralNameInterface> names) {
        sel.setPathToNamesInternal(names);
    }

    @Override // sun.security.provider.certpath.CertPathHelper
    protected void implSetDateAndTime(X509CRLSelector sel, Date date, long skew) {
        sel.setDateAndTime(date, skew);
    }
}

package sun.security.provider.certpath;

import java.security.cert.X509CRLSelector;
import java.security.cert.X509CertSelector;
import java.util.Date;
import java.util.Set;
import sun.security.x509.GeneralNameInterface;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public abstract class CertPathHelper {
    protected static CertPathHelper instance;

    protected abstract void implSetDateAndTime(X509CRLSelector x509CRLSelector, Date date, long j10);

    protected abstract void implSetPathToNames(X509CertSelector x509CertSelector, Set<GeneralNameInterface> set);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setPathToNames(X509CertSelector sel, Set<GeneralNameInterface> names) {
        instance.implSetPathToNames(sel, names);
    }

    public static void setDateAndTime(X509CRLSelector sel, Date date, long skew) {
        instance.implSetDateAndTime(sel, date, skew);
    }
}

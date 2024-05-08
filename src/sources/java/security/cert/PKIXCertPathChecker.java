package java.security.cert;

import java.util.Collection;
import java.util.Collections;
import java.util.Set;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public abstract class PKIXCertPathChecker implements CertPathChecker, Cloneable {
    public abstract void check(Certificate certificate, Collection<String> collection) throws CertPathValidatorException;

    public abstract Set<String> getSupportedExtensions();

    @Override // java.security.cert.CertPathChecker
    public abstract void init(boolean z10) throws CertPathValidatorException;

    @Override // java.security.cert.CertPathChecker
    public abstract boolean isForwardCheckingSupported();

    @Override // java.security.cert.CertPathChecker
    public void check(Certificate cert) throws CertPathValidatorException {
        check(cert, Collections.emptySet());
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e2) {
            throw new InternalError(e2.toString(), e2);
        }
    }
}

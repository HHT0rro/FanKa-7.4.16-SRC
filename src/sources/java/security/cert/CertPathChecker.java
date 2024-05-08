package java.security.cert;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public interface CertPathChecker {
    void check(Certificate certificate) throws CertPathValidatorException;

    void init(boolean z10) throws CertPathValidatorException;

    boolean isForwardCheckingSupported();
}

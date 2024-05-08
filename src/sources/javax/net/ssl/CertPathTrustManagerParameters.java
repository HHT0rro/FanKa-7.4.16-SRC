package javax.net.ssl;

import java.security.cert.CertPathParameters;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class CertPathTrustManagerParameters implements ManagerFactoryParameters {
    private final CertPathParameters parameters;

    public CertPathTrustManagerParameters(CertPathParameters parameters) {
        this.parameters = (CertPathParameters) parameters.clone();
    }

    public CertPathParameters getParameters() {
        return (CertPathParameters) this.parameters.clone();
    }
}

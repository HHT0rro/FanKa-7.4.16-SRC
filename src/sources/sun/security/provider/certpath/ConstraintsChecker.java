package sun.security.provider.certpath;

import java.io.IOException;
import java.security.cert.CertPathValidatorException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.PKIXCertPathChecker;
import java.security.cert.PKIXReason;
import java.security.cert.X509Certificate;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import sun.security.util.Debug;
import sun.security.x509.NameConstraintsExtension;
import sun.security.x509.PKIXExtensions;
import sun.security.x509.X509CertImpl;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
class ConstraintsChecker extends PKIXCertPathChecker {
    private static final Debug debug = Debug.getInstance("certpath");
    private final int certPathLength;

    /* renamed from: i, reason: collision with root package name */
    private int f53741i;
    private int maxPathLength;
    private NameConstraintsExtension prevNC;
    private Set<String> supportedExts;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ConstraintsChecker(int certPathLength) {
        this.certPathLength = certPathLength;
    }

    @Override // java.security.cert.PKIXCertPathChecker, java.security.cert.CertPathChecker
    public void init(boolean forward) throws CertPathValidatorException {
        if (!forward) {
            this.f53741i = 0;
            this.maxPathLength = this.certPathLength;
            this.prevNC = null;
            return;
        }
        throw new CertPathValidatorException("forward checking not supported");
    }

    @Override // java.security.cert.PKIXCertPathChecker, java.security.cert.CertPathChecker
    public boolean isForwardCheckingSupported() {
        return false;
    }

    @Override // java.security.cert.PKIXCertPathChecker
    public Set<String> getSupportedExtensions() {
        if (this.supportedExts == null) {
            HashSet hashSet = new HashSet(2);
            this.supportedExts = hashSet;
            hashSet.add(PKIXExtensions.BasicConstraints_Id.toString());
            this.supportedExts.add(PKIXExtensions.NameConstraints_Id.toString());
            this.supportedExts = Collections.unmodifiableSet(this.supportedExts);
        }
        return this.supportedExts;
    }

    @Override // java.security.cert.PKIXCertPathChecker
    public void check(Certificate cert, Collection<String> unresCritExts) throws CertPathValidatorException {
        X509Certificate currCert = (X509Certificate) cert;
        this.f53741i++;
        checkBasicConstraints(currCert);
        verifyNameConstraints(currCert);
        if (unresCritExts != null && !unresCritExts.isEmpty()) {
            unresCritExts.remove(PKIXExtensions.BasicConstraints_Id.toString());
            unresCritExts.remove(PKIXExtensions.NameConstraints_Id.toString());
        }
    }

    private void verifyNameConstraints(X509Certificate currCert) throws CertPathValidatorException {
        Debug debug2 = debug;
        if (debug2 != null) {
            debug2.println("---checking name constraints...");
        }
        if (this.prevNC != null && (this.f53741i == this.certPathLength || !X509CertImpl.isSelfIssued(currCert))) {
            if (debug2 != null) {
                debug2.println("prevNC = " + ((Object) this.prevNC) + ", currDN = " + ((Object) currCert.getSubjectX500Principal()));
            }
            try {
                if (!this.prevNC.verify(currCert)) {
                    throw new CertPathValidatorException("name constraints check failed", null, null, -1, PKIXReason.INVALID_NAME);
                }
            } catch (IOException ioe) {
                throw new CertPathValidatorException(ioe);
            }
        }
        this.prevNC = mergeNameConstraints(currCert, this.prevNC);
        if (debug2 != null) {
            debug2.println("name constraints verified.");
        }
    }

    static NameConstraintsExtension mergeNameConstraints(X509Certificate currCert, NameConstraintsExtension prevNC) throws CertPathValidatorException {
        try {
            X509CertImpl currCertImpl = X509CertImpl.toImpl(currCert);
            NameConstraintsExtension newConstraints = currCertImpl.getNameConstraintsExtension();
            Debug debug2 = debug;
            if (debug2 != null) {
                debug2.println("prevNC = " + ((Object) prevNC) + ", newNC = " + String.valueOf(newConstraints));
            }
            if (prevNC == null) {
                if (debug2 != null) {
                    debug2.println("mergedNC = " + String.valueOf(newConstraints));
                }
                if (newConstraints == null) {
                    return newConstraints;
                }
                return (NameConstraintsExtension) newConstraints.clone();
            }
            try {
                prevNC.merge(newConstraints);
                if (debug2 != null) {
                    debug2.println("mergedNC = " + ((Object) prevNC));
                }
                return prevNC;
            } catch (IOException ioe) {
                throw new CertPathValidatorException(ioe);
            }
        } catch (CertificateException ce2) {
            throw new CertPathValidatorException(ce2);
        }
    }

    private void checkBasicConstraints(X509Certificate currCert) throws CertPathValidatorException {
        Debug debug2 = debug;
        if (debug2 != null) {
            debug2.println("---checking basic constraints...");
            debug2.println("i = " + this.f53741i + ", maxPathLength = " + this.maxPathLength);
        }
        if (this.f53741i < this.certPathLength) {
            int pathLenConstraint = -1;
            if (currCert.getVersion() < 3) {
                if (this.f53741i == 1 && X509CertImpl.isSelfIssued(currCert)) {
                    pathLenConstraint = Integer.MAX_VALUE;
                }
            } else {
                pathLenConstraint = currCert.getBasicConstraints();
            }
            if (pathLenConstraint == -1) {
                throw new CertPathValidatorException("basic constraints check failed: this is not a CA certificate", null, null, -1, PKIXReason.NOT_CA_CERT);
            }
            if (!X509CertImpl.isSelfIssued(currCert)) {
                int i10 = this.maxPathLength;
                if (i10 <= 0) {
                    throw new CertPathValidatorException("basic constraints check failed: pathLenConstraint violated - this cert must be the last cert in the certification path", null, null, -1, PKIXReason.PATH_TOO_LONG);
                }
                this.maxPathLength = i10 - 1;
            }
            if (pathLenConstraint < this.maxPathLength) {
                this.maxPathLength = pathLenConstraint;
            }
        }
        if (debug2 != null) {
            debug2.println("after processing, maxPathLength = " + this.maxPathLength);
            debug2.println("basic constraints verified.");
        }
    }

    static int mergeBasicConstraints(X509Certificate cert, int maxPathLength) {
        int pathLenConstraint = cert.getBasicConstraints();
        if (!X509CertImpl.isSelfIssued(cert)) {
            maxPathLength--;
        }
        if (pathLenConstraint < maxPathLength) {
            return pathLenConstraint;
        }
        return maxPathLength;
    }
}

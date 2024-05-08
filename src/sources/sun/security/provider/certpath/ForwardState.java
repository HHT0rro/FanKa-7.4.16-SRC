package sun.security.provider.certpath;

import java.io.IOException;
import java.security.cert.CertPathValidatorException;
import java.security.cert.CertificateException;
import java.security.cert.PKIXCertPathChecker;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.ListIterator;
import javax.security.auth.x500.X500Principal;
import sun.security.util.Debug;
import sun.security.x509.GeneralName;
import sun.security.x509.GeneralNameInterface;
import sun.security.x509.GeneralNames;
import sun.security.x509.SubjectAlternativeNameExtension;
import sun.security.x509.X500Name;
import sun.security.x509.X509CertImpl;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
class ForwardState implements State {
    private static final Debug debug = Debug.getInstance("certpath");
    X509CertImpl cert;
    ArrayList<PKIXCertPathChecker> forwardCheckers;
    X500Principal issuerDN;
    HashSet<GeneralNameInterface> subjectNamesTraversed;
    int traversedCACerts;
    private boolean init = true;
    boolean keyParamsNeededFlag = false;

    @Override // sun.security.provider.certpath.State
    public boolean isInitial() {
        return this.init;
    }

    @Override // sun.security.provider.certpath.State
    public boolean keyParamsNeeded() {
        return this.keyParamsNeededFlag;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("State [");
        sb2.append("\n  issuerDN of last cert: ").append((Object) this.issuerDN);
        sb2.append("\n  traversedCACerts: ").append(this.traversedCACerts);
        sb2.append("\n  init: ").append(String.valueOf(this.init));
        sb2.append("\n  keyParamsNeeded: ").append(String.valueOf(this.keyParamsNeededFlag));
        sb2.append("\n  subjectNamesTraversed: \n").append((Object) this.subjectNamesTraversed);
        sb2.append("]\n");
        return sb2.toString();
    }

    public void initState(List<PKIXCertPathChecker> certPathCheckers) throws CertPathValidatorException {
        this.subjectNamesTraversed = new HashSet<>();
        this.traversedCACerts = 0;
        this.forwardCheckers = new ArrayList<>();
        for (PKIXCertPathChecker checker : certPathCheckers) {
            if (checker.isForwardCheckingSupported()) {
                checker.init(true);
                this.forwardCheckers.add(checker);
            }
        }
        this.init = true;
    }

    @Override // sun.security.provider.certpath.State
    public void updateState(X509Certificate cert) throws CertificateException, IOException, CertPathValidatorException {
        if (cert == null) {
            return;
        }
        X509CertImpl icert = X509CertImpl.toImpl(cert);
        if (PKIX.isDSAPublicKeyWithoutParams(icert.getPublicKey())) {
            this.keyParamsNeededFlag = true;
        }
        this.cert = icert;
        this.issuerDN = cert.getIssuerX500Principal();
        if (!X509CertImpl.isSelfIssued(cert) && !this.init && cert.getBasicConstraints() != -1) {
            this.traversedCACerts++;
        }
        if (this.init || !X509CertImpl.isSelfIssued(cert)) {
            X500Principal subjName = cert.getSubjectX500Principal();
            this.subjectNamesTraversed.add(X500Name.asX500Name(subjName));
            try {
                SubjectAlternativeNameExtension subjAltNameExt = icert.getSubjectAlternativeNameExtension();
                if (subjAltNameExt != null) {
                    GeneralNames gNames = subjAltNameExt.get(SubjectAlternativeNameExtension.SUBJECT_NAME);
                    for (GeneralName gName : gNames.names()) {
                        this.subjectNamesTraversed.add(gName.getName());
                    }
                }
            } catch (IOException e2) {
                Debug debug2 = debug;
                if (debug2 != null) {
                    debug2.println("ForwardState.updateState() unexpected exception");
                    e2.printStackTrace();
                }
                throw new CertPathValidatorException(e2);
            }
        }
        this.init = false;
    }

    @Override // sun.security.provider.certpath.State
    public Object clone() {
        try {
            ForwardState clonedState = (ForwardState) super.clone();
            ArrayList<PKIXCertPathChecker> arrayList = (ArrayList) this.forwardCheckers.clone();
            clonedState.forwardCheckers = arrayList;
            ListIterator<PKIXCertPathChecker> li = arrayList.listIterator();
            while (li.hasNext()) {
                PKIXCertPathChecker checker = li.next();
                if (checker instanceof Cloneable) {
                    li.set((PKIXCertPathChecker) checker.clone());
                }
            }
            clonedState.subjectNamesTraversed = (HashSet) this.subjectNamesTraversed.clone();
            return clonedState;
        } catch (CloneNotSupportedException e2) {
            throw new InternalError(e2.toString(), e2);
        }
    }
}

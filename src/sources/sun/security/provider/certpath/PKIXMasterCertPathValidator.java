package sun.security.provider.certpath;

import com.alipay.sdk.util.i;
import java.security.cert.CertPath;
import java.security.cert.CertPathValidatorException;
import java.security.cert.PKIXCertPathChecker;
import java.security.cert.PKIXReason;
import java.security.cert.X509Certificate;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.StringJoiner;
import sun.security.util.Debug;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
class PKIXMasterCertPathValidator {
    private static final Debug debug = Debug.getInstance("certpath");

    PKIXMasterCertPathValidator() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void validate(CertPath cpOriginal, List<X509Certificate> reversedCertList, List<PKIXCertPathChecker> certPathCheckers) throws CertPathValidatorException {
        int cpSize = reversedCertList.size();
        Debug debug2 = debug;
        if (debug2 != null) {
            debug2.println("--------------------------------------------------------------");
            debug2.println("Executing PKIX certification path validation algorithm.");
        }
        for (int i10 = 0; i10 < cpSize; i10++) {
            X509Certificate currCert = reversedCertList.get(i10);
            Debug debug3 = debug;
            if (debug3 != null) {
                debug3.println("Checking cert" + (i10 + 1) + " - Subject: " + ((Object) currCert.getSubjectX500Principal()));
            }
            Set<String> unresCritExts = currCert.getCriticalExtensionOIDs();
            if (unresCritExts == null) {
                unresCritExts = Collections.emptySet();
            }
            if (debug3 != null && !unresCritExts.isEmpty()) {
                StringJoiner joiner = new StringJoiner(", ", "{", i.f4738d);
                for (String oid : unresCritExts) {
                    joiner.add(oid);
                }
                debug.println("Set of critical extensions: " + joiner.toString());
            }
            for (int j10 = 0; j10 < certPathCheckers.size(); j10++) {
                PKIXCertPathChecker currChecker = certPathCheckers.get(j10);
                Debug debug4 = debug;
                if (debug4 != null) {
                    debug4.println("-Using checker" + (j10 + 1) + " ... [" + currChecker.getClass().getName() + "]");
                }
                if (i10 == 0) {
                    currChecker.init(false);
                }
                try {
                    currChecker.check(currCert, unresCritExts);
                    if (debug4 != null) {
                        debug4.println("-checker" + (j10 + 1) + " validation succeeded");
                    }
                } catch (CertPathValidatorException cpve) {
                    throw new CertPathValidatorException(cpve.getMessage(), cpve.getCause() != null ? cpve.getCause() : cpve, cpOriginal, cpSize - (i10 + 1), cpve.getReason());
                }
            }
            if (!unresCritExts.isEmpty()) {
                throw new CertPathValidatorException("unrecognized critical extension(s)", null, cpOriginal, cpSize - (i10 + 1), PKIXReason.UNRECOGNIZED_CRIT_EXT);
            }
            Debug debug5 = debug;
            if (debug5 != null) {
                debug5.println("\ncert" + (i10 + 1) + " validation succeeded.\n");
            }
        }
        Debug debug6 = debug;
        if (debug6 != null) {
            debug6.println("Cert path validation succeeded. (PKIX validation algorithm)");
            debug6.println("--------------------------------------------------------------");
        }
    }
}

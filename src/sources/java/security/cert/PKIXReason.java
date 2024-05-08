package java.security.cert;

import java.security.cert.CertPathValidatorException;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public enum PKIXReason implements CertPathValidatorException.Reason {
    NAME_CHAINING,
    INVALID_KEY_USAGE,
    INVALID_POLICY,
    NO_TRUST_ANCHOR,
    UNRECOGNIZED_CRIT_EXT,
    NOT_CA_CERT,
    PATH_TOO_LONG,
    INVALID_NAME
}

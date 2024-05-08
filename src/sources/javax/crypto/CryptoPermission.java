package javax.crypto;

import java.security.Permission;
import java.security.spec.AlgorithmParameterSpec;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
class CryptoPermission extends Permission {
    static final String ALG_NAME_WILDCARD = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CryptoPermission(String alg) {
        super("");
    }

    CryptoPermission(String alg, int maxKeySize) {
        super("");
    }

    CryptoPermission(String alg, int maxKeySize, AlgorithmParameterSpec algParamSpec) {
        super("");
    }

    CryptoPermission(String alg, String exemptionMechanism) {
        super("");
    }

    CryptoPermission(String alg, int maxKeySize, String exemptionMechanism) {
        super("");
    }

    CryptoPermission(String alg, int maxKeySize, AlgorithmParameterSpec algParamSpec, String exemptionMechanism) {
        super("");
    }

    @Override // java.security.Permission
    public boolean implies(Permission p10) {
        return true;
    }

    @Override // java.security.Permission
    public String getActions() {
        return null;
    }

    final String getAlgorithm() {
        return null;
    }

    final String getExemptionMechanism() {
        return null;
    }

    final int getMaxKeySize() {
        return Integer.MAX_VALUE;
    }

    final boolean getCheckParam() {
        return false;
    }

    final AlgorithmParameterSpec getAlgorithmParameterSpec() {
        return null;
    }
}

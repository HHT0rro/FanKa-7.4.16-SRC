package sun.security.util;

import java.security.AccessController;
import java.security.AlgorithmConstraints;
import java.security.PrivilegedAction;
import java.security.Security;
import java.util.Set;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public abstract class AbstractAlgorithmConstraints implements AlgorithmConstraints {
    protected final AlgorithmDecomposer decomposer;

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractAlgorithmConstraints(AlgorithmDecomposer decomposer) {
        this.decomposer = decomposer;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String[] getAlgorithms(final String propertyName) {
        String property = (String) AccessController.doPrivileged(new PrivilegedAction<String>() { // from class: sun.security.util.AbstractAlgorithmConstraints.1
            @Override // java.security.PrivilegedAction
            public String run() {
                return Security.getProperty(String.this);
            }
        });
        String[] algorithmsInProperty = null;
        if (property != null && !property.isEmpty()) {
            if (property.length() >= 2 && property.charAt(0) == '\"' && property.charAt(property.length() - 1) == '\"') {
                property = property.substring(1, property.length() - 1);
            }
            algorithmsInProperty = property.split(",");
            for (int i10 = 0; i10 < algorithmsInProperty.length; i10++) {
                algorithmsInProperty[i10] = algorithmsInProperty[i10].trim();
            }
        }
        if (algorithmsInProperty == null) {
            return new String[0];
        }
        return algorithmsInProperty;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean checkAlgorithm(String[] algorithms, String algorithm, AlgorithmDecomposer decomposer) {
        if (algorithm == null || algorithm.length() == 0) {
            throw new IllegalArgumentException("No algorithm name specified");
        }
        Set<String> elements = null;
        for (String item : algorithms) {
            if (item != null && !item.isEmpty()) {
                if (item.equalsIgnoreCase(algorithm)) {
                    return false;
                }
                if (elements == null) {
                    elements = decomposer.decompose(algorithm);
                }
                for (String element : elements) {
                    if (item.equalsIgnoreCase(element)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}

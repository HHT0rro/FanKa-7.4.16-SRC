package com.android.internal.org.bouncycastle.jcajce.provider.symmetric.util;

import java.security.AlgorithmParameters;
import java.security.spec.AlgorithmParameterSpec;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
class SpecUtil {
    SpecUtil() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static AlgorithmParameterSpec extractSpec(AlgorithmParameters params, Class[] availableSpecs) {
        try {
            return params.getParameterSpec(AlgorithmParameterSpec.class);
        } catch (Exception e2) {
            for (int i10 = 0; i10 != availableSpecs.length; i10++) {
                if (availableSpecs[i10] != null) {
                    try {
                        return params.getParameterSpec(availableSpecs[i10]);
                    } catch (Exception e10) {
                    }
                }
            }
            return null;
        }
    }
}

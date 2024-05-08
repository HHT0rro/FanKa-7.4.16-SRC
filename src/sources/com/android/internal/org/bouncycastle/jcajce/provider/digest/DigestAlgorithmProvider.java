package com.android.internal.org.bouncycastle.jcajce.provider.digest;

import com.android.internal.org.bouncycastle.asn1.ASN1ObjectIdentifier;
import com.android.internal.org.bouncycastle.jcajce.provider.config.ConfigurableProvider;
import com.android.internal.org.bouncycastle.jcajce.provider.util.AlgorithmProvider;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
abstract class DigestAlgorithmProvider extends AlgorithmProvider {
    protected void addHMACAlgorithm(ConfigurableProvider provider, String algorithm, String algorithmClassName, String keyGeneratorClassName) {
        String mainName = "HMAC" + algorithm;
        provider.addAlgorithm("Mac." + mainName, algorithmClassName);
        provider.addAlgorithm("Alg.Alias.Mac.HMAC-" + algorithm, mainName);
        provider.addAlgorithm("Alg.Alias.Mac.HMAC/" + algorithm, mainName);
        provider.addAlgorithm("KeyGenerator." + mainName, keyGeneratorClassName);
        provider.addAlgorithm("Alg.Alias.KeyGenerator.HMAC-" + algorithm, mainName);
        provider.addAlgorithm("Alg.Alias.KeyGenerator.HMAC/" + algorithm, mainName);
    }

    protected void addHMACAlias(ConfigurableProvider provider, String algorithm, ASN1ObjectIdentifier oid) {
        String mainName = "HMAC" + algorithm;
        provider.addAlgorithm("Alg.Alias.Mac." + ((Object) oid), mainName);
        provider.addAlgorithm("Alg.Alias.KeyGenerator." + ((Object) oid), mainName);
    }
}

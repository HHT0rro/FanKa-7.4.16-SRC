package com.android.internal.org.bouncycastle.jcajce.provider.util;

import com.android.internal.org.bouncycastle.asn1.ASN1ObjectIdentifier;
import com.android.internal.org.bouncycastle.jcajce.provider.config.ConfigurableProvider;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public abstract class AsymmetricAlgorithmProvider extends AlgorithmProvider {
    protected void addSignatureAlgorithm(ConfigurableProvider provider, String algorithm, String className, ASN1ObjectIdentifier oid) {
        provider.addAlgorithm("Signature." + algorithm, className);
        provider.addAlgorithm("Alg.Alias.Signature." + ((Object) oid), algorithm);
        provider.addAlgorithm("Alg.Alias.Signature.OID." + ((Object) oid), algorithm);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void addSignatureAlgorithm(ConfigurableProvider provider, String digest, String algorithm, String className, ASN1ObjectIdentifier oid) {
        String mainName = digest + "WITH" + algorithm;
        String jdk11Variation1 = digest + "with" + algorithm;
        String jdk11Variation2 = digest + "With" + algorithm;
        String alias = digest + "/" + algorithm;
        provider.addAlgorithm("Signature." + mainName, className);
        provider.addAlgorithm("Alg.Alias.Signature." + jdk11Variation1, mainName);
        provider.addAlgorithm("Alg.Alias.Signature." + jdk11Variation2, mainName);
        provider.addAlgorithm("Alg.Alias.Signature." + alias, mainName);
        provider.addAlgorithm("Alg.Alias.Signature." + ((Object) oid), mainName);
        provider.addAlgorithm("Alg.Alias.Signature.OID." + ((Object) oid), mainName);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void registerOid(ConfigurableProvider provider, ASN1ObjectIdentifier oid, String name, AsymmetricKeyInfoConverter keyFactory) {
        provider.addAlgorithm("Alg.Alias.KeyFactory." + ((Object) oid), name);
        provider.addAlgorithm("Alg.Alias.KeyPairGenerator." + ((Object) oid), name);
        provider.addKeyInfoConverter(oid, keyFactory);
    }

    protected void registerOidAlgorithmParameters(ConfigurableProvider provider, ASN1ObjectIdentifier oid, String name) {
        provider.addAlgorithm("Alg.Alias.AlgorithmParameters." + ((Object) oid), name);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void registerOidAlgorithmParameterGenerator(ConfigurableProvider provider, ASN1ObjectIdentifier oid, String name) {
        provider.addAlgorithm("Alg.Alias.AlgorithmParameterGenerator." + ((Object) oid), name);
        provider.addAlgorithm("Alg.Alias.AlgorithmParameters." + ((Object) oid), name);
    }
}

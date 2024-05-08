package com.android.internal.org.bouncycastle.jcajce.provider.asymmetric.ec;

import com.android.internal.org.bouncycastle.asn1.x9.X9IntegerConverter;
import com.android.internal.org.bouncycastle.crypto.BasicAgreement;
import com.android.internal.org.bouncycastle.crypto.CipherParameters;
import com.android.internal.org.bouncycastle.crypto.DerivationFunction;
import com.android.internal.org.bouncycastle.crypto.agreement.ECDHBasicAgreement;
import com.android.internal.org.bouncycastle.crypto.params.ECDomainParameters;
import com.android.internal.org.bouncycastle.crypto.params.ECPrivateKeyParameters;
import com.android.internal.org.bouncycastle.jcajce.provider.asymmetric.util.BaseAgreementSpi;
import com.android.internal.org.bouncycastle.jcajce.provider.asymmetric.util.ECUtil;
import com.android.internal.org.bouncycastle.jcajce.spec.UserKeyingMaterialSpec;
import com.android.internal.org.bouncycastle.jce.interfaces.ECPrivateKey;
import com.android.internal.org.bouncycastle.jce.interfaces.ECPublicKey;
import com.android.internal.org.bouncycastle.util.Arrays;
import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class KeyAgreementSpi extends BaseAgreementSpi {
    private static final X9IntegerConverter converter = new X9IntegerConverter();
    private Object agreement;
    private String kaAlgorithm;
    private ECDomainParameters parameters;
    private byte[] result;

    protected KeyAgreementSpi(String kaAlgorithm, BasicAgreement agreement, DerivationFunction kdf) {
        super(kaAlgorithm, kdf);
        this.kaAlgorithm = kaAlgorithm;
        this.agreement = agreement;
    }

    protected byte[] bigIntToBytes(BigInteger r10) {
        X9IntegerConverter x9IntegerConverter = converter;
        return x9IntegerConverter.integerToBytes(r10, x9IntegerConverter.getByteLength(this.parameters.getCurve()));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // javax.crypto.KeyAgreementSpi
    public Key engineDoPhase(Key key, boolean lastPhase) throws InvalidKeyException, IllegalStateException {
        if (this.parameters == null) {
            throw new IllegalStateException(this.kaAlgorithm + " not initialised.");
        }
        if (!lastPhase) {
            throw new IllegalStateException(this.kaAlgorithm + " can only be between two parties.");
        }
        if (!(key instanceof PublicKey)) {
            throw new InvalidKeyException(this.kaAlgorithm + " key agreement requires " + getSimpleName(ECPublicKey.class) + " for doPhase");
        }
        CipherParameters pubKey = ECUtils.generatePublicKeyParameter((PublicKey) key);
        try {
            this.result = bigIntToBytes(((BasicAgreement) this.agreement).calculateAgreement(pubKey));
            return null;
        } catch (Exception e2) {
            throw new InvalidKeyException("calculation failed: " + e2.getMessage()) { // from class: com.android.internal.org.bouncycastle.jcajce.provider.asymmetric.ec.KeyAgreementSpi.1
                @Override // java.lang.Throwable
                public Throwable getCause() {
                    return e2;
                }
            };
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // javax.crypto.KeyAgreementSpi
    public void engineInit(Key key, AlgorithmParameterSpec params, SecureRandom random) throws InvalidKeyException, InvalidAlgorithmParameterException {
        if (params != null && !(params instanceof UserKeyingMaterialSpec)) {
            throw new InvalidAlgorithmParameterException("No algorithm parameters supported");
        }
        initFromKey(key, params);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // javax.crypto.KeyAgreementSpi
    public void engineInit(Key key, SecureRandom random) throws InvalidKeyException {
        try {
            initFromKey(key, null);
        } catch (InvalidAlgorithmParameterException e2) {
            throw new InvalidKeyException(e2.getMessage());
        }
    }

    private void initFromKey(Key key, AlgorithmParameterSpec parameterSpec) throws InvalidKeyException, InvalidAlgorithmParameterException {
        if (!(key instanceof PrivateKey)) {
            throw new InvalidKeyException(this.kaAlgorithm + " key agreement requires " + getSimpleName(ECPrivateKey.class) + " for initialisation");
        }
        if (this.kdf == null && (parameterSpec instanceof UserKeyingMaterialSpec)) {
            throw new InvalidAlgorithmParameterException("no KDF specified for UserKeyingMaterialSpec");
        }
        ECPrivateKeyParameters privKey = (ECPrivateKeyParameters) ECUtil.generatePrivateKeyParameter((PrivateKey) key);
        this.parameters = privKey.getParameters();
        this.ukmParameters = parameterSpec instanceof UserKeyingMaterialSpec ? ((UserKeyingMaterialSpec) parameterSpec).getUserKeyingMaterial() : null;
        ((BasicAgreement) this.agreement).init(privKey);
    }

    private static String getSimpleName(Class clazz) {
        String fullName = clazz.getName();
        return fullName.substring(fullName.lastIndexOf(46) + 1);
    }

    @Override // com.android.internal.org.bouncycastle.jcajce.provider.asymmetric.util.BaseAgreementSpi
    protected byte[] calcSecret() {
        return Arrays.clone(this.result);
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static class DH extends KeyAgreementSpi {
        public DH() {
            super("ECDH", new ECDHBasicAgreement(), null);
        }
    }
}

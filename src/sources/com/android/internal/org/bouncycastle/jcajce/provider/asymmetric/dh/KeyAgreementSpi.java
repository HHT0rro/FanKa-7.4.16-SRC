package com.android.internal.org.bouncycastle.jcajce.provider.asymmetric.dh;

import com.android.internal.org.bouncycastle.crypto.BasicAgreement;
import com.android.internal.org.bouncycastle.crypto.DerivationFunction;
import com.android.internal.org.bouncycastle.crypto.params.DHParameters;
import com.android.internal.org.bouncycastle.crypto.params.DHPrivateKeyParameters;
import com.android.internal.org.bouncycastle.crypto.params.DHPublicKeyParameters;
import com.android.internal.org.bouncycastle.jcajce.provider.asymmetric.util.BaseAgreementSpi;
import com.android.internal.org.bouncycastle.jcajce.spec.DHDomainParameterSpec;
import com.android.internal.org.bouncycastle.jcajce.spec.UserKeyingMaterialSpec;
import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.SecretKey;
import javax.crypto.ShortBufferException;
import javax.crypto.interfaces.DHPrivateKey;
import javax.crypto.interfaces.DHPublicKey;
import javax.crypto.spec.DHParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class KeyAgreementSpi extends BaseAgreementSpi {
    private static final BigInteger ONE = BigInteger.valueOf(1);
    private static final BigInteger TWO = BigInteger.valueOf(2);

    /* renamed from: g, reason: collision with root package name */
    private BigInteger f9237g;
    private final BasicAgreement mqvAgreement;

    /* renamed from: p, reason: collision with root package name */
    private BigInteger f9238p;
    private byte[] result;

    /* renamed from: x, reason: collision with root package name */
    private BigInteger f9239x;

    public KeyAgreementSpi() {
        this("Diffie-Hellman", null);
    }

    public KeyAgreementSpi(String kaAlgorithm, DerivationFunction kdf) {
        super(kaAlgorithm, kdf);
        this.mqvAgreement = null;
    }

    public KeyAgreementSpi(String kaAlgorithm, BasicAgreement mqvAgreement, DerivationFunction kdf) {
        super(kaAlgorithm, kdf);
        this.mqvAgreement = mqvAgreement;
    }

    protected byte[] bigIntToBytes(BigInteger r10) {
        int expectedLength = (this.f9238p.bitLength() + 7) / 8;
        byte[] tmp = r10.toByteArray();
        if (tmp.length == expectedLength) {
            return tmp;
        }
        if (tmp[0] == 0 && tmp.length == expectedLength + 1) {
            byte[] rv = new byte[tmp.length - 1];
            System.arraycopy((Object) tmp, 1, (Object) rv, 0, rv.length);
            return rv;
        }
        byte[] rv2 = new byte[expectedLength];
        System.arraycopy((Object) tmp, 0, (Object) rv2, rv2.length - tmp.length, tmp.length);
        return rv2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // javax.crypto.KeyAgreementSpi
    public Key engineDoPhase(Key key, boolean lastPhase) throws InvalidKeyException, IllegalStateException {
        if (this.f9239x == null) {
            throw new IllegalStateException("Diffie-Hellman not initialised.");
        }
        if (!(key instanceof DHPublicKey)) {
            throw new InvalidKeyException("DHKeyAgreement doPhase requires DHPublicKey");
        }
        DHPublicKey pubKey = (DHPublicKey) key;
        if (!pubKey.getParams().getG().equals(this.f9237g) || !pubKey.getParams().getP().equals(this.f9238p)) {
            throw new InvalidKeyException("DHPublicKey not for this KeyAgreement!");
        }
        BigInteger peerY = ((DHPublicKey) key).getY();
        if (peerY != null && peerY.compareTo(TWO) >= 0) {
            BigInteger bigInteger = this.f9238p;
            BigInteger bigInteger2 = ONE;
            if (peerY.compareTo(bigInteger.subtract(bigInteger2)) < 0) {
                BigInteger res = peerY.modPow(this.f9239x, this.f9238p);
                if (res.compareTo(bigInteger2) == 0) {
                    throw new InvalidKeyException("Shared key can't be 1");
                }
                this.result = bigIntToBytes(res);
                if (lastPhase) {
                    return null;
                }
                return new BCDHPublicKey(res, pubKey.getParams());
            }
        }
        throw new InvalidKeyException("Invalid DH PublicKey");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.android.internal.org.bouncycastle.jcajce.provider.asymmetric.util.BaseAgreementSpi, javax.crypto.KeyAgreementSpi
    public byte[] engineGenerateSecret() throws IllegalStateException {
        if (this.f9239x == null) {
            throw new IllegalStateException("Diffie-Hellman not initialised.");
        }
        return super.engineGenerateSecret();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.android.internal.org.bouncycastle.jcajce.provider.asymmetric.util.BaseAgreementSpi, javax.crypto.KeyAgreementSpi
    public int engineGenerateSecret(byte[] sharedSecret, int offset) throws IllegalStateException, ShortBufferException {
        if (this.f9239x == null) {
            throw new IllegalStateException("Diffie-Hellman not initialised.");
        }
        return super.engineGenerateSecret(sharedSecret, offset);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.android.internal.org.bouncycastle.jcajce.provider.asymmetric.util.BaseAgreementSpi, javax.crypto.KeyAgreementSpi
    public SecretKey engineGenerateSecret(String algorithm) throws NoSuchAlgorithmException {
        if (this.f9239x == null) {
            throw new IllegalStateException("Diffie-Hellman not initialised.");
        }
        if (algorithm.equals("TlsPremasterSecret")) {
            return new SecretKeySpec(trimZeroes(this.result), algorithm);
        }
        return super.engineGenerateSecret(algorithm);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // javax.crypto.KeyAgreementSpi
    public void engineInit(Key key, AlgorithmParameterSpec params, SecureRandom random) throws InvalidKeyException, InvalidAlgorithmParameterException {
        if (!(key instanceof DHPrivateKey)) {
            throw new InvalidKeyException("DHKeyAgreement requires DHPrivateKey for initialisation");
        }
        DHPrivateKey privKey = (DHPrivateKey) key;
        if (params != null) {
            if (params instanceof DHParameterSpec) {
                DHParameterSpec p10 = (DHParameterSpec) params;
                this.f9238p = p10.getP();
                this.f9237g = p10.getG();
                this.ukmParameters = null;
            } else if (params instanceof UserKeyingMaterialSpec) {
                if (this.kdf == null) {
                    throw new InvalidAlgorithmParameterException("no KDF specified for UserKeyingMaterialSpec");
                }
                this.f9238p = privKey.getParams().getP();
                this.f9237g = privKey.getParams().getG();
                this.ukmParameters = ((UserKeyingMaterialSpec) params).getUserKeyingMaterial();
            } else {
                throw new InvalidAlgorithmParameterException("DHKeyAgreement only accepts DHParameterSpec");
            }
        } else {
            this.f9238p = privKey.getParams().getP();
            this.f9237g = privKey.getParams().getG();
        }
        BigInteger x10 = privKey.getX();
        this.f9239x = x10;
        this.result = bigIntToBytes(x10);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // javax.crypto.KeyAgreementSpi
    public void engineInit(Key key, SecureRandom random) throws InvalidKeyException {
        if (!(key instanceof DHPrivateKey)) {
            throw new InvalidKeyException("DHKeyAgreement requires DHPrivateKey");
        }
        DHPrivateKey privKey = (DHPrivateKey) key;
        this.f9238p = privKey.getParams().getP();
        this.f9237g = privKey.getParams().getG();
        BigInteger x10 = privKey.getX();
        this.f9239x = x10;
        this.result = bigIntToBytes(x10);
    }

    @Override // com.android.internal.org.bouncycastle.jcajce.provider.asymmetric.util.BaseAgreementSpi
    protected byte[] calcSecret() {
        return this.result;
    }

    private DHPrivateKeyParameters generatePrivateKeyParameter(PrivateKey privKey) throws InvalidKeyException {
        if (privKey instanceof DHPrivateKey) {
            if (privKey instanceof BCDHPrivateKey) {
                return ((BCDHPrivateKey) privKey).engineGetKeyParameters();
            }
            DHPrivateKey pub = (DHPrivateKey) privKey;
            DHParameterSpec params = pub.getParams();
            return new DHPrivateKeyParameters(pub.getX(), new DHParameters(params.getP(), params.getG(), null, params.getL()));
        }
        throw new InvalidKeyException("private key not a DHPrivateKey");
    }

    private DHPublicKeyParameters generatePublicKeyParameter(PublicKey pubKey) throws InvalidKeyException {
        if (pubKey instanceof DHPublicKey) {
            if (pubKey instanceof BCDHPublicKey) {
                return ((BCDHPublicKey) pubKey).engineGetKeyParameters();
            }
            DHPublicKey pub = (DHPublicKey) pubKey;
            DHParameterSpec params = pub.getParams();
            if (params instanceof DHDomainParameterSpec) {
                return new DHPublicKeyParameters(pub.getY(), ((DHDomainParameterSpec) params).getDomainParameters());
            }
            return new DHPublicKeyParameters(pub.getY(), new DHParameters(params.getP(), params.getG(), null, params.getL()));
        }
        throw new InvalidKeyException("public key not a DHPublicKey");
    }
}

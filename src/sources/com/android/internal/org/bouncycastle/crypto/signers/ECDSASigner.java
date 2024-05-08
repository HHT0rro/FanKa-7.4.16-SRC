package com.android.internal.org.bouncycastle.crypto.signers;

import com.android.internal.org.bouncycastle.crypto.CipherParameters;
import com.android.internal.org.bouncycastle.crypto.CryptoServicesRegistrar;
import com.android.internal.org.bouncycastle.crypto.DSAExt;
import com.android.internal.org.bouncycastle.crypto.params.ECDomainParameters;
import com.android.internal.org.bouncycastle.crypto.params.ECKeyParameters;
import com.android.internal.org.bouncycastle.crypto.params.ECPrivateKeyParameters;
import com.android.internal.org.bouncycastle.crypto.params.ECPublicKeyParameters;
import com.android.internal.org.bouncycastle.crypto.params.ParametersWithRandom;
import com.android.internal.org.bouncycastle.math.ec.ECAlgorithms;
import com.android.internal.org.bouncycastle.math.ec.ECConstants;
import com.android.internal.org.bouncycastle.math.ec.ECCurve;
import com.android.internal.org.bouncycastle.math.ec.ECFieldElement;
import com.android.internal.org.bouncycastle.math.ec.ECMultiplier;
import com.android.internal.org.bouncycastle.math.ec.ECPoint;
import com.android.internal.org.bouncycastle.math.ec.FixedPointCombMultiplier;
import com.android.internal.org.bouncycastle.util.BigIntegers;
import java.math.BigInteger;
import java.security.SecureRandom;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class ECDSASigner implements ECConstants, DSAExt {
    private final DSAKCalculator kCalculator;
    private ECKeyParameters key;
    private SecureRandom random;

    public ECDSASigner() {
        this.kCalculator = new RandomDSAKCalculator();
    }

    public ECDSASigner(DSAKCalculator kCalculator) {
        this.kCalculator = kCalculator;
    }

    @Override // com.android.internal.org.bouncycastle.crypto.DSA
    public void init(boolean forSigning, CipherParameters param) {
        SecureRandom providedRandom = null;
        if (forSigning) {
            if (param instanceof ParametersWithRandom) {
                ParametersWithRandom rParam = (ParametersWithRandom) param;
                this.key = (ECPrivateKeyParameters) rParam.getParameters();
                providedRandom = rParam.getRandom();
            } else {
                this.key = (ECPrivateKeyParameters) param;
            }
        } else {
            this.key = (ECPublicKeyParameters) param;
        }
        this.random = initSecureRandom(forSigning && !this.kCalculator.isDeterministic(), providedRandom);
    }

    @Override // com.android.internal.org.bouncycastle.crypto.DSAExt
    public BigInteger getOrder() {
        return this.key.getParameters().getN();
    }

    @Override // com.android.internal.org.bouncycastle.crypto.DSA
    public BigInteger[] generateSignature(byte[] message) {
        ECDomainParameters ec2 = this.key.getParameters();
        BigInteger n10 = ec2.getN();
        BigInteger e2 = calculateE(n10, message);
        BigInteger d10 = ((ECPrivateKeyParameters) this.key).getD();
        if (this.kCalculator.isDeterministic()) {
            this.kCalculator.init(n10, d10, message);
        } else {
            this.kCalculator.init(n10, this.random);
        }
        ECMultiplier basePointMultiplier = createBasePointMultiplier();
        while (true) {
            BigInteger k10 = this.kCalculator.nextK();
            ECPoint p10 = basePointMultiplier.multiply(ec2.getG(), k10).normalize();
            BigInteger r10 = p10.getAffineXCoord().toBigInteger().mod(n10);
            if (!r10.equals(ZERO)) {
                BigInteger k11 = BigIntegers.modOddInverse(n10, k10).multiply(e2.add(d10.multiply(r10))).mod(n10);
                if (!k11.equals(ZERO)) {
                    return new BigInteger[]{r10, k11};
                }
            }
        }
    }

    @Override // com.android.internal.org.bouncycastle.crypto.DSA
    public boolean verifySignature(byte[] message, BigInteger r10, BigInteger s2) {
        BigInteger cofactor;
        ECFieldElement D;
        BigInteger r11 = r10;
        ECDomainParameters ec2 = this.key.getParameters();
        BigInteger n10 = ec2.getN();
        BigInteger e2 = calculateE(n10, message);
        if (r11.compareTo(ONE) < 0 || r11.compareTo(n10) >= 0 || s2.compareTo(ONE) < 0 || s2.compareTo(n10) >= 0) {
            return false;
        }
        BigInteger c4 = BigIntegers.modOddInverseVar(n10, s2);
        BigInteger u12 = e2.multiply(c4).mod(n10);
        BigInteger u22 = r11.multiply(c4).mod(n10);
        ECPoint G = ec2.getG();
        ECPoint Q = ((ECPublicKeyParameters) this.key).getQ();
        ECPoint point = ECAlgorithms.sumOfTwoMultiplies(G, u12, Q, u22);
        if (point.isInfinity()) {
            return false;
        }
        ECCurve curve = point.getCurve();
        if (curve != null && (cofactor = curve.getCofactor()) != null && cofactor.compareTo(EIGHT) <= 0 && (D = getDenominator(curve.getCoordinateSystem(), point)) != null && !D.isZero()) {
            ECFieldElement X = point.getXCoord();
            while (curve.isValidFieldElement(r11)) {
                ECFieldElement R = curve.fromBigInteger(r11).multiply(D);
                if (R.equals(X)) {
                    return true;
                }
                r11 = r11.add(n10);
            }
            return false;
        }
        BigInteger v2 = point.normalize().getAffineXCoord().toBigInteger().mod(n10);
        return v2.equals(r11);
    }

    protected BigInteger calculateE(BigInteger n10, byte[] message) {
        int log2n = n10.bitLength();
        int messageBitLength = message.length * 8;
        BigInteger e2 = new BigInteger(1, message);
        if (log2n < messageBitLength) {
            return e2.shiftRight(messageBitLength - log2n);
        }
        return e2;
    }

    protected ECMultiplier createBasePointMultiplier() {
        return new FixedPointCombMultiplier();
    }

    protected ECFieldElement getDenominator(int coordinateSystem, ECPoint p10) {
        switch (coordinateSystem) {
            case 1:
            case 6:
            case 7:
                return p10.getZCoord(0);
            case 2:
            case 3:
            case 4:
                return p10.getZCoord(0).square();
            case 5:
            default:
                return null;
        }
    }

    protected SecureRandom initSecureRandom(boolean needed, SecureRandom provided) {
        if (needed) {
            return CryptoServicesRegistrar.getSecureRandom(provided);
        }
        return null;
    }
}

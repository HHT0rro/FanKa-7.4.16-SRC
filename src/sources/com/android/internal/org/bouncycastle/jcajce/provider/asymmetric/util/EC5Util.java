package com.android.internal.org.bouncycastle.jcajce.provider.asymmetric.util;

import com.android.internal.org.bouncycastle.asn1.ASN1ObjectIdentifier;
import com.android.internal.org.bouncycastle.asn1.ASN1Sequence;
import com.android.internal.org.bouncycastle.asn1.x9.ECNamedCurveTable;
import com.android.internal.org.bouncycastle.asn1.x9.X962Parameters;
import com.android.internal.org.bouncycastle.asn1.x9.X9ECParameters;
import com.android.internal.org.bouncycastle.crypto.ec.CustomNamedCurves;
import com.android.internal.org.bouncycastle.crypto.params.ECDomainParameters;
import com.android.internal.org.bouncycastle.jcajce.provider.config.ProviderConfiguration;
import com.android.internal.org.bouncycastle.jce.provider.BouncyCastleProvider;
import com.android.internal.org.bouncycastle.jce.spec.ECNamedCurveParameterSpec;
import com.android.internal.org.bouncycastle.jce.spec.ECNamedCurveSpec;
import com.android.internal.org.bouncycastle.math.ec.ECAlgorithms;
import com.android.internal.org.bouncycastle.math.ec.ECCurve;
import com.android.internal.org.bouncycastle.math.field.FiniteField;
import com.android.internal.org.bouncycastle.math.field.Polynomial;
import com.android.internal.org.bouncycastle.math.field.PolynomialExtensionField;
import com.android.internal.org.bouncycastle.util.Arrays;
import java.math.BigInteger;
import java.security.spec.ECField;
import java.security.spec.ECFieldF2m;
import java.security.spec.ECFieldFp;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.security.spec.EllipticCurve;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class EC5Util {
    private static Map customCurves = new HashMap();

    static {
        Enumeration e2 = CustomNamedCurves.getNames();
        while (e2.hasMoreElements()) {
            String name = (String) e2.nextElement();
            X9ECParameters curveParams = ECNamedCurveTable.getByName(name);
            if (curveParams != null) {
                customCurves.put(curveParams.getCurve(), CustomNamedCurves.getByName(name).getCurve());
            }
        }
    }

    public static ECCurve getCurve(ProviderConfiguration configuration, X962Parameters params) {
        Set acceptableCurves = configuration.getAcceptableNamedCurves();
        if (params.isNamedCurve()) {
            ASN1ObjectIdentifier oid = ASN1ObjectIdentifier.getInstance(params.getParameters());
            if (acceptableCurves.isEmpty() || acceptableCurves.contains(oid)) {
                X9ECParameters ecP = ECUtil.getNamedCurveByOid(oid);
                if (ecP == null) {
                    ecP = (X9ECParameters) configuration.getAdditionalECParameters().get(oid);
                }
                ECCurve curve = ecP.getCurve();
                return curve;
            }
            throw new IllegalStateException("named curve not acceptable");
        }
        if (params.isImplicitlyCA()) {
            ECCurve curve2 = configuration.getEcImplicitlyCa().getCurve();
            return curve2;
        }
        ASN1Sequence pSeq = ASN1Sequence.getInstance(params.getParameters());
        if (acceptableCurves.isEmpty()) {
            if (pSeq.size() > 3) {
                ECCurve curve3 = X9ECParameters.getInstance(pSeq).getCurve();
                return curve3;
            }
            throw new IllegalStateException("GOST is not supported");
        }
        throw new IllegalStateException("encoded parameters not acceptable");
    }

    public static ECDomainParameters getDomainParameters(ProviderConfiguration configuration, ECParameterSpec params) {
        if (params == null) {
            com.android.internal.org.bouncycastle.jce.spec.ECParameterSpec iSpec = configuration.getEcImplicitlyCa();
            ECDomainParameters domainParameters = new ECDomainParameters(iSpec.getCurve(), iSpec.getG(), iSpec.getN(), iSpec.getH(), iSpec.getSeed());
            return domainParameters;
        }
        ECDomainParameters domainParameters2 = ECUtil.getDomainParameters(configuration, convertSpec(params));
        return domainParameters2;
    }

    public static ECParameterSpec convertToSpec(X962Parameters params, ECCurve curve) {
        ECParameterSpec ecSpec;
        if (params.isNamedCurve()) {
            ASN1ObjectIdentifier oid = (ASN1ObjectIdentifier) params.getParameters();
            X9ECParameters ecP = ECUtil.getNamedCurveByOid(oid);
            if (ecP == null) {
                Map additionalECParameters = BouncyCastleProvider.CONFIGURATION.getAdditionalECParameters();
                if (!additionalECParameters.isEmpty()) {
                    ecP = (X9ECParameters) additionalECParameters.get(oid);
                }
            }
            ECParameterSpec ecSpec2 = new ECNamedCurveSpec(ECUtil.getCurveName(oid), convertCurve(curve, ecP.getSeed()), convertPoint(ecP.getG()), ecP.getN(), ecP.getH());
            return ecSpec2;
        }
        if (params.isImplicitlyCA()) {
            return null;
        }
        ASN1Sequence pSeq = ASN1Sequence.getInstance(params.getParameters());
        if (pSeq.size() > 3) {
            X9ECParameters ecP2 = X9ECParameters.getInstance(pSeq);
            EllipticCurve ellipticCurve = convertCurve(curve, ecP2.getSeed());
            if (ecP2.getH() != null) {
                ecSpec = new ECParameterSpec(ellipticCurve, convertPoint(ecP2.getG()), ecP2.getN(), ecP2.getH().intValue());
            } else {
                ecSpec = new ECParameterSpec(ellipticCurve, convertPoint(ecP2.getG()), ecP2.getN(), 1);
            }
            return ecSpec;
        }
        return null;
    }

    public static ECParameterSpec convertToSpec(X9ECParameters domainParameters) {
        return new ECParameterSpec(convertCurve(domainParameters.getCurve(), null), convertPoint(domainParameters.getG()), domainParameters.getN(), domainParameters.getH().intValue());
    }

    public static ECParameterSpec convertToSpec(ECDomainParameters domainParameters) {
        return new ECParameterSpec(convertCurve(domainParameters.getCurve(), null), convertPoint(domainParameters.getG()), domainParameters.getN(), domainParameters.getH().intValue());
    }

    public static EllipticCurve convertCurve(ECCurve curve, byte[] seed) {
        ECField field = convertField(curve.getField());
        BigInteger a10 = curve.getA().toBigInteger();
        BigInteger b4 = curve.getB().toBigInteger();
        return new EllipticCurve(field, a10, b4, null);
    }

    public static ECCurve convertCurve(EllipticCurve ec2) {
        ECField field = ec2.getField();
        BigInteger a10 = ec2.getA();
        BigInteger b4 = ec2.getB();
        if (field instanceof ECFieldFp) {
            ECCurve.Fp curve = new ECCurve.Fp(((ECFieldFp) field).getP(), a10, b4);
            if (customCurves.containsKey(curve)) {
                return (ECCurve) customCurves.get(curve);
            }
            return curve;
        }
        ECFieldF2m fieldF2m = (ECFieldF2m) field;
        int m10 = fieldF2m.getM();
        int[] ks = ECUtil.convertMidTerms(fieldF2m.getMidTermsOfReductionPolynomial());
        return new ECCurve.F2m(m10, ks[0], ks[1], ks[2], a10, b4);
    }

    public static ECField convertField(FiniteField field) {
        if (ECAlgorithms.isFpField(field)) {
            return new ECFieldFp(field.getCharacteristic());
        }
        Polynomial poly = ((PolynomialExtensionField) field).getMinimalPolynomial();
        int[] exponents = poly.getExponentsPresent();
        int[] ks = Arrays.reverse(Arrays.copyOfRange(exponents, 1, exponents.length - 1));
        return new ECFieldF2m(poly.getDegree(), ks);
    }

    public static ECParameterSpec convertSpec(EllipticCurve ellipticCurve, com.android.internal.org.bouncycastle.jce.spec.ECParameterSpec spec) {
        ECPoint g3 = convertPoint(spec.getG());
        if (spec instanceof ECNamedCurveParameterSpec) {
            String name = ((ECNamedCurveParameterSpec) spec).getName();
            return new ECNamedCurveSpec(name, ellipticCurve, g3, spec.getN(), spec.getH());
        }
        return new ECParameterSpec(ellipticCurve, g3, spec.getN(), spec.getH().intValue());
    }

    public static com.android.internal.org.bouncycastle.jce.spec.ECParameterSpec convertSpec(ECParameterSpec ecSpec) {
        ECCurve curve = convertCurve(ecSpec.getCurve());
        com.android.internal.org.bouncycastle.math.ec.ECPoint g3 = convertPoint(curve, ecSpec.getGenerator());
        BigInteger n10 = ecSpec.getOrder();
        BigInteger h10 = BigInteger.valueOf(ecSpec.getCofactor());
        byte[] seed = ecSpec.getCurve().getSeed();
        if (ecSpec instanceof ECNamedCurveSpec) {
            return new ECNamedCurveParameterSpec(((ECNamedCurveSpec) ecSpec).getName(), curve, g3, n10, h10, seed);
        }
        return new com.android.internal.org.bouncycastle.jce.spec.ECParameterSpec(curve, g3, n10, h10, seed);
    }

    public static com.android.internal.org.bouncycastle.math.ec.ECPoint convertPoint(ECParameterSpec ecSpec, ECPoint point) {
        return convertPoint(convertCurve(ecSpec.getCurve()), point);
    }

    public static com.android.internal.org.bouncycastle.math.ec.ECPoint convertPoint(ECCurve curve, ECPoint point) {
        return curve.createPoint(point.getAffineX(), point.getAffineY());
    }

    public static ECPoint convertPoint(com.android.internal.org.bouncycastle.math.ec.ECPoint point) {
        com.android.internal.org.bouncycastle.math.ec.ECPoint point2 = point.normalize();
        return new ECPoint(point2.getAffineXCoord().toBigInteger(), point2.getAffineYCoord().toBigInteger());
    }
}

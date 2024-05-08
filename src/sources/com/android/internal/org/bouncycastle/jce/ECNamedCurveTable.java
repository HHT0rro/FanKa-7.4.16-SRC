package com.android.internal.org.bouncycastle.jce;

import com.android.internal.org.bouncycastle.asn1.ASN1ObjectIdentifier;
import com.android.internal.org.bouncycastle.asn1.x9.X9ECParameters;
import com.android.internal.org.bouncycastle.crypto.ec.CustomNamedCurves;
import com.android.internal.org.bouncycastle.jce.spec.ECNamedCurveParameterSpec;
import java.util.Enumeration;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class ECNamedCurveTable {
    public static ECNamedCurveParameterSpec getParameterSpec(String name) {
        X9ECParameters ecP = CustomNamedCurves.getByName(name);
        if (ecP == null) {
            try {
                ecP = CustomNamedCurves.getByOID(new ASN1ObjectIdentifier(name));
            } catch (IllegalArgumentException e2) {
            }
            if (ecP == null && (ecP = com.android.internal.org.bouncycastle.asn1.x9.ECNamedCurveTable.getByName(name)) == null) {
                try {
                    ecP = com.android.internal.org.bouncycastle.asn1.x9.ECNamedCurveTable.getByOID(new ASN1ObjectIdentifier(name));
                } catch (IllegalArgumentException e10) {
                }
            }
        }
        if (ecP == null) {
            return null;
        }
        return new ECNamedCurveParameterSpec(name, ecP.getCurve(), ecP.getG(), ecP.getN(), ecP.getH(), ecP.getSeed());
    }

    public static Enumeration getNames() {
        return com.android.internal.org.bouncycastle.asn1.x9.ECNamedCurveTable.getNames();
    }
}

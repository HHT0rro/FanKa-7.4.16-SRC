package com.android.internal.org.bouncycastle.asn1.x9;

import com.android.internal.org.bouncycastle.asn1.ASN1ObjectIdentifier;
import com.android.internal.org.bouncycastle.asn1.nist.NISTNamedCurves;
import com.android.internal.org.bouncycastle.asn1.sec.SECNamedCurves;
import java.util.Enumeration;
import java.util.Vector;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class ECNamedCurveTable {
    public static X9ECParameters getByName(String name) {
        X9ECParameters ecP = X962NamedCurves.getByName(name);
        if (ecP == null) {
            ecP = SECNamedCurves.getByName(name);
        }
        if (ecP == null) {
            return NISTNamedCurves.getByName(name);
        }
        return ecP;
    }

    public static ASN1ObjectIdentifier getOID(String name) {
        ASN1ObjectIdentifier oid = X962NamedCurves.getOID(name);
        if (oid == null) {
            oid = SECNamedCurves.getOID(name);
        }
        if (oid == null) {
            return NISTNamedCurves.getOID(name);
        }
        return oid;
    }

    public static String getName(ASN1ObjectIdentifier oid) {
        String name = X962NamedCurves.getName(oid);
        if (name == null) {
            name = SECNamedCurves.getName(oid);
        }
        if (name == null) {
            return NISTNamedCurves.getName(oid);
        }
        return name;
    }

    public static X9ECParameters getByOID(ASN1ObjectIdentifier oid) {
        X9ECParameters ecP = X962NamedCurves.getByOID(oid);
        if (ecP == null) {
            return SECNamedCurves.getByOID(oid);
        }
        return ecP;
    }

    public static Enumeration getNames() {
        Vector v2 = new Vector();
        addEnumeration(v2, X962NamedCurves.getNames());
        addEnumeration(v2, SECNamedCurves.getNames());
        addEnumeration(v2, NISTNamedCurves.getNames());
        return v2.elements();
    }

    private static void addEnumeration(Vector v2, Enumeration e2) {
        while (e2.hasMoreElements()) {
            v2.addElement(e2.nextElement());
        }
    }
}

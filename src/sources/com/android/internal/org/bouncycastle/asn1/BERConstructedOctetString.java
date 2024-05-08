package com.android.internal.org.bouncycastle.asn1;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Vector;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class BERConstructedOctetString extends BEROctetString {
    private static final int MAX_LENGTH = 1000;
    private Vector octs;

    private static byte[] toBytes(Vector octs) {
        ByteArrayOutputStream bOut = new ByteArrayOutputStream();
        for (int i10 = 0; i10 != octs.size(); i10++) {
            try {
                DEROctetString o10 = (DEROctetString) octs.elementAt(i10);
                bOut.write(o10.getOctets());
            } catch (IOException e2) {
                throw new IllegalArgumentException("exception converting octets " + e2.toString());
            } catch (ClassCastException e10) {
                throw new IllegalArgumentException(octs.elementAt(i10).getClass().getName() + " found in input should only contain DEROctetString");
            }
        }
        return bOut.toByteArray();
    }

    public BERConstructedOctetString(byte[] string) {
        super(string);
    }

    public BERConstructedOctetString(Vector octs) {
        super(toBytes(octs));
        this.octs = octs;
    }

    public BERConstructedOctetString(ASN1Primitive obj) {
        super(toByteArray(obj));
    }

    private static byte[] toByteArray(ASN1Primitive obj) {
        try {
            return obj.getEncoded();
        } catch (IOException e2) {
            throw new IllegalArgumentException("Unable to encode object");
        }
    }

    public BERConstructedOctetString(ASN1Encodable obj) {
        this(obj.toASN1Primitive());
    }

    @Override // com.android.internal.org.bouncycastle.asn1.ASN1OctetString
    public byte[] getOctets() {
        return this.string;
    }

    @Override // com.android.internal.org.bouncycastle.asn1.BEROctetString
    public Enumeration getObjects() {
        Vector vector = this.octs;
        if (vector == null) {
            return generateOcts().elements();
        }
        return vector.elements();
    }

    private Vector generateOcts() {
        int end;
        Vector vec = new Vector();
        for (int i10 = 0; i10 < this.string.length; i10 += 1000) {
            if (i10 + 1000 > this.string.length) {
                end = this.string.length;
            } else {
                end = i10 + 1000;
            }
            byte[] nStr = new byte[end - i10];
            System.arraycopy((Object) this.string, i10, (Object) nStr, 0, nStr.length);
            vec.addElement(new DEROctetString(nStr));
        }
        return vec;
    }

    public static BEROctetString fromSequence(ASN1Sequence seq) {
        Vector v2 = new Vector();
        Enumeration e2 = seq.getObjects();
        while (e2.hasMoreElements()) {
            v2.addElement(e2.nextElement());
        }
        return new BERConstructedOctetString(v2);
    }
}

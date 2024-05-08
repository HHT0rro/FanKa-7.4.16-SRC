package com.android.internal.org.bouncycastle.asn1.x509;

import com.android.internal.org.bouncycastle.asn1.ASN1Object;
import com.android.internal.org.bouncycastle.asn1.ASN1ObjectIdentifier;
import com.android.internal.org.bouncycastle.asn1.ASN1Primitive;
import com.android.internal.org.bouncycastle.asn1.ASN1Sequence;
import com.android.internal.org.bouncycastle.asn1.ASN1TaggedObject;
import com.android.internal.org.bouncycastle.asn1.DERSequence;
import com.android.internal.org.bouncycastle.util.Strings;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class GeneralNames extends ASN1Object {
    private final GeneralName[] names;

    private static GeneralName[] copy(GeneralName[] names) {
        GeneralName[] result = new GeneralName[names.length];
        System.arraycopy(names, 0, result, 0, names.length);
        return result;
    }

    public static GeneralNames getInstance(Object obj) {
        if (obj instanceof GeneralNames) {
            return (GeneralNames) obj;
        }
        if (obj != null) {
            return new GeneralNames(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public static GeneralNames getInstance(ASN1TaggedObject obj, boolean explicit) {
        return new GeneralNames(ASN1Sequence.getInstance(obj, explicit));
    }

    public static GeneralNames fromExtensions(Extensions extensions, ASN1ObjectIdentifier extOID) {
        return getInstance(Extensions.getExtensionParsedValue(extensions, extOID));
    }

    public GeneralNames(GeneralName name) {
        this.names = new GeneralName[]{name};
    }

    public GeneralNames(GeneralName[] names) {
        this.names = copy(names);
    }

    private GeneralNames(ASN1Sequence seq) {
        this.names = new GeneralName[seq.size()];
        for (int i10 = 0; i10 != seq.size(); i10++) {
            this.names[i10] = GeneralName.getInstance(seq.getObjectAt(i10));
        }
    }

    public GeneralName[] getNames() {
        return copy(this.names);
    }

    @Override // com.android.internal.org.bouncycastle.asn1.ASN1Object, com.android.internal.org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return new DERSequence(this.names);
    }

    public String toString() {
        StringBuffer buf = new StringBuffer();
        String sep = Strings.lineSeparator();
        buf.append("GeneralNames:");
        buf.append(sep);
        for (int i10 = 0; i10 != this.names.length; i10++) {
            buf.append("    ");
            buf.append((Object) this.names[i10]);
            buf.append(sep);
        }
        return buf.toString();
    }
}

package com.android.internal.org.bouncycastle.asn1.x509;

import com.android.internal.org.bouncycastle.asn1.ASN1EncodableVector;
import com.android.internal.org.bouncycastle.asn1.ASN1Object;
import com.android.internal.org.bouncycastle.asn1.ASN1Primitive;
import com.android.internal.org.bouncycastle.asn1.ASN1Sequence;
import com.android.internal.org.bouncycastle.asn1.ASN1TaggedObject;
import com.android.internal.org.bouncycastle.asn1.DERSequence;
import com.android.internal.org.bouncycastle.asn1.DERTaggedObject;
import java.util.Enumeration;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class NameConstraints extends ASN1Object {
    private GeneralSubtree[] excluded;
    private GeneralSubtree[] permitted;

    public static NameConstraints getInstance(Object obj) {
        if (obj instanceof NameConstraints) {
            return (NameConstraints) obj;
        }
        if (obj != null) {
            return new NameConstraints(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    private NameConstraints(ASN1Sequence seq) {
        Enumeration e2 = seq.getObjects();
        while (e2.hasMoreElements()) {
            ASN1TaggedObject o10 = ASN1TaggedObject.getInstance(e2.nextElement());
            switch (o10.getTagNo()) {
                case 0:
                    this.permitted = createArray(ASN1Sequence.getInstance(o10, false));
                    break;
                case 1:
                    this.excluded = createArray(ASN1Sequence.getInstance(o10, false));
                    break;
                default:
                    throw new IllegalArgumentException("Unknown tag encountered: " + o10.getTagNo());
            }
        }
    }

    public NameConstraints(GeneralSubtree[] permitted, GeneralSubtree[] excluded) {
        this.permitted = cloneSubtree(permitted);
        this.excluded = cloneSubtree(excluded);
    }

    private GeneralSubtree[] createArray(ASN1Sequence subtree) {
        GeneralSubtree[] ar2 = new GeneralSubtree[subtree.size()];
        for (int i10 = 0; i10 != ar2.length; i10++) {
            ar2[i10] = GeneralSubtree.getInstance(subtree.getObjectAt(i10));
        }
        return ar2;
    }

    public GeneralSubtree[] getPermittedSubtrees() {
        return cloneSubtree(this.permitted);
    }

    public GeneralSubtree[] getExcludedSubtrees() {
        return cloneSubtree(this.excluded);
    }

    @Override // com.android.internal.org.bouncycastle.asn1.ASN1Object, com.android.internal.org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector v2 = new ASN1EncodableVector(2);
        GeneralSubtree[] generalSubtreeArr = this.permitted;
        if (generalSubtreeArr != null) {
            v2.add(new DERTaggedObject(false, 0, new DERSequence(generalSubtreeArr)));
        }
        GeneralSubtree[] generalSubtreeArr2 = this.excluded;
        if (generalSubtreeArr2 != null) {
            v2.add(new DERTaggedObject(false, 1, new DERSequence(generalSubtreeArr2)));
        }
        return new DERSequence(v2);
    }

    private static GeneralSubtree[] cloneSubtree(GeneralSubtree[] subtrees) {
        if (subtrees != null) {
            GeneralSubtree[] rv = new GeneralSubtree[subtrees.length];
            System.arraycopy(subtrees, 0, rv, 0, rv.length);
            return rv;
        }
        return null;
    }
}

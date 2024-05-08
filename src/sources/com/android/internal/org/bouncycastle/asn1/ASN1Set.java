package com.android.internal.org.bouncycastle.asn1;

import com.android.internal.org.bouncycastle.util.Arrays;
import com.android.internal.org.bouncycastle.util.Iterable;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public abstract class ASN1Set extends ASN1Primitive implements Iterable<ASN1Encodable> {
    protected final ASN1Encodable[] elements;
    protected final boolean isSorted;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.android.internal.org.bouncycastle.asn1.ASN1Primitive
    public abstract void encode(ASN1OutputStream aSN1OutputStream, boolean z10) throws IOException;

    public static ASN1Set getInstance(Object obj) {
        if (obj == null || (obj instanceof ASN1Set)) {
            return (ASN1Set) obj;
        }
        if (obj instanceof ASN1SetParser) {
            return getInstance(((ASN1SetParser) obj).toASN1Primitive());
        }
        if (obj instanceof byte[]) {
            try {
                return getInstance(ASN1Primitive.fromByteArray((byte[]) obj));
            } catch (IOException e2) {
                throw new IllegalArgumentException("failed to construct set from byte[]: " + e2.getMessage());
            }
        }
        if (obj instanceof ASN1Encodable) {
            ASN1Primitive primitive = ((ASN1Encodable) obj).toASN1Primitive();
            if (primitive instanceof ASN1Set) {
                return (ASN1Set) primitive;
            }
        }
        throw new IllegalArgumentException("unknown object in getInstance: " + obj.getClass().getName());
    }

    public static ASN1Set getInstance(ASN1TaggedObject taggedObject, boolean explicit) {
        if (explicit) {
            if (!taggedObject.isExplicit()) {
                throw new IllegalArgumentException("object implicit - explicit expected.");
            }
            return getInstance(taggedObject.getObject());
        }
        ASN1Primitive o10 = taggedObject.getObject();
        if (taggedObject.isExplicit()) {
            if (taggedObject instanceof BERTaggedObject) {
                return new BERSet(o10);
            }
            return new DLSet(o10);
        }
        if (o10 instanceof ASN1Set) {
            ASN1Set s2 = (ASN1Set) o10;
            if (taggedObject instanceof BERTaggedObject) {
                return s2;
            }
            return (ASN1Set) s2.toDLObject();
        }
        if (o10 instanceof ASN1Sequence) {
            ASN1Encodable[] elements = ((ASN1Sequence) o10).toArrayInternal();
            if (taggedObject instanceof BERTaggedObject) {
                return new BERSet(false, elements);
            }
            return new DLSet(false, elements);
        }
        throw new IllegalArgumentException("unknown object in getInstance: " + taggedObject.getClass().getName());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ASN1Set() {
        this.elements = ASN1EncodableVector.EMPTY_ELEMENTS;
        this.isSorted = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ASN1Set(ASN1Encodable element) {
        if (element == null) {
            throw new NullPointerException("'element' cannot be null");
        }
        this.elements = new ASN1Encodable[]{element};
        this.isSorted = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ASN1Set(ASN1EncodableVector elementVector, boolean doSort) {
        ASN1Encodable[] tmp;
        if (elementVector == null) {
            throw new NullPointerException("'elementVector' cannot be null");
        }
        if (doSort && elementVector.size() >= 2) {
            tmp = elementVector.copyElements();
            sort(tmp);
        } else {
            tmp = elementVector.takeElements();
        }
        this.elements = tmp;
        this.isSorted = doSort || tmp.length < 2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ASN1Set(ASN1Encodable[] elements, boolean doSort) {
        if (Arrays.isNullOrContainsNull(elements)) {
            throw new NullPointerException("'elements' cannot be null, or contain null");
        }
        ASN1Encodable[] tmp = ASN1EncodableVector.cloneElements(elements);
        if (doSort && tmp.length >= 2) {
            sort(tmp);
        }
        this.elements = tmp;
        this.isSorted = doSort || tmp.length < 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ASN1Set(boolean isSorted, ASN1Encodable[] elements) {
        this.elements = elements;
        this.isSorted = isSorted || elements.length < 2;
    }

    public Enumeration getObjects() {
        return new Enumeration() { // from class: com.android.internal.org.bouncycastle.asn1.ASN1Set.1
            private int pos = 0;

            @Override // java.util.Enumeration
            public boolean hasMoreElements() {
                return this.pos < ASN1Set.this.elements.length;
            }

            @Override // java.util.Enumeration
            public Object nextElement() {
                if (this.pos < ASN1Set.this.elements.length) {
                    ASN1Encodable[] aSN1EncodableArr = ASN1Set.this.elements;
                    int i10 = this.pos;
                    this.pos = i10 + 1;
                    return aSN1EncodableArr[i10];
                }
                throw new NoSuchElementException();
            }
        };
    }

    public ASN1Encodable getObjectAt(int index) {
        return this.elements[index];
    }

    public int size() {
        return this.elements.length;
    }

    public ASN1Encodable[] toArray() {
        return ASN1EncodableVector.cloneElements(this.elements);
    }

    public ASN1SetParser parser() {
        final int count = size();
        return new ASN1SetParser() { // from class: com.android.internal.org.bouncycastle.asn1.ASN1Set.2
            private int pos = 0;

            @Override // com.android.internal.org.bouncycastle.asn1.ASN1SetParser
            public ASN1Encodable readObject() throws IOException {
                if (count == this.pos) {
                    return null;
                }
                ASN1Encodable[] aSN1EncodableArr = ASN1Set.this.elements;
                int i10 = this.pos;
                this.pos = i10 + 1;
                ASN1Encodable obj = aSN1EncodableArr[i10];
                if (obj instanceof ASN1Sequence) {
                    return ((ASN1Sequence) obj).parser();
                }
                if (obj instanceof ASN1Set) {
                    return ((ASN1Set) obj).parser();
                }
                return obj;
            }

            @Override // com.android.internal.org.bouncycastle.asn1.InMemoryRepresentable
            public ASN1Primitive getLoadedObject() {
                return ASN1Set.this;
            }

            @Override // com.android.internal.org.bouncycastle.asn1.ASN1Encodable
            public ASN1Primitive toASN1Primitive() {
                return ASN1Set.this;
            }
        };
    }

    @Override // com.android.internal.org.bouncycastle.asn1.ASN1Primitive, com.android.internal.org.bouncycastle.asn1.ASN1Object
    public int hashCode() {
        int i10 = this.elements.length;
        int hc2 = i10 + 1;
        while (true) {
            i10--;
            if (i10 >= 0) {
                hc2 += this.elements[i10].toASN1Primitive().hashCode();
            } else {
                return hc2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.android.internal.org.bouncycastle.asn1.ASN1Primitive
    public ASN1Primitive toDERObject() {
        ASN1Encodable[] tmp;
        if (this.isSorted) {
            tmp = this.elements;
        } else {
            tmp = (ASN1Encodable[]) this.elements.clone();
            sort(tmp);
        }
        return new DERSet(true, tmp);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.android.internal.org.bouncycastle.asn1.ASN1Primitive
    public ASN1Primitive toDLObject() {
        return new DLSet(this.isSorted, this.elements);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.android.internal.org.bouncycastle.asn1.ASN1Primitive
    public boolean asn1Equals(ASN1Primitive other) {
        if (!(other instanceof ASN1Set)) {
            return false;
        }
        ASN1Set that = (ASN1Set) other;
        int count = size();
        if (that.size() != count) {
            return false;
        }
        DERSet dis = (DERSet) toDERObject();
        DERSet dat = (DERSet) that.toDERObject();
        for (int i10 = 0; i10 < count; i10++) {
            ASN1Primitive p12 = dis.elements[i10].toASN1Primitive();
            ASN1Primitive p22 = dat.elements[i10].toASN1Primitive();
            if (p12 != p22 && !p12.asn1Equals(p22)) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.android.internal.org.bouncycastle.asn1.ASN1Primitive
    public boolean isConstructed() {
        return true;
    }

    public String toString() {
        int count = size();
        if (count == 0) {
            return "[]";
        }
        StringBuffer sb2 = new StringBuffer();
        sb2.append('[');
        int i10 = 0;
        while (true) {
            sb2.append((Object) this.elements[i10]);
            i10++;
            if (i10 < count) {
                sb2.append(", ");
            } else {
                sb2.append(']');
                return sb2.toString();
            }
        }
    }

    @Override // com.android.internal.org.bouncycastle.util.Iterable, java.lang.Iterable
    /* renamed from: iterator */
    public Iterator<ASN1Encodable> iterator2() {
        return new Arrays.Iterator(toArray());
    }

    private static byte[] getDEREncoded(ASN1Encodable obj) {
        try {
            return obj.toASN1Primitive().getEncoded(ASN1Encoding.DER);
        } catch (IOException e2) {
            throw new IllegalArgumentException("cannot encode object added to SET");
        }
    }

    private static boolean lessThanOrEqual(byte[] a10, byte[] b4) {
        int a02 = a10[0] & (-33);
        int b02 = b4[0] & (-33);
        if (a02 == b02) {
            int last = Math.min(a10.length, b4.length) - 1;
            for (int i10 = 1; i10 < last; i10++) {
                if (a10[i10] != b4[i10]) {
                    if ((a10[i10] & 255) >= (b4[i10] & 255)) {
                        return false;
                    }
                    return true;
                }
            }
            int i11 = a10[last];
            if ((i11 & 255) > (b4[last] & 255)) {
                return false;
            }
            return true;
        }
        if (a02 >= b02) {
            return false;
        }
        return true;
    }

    private static void sort(ASN1Encodable[] t2) {
        int count = t2.length;
        if (count < 2) {
            return;
        }
        ASN1Encodable eh = t2[0];
        ASN1Encodable ei = t2[1];
        byte[] bh = getDEREncoded(eh);
        byte[] bi = getDEREncoded(ei);
        if (lessThanOrEqual(bi, bh)) {
            ei = eh;
            eh = ei;
            bi = bh;
            bh = bi;
        }
        for (int i10 = 2; i10 < count; i10++) {
            ASN1Encodable e2 = t2[i10];
            byte[] b22 = getDEREncoded(e2);
            if (lessThanOrEqual(bi, b22)) {
                t2[i10 - 2] = eh;
                eh = ei;
                bh = bi;
                ei = e2;
                bi = b22;
            } else if (lessThanOrEqual(bh, b22)) {
                t2[i10 - 2] = eh;
                eh = e2;
                bh = b22;
            } else {
                int j10 = i10 - 1;
                while (true) {
                    j10--;
                    if (j10 <= 0) {
                        break;
                    }
                    ASN1Encodable e12 = t2[j10 - 1];
                    byte[] b12 = getDEREncoded(e12);
                    if (lessThanOrEqual(b12, b22)) {
                        break;
                    } else {
                        t2[j10] = e12;
                    }
                }
                t2[j10] = e2;
            }
        }
        int i11 = count - 2;
        t2[i11] = eh;
        t2[count - 1] = ei;
    }
}

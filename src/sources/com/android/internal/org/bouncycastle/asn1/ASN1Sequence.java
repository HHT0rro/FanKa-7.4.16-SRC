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
public abstract class ASN1Sequence extends ASN1Primitive implements Iterable<ASN1Encodable> {
    ASN1Encodable[] elements;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.android.internal.org.bouncycastle.asn1.ASN1Primitive
    public abstract void encode(ASN1OutputStream aSN1OutputStream, boolean z10) throws IOException;

    public static ASN1Sequence getInstance(Object obj) {
        if (obj == null || (obj instanceof ASN1Sequence)) {
            return (ASN1Sequence) obj;
        }
        if (obj instanceof ASN1SequenceParser) {
            return getInstance(((ASN1SequenceParser) obj).toASN1Primitive());
        }
        if (obj instanceof byte[]) {
            try {
                return getInstance(fromByteArray((byte[]) obj));
            } catch (IOException e2) {
                throw new IllegalArgumentException("failed to construct sequence from byte[]: " + e2.getMessage());
            }
        }
        if (obj instanceof ASN1Encodable) {
            ASN1Primitive primitive = ((ASN1Encodable) obj).toASN1Primitive();
            if (primitive instanceof ASN1Sequence) {
                return (ASN1Sequence) primitive;
            }
        }
        throw new IllegalArgumentException("unknown object in getInstance: " + obj.getClass().getName());
    }

    public static ASN1Sequence getInstance(ASN1TaggedObject taggedObject, boolean explicit) {
        if (explicit) {
            if (!taggedObject.isExplicit()) {
                throw new IllegalArgumentException("object implicit - explicit expected.");
            }
            return getInstance(taggedObject.getObject());
        }
        ASN1Primitive o10 = taggedObject.getObject();
        if (taggedObject.isExplicit()) {
            if (taggedObject instanceof BERTaggedObject) {
                return new BERSequence(o10);
            }
            return new DLSequence(o10);
        }
        if (o10 instanceof ASN1Sequence) {
            ASN1Sequence s2 = (ASN1Sequence) o10;
            if (taggedObject instanceof BERTaggedObject) {
                return s2;
            }
            return (ASN1Sequence) s2.toDLObject();
        }
        throw new IllegalArgumentException("unknown object in getInstance: " + taggedObject.getClass().getName());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ASN1Sequence() {
        this.elements = ASN1EncodableVector.EMPTY_ELEMENTS;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ASN1Sequence(ASN1Encodable element) {
        if (element == null) {
            throw new NullPointerException("'element' cannot be null");
        }
        this.elements = new ASN1Encodable[]{element};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ASN1Sequence(ASN1EncodableVector elementVector) {
        if (elementVector == null) {
            throw new NullPointerException("'elementVector' cannot be null");
        }
        this.elements = elementVector.takeElements();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ASN1Sequence(ASN1Encodable[] elements) {
        if (Arrays.isNullOrContainsNull(elements)) {
            throw new NullPointerException("'elements' cannot be null, or contain null");
        }
        this.elements = ASN1EncodableVector.cloneElements(elements);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ASN1Sequence(ASN1Encodable[] elements, boolean clone) {
        this.elements = clone ? ASN1EncodableVector.cloneElements(elements) : elements;
    }

    public ASN1Encodable[] toArray() {
        return ASN1EncodableVector.cloneElements(this.elements);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ASN1Encodable[] toArrayInternal() {
        return this.elements;
    }

    public Enumeration getObjects() {
        return new Enumeration() { // from class: com.android.internal.org.bouncycastle.asn1.ASN1Sequence.1
            private int pos = 0;

            @Override // java.util.Enumeration
            public boolean hasMoreElements() {
                return this.pos < ASN1Sequence.this.elements.length;
            }

            @Override // java.util.Enumeration
            public Object nextElement() {
                if (this.pos < ASN1Sequence.this.elements.length) {
                    ASN1Encodable[] aSN1EncodableArr = ASN1Sequence.this.elements;
                    int i10 = this.pos;
                    this.pos = i10 + 1;
                    return aSN1EncodableArr[i10];
                }
                throw new NoSuchElementException();
            }
        };
    }

    public ASN1SequenceParser parser() {
        final int count = size();
        return new ASN1SequenceParser() { // from class: com.android.internal.org.bouncycastle.asn1.ASN1Sequence.2
            private int pos = 0;

            @Override // com.android.internal.org.bouncycastle.asn1.ASN1SequenceParser
            public ASN1Encodable readObject() throws IOException {
                if (count == this.pos) {
                    return null;
                }
                ASN1Encodable[] aSN1EncodableArr = ASN1Sequence.this.elements;
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
                return ASN1Sequence.this;
            }

            @Override // com.android.internal.org.bouncycastle.asn1.ASN1Encodable
            public ASN1Primitive toASN1Primitive() {
                return ASN1Sequence.this;
            }
        };
    }

    public ASN1Encodable getObjectAt(int index) {
        return this.elements[index];
    }

    public int size() {
        return this.elements.length;
    }

    @Override // com.android.internal.org.bouncycastle.asn1.ASN1Primitive, com.android.internal.org.bouncycastle.asn1.ASN1Object
    public int hashCode() {
        int i10 = this.elements.length;
        int hc2 = i10 + 1;
        while (true) {
            i10--;
            if (i10 >= 0) {
                hc2 = (hc2 * 257) ^ this.elements[i10].toASN1Primitive().hashCode();
            } else {
                return hc2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.android.internal.org.bouncycastle.asn1.ASN1Primitive
    public boolean asn1Equals(ASN1Primitive other) {
        if (!(other instanceof ASN1Sequence)) {
            return false;
        }
        ASN1Sequence that = (ASN1Sequence) other;
        int count = size();
        if (that.size() != count) {
            return false;
        }
        for (int i10 = 0; i10 < count; i10++) {
            ASN1Primitive p12 = this.elements[i10].toASN1Primitive();
            ASN1Primitive p22 = that.elements[i10].toASN1Primitive();
            if (p12 != p22 && !p12.asn1Equals(p22)) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.android.internal.org.bouncycastle.asn1.ASN1Primitive
    public ASN1Primitive toDERObject() {
        return new DERSequence(this.elements, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.android.internal.org.bouncycastle.asn1.ASN1Primitive
    public ASN1Primitive toDLObject() {
        return new DLSequence(this.elements, false);
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
        return new Arrays.Iterator(this.elements);
    }
}

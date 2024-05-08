package com.android.internal.org.bouncycastle.asn1;

import java.io.IOException;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public abstract class ASN1Null extends ASN1Primitive {
    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.android.internal.org.bouncycastle.asn1.ASN1Primitive
    public abstract void encode(ASN1OutputStream aSN1OutputStream, boolean z10) throws IOException;

    public static ASN1Null getInstance(Object o10) {
        if (o10 instanceof ASN1Null) {
            return (ASN1Null) o10;
        }
        if (o10 != null) {
            try {
                return getInstance(ASN1Primitive.fromByteArray((byte[]) o10));
            } catch (IOException e2) {
                throw new IllegalArgumentException("failed to construct NULL from byte[]: " + e2.getMessage());
            } catch (ClassCastException e10) {
                throw new IllegalArgumentException("unknown object in getInstance(): " + o10.getClass().getName());
            }
        }
        return null;
    }

    @Override // com.android.internal.org.bouncycastle.asn1.ASN1Primitive, com.android.internal.org.bouncycastle.asn1.ASN1Object
    public int hashCode() {
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.android.internal.org.bouncycastle.asn1.ASN1Primitive
    public boolean asn1Equals(ASN1Primitive o10) {
        if (!(o10 instanceof ASN1Null)) {
            return false;
        }
        return true;
    }

    public String toString() {
        return "NULL";
    }
}

package com.android.internal.org.bouncycastle.asn1;

import com.android.internal.org.bouncycastle.util.Arrays;
import com.android.internal.org.bouncycastle.util.Properties;
import java.io.IOException;
import java.math.BigInteger;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class ASN1Integer extends ASN1Primitive {
    static final int SIGN_EXT_SIGNED = -1;
    static final int SIGN_EXT_UNSIGNED = 255;
    private final byte[] bytes;
    private final int start;

    public static ASN1Integer getInstance(Object obj) {
        if (obj == null || (obj instanceof ASN1Integer)) {
            return (ASN1Integer) obj;
        }
        if (obj instanceof byte[]) {
            try {
                return (ASN1Integer) fromByteArray((byte[]) obj);
            } catch (Exception e2) {
                throw new IllegalArgumentException("encoding error in getInstance: " + e2.toString());
            }
        }
        throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
    }

    public static ASN1Integer getInstance(ASN1TaggedObject obj, boolean explicit) {
        ASN1Primitive o10 = obj.getObject();
        if (explicit || (o10 instanceof ASN1Integer)) {
            return getInstance(o10);
        }
        return new ASN1Integer(ASN1OctetString.getInstance(o10).getOctets());
    }

    public ASN1Integer(long value) {
        this.bytes = BigInteger.valueOf(value).toByteArray();
        this.start = 0;
    }

    public ASN1Integer(BigInteger value) {
        this.bytes = value.toByteArray();
        this.start = 0;
    }

    public ASN1Integer(byte[] bytes) {
        this(bytes, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ASN1Integer(byte[] bytes, boolean clone) {
        if (isMalformed(bytes)) {
            throw new IllegalArgumentException("malformed integer");
        }
        this.bytes = clone ? Arrays.clone(bytes) : bytes;
        this.start = signBytesToSkip(bytes);
    }

    public BigInteger getPositiveValue() {
        return new BigInteger(1, this.bytes);
    }

    public BigInteger getValue() {
        return new BigInteger(this.bytes);
    }

    public boolean hasValue(BigInteger x10) {
        return x10 != null && intValue(this.bytes, this.start, -1) == x10.intValue() && getValue().equals(x10);
    }

    public int intPositiveValueExact() {
        byte[] bArr = this.bytes;
        int length = bArr.length;
        int i10 = this.start;
        int count = length - i10;
        if (count > 4 || (count == 4 && (bArr[i10] & 128) != 0)) {
            throw new ArithmeticException("ASN.1 Integer out of positive int range");
        }
        return intValue(bArr, i10, 255);
    }

    public int intValueExact() {
        byte[] bArr = this.bytes;
        int length = bArr.length;
        int i10 = this.start;
        int count = length - i10;
        if (count > 4) {
            throw new ArithmeticException("ASN.1 Integer out of int range");
        }
        return intValue(bArr, i10, -1);
    }

    public long longValueExact() {
        byte[] bArr = this.bytes;
        int length = bArr.length;
        int i10 = this.start;
        int count = length - i10;
        if (count > 8) {
            throw new ArithmeticException("ASN.1 Integer out of long range");
        }
        return longValue(bArr, i10, -1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.android.internal.org.bouncycastle.asn1.ASN1Primitive
    public boolean isConstructed() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.android.internal.org.bouncycastle.asn1.ASN1Primitive
    public int encodedLength() {
        return StreamUtil.calculateBodyLength(this.bytes.length) + 1 + this.bytes.length;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.android.internal.org.bouncycastle.asn1.ASN1Primitive
    public void encode(ASN1OutputStream out, boolean withTag) throws IOException {
        out.writeEncoded(withTag, 2, this.bytes);
    }

    @Override // com.android.internal.org.bouncycastle.asn1.ASN1Primitive, com.android.internal.org.bouncycastle.asn1.ASN1Object
    public int hashCode() {
        return Arrays.hashCode(this.bytes);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.android.internal.org.bouncycastle.asn1.ASN1Primitive
    public boolean asn1Equals(ASN1Primitive o10) {
        if (!(o10 instanceof ASN1Integer)) {
            return false;
        }
        ASN1Integer other = (ASN1Integer) o10;
        return Arrays.areEqual(this.bytes, other.bytes);
    }

    public String toString() {
        return getValue().toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int intValue(byte[] bytes, int start, int signExt) {
        int length = bytes.length;
        int pos = Math.max(start, length - 4);
        int val = bytes[pos] & signExt;
        while (true) {
            pos++;
            if (pos < length) {
                val = (val << 8) | (bytes[pos] & 255);
            } else {
                return val;
            }
        }
    }

    static long longValue(byte[] bytes, int start, int signExt) {
        int length = bytes.length;
        int pos = Math.max(start, length - 8);
        long val = bytes[pos] & signExt;
        while (true) {
            pos++;
            if (pos < length) {
                val = (val << 8) | (bytes[pos] & 255);
            } else {
                return val;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isMalformed(byte[] bytes) {
        switch (bytes.length) {
            case 0:
                return true;
            case 1:
                return false;
            default:
                return bytes[0] == (bytes[1] >> 7) && !Properties.isOverrideSet("com.android.internal.org.bouncycastle.asn1.allow_unsafe_integer");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int signBytesToSkip(byte[] bytes) {
        int pos = 0;
        int last = bytes.length - 1;
        while (pos < last && bytes[pos] == (bytes[pos + 1] >> 7)) {
            pos++;
        }
        return pos;
    }
}

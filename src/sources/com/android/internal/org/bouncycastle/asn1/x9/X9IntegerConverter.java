package com.android.internal.org.bouncycastle.asn1.x9;

import com.android.internal.org.bouncycastle.math.ec.ECCurve;
import com.android.internal.org.bouncycastle.math.ec.ECFieldElement;
import java.math.BigInteger;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class X9IntegerConverter {
    public int getByteLength(ECCurve c4) {
        return (c4.getFieldSize() + 7) / 8;
    }

    public int getByteLength(ECFieldElement fe2) {
        return (fe2.getFieldSize() + 7) / 8;
    }

    public byte[] integerToBytes(BigInteger s2, int qLength) {
        byte[] bytes = s2.toByteArray();
        if (qLength < bytes.length) {
            byte[] tmp = new byte[qLength];
            System.arraycopy((Object) bytes, bytes.length - tmp.length, (Object) tmp, 0, tmp.length);
            return tmp;
        }
        if (qLength > bytes.length) {
            byte[] tmp2 = new byte[qLength];
            System.arraycopy((Object) bytes, 0, (Object) tmp2, tmp2.length - bytes.length, bytes.length);
            return tmp2;
        }
        return bytes;
    }
}

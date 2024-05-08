package com.android.internal.org.bouncycastle.asn1;

import com.android.internal.org.bouncycastle.util.Strings;
import java.io.IOException;
import java.util.Date;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class DERGeneralizedTime extends ASN1GeneralizedTime {
    public DERGeneralizedTime(byte[] time) {
        super(time);
    }

    public DERGeneralizedTime(Date time) {
        super(time);
    }

    public DERGeneralizedTime(String time) {
        super(time);
    }

    private byte[] getDERTime() {
        if (this.time[this.time.length - 1] == 90) {
            if (!hasMinutes()) {
                byte[] derTime = new byte[this.time.length + 4];
                System.arraycopy((Object) this.time, 0, (Object) derTime, 0, this.time.length - 1);
                System.arraycopy((Object) Strings.toByteArray("0000Z"), 0, (Object) derTime, this.time.length - 1, 5);
                return derTime;
            }
            if (!hasSeconds()) {
                byte[] derTime2 = new byte[this.time.length + 2];
                System.arraycopy((Object) this.time, 0, (Object) derTime2, 0, this.time.length - 1);
                System.arraycopy((Object) Strings.toByteArray("00Z"), 0, (Object) derTime2, this.time.length - 1, 3);
                return derTime2;
            }
            if (hasFractionalSeconds()) {
                int ind = this.time.length - 2;
                while (ind > 0 && this.time[ind] == 48) {
                    ind--;
                }
                if (this.time[ind] == 46) {
                    byte[] derTime3 = new byte[ind + 1];
                    System.arraycopy((Object) this.time, 0, (Object) derTime3, 0, ind);
                    derTime3[ind] = 90;
                    return derTime3;
                }
                byte[] derTime4 = new byte[ind + 2];
                System.arraycopy((Object) this.time, 0, (Object) derTime4, 0, ind + 1);
                derTime4[ind + 1] = 90;
                return derTime4;
            }
            return this.time;
        }
        return this.time;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.android.internal.org.bouncycastle.asn1.ASN1GeneralizedTime, com.android.internal.org.bouncycastle.asn1.ASN1Primitive
    public int encodedLength() {
        int length = getDERTime().length;
        return StreamUtil.calculateBodyLength(length) + 1 + length;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.android.internal.org.bouncycastle.asn1.ASN1GeneralizedTime, com.android.internal.org.bouncycastle.asn1.ASN1Primitive
    public void encode(ASN1OutputStream out, boolean withTag) throws IOException {
        out.writeEncoded(withTag, 24, getDERTime());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.android.internal.org.bouncycastle.asn1.ASN1GeneralizedTime, com.android.internal.org.bouncycastle.asn1.ASN1Primitive
    public ASN1Primitive toDERObject() {
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.android.internal.org.bouncycastle.asn1.ASN1GeneralizedTime, com.android.internal.org.bouncycastle.asn1.ASN1Primitive
    public ASN1Primitive toDLObject() {
        return this;
    }
}

package com.android.internal.org.bouncycastle.asn1.pkcs;

import com.android.internal.org.bouncycastle.asn1.ASN1Object;
import com.android.internal.org.bouncycastle.asn1.ASN1Primitive;
import com.android.internal.org.bouncycastle.asn1.ASN1Sequence;
import com.android.internal.org.bouncycastle.asn1.BERSequence;
import com.android.internal.org.bouncycastle.asn1.DLSequence;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class AuthenticatedSafe extends ASN1Object {
    private ContentInfo[] info;
    private boolean isBer;

    private AuthenticatedSafe(ASN1Sequence seq) {
        this.isBer = true;
        this.info = new ContentInfo[seq.size()];
        int i10 = 0;
        while (true) {
            ContentInfo[] contentInfoArr = this.info;
            if (i10 != contentInfoArr.length) {
                contentInfoArr[i10] = ContentInfo.getInstance(seq.getObjectAt(i10));
                i10++;
            } else {
                this.isBer = seq instanceof BERSequence;
                return;
            }
        }
    }

    public static AuthenticatedSafe getInstance(Object o10) {
        if (o10 instanceof AuthenticatedSafe) {
            return (AuthenticatedSafe) o10;
        }
        if (o10 != null) {
            return new AuthenticatedSafe(ASN1Sequence.getInstance(o10));
        }
        return null;
    }

    public AuthenticatedSafe(ContentInfo[] info) {
        this.isBer = true;
        this.info = copy(info);
    }

    public ContentInfo[] getContentInfo() {
        return copy(this.info);
    }

    private ContentInfo[] copy(ContentInfo[] infos) {
        ContentInfo[] tmp = new ContentInfo[infos.length];
        System.arraycopy(infos, 0, tmp, 0, tmp.length);
        return tmp;
    }

    @Override // com.android.internal.org.bouncycastle.asn1.ASN1Object, com.android.internal.org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        if (this.isBer) {
            return new BERSequence(this.info);
        }
        return new DLSequence(this.info);
    }
}

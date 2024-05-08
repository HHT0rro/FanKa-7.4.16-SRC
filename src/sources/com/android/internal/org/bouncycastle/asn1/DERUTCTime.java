package com.android.internal.org.bouncycastle.asn1;

import java.util.Date;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class DERUTCTime extends ASN1UTCTime {
    DERUTCTime(byte[] bytes) {
        super(bytes);
    }

    public DERUTCTime(Date time) {
        super(time);
    }

    public DERUTCTime(String time) {
        super(time);
    }
}

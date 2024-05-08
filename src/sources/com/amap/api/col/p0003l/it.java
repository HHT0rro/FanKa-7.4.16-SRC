package com.amap.api.col.p0003l;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/* compiled from: StatisticsPubDataStrategy.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class it extends iu {
    public it() {
    }

    @Override // com.amap.api.col.p0003l.iu
    public final byte[] a(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(new SimpleDateFormat("yyyyMMdd HHmmss").format(new Date()));
        stringBuffer.append(" ");
        stringBuffer.append(UUID.randomUUID().toString());
        stringBuffer.append(" ");
        if (stringBuffer.length() != 53) {
            return new byte[0];
        }
        byte[] a10 = fv.a(stringBuffer.toString());
        byte[] bArr2 = new byte[a10.length + bArr.length];
        System.arraycopy((Object) a10, 0, (Object) bArr2, 0, a10.length);
        System.arraycopy((Object) bArr, 0, (Object) bArr2, a10.length, bArr.length);
        return bArr2;
    }

    public it(iu iuVar) {
        super(iuVar);
    }
}

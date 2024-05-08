package com.amap.api.col.s;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/* compiled from: RSAAESEncryptProcessor.java */
/* renamed from: com.amap.api.col.s.do, reason: invalid class name */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class Cdo extends dm {
    public Cdo() {
    }

    @Override // com.amap.api.col.s.dm
    public final byte[] a(byte[] bArr) throws CertificateException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException {
        return cb.a(bArr);
    }

    public Cdo(dm dmVar) {
        super(dmVar);
    }
}

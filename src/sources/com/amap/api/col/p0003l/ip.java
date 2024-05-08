package com.amap.api.col.p0003l;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/* compiled from: EncryptRsaDataStrategy.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class ip extends iu {

    /* renamed from: a, reason: collision with root package name */
    private hp f6492a;

    public ip() {
        this.f6492a = new hr();
    }

    @Override // com.amap.api.col.p0003l.iu
    public final byte[] a(byte[] bArr) throws CertificateException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException {
        return this.f6492a.b(bArr);
    }

    public ip(iu iuVar) {
        super(iuVar);
        this.f6492a = new hr();
    }
}

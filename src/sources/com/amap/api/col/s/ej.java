package com.amap.api.col.s;

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
public final class ej extends eo {

    /* renamed from: a, reason: collision with root package name */
    private dm f7911a;

    public ej() {
        this.f7911a = new Cdo();
    }

    @Override // com.amap.api.col.s.eo
    public final byte[] a(byte[] bArr) throws CertificateException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException {
        return this.f7911a.b(bArr);
    }

    public ej(eo eoVar) {
        super(eoVar);
        this.f7911a = new Cdo();
    }
}

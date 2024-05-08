package com.amap.api.col.s;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/* compiled from: UpdateDataStrategy.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public abstract class eo {

    /* renamed from: c, reason: collision with root package name */
    public eo f7921c;

    /* renamed from: d, reason: collision with root package name */
    public byte[] f7922d = null;

    public eo() {
    }

    public final byte[] a() throws CertificateException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException {
        byte[] a10 = a(this.f7922d);
        eo eoVar = this.f7921c;
        if (eoVar == null) {
            return a10;
        }
        eoVar.f7922d = a10;
        return eoVar.a();
    }

    public abstract byte[] a(byte[] bArr) throws CertificateException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException;

    public void b(byte[] bArr) {
    }

    public eo(eo eoVar) {
        this.f7921c = eoVar;
    }
}

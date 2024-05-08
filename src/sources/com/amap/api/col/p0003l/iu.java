package com.amap.api.col.p0003l;

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
public abstract class iu {

    /* renamed from: c, reason: collision with root package name */
    public iu f6502c;

    /* renamed from: d, reason: collision with root package name */
    public byte[] f6503d = null;

    public iu() {
    }

    public final byte[] a() throws CertificateException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException {
        byte[] a10 = a(this.f6503d);
        iu iuVar = this.f6502c;
        if (iuVar == null) {
            return a10;
        }
        iuVar.f6503d = a10;
        return iuVar.a();
    }

    public abstract byte[] a(byte[] bArr) throws CertificateException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException;

    public void b(byte[] bArr) {
    }

    public iu(iu iuVar) {
        this.f6502c = iuVar;
    }
}

package com.amap.api.col.p0003l;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/* compiled from: EncryptProcessor.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public abstract class hp {

    /* renamed from: a, reason: collision with root package name */
    public hp f6259a;

    public hp() {
    }

    public abstract byte[] a(byte[] bArr) throws CertificateException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException;

    public final byte[] b(byte[] bArr) throws CertificateException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException {
        hp hpVar = this.f6259a;
        if (hpVar != null) {
            bArr = hpVar.b(bArr);
        }
        return a(bArr);
    }

    public hp(hp hpVar) {
        this.f6259a = hpVar;
    }
}

package com.amap.api.col.s;

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
public abstract class dm {

    /* renamed from: a, reason: collision with root package name */
    public dm f7691a;

    public dm() {
    }

    public abstract byte[] a(byte[] bArr) throws CertificateException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException;

    public final byte[] b(byte[] bArr) throws CertificateException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException {
        dm dmVar = this.f7691a;
        if (dmVar != null) {
            bArr = dmVar.b(bArr);
        }
        return a(bArr);
    }

    public dm(dm dmVar) {
        this.f7691a = dmVar;
    }
}

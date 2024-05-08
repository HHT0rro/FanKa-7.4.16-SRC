package com.amap.api.col.p0003l;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/* compiled from: RSAAESEncryptProcessor.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class hr extends hp {
    public hr() {
    }

    @Override // com.amap.api.col.p0003l.hp
    public final byte[] a(byte[] bArr) throws CertificateException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException {
        return fn.a(bArr);
    }

    public hr(hp hpVar) {
        super(hpVar);
    }
}

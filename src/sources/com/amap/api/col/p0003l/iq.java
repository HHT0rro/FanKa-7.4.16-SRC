package com.amap.api.col.p0003l;

import android.content.Context;
import android.text.TextUtils;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/* compiled from: HeaderAddStrategy.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class iq extends iu {

    /* renamed from: a, reason: collision with root package name */
    private Context f6493a;

    /* renamed from: b, reason: collision with root package name */
    private String f6494b;

    /* renamed from: e, reason: collision with root package name */
    private hp f6495e;

    /* renamed from: f, reason: collision with root package name */
    private Object[] f6496f;

    public iq(Context context, iu iuVar, hp hpVar, String str, Object... objArr) {
        super(iuVar);
        this.f6493a = context;
        this.f6494b = str;
        this.f6495e = hpVar;
        this.f6496f = objArr;
    }

    private String b() {
        try {
            return String.format(fv.c(this.f6494b), this.f6496f);
        } catch (Throwable th) {
            th.printStackTrace();
            gy.b(th, "ofm", "gpj");
            return "";
        }
    }

    @Override // com.amap.api.col.p0003l.iu
    public final byte[] a(byte[] bArr) throws CertificateException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException {
        String a10 = fv.a(bArr);
        if (TextUtils.isEmpty(a10)) {
            return null;
        }
        return fv.a("{\"pinfo\":\"" + fv.a(this.f6495e.b(fv.a(b()))) + "\",\"els\":[" + a10 + "]}");
    }
}

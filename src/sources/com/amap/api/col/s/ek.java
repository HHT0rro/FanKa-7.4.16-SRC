package com.amap.api.col.s;

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
public final class ek extends eo {

    /* renamed from: a, reason: collision with root package name */
    private Context f7912a;

    /* renamed from: b, reason: collision with root package name */
    private String f7913b;

    /* renamed from: e, reason: collision with root package name */
    private dm f7914e;

    /* renamed from: f, reason: collision with root package name */
    private Object[] f7915f;

    public ek(Context context, eo eoVar, dm dmVar, String str, Object... objArr) {
        super(eoVar);
        this.f7912a = context;
        this.f7913b = str;
        this.f7914e = dmVar;
        this.f7915f = objArr;
    }

    private String b() {
        try {
            return String.format(ci.c(this.f7913b), this.f7915f);
        } catch (Throwable th) {
            th.printStackTrace();
            df.c(th, "ofm", "gpj");
            return "";
        }
    }

    @Override // com.amap.api.col.s.eo
    public final byte[] a(byte[] bArr) throws CertificateException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException {
        String a10 = ci.a(bArr);
        if (TextUtils.isEmpty(a10)) {
            return null;
        }
        return ci.a("{\"pinfo\":\"" + ci.a(this.f7914e.b(ci.a(b()))) + "\",\"els\":[" + a10 + "]}");
    }
}
